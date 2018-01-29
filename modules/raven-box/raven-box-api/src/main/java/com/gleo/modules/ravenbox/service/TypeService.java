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

import com.gleo.modules.ravenbox.model.Type;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

/**
 * Provides the remote service interface for Type. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Guillaume Lenoir
 * @see TypeServiceUtil
 * @see com.gleo.modules.ravenbox.service.base.TypeServiceBaseImpl
 * @see com.gleo.modules.ravenbox.service.impl.TypeServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=ravenbox", "json.web.service.context.path=Type"}, service = TypeService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface TypeService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TypeServiceUtil} to access the type remote service. Add custom service methods to {@link com.gleo.modules.ravenbox.service.impl.TypeServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public Type addType(Type type, ServiceContext serviceContext)
		throws PortalException, SystemException, PrincipalException;

	public Type deleteType(long typeId, ServiceContext serviceContext)
		throws PortalException, SystemException, PrincipalException;

	public Type updateType(Type type)
		throws PortalException, SystemException, PrincipalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTypesCount(long groupId) throws SystemException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Type> getTypesByGroupId(long groupId, int start, int end)
		throws SystemException;
}