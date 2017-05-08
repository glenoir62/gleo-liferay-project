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

import com.liferay.portal.kernel.exception.NoSuchCountryException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

/**
 * Provides the remote service interface for ExtCountry. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author guillaumelenoir
 * @see ExtCountryServiceUtil
 * @see com.gleo.plugins.hexiagon.service.base.ExtCountryServiceBaseImpl
 * @see com.gleo.plugins.hexiagon.service.impl.ExtCountryServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=hexiagon", "json.web.service.context.path=ExtCountry"}, service = ExtCountryService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ExtCountryService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExtCountryServiceUtil} to access the ext country remote service. Add custom service methods to {@link com.gleo.plugins.hexiagon.service.impl.ExtCountryServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public Country addCountry(boolean isActive, boolean isZipRequired,
		java.lang.String name, java.lang.String a2, java.lang.String a3,
		java.lang.String number, java.lang.String idd)
		throws PortalException, SystemException;

	public Country setActive(long countryId, boolean active)
		throws NoSuchCountryException, SystemException, PrincipalException;

	public Country updateCountry(long countryId, boolean isActive,
		boolean isZipRequired, java.lang.String name, java.lang.String a2,
		java.lang.String a3, java.lang.String number, java.lang.String idd)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCountriesCount() throws SystemException, PrincipalException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Country> getCountries(int start, int end)
		throws SystemException, PrincipalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Country> getCountries(int start, int end,
		OrderByComparator<Country> byComparator)
		throws SystemException, PrincipalException;
}