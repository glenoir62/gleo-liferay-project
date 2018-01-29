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

import com.gleo.plugins.ravenbox.exception.NoSuchCurrencyException;
import com.gleo.plugins.ravenbox.model.Currency;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the currency service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Guillaume Lenoir
 * @see com.gleo.plugins.ravenbox.service.persistence.impl.CurrencyPersistenceImpl
 * @see CurrencyUtil
 * @generated
 */
@ProviderType
public interface CurrencyPersistence extends BasePersistence<Currency> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CurrencyUtil} to access the currency persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the currency where countryId = &#63; or throws a {@link NoSuchCurrencyException} if it could not be found.
	*
	* @param countryId the country ID
	* @return the matching currency
	* @throws NoSuchCurrencyException if a matching currency could not be found
	*/
	public Currency findByCountryId(long countryId)
		throws NoSuchCurrencyException;

	/**
	* Returns the currency where countryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param countryId the country ID
	* @return the matching currency, or <code>null</code> if a matching currency could not be found
	*/
	public Currency fetchByCountryId(long countryId);

	/**
	* Returns the currency where countryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param countryId the country ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching currency, or <code>null</code> if a matching currency could not be found
	*/
	public Currency fetchByCountryId(long countryId, boolean retrieveFromCache);

	/**
	* Removes the currency where countryId = &#63; from the database.
	*
	* @param countryId the country ID
	* @return the currency that was removed
	*/
	public Currency removeByCountryId(long countryId)
		throws NoSuchCurrencyException;

	/**
	* Returns the number of currencies where countryId = &#63;.
	*
	* @param countryId the country ID
	* @return the number of matching currencies
	*/
	public int countByCountryId(long countryId);

	/**
	* Caches the currency in the entity cache if it is enabled.
	*
	* @param currency the currency
	*/
	public void cacheResult(Currency currency);

	/**
	* Caches the currencies in the entity cache if it is enabled.
	*
	* @param currencies the currencies
	*/
	public void cacheResult(java.util.List<Currency> currencies);

	/**
	* Creates a new currency with the primary key. Does not add the currency to the database.
	*
	* @param currencyId the primary key for the new currency
	* @return the new currency
	*/
	public Currency create(long currencyId);

	/**
	* Removes the currency with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param currencyId the primary key of the currency
	* @return the currency that was removed
	* @throws NoSuchCurrencyException if a currency with the primary key could not be found
	*/
	public Currency remove(long currencyId) throws NoSuchCurrencyException;

	public Currency updateImpl(Currency currency);

	/**
	* Returns the currency with the primary key or throws a {@link NoSuchCurrencyException} if it could not be found.
	*
	* @param currencyId the primary key of the currency
	* @return the currency
	* @throws NoSuchCurrencyException if a currency with the primary key could not be found
	*/
	public Currency findByPrimaryKey(long currencyId)
		throws NoSuchCurrencyException;

	/**
	* Returns the currency with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param currencyId the primary key of the currency
	* @return the currency, or <code>null</code> if a currency with the primary key could not be found
	*/
	public Currency fetchByPrimaryKey(long currencyId);

	@Override
	public java.util.Map<java.io.Serializable, Currency> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the currencies.
	*
	* @return the currencies
	*/
	public java.util.List<Currency> findAll();

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
	public java.util.List<Currency> findAll(int start, int end);

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
	public java.util.List<Currency> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Currency> orderByComparator);

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
	public java.util.List<Currency> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Currency> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the currencies from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of currencies.
	*
	* @return the number of currencies
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}