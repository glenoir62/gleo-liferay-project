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

package com.gleo.plugins.ravenbox.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.gleo.plugins.ravenbox.exception.NoSuchFavoriteException;
import com.gleo.plugins.ravenbox.model.Favorite;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the favorite service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Guillaume Lenoir
 * @see com.gleo.plugins.ravenbox.service.persistence.impl.FavoritePersistenceImpl
 * @see FavoriteUtil
 * @generated
 */
@ProviderType
public interface FavoritePersistence extends BasePersistence<Favorite> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FavoriteUtil} to access the favorite persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the favorites where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching favorites
	*/
	public java.util.List<Favorite> findByUserIdGroupId(long userId,
		long groupId);

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
	public java.util.List<Favorite> findByUserIdGroupId(long userId,
		long groupId, int start, int end);

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
	public java.util.List<Favorite> findByUserIdGroupId(long userId,
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite> orderByComparator);

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
	public java.util.List<Favorite> findByUserIdGroupId(long userId,
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first favorite in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching favorite
	* @throws NoSuchFavoriteException if a matching favorite could not be found
	*/
	public Favorite findByUserIdGroupId_First(long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite> orderByComparator)
		throws NoSuchFavoriteException;

	/**
	* Returns the first favorite in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching favorite, or <code>null</code> if a matching favorite could not be found
	*/
	public Favorite fetchByUserIdGroupId_First(long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite> orderByComparator);

	/**
	* Returns the last favorite in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching favorite
	* @throws NoSuchFavoriteException if a matching favorite could not be found
	*/
	public Favorite findByUserIdGroupId_Last(long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite> orderByComparator)
		throws NoSuchFavoriteException;

	/**
	* Returns the last favorite in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching favorite, or <code>null</code> if a matching favorite could not be found
	*/
	public Favorite fetchByUserIdGroupId_Last(long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite> orderByComparator);

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
	public Favorite[] findByUserIdGroupId_PrevAndNext(long favoriteId,
		long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite> orderByComparator)
		throws NoSuchFavoriteException;

	/**
	* Removes all the favorites where userId = &#63; and groupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	*/
	public void removeByUserIdGroupId(long userId, long groupId);

	/**
	* Returns the number of favorites where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching favorites
	*/
	public int countByUserIdGroupId(long userId, long groupId);

	/**
	* Returns all the favorites where announcementId = &#63;.
	*
	* @param announcementId the announcement ID
	* @return the matching favorites
	*/
	public java.util.List<Favorite> findByAnnouncementId(long announcementId);

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
	public java.util.List<Favorite> findByAnnouncementId(long announcementId,
		int start, int end);

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
	public java.util.List<Favorite> findByAnnouncementId(long announcementId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite> orderByComparator);

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
	public java.util.List<Favorite> findByAnnouncementId(long announcementId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first favorite in the ordered set where announcementId = &#63;.
	*
	* @param announcementId the announcement ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching favorite
	* @throws NoSuchFavoriteException if a matching favorite could not be found
	*/
	public Favorite findByAnnouncementId_First(long announcementId,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite> orderByComparator)
		throws NoSuchFavoriteException;

	/**
	* Returns the first favorite in the ordered set where announcementId = &#63;.
	*
	* @param announcementId the announcement ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching favorite, or <code>null</code> if a matching favorite could not be found
	*/
	public Favorite fetchByAnnouncementId_First(long announcementId,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite> orderByComparator);

	/**
	* Returns the last favorite in the ordered set where announcementId = &#63;.
	*
	* @param announcementId the announcement ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching favorite
	* @throws NoSuchFavoriteException if a matching favorite could not be found
	*/
	public Favorite findByAnnouncementId_Last(long announcementId,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite> orderByComparator)
		throws NoSuchFavoriteException;

	/**
	* Returns the last favorite in the ordered set where announcementId = &#63;.
	*
	* @param announcementId the announcement ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching favorite, or <code>null</code> if a matching favorite could not be found
	*/
	public Favorite fetchByAnnouncementId_Last(long announcementId,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite> orderByComparator);

	/**
	* Returns the favorites before and after the current favorite in the ordered set where announcementId = &#63;.
	*
	* @param favoriteId the primary key of the current favorite
	* @param announcementId the announcement ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next favorite
	* @throws NoSuchFavoriteException if a favorite with the primary key could not be found
	*/
	public Favorite[] findByAnnouncementId_PrevAndNext(long favoriteId,
		long announcementId,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite> orderByComparator)
		throws NoSuchFavoriteException;

	/**
	* Removes all the favorites where announcementId = &#63; from the database.
	*
	* @param announcementId the announcement ID
	*/
	public void removeByAnnouncementId(long announcementId);

	/**
	* Returns the number of favorites where announcementId = &#63;.
	*
	* @param announcementId the announcement ID
	* @return the number of matching favorites
	*/
	public int countByAnnouncementId(long announcementId);

	/**
	* Returns the favorite where announcementId = &#63; and userId = &#63; and groupId = &#63; or throws a {@link NoSuchFavoriteException} if it could not be found.
	*
	* @param announcementId the announcement ID
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching favorite
	* @throws NoSuchFavoriteException if a matching favorite could not be found
	*/
	public Favorite findByA_U(long announcementId, long userId, long groupId)
		throws NoSuchFavoriteException;

	/**
	* Returns the favorite where announcementId = &#63; and userId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param announcementId the announcement ID
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching favorite, or <code>null</code> if a matching favorite could not be found
	*/
	public Favorite fetchByA_U(long announcementId, long userId, long groupId);

	/**
	* Returns the favorite where announcementId = &#63; and userId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param announcementId the announcement ID
	* @param userId the user ID
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching favorite, or <code>null</code> if a matching favorite could not be found
	*/
	public Favorite fetchByA_U(long announcementId, long userId, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the favorite where announcementId = &#63; and userId = &#63; and groupId = &#63; from the database.
	*
	* @param announcementId the announcement ID
	* @param userId the user ID
	* @param groupId the group ID
	* @return the favorite that was removed
	*/
	public Favorite removeByA_U(long announcementId, long userId, long groupId)
		throws NoSuchFavoriteException;

	/**
	* Returns the number of favorites where announcementId = &#63; and userId = &#63; and groupId = &#63;.
	*
	* @param announcementId the announcement ID
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching favorites
	*/
	public int countByA_U(long announcementId, long userId, long groupId);

	/**
	* Caches the favorite in the entity cache if it is enabled.
	*
	* @param favorite the favorite
	*/
	public void cacheResult(Favorite favorite);

	/**
	* Caches the favorites in the entity cache if it is enabled.
	*
	* @param favorites the favorites
	*/
	public void cacheResult(java.util.List<Favorite> favorites);

	/**
	* Creates a new favorite with the primary key. Does not add the favorite to the database.
	*
	* @param favoriteId the primary key for the new favorite
	* @return the new favorite
	*/
	public Favorite create(long favoriteId);

	/**
	* Removes the favorite with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param favoriteId the primary key of the favorite
	* @return the favorite that was removed
	* @throws NoSuchFavoriteException if a favorite with the primary key could not be found
	*/
	public Favorite remove(long favoriteId) throws NoSuchFavoriteException;

	public Favorite updateImpl(Favorite favorite);

	/**
	* Returns the favorite with the primary key or throws a {@link NoSuchFavoriteException} if it could not be found.
	*
	* @param favoriteId the primary key of the favorite
	* @return the favorite
	* @throws NoSuchFavoriteException if a favorite with the primary key could not be found
	*/
	public Favorite findByPrimaryKey(long favoriteId)
		throws NoSuchFavoriteException;

	/**
	* Returns the favorite with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param favoriteId the primary key of the favorite
	* @return the favorite, or <code>null</code> if a favorite with the primary key could not be found
	*/
	public Favorite fetchByPrimaryKey(long favoriteId);

	@Override
	public java.util.Map<java.io.Serializable, Favorite> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the favorites.
	*
	* @return the favorites
	*/
	public java.util.List<Favorite> findAll();

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
	public java.util.List<Favorite> findAll(int start, int end);

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
	public java.util.List<Favorite> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite> orderByComparator);

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
	public java.util.List<Favorite> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Favorite> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the favorites from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of favorites.
	*
	* @return the number of favorites
	*/
	public int countAll();
}