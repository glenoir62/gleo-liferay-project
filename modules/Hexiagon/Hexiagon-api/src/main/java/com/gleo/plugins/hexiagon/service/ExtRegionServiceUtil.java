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
 * Provides the remote service utility for ExtRegion. This utility wraps
 * {@link com.gleo.plugins.hexiagon.service.impl.ExtRegionServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author guillaumelenoir
 * @see ExtRegionService
 * @see com.gleo.plugins.hexiagon.service.base.ExtRegionServiceBaseImpl
 * @see com.gleo.plugins.hexiagon.service.impl.ExtRegionServiceImpl
 * @generated
 */
@ProviderType
public class ExtRegionServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.gleo.plugins.hexiagon.service.impl.ExtRegionServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.model.Region setActive(
		long regionId, boolean active)
		throws com.liferay.portal.kernel.exception.NoSuchRegionException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return getService().setActive(regionId, active);
	}

	public static com.liferay.portal.kernel.model.Region updateRegion(
		long regionId, boolean isActive, java.lang.String name,
		java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateRegion(regionId, isActive, name, regionCode);
	}

	public static int getRegionsCount(long countryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return getService().getRegionsCount(countryId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.liferay.portal.kernel.model.Region> getRegions(
		long countryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return getService().getRegions(countryId, start, end);
	}

	public static java.util.List<com.liferay.portal.kernel.model.Region> getRegions(
		long countryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return getService().getRegions(countryId, start, end, orderByComparator);
	}

	public static ExtRegionService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ExtRegionService, ExtRegionService> _serviceTracker =
		ServiceTrackerFactory.open(ExtRegionService.class);
}