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

import com.gleo.plugins.hexiagon.model.Currency;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the currency service. This utility wraps {@link com.gleo.plugins.hexiagon.service.persistence.impl.CurrencyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author guillaumelenoir
 * @see CurrencyPersistence
 * @see com.gleo.plugins.hexiagon.service.persistence.impl.CurrencyPersistenceImpl
 * @generated
 */
@ProviderType
public class CurrencyUtil {
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
	public static void clearCache(Currency currency) {
		getPersistence().clearCache(currency);
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
	public static List<Currency> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Currency> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Currency> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Currency> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Currency update(Currency currency) {
		return getPersistence().update(currency);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Currency update(Currency currency,
		ServiceContext serviceContext) {
		return getPersistence().update(currency, serviceContext);
	}

	/**
	* Returns the currency where countryId = &#63; or throws a {@link NoSuchCurrencyException} if it could not be found.
	*
	* @param countryId the country ID
	* @return the matching currency
	* @throws NoSuchCurrencyException if a matching currency could not be found
	*/
	public static Currency findByCountryId(long countryId)
		throws com.gleo.plugins.hexiagon.exception.NoSuchCurrencyException {
		return getPersistence().findByCountryId(countryId);
	}

	/**
	* Returns the currency where countryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param countryId the country ID
	* @return the matching currency, or <code>null</code> if a matching currency could not be found
	*/
	public static Currency fetchByCountryId(long countryId) {
		return getPersistence().fetchByCountryId(countryId);
	}

	/**
	* Returns the currency where countryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param countryId the country ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching currency, or <code>null</code> if a matching currency could not be found
	*/
	public static Currency fetchByCountryId(long countryId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByCountryId(countryId, retrieveFromCache);
	}

	/**
	* Removes the currency where countryId = &#63; from the database.
	*
	* @param countryId the country ID
	* @return the currency that was removed
	*/
	public static Currency removeByCountryId(long countryId)
		throws com.gleo.plugins.hexiagon.exception.NoSuchCurrencyException {
		return getPersistence().removeByCountryId(countryId);
	}

	/**
	* Returns the number of currencies where countryId = &#63;.
	*
	* @param countryId the country ID
	* @return the number of matching currencies
	*/
	public static int countByCountryId(long countryId) {
		return getPersistence().countByCountryId(countryId);
	}

	/**
	* Caches the currency in the entity cache if it is enabled.
	*
	* @param currency the currency
	*/
	public static void cacheResult(Currency currency) {
		getPersistence().cacheResult(currency);
	}

	/**
	* Caches the currencies in the entity cache if it is enabled.
	*
	* @param currencies the currencies
	*/
	public static void cacheResult(List<Currency> currencies) {
		getPersistence().cacheResult(currencies);
	}

	/**
	* Creates a new currency with the primary key. Does not add the currency to the database.
	*
	* @param currencyId the primary key for the new currency
	* @return the new currency
	*/
	public static Currency create(long currencyId) {
		return getPersistence().create(currencyId);
	}

	/**
	* Removes the currency with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param currencyId the primary key of the currency
	* @return the currency that was removed
	* @throws NoSuchCurrencyException if a currency with the primary key could not be found
	*/
	public static Currency remove(long currencyId)
		throws com.gleo.plugins.hexiagon.exception.NoSuchCurrencyException {
		return getPersistence().remove(currencyId);
	}

	public static Currency updateImpl(Currency currency) {
		return getPersistence().updateImpl(currency);
	}

	/**
	* Returns the currency with the primary key or throws a {@link NoSuchCurrencyException} if it could not be found.
	*
	* @param currencyId the primary key of the currency
	* @return the currency
	* @throws NoSuchCurrencyException if a currency with the primary key could not be found
	*/
	public static Currency findByPrimaryKey(long currencyId)
		throws com.gleo.plugins.hexiagon.exception.NoSuchCurrencyException {
		return getPersistence().findByPrimaryKey(currencyId);
	}

	/**
	* Returns the currency with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param currencyId the primary key of the currency
	* @return the currency, or <code>null</code> if a currency with the primary key could not be found
	*/
	public static Currency fetchByPrimaryKey(long currencyId) {
		return getPersistence().fetchByPrimaryKey(currencyId);
	}

	public static java.util.Map<java.io.Serializable, Currency> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the currencies.
	*
	* @return the currencies
	*/
	public static List<Currency> findAll() {
		return getPersistence().findAll();
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
	public static List<Currency> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Currency> findAll(int start, int end,
		OrderByComparator<Currency> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Currency> findAll(int start, int end,
		OrderByComparator<Currency> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the currencies from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of currencies.
	*
	* @return the number of currencies
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static CurrencyPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CurrencyPersistence, CurrencyPersistence> _serviceTracker =
		ServiceTrackerFactory.open(CurrencyPersistence.class);
}