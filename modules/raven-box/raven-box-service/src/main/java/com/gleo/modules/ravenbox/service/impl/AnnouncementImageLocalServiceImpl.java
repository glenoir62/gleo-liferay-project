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

import com.gleo.modules.ravenbox.model.AnnouncementImage;
import com.gleo.modules.ravenbox.service.base.AnnouncementImageLocalServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.io.InputStream;
import java.util.List;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the announcement image local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.gleo.modules.ravenbox.service.AnnouncementImageLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see AnnouncementImageLocalServiceBaseImpl
 * @see com.gleo.modules.ravenbox.service.AnnouncementImageLocalServiceUtil
 */
@ProviderType
public class AnnouncementImageLocalServiceImpl extends AnnouncementImageLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link
     * com.glenoir.plugins.hexagon.service.AnnouncementImageLocalServiceUtil} to
     * access the announcement image local service.
     */

    private static Log LOGGER = LogFactoryUtil.getLog(AnnouncementImageLocalServiceImpl.class);

    public AnnouncementImage addAnnouncementImage(AnnouncementImage announcementImage, long annoucementFolderId,
	    ServiceContext serviceContext) throws SystemException, PortalException {

	InputStream imageInputStream = announcementImage.getInputStream();
	long groupId = announcementImage.getGroupId();
	long userId = announcementImage.getUserId();

	if (announcementImage.isNew() && Validator.isNotNull(imageInputStream)) {
	    announcementImage
		    .setAnnouncementImageId(CounterLocalServiceUtil.increment(AnnouncementImage.class.getName()));

	    try {

//		// Add image in the announcement repository portlet
//		FileEntry imageFileEntry = PortletFileRepositoryUtil.addPortletFileEntry(groupId, userId,
//			AnnouncementImage.class.getName(), announcementImage.getAnnouncementImageId(),
//			AnnouncementConstants.ANNOUNCEMENT_PORTLET_REPOSITORY, annoucementFolderId, imageInputStream,
//			String.valueOf(announcementImage.getAnnouncementImageId()), StringPool.BLANK, true);
//		DLProcessorRegistryUtil.trigger(imageFileEntry, null, true);
//
//		// Set new file entryId
//		announcementImage.setFileEntryId(imageFileEntry.getFileEntryId());
//
//		// Add announcement image
//		announcementImage = super.addAnnouncementImage(announcementImage);
	    } catch (SystemException e) {
		if (LOGGER.isDebugEnabled()) {
		    LOGGER.debug(e);
		}
		LOGGER.error("SystemException : impossible to add announcement image with file entry "
			+ announcementImage.getFileEntryId());
		LOGGER.error(e.getMessage());
//	    } catch (PortalException e) {
//		if (LOGGER.isDebugEnabled()) {
//		    LOGGER.debug(e);
//		}
//		LOGGER.error("PortalException : impossible to add announcement image with file entry "
//			+ announcementImage.getFileEntryId());
//		LOGGER.error(e.getMessage());
	    }
	}

	return announcementImage;
    }

    public List<AnnouncementImage> getAnnouncementImageByAnnouncementId(long announcementId) throws SystemException {

	return announcementImagePersistence.findByG_A(announcementId);
    }

    public AnnouncementImage getAnnouncementImageByAnnouncementIdOrder(long announcementId, int order)
	    throws SystemException {

	return announcementImagePersistence.fetchByA_O(announcementId, order);
    }

    public AnnouncementImage deleteAnnouncementImage(AnnouncementImage announcementImage)
	    throws SystemException, PortalException {

	long fileEntryId = announcementImage.getFileEntryId();

	if (Validator.isNotNull(fileEntryId)) {
	    try {
		PortletFileRepositoryUtil.deletePortletFileEntry(fileEntryId);
	    } catch (SystemException e) {
		if (LOGGER.isDebugEnabled()) {
		    LOGGER.debug(e);
		}
		LOGGER.error("SystemException : impossible to delete announcement image with file entry "
			+ announcementImage.getFileEntryId());
		LOGGER.error(e.getMessage());
	    } catch (PortalException e) {
		if (LOGGER.isDebugEnabled()) {
		    LOGGER.debug(e);
		}
		LOGGER.error("PortalException : impossible to delete announcement image with file entry "
			+ announcementImage.getFileEntryId());
		LOGGER.error(e.getMessage());
	    }
	}

	return super.deleteAnnouncementImage(announcementImage);
    }

    public AnnouncementImage updateAnnouncementImage(AnnouncementImage announcementImage, long annoucementFolderId,
	    ServiceContext serviceContext) throws SystemException, PortalException {

	InputStream imageInputStream = announcementImage.getInputStream();
	long groupId = announcementImage.getGroupId();
	long userId = announcementImage.getUserId();
	long announcementImageId = announcementImage.getAnnouncementImageId();
	long fileEntryId = announcementImage.getFileEntryId();

	if (Validator.isNotNull(imageInputStream)) {
//	    try {
//		// Delete old file Entry
//		PortletFileRepositoryUtil.deletePortletFileEntry(fileEntryId);
//
//		// Add image in the announcement repository portlet
//		FileEntry imageFileEntry = PortletFileRepositoryUtil.addPortletFileEntry(groupId, userId,
//			AnnouncementImage.class.getName(), announcementImageId,
//			AnnouncementConstants.ANNOUNCEMENT_PORTLET_REPOSITORY, annoucementFolderId, imageInputStream,
//			String.valueOf(announcementImageId), StringPool.BLANK, true);
//		DLProcessorRegistryUtil.trigger(imageFileEntry, null, true);
//
//		// Set new file entryId
//		announcementImage.setFileEntryId(imageFileEntry.getFileEntryId());
//	    } catch (SystemException e) {
//		if (LOGGER.isDebugEnabled()) {
//		    LOGGER.debug(e);
//		}
//		LOGGER.error("SystemException : impossible to update announcement image with file entry "
//			+ announcementImage.getFileEntryId());
//		LOGGER.error(e.getMessage());
//	    } catch (PortalException e) {
//		if (LOGGER.isDebugEnabled()) {
//		    LOGGER.debug(e);
//		}
//		LOGGER.error("PortalException : impossible to update announcement image with file entry "
//			+ announcementImage.getFileEntryId());
//		LOGGER.error(e.getMessage());
//	    }
	}

	// Update announcement image

	return super.updateAnnouncementImage(announcementImage);
    }
}