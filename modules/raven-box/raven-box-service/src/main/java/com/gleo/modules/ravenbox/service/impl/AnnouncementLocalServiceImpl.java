/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.gleo.modules.ravenbox.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.gleo.modules.ravenbox.constants.AnnouncementConstants;
import com.gleo.modules.ravenbox.model.Announcement;
import com.gleo.modules.ravenbox.model.AnnouncementImage;
import com.gleo.modules.ravenbox.model.Favorite;
import com.gleo.modules.ravenbox.service.base.AnnouncementLocalServiceBaseImpl;
import com.gleo.modules.ravenbox.service.persistence.AnnouncementUtil;
import com.gleo.modules.ravenbox.socials.AnnouncementActivityKeys;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.Repository;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the announcement local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.gleo.modules.ravenbox.service.AnnouncementLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see AnnouncementLocalServiceBaseImpl
 * @see com.gleo.modules.ravenbox.service.AnnouncementLocalServiceUtil
 */
@ProviderType
public class AnnouncementLocalServiceImpl extends AnnouncementLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Always use {@link
     * com.gleo.modules.ravenbox.service.AnnouncementLocalServiceUtil} to access
     * the announcement local service.
     */

    /*
     * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
     * {@link com.glenoir.plugins.hexagon.service.AnnouncementLocalServiceUtil}
     * to access the announcement local service.
     */

    /**
     * AnnouncementLocalServiceImpl Logger.
     */
    private static Log LOGGER = LogFactoryUtil.getLog(AnnouncementLocalServiceImpl.class);

    /**
     * Adds the Announcement to the database incrementing the primary key
     * 
     * @throws PortalException
     */
    public Announcement addAnnouncement(Announcement announcement, ServiceContext serviceContext)
	    throws SystemException, PortalException {

		long announcementId = CounterLocalServiceUtil.increment(Announcement.class.getName());
		boolean addGroupPermissions = true;
		boolean addGuestPermissions = false;
		String[] groupPermissions = PortalUtil.getGroupPermissions(serviceContext.getRequest());
		String[] guestPermissions = PortalUtil.getGuestPermissions(serviceContext.getRequest());
	
		serviceContext.setAddGroupPermissions(addGroupPermissions);
		serviceContext.setAddGuestPermissions(addGuestPermissions);
		serviceContext.setGroupPermissions(groupPermissions);
		serviceContext.setGuestPermissions(guestPermissions);
	
		announcement.setAnnouncementId(announcementId);
	
		List<AnnouncementImage> announcementImages = announcement.getAnnouncementImages();
		long companyId = serviceContext.getCompanyId();
		long groupId = serviceContext.getScopeGroupId();
		long userId = serviceContext.getUserId();
	
		announcement.setCompanyId(companyId);
		announcement.setGroupId(groupId);
		announcement.setAnnouncementId(announcementId);
		announcement.setUserId(userId);
	
		Date now = new Date();
	
		User user = userPersistence.findByPrimaryKey(userId);
	
		Repository repository = PortletFileRepositoryUtil.addPortletRepository(groupId,
				AnnouncementConstants.ANNOUNCEMENT_PORTLET_REPOSITORY, serviceContext);
	
		Folder userFolder = PortletFileRepositoryUtil.addPortletFolder(userId, repository.getRepositoryId(),
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, String.valueOf(userId), serviceContext);
	
		Folder annoucementFolder = PortletFileRepositoryUtil.addPortletFolder(userId, repository.getRepositoryId(),
				userFolder.getFolderId(), String.valueOf(announcement.getAnnouncementId()), serviceContext);
	
		announcement.setStatus(WorkflowConstants.STATUS_DRAFT);
		announcement.setStatusDate(serviceContext.getModifiedDate(now));
		announcement.setFolderId(annoucementFolder.getFolderId());
		announcement.setUuid(serviceContext.getUuid());
		announcement.setModifiedDate(now);
		announcement.setCreateDate(now);
		announcement.setUserName(user.getFullName());
	
		for (AnnouncementImage announcementImage : announcementImages) {
			if (Validator.isNotNull(announcementImage)) {
				announcementImage.setAnnouncementId(announcementId);
				announcementImageLocalService.addAnnouncementImage(announcementImage, annoucementFolder.getFolderId(),
						serviceContext);
			}
		}
	
		// Persistence
	
		announcementPersistence.update(announcement);
	
		// Resources
		if (serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()) {
	
		    resourceLocalService.addResources(companyId, groupId, userId, Announcement.class.getName(), announcementId,
			    false, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		} else {
		    resourceLocalService.addModelResources(companyId, groupId, userId, Announcement.class.getName(),
			    announcementId, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		}
	
		// Asset
	
		updateAsset(userId, announcement, serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(),
			serviceContext.getAssetLinkEntryIds());
	
		// Message boards
	
		mbMessageLocalService.addDiscussionMessage(userId, announcement.getUserName(), groupId,
			Announcement.class.getName(), announcement.getAnnouncementId(), WorkflowConstants.ACTION_PUBLISH);
	
		// Workflow
		WorkflowHandlerRegistryUtil.startWorkflowInstance(announcement.getCompanyId(), announcement.getGroupId(),
			userId, Announcement.class.getName(), announcement.getPrimaryKey(), announcement, serviceContext);
	
		// Social activities
		socialActivityLocalService.addActivity(userId,
		announcement.getGroupId(), Announcement.class.getName(),
		announcement.getAnnouncementId(),
		AnnouncementActivityKeys.ADD_ANNOUNCEMENT, StringPool.BLANK, 0);
	
		return announcement;
    }

	public void updateAsset(long userId, Announcement announcement, long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds) throws PortalException, SystemException {

		String layoutUrl = null;

		// Set default Layout
		try {
			Layout layout = LayoutLocalServiceUtil.getFriendlyURLLayout(announcement.getGroupId(), false,
					"/announcement-view");
			layoutUrl = layout.getUuid();
		} catch (Exception e) {

		}

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId, announcement.getGroupId(),
				announcement.getCreateDate(), announcement.getModifiedDate(), Announcement.class.getName(),
				announcement.getAnnouncementId(), announcement.getUuid(), 0, assetCategoryIds, assetTagNames, true,
				null, null, null, ContentTypes.TEXT_HTML, announcement.getTitle(),
				StringUtil.shorten(announcement.getContent(), 50), null, null, layoutUrl, 0, 0, null, false);

		// Social activities
		// socialActivityLocalService.addActivity(userId,
		// announcement.getGroupId(), Announcement.class.getName(),
		// announcement.getAnnouncementId(),
		// AnnouncementActivityKeys.UPDATE_ANNOUNCEMENT, StringPool.BLANK, 0);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(), assetLinkEntryIds,
				AssetLinkConstants.TYPE_RELATED);
    }

    /**
     * Delete announcement
     * 
     * @param announcementId
     * @return
     * @throws SystemException
     * @throws PortalException
     */
    @Indexable(type = IndexableType.DELETE)
    public Announcement deleteAnnouncement(long announcementId) throws SystemException, PortalException {

	Announcement announcement = announcementPersistence.findByPrimaryKey(announcementId);

	List<AnnouncementImage> announcementImages = announcementImageLocalService
		.getAnnouncementImageByAnnouncementId(announcement.getAnnouncementId());

	for (AnnouncementImage announcementImage : announcementImages) {
	    try {
		announcementImageLocalService.deleteAnnouncementImage(announcementImage);
	    } catch (PortalException pe) {
		if (LOGGER.isDebugEnabled()) {
		    LOGGER.debug(pe);
		}
		LOGGER.error("PortalExecption : impossible to delete announcement image with file entry "
			+ announcementImage.getAnnouncementId());
	    } catch (SystemException se) {
		if (LOGGER.isDebugEnabled()) {
		    LOGGER.debug(se);
		}
		LOGGER.error("PortalExecption : impossible to delete announcement image with file entry "
			+ announcementImage.getAnnouncementId());
	    }

	}

	PortletFileRepositoryUtil.deleteFolder(announcement.getFolderId());

	// Asset
	assetEntryLocalService.deleteEntry(Announcement.class.getName(), announcementId);

	// Message boards
	mbMessageLocalService.deleteDiscussionMessages(Announcement.class.getName(), announcementId);

	// Resources
	resourceLocalService.deleteResource(announcement.getCompanyId(), Announcement.class.getName(),
		ResourceConstants.SCOPE_COMPANY, announcement.getPrimaryKey());

	// Social activities
	socialActivityLocalService.deleteActivities(Announcement.class.getName(), announcementId);

	// Favorite
	favoritePersistence.removeByAnnouncementId(announcementId);

	return super.deleteAnnouncement(announcementId);
    }

    /**
     * Update announcement
     * 
     * @param announcement
     * @param serviceContext
     * @return announcement
     * @throws SystemException
     * @throws PortalException
     */
    @Indexable(type = IndexableType.REINDEX)
    public Announcement updateAnnouncement(Announcement announcement, ServiceContext serviceContext)
	    throws SystemException, PortalException {

	long annoucementFolderId = announcement.getFolderId();
	List<AnnouncementImage> announcementImages = announcement.getAnnouncementImages();

	for (AnnouncementImage announcementImage : announcementImages) {
	    if (Validator.isNotNull(announcementImage)) {

		long announcementImageId = announcementImage.getAnnouncementImageId();

		if (announcementImage.isActive()) {
		    if (Validator.isNotNull(announcementImageId)) {
			// Update Image
			announcementImage = announcementImageLocalService.updateAnnouncementImage(announcementImage,
				annoucementFolderId, serviceContext);
		    } else {
			// Add Image
			announcementImage = announcementImageLocalService.addAnnouncementImage(announcementImage,
				annoucementFolderId, serviceContext);
		    }
		} else if (!announcementImage.isNew()) {
		    // Delete image
		    announcementImage = announcementImageLocalService.deleteAnnouncementImage(announcementImage);
		}
	    }
	}
	// Set modified Date
	Date now = new Date();
	announcement.setModifiedDate(now);

	// Asset
	updateAsset(announcement.getUserId(), announcement, serviceContext.getAssetCategoryIds(),
		serviceContext.getAssetTagNames(), serviceContext.getAssetLinkEntryIds());

	// Social activities
	socialActivityLocalService.addActivity(serviceContext.getUserId(),
	announcement.getGroupId(), Announcement.class.getName(),
	announcement.getAnnouncementId(),
	AnnouncementActivityKeys.UPDATE_ANNOUNCEMENT, StringPool.BLANK, 0);
 
	return super.updateAnnouncement(announcement);
    }

    /**
     * Gets a list with all the Announcements in a group
     */
    public List<Announcement> getAnnouncementsByGroupId(long groupId) throws SystemException {

	return announcementPersistence.findByG_S(groupId, WorkflowConstants.STATUS_APPROVED);
    }

    /**
     * Gets a list with a range of Announcements from a group
     */
    public List<Announcement> getAnnouncementsByGroupId(long groupId, int start, int end) throws SystemException {

	return announcementPersistence.findByG_S(groupId, WorkflowConstants.STATUS_APPROVED, start, end);
    }

    /**
     * Gets the number of Announcements in a group
     */
    public int getAnnouncementsCountByGroupId(long groupId) throws SystemException {

	return AnnouncementUtil.countByG_S(groupId, WorkflowConstants.STATUS_APPROVED);
    }

    /**
     * Gets a list with all the Announcements by type Id
     */
    public List<Announcement> getAnnouncementsByTypeId(long typeId) throws SystemException {

	return AnnouncementUtil.findByTypeId(typeId);
    }

    /**
     * Gets the number of Announcements by type Id
     */
    public int getAnnouncementsCountByTypeId(long typeId) throws SystemException {

	return AnnouncementUtil.countByTypeId(typeId);
    }

    /**
     * Gets a list with all the Announcements by currency Id
     */
    public List<Announcement> getAnnouncementsByCurrencyId(long currencyId) throws SystemException {

	return AnnouncementUtil.findByCurrencyId(currencyId);
    }

    /**
     * Gets the number of Announcements by currency Id
     */
    public int getAnnouncementsCountByCurrencyId(long currencyId) throws SystemException {

	return AnnouncementUtil.countByCurrencyId(currencyId);
    }

    /**
     * @param announcement
     * @return
     * @throws SystemException
     */
    @Override
    public Announcement updateAnnouncement(Announcement announcement) throws SystemException {

	announcementPersistence.cacheResult(announcement);
	return super.updateAnnouncement(announcement);
    }

    /**
     * Update workflow status
     * 
     * @param userId
     * @param resourcePrimKey
     * @param status
     * @param serviceContext
     * @return
     * @throws PortalException
     * @throws SystemException
     */
    @Indexable(type = IndexableType.REINDEX)
    public Announcement updateStatus(long userId, long resourcePrimKey, int status, ServiceContext serviceContext)
	    throws PortalException, SystemException {

    Date now = new Date();
	User user = userLocalService.getUser(userId);
	Announcement announcement = getAnnouncement(resourcePrimKey);

	announcement.setStatus(status);
	announcement.setStatusByUserId(userId);
	announcement.setStatusByUserName(user.getFullName());
	announcement.setStatusDate(serviceContext.getModifiedDate(now));

	updateAnnouncement(announcement);

	if (status == WorkflowConstants.STATUS_APPROVED) {

	    assetEntryLocalService.updateVisible(Announcement.class.getName(), resourcePrimKey, true);

	} else {

	    assetEntryLocalService.updateVisible(Announcement.class.getName(), resourcePrimKey, false);
	}

	return announcement;
    }

    /**
     * Delete Announcements
     * 
     * @param announcements
     */
    public void deleteAnnouncements(List<Announcement> announcements) {
	Iterator<Announcement> iterator = announcements.iterator();

	while (iterator.hasNext()) {
	    Announcement announcement = (Announcement) iterator.next();
	    if (announcement != null) {
		try {
		    // Delete annoucement
		    LOGGER.info("Delete " + announcement);

		    announcementLocalService.deleteAnnouncement(announcement.getAnnouncementId());

		} catch (Exception e) {
		    LOGGER.info("Unable to delete announcement Id " + announcement.getAnnouncementId());
		    LOGGER.error(e);
		}
	    }

	}
    }

    /**
     * Get favorites
     * 
     * @param groupId
     * @param userId
     * @param start
     * @param end
     * @return favorites list
     * @throws SystemException
     */
    public List<Announcement> getFavoritesAnnouncementsByGroupIUserId(long groupId, long userId, int start, int end)
	    throws SystemException {

	List<Favorite> favorites = favoritePersistence.findByUserIdGroupId(userId, groupId, start, end);
	List<Announcement> announcements = null;

	if (Validator.isNotNull(favorites) && favorites.size() > 0) {
	    announcements = new ArrayList<Announcement>();

	    for (Favorite favorite : favorites) {
		try {
		    Announcement announcement = announcementLocalService.getAnnouncement(favorite.getAnnouncementId());
		    announcements.add(announcement);
		} catch (PortalException pe) {
		    if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(pe);
		    }
		    LOGGER.error("PortalException : impossible to get announcement " + favorite.getAnnouncementId());
		} catch (SystemException se) {
		    if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(se);
		    }
		    LOGGER.error("SystemException : impossible to get announcement " + favorite.getAnnouncementId());
		}
	    }
	} else {
	    announcements = Collections.emptyList();
	}
	return announcements;

    }
}