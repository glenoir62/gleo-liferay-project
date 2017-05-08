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
 * Provides a wrapper for {@link ExtRegionService}.
 *
 * @author guillaumelenoir
 * @see ExtRegionService
 * @generated
 */
@ProviderType
public class ExtRegionServiceWrapper implements ExtRegionService,
	ServiceWrapper<ExtRegionService> {
	public ExtRegionServiceWrapper(ExtRegionService extRegionService) {
		_extRegionService = extRegionService;
	}

	@Override
	public com.liferay.portal.kernel.model.Region setActive(long regionId,
		boolean active)
		throws com.liferay.portal.kernel.exception.NoSuchRegionException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return _extRegionService.setActive(regionId, active);
	}

	@Override
	public com.liferay.portal.kernel.model.Region updateRegion(long regionId,
		boolean isActive, java.lang.String name, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _extRegionService.updateRegion(regionId, isActive, name,
			regionCode);
	}

	@Override
	public int getRegionsCount(long countryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return _extRegionService.getRegionsCount(countryId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _extRegionService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.Region> getRegions(
		long countryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return _extRegionService.getRegions(countryId, start, end);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.Region> getRegions(
		long countryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.portal.kernel.model.Region> orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return _extRegionService.getRegions(countryId, start, end,
			orderByComparator);
	}

	@Override
	public ExtRegionService getWrappedService() {
		return _extRegionService;
	}

	@Override
	public void setWrappedService(ExtRegionService extRegionService) {
		_extRegionService = extRegionService;
	}

	private ExtRegionService _extRegionService;
}