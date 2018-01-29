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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TypeService}.
 *
 * @author Guillaume Lenoir
 * @see TypeService
 * @generated
 */
@ProviderType
public class TypeServiceWrapper implements TypeService,
	ServiceWrapper<TypeService> {
	public TypeServiceWrapper(TypeService typeService) {
		_typeService = typeService;
	}

	@Override
	public com.gleo.modules.ravenbox.model.Type addType(
		com.gleo.modules.ravenbox.model.Type type,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return _typeService.addType(type, serviceContext);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Type deleteType(long typeId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return _typeService.deleteType(typeId, serviceContext);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Type updateType(
		com.gleo.modules.ravenbox.model.Type type)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return _typeService.updateType(type);
	}

	@Override
	public int getTypesCount(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeService.getTypesCount(groupId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _typeService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.gleo.modules.ravenbox.model.Type> getTypesByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeService.getTypesByGroupId(groupId, start, end);
	}

	@Override
	public TypeService getWrappedService() {
		return _typeService;
	}

	@Override
	public void setWrappedService(TypeService typeService) {
		_typeService = typeService;
	}

	private TypeService _typeService;
}