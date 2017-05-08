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

package com.gleo.plugins.hexiagon.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.gleo.plugins.hexiagon.service.base.CurrencyServiceBaseImpl;

/**
 * The implementation of the currency remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.gleo.plugins.hexiagon.service.CurrencyService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author guillaumelenoir
 * @see CurrencyServiceBaseImpl
 * @see com.gleo.plugins.hexiagon.service.CurrencyServiceUtil
 */
@ProviderType
public class CurrencyServiceImpl extends CurrencyServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.gleo.plugins.hexiagon.service.CurrencyServiceUtil} to access the currency remote service.
	 */
}