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
import com.gleo.modules.ravenbox.service.base.TypeLocalServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.gleo.modules.ravenbox.service.TypeLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see TypeLocalServiceBaseImpl
 * @see com.gleo.modules.ravenbox.service.TypeLocalServiceUtil
 */
@ProviderType
public class TypeLocalServiceImpl extends TypeLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Always use {@link
     * com.gleo.modules.ravenbox.service.TypeLocalServiceUtil} to access the
     * type local service.
     */

    /**
     * Adds the Type to the database incrementing the primary key
     *
     */
    public Type addType(Type type, ServiceContext serviceContext) throws SystemException, PortalException {
	long typeId = CounterLocalServiceUtil.increment(Type.class.getName());

	long companyId = serviceContext.getCompanyId();
	long groupId = serviceContext.getScopeGroupId();
	long userId = serviceContext.getUserId();

	type.setCompanyId(companyId);
	type.setGroupId(groupId);
	type.setTypeId(typeId);

	type = typePersistence.update(type);
	// Resources

	if (serviceContext.isAddGroupPermissions() || serviceContext.isAddGuestPermissions()) {

	    resourceLocalService.addResources(type.getCompanyId(), type.getGroupId(), userId, Type.class.getName(),
		    typeId, false, serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
	} else {
	    resourceLocalService.addModelResources(type.getCompanyId(), type.getGroupId(), userId, Type.class.getName(),
		    typeId, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
	}

	return type;
    }

    public Type deleteType(long typeId) throws SystemException, PortalException {
	Type type = typeLocalService.getType(typeId);
	return deleteType(type);
    }

    public Type updateType(Type type) throws SystemException {

	typePersistence.clearCache(type);
	return super.updateType(type);
    }

    public List<Type> getTypes(long groupId, int start, int end) throws SystemException {
	return typePersistence.findByGroupId(groupId, start, end);
    }

    public int getTypesCount(long groupId) throws SystemException {
	return typePersistence.countByGroupId(groupId);
    }
}