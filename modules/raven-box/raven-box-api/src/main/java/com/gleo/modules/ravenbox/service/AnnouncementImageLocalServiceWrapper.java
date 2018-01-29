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

package com.gleo.modules.ravenbox.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AnnouncementImageLocalService}.
 *
 * @author Guillaume Lenoir
 * @see AnnouncementImageLocalService
 * @generated
 */
@ProviderType
public class AnnouncementImageLocalServiceWrapper
	implements AnnouncementImageLocalService,
		ServiceWrapper<AnnouncementImageLocalService> {
	public AnnouncementImageLocalServiceWrapper(
		AnnouncementImageLocalService announcementImageLocalService) {
		_announcementImageLocalService = announcementImageLocalService;
	}

	/**
	* Adds the announcement image to the database. Also notifies the appropriate model listeners.
	*
	* @param announcementImage the announcement image
	* @return the announcement image that was added
	*/
	@Override
	public com.gleo.modules.ravenbox.model.AnnouncementImage addAnnouncementImage(
		com.gleo.modules.ravenbox.model.AnnouncementImage announcementImage) {
		return _announcementImageLocalService.addAnnouncementImage(announcementImage);
	}

	/**
	* Creates a new announcement image with the primary key. Does not add the announcement image to the database.
	*
	* @param announcementImageId the primary key for the new announcement image
	* @return the new announcement image
	*/
	@Override
	public com.gleo.modules.ravenbox.model.AnnouncementImage createAnnouncementImage(
		long announcementImageId) {
		return _announcementImageLocalService.createAnnouncementImage(announcementImageId);
	}

	/**
	* Deletes the announcement image from the database. Also notifies the appropriate model listeners.
	*
	* @param announcementImage the announcement image
	* @return the announcement image that was removed
	*/
	@Override
	public com.gleo.modules.ravenbox.model.AnnouncementImage deleteAnnouncementImage(
		com.gleo.modules.ravenbox.model.AnnouncementImage announcementImage) {
		return _announcementImageLocalService.deleteAnnouncementImage(announcementImage);
	}

	/**
	* Deletes the announcement image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param announcementImageId the primary key of the announcement image
	* @return the announcement image that was removed
	* @throws PortalException if a announcement image with the primary key could not be found
	*/
	@Override
	public com.gleo.modules.ravenbox.model.AnnouncementImage deleteAnnouncementImage(
		long announcementImageId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _announcementImageLocalService.deleteAnnouncementImage(announcementImageId);
	}

	@Override
	public com.gleo.modules.ravenbox.model.AnnouncementImage fetchAnnouncementImage(
		long announcementImageId) {
		return _announcementImageLocalService.fetchAnnouncementImage(announcementImageId);
	}

	/**
	* Returns the announcement image with the primary key.
	*
	* @param announcementImageId the primary key of the announcement image
	* @return the announcement image
	* @throws PortalException if a announcement image with the primary key could not be found
	*/
	@Override
	public com.gleo.modules.ravenbox.model.AnnouncementImage getAnnouncementImage(
		long announcementImageId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _announcementImageLocalService.getAnnouncementImage(announcementImageId);
	}

	/**
	* Updates the announcement image in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param announcementImage the announcement image
	* @return the announcement image that was updated
	*/
	@Override
	public com.gleo.modules.ravenbox.model.AnnouncementImage updateAnnouncementImage(
		com.gleo.modules.ravenbox.model.AnnouncementImage announcementImage) {
		return _announcementImageLocalService.updateAnnouncementImage(announcementImage);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _announcementImageLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _announcementImageLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _announcementImageLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _announcementImageLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _announcementImageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of announcement images.
	*
	* @return the number of announcement images
	*/
	@Override
	public int getAnnouncementImagesCount() {
		return _announcementImageLocalService.getAnnouncementImagesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _announcementImageLocalService.getOSGiServiceIdentifier();
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
		return _announcementImageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gleo.modules.ravenbox.model.impl.AnnouncementImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _announcementImageLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gleo.modules.ravenbox.model.impl.AnnouncementImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _announcementImageLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns a range of all the announcement images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gleo.modules.ravenbox.model.impl.AnnouncementImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of announcement images
	* @param end the upper bound of the range of announcement images (not inclusive)
	* @return the range of announcement images
	*/
	@Override
	public java.util.List<com.gleo.modules.ravenbox.model.AnnouncementImage> getAnnouncementImages(
		int start, int end) {
		return _announcementImageLocalService.getAnnouncementImages(start, end);
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
		return _announcementImageLocalService.dynamicQueryCount(dynamicQuery);
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
		return _announcementImageLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public AnnouncementImageLocalService getWrappedService() {
		return _announcementImageLocalService;
	}

	@Override
	public void setWrappedService(
		AnnouncementImageLocalService announcementImageLocalService) {
		_announcementImageLocalService = announcementImageLocalService;
	}

	private AnnouncementImageLocalService _announcementImageLocalService;
}