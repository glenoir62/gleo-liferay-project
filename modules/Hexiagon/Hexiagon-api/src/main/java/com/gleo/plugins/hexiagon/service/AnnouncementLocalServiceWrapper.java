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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AnnouncementLocalService}.
 *
 * @author guillaumelenoir
 * @see AnnouncementLocalService
 * @generated
 */
@ProviderType
public class AnnouncementLocalServiceWrapper implements AnnouncementLocalService,
	ServiceWrapper<AnnouncementLocalService> {
	public AnnouncementLocalServiceWrapper(
		AnnouncementLocalService announcementLocalService) {
		_announcementLocalService = announcementLocalService;
	}

	/**
	* Adds the announcement to the database. Also notifies the appropriate model listeners.
	*
	* @param announcement the announcement
	* @return the announcement that was added
	*/
	@Override
	public com.gleo.plugins.hexiagon.model.Announcement addAnnouncement(
		com.gleo.plugins.hexiagon.model.Announcement announcement) {
		return _announcementLocalService.addAnnouncement(announcement);
	}

	/**
	* Adds the Announcement to the database incrementing the primary key
	*
	* @throws PortalException
	*/
	@Override
	public com.gleo.plugins.hexiagon.model.Announcement addAnnouncement(
		com.gleo.plugins.hexiagon.model.Announcement announcement,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.addAnnouncement(announcement,
			serviceContext);
	}

	/**
	* Creates a new announcement with the primary key. Does not add the announcement to the database.
	*
	* @param announcementId the primary key for the new announcement
	* @return the new announcement
	*/
	@Override
	public com.gleo.plugins.hexiagon.model.Announcement createAnnouncement(
		long announcementId) {
		return _announcementLocalService.createAnnouncement(announcementId);
	}

	/**
	* Deletes the announcement from the database. Also notifies the appropriate model listeners.
	*
	* @param announcement the announcement
	* @return the announcement that was removed
	*/
	@Override
	public com.gleo.plugins.hexiagon.model.Announcement deleteAnnouncement(
		com.gleo.plugins.hexiagon.model.Announcement announcement) {
		return _announcementLocalService.deleteAnnouncement(announcement);
	}

	/**
	* Deletes the announcement with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param announcementId the primary key of the announcement
	* @return the announcement that was removed
	* @throws PortalException if a announcement with the primary key could not be found
	* @throws SystemException
	*/
	@Override
	public com.gleo.plugins.hexiagon.model.Announcement deleteAnnouncement(
		long announcementId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.deleteAnnouncement(announcementId);
	}

	@Override
	public com.gleo.plugins.hexiagon.model.Announcement fetchAnnouncement(
		long announcementId) {
		return _announcementLocalService.fetchAnnouncement(announcementId);
	}

	/**
	* Returns the announcement matching the UUID and group.
	*
	* @param uuid the announcement's UUID
	* @param groupId the primary key of the group
	* @return the matching announcement, or <code>null</code> if a matching announcement could not be found
	*/
	@Override
	public com.gleo.plugins.hexiagon.model.Announcement fetchAnnouncementByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _announcementLocalService.fetchAnnouncementByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the announcement with the primary key.
	*
	* @param announcementId the primary key of the announcement
	* @return the announcement
	* @throws PortalException if a announcement with the primary key could not be found
	*/
	@Override
	public com.gleo.plugins.hexiagon.model.Announcement getAnnouncement(
		long announcementId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _announcementLocalService.getAnnouncement(announcementId);
	}

	/**
	* Returns the announcement matching the UUID and group.
	*
	* @param uuid the announcement's UUID
	* @param groupId the primary key of the group
	* @return the matching announcement
	* @throws PortalException if a matching announcement could not be found
	*/
	@Override
	public com.gleo.plugins.hexiagon.model.Announcement getAnnouncementByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _announcementLocalService.getAnnouncementByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Updates the announcement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param announcement the announcement
	* @return the announcement that was updated
	* @throws SystemException
	*/
	@Override
	public com.gleo.plugins.hexiagon.model.Announcement updateAnnouncement(
		com.gleo.plugins.hexiagon.model.Announcement announcement)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.updateAnnouncement(announcement);
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
	@Override
	public com.gleo.plugins.hexiagon.model.Announcement updateAnnouncement(
		com.gleo.plugins.hexiagon.model.Announcement announcement,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.updateAnnouncement(announcement,
			serviceContext);
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
	@Override
	public com.gleo.plugins.hexiagon.model.Announcement updateStatus(
		long userId, long resourcePrimKey, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.updateStatus(userId, resourcePrimKey,
			status, serviceContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _announcementLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _announcementLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _announcementLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _announcementLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _announcementLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _announcementLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of announcements.
	*
	* @return the number of announcements
	*/
	@Override
	public int getAnnouncementsCount() {
		return _announcementLocalService.getAnnouncementsCount();
	}

	/**
	* Gets the number of Announcements by currency Id
	*/
	@Override
	public int getAnnouncementsCountByCurrencyId(long currencyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.getAnnouncementsCountByCurrencyId(currencyId);
	}

	/**
	* Gets the number of Announcements in a group
	*/
	@Override
	public int getAnnouncementsCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.getAnnouncementsCountByGroupId(groupId);
	}

	/**
	* Gets the number of Announcements by type Id
	*/
	@Override
	public int getAnnouncementsCountByTypeId(long typeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.getAnnouncementsCountByTypeId(typeId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _announcementLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _announcementLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _announcementLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _announcementLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

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
	@Override
	public java.util.List<com.gleo.plugins.hexiagon.model.Announcement> getAnnouncements(
		int start, int end) {
		return _announcementLocalService.getAnnouncements(start, end);
	}

	/**
	* Gets a list with all the Announcements by currency Id
	*/
	@Override
	public java.util.List<com.gleo.plugins.hexiagon.model.Announcement> getAnnouncementsByCurrencyId(
		long currencyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.getAnnouncementsByCurrencyId(currencyId);
	}

	/**
	* Gets a list with all the Announcements in a group
	*/
	@Override
	public java.util.List<com.gleo.plugins.hexiagon.model.Announcement> getAnnouncementsByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.getAnnouncementsByGroupId(groupId);
	}

	/**
	* Gets a list with a range of Announcements from a group
	*/
	@Override
	public java.util.List<com.gleo.plugins.hexiagon.model.Announcement> getAnnouncementsByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.getAnnouncementsByGroupId(groupId,
			start, end);
	}

	/**
	* Gets a list with all the Announcements by type Id
	*/
	@Override
	public java.util.List<com.gleo.plugins.hexiagon.model.Announcement> getAnnouncementsByTypeId(
		long typeId) throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.getAnnouncementsByTypeId(typeId);
	}

	/**
	* Returns all the announcements matching the UUID and company.
	*
	* @param uuid the UUID of the announcements
	* @param companyId the primary key of the company
	* @return the matching announcements, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.gleo.plugins.hexiagon.model.Announcement> getAnnouncementsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _announcementLocalService.getAnnouncementsByUuidAndCompanyId(uuid,
			companyId);
	}

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
	@Override
	public java.util.List<com.gleo.plugins.hexiagon.model.Announcement> getAnnouncementsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.gleo.plugins.hexiagon.model.Announcement> orderByComparator) {
		return _announcementLocalService.getAnnouncementsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
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
	@Override
	public java.util.List<com.gleo.plugins.hexiagon.model.Announcement> getFavoritesAnnouncementsByGroupIUserId(
		long groupId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementLocalService.getFavoritesAnnouncementsByGroupIUserId(groupId,
			userId, start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _announcementLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _announcementLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	/**
	* Delete Announcements
	*
	* @param announcements
	*/
	@Override
	public void deleteAnnouncements(
		java.util.List<com.gleo.plugins.hexiagon.model.Announcement> announcements) {
		_announcementLocalService.deleteAnnouncements(announcements);
	}

	@Override
	public void updateAsset(long userId,
		com.gleo.plugins.hexiagon.model.Announcement announcement,
		long[] assetCategoryIds, java.lang.String[] assetTagNames,
		long[] assetLinkEntryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_announcementLocalService.updateAsset(userId, announcement,
			assetCategoryIds, assetTagNames, assetLinkEntryIds);
	}

	@Override
	public AnnouncementLocalService getWrappedService() {
		return _announcementLocalService;
	}

	@Override
	public void setWrappedService(
		AnnouncementLocalService announcementLocalService) {
		_announcementLocalService = announcementLocalService;
	}

	private AnnouncementLocalService _announcementLocalService;
}