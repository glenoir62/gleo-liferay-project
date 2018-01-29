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

package com.gleo.modules.ravenbox.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.gleo.modules.ravenbox.model.Currency;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Currency in entity cache.
 *
 * @author Guillaume Lenoir
 * @see Currency
 * @generated
 */
@ProviderType
public class CurrencyCacheModel implements CacheModel<Currency>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CurrencyCacheModel)) {
			return false;
		}

		CurrencyCacheModel currencyCacheModel = (CurrencyCacheModel)obj;

		if (currencyId == currencyCacheModel.currencyId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, currencyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{currencyId=");
		sb.append(currencyId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", label=");
		sb.append(label);
		sb.append(", symbol=");
		sb.append(symbol);
		sb.append(", order=");
		sb.append(order);
		sb.append(", countryId=");
		sb.append(countryId);
		sb.append(", rate=");
		sb.append(rate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Currency toEntityModel() {
		CurrencyImpl currencyImpl = new CurrencyImpl();

		currencyImpl.setCurrencyId(currencyId);
		currencyImpl.setCompanyId(companyId);

		if (label == null) {
			currencyImpl.setLabel(StringPool.BLANK);
		}
		else {
			currencyImpl.setLabel(label);
		}

		if (symbol == null) {
			currencyImpl.setSymbol(StringPool.BLANK);
		}
		else {
			currencyImpl.setSymbol(symbol);
		}

		currencyImpl.setOrder(order);
		currencyImpl.setCountryId(countryId);
		currencyImpl.setRate(rate);

		currencyImpl.resetOriginalValues();

		return currencyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		currencyId = objectInput.readLong();

		companyId = objectInput.readLong();
		label = objectInput.readUTF();
		symbol = objectInput.readUTF();

		order = objectInput.readInt();

		countryId = objectInput.readLong();

		rate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(currencyId);

		objectOutput.writeLong(companyId);

		if (label == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(label);
		}

		if (symbol == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(symbol);
		}

		objectOutput.writeInt(order);

		objectOutput.writeLong(countryId);

		objectOutput.writeLong(rate);
	}

	public long currencyId;
	public long companyId;
	public String label;
	public String symbol;
	public int order;
	public long countryId;
	public long rate;
}