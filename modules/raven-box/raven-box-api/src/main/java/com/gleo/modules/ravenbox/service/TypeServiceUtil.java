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

package com.gleo.modules.ravenbox.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Type. This utility wraps
 * {@link com.gleo.modules.ravenbox.service.impl.TypeServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Guillaume Lenoir
 * @see TypeService
 * @see com.gleo.modules.ravenbox.service.base.TypeServiceBaseImpl
 * @see com.gleo.modules.ravenbox.service.impl.TypeServiceImpl
 * @generated
 */
@ProviderType
public class TypeServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.gleo.modules.ravenbox.service.impl.TypeServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.gleo.modules.ravenbox.model.Type addType(
		com.gleo.modules.ravenbox.model.Type type,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return getService().addType(type, serviceContext);
	}

	public static com.gleo.modules.ravenbox.model.Type deleteType(long typeId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return getService().deleteType(typeId, serviceContext);
	}

	public static com.gleo.modules.ravenbox.model.Type updateType(
		com.gleo.modules.ravenbox.model.Type type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return getService().updateType(type);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.gleo.modules.ravenbox.model.Type> getTypesByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTypesByGroupId(groupId, start, end);
	}

	public static TypeService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TypeService, TypeService> _serviceTracker = ServiceTrackerFactory.open(TypeService.class);
}