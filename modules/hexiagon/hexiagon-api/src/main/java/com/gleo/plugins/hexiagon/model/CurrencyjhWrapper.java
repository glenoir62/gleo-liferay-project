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
 * This class is a wrapper for {@link Currencyjh}.
 * </p>
 *
 * @author guillaumelenoir
 * @see Currencyjh
 * @generated
 */
@ProviderType
public class CurrencyjhWrapper implements Currencyjh, ModelWrapper<Currencyjh> {
	public CurrencyjhWrapper(Currencyjh currencyjh) {
		_currencyjh = currencyjh;
	}

	@Override
	public Class<?> getModelClass() {
		return Currencyjh.class;
	}

	@Override
	public String getModelClassName() {
		return Currencyjh.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("currencyId", getCurrencyId());
		attributes.put("companyId", getCompanyId());
		attributes.put("label", getLabel());
		attributes.put("symbol", getSymbol());
		attributes.put("order", getOrder());
		attributes.put("countryId", getCountryId());
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

		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		Long rate = (Long)attributes.get("rate");

		if (rate != null) {
			setRate(rate);
		}
	}

	@Override
	public Currencyjh toEscapedModel() {
		return new CurrencyjhWrapper(_currencyjh.toEscapedModel());
	}

	@Override
	public Currencyjh toUnescapedModel() {
		return new CurrencyjhWrapper(_currencyjh.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _currencyjh.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _currencyjh.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _currencyjh.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _currencyjh.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Currencyjh> toCacheModel() {
		return _currencyjh.toCacheModel();
	}

	@Override
	public int compareTo(Currencyjh currencyjh) {
		return _currencyjh.compareTo(currencyjh);
	}

	/**
	* Returns the order of this currencyjh.
	*
	* @return the order of this currencyjh
	*/
	@Override
	public int getOrder() {
		return _currencyjh.getOrder();
	}

	@Override
	public int hashCode() {
		return _currencyjh.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _currencyjh.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new CurrencyjhWrapper((Currencyjh)_currencyjh.clone());
	}

	/**
	* Returns the label of this currencyjh.
	*
	* @return the label of this currencyjh
	*/
	@Override
	public java.lang.String getLabel() {
		return _currencyjh.getLabel();
	}

	/**
	* Returns the symbol of this currencyjh.
	*
	* @return the symbol of this currencyjh
	*/
	@Override
	public java.lang.String getSymbol() {
		return _currencyjh.getSymbol();
	}

	@Override
	public java.lang.String toString() {
		return _currencyjh.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _currencyjh.toXmlString();
	}

	/**
	* Returns the company ID of this currencyjh.
	*
	* @return the company ID of this currencyjh
	*/
	@Override
	public long getCompanyId() {
		return _currencyjh.getCompanyId();
	}

	/**
	* Returns the country ID of this currencyjh.
	*
	* @return the country ID of this currencyjh
	*/
	@Override
	public long getCountryId() {
		return _currencyjh.getCountryId();
	}

	/**
	* Returns the currency ID of this currencyjh.
	*
	* @return the currency ID of this currencyjh
	*/
	@Override
	public long getCurrencyId() {
		return _currencyjh.getCurrencyId();
	}

	/**
	* Returns the primary key of this currencyjh.
	*
	* @return the primary key of this currencyjh
	*/
	@Override
	public long getPrimaryKey() {
		return _currencyjh.getPrimaryKey();
	}

	/**
	* Returns the rate of this currencyjh.
	*
	* @return the rate of this currencyjh
	*/
	@Override
	public long getRate() {
		return _currencyjh.getRate();
	}

	@Override
	public void persist() {
		_currencyjh.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_currencyjh.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this currencyjh.
	*
	* @param companyId the company ID of this currencyjh
	*/
	@Override
	public void setCompanyId(long companyId) {
		_currencyjh.setCompanyId(companyId);
	}

	/**
	* Sets the country ID of this currencyjh.
	*
	* @param countryId the country ID of this currencyjh
	*/
	@Override
	public void setCountryId(long countryId) {
		_currencyjh.setCountryId(countryId);
	}

	/**
	* Sets the currency ID of this currencyjh.
	*
	* @param currencyId the currency ID of this currencyjh
	*/
	@Override
	public void setCurrencyId(long currencyId) {
		_currencyjh.setCurrencyId(currencyId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_currencyjh.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_currencyjh.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_currencyjh.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the label of this currencyjh.
	*
	* @param label the label of this currencyjh
	*/
	@Override
	public void setLabel(java.lang.String label) {
		_currencyjh.setLabel(label);
	}

	@Override
	public void setNew(boolean n) {
		_currencyjh.setNew(n);
	}

	/**
	* Sets the order of this currencyjh.
	*
	* @param order the order of this currencyjh
	*/
	@Override
	public void setOrder(int order) {
		_currencyjh.setOrder(order);
	}

	/**
	* Sets the primary key of this currencyjh.
	*
	* @param primaryKey the primary key of this currencyjh
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_currencyjh.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_currencyjh.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the rate of this currencyjh.
	*
	* @param rate the rate of this currencyjh
	*/
	@Override
	public void setRate(long rate) {
		_currencyjh.setRate(rate);
	}

	/**
	* Sets the symbol of this currencyjh.
	*
	* @param symbol the symbol of this currencyjh
	*/
	@Override
	public void setSymbol(java.lang.String symbol) {
		_currencyjh.setSymbol(symbol);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CurrencyjhWrapper)) {
			return false;
		}

		CurrencyjhWrapper currencyjhWrapper = (CurrencyjhWrapper)obj;

		if (Objects.equals(_currencyjh, currencyjhWrapper._currencyjh)) {
			return true;
		}

		return false;
	}

	@Override
	public Currencyjh getWrappedModel() {
		return _currencyjh;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _currencyjh.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _currencyjh.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_currencyjh.resetOriginalValues();
	}

	private final Currencyjh _currencyjh;
}