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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ExtCountryService}.
 *
 * @author guillaumelenoir
 * @see ExtCountryService
 * @generated
 */
@ProviderType
public class ExtCountryServiceWrapper implements ExtCountryService,
	ServiceWrapper<ExtCountryService> {
	public ExtCountryServiceWrapper(ExtCountryService extCountryService) {
		_extCountryService = extCountryService;
	}

	@Override
	public com.liferay.portal.kernel.model.Country addCountry(
		boolean isActive, boolean isZipRequired, java.lang.String name,
		java.lang.String a2, java.lang.String a3, java.lang.String number,
		java.lang.String idd)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _extCountryService.addCountry(isActive, isZipRequired, name, a2,
			a3, number, idd);
	}

	@Override
	public com.liferay.portal.kernel.model.Country setActive(long countryId,
		boolean active)
		throws com.liferay.portal.kernel.exception.NoSuchCountryException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return _extCountryService.setActive(countryId, active);
	}

	@Override
	public com.liferay.portal.kernel.model.Country updateCountry(
		long countryId, boolean isActive, boolean isZipRequired,
		java.lang.String name, java.lang.String a2, java.lang.String a3,
		java.lang.String number, java.lang.String idd)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _extCountryService.updateCountry(countryId, isActive,
			isZipRequired, name, a2, a3, number, idd);
	}

	@Override
	public int getCountriesCount()
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return _extCountryService.getCountriesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _extCountryService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.Country> getCountries(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return _extCountryService.getCountries(start, end);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.Country> getCountries(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator byComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return _extCountryService.getCountries(start, end, byComparator);
	}

	@Override
	public ExtCountryService getWrappedService() {
		return _extCountryService;
	}

	@Override
	public void setWrappedService(ExtCountryService extCountryService) {
		_extCountryService = extCountryService;
	}

	private ExtCountryService _extCountryService;
}