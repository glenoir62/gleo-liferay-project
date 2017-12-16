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

package com.gleo.plugins.hexiagon.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Currency. This utility wraps
 * {@link com.gleo.plugins.hexiagon.service.impl.CurrencyServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author guillaumelenoir
 * @see CurrencyService
 * @see com.gleo.plugins.hexiagon.service.base.CurrencyServiceBaseImpl
 * @see com.gleo.plugins.hexiagon.service.impl.CurrencyServiceImpl
 * @generated
 */
@ProviderType
public class CurrencyServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.gleo.plugins.hexiagon.service.impl.CurrencyServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.gleo.plugins.hexiagon.model.Currency addCurrency(
		com.gleo.plugins.hexiagon.model.Currency currency,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return getService().addCurrency(currency, serviceContext);
	}

	public static com.gleo.plugins.hexiagon.model.Currency deleteCurrency(
		long currencyId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return getService().deleteCurrency(currencyId, serviceContext);
	}

	public static com.gleo.plugins.hexiagon.model.Currency updateCurrency(
		com.gleo.plugins.hexiagon.model.Currency currency)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return getService().updateCurrency(currency);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static CurrencyService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CurrencyService, CurrencyService> _serviceTracker =
		ServiceTrackerFactory.open(CurrencyService.class);
}