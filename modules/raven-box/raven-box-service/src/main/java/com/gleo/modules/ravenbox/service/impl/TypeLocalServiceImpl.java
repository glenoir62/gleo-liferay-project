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

import com.gleo.modules.ravenbox.exception.NoSuchTypeException;
import com.gleo.modules.ravenbox.model.Type;
import com.gleo.modules.ravenbox.service.base.TypeLocalServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

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
	@Indexable(type = IndexableType.REINDEX)
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

	@Indexable(type = IndexableType.DELETE)
	public Type deleteType(long typeId) throws SystemException, PortalException {
		Type type = typeLocalService.getType(typeId);
		return deleteType(type);
	}
	

	public List<Type> findByGroupId(long groupId) {
		return typePersistence.findByGroupId(groupId);
	}

	public List<Type> findByGroupId(long groupId, int start, int end) {
		return typePersistence.findByGroupId(groupId, start, end);
	}


}