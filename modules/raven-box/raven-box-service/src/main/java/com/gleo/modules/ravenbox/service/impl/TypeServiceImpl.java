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

package com.gleo.modules.ravenbox.service.impl;

import com.gleo.modules.ravenbox.model.Type;
import com.gleo.modules.ravenbox.permission.RavenBoxPermission;
import com.gleo.modules.ravenbox.permission.TypePermission;
import com.gleo.modules.ravenbox.service.base.TypeServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the type remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.gleo.modules.ravenbox.service.TypeService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see TypeServiceBaseImpl
 * @see com.gleo.modules.ravenbox.service.TypeServiceUtil
 */
@ProviderType
public class TypeServiceImpl extends TypeServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Always use {@link
     * com.gleo.modules.ravenbox.service.TypeServiceUtil} to access the type
     * remote service.
     */
    public Type addType(Type type, ServiceContext serviceContext)
	    throws SystemException, PrincipalException, PortalException {

	RavenBoxPermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(), "ADD_TYPE");

	return typeLocalService.addType(type, serviceContext);
    }

    public Type updateType(Type type) throws SystemException, PrincipalException, PortalException {

	TypePermission.check(getPermissionChecker(), type.getTypeId(), ActionKeys.UPDATE);

	return typeLocalService.updateType(type);
    }

    public Type deleteType(long typeId, ServiceContext serviceContext)
	    throws SystemException, PrincipalException, PortalException {

	TypePermission.check(getPermissionChecker(), typeId, ActionKeys.DELETE);

	return typeLocalService.deleteType(typeId);
    }

    public List<Type> getTypesByGroupId(long groupId, int start, int end) throws SystemException {

	return typePersistence.filterFindByGroupId(groupId, start, end);
    }
    
    public int getTypesCount(long groupId) throws SystemException {

	return typePersistence.filterCountByGroupId(groupId);
    }
}