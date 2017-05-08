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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the Currencyjh service. Represents a row in the &quot;Hexiagon_Currencyjh&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.gleo.plugins.hexiagon.model.impl.CurrencyjhModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.gleo.plugins.hexiagon.model.impl.CurrencyjhImpl}.
 * </p>
 *
 * @author guillaumelenoir
 * @see Currencyjh
 * @see com.gleo.plugins.hexiagon.model.impl.CurrencyjhImpl
 * @see com.gleo.plugins.hexiagon.model.impl.CurrencyjhModelImpl
 * @generated
 */
@ProviderType
public interface CurrencyjhModel extends BaseModel<Currencyjh>, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a currencyjh model instance should use the {@link Currencyjh} interface instead.
	 */

	/**
	 * Returns the primary key of this currencyjh.
	 *
	 * @return the primary key of this currencyjh
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this currencyjh.
	 *
	 * @param primaryKey the primary key of this currencyjh
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the currency ID of this currencyjh.
	 *
	 * @return the currency ID of this currencyjh
	 */
	public long getCurrencyId();

	/**
	 * Sets the currency ID of this currencyjh.
	 *
	 * @param currencyId the currency ID of this currencyjh
	 */
	public void setCurrencyId(long currencyId);

	/**
	 * Returns the company ID of this currencyjh.
	 *
	 * @return the company ID of this currencyjh
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this currencyjh.
	 *
	 * @param companyId the company ID of this currencyjh
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the label of this currencyjh.
	 *
	 * @return the label of this currencyjh
	 */
	@AutoEscape
	public String getLabel();

	/**
	 * Sets the label of this currencyjh.
	 *
	 * @param label the label of this currencyjh
	 */
	public void setLabel(String label);

	/**
	 * Returns the symbol of this currencyjh.
	 *
	 * @return the symbol of this currencyjh
	 */
	@AutoEscape
	public String getSymbol();

	/**
	 * Sets the symbol of this currencyjh.
	 *
	 * @param symbol the symbol of this currencyjh
	 */
	public void setSymbol(String symbol);

	/**
	 * Returns the order of this currencyjh.
	 *
	 * @return the order of this currencyjh
	 */
	public int getOrder();

	/**
	 * Sets the order of this currencyjh.
	 *
	 * @param order the order of this currencyjh
	 */
	public void setOrder(int order);

	/**
	 * Returns the country ID of this currencyjh.
	 *
	 * @return the country ID of this currencyjh
	 */
	public long getCountryId();

	/**
	 * Sets the country ID of this currencyjh.
	 *
	 * @param countryId the country ID of this currencyjh
	 */
	public void setCountryId(long countryId);

	/**
	 * Returns the rate of this currencyjh.
	 *
	 * @return the rate of this currencyjh
	 */
	public long getRate();

	/**
	 * Sets the rate of this currencyjh.
	 *
	 * @param rate the rate of this currencyjh
	 */
	public void setRate(long rate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Currencyjh currencyjh);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Currencyjh> toCacheModel();

	@Override
	public Currencyjh toEscapedModel();

	@Override
	public Currencyjh toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}