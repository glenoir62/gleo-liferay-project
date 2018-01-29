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

import com.gleo.modules.ravenbox.exception.NoSuchAnnouncementException;
import com.gleo.modules.ravenbox.model.Announcement;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the announcement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Guillaume Lenoir
 * @see com.gleo.modules.ravenbox.service.persistence.impl.AnnouncementPersistenceImpl
 * @see AnnouncementUtil
 * @generated
 */
@ProviderType
public interface AnnouncementPersistence extends BasePersistence<Announcement> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnnouncementUtil} to access the announcement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the announcements where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching announcements
	*/
	public java.util.List<Announcement> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the announcements where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of announcements
	* @param end the upper bound of the range of announcements (not inclusive)
	* @return the range of matching announcements
	*/
	public java.util.List<Announcement> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the announcements where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of announcements
	* @param end the upper bound of the range of announcements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching announcements
	*/
	public java.util.List<Announcement> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator);

	/**
	* Returns an ordered range of all the announcements where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of announcements
	* @param end the upper bound of the range of announcements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching announcements
	*/
	public java.util.List<Announcement> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first announcement in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching announcement
	* @throws NoSuchAnnouncementException if a matching announcement could not be found
	*/
	public Announcement findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator)
		throws NoSuchAnnouncementException;

	/**
	* Returns the first announcement in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching announcement, or <code>null</code> if a matching announcement could not be found
	*/
	public Announcement fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator);

	/**
	* Returns the last announcement in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching announcement
	* @throws NoSuchAnnouncementException if a matching announcement could not be found
	*/
	public Announcement findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator)
		throws NoSuchAnnouncementException;

	/**
	* Returns the last announcement in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching announcement, or <code>null</code> if a matching announcement could not be found
	*/
	public Announcement fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator);

	/**
	* Returns the announcements before and after the current announcement in the ordered set where uuid = &#63;.
	*
	* @param announcementId the primary key of the current announcement
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next announcement
	* @throws NoSuchAnnouncementException if a announcement with the primary key could not be found
	*/
	public Announcement[] findByUuid_PrevAndNext(long announcementId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator)
		throws NoSuchAnnouncementException;

	/**
	* Removes all the announcements where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of announcements where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching announcements
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the announcement where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchAnnouncementException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching announcement
	* @throws NoSuchAnnouncementException if a matching announcement could not be found
	*/
	public Announcement findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchAnnouncementException;

	/**
	* Returns the announcement where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching announcement, or <code>null</code> if a matching announcement could not be found
	*/
	public Announcement fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the announcement where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching announcement, or <code>null</code> if a matching announcement could not be found
	*/
	public Announcement fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the announcement where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the announcement that was removed
	*/
	public Announcement removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchAnnouncementException;

	/**
	* Returns the number of announcements where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching announcements
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the announcements where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching announcements
	*/
	public java.util.List<Announcement> findByUuid_C(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of all the announcements where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of announcements
	* @param end the upper bound of the range of announcements (not inclusive)
	* @return the range of matching announcements
	*/
	public java.util.List<Announcement> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the announcements where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of announcements
	* @param end the upper bound of the range of announcements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching announcements
	*/
	public java.util.List<Announcement> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator);

	/**
	* Returns an ordered range of all the announcements where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of announcements
	* @param end the upper bound of the range of announcements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching announcements
	*/
	public java.util.List<Announcement> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first announcement in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching announcement
	* @throws NoSuchAnnouncementException if a matching announcement could not be found
	*/
	public Announcement findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator)
		throws NoSuchAnnouncementException;

	/**
	* Returns the first announcement in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching announcement, or <code>null</code> if a matching announcement could not be found
	*/
	public Announcement fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator);

	/**
	* Returns the last announcement in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching announcement
	* @throws NoSuchAnnouncementException if a matching announcement could not be found
	*/
	public Announcement findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator)
		throws NoSuchAnnouncementException;

	/**
	* Returns the last announcement in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching announcement, or <code>null</code> if a matching announcement could not be found
	*/
	public Announcement fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator);

	/**
	* Returns the announcements before and after the current announcement in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param announcementId the primary key of the current announcement
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next announcement
	* @throws NoSuchAnnouncementException if a announcement with the primary key could not be found
	*/
	public Announcement[] findByUuid_C_PrevAndNext(long announcementId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator)
		throws NoSuchAnnouncementException;

	/**
	* Removes all the announcements where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of announcements where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching announcements
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the announcements where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching announcements
	*/
	public java.util.List<Announcement> findByGroupId(long groupId);

	/**
	* Returns a range of all the announcements where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of announcements
	* @param end the upper bound of the range of announcements (not inclusive)
	* @return the range of matching announcements
	*/
	public java.util.List<Announcement> findByGroupId(long groupId, int start,
		int end);

	/**
	* Returns an ordered range of all the announcements where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of announcements
	* @param end the upper bound of the range of announcements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching announcements
	*/
	public java.util.List<Announcement> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator);

	/**
	* Returns an ordered range of all the announcements where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of announcements
	* @param end the upper bound of the range of announcements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching announcements
	*/
	public java.util.List<Announcement> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first announcement in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching announcement
	* @throws NoSuchAnnouncementException if a matching announcement could not be found
	*/
	public Announcement findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator)
		throws NoSuchAnnouncementException;

	/**
	* Returns the first announcement in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching announcement, or <code>null</code> if a matching announcement could not be found
	*/
	public Announcement fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator);

	/**
	* Returns the last announcement in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching announcement
	* @throws NoSuchAnnouncementException if a matching announcement could not be found
	*/
	public Announcement findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator)
		throws NoSuchAnnouncementException;

	/**
	* Returns the last announcement in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching announcement, or <code>null</code> if a matching announcement could not be found
	*/
	public Announcement fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator);

	/**
	* Returns the announcements before and after the current announcement in the ordered set where groupId = &#63;.
	*
	* @param announcementId the primary key of the current announcement
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next announcement
	* @throws NoSuchAnnouncementException if a announcement with the primary key could not be found
	*/
	public Announcement[] findByGroupId_PrevAndNext(long announcementId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator)
		throws NoSuchAnnouncementException;

	/**
	* Removes all the announcements where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of announcements where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching announcements
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns all the announcements where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching announcements
	*/
	public java.util.List<Announcement> findByG_S(long groupId, int status);

	/**
	* Returns a range of all the announcements where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of announcements
	* @param end the upper bound of the range of announcements (not inclusive)
	* @return the range of matching announcements
	*/
	public java.util.List<Announcement> findByG_S(long groupId, int status,
		int start, int end);

	/**
	* Returns an ordered range of all the announcements where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of announcements
	* @param end the upper bound of the range of announcements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching announcements
	*/
	public java.util.List<Announcement> findByG_S(long groupId, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator);

	/**
	* Returns an ordered range of all the announcements where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of announcements
	* @param end the upper bound of the range of announcements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching announcements
	*/
	public java.util.List<Announcement> findByG_S(long groupId, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first announcement in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching announcement
	* @throws NoSuchAnnouncementException if a matching announcement could not be found
	*/
	public Announcement findByG_S_First(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator)
		throws NoSuchAnnouncementException;

	/**
	* Returns the first announcement in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching announcement, or <code>null</code> if a matching announcement could not be found
	*/
	public Announcement fetchByG_S_First(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator);

	/**
	* Returns the last announcement in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching announcement
	* @throws NoSuchAnnouncementException if a matching announcement could not be found
	*/
	public Announcement findByG_S_Last(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator)
		throws NoSuchAnnouncementException;

	/**
	* Returns the last announcement in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching announcement, or <code>null</code> if a matching announcement could not be found
	*/
	public Announcement fetchByG_S_Last(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator);

	/**
	* Returns the announcements before and after the current announcement in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param announcementId the primary key of the current announcement
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next announcement
	* @throws NoSuchAnnouncementException if a announcement with the primary key could not be found
	*/
	public Announcement[] findByG_S_PrevAndNext(long announcementId,
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator)
		throws NoSuchAnnouncementException;

	/**
	* Removes all the announcements where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	*/
	public void removeByG_S(long groupId, int status);

	/**
	* Returns the number of announcements where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching announcements
	*/
	public int countByG_S(long groupId, int status);

	/**
	* Returns all the announcements where typeId = &#63;.
	*
	* @param typeId the type ID
	* @return the matching announcements
	*/
	public java.util.List<Announcement> findByTypeId(long typeId);

	/**
	* Returns a range of all the announcements where typeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typeId the type ID
	* @param start the lower bound of the range of announcements
	* @param end the upper bound of the range of announcements (not inclusive)
	* @return the range of matching announcements
	*/
	public java.util.List<Announcement> findByTypeId(long typeId, int start,
		int end);

	/**
	* Returns an ordered range of all the announcements where typeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typeId the type ID
	* @param start the lower bound of the range of announcements
	* @param end the upper bound of the range of announcements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching announcements
	*/
	public java.util.List<Announcement> findByTypeId(long typeId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator);

	/**
	* Returns an ordered range of all the announcements where typeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param typeId the type ID
	* @param start the lower bound of the range of announcements
	* @param end the upper bound of the range of announcements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching announcements
	*/
	public java.util.List<Announcement> findByTypeId(long typeId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first announcement in the ordered set where typeId = &#63;.
	*
	* @param typeId the type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching announcement
	* @throws NoSuchAnnouncementException if a matching announcement could not be found
	*/
	public Announcement findByTypeId_First(long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator)
		throws NoSuchAnnouncementException;

	/**
	* Returns the first announcement in the ordered set where typeId = &#63;.
	*
	* @param typeId the type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching announcement, or <code>null</code> if a matching announcement could not be found
	*/
	public Announcement fetchByTypeId_First(long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator);

	/**
	* Returns the last announcement in the ordered set where typeId = &#63;.
	*
	* @param typeId the type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching announcement
	* @throws NoSuchAnnouncementException if a matching announcement could not be found
	*/
	public Announcement findByTypeId_Last(long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator)
		throws NoSuchAnnouncementException;

	/**
	* Returns the last announcement in the ordered set where typeId = &#63;.
	*
	* @param typeId the type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching announcement, or <code>null</code> if a matching announcement could not be found
	*/
	public Announcement fetchByTypeId_Last(long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator);

	/**
	* Returns the announcements before and after the current announcement in the ordered set where typeId = &#63;.
	*
	* @param announcementId the primary key of the current announcement
	* @param typeId the type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next announcement
	* @throws NoSuchAnnouncementException if a announcement with the primary key could not be found
	*/
	public Announcement[] findByTypeId_PrevAndNext(long announcementId,
		long typeId,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator)
		throws NoSuchAnnouncementException;

	/**
	* Removes all the announcements where typeId = &#63; from the database.
	*
	* @param typeId the type ID
	*/
	public void removeByTypeId(long typeId);

	/**
	* Returns the number of announcements where typeId = &#63;.
	*
	* @param typeId the type ID
	* @return the number of matching announcements
	*/
	public int countByTypeId(long typeId);

	/**
	* Returns all the announcements where currencyId = &#63;.
	*
	* @param currencyId the currency ID
	* @return the matching announcements
	*/
	public java.util.List<Announcement> findByCurrencyId(long currencyId);

	/**
	* Returns a range of all the announcements where currencyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param currencyId the currency ID
	* @param start the lower bound of the range of announcements
	* @param end the upper bound of the range of announcements (not inclusive)
	* @return the range of matching announcements
	*/
	public java.util.List<Announcement> findByCurrencyId(long currencyId,
		int start, int end);

	/**
	* Returns an ordered range of all the announcements where currencyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param currencyId the currency ID
	* @param start the lower bound of the range of announcements
	* @param end the upper bound of the range of announcements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching announcements
	*/
	public java.util.List<Announcement> findByCurrencyId(long currencyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator);

	/**
	* Returns an ordered range of all the announcements where currencyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param currencyId the currency ID
	* @param start the lower bound of the range of announcements
	* @param end the upper bound of the range of announcements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching announcements
	*/
	public java.util.List<Announcement> findByCurrencyId(long currencyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first announcement in the ordered set where currencyId = &#63;.
	*
	* @param currencyId the currency ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching announcement
	* @throws NoSuchAnnouncementException if a matching announcement could not be found
	*/
	public Announcement findByCurrencyId_First(long currencyId,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator)
		throws NoSuchAnnouncementException;

	/**
	* Returns the first announcement in the ordered set where currencyId = &#63;.
	*
	* @param currencyId the currency ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching announcement, or <code>null</code> if a matching announcement could not be found
	*/
	public Announcement fetchByCurrencyId_First(long currencyId,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator);

	/**
	* Returns the last announcement in the ordered set where currencyId = &#63;.
	*
	* @param currencyId the currency ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching announcement
	* @throws NoSuchAnnouncementException if a matching announcement could not be found
	*/
	public Announcement findByCurrencyId_Last(long currencyId,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator)
		throws NoSuchAnnouncementException;

	/**
	* Returns the last announcement in the ordered set where currencyId = &#63;.
	*
	* @param currencyId the currency ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching announcement, or <code>null</code> if a matching announcement could not be found
	*/
	public Announcement fetchByCurrencyId_Last(long currencyId,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator);

	/**
	* Returns the announcements before and after the current announcement in the ordered set where currencyId = &#63;.
	*
	* @param announcementId the primary key of the current announcement
	* @param currencyId the currency ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next announcement
	* @throws NoSuchAnnouncementException if a announcement with the primary key could not be found
	*/
	public Announcement[] findByCurrencyId_PrevAndNext(long announcementId,
		long currencyId,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator)
		throws NoSuchAnnouncementException;

	/**
	* Removes all the announcements where currencyId = &#63; from the database.
	*
	* @param currencyId the currency ID
	*/
	public void removeByCurrencyId(long currencyId);

	/**
	* Returns the number of announcements where currencyId = &#63;.
	*
	* @param currencyId the currency ID
	* @return the number of matching announcements
	*/
	public int countByCurrencyId(long currencyId);

	/**
	* Caches the announcement in the entity cache if it is enabled.
	*
	* @param announcement the announcement
	*/
	public void cacheResult(Announcement announcement);

	/**
	* Caches the announcements in the entity cache if it is enabled.
	*
	* @param announcements the announcements
	*/
	public void cacheResult(java.util.List<Announcement> announcements);

	/**
	* Creates a new announcement with the primary key. Does not add the announcement to the database.
	*
	* @param announcementId the primary key for the new announcement
	* @return the new announcement
	*/
	public Announcement create(long announcementId);

	/**
	* Removes the announcement with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param announcementId the primary key of the announcement
	* @return the announcement that was removed
	* @throws NoSuchAnnouncementException if a announcement with the primary key could not be found
	*/
	public Announcement remove(long announcementId)
		throws NoSuchAnnouncementException;

	public Announcement updateImpl(Announcement announcement);

	/**
	* Returns the announcement with the primary key or throws a {@link NoSuchAnnouncementException} if it could not be found.
	*
	* @param announcementId the primary key of the announcement
	* @return the announcement
	* @throws NoSuchAnnouncementException if a announcement with the primary key could not be found
	*/
	public Announcement findByPrimaryKey(long announcementId)
		throws NoSuchAnnouncementException;

	/**
	* Returns the announcement with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param announcementId the primary key of the announcement
	* @return the announcement, or <code>null</code> if a announcement with the primary key could not be found
	*/
	public Announcement fetchByPrimaryKey(long announcementId);

	@Override
	public java.util.Map<java.io.Serializable, Announcement> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the announcements.
	*
	* @return the announcements
	*/
	public java.util.List<Announcement> findAll();

	/**
	* Returns a range of all the announcements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of announcements
	* @param end the upper bound of the range of announcements (not inclusive)
	* @return the range of announcements
	*/
	public java.util.List<Announcement> findAll(int start, int end);

	/**
	* Returns an ordered range of all the announcements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of announcements
	* @param end the upper bound of the range of announcements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of announcements
	*/
	public java.util.List<Announcement> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator);

	/**
	* Returns an ordered range of all the announcements.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of announcements
	* @param end the upper bound of the range of announcements (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of announcements
	*/
	public java.util.List<Announcement> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Announcement> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the announcements from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of announcements.
	*
	* @return the number of announcements
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}