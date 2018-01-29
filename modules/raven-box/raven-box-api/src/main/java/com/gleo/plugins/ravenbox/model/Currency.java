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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Currency service. Represents a row in the &quot;ravenbox_Currency&quot; database table, with each column mapped to a property of this class.
 *
 * @author Guillaume Lenoir
 * @see CurrencyModel
 * @see com.gleo.plugins.ravenbox.model.impl.CurrencyImpl
 * @see com.gleo.plugins.ravenbox.model.impl.CurrencyModelImpl
 * @generated
 */
@ImplementationClassName("com.gleo.plugins.ravenbox.model.impl.CurrencyImpl")
@ProviderType
public interface Currency extends CurrencyModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.gleo.plugins.ravenbox.model.impl.CurrencyImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Currency, Long> CURRENCY_ID_ACCESSOR = new Accessor<Currency, Long>() {
			@Override
			public Long get(Currency currency) {
				return currency.getCurrencyId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Currency> getTypeClass() {
				return Currency.class;
			}
		};
}