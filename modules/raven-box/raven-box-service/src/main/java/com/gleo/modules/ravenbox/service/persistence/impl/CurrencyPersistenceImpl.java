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

package com.gleo.modules.ravenbox.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.gleo.modules.ravenbox.exception.NoSuchCurrencyException;
import com.gleo.modules.ravenbox.model.Currency;
import com.gleo.modules.ravenbox.model.impl.CurrencyImpl;
import com.gleo.modules.ravenbox.model.impl.CurrencyModelImpl;
import com.gleo.modules.ravenbox.service.persistence.CurrencyPersistence;

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
 * The persistence implementation for the currency service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Guillaume Lenoir
 * @see CurrencyPersistence
 * @see com.gleo.modules.ravenbox.service.persistence.CurrencyUtil
 * @generated
 */
@ProviderType
public class CurrencyPersistenceImpl extends BasePersistenceImpl<Currency>
	implements CurrencyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CurrencyUtil} to access the currency persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CurrencyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CurrencyModelImpl.ENTITY_CACHE_ENABLED,
			CurrencyModelImpl.FINDER_CACHE_ENABLED, CurrencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CurrencyModelImpl.ENTITY_CACHE_ENABLED,
			CurrencyModelImpl.FINDER_CACHE_ENABLED, CurrencyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CurrencyModelImpl.ENTITY_CACHE_ENABLED,
			CurrencyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_COUNTRYID = new FinderPath(CurrencyModelImpl.ENTITY_CACHE_ENABLED,
			CurrencyModelImpl.FINDER_CACHE_ENABLED, CurrencyImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCountryId",
			new String[] { Long.class.getName() },
			CurrencyModelImpl.COUNTRYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COUNTRYID = new FinderPath(CurrencyModelImpl.ENTITY_CACHE_ENABLED,
			CurrencyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCountryId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the currency where countryId = &#63; or throws a {@link NoSuchCurrencyException} if it could not be found.
	 *
	 * @param countryId the country ID
	 * @return the matching currency
	 * @throws NoSuchCurrencyException if a matching currency could not be found
	 */
	@Override
	public Currency findByCountryId(long countryId)
		throws NoSuchCurrencyException {
		Currency currency = fetchByCountryId(countryId);

		if (currency == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("countryId=");
			msg.append(countryId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchCurrencyException(msg.toString());
		}

		return currency;
	}

	/**
	 * Returns the currency where countryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param countryId the country ID
	 * @return the matching currency, or <code>null</code> if a matching currency could not be found
	 */
	@Override
	public Currency fetchByCountryId(long countryId) {
		return fetchByCountryId(countryId, true);
	}

	/**
	 * Returns the currency where countryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param countryId the country ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching currency, or <code>null</code> if a matching currency could not be found
	 */
	@Override
	public Currency fetchByCountryId(long countryId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { countryId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_COUNTRYID,
					finderArgs, this);
		}

		if (result instanceof Currency) {
			Currency currency = (Currency)result;

			if ((countryId != currency.getCountryId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CURRENCY_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYID_COUNTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countryId);

				List<Currency> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_COUNTRYID,
						finderArgs, list);
				}
				else {
					Currency currency = list.get(0);

					result = currency;

					cacheResult(currency);

					if ((currency.getCountryId() != countryId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_COUNTRYID,
							finderArgs, currency);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_COUNTRYID,
					finderArgs);

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
			return (Currency)result;
		}
	}

	/**
	 * Removes the currency where countryId = &#63; from the database.
	 *
	 * @param countryId the country ID
	 * @return the currency that was removed
	 */
	@Override
	public Currency removeByCountryId(long countryId)
		throws NoSuchCurrencyException {
		Currency currency = findByCountryId(countryId);

		return remove(currency);
	}

	/**
	 * Returns the number of currencies where countryId = &#63;.
	 *
	 * @param countryId the country ID
	 * @return the number of matching currencies
	 */
	@Override
	public int countByCountryId(long countryId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COUNTRYID;

		Object[] finderArgs = new Object[] { countryId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CURRENCY_WHERE);

			query.append(_FINDER_COLUMN_COUNTRYID_COUNTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(countryId);

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

	private static final String _FINDER_COLUMN_COUNTRYID_COUNTRYID_2 = "currency.countryId = ?";

	public CurrencyPersistenceImpl() {
		setModelClass(Currency.class);
	}

	/**
	 * Caches the currency in the entity cache if it is enabled.
	 *
	 * @param currency the currency
	 */
	@Override
	public void cacheResult(Currency currency) {
		entityCache.putResult(CurrencyModelImpl.ENTITY_CACHE_ENABLED,
			CurrencyImpl.class, currency.getPrimaryKey(), currency);

		finderCache.putResult(FINDER_PATH_FETCH_BY_COUNTRYID,
			new Object[] { currency.getCountryId() }, currency);

		currency.resetOriginalValues();
	}

	/**
	 * Caches the currencies in the entity cache if it is enabled.
	 *
	 * @param currencies the currencies
	 */
	@Override
	public void cacheResult(List<Currency> currencies) {
		for (Currency currency : currencies) {
			if (entityCache.getResult(CurrencyModelImpl.ENTITY_CACHE_ENABLED,
						CurrencyImpl.class, currency.getPrimaryKey()) == null) {
				cacheResult(currency);
			}
			else {
				currency.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all currencies.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CurrencyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the currency.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Currency currency) {
		entityCache.removeResult(CurrencyModelImpl.ENTITY_CACHE_ENABLED,
			CurrencyImpl.class, currency.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((CurrencyModelImpl)currency);
	}

	@Override
	public void clearCache(List<Currency> currencies) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Currency currency : currencies) {
			entityCache.removeResult(CurrencyModelImpl.ENTITY_CACHE_ENABLED,
				CurrencyImpl.class, currency.getPrimaryKey());

			clearUniqueFindersCache((CurrencyModelImpl)currency);
		}
	}

	protected void cacheUniqueFindersCache(
		CurrencyModelImpl currencyModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] { currencyModelImpl.getCountryId() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_COUNTRYID, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_COUNTRYID, args,
				currencyModelImpl);
		}
		else {
			if ((currencyModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_COUNTRYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { currencyModelImpl.getCountryId() };

				finderCache.putResult(FINDER_PATH_COUNT_BY_COUNTRYID, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_COUNTRYID, args,
					currencyModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(CurrencyModelImpl currencyModelImpl) {
		Object[] args = new Object[] { currencyModelImpl.getCountryId() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_COUNTRYID, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_COUNTRYID, args);

		if ((currencyModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_COUNTRYID.getColumnBitmask()) != 0) {
			args = new Object[] { currencyModelImpl.getOriginalCountryId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_COUNTRYID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_COUNTRYID, args);
		}
	}

	/**
	 * Creates a new currency with the primary key. Does not add the currency to the database.
	 *
	 * @param currencyId the primary key for the new currency
	 * @return the new currency
	 */
	@Override
	public Currency create(long currencyId) {
		Currency currency = new CurrencyImpl();

		currency.setNew(true);
		currency.setPrimaryKey(currencyId);

		currency.setCompanyId(companyProvider.getCompanyId());

		return currency;
	}

	/**
	 * Removes the currency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param currencyId the primary key of the currency
	 * @return the currency that was removed
	 * @throws NoSuchCurrencyException if a currency with the primary key could not be found
	 */
	@Override
	public Currency remove(long currencyId) throws NoSuchCurrencyException {
		return remove((Serializable)currencyId);
	}

	/**
	 * Removes the currency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the currency
	 * @return the currency that was removed
	 * @throws NoSuchCurrencyException if a currency with the primary key could not be found
	 */
	@Override
	public Currency remove(Serializable primaryKey)
		throws NoSuchCurrencyException {
		Session session = null;

		try {
			session = openSession();

			Currency currency = (Currency)session.get(CurrencyImpl.class,
					primaryKey);

			if (currency == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCurrencyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(currency);
		}
		catch (NoSuchCurrencyException nsee) {
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
	protected Currency removeImpl(Currency currency) {
		currency = toUnwrappedModel(currency);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(currency)) {
				currency = (Currency)session.get(CurrencyImpl.class,
						currency.getPrimaryKeyObj());
			}

			if (currency != null) {
				session.delete(currency);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (currency != null) {
			clearCache(currency);
		}

		return currency;
	}

	@Override
	public Currency updateImpl(Currency currency) {
		currency = toUnwrappedModel(currency);

		boolean isNew = currency.isNew();

		CurrencyModelImpl currencyModelImpl = (CurrencyModelImpl)currency;

		Session session = null;

		try {
			session = openSession();

			if (currency.isNew()) {
				session.save(currency);

				currency.setNew(false);
			}
			else {
				currency = (Currency)session.merge(currency);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CurrencyModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(CurrencyModelImpl.ENTITY_CACHE_ENABLED,
			CurrencyImpl.class, currency.getPrimaryKey(), currency, false);

		clearUniqueFindersCache(currencyModelImpl);
		cacheUniqueFindersCache(currencyModelImpl, isNew);

		currency.resetOriginalValues();

		return currency;
	}

	protected Currency toUnwrappedModel(Currency currency) {
		if (currency instanceof CurrencyImpl) {
			return currency;
		}

		CurrencyImpl currencyImpl = new CurrencyImpl();

		currencyImpl.setNew(currency.isNew());
		currencyImpl.setPrimaryKey(currency.getPrimaryKey());

		currencyImpl.setCurrencyId(currency.getCurrencyId());
		currencyImpl.setCompanyId(currency.getCompanyId());
		currencyImpl.setLabel(currency.getLabel());
		currencyImpl.setSymbol(currency.getSymbol());
		currencyImpl.setOrder(currency.getOrder());
		currencyImpl.setCountryId(currency.getCountryId());
		currencyImpl.setRate(currency.getRate());

		return currencyImpl;
	}

	/**
	 * Returns the currency with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the currency
	 * @return the currency
	 * @throws NoSuchCurrencyException if a currency with the primary key could not be found
	 */
	@Override
	public Currency findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCurrencyException {
		Currency currency = fetchByPrimaryKey(primaryKey);

		if (currency == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCurrencyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return currency;
	}

	/**
	 * Returns the currency with the primary key or throws a {@link NoSuchCurrencyException} if it could not be found.
	 *
	 * @param currencyId the primary key of the currency
	 * @return the currency
	 * @throws NoSuchCurrencyException if a currency with the primary key could not be found
	 */
	@Override
	public Currency findByPrimaryKey(long currencyId)
		throws NoSuchCurrencyException {
		return findByPrimaryKey((Serializable)currencyId);
	}

	/**
	 * Returns the currency with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the currency
	 * @return the currency, or <code>null</code> if a currency with the primary key could not be found
	 */
	@Override
	public Currency fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CurrencyModelImpl.ENTITY_CACHE_ENABLED,
				CurrencyImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Currency currency = (Currency)serializable;

		if (currency == null) {
			Session session = null;

			try {
				session = openSession();

				currency = (Currency)session.get(CurrencyImpl.class, primaryKey);

				if (currency != null) {
					cacheResult(currency);
				}
				else {
					entityCache.putResult(CurrencyModelImpl.ENTITY_CACHE_ENABLED,
						CurrencyImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CurrencyModelImpl.ENTITY_CACHE_ENABLED,
					CurrencyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return currency;
	}

	/**
	 * Returns the currency with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param currencyId the primary key of the currency
	 * @return the currency, or <code>null</code> if a currency with the primary key could not be found
	 */
	@Override
	public Currency fetchByPrimaryKey(long currencyId) {
		return fetchByPrimaryKey((Serializable)currencyId);
	}

	@Override
	public Map<Serializable, Currency> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Currency> map = new HashMap<Serializable, Currency>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Currency currency = fetchByPrimaryKey(primaryKey);

			if (currency != null) {
				map.put(primaryKey, currency);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CurrencyModelImpl.ENTITY_CACHE_ENABLED,
					CurrencyImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Currency)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CURRENCY_WHERE_PKS_IN);

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

			for (Currency currency : (List<Currency>)q.list()) {
				map.put(currency.getPrimaryKeyObj(), currency);

				cacheResult(currency);

				uncachedPrimaryKeys.remove(currency.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CurrencyModelImpl.ENTITY_CACHE_ENABLED,
					CurrencyImpl.class, primaryKey, nullModel);
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
	 * Returns all the currencies.
	 *
	 * @return the currencies
	 */
	@Override
	public List<Currency> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the currencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CurrencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of currencies
	 * @param end the upper bound of the range of currencies (not inclusive)
	 * @return the range of currencies
	 */
	@Override
	public List<Currency> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the currencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CurrencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of currencies
	 * @param end the upper bound of the range of currencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of currencies
	 */
	@Override
	public List<Currency> findAll(int start, int end,
		OrderByComparator<Currency> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the currencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CurrencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of currencies
	 * @param end the upper bound of the range of currencies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of currencies
	 */
	@Override
	public List<Currency> findAll(int start, int end,
		OrderByComparator<Currency> orderByComparator, boolean retrieveFromCache) {
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

		List<Currency> list = null;

		if (retrieveFromCache) {
			list = (List<Currency>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CURRENCY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CURRENCY;

				if (pagination) {
					sql = sql.concat(CurrencyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Currency>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Currency>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the currencies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Currency currency : findAll()) {
			remove(currency);
		}
	}

	/**
	 * Returns the number of currencies.
	 *
	 * @return the number of currencies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CURRENCY);

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
		return CurrencyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the currency persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(CurrencyImpl.class.getName());
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
	private static final String _SQL_SELECT_CURRENCY = "SELECT currency FROM Currency currency";
	private static final String _SQL_SELECT_CURRENCY_WHERE_PKS_IN = "SELECT currency FROM Currency currency WHERE currencyId IN (";
	private static final String _SQL_SELECT_CURRENCY_WHERE = "SELECT currency FROM Currency currency WHERE ";
	private static final String _SQL_COUNT_CURRENCY = "SELECT COUNT(currency) FROM Currency currency";
	private static final String _SQL_COUNT_CURRENCY_WHERE = "SELECT COUNT(currency) FROM Currency currency WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "currency.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Currency exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Currency exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CurrencyPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"order"
			});
}