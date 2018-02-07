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
 * Provides a wrapper for {@link FavoriteLocalService}.
 *
 * @author Guillaume Lenoir
 * @see FavoriteLocalService
 * @generated
 */
@ProviderType
public class FavoriteLocalServiceWrapper implements FavoriteLocalService,
	ServiceWrapper<FavoriteLocalService> {
	public FavoriteLocalServiceWrapper(
		FavoriteLocalService favoriteLocalService) {
		_favoriteLocalService = favoriteLocalService;
	}

	@Override
	public boolean isUserFavoriteAnnouncement(long userId, long announcementId,
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _favoriteLocalService.isUserFavoriteAnnouncement(userId,
			announcementId, groupId);
	}

	/**
	* Adds the favorite to the database. Also notifies the appropriate model listeners.
	*
	* @param favorite the favorite
	* @return the favorite that was added
	*/
	@Override
	public com.gleo.modules.ravenbox.model.Favorite addFavorite(
		com.gleo.modules.ravenbox.model.Favorite favorite) {
		return _favoriteLocalService.addFavorite(favorite);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Favorite addUserFavoriteAnnouncement(
		long announcementId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _favoriteLocalService.addUserFavoriteAnnouncement(announcementId,
			serviceContext);
	}

	/**
	* Creates a new favorite with the primary key. Does not add the favorite to the database.
	*
	* @param favoriteId the primary key for the new favorite
	* @return the new favorite
	*/
	@Override
	public com.gleo.modules.ravenbox.model.Favorite createFavorite(
		long favoriteId) {
		return _favoriteLocalService.createFavorite(favoriteId);
	}

	/**
	* Deletes the favorite from the database. Also notifies the appropriate model listeners.
	*
	* @param favorite the favorite
	* @return the favorite that was removed
	*/
	@Override
	public com.gleo.modules.ravenbox.model.Favorite deleteFavorite(
		com.gleo.modules.ravenbox.model.Favorite favorite) {
		return _favoriteLocalService.deleteFavorite(favorite);
	}

	/**
	* Deletes the favorite with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param favoriteId the primary key of the favorite
	* @return the favorite that was removed
	* @throws PortalException if a favorite with the primary key could not be found
	*/
	@Override
	public com.gleo.modules.ravenbox.model.Favorite deleteFavorite(
		long favoriteId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _favoriteLocalService.deleteFavorite(favoriteId);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Favorite fetchFavorite(
		long favoriteId) {
		return _favoriteLocalService.fetchFavorite(favoriteId);
	}

	/**
	* Returns the favorite with the primary key.
	*
	* @param favoriteId the primary key of the favorite
	* @return the favorite
	* @throws PortalException if a favorite with the primary key could not be found
	*/
	@Override
	public com.gleo.modules.ravenbox.model.Favorite getFavorite(long favoriteId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _favoriteLocalService.getFavorite(favoriteId);
	}

	/**
	* Updates the favorite in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param favorite the favorite
	* @return the favorite that was updated
	*/
	@Override
	public com.gleo.modules.ravenbox.model.Favorite updateFavorite(
		com.gleo.modules.ravenbox.model.Favorite favorite) {
		return _favoriteLocalService.updateFavorite(favorite);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _favoriteLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _favoriteLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _favoriteLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _favoriteLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _favoriteLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public int countUserFavoriteAnnouncement(long userId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _favoriteLocalService.countUserFavoriteAnnouncement(userId,
			groupId);
	}

	/**
	* Returns the number of favorites.
	*
	* @return the number of favorites
	*/
	@Override
	public int getFavoritesCount() {
		return _favoriteLocalService.getFavoritesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _favoriteLocalService.getOSGiServiceIdentifier();
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
		return _favoriteLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gleo.modules.ravenbox.model.impl.FavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _favoriteLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gleo.modules.ravenbox.model.impl.FavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _favoriteLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the favorites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gleo.modules.ravenbox.model.impl.FavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of favorites
	* @param end the upper bound of the range of favorites (not inclusive)
	* @return the range of favorites
	*/
	@Override
	public java.util.List<com.gleo.modules.ravenbox.model.Favorite> getFavorites(
		int start, int end) {
		return _favoriteLocalService.getFavorites(start, end);
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
		return _favoriteLocalService.dynamicQueryCount(dynamicQuery);
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
		return _favoriteLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public void removeUserFavoriteAnnouncement(long announcementId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		_favoriteLocalService.removeUserFavoriteAnnouncement(announcementId,
			serviceContext);
	}

	@Override
	public FavoriteLocalService getWrappedService() {
		return _favoriteLocalService;
	}

	@Override
	public void setWrappedService(FavoriteLocalService favoriteLocalService) {
		_favoriteLocalService = favoriteLocalService;
	}

	private FavoriteLocalService _favoriteLocalService;
}