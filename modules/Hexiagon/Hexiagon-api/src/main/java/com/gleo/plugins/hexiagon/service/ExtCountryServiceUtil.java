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
 * Provides the remote service utility for ExtCountry. This utility wraps
 * {@link com.gleo.plugins.hexiagon.service.impl.ExtCountryServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author guillaumelenoir
 * @see ExtCountryService
 * @see com.gleo.plugins.hexiagon.service.base.ExtCountryServiceBaseImpl
 * @see com.gleo.plugins.hexiagon.service.impl.ExtCountryServiceImpl
 * @generated
 */
@ProviderType
public class ExtCountryServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.gleo.plugins.hexiagon.service.impl.ExtCountryServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.model.Country addCountry(
		boolean isActive, boolean isZipRequired, java.lang.String name,
		java.lang.String a2, java.lang.String a3, java.lang.String number,
		java.lang.String idd)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCountry(isActive, isZipRequired, name, a2, a3, number,
			idd);
	}

	public static com.liferay.portal.kernel.model.Country setActive(
		long countryId, boolean active)
		throws com.liferay.portal.kernel.exception.NoSuchCountryException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return getService().setActive(countryId, active);
	}

	public static com.liferay.portal.kernel.model.Country updateCountry(
		long countryId, boolean isActive, boolean isZipRequired,
		java.lang.String name, java.lang.String a2, java.lang.String a3,
		java.lang.String number, java.lang.String idd)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCountry(countryId, isActive, isZipRequired, name, a2,
			a3, number, idd);
	}

	public static int getCountriesCount()
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return getService().getCountriesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.liferay.portal.kernel.model.Country> getCountries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return getService().getCountries(start, end);
	}

	public static java.util.List<com.liferay.portal.kernel.model.Country> getCountries(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator byComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return getService().getCountries(start, end, byComparator);
	}

	public static ExtCountryService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ExtCountryService, ExtCountryService> _serviceTracker =
		ServiceTrackerFactory.open(ExtCountryService.class);
}