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

package com.gleo.plugins.ravenbox.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.gleo.plugins.ravenbox.service.http.CurrencyServiceSoap}.
 *
 * @author Guillaume Lenoir
 * @see com.gleo.plugins.ravenbox.service.http.CurrencyServiceSoap
 * @generated
 */
@ProviderType
public class CurrencySoap implements Serializable {
	public static CurrencySoap toSoapModel(Currency model) {
		CurrencySoap soapModel = new CurrencySoap();

		soapModel.setCurrencyId(model.getCurrencyId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setLabel(model.getLabel());
		soapModel.setSymbol(model.getSymbol());
		soapModel.setOrder(model.getOrder());
		soapModel.setCountryId(model.getCountryId());
		soapModel.setRate(model.getRate());

		return soapModel;
	}

	public static CurrencySoap[] toSoapModels(Currency[] models) {
		CurrencySoap[] soapModels = new CurrencySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CurrencySoap[][] toSoapModels(Currency[][] models) {
		CurrencySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CurrencySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CurrencySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CurrencySoap[] toSoapModels(List<Currency> models) {
		List<CurrencySoap> soapModels = new ArrayList<CurrencySoap>(models.size());

		for (Currency model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CurrencySoap[soapModels.size()]);
	}

	public CurrencySoap() {
	}

	public long getPrimaryKey() {
		return _currencyId;
	}

	public void setPrimaryKey(long pk) {
		setCurrencyId(pk);
	}

	public long getCurrencyId() {
		return _currencyId;
	}

	public void setCurrencyId(long currencyId) {
		_currencyId = currencyId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getLabel() {
		return _label;
	}

	public void setLabel(String label) {
		_label = label;
	}

	public String getSymbol() {
		return _symbol;
	}

	public void setSymbol(String symbol) {
		_symbol = symbol;
	}

	public int getOrder() {
		return _order;
	}

	public void setOrder(int order) {
		_order = order;
	}

	public long getCountryId() {
		return _countryId;
	}

	public void setCountryId(long countryId) {
		_countryId = countryId;
	}

	public long getRate() {
		return _rate;
	}

	public void setRate(long rate) {
		_rate = rate;
	}

	private long _currencyId;
	private long _companyId;
	private String _label;
	private String _symbol;
	private int _order;
	private long _countryId;
	private long _rate;
}