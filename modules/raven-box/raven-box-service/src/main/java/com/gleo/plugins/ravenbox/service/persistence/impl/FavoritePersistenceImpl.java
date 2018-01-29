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

package com.gleo.plugins.ravenbox.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.gleo.plugins.ravenbox.exception.NoSuchFavoriteException;
import com.gleo.plugins.ravenbox.model.Favorite;
import com.gleo.plugins.ravenbox.model.impl.FavoriteImpl;
import com.gleo.plugins.ravenbox.model.impl.FavoriteModelImpl;
import com.gleo.plugins.ravenbox.service.persistence.FavoritePersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the favorite service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Guillaume Lenoir
 * @see FavoritePersistence
 * @see com.gleo.plugins.ravenbox.service.persistence.FavoriteUtil
 * @generated
 */
@ProviderType
public class FavoritePersistenceImpl extends BasePersistenceImpl<Favorite>
	implements FavoritePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FavoriteUtil} to access the favorite persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FavoriteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FavoriteModelImpl.ENTITY_CACHE_ENABLED,
			FavoriteModelImpl.FINDER_CACHE_ENABLED, FavoriteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FavoriteModelImpl.ENTITY_CACHE_ENABLED,
			FavoriteModelImpl.FINDER_CACHE_ENABLED, FavoriteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FavoriteModelImpl.ENTITY_CACHE_ENABLED,
			FavoriteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDGROUPID =
		new FinderPath(FavoriteModelImpl.ENTITY_CACHE_ENABLED,
			FavoriteModelImpl.FINDER_CACHE_ENABLED, FavoriteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID =
		new FinderPath(FavoriteModelImpl.ENTITY_CACHE_ENABLED,
			FavoriteModelImpl.FINDER_CACHE_ENABLED, FavoriteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserIdGroupId",
			new String[] { Long.class.getName(), Long.class.getName() },
			FavoriteModelImpl.USERID_COLUMN_BITMASK |
			FavoriteModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERIDGROUPID = new FinderPath(FavoriteModelImpl.ENTITY_CACHE_ENABLED,
			FavoriteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserIdGroupId",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the favorites where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching favorites
	 */
	@Override
	public List<Favorite> findByUserIdGroupId(long userId, long groupId) {
		return findByUserIdGroupId(userId, groupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Favorite> findByUserIdGroupId(long userId, long groupId,
		int start, int end) {
		return findByUserIdGroupId(userId, groupId, start, end, null);
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
	@Override
	public List<Favorite> findByUserIdGroupId(long userId, long groupId,
		int start, int end, OrderByComparator<Favorite> orderByComparator) {
		return findByUserIdGroupId(userId, groupId, start, end,
			orderByComparator, true);
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
	@Override
	public List<Favorite> findByUserIdGroupId(long userId, long groupId,
		int start, int end, OrderByComparator<Favorite> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID;
			finderArgs = new Object[] { userId, groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDGROUPID;
			finderArgs = new Object[] {
					userId, groupId,
					
					start, end, orderByComparator
				};
		}

		List<Favorite> list = null;

		if (retrieveFromCache) {
			list = (List<Favorite>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Favorite favorite : list) {
					if ((userId != favorite.getUserId()) ||
							(groupId != favorite.getGroupId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_FAVORITE_WHERE);

			query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FavoriteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Favorite>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Favorite>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Favorite findByUserIdGroupId_First(long userId, long groupId,
		OrderByComparator<Favorite> orderByComparator)
		throws NoSuchFavoriteException {
		Favorite favorite = fetchByUserIdGroupId_First(userId, groupId,
				orderByComparator);

		if (favorite != null) {
			return favorite;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFavoriteException(msg.toString());
	}

	/**
	 * Returns the first favorite in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching favorite, or <code>null</code> if a matching favorite could not be found
	 */
	@Override
	public Favorite fetchByUserIdGroupId_First(long userId, long groupId,
		OrderByComparator<Favorite> orderByComparator) {
		List<Favorite> list = findByUserIdGroupId(userId, groupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Favorite findByUserIdGroupId_Last(long userId, long groupId,
		OrderByComparator<Favorite> orderByComparator)
		throws NoSuchFavoriteException {
		Favorite favorite = fetchByUserIdGroupId_Last(userId, groupId,
				orderByComparator);

		if (favorite != null) {
			return favorite;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFavoriteException(msg.toString());
	}

	/**
	 * Returns the last favorite in the ordered set where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching favorite, or <code>null</code> if a matching favorite could not be found
	 */
	@Override
	public Favorite fetchByUserIdGroupId_Last(long userId, long groupId,
		OrderByComparator<Favorite> orderByComparator) {
		int count = countByUserIdGroupId(userId, groupId);

		if (count == 0) {
			return null;
		}

		List<Favorite> list = findByUserIdGroupId(userId, groupId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Favorite[] findByUserIdGroupId_PrevAndNext(long favoriteId,
		long userId, long groupId, OrderByComparator<Favorite> orderByComparator)
		throws NoSuchFavoriteException {
		Favorite favorite = findByPrimaryKey(favoriteId);

		Session session = null;

		try {
			session = openSession();

			Favorite[] array = new FavoriteImpl[3];

			array[0] = getByUserIdGroupId_PrevAndNext(session, favorite,
					userId, groupId, orderByComparator, true);

			array[1] = favorite;

			array[2] = getByUserIdGroupId_PrevAndNext(session, favorite,
					userId, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Favorite getByUserIdGroupId_PrevAndNext(Session session,
		Favorite favorite, long userId, long groupId,
		OrderByComparator<Favorite> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_FAVORITE_WHERE);

		query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

		query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(FavoriteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(favorite);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Favorite> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the favorites where userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 */
	@Override
	public void removeByUserIdGroupId(long userId, long groupId) {
		for (Favorite favorite : findByUserIdGroupId(userId, groupId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(favorite);
		}
	}

	/**
	 * Returns the number of favorites where userId = &#63; and groupId = &#63;.
	 *
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching favorites
	 */
	@Override
	public int countByUserIdGroupId(long userId, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDGROUPID;

		Object[] finderArgs = new Object[] { userId, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_FAVORITE_WHERE);

			query.append(_FINDER_COLUMN_USERIDGROUPID_USERID_2);

			query.append(_FINDER_COLUMN_USERIDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERIDGROUPID_USERID_2 = "favorite.userId = ? AND ";
	private static final String _FINDER_COLUMN_USERIDGROUPID_GROUPID_2 = "favorite.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ANNOUNCEMENTID =
		new FinderPath(FavoriteModelImpl.ENTITY_CACHE_ENABLED,
			FavoriteModelImpl.FINDER_CACHE_ENABLED, FavoriteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAnnouncementId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOUNCEMENTID =
		new FinderPath(FavoriteModelImpl.ENTITY_CACHE_ENABLED,
			FavoriteModelImpl.FINDER_CACHE_ENABLED, FavoriteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAnnouncementId",
			new String[] { Long.class.getName() },
			FavoriteModelImpl.ANNOUNCEMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ANNOUNCEMENTID = new FinderPath(FavoriteModelImpl.ENTITY_CACHE_ENABLED,
			FavoriteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAnnouncementId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the favorites where announcementId = &#63;.
	 *
	 * @param announcementId the announcement ID
	 * @return the matching favorites
	 */
	@Override
	public List<Favorite> findByAnnouncementId(long announcementId) {
		return findByAnnouncementId(announcementId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Favorite> findByAnnouncementId(long announcementId, int start,
		int end) {
		return findByAnnouncementId(announcementId, start, end, null);
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
	@Override
	public List<Favorite> findByAnnouncementId(long announcementId, int start,
		int end, OrderByComparator<Favorite> orderByComparator) {
		return findByAnnouncementId(announcementId, start, end,
			orderByComparator, true);
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
	@Override
	public List<Favorite> findByAnnouncementId(long announcementId, int start,
		int end, OrderByComparator<Favorite> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOUNCEMENTID;
			finderArgs = new Object[] { announcementId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ANNOUNCEMENTID;
			finderArgs = new Object[] {
					announcementId,
					
					start, end, orderByComparator
				};
		}

		List<Favorite> list = null;

		if (retrieveFromCache) {
			list = (List<Favorite>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Favorite favorite : list) {
					if ((announcementId != favorite.getAnnouncementId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_FAVORITE_WHERE);

			query.append(_FINDER_COLUMN_ANNOUNCEMENTID_ANNOUNCEMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FavoriteModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(announcementId);

				if (!pagination) {
					list = (List<Favorite>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Favorite>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first favorite in the ordered set where announcementId = &#63;.
	 *
	 * @param announcementId the announcement ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching favorite
	 * @throws NoSuchFavoriteException if a matching favorite could not be found
	 */
	@Override
	public Favorite findByAnnouncementId_First(long announcementId,
		OrderByComparator<Favorite> orderByComparator)
		throws NoSuchFavoriteException {
		Favorite favorite = fetchByAnnouncementId_First(announcementId,
				orderByComparator);

		if (favorite != null) {
			return favorite;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("announcementId=");
		msg.append(announcementId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFavoriteException(msg.toString());
	}

	/**
	 * Returns the first favorite in the ordered set where announcementId = &#63;.
	 *
	 * @param announcementId the announcement ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching favorite, or <code>null</code> if a matching favorite could not be found
	 */
	@Override
	public Favorite fetchByAnnouncementId_First(long announcementId,
		OrderByComparator<Favorite> orderByComparator) {
		List<Favorite> list = findByAnnouncementId(announcementId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last favorite in the ordered set where announcementId = &#63;.
	 *
	 * @param announcementId the announcement ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching favorite
	 * @throws NoSuchFavoriteException if a matching favorite could not be found
	 */
	@Override
	public Favorite findByAnnouncementId_Last(long announcementId,
		OrderByComparator<Favorite> orderByComparator)
		throws NoSuchFavoriteException {
		Favorite favorite = fetchByAnnouncementId_Last(announcementId,
				orderByComparator);

		if (favorite != null) {
			return favorite;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("announcementId=");
		msg.append(announcementId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFavoriteException(msg.toString());
	}

	/**
	 * Returns the last favorite in the ordered set where announcementId = &#63;.
	 *
	 * @param announcementId the announcement ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching favorite, or <code>null</code> if a matching favorite could not be found
	 */
	@Override
	public Favorite fetchByAnnouncementId_Last(long announcementId,
		OrderByComparator<Favorite> orderByComparator) {
		int count = countByAnnouncementId(announcementId);

		if (count == 0) {
			return null;
		}

		List<Favorite> list = findByAnnouncementId(announcementId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Favorite[] findByAnnouncementId_PrevAndNext(long favoriteId,
		long announcementId, OrderByComparator<Favorite> orderByComparator)
		throws NoSuchFavoriteException {
		Favorite favorite = findByPrimaryKey(favoriteId);

		Session session = null;

		try {
			session = openSession();

			Favorite[] array = new FavoriteImpl[3];

			array[0] = getByAnnouncementId_PrevAndNext(session, favorite,
					announcementId, orderByComparator, true);

			array[1] = favorite;

			array[2] = getByAnnouncementId_PrevAndNext(session, favorite,
					announcementId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Favorite getByAnnouncementId_PrevAndNext(Session session,
		Favorite favorite, long announcementId,
		OrderByComparator<Favorite> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FAVORITE_WHERE);

		query.append(_FINDER_COLUMN_ANNOUNCEMENTID_ANNOUNCEMENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(FavoriteModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(announcementId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(favorite);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Favorite> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the favorites where announcementId = &#63; from the database.
	 *
	 * @param announcementId the announcement ID
	 */
	@Override
	public void removeByAnnouncementId(long announcementId) {
		for (Favorite favorite : findByAnnouncementId(announcementId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(favorite);
		}
	}

	/**
	 * Returns the number of favorites where announcementId = &#63;.
	 *
	 * @param announcementId the announcement ID
	 * @return the number of matching favorites
	 */
	@Override
	public int countByAnnouncementId(long announcementId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ANNOUNCEMENTID;

		Object[] finderArgs = new Object[] { announcementId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_FAVORITE_WHERE);

			query.append(_FINDER_COLUMN_ANNOUNCEMENTID_ANNOUNCEMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(announcementId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ANNOUNCEMENTID_ANNOUNCEMENTID_2 = "favorite.announcementId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_A_U = new FinderPath(FavoriteModelImpl.ENTITY_CACHE_ENABLED,
			FavoriteModelImpl.FINDER_CACHE_ENABLED, FavoriteImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByA_U",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			FavoriteModelImpl.ANNOUNCEMENTID_COLUMN_BITMASK |
			FavoriteModelImpl.USERID_COLUMN_BITMASK |
			FavoriteModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_A_U = new FinderPath(FavoriteModelImpl.ENTITY_CACHE_ENABLED,
			FavoriteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByA_U",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the favorite where announcementId = &#63; and userId = &#63; and groupId = &#63; or throws a {@link NoSuchFavoriteException} if it could not be found.
	 *
	 * @param announcementId the announcement ID
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching favorite
	 * @throws NoSuchFavoriteException if a matching favorite could not be found
	 */
	@Override
	public Favorite findByA_U(long announcementId, long userId, long groupId)
		throws NoSuchFavoriteException {
		Favorite favorite = fetchByA_U(announcementId, userId, groupId);

		if (favorite == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("announcementId=");
			msg.append(announcementId);

			msg.append(", userId=");
			msg.append(userId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchFavoriteException(msg.toString());
		}

		return favorite;
	}

	/**
	 * Returns the favorite where announcementId = &#63; and userId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param announcementId the announcement ID
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the matching favorite, or <code>null</code> if a matching favorite could not be found
	 */
	@Override
	public Favorite fetchByA_U(long announcementId, long userId, long groupId) {
		return fetchByA_U(announcementId, userId, groupId, true);
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
	@Override
	public Favorite fetchByA_U(long announcementId, long userId, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { announcementId, userId, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_A_U,
					finderArgs, this);
		}

		if (result instanceof Favorite) {
			Favorite favorite = (Favorite)result;

			if ((announcementId != favorite.getAnnouncementId()) ||
					(userId != favorite.getUserId()) ||
					(groupId != favorite.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_FAVORITE_WHERE);

			query.append(_FINDER_COLUMN_A_U_ANNOUNCEMENTID_2);

			query.append(_FINDER_COLUMN_A_U_USERID_2);

			query.append(_FINDER_COLUMN_A_U_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(announcementId);

				qPos.add(userId);

				qPos.add(groupId);

				List<Favorite> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_A_U, finderArgs,
						list);
				}
				else {
					Favorite favorite = list.get(0);

					result = favorite;

					cacheResult(favorite);

					if ((favorite.getAnnouncementId() != announcementId) ||
							(favorite.getUserId() != userId) ||
							(favorite.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_A_U,
							finderArgs, favorite);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_A_U, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Favorite)result;
		}
	}

	/**
	 * Removes the favorite where announcementId = &#63; and userId = &#63; and groupId = &#63; from the database.
	 *
	 * @param announcementId the announcement ID
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the favorite that was removed
	 */
	@Override
	public Favorite removeByA_U(long announcementId, long userId, long groupId)
		throws NoSuchFavoriteException {
		Favorite favorite = findByA_U(announcementId, userId, groupId);

		return remove(favorite);
	}

	/**
	 * Returns the number of favorites where announcementId = &#63; and userId = &#63; and groupId = &#63;.
	 *
	 * @param announcementId the announcement ID
	 * @param userId the user ID
	 * @param groupId the group ID
	 * @return the number of matching favorites
	 */
	@Override
	public int countByA_U(long announcementId, long userId, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_A_U;

		Object[] finderArgs = new Object[] { announcementId, userId, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_FAVORITE_WHERE);

			query.append(_FINDER_COLUMN_A_U_ANNOUNCEMENTID_2);

			query.append(_FINDER_COLUMN_A_U_USERID_2);

			query.append(_FINDER_COLUMN_A_U_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(announcementId);

				qPos.add(userId);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_A_U_ANNOUNCEMENTID_2 = "favorite.announcementId = ? AND ";
	private static final String _FINDER_COLUMN_A_U_USERID_2 = "favorite.userId = ? AND ";
	private static final String _FINDER_COLUMN_A_U_GROUPID_2 = "favorite.groupId = ?";

	public FavoritePersistenceImpl() {
		setModelClass(Favorite.class);
	}

	/**
	 * Caches the favorite in the entity cache if it is enabled.
	 *
	 * @param favorite the favorite
	 */
	@Override
	public void cacheResult(Favorite favorite) {
		entityCache.putResult(FavoriteModelImpl.ENTITY_CACHE_ENABLED,
			FavoriteImpl.class, favorite.getPrimaryKey(), favorite);

		finderCache.putResult(FINDER_PATH_FETCH_BY_A_U,
			new Object[] {
				favorite.getAnnouncementId(), favorite.getUserId(),
				favorite.getGroupId()
			}, favorite);

		favorite.resetOriginalValues();
	}

	/**
	 * Caches the favorites in the entity cache if it is enabled.
	 *
	 * @param favorites the favorites
	 */
	@Override
	public void cacheResult(List<Favorite> favorites) {
		for (Favorite favorite : favorites) {
			if (entityCache.getResult(FavoriteModelImpl.ENTITY_CACHE_ENABLED,
						FavoriteImpl.class, favorite.getPrimaryKey()) == null) {
				cacheResult(favorite);
			}
			else {
				favorite.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all favorites.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FavoriteImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the favorite.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Favorite favorite) {
		entityCache.removeResult(FavoriteModelImpl.ENTITY_CACHE_ENABLED,
			FavoriteImpl.class, favorite.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((FavoriteModelImpl)favorite);
	}

	@Override
	public void clearCache(List<Favorite> favorites) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Favorite favorite : favorites) {
			entityCache.removeResult(FavoriteModelImpl.ENTITY_CACHE_ENABLED,
				FavoriteImpl.class, favorite.getPrimaryKey());

			clearUniqueFindersCache((FavoriteModelImpl)favorite);
		}
	}

	protected void cacheUniqueFindersCache(
		FavoriteModelImpl favoriteModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					favoriteModelImpl.getAnnouncementId(),
					favoriteModelImpl.getUserId(),
					favoriteModelImpl.getGroupId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_A_U, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_A_U, args,
				favoriteModelImpl);
		}
		else {
			if ((favoriteModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_A_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						favoriteModelImpl.getAnnouncementId(),
						favoriteModelImpl.getUserId(),
						favoriteModelImpl.getGroupId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_A_U, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_A_U, args,
					favoriteModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(FavoriteModelImpl favoriteModelImpl) {
		Object[] args = new Object[] {
				favoriteModelImpl.getAnnouncementId(),
				favoriteModelImpl.getUserId(), favoriteModelImpl.getGroupId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_A_U, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_A_U, args);

		if ((favoriteModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_A_U.getColumnBitmask()) != 0) {
			args = new Object[] {
					favoriteModelImpl.getOriginalAnnouncementId(),
					favoriteModelImpl.getOriginalUserId(),
					favoriteModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_A_U, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_A_U, args);
		}
	}

	/**
	 * Creates a new favorite with the primary key. Does not add the favorite to the database.
	 *
	 * @param favoriteId the primary key for the new favorite
	 * @return the new favorite
	 */
	@Override
	public Favorite create(long favoriteId) {
		Favorite favorite = new FavoriteImpl();

		favorite.setNew(true);
		favorite.setPrimaryKey(favoriteId);

		favorite.setCompanyId(companyProvider.getCompanyId());

		return favorite;
	}

	/**
	 * Removes the favorite with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param favoriteId the primary key of the favorite
	 * @return the favorite that was removed
	 * @throws NoSuchFavoriteException if a favorite with the primary key could not be found
	 */
	@Override
	public Favorite remove(long favoriteId) throws NoSuchFavoriteException {
		return remove((Serializable)favoriteId);
	}

	/**
	 * Removes the favorite with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the favorite
	 * @return the favorite that was removed
	 * @throws NoSuchFavoriteException if a favorite with the primary key could not be found
	 */
	@Override
	public Favorite remove(Serializable primaryKey)
		throws NoSuchFavoriteException {
		Session session = null;

		try {
			session = openSession();

			Favorite favorite = (Favorite)session.get(FavoriteImpl.class,
					primaryKey);

			if (favorite == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFavoriteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(favorite);
		}
		catch (NoSuchFavoriteException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Favorite removeImpl(Favorite favorite) {
		favorite = toUnwrappedModel(favorite);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(favorite)) {
				favorite = (Favorite)session.get(FavoriteImpl.class,
						favorite.getPrimaryKeyObj());
			}

			if (favorite != null) {
				session.delete(favorite);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (favorite != null) {
			clearCache(favorite);
		}

		return favorite;
	}

	@Override
	public Favorite updateImpl(Favorite favorite) {
		favorite = toUnwrappedModel(favorite);

		boolean isNew = favorite.isNew();

		FavoriteModelImpl favoriteModelImpl = (FavoriteModelImpl)favorite;

		Session session = null;

		try {
			session = openSession();

			if (favorite.isNew()) {
				session.save(favorite);

				favorite.setNew(false);
			}
			else {
				favorite = (Favorite)session.merge(favorite);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FavoriteModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((favoriteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						favoriteModelImpl.getOriginalUserId(),
						favoriteModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERIDGROUPID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID,
					args);

				args = new Object[] {
						favoriteModelImpl.getUserId(),
						favoriteModelImpl.getGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERIDGROUPID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDGROUPID,
					args);
			}

			if ((favoriteModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOUNCEMENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						favoriteModelImpl.getOriginalAnnouncementId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ANNOUNCEMENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOUNCEMENTID,
					args);

				args = new Object[] { favoriteModelImpl.getAnnouncementId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ANNOUNCEMENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ANNOUNCEMENTID,
					args);
			}
		}

		entityCache.putResult(FavoriteModelImpl.ENTITY_CACHE_ENABLED,
			FavoriteImpl.class, favorite.getPrimaryKey(), favorite, false);

		clearUniqueFindersCache(favoriteModelImpl);
		cacheUniqueFindersCache(favoriteModelImpl, isNew);

		favorite.resetOriginalValues();

		return favorite;
	}

	protected Favorite toUnwrappedModel(Favorite favorite) {
		if (favorite instanceof FavoriteImpl) {
			return favorite;
		}

		FavoriteImpl favoriteImpl = new FavoriteImpl();

		favoriteImpl.setNew(favorite.isNew());
		favoriteImpl.setPrimaryKey(favorite.getPrimaryKey());

		favoriteImpl.setFavoriteId(favorite.getFavoriteId());
		favoriteImpl.setAnnouncementId(favorite.getAnnouncementId());
		favoriteImpl.setCompanyId(favorite.getCompanyId());
		favoriteImpl.setGroupId(favorite.getGroupId());
		favoriteImpl.setUserId(favorite.getUserId());

		return favoriteImpl;
	}

	/**
	 * Returns the favorite with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the favorite
	 * @return the favorite
	 * @throws NoSuchFavoriteException if a favorite with the primary key could not be found
	 */
	@Override
	public Favorite findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFavoriteException {
		Favorite favorite = fetchByPrimaryKey(primaryKey);

		if (favorite == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFavoriteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return favorite;
	}

	/**
	 * Returns the favorite with the primary key or throws a {@link NoSuchFavoriteException} if it could not be found.
	 *
	 * @param favoriteId the primary key of the favorite
	 * @return the favorite
	 * @throws NoSuchFavoriteException if a favorite with the primary key could not be found
	 */
	@Override
	public Favorite findByPrimaryKey(long favoriteId)
		throws NoSuchFavoriteException {
		return findByPrimaryKey((Serializable)favoriteId);
	}

	/**
	 * Returns the favorite with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the favorite
	 * @return the favorite, or <code>null</code> if a favorite with the primary key could not be found
	 */
	@Override
	public Favorite fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(FavoriteModelImpl.ENTITY_CACHE_ENABLED,
				FavoriteImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Favorite favorite = (Favorite)serializable;

		if (favorite == null) {
			Session session = null;

			try {
				session = openSession();

				favorite = (Favorite)session.get(FavoriteImpl.class, primaryKey);

				if (favorite != null) {
					cacheResult(favorite);
				}
				else {
					entityCache.putResult(FavoriteModelImpl.ENTITY_CACHE_ENABLED,
						FavoriteImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(FavoriteModelImpl.ENTITY_CACHE_ENABLED,
					FavoriteImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return favorite;
	}

	/**
	 * Returns the favorite with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param favoriteId the primary key of the favorite
	 * @return the favorite, or <code>null</code> if a favorite with the primary key could not be found
	 */
	@Override
	public Favorite fetchByPrimaryKey(long favoriteId) {
		return fetchByPrimaryKey((Serializable)favoriteId);
	}

	@Override
	public Map<Serializable, Favorite> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Favorite> map = new HashMap<Serializable, Favorite>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Favorite favorite = fetchByPrimaryKey(primaryKey);

			if (favorite != null) {
				map.put(primaryKey, favorite);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(FavoriteModelImpl.ENTITY_CACHE_ENABLED,
					FavoriteImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Favorite)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_FAVORITE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Favorite favorite : (List<Favorite>)q.list()) {
				map.put(favorite.getPrimaryKeyObj(), favorite);

				cacheResult(favorite);

				uncachedPrimaryKeys.remove(favorite.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(FavoriteModelImpl.ENTITY_CACHE_ENABLED,
					FavoriteImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the favorites.
	 *
	 * @return the favorites
	 */
	@Override
	public List<Favorite> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Favorite> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Favorite> findAll(int start, int end,
		OrderByComparator<Favorite> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Favorite> findAll(int start, int end,
		OrderByComparator<Favorite> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Favorite> list = null;

		if (retrieveFromCache) {
			list = (List<Favorite>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_FAVORITE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FAVORITE;

				if (pagination) {
					sql = sql.concat(FavoriteModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Favorite>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Favorite>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the favorites from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Favorite favorite : findAll()) {
			remove(favorite);
		}
	}

	/**
	 * Returns the number of favorites.
	 *
	 * @return the number of favorites
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FAVORITE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FavoriteModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the favorite persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(FavoriteImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_FAVORITE = "SELECT favorite FROM Favorite favorite";
	private static final String _SQL_SELECT_FAVORITE_WHERE_PKS_IN = "SELECT favorite FROM Favorite favorite WHERE favoriteId IN (";
	private static final String _SQL_SELECT_FAVORITE_WHERE = "SELECT favorite FROM Favorite favorite WHERE ";
	private static final String _SQL_COUNT_FAVORITE = "SELECT COUNT(favorite) FROM Favorite favorite";
	private static final String _SQL_COUNT_FAVORITE_WHERE = "SELECT COUNT(favorite) FROM Favorite favorite WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "favorite.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Favorite exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Favorite exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(FavoritePersistenceImpl.class);
}