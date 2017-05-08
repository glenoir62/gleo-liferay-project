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

package com.gleo.plugins.hexiagon.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.gleo.plugins.hexiagon.exception.NoSuchAnnouncementImageException;
import com.gleo.plugins.hexiagon.model.AnnouncementImage;
import com.gleo.plugins.hexiagon.model.impl.AnnouncementImageImpl;
import com.gleo.plugins.hexiagon.model.impl.AnnouncementImageModelImpl;
import com.gleo.plugins.hexiagon.service.persistence.AnnouncementImagePersistence;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
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
 * The persistence implementation for the announcement image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guillaumelenoir
 * @see AnnouncementImagePersistence
 * @see com.gleo.plugins.hexiagon.service.persistence.AnnouncementImageUtil
 * @generated
 */
@ProviderType
public class AnnouncementImagePersistenceImpl extends BasePersistenceImpl<AnnouncementImage>
	implements AnnouncementImagePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AnnouncementImageUtil} to access the announcement image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AnnouncementImageImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AnnouncementImageModelImpl.ENTITY_CACHE_ENABLED,
			AnnouncementImageModelImpl.FINDER_CACHE_ENABLED,
			AnnouncementImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AnnouncementImageModelImpl.ENTITY_CACHE_ENABLED,
			AnnouncementImageModelImpl.FINDER_CACHE_ENABLED,
			AnnouncementImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AnnouncementImageModelImpl.ENTITY_CACHE_ENABLED,
			AnnouncementImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_A = new FinderPath(AnnouncementImageModelImpl.ENTITY_CACHE_ENABLED,
			AnnouncementImageModelImpl.FINDER_CACHE_ENABLED,
			AnnouncementImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_A",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A = new FinderPath(AnnouncementImageModelImpl.ENTITY_CACHE_ENABLED,
			AnnouncementImageModelImpl.FINDER_CACHE_ENABLED,
			AnnouncementImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_A",
			new String[] { Long.class.getName() },
			AnnouncementImageModelImpl.ANNOUNCEMENTID_COLUMN_BITMASK |
			AnnouncementImageModelImpl.ORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_A = new FinderPath(AnnouncementImageModelImpl.ENTITY_CACHE_ENABLED,
			AnnouncementImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_A",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the announcement images where announcementId = &#63;.
	 *
	 * @param announcementId the announcement ID
	 * @return the matching announcement images
	 */
	@Override
	public List<AnnouncementImage> findByG_A(long announcementId) {
		return findByG_A(announcementId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<AnnouncementImage> findByG_A(long announcementId, int start,
		int end) {
		return findByG_A(announcementId, start, end, null);
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
	@Override
	public List<AnnouncementImage> findByG_A(long announcementId, int start,
		int end, OrderByComparator<AnnouncementImage> orderByComparator) {
		return findByG_A(announcementId, start, end, orderByComparator, true);
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
	@Override
	public List<AnnouncementImage> findByG_A(long announcementId, int start,
		int end, OrderByComparator<AnnouncementImage> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A;
			finderArgs = new Object[] { announcementId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_A;
			finderArgs = new Object[] {
					announcementId,
					
					start, end, orderByComparator
				};
		}

		List<AnnouncementImage> list = null;

		if (retrieveFromCache) {
			list = (List<AnnouncementImage>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnnouncementImage announcementImage : list) {
					if ((announcementId != announcementImage.getAnnouncementId())) {
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

			query.append(_SQL_SELECT_ANNOUNCEMENTIMAGE_WHERE);

			query.append(_FINDER_COLUMN_G_A_ANNOUNCEMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AnnouncementImageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(announcementId);

				if (!pagination) {
					list = (List<AnnouncementImage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnnouncementImage>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first announcement image in the ordered set where announcementId = &#63;.
	 *
	 * @param announcementId the announcement ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching announcement image
	 * @throws NoSuchAnnouncementImageException if a matching announcement image could not be found
	 */
	@Override
	public AnnouncementImage findByG_A_First(long announcementId,
		OrderByComparator<AnnouncementImage> orderByComparator)
		throws NoSuchAnnouncementImageException {
		AnnouncementImage announcementImage = fetchByG_A_First(announcementId,
				orderByComparator);

		if (announcementImage != null) {
			return announcementImage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("announcementId=");
		msg.append(announcementId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnnouncementImageException(msg.toString());
	}

	/**
	 * Returns the first announcement image in the ordered set where announcementId = &#63;.
	 *
	 * @param announcementId the announcement ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching announcement image, or <code>null</code> if a matching announcement image could not be found
	 */
	@Override
	public AnnouncementImage fetchByG_A_First(long announcementId,
		OrderByComparator<AnnouncementImage> orderByComparator) {
		List<AnnouncementImage> list = findByG_A(announcementId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last announcement image in the ordered set where announcementId = &#63;.
	 *
	 * @param announcementId the announcement ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching announcement image
	 * @throws NoSuchAnnouncementImageException if a matching announcement image could not be found
	 */
	@Override
	public AnnouncementImage findByG_A_Last(long announcementId,
		OrderByComparator<AnnouncementImage> orderByComparator)
		throws NoSuchAnnouncementImageException {
		AnnouncementImage announcementImage = fetchByG_A_Last(announcementId,
				orderByComparator);

		if (announcementImage != null) {
			return announcementImage;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("announcementId=");
		msg.append(announcementId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnnouncementImageException(msg.toString());
	}

	/**
	 * Returns the last announcement image in the ordered set where announcementId = &#63;.
	 *
	 * @param announcementId the announcement ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching announcement image, or <code>null</code> if a matching announcement image could not be found
	 */
	@Override
	public AnnouncementImage fetchByG_A_Last(long announcementId,
		OrderByComparator<AnnouncementImage> orderByComparator) {
		int count = countByG_A(announcementId);

		if (count == 0) {
			return null;
		}

		List<AnnouncementImage> list = findByG_A(announcementId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AnnouncementImage[] findByG_A_PrevAndNext(long announcementImageId,
		long announcementId,
		OrderByComparator<AnnouncementImage> orderByComparator)
		throws NoSuchAnnouncementImageException {
		AnnouncementImage announcementImage = findByPrimaryKey(announcementImageId);

		Session session = null;

		try {
			session = openSession();

			AnnouncementImage[] array = new AnnouncementImageImpl[3];

			array[0] = getByG_A_PrevAndNext(session, announcementImage,
					announcementId, orderByComparator, true);

			array[1] = announcementImage;

			array[2] = getByG_A_PrevAndNext(session, announcementImage,
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

	protected AnnouncementImage getByG_A_PrevAndNext(Session session,
		AnnouncementImage announcementImage, long announcementId,
		OrderByComparator<AnnouncementImage> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANNOUNCEMENTIMAGE_WHERE);

		query.append(_FINDER_COLUMN_G_A_ANNOUNCEMENTID_2);

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
			query.append(AnnouncementImageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(announcementId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(announcementImage);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnnouncementImage> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the announcement images where announcementId = &#63; from the database.
	 *
	 * @param announcementId the announcement ID
	 */
	@Override
	public void removeByG_A(long announcementId) {
		for (AnnouncementImage announcementImage : findByG_A(announcementId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(announcementImage);
		}
	}

	/**
	 * Returns the number of announcement images where announcementId = &#63;.
	 *
	 * @param announcementId the announcement ID
	 * @return the number of matching announcement images
	 */
	@Override
	public int countByG_A(long announcementId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_A;

		Object[] finderArgs = new Object[] { announcementId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ANNOUNCEMENTIMAGE_WHERE);

			query.append(_FINDER_COLUMN_G_A_ANNOUNCEMENTID_2);

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

	private static final String _FINDER_COLUMN_G_A_ANNOUNCEMENTID_2 = "announcementImage.announcementId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_A_O = new FinderPath(AnnouncementImageModelImpl.ENTITY_CACHE_ENABLED,
			AnnouncementImageModelImpl.FINDER_CACHE_ENABLED,
			AnnouncementImageImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByA_O",
			new String[] { Long.class.getName(), Integer.class.getName() },
			AnnouncementImageModelImpl.ANNOUNCEMENTID_COLUMN_BITMASK |
			AnnouncementImageModelImpl.ORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_A_O = new FinderPath(AnnouncementImageModelImpl.ENTITY_CACHE_ENABLED,
			AnnouncementImageModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByA_O",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns the announcement image where announcementId = &#63; and order = &#63; or throws a {@link NoSuchAnnouncementImageException} if it could not be found.
	 *
	 * @param announcementId the announcement ID
	 * @param order the order
	 * @return the matching announcement image
	 * @throws NoSuchAnnouncementImageException if a matching announcement image could not be found
	 */
	@Override
	public AnnouncementImage findByA_O(long announcementId, int order)
		throws NoSuchAnnouncementImageException {
		AnnouncementImage announcementImage = fetchByA_O(announcementId, order);

		if (announcementImage == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("announcementId=");
			msg.append(announcementId);

			msg.append(", order=");
			msg.append(order);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchAnnouncementImageException(msg.toString());
		}

		return announcementImage;
	}

	/**
	 * Returns the announcement image where announcementId = &#63; and order = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param announcementId the announcement ID
	 * @param order the order
	 * @return the matching announcement image, or <code>null</code> if a matching announcement image could not be found
	 */
	@Override
	public AnnouncementImage fetchByA_O(long announcementId, int order) {
		return fetchByA_O(announcementId, order, true);
	}

	/**
	 * Returns the announcement image where announcementId = &#63; and order = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param announcementId the announcement ID
	 * @param order the order
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching announcement image, or <code>null</code> if a matching announcement image could not be found
	 */
	@Override
	public AnnouncementImage fetchByA_O(long announcementId, int order,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { announcementId, order };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_A_O,
					finderArgs, this);
		}

		if (result instanceof AnnouncementImage) {
			AnnouncementImage announcementImage = (AnnouncementImage)result;

			if ((announcementId != announcementImage.getAnnouncementId()) ||
					(order != announcementImage.getOrder())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ANNOUNCEMENTIMAGE_WHERE);

			query.append(_FINDER_COLUMN_A_O_ANNOUNCEMENTID_2);

			query.append(_FINDER_COLUMN_A_O_ORDER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(announcementId);

				qPos.add(order);

				List<AnnouncementImage> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_A_O, finderArgs,
						list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"AnnouncementImagePersistenceImpl.fetchByA_O(long, int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					AnnouncementImage announcementImage = list.get(0);

					result = announcementImage;

					cacheResult(announcementImage);

					if ((announcementImage.getAnnouncementId() != announcementId) ||
							(announcementImage.getOrder() != order)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_A_O,
							finderArgs, announcementImage);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_A_O, finderArgs);

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
			return (AnnouncementImage)result;
		}
	}

	/**
	 * Removes the announcement image where announcementId = &#63; and order = &#63; from the database.
	 *
	 * @param announcementId the announcement ID
	 * @param order the order
	 * @return the announcement image that was removed
	 */
	@Override
	public AnnouncementImage removeByA_O(long announcementId, int order)
		throws NoSuchAnnouncementImageException {
		AnnouncementImage announcementImage = findByA_O(announcementId, order);

		return remove(announcementImage);
	}

	/**
	 * Returns the number of announcement images where announcementId = &#63; and order = &#63;.
	 *
	 * @param announcementId the announcement ID
	 * @param order the order
	 * @return the number of matching announcement images
	 */
	@Override
	public int countByA_O(long announcementId, int order) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_A_O;

		Object[] finderArgs = new Object[] { announcementId, order };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ANNOUNCEMENTIMAGE_WHERE);

			query.append(_FINDER_COLUMN_A_O_ANNOUNCEMENTID_2);

			query.append(_FINDER_COLUMN_A_O_ORDER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(announcementId);

				qPos.add(order);

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

	private static final String _FINDER_COLUMN_A_O_ANNOUNCEMENTID_2 = "announcementImage.announcementId = ? AND ";
	private static final String _FINDER_COLUMN_A_O_ORDER_2 = "announcementImage.order = ?";

	public AnnouncementImagePersistenceImpl() {
		setModelClass(AnnouncementImage.class);
	}

	/**
	 * Caches the announcement image in the entity cache if it is enabled.
	 *
	 * @param announcementImage the announcement image
	 */
	@Override
	public void cacheResult(AnnouncementImage announcementImage) {
		entityCache.putResult(AnnouncementImageModelImpl.ENTITY_CACHE_ENABLED,
			AnnouncementImageImpl.class, announcementImage.getPrimaryKey(),
			announcementImage);

		finderCache.putResult(FINDER_PATH_FETCH_BY_A_O,
			new Object[] {
				announcementImage.getAnnouncementId(),
				announcementImage.getOrder()
			}, announcementImage);

		announcementImage.resetOriginalValues();
	}

	/**
	 * Caches the announcement images in the entity cache if it is enabled.
	 *
	 * @param announcementImages the announcement images
	 */
	@Override
	public void cacheResult(List<AnnouncementImage> announcementImages) {
		for (AnnouncementImage announcementImage : announcementImages) {
			if (entityCache.getResult(
						AnnouncementImageModelImpl.ENTITY_CACHE_ENABLED,
						AnnouncementImageImpl.class,
						announcementImage.getPrimaryKey()) == null) {
				cacheResult(announcementImage);
			}
			else {
				announcementImage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all announcement images.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AnnouncementImageImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the announcement image.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AnnouncementImage announcementImage) {
		entityCache.removeResult(AnnouncementImageModelImpl.ENTITY_CACHE_ENABLED,
			AnnouncementImageImpl.class, announcementImage.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((AnnouncementImageModelImpl)announcementImage);
	}

	@Override
	public void clearCache(List<AnnouncementImage> announcementImages) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AnnouncementImage announcementImage : announcementImages) {
			entityCache.removeResult(AnnouncementImageModelImpl.ENTITY_CACHE_ENABLED,
				AnnouncementImageImpl.class, announcementImage.getPrimaryKey());

			clearUniqueFindersCache((AnnouncementImageModelImpl)announcementImage);
		}
	}

	protected void cacheUniqueFindersCache(
		AnnouncementImageModelImpl announcementImageModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					announcementImageModelImpl.getAnnouncementId(),
					announcementImageModelImpl.getOrder()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_A_O, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_A_O, args,
				announcementImageModelImpl);
		}
		else {
			if ((announcementImageModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_A_O.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						announcementImageModelImpl.getAnnouncementId(),
						announcementImageModelImpl.getOrder()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_A_O, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_A_O, args,
					announcementImageModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		AnnouncementImageModelImpl announcementImageModelImpl) {
		Object[] args = new Object[] {
				announcementImageModelImpl.getAnnouncementId(),
				announcementImageModelImpl.getOrder()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_A_O, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_A_O, args);

		if ((announcementImageModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_A_O.getColumnBitmask()) != 0) {
			args = new Object[] {
					announcementImageModelImpl.getOriginalAnnouncementId(),
					announcementImageModelImpl.getOriginalOrder()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_A_O, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_A_O, args);
		}
	}

	/**
	 * Creates a new announcement image with the primary key. Does not add the announcement image to the database.
	 *
	 * @param announcementImageId the primary key for the new announcement image
	 * @return the new announcement image
	 */
	@Override
	public AnnouncementImage create(long announcementImageId) {
		AnnouncementImage announcementImage = new AnnouncementImageImpl();

		announcementImage.setNew(true);
		announcementImage.setPrimaryKey(announcementImageId);

		announcementImage.setCompanyId(companyProvider.getCompanyId());

		return announcementImage;
	}

	/**
	 * Removes the announcement image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param announcementImageId the primary key of the announcement image
	 * @return the announcement image that was removed
	 * @throws NoSuchAnnouncementImageException if a announcement image with the primary key could not be found
	 */
	@Override
	public AnnouncementImage remove(long announcementImageId)
		throws NoSuchAnnouncementImageException {
		return remove((Serializable)announcementImageId);
	}

	/**
	 * Removes the announcement image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the announcement image
	 * @return the announcement image that was removed
	 * @throws NoSuchAnnouncementImageException if a announcement image with the primary key could not be found
	 */
	@Override
	public AnnouncementImage remove(Serializable primaryKey)
		throws NoSuchAnnouncementImageException {
		Session session = null;

		try {
			session = openSession();

			AnnouncementImage announcementImage = (AnnouncementImage)session.get(AnnouncementImageImpl.class,
					primaryKey);

			if (announcementImage == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnnouncementImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(announcementImage);
		}
		catch (NoSuchAnnouncementImageException nsee) {
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
	protected AnnouncementImage removeImpl(AnnouncementImage announcementImage) {
		announcementImage = toUnwrappedModel(announcementImage);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(announcementImage)) {
				announcementImage = (AnnouncementImage)session.get(AnnouncementImageImpl.class,
						announcementImage.getPrimaryKeyObj());
			}

			if (announcementImage != null) {
				session.delete(announcementImage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (announcementImage != null) {
			clearCache(announcementImage);
		}

		return announcementImage;
	}

	@Override
	public AnnouncementImage updateImpl(AnnouncementImage announcementImage) {
		announcementImage = toUnwrappedModel(announcementImage);

		boolean isNew = announcementImage.isNew();

		AnnouncementImageModelImpl announcementImageModelImpl = (AnnouncementImageModelImpl)announcementImage;

		Session session = null;

		try {
			session = openSession();

			if (announcementImage.isNew()) {
				session.save(announcementImage);

				announcementImage.setNew(false);
			}
			else {
				announcementImage = (AnnouncementImage)session.merge(announcementImage);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AnnouncementImageModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((announcementImageModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						announcementImageModelImpl.getOriginalAnnouncementId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_G_A, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A,
					args);

				args = new Object[] {
						announcementImageModelImpl.getAnnouncementId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_G_A, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A,
					args);
			}
		}

		entityCache.putResult(AnnouncementImageModelImpl.ENTITY_CACHE_ENABLED,
			AnnouncementImageImpl.class, announcementImage.getPrimaryKey(),
			announcementImage, false);

		clearUniqueFindersCache(announcementImageModelImpl);
		cacheUniqueFindersCache(announcementImageModelImpl, isNew);

		announcementImage.resetOriginalValues();

		return announcementImage;
	}

	protected AnnouncementImage toUnwrappedModel(
		AnnouncementImage announcementImage) {
		if (announcementImage instanceof AnnouncementImageImpl) {
			return announcementImage;
		}

		AnnouncementImageImpl announcementImageImpl = new AnnouncementImageImpl();

		announcementImageImpl.setNew(announcementImage.isNew());
		announcementImageImpl.setPrimaryKey(announcementImage.getPrimaryKey());

		announcementImageImpl.setAnnouncementImageId(announcementImage.getAnnouncementImageId());
		announcementImageImpl.setCompanyId(announcementImage.getCompanyId());
		announcementImageImpl.setGroupId(announcementImage.getGroupId());
		announcementImageImpl.setUserId(announcementImage.getUserId());
		announcementImageImpl.setAnnouncementId(announcementImage.getAnnouncementId());
		announcementImageImpl.setFileEntryId(announcementImage.getFileEntryId());
		announcementImageImpl.setDescription(announcementImage.getDescription());
		announcementImageImpl.setOrder(announcementImage.getOrder());

		return announcementImageImpl;
	}

	/**
	 * Returns the announcement image with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the announcement image
	 * @return the announcement image
	 * @throws NoSuchAnnouncementImageException if a announcement image with the primary key could not be found
	 */
	@Override
	public AnnouncementImage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAnnouncementImageException {
		AnnouncementImage announcementImage = fetchByPrimaryKey(primaryKey);

		if (announcementImage == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAnnouncementImageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return announcementImage;
	}

	/**
	 * Returns the announcement image with the primary key or throws a {@link NoSuchAnnouncementImageException} if it could not be found.
	 *
	 * @param announcementImageId the primary key of the announcement image
	 * @return the announcement image
	 * @throws NoSuchAnnouncementImageException if a announcement image with the primary key could not be found
	 */
	@Override
	public AnnouncementImage findByPrimaryKey(long announcementImageId)
		throws NoSuchAnnouncementImageException {
		return findByPrimaryKey((Serializable)announcementImageId);
	}

	/**
	 * Returns the announcement image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the announcement image
	 * @return the announcement image, or <code>null</code> if a announcement image with the primary key could not be found
	 */
	@Override
	public AnnouncementImage fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AnnouncementImageModelImpl.ENTITY_CACHE_ENABLED,
				AnnouncementImageImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AnnouncementImage announcementImage = (AnnouncementImage)serializable;

		if (announcementImage == null) {
			Session session = null;

			try {
				session = openSession();

				announcementImage = (AnnouncementImage)session.get(AnnouncementImageImpl.class,
						primaryKey);

				if (announcementImage != null) {
					cacheResult(announcementImage);
				}
				else {
					entityCache.putResult(AnnouncementImageModelImpl.ENTITY_CACHE_ENABLED,
						AnnouncementImageImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AnnouncementImageModelImpl.ENTITY_CACHE_ENABLED,
					AnnouncementImageImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return announcementImage;
	}

	/**
	 * Returns the announcement image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param announcementImageId the primary key of the announcement image
	 * @return the announcement image, or <code>null</code> if a announcement image with the primary key could not be found
	 */
	@Override
	public AnnouncementImage fetchByPrimaryKey(long announcementImageId) {
		return fetchByPrimaryKey((Serializable)announcementImageId);
	}

	@Override
	public Map<Serializable, AnnouncementImage> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AnnouncementImage> map = new HashMap<Serializable, AnnouncementImage>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AnnouncementImage announcementImage = fetchByPrimaryKey(primaryKey);

			if (announcementImage != null) {
				map.put(primaryKey, announcementImage);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AnnouncementImageModelImpl.ENTITY_CACHE_ENABLED,
					AnnouncementImageImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AnnouncementImage)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ANNOUNCEMENTIMAGE_WHERE_PKS_IN);

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

			for (AnnouncementImage announcementImage : (List<AnnouncementImage>)q.list()) {
				map.put(announcementImage.getPrimaryKeyObj(), announcementImage);

				cacheResult(announcementImage);

				uncachedPrimaryKeys.remove(announcementImage.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AnnouncementImageModelImpl.ENTITY_CACHE_ENABLED,
					AnnouncementImageImpl.class, primaryKey, nullModel);
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
	 * Returns all the announcement images.
	 *
	 * @return the announcement images
	 */
	@Override
	public List<AnnouncementImage> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AnnouncementImage> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<AnnouncementImage> findAll(int start, int end,
		OrderByComparator<AnnouncementImage> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<AnnouncementImage> findAll(int start, int end,
		OrderByComparator<AnnouncementImage> orderByComparator,
		boolean retrieveFromCache) {
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

		List<AnnouncementImage> list = null;

		if (retrieveFromCache) {
			list = (List<AnnouncementImage>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ANNOUNCEMENTIMAGE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ANNOUNCEMENTIMAGE;

				if (pagination) {
					sql = sql.concat(AnnouncementImageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AnnouncementImage>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnnouncementImage>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the announcement images from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AnnouncementImage announcementImage : findAll()) {
			remove(announcementImage);
		}
	}

	/**
	 * Returns the number of announcement images.
	 *
	 * @return the number of announcement images
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ANNOUNCEMENTIMAGE);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AnnouncementImageModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the announcement image persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AnnouncementImageImpl.class.getName());
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
	private static final String _SQL_SELECT_ANNOUNCEMENTIMAGE = "SELECT announcementImage FROM AnnouncementImage announcementImage";
	private static final String _SQL_SELECT_ANNOUNCEMENTIMAGE_WHERE_PKS_IN = "SELECT announcementImage FROM AnnouncementImage announcementImage WHERE announcementImageId IN (";
	private static final String _SQL_SELECT_ANNOUNCEMENTIMAGE_WHERE = "SELECT announcementImage FROM AnnouncementImage announcementImage WHERE ";
	private static final String _SQL_COUNT_ANNOUNCEMENTIMAGE = "SELECT COUNT(announcementImage) FROM AnnouncementImage announcementImage";
	private static final String _SQL_COUNT_ANNOUNCEMENTIMAGE_WHERE = "SELECT COUNT(announcementImage) FROM AnnouncementImage announcementImage WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "announcementImage.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AnnouncementImage exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AnnouncementImage exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AnnouncementImagePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"order"
			});
}