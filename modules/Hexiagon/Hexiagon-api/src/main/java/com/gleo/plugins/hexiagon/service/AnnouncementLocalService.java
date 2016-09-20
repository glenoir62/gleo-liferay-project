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

package com.gleo.plugins.hexiagon.service;

import aQute.bnd.annotation.ProviderType;

import com.gleo.plugins.hexiagon.model.Announcement;

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for Announcement. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author guillaumelenoir
 * @see AnnouncementLocalServiceUtil
 * @see com.gleo.plugins.hexiagon.service.base.AnnouncementLocalServiceBaseImpl
 * @see com.gleo.plugins.hexiagon.service.impl.AnnouncementLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface AnnouncementLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnnouncementLocalServiceUtil} to access the announcement local service. Add custom service methods to {@link com.gleo.plugins.hexiagon.service.impl.AnnouncementLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the announcement to the database. Also notifies the appropriate model listeners.
	*
	* @param announcement the announcement
	* @return the announcement that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Announcement addAnnouncement(Announcement announcement);

	/**
	* Adds the Announcement to the database incrementing the primary key
	*
	* @throws PortalException
	*/
	public Announcement addAnnouncement(Announcement announcement,
		ServiceContext serviceContext) throws PortalException, SystemException;

	/**
	* Creates a new announcement with the primary key. Does not add the announcement to the database.
	*
	* @param announcementId the primary key for the new announcement
	* @return the new announcement
	*/
	public Announcement createAnnouncement(long announcementId);

	/**
	* Deletes the announcement from the database. Also notifies the appropriate model listeners.
	*
	* @param announcement the announcement
	* @return the announcement that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public Announcement deleteAnnouncement(Announcement announcement);

	/**
	* Deletes the announcement with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param announcementId the primary key of the announcement
	* @return the announcement that was removed
	* @throws PortalException if a announcement with the primary key could not be found
	* @throws SystemException
	*/
	@Indexable(type = IndexableType.DELETE)
	public Announcement deleteAnnouncement(long announcementId)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Announcement fetchAnnouncement(long announcementId);

	/**
	* Returns the announcement matching the UUID and group.
	*
	* @param uuid the announcement's UUID
	* @param groupId the primary key of the group
	* @return the matching announcement, or <code>null</code> if a matching announcement could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Announcement fetchAnnouncementByUuidAndGroupId(
		java.lang.String uuid, long groupId);

	/**
	* Returns the announcement with the primary key.
	*
	* @param announcementId the primary key of the announcement
	* @return the announcement
	* @throws PortalException if a announcement with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Announcement getAnnouncement(long announcementId)
		throws PortalException;

	/**
	* Returns the announcement matching the UUID and group.
	*
	* @param uuid the announcement's UUID
	* @param groupId the primary key of the group
	* @return the matching announcement
	* @throws PortalException if a matching announcement could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Announcement getAnnouncementByUuidAndGroupId(java.lang.String uuid,
		long groupId) throws PortalException;

	/**
	* Updates the announcement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param announcement the announcement
	* @return the announcement that was updated
	* @throws SystemException
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Announcement updateAnnouncement(Announcement announcement)
		throws SystemException;

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
	public Announcement updateAnnouncement(Announcement announcement,
		ServiceContext serviceContext) throws PortalException, SystemException;

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
	public Announcement updateStatus(long userId, long resourcePrimKey,
		int status, ServiceContext serviceContext)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Returns the number of announcements.
	*
	* @return the number of announcements
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnnouncementsCount();

	/**
	* Gets the number of Announcements by currency Id
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnnouncementsCountByCurrencyId(long currencyId)
		throws SystemException;

	/**
	* Gets the number of Announcements in a group
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnnouncementsCountByGroupId(long groupId)
		throws SystemException;

	/**
	* Gets the number of Announcements by type Id
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnnouncementsCountByTypeId(long typeId)
		throws SystemException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gleo.plugins.hexiagon.model.impl.AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gleo.plugins.hexiagon.model.impl.AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns a range of all the announcements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gleo.plugins.hexiagon.model.impl.AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of announcements
	* @param end the upper bound of the range of announcements (not inclusive)
	* @return the range of announcements
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Announcement> getAnnouncements(int start, int end);

	/**
	* Gets a list with all the Announcements by currency Id
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Announcement> getAnnouncementsByCurrencyId(long currencyId)
		throws SystemException;

	/**
	* Gets a list with all the Announcements in a group
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Announcement> getAnnouncementsByGroupId(long groupId)
		throws SystemException;

	/**
	* Gets a list with a range of Announcements from a group
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Announcement> getAnnouncementsByGroupId(long groupId,
		int start, int end) throws SystemException;

	/**
	* Gets a list with all the Announcements by type Id
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Announcement> getAnnouncementsByTypeId(long typeId)
		throws SystemException;

	/**
	* Returns all the announcements matching the UUID and company.
	*
	* @param uuid the UUID of the announcements
	* @param companyId the primary key of the company
	* @return the matching announcements, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Announcement> getAnnouncementsByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

	/**
	* Returns a range of announcements matching the UUID and company.
	*
	* @param uuid the UUID of the announcements
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of announcements
	* @param end the upper bound of the range of announcements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching announcements, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Announcement> getAnnouncementsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<Announcement> orderByComparator);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Announcement> getFavoritesAnnouncementsByGroupIUserId(
		long groupId, long userId, int start, int end)
		throws SystemException;

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	/**
	* Delete Announcements
	*
	* @param announcements
	*/
	public void deleteAnnouncements(List<Announcement> announcements);

	public void updateAsset(long userId, Announcement announcement,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds) throws PortalException, SystemException;
}