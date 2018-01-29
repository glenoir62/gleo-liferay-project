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

package com.gleo.modules.ravenbox.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.gleo.modules.ravenbox.model.Favorite;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the favorite service. This utility wraps {@link com.gleo.modules.ravenbox.service.persistence.impl.FavoritePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Guillaume Lenoir
 * @see FavoritePersistence
 * @see com.gleo.modules.ravenbox.service.persistence.impl.FavoritePersistenceImpl
 * @generated
 */
@ProviderType
public class FavoriteUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Favorite favorite) {
		getPersistence().clearCache(favorite);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Favorite> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Favorite> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Favorite> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Favorite> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Favorite update(Favorite favorite) {
		return getPersistence().update(favorite);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Favorite update(Favorite favorite,
		ServiceContext serviceContext) {
		return getPersistence().update(favorite, serviceContext);
	}

	/**
	* Returns all the favorites where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching favorites
	*/
	public static List<Favorite> findByUserIdGroupId(long userId, long groupId) {
		return getPersistence().findByUserIdGroupId(userId, groupId);
	}

	/**
	* Returns a range of all the favorites where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of favorites
	* @param end the upper bound of the range of favorites (not inclusive)
	* @return the range of matching favorites
	*/
	public static List<Favorite> findByUserIdGroupId(long userId, long groupId,
		int start, int end) {
		return getPersistence().findByUserIdGroupId(userId, groupId, start, end);
	}

	/**
	* Returns an ordered range of all the favorites where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of favorites
	* @param end the upper bound of the range of favorites (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching favorites
	*/
	public static List<Favorite> findByUserIdGroupId(long userId, long groupId,
		int start, int end, OrderByComparator<Favorite> orderByComparator) {
		return getPersistence()
				   .findByUserIdGroupId(userId, groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the favorites where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of favorites
	* @param end the upper bound of the range of favorites (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching favorites
	*/
	public static List<Favorite> findByUserIdGroupId(long userId, long groupId,
		int start, int end, OrderByComparator<Favorite> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserIdGroupId(userId, groupId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first favorite in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching favorite
	* @throws NoSuchFavoriteException if a matching favorite could not be found
	*/
	public static Favorite findByUserIdGroupId_First(long userId, long groupId,
		OrderByComparator<Favorite> orderByComparator)
		throws com.gleo.modules.ravenbox.exception.NoSuchFavoriteException {
		return getPersistence()
				   .findByUserIdGroupId_First(userId, groupId, orderByComparator);
	}

	/**
	* Returns the first favorite in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching favorite, or <code>null</code> if a matching favorite could not be found
	*/
	public static Favorite fetchByUserIdGroupId_First(long userId,
		long groupId, OrderByComparator<Favorite> orderByComparator) {
		return getPersistence()
				   .fetchByUserIdGroupId_First(userId, groupId,
			orderByComparator);
	}

	/**
	* Returns the last favorite in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching favorite
	* @throws NoSuchFavoriteException if a matching favorite could not be found
	*/
	public static Favorite findByUserIdGroupId_Last(long userId, long groupId,
		OrderByComparator<Favorite> orderByComparator)
		throws com.gleo.modules.ravenbox.exception.NoSuchFavoriteException {
		return getPersistence()
				   .findByUserIdGroupId_Last(userId, groupId, orderByComparator);
	}

	/**
	* Returns the last favorite in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching favorite, or <code>null</code> if a matching favorite could not be found
	*/
	public static Favorite fetchByUserIdGroupId_Last(long userId, long groupId,
		OrderByComparator<Favorite> orderByComparator) {
		return getPersistence()
				   .fetchByUserIdGroupId_Last(userId, groupId, orderByComparator);
	}

	/**
	* Returns the favorites before and after the current favorite in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param favoriteId the primary key of the current favorite
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next favorite
	* @throws NoSuchFavoriteException if a favorite with the primary key could not be found
	*/
	public static Favorite[] findByUserIdGroupId_PrevAndNext(long favoriteId,
		long userId, long groupId, OrderByComparator<Favorite> orderByComparator)
		throws com.gleo.modules.ravenbox.exception.NoSuchFavoriteException {
		return getPersistence()
				   .findByUserIdGroupId_PrevAndNext(favoriteId, userId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the favorites where userId = &#63; and groupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	*/
	public static void removeByUserIdGroupId(long userId, long groupId) {
		getPersistence().removeByUserIdGroupId(userId, groupId);
	}

	/**
	* Returns the number of favorites where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching favorites
	*/
	public static int countByUserIdGroupId(long userId, long groupId) {
		return getPersistence().countByUserIdGroupId(userId, groupId);
	}

	/**
	* Returns all the favorites where announcementId = &#63;.
	*
	* @param announcementId the announcement ID
	* @return the matching favorites
	*/
	public static List<Favorite> findByAnnouncementId(long announcementId) {
		return getPersistence().findByAnnouncementId(announcementId);
	}

	/**
	* Returns a range of all the favorites where announcementId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param announcementId the announcement ID
	* @param start the lower bound of the range of favorites
	* @param end the upper bound of the range of favorites (not inclusive)
	* @return the range of matching favorites
	*/
	public static List<Favorite> findByAnnouncementId(long announcementId,
		int start, int end) {
		return getPersistence().findByAnnouncementId(announcementId, start, end);
	}

	/**
	* Returns an ordered range of all the favorites where announcementId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param announcementId the announcement ID
	* @param start the lower bound of the range of favorites
	* @param end the upper bound of the range of favorites (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching favorites
	*/
	public static List<Favorite> findByAnnouncementId(long announcementId,
		int start, int end, OrderByComparator<Favorite> orderByComparator) {
		return getPersistence()
				   .findByAnnouncementId(announcementId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the favorites where announcementId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param announcementId the announcement ID
	* @param start the lower bound of the range of favorites
	* @param end the upper bound of the range of favorites (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching favorites
	*/
	public static List<Favorite> findByAnnouncementId(long announcementId,
		int start, int end, OrderByComparator<Favorite> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByAnnouncementId(announcementId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first favorite in the ordered set where announcementId = &#63;.
	*
	* @param announcementId the announcement ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching favorite
	* @throws NoSuchFavoriteException if a matching favorite could not be found
	*/
	public static Favorite findByAnnouncementId_First(long announcementId,
		OrderByComparator<Favorite> orderByComparator)
		throws com.gleo.modules.ravenbox.exception.NoSuchFavoriteException {
		return getPersistence()
				   .findByAnnouncementId_First(announcementId, orderByComparator);
	}

	/**
	* Returns the first favorite in the ordered set where announcementId = &#63;.
	*
	* @param announcementId the announcement ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching favorite, or <code>null</code> if a matching favorite could not be found
	*/
	public static Favorite fetchByAnnouncementId_First(long announcementId,
		OrderByComparator<Favorite> orderByComparator) {
		return getPersistence()
				   .fetchByAnnouncementId_First(announcementId,
			orderByComparator);
	}

	/**
	* Returns the last favorite in the ordered set where announcementId = &#63;.
	*
	* @param announcementId the announcement ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching favorite
	* @throws NoSuchFavoriteException if a matching favorite could not be found
	*/
	public static Favorite findByAnnouncementId_Last(long announcementId,
		OrderByComparator<Favorite> orderByComparator)
		throws com.gleo.modules.ravenbox.exception.NoSuchFavoriteException {
		return getPersistence()
				   .findByAnnouncementId_Last(announcementId, orderByComparator);
	}

	/**
	* Returns the last favorite in the ordered set where announcementId = &#63;.
	*
	* @param announcementId the announcement ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching favorite, or <code>null</code> if a matching favorite could not be found
	*/
	public static Favorite fetchByAnnouncementId_Last(long announcementId,
		OrderByComparator<Favorite> orderByComparator) {
		return getPersistence()
				   .fetchByAnnouncementId_Last(announcementId, orderByComparator);
	}

	/**
	* Returns the favorites before and after the current favorite in the ordered set where announcementId = &#63;.
	*
	* @param favoriteId the primary key of the current favorite
	* @param announcementId the announcement ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next favorite
	* @throws NoSuchFavoriteException if a favorite with the primary key could not be found
	*/
	public static Favorite[] findByAnnouncementId_PrevAndNext(long favoriteId,
		long announcementId, OrderByComparator<Favorite> orderByComparator)
		throws com.gleo.modules.ravenbox.exception.NoSuchFavoriteException {
		return getPersistence()
				   .findByAnnouncementId_PrevAndNext(favoriteId,
			announcementId, orderByComparator);
	}

	/**
	* Removes all the favorites where announcementId = &#63; from the database.
	*
	* @param announcementId the announcement ID
	*/
	public static void removeByAnnouncementId(long announcementId) {
		getPersistence().removeByAnnouncementId(announcementId);
	}

	/**
	* Returns the number of favorites where announcementId = &#63;.
	*
	* @param announcementId the announcement ID
	* @return the number of matching favorites
	*/
	public static int countByAnnouncementId(long announcementId) {
		return getPersistence().countByAnnouncementId(announcementId);
	}

	/**
	* Returns the favorite where announcementId = &#63; and userId = &#63; and groupId = &#63; or throws a {@link NoSuchFavoriteException} if it could not be found.
	*
	* @param announcementId the announcement ID
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching favorite
	* @throws NoSuchFavoriteException if a matching favorite could not be found
	*/
	public static Favorite findByA_U(long announcementId, long userId,
		long groupId)
		throws com.gleo.modules.ravenbox.exception.NoSuchFavoriteException {
		return getPersistence().findByA_U(announcementId, userId, groupId);
	}

	/**
	* Returns the favorite where announcementId = &#63; and userId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param announcementId the announcement ID
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching favorite, or <code>null</code> if a matching favorite could not be found
	*/
	public static Favorite fetchByA_U(long announcementId, long userId,
		long groupId) {
		return getPersistence().fetchByA_U(announcementId, userId, groupId);
	}

	/**
	* Returns the favorite where announcementId = &#63; and userId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param announcementId the announcement ID
	* @param userId the user ID
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching favorite, or <code>null</code> if a matching favorite could not be found
	*/
	public static Favorite fetchByA_U(long announcementId, long userId,
		long groupId, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByA_U(announcementId, userId, groupId,
			retrieveFromCache);
	}

	/**
	* Removes the favorite where announcementId = &#63; and userId = &#63; and groupId = &#63; from the database.
	*
	* @param announcementId the announcement ID
	* @param userId the user ID
	* @param groupId the group ID
	* @return the favorite that was removed
	*/
	public static Favorite removeByA_U(long announcementId, long userId,
		long groupId)
		throws com.gleo.modules.ravenbox.exception.NoSuchFavoriteException {
		return getPersistence().removeByA_U(announcementId, userId, groupId);
	}

	/**
	* Returns the number of favorites where announcementId = &#63; and userId = &#63; and groupId = &#63;.
	*
	* @param announcementId the announcement ID
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching favorites
	*/
	public static int countByA_U(long announcementId, long userId, long groupId) {
		return getPersistence().countByA_U(announcementId, userId, groupId);
	}

	/**
	* Caches the favorite in the entity cache if it is enabled.
	*
	* @param favorite the favorite
	*/
	public static void cacheResult(Favorite favorite) {
		getPersistence().cacheResult(favorite);
	}

	/**
	* Caches the favorites in the entity cache if it is enabled.
	*
	* @param favorites the favorites
	*/
	public static void cacheResult(List<Favorite> favorites) {
		getPersistence().cacheResult(favorites);
	}

	/**
	* Creates a new favorite with the primary key. Does not add the favorite to the database.
	*
	* @param favoriteId the primary key for the new favorite
	* @return the new favorite
	*/
	public static Favorite create(long favoriteId) {
		return getPersistence().create(favoriteId);
	}

	/**
	* Removes the favorite with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param favoriteId the primary key of the favorite
	* @return the favorite that was removed
	* @throws NoSuchFavoriteException if a favorite with the primary key could not be found
	*/
	public static Favorite remove(long favoriteId)
		throws com.gleo.modules.ravenbox.exception.NoSuchFavoriteException {
		return getPersistence().remove(favoriteId);
	}

	public static Favorite updateImpl(Favorite favorite) {
		return getPersistence().updateImpl(favorite);
	}

	/**
	* Returns the favorite with the primary key or throws a {@link NoSuchFavoriteException} if it could not be found.
	*
	* @param favoriteId the primary key of the favorite
	* @return the favorite
	* @throws NoSuchFavoriteException if a favorite with the primary key could not be found
	*/
	public static Favorite findByPrimaryKey(long favoriteId)
		throws com.gleo.modules.ravenbox.exception.NoSuchFavoriteException {
		return getPersistence().findByPrimaryKey(favoriteId);
	}

	/**
	* Returns the favorite with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param favoriteId the primary key of the favorite
	* @return the favorite, or <code>null</code> if a favorite with the primary key could not be found
	*/
	public static Favorite fetchByPrimaryKey(long favoriteId) {
		return getPersistence().fetchByPrimaryKey(favoriteId);
	}

	public static java.util.Map<java.io.Serializable, Favorite> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the favorites.
	*
	* @return the favorites
	*/
	public static List<Favorite> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the favorites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of favorites
	* @param end the upper bound of the range of favorites (not inclusive)
	* @return the range of favorites
	*/
	public static List<Favorite> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the favorites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of favorites
	* @param end the upper bound of the range of favorites (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of favorites
	*/
	public static List<Favorite> findAll(int start, int end,
		OrderByComparator<Favorite> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the favorites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FavoriteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of favorites
	* @param end the upper bound of the range of favorites (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of favorites
	*/
	public static List<Favorite> findAll(int start, int end,
		OrderByComparator<Favorite> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the favorites from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of favorites.
	*
	* @return the number of favorites
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FavoritePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FavoritePersistence, FavoritePersistence> _serviceTracker =
		ServiceTrackerFactory.open(FavoritePersistence.class);
}