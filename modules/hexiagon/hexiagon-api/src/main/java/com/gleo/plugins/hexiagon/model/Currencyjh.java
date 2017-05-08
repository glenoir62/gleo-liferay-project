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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Currencyjh service. Represents a row in the &quot;Hexiagon_Currencyjh&quot; database table, with each column mapped to a property of this class.
 *
 * @author guillaumelenoir
 * @see CurrencyjhModel
 * @see com.gleo.plugins.hexiagon.model.impl.CurrencyjhImpl
 * @see com.gleo.plugins.hexiagon.model.impl.CurrencyjhModelImpl
 * @generated
 */
@ImplementationClassName("com.gleo.plugins.hexiagon.model.impl.CurrencyjhImpl")
@ProviderType
public interface Currencyjh extends CurrencyjhModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.gleo.plugins.hexiagon.model.impl.CurrencyjhImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Currencyjh, Long> CURRENCY_ID_ACCESSOR = new Accessor<Currencyjh, Long>() {
			@Override
			public Long get(Currencyjh currencyjh) {
				return currencyjh.getCurrencyId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Currencyjh> getTypeClass() {
				return Currencyjh.class;
			}
		};
}