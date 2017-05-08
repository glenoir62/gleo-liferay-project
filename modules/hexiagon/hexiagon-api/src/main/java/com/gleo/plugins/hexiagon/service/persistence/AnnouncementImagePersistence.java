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

package com.gleo.plugins.hexiagon.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.gleo.plugins.hexiagon.exception.NoSuchAnnouncementImageException;
import com.gleo.plugins.hexiagon.model.AnnouncementImage;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the announcement image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guillaumelenoir
 * @see com.gleo.plugins.hexiagon.service.persistence.impl.AnnouncementImagePersistenceImpl
 * @see AnnouncementImageUtil
 * @generated
 */
@ProviderType
public interface AnnouncementImagePersistence extends BasePersistence<AnnouncementImage> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnnouncementImageUtil} to access the announcement image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the announcement images where announcementId = &#63;.
	*
	* @param announcementId the announcement ID
	* @return the matching announcement images
	*/
	public java.util.List<AnnouncementImage> findByG_A(long announcementId);

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
	public java.util.List<AnnouncementImage> findByG_A(long announcementId,
		int start, int end);

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
	public java.util.List<AnnouncementImage> findByG_A(long announcementId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnnouncementImage> orderByComparator);

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
	public java.util.List<AnnouncementImage> findByG_A(long announcementId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnnouncementImage> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first announcement image in the ordered set where announcementId = &#63;.
	*
	* @param announcementId the announcement ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching announcement image
	* @throws NoSuchAnnouncementImageException if a matching announcement image could not be found
	*/
	public AnnouncementImage findByG_A_First(long announcementId,
		com.liferay.portal.kernel.util.OrderByComparator<AnnouncementImage> orderByComparator)
		throws NoSuchAnnouncementImageException;

	/**
	* Returns the first announcement image in the ordered set where announcementId = &#63;.
	*
	* @param announcementId the announcement ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching announcement image, or <code>null</code> if a matching announcement image could not be found
	*/
	public AnnouncementImage fetchByG_A_First(long announcementId,
		com.liferay.portal.kernel.util.OrderByComparator<AnnouncementImage> orderByComparator);

	/**
	* Returns the last announcement image in the ordered set where announcementId = &#63;.
	*
	* @param announcementId the announcement ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching announcement image
	* @throws NoSuchAnnouncementImageException if a matching announcement image could not be found
	*/
	public AnnouncementImage findByG_A_Last(long announcementId,
		com.liferay.portal.kernel.util.OrderByComparator<AnnouncementImage> orderByComparator)
		throws NoSuchAnnouncementImageException;

	/**
	* Returns the last announcement image in the ordered set where announcementId = &#63;.
	*
	* @param announcementId the announcement ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching announcement image, or <code>null</code> if a matching announcement image could not be found
	*/
	public AnnouncementImage fetchByG_A_Last(long announcementId,
		com.liferay.portal.kernel.util.OrderByComparator<AnnouncementImage> orderByComparator);

	/**
	* Returns the announcement images before and after the current announcement image in the ordered set where announcementId = &#63;.
	*
	* @param announcementImageId the primary key of the current announcement image
	* @param announcementId the announcement ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next announcement image
	* @throws NoSuchAnnouncementImageException if a announcement image with the primary key could not be found
	*/
	public AnnouncementImage[] findByG_A_PrevAndNext(long announcementImageId,
		long announcementId,
		com.liferay.portal.kernel.util.OrderByComparator<AnnouncementImage> orderByComparator)
		throws NoSuchAnnouncementImageException;

	/**
	* Removes all the announcement images where announcementId = &#63; from the database.
	*
	* @param announcementId the announcement ID
	*/
	public void removeByG_A(long announcementId);

	/**
	* Returns the number of announcement images where announcementId = &#63;.
	*
	* @param announcementId the announcement ID
	* @return the number of matching announcement images
	*/
	public int countByG_A(long announcementId);

	/**
	* Returns the announcement image where announcementId = &#63; and order = &#63; or throws a {@link NoSuchAnnouncementImageException} if it could not be found.
	*
	* @param announcementId the announcement ID
	* @param order the order
	* @return the matching announcement image
	* @throws NoSuchAnnouncementImageException if a matching announcement image could not be found
	*/
	public AnnouncementImage findByA_O(long announcementId, int order)
		throws NoSuchAnnouncementImageException;

	/**
	* Returns the announcement image where announcementId = &#63; and order = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param announcementId the announcement ID
	* @param order the order
	* @return the matching announcement image, or <code>null</code> if a matching announcement image could not be found
	*/
	public AnnouncementImage fetchByA_O(long announcementId, int order);

	/**
	* Returns the announcement image where announcementId = &#63; and order = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param announcementId the announcement ID
	* @param order the order
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching announcement image, or <code>null</code> if a matching announcement image could not be found
	*/
	public AnnouncementImage fetchByA_O(long announcementId, int order,
		boolean retrieveFromCache);

	/**
	* Removes the announcement image where announcementId = &#63; and order = &#63; from the database.
	*
	* @param announcementId the announcement ID
	* @param order the order
	* @return the announcement image that was removed
	*/
	public AnnouncementImage removeByA_O(long announcementId, int order)
		throws NoSuchAnnouncementImageException;

	/**
	* Returns the number of announcement images where announcementId = &#63; and order = &#63;.
	*
	* @param announcementId the announcement ID
	* @param order the order
	* @return the number of matching announcement images
	*/
	public int countByA_O(long announcementId, int order);

	/**
	* Caches the announcement image in the entity cache if it is enabled.
	*
	* @param announcementImage the announcement image
	*/
	public void cacheResult(AnnouncementImage announcementImage);

	/**
	* Caches the announcement images in the entity cache if it is enabled.
	*
	* @param announcementImages the announcement images
	*/
	public void cacheResult(
		java.util.List<AnnouncementImage> announcementImages);

	/**
	* Creates a new announcement image with the primary key. Does not add the announcement image to the database.
	*
	* @param announcementImageId the primary key for the new announcement image
	* @return the new announcement image
	*/
	public AnnouncementImage create(long announcementImageId);

	/**
	* Removes the announcement image with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param announcementImageId the primary key of the announcement image
	* @return the announcement image that was removed
	* @throws NoSuchAnnouncementImageException if a announcement image with the primary key could not be found
	*/
	public AnnouncementImage remove(long announcementImageId)
		throws NoSuchAnnouncementImageException;

	public AnnouncementImage updateImpl(AnnouncementImage announcementImage);

	/**
	* Returns the announcement image with the primary key or throws a {@link NoSuchAnnouncementImageException} if it could not be found.
	*
	* @param announcementImageId the primary key of the announcement image
	* @return the announcement image
	* @throws NoSuchAnnouncementImageException if a announcement image with the primary key could not be found
	*/
	public AnnouncementImage findByPrimaryKey(long announcementImageId)
		throws NoSuchAnnouncementImageException;

	/**
	* Returns the announcement image with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param announcementImageId the primary key of the announcement image
	* @return the announcement image, or <code>null</code> if a announcement image with the primary key could not be found
	*/
	public AnnouncementImage fetchByPrimaryKey(long announcementImageId);

	@Override
	public java.util.Map<java.io.Serializable, AnnouncementImage> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the announcement images.
	*
	* @return the announcement images
	*/
	public java.util.List<AnnouncementImage> findAll();

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
	public java.util.List<AnnouncementImage> findAll(int start, int end);

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
	public java.util.List<AnnouncementImage> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnnouncementImage> orderByComparator);

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
	public java.util.List<AnnouncementImage> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnnouncementImage> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the announcement images from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of announcement images.
	*
	* @return the number of announcement images
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}