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

package com.gleo.plugins.hexiagon.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Currency}.
 * </p>
 *
 * @author guillaumelenoir
 * @see Currency
 * @generated
 */
@ProviderType
public class CurrencyWrapper implements Currency, ModelWrapper<Currency> {
	public CurrencyWrapper(Currency currency) {
		_currency = currency;
	}

	@Override
	public Class<?> getModelClass() {
		return Currency.class;
	}

	@Override
	public String getModelClassName() {
		return Currency.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("currencyId", getCurrencyId());
		attributes.put("companyId", getCompanyId());
		attributes.put("label", getLabel());
		attributes.put("symbol", getSymbol());
		attributes.put("order", getOrder());
		attributes.put("rate", getRate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long currencyId = (Long)attributes.get("currencyId");

		if (currencyId != null) {
			setCurrencyId(currencyId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String label = (String)attributes.get("label");

		if (label != null) {
			setLabel(label);
		}

		String symbol = (String)attributes.get("symbol");

		if (symbol != null) {
			setSymbol(symbol);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		Long rate = (Long)attributes.get("rate");

		if (rate != null) {
			setRate(rate);
		}
	}

	@Override
	public Currency toEscapedModel() {
		return new CurrencyWrapper(_currency.toEscapedModel());
	}

	@Override
	public Currency toUnescapedModel() {
		return new CurrencyWrapper(_currency.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _currency.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _currency.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _currency.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _currency.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Currency> toCacheModel() {
		return _currency.toCacheModel();
	}

	@Override
	public int compareTo(Currency currency) {
		return _currency.compareTo(currency);
	}

	/**
	* Returns the order of this currency.
	*
	* @return the order of this currency
	*/
	@Override
	public int getOrder() {
		return _currency.getOrder();
	}

	@Override
	public int hashCode() {
		return _currency.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _currency.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new CurrencyWrapper((Currency)_currency.clone());
	}

	/**
	* Returns the label of this currency.
	*
	* @return the label of this currency
	*/
	@Override
	public java.lang.String getLabel() {
		return _currency.getLabel();
	}

	/**
	* Returns the symbol of this currency.
	*
	* @return the symbol of this currency
	*/
	@Override
	public java.lang.String getSymbol() {
		return _currency.getSymbol();
	}

	@Override
	public java.lang.String toString() {
		return _currency.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _currency.toXmlString();
	}

	/**
	* Returns the company ID of this currency.
	*
	* @return the company ID of this currency
	*/
	@Override
	public long getCompanyId() {
		return _currency.getCompanyId();
	}

	/**
	* Returns the currency ID of this currency.
	*
	* @return the currency ID of this currency
	*/
	@Override
	public long getCurrencyId() {
		return _currency.getCurrencyId();
	}

	/**
	* Returns the primary key of this currency.
	*
	* @return the primary key of this currency
	*/
	@Override
	public long getPrimaryKey() {
		return _currency.getPrimaryKey();
	}

	/**
	* Returns the rate of this currency.
	*
	* @return the rate of this currency
	*/
	@Override
	public long getRate() {
		return _currency.getRate();
	}

	@Override
	public void persist() {
		_currency.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_currency.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this currency.
	*
	* @param companyId the company ID of this currency
	*/
	@Override
	public void setCompanyId(long companyId) {
		_currency.setCompanyId(companyId);
	}

	/**
	* Sets the currency ID of this currency.
	*
	* @param currencyId the currency ID of this currency
	*/
	@Override
	public void setCurrencyId(long currencyId) {
		_currency.setCurrencyId(currencyId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_currency.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_currency.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_currency.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the label of this currency.
	*
	* @param label the label of this currency
	*/
	@Override
	public void setLabel(java.lang.String label) {
		_currency.setLabel(label);
	}

	@Override
	public void setNew(boolean n) {
		_currency.setNew(n);
	}

	/**
	* Sets the order of this currency.
	*
	* @param order the order of this currency
	*/
	@Override
	public void setOrder(int order) {
		_currency.setOrder(order);
	}

	/**
	* Sets the primary key of this currency.
	*
	* @param primaryKey the primary key of this currency
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_currency.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_currency.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the rate of this currency.
	*
	* @param rate the rate of this currency
	*/
	@Override
	public void setRate(long rate) {
		_currency.setRate(rate);
	}

	/**
	* Sets the symbol of this currency.
	*
	* @param symbol the symbol of this currency
	*/
	@Override
	public void setSymbol(java.lang.String symbol) {
		_currency.setSymbol(symbol);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CurrencyWrapper)) {
			return false;
		}

		CurrencyWrapper currencyWrapper = (CurrencyWrapper)obj;

		if (Objects.equals(_currency, currencyWrapper._currency)) {
			return true;
		}

		return false;
	}

	@Override
	public Currency getWrappedModel() {
		return _currency;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _currency.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _currency.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_currency.resetOriginalValues();
	}

	private final Currency _currency;
}