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

import com.gleo.plugins.ravenbox.model.AnnouncementImage;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the announcement image service. This utility wraps {@link com.gleo.plugins.ravenbox.service.persistence.impl.AnnouncementImagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Guillaume Lenoir
 * @see AnnouncementImagePersistence
 * @see com.gleo.plugins.ravenbox.service.persistence.impl.AnnouncementImagePersistenceImpl
 * @generated
 */
@ProviderType
public class AnnouncementImageUtil {
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
	public static void clearCache(AnnouncementImage announcementImage) {
		getPersistence().clearCache(announcementImage);
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
	public static List<AnnouncementImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AnnouncementImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AnnouncementImage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AnnouncementImage> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AnnouncementImage update(AnnouncementImage announcementImage) {
		return getPersistence().update(announcementImage);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AnnouncementImage update(
		AnnouncementImage announcementImage, ServiceContext serviceContext) {
		return getPersistence().update(announcementImage, serviceContext);
	}

	/**
	* Returns all the announcement images where announcementId = &#63;.
	*
	* @param announcementId the announcement ID
	* @return the matching announcement images
	*/
	public static List<AnnouncementImage> findByG_A(long announcementId) {
		return getPersistence().findByG_A(announcementId);
	}

	/**
	* Returns a range of all the announcement images where announcementId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param announcementId the announcement ID
	* @param start the lower bound of the range of announcement images
	* @param end the upper bound of the range of announcement images (not inclusive)
	* @return the range of matching announcement images
	*/
	public static List<AnnouncementImage> findByG_A(long announcementId,
		int start, int end) {
		return getPersistence().findByG_A(announcementId, start, end);
	}

	/**
	* Returns an ordered range of all the announcement images where announcementId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param announcementId the announcement ID
	* @param start the lower bound of the range of announcement images
	* @param end the upper bound of the range of announcement images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching announcement images
	*/
	public static List<AnnouncementImage> findByG_A(long announcementId,
		int start, int end,
		OrderByComparator<AnnouncementImage> orderByComparator) {
		return getPersistence()
				   .findByG_A(announcementId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the announcement images where announcementId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param announcementId the announcement ID
	* @param start the lower bound of the range of announcement images
	* @param end the upper bound of the range of announcement images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching announcement images
	*/
	public static List<AnnouncementImage> findByG_A(long announcementId,
		int start, int end,
		OrderByComparator<AnnouncementImage> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByG_A(announcementId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first announcement image in the ordered set where announcementId = &#63;.
	*
	* @param announcementId the announcement ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching announcement image
	* @throws NoSuchAnnouncementImageException if a matching announcement image could not be found
	*/
	public static AnnouncementImage findByG_A_First(long announcementId,
		OrderByComparator<AnnouncementImage> orderByComparator)
		throws com.gleo.plugins.ravenbox.exception.NoSuchAnnouncementImageException {
		return getPersistence()
				   .findByG_A_First(announcementId, orderByComparator);
	}

	/**
	* Returns the first announcement image in the ordered set where announcementId = &#63;.
	*
	* @param announcementId the announcement ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching announcement image, or <code>null</code> if a matching announcement image could not be found
	*/
	public static AnnouncementImage fetchByG_A_First(long announcementId,
		OrderByComparator<AnnouncementImage> orderByComparator) {
		return getPersistence()
				   .fetchByG_A_First(announcementId, orderByComparator);
	}

	/**
	* Returns the last announcement image in the ordered set where announcementId = &#63;.
	*
	* @param announcementId the announcement ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching announcement image
	* @throws NoSuchAnnouncementImageException if a matching announcement image could not be found
	*/
	public static AnnouncementImage findByG_A_Last(long announcementId,
		OrderByComparator<AnnouncementImage> orderByComparator)
		throws com.gleo.plugins.ravenbox.exception.NoSuchAnnouncementImageException {
		return getPersistence().findByG_A_Last(announcementId, orderByComparator);
	}

	/**
	* Returns the last announcement image in the ordered set where announcementId = &#63;.
	*
	* @param announcementId the announcement ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching announcement image, or <code>null</code> if a matching announcement image could not be found
	*/
	public static AnnouncementImage fetchByG_A_Last(long announcementId,
		OrderByComparator<AnnouncementImage> orderByComparator) {
		return getPersistence()
				   .fetchByG_A_Last(announcementId, orderByComparator);
	}

	/**
	* Returns the announcement images before and after the current announcement image in the ordered set where announcementId = &#63;.
	*
	* @param announcementImageId the primary key of the current announcement image
	* @param announcementId the announcement ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next announcement image
	* @throws NoSuchAnnouncementImageException if a announcement image with the primary key could not be found
	*/
	public static AnnouncementImage[] findByG_A_PrevAndNext(
		long announcementImageId, long announcementId,
		OrderByComparator<AnnouncementImage> orderByComparator)
		throws com.gleo.plugins.ravenbox.exception.NoSuchAnnouncementImageException {
		return getPersistence()
				   .findByG_A_PrevAndNext(announcementImageId, announcementId,
			orderByComparator);
	}

	/**
	* Removes all the announcement images where announcementId = &#63; from the database.
	*
	* @param announcementId the announcement ID
	*/
	public static void removeByG_A(long announcementId) {
		getPersistence().removeByG_A(announcementId);
	}

	/**
	* Returns the number of announcement images where announcementId = &#63;.
	*
	* @param announcementId the announcement ID
	* @return the number of matching announcement images
	*/
	public static int countByG_A(long announcementId) {
		return getPersistence().countByG_A(announcementId);
	}

	/**
	* Returns the announcement image where announcementId = &#63; and order = &#63; or throws a {@link NoSuchAnnouncementImageException} if it could not be found.
	*
	* @param announcementId the announcement ID
	* @param order the order
	* @return the matching announcement image
	* @throws NoSuchAnnouncementImageException if a matching announcement image could not be found
	*/
	public static AnnouncementImage findByA_O(long announcementId, int order)
		throws com.gleo.plugins.ravenbox.exception.NoSuchAnnouncementImageException {
		return getPersistence().findByA_O(announcementId, order);
	}

	/**
	* Returns the announcement image where announcementId = &#63; and order = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param announcementId the announcement ID
	* @param order the order
	* @return the matching announcement image, or <code>null</code> if a matching announcement image could not be found
	*/
	public static AnnouncementImage fetchByA_O(long announcementId, int order) {
		return getPersistence().fetchByA_O(announcementId, order);
	}

	/**
	* Returns the announcement image where announcementId = &#63; and order = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param announcementId the announcement ID
	* @param order the order
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching announcement image, or <code>null</code> if a matching announcement image could not be found
	*/
	public static AnnouncementImage fetchByA_O(long announcementId, int order,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByA_O(announcementId, order, retrieveFromCache);
	}

	/**
	* Removes the announcement image where announcementId = &#63; and order = &#63; from the database.
	*
	* @param announcementId the announcement ID
	* @param order the order
	* @return the announcement image that was removed
	*/
	public static AnnouncementImage removeByA_O(long announcementId, int order)
		throws com.gleo.plugins.ravenbox.exception.NoSuchAnnouncementImageException {
		return getPersistence().removeByA_O(announcementId, order);
	}

	/**
	* Returns the number of announcement images where announcementId = &#63; and order = &#63;.
	*
	* @param announcementId the announcement ID
	* @param order the order
	* @return the number of matching announcement images
	*/
	public static int countByA_O(long announcementId, int order) {
		return getPersistence().countByA_O(announcementId, order);
	}

	/**
	* Caches the announcement image in the entity cache if it is enabled.
	*
	* @param announcementImage the announcement image
	*/
	public static void cacheResult(AnnouncementImage announcementImage) {
		getPersistence().cacheResult(announcementImage);
	}

	/**
	* Caches the announcement images in the entity cache if it is enabled.
	*
	* @param announcementImages the announcement images
	*/
	public static void cacheResult(List<AnnouncementImage> announcementImages) {
		getPersistence().cacheResult(announcementImages);
	}

	/**
	* Creates a new announcement image with the primary key. Does not add the announcement image to the database.
	*
	* @param announcementImageId the primary key for the new announcement image
	* @return the new announcement image
	*/
	public static AnnouncementImage create(long announcementImageId) {
		return getPersistence().create(announcementImageId);
	}

	/**
	* Removes the announcement image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param announcementImageId the primary key of the announcement image
	* @return the announcement image that was removed
	* @throws NoSuchAnnouncementImageException if a announcement image with the primary key could not be found
	*/
	public static AnnouncementImage remove(long announcementImageId)
		throws com.gleo.plugins.ravenbox.exception.NoSuchAnnouncementImageException {
		return getPersistence().remove(announcementImageId);
	}

	public static AnnouncementImage updateImpl(
		AnnouncementImage announcementImage) {
		return getPersistence().updateImpl(announcementImage);
	}

	/**
	* Returns the announcement image with the primary key or throws a {@link NoSuchAnnouncementImageException} if it could not be found.
	*
	* @param announcementImageId the primary key of the announcement image
	* @return the announcement image
	* @throws NoSuchAnnouncementImageException if a announcement image with the primary key could not be found
	*/
	public static AnnouncementImage findByPrimaryKey(long announcementImageId)
		throws com.gleo.plugins.ravenbox.exception.NoSuchAnnouncementImageException {
		return getPersistence().findByPrimaryKey(announcementImageId);
	}

	/**
	* Returns the announcement image with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param announcementImageId the primary key of the announcement image
	* @return the announcement image, or <code>null</code> if a announcement image with the primary key could not be found
	*/
	public static AnnouncementImage fetchByPrimaryKey(long announcementImageId) {
		return getPersistence().fetchByPrimaryKey(announcementImageId);
	}

	public static java.util.Map<java.io.Serializable, AnnouncementImage> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the announcement images.
	*
	* @return the announcement images
	*/
	public static List<AnnouncementImage> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the announcement images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of announcement images
	* @param end the upper bound of the range of announcement images (not inclusive)
	* @return the range of announcement images
	*/
	public static List<AnnouncementImage> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the announcement images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of announcement images
	* @param end the upper bound of the range of announcement images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of announcement images
	*/
	public static List<AnnouncementImage> findAll(int start, int end,
		OrderByComparator<AnnouncementImage> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the announcement images.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementImageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of announcement images
	* @param end the upper bound of the range of announcement images (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of announcement images
	*/
	public static List<AnnouncementImage> findAll(int start, int end,
		OrderByComparator<AnnouncementImage> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the announcement images from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of announcement images.
	*
	* @return the number of announcement images
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static AnnouncementImagePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AnnouncementImagePersistence, AnnouncementImagePersistence> _serviceTracker =
		ServiceTrackerFactory.open(AnnouncementImagePersistence.class);
}