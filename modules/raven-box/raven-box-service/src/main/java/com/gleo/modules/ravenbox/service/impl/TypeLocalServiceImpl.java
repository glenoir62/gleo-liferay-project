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

    public List<Type> findByGroupId(long groupId) {
	return typePersistence.findByGroupId(groupId);
    }

    public List<Type> findByGroupId(long groupId, int start, int end) {
	return typePersistence.findByGroupId(groupId, start, end);
    }

    public void clearCache() {
	typePersistence.clearCache();
    }

    public void clearCache(List<Type> modelList) {
	typePersistence.clearCache(modelList);
    }

    public void clearCache(Type model) {
	typePersistence.clearCache(model);
    }

    public void closeSession(Session session) {
	typePersistence.closeSession(session);
    }

    public long countWithDynamicQuery(DynamicQuery dynamicQuery) {
	return typePersistence.countWithDynamicQuery(dynamicQuery);
    }

    public List<Type> findByGroupId(long groupId, int start, int end, OrderByComparator<Type> orderByComparator) {
	return typePersistence.findByGroupId(groupId, start, end, orderByComparator);
    }

    public long countWithDynamicQuery(DynamicQuery dynamicQuery, Projection projection) {
	return typePersistence.countWithDynamicQuery(dynamicQuery, projection);
    }

    public Type fetchByPrimaryKey(Serializable primaryKey) {
	return typePersistence.fetchByPrimaryKey(primaryKey);
    }

    public Type findByPrimaryKey(Serializable primaryKey) throws NoSuchModelException {
	return typePersistence.findByPrimaryKey(primaryKey);
    }

    public List<Type> findByGroupId(long groupId, int start, int end, OrderByComparator<Type> orderByComparator,
	    boolean retrieveFromCache) {
	return typePersistence.findByGroupId(groupId, start, end, orderByComparator, retrieveFromCache);
    }

    public Type findByGroupId_First(long groupId, OrderByComparator<Type> orderByComparator)
	    throws NoSuchTypeException {
	return typePersistence.findByGroupId_First(groupId, orderByComparator);
    }

    public void flush() {
	typePersistence.flush();
    }

    public Type fetchByGroupId_First(long groupId, OrderByComparator<Type> orderByComparator) {
	return typePersistence.fetchByGroupId_First(groupId, orderByComparator);
    }

    public Session getCurrentSession() throws ORMException {
	return typePersistence.getCurrentSession();
    }

    public DataSource getDataSource() {
	return typePersistence.getDataSource();
    }

    public ModelListener<Type>[] getListeners() {
	return typePersistence.getListeners();
    }

    public Type findByGroupId_Last(long groupId, OrderByComparator<Type> orderByComparator) throws NoSuchTypeException {
	return typePersistence.findByGroupId_Last(groupId, orderByComparator);
    }

    public Session openSession() throws ORMException {
	return typePersistence.openSession();
    }

    public SystemException processException(Exception e) {
	return typePersistence.processException(e);
    }

    public void registerListener(ModelListener<Type> listener) {
	typePersistence.registerListener(listener);
    }

    public Type fetchByGroupId_Last(long groupId, OrderByComparator<Type> orderByComparator) {
	return typePersistence.fetchByGroupId_Last(groupId, orderByComparator);
    }

    public Type remove(Serializable primaryKey) throws NoSuchModelException {
	return typePersistence.remove(primaryKey);
    }

    public Type remove(Type model) {
	return typePersistence.remove(model);
    }

    public Type[] findByGroupId_PrevAndNext(long typeId, long groupId, OrderByComparator<Type> orderByComparator)
	    throws NoSuchTypeException {
	return typePersistence.findByGroupId_PrevAndNext(typeId, groupId, orderByComparator);
    }

    public void setDataSource(DataSource dataSource) {
	typePersistence.setDataSource(dataSource);
    }

    public void unregisterListener(ModelListener<Type> listener) {
	typePersistence.unregisterListener(listener);
    }

    public List<Type> filterFindByGroupId(long groupId) {
	return typePersistence.filterFindByGroupId(groupId);
    }

    public Type update(Type model) {
	return typePersistence.update(model);
    }

    public List<Type> filterFindByGroupId(long groupId, int start, int end) {
	return typePersistence.filterFindByGroupId(groupId, start, end);
    }

    public Type update(Type model, ServiceContext serviceContext) {
	return typePersistence.update(model, serviceContext);
    }

    public List<Type> filterFindByGroupId(long groupId, int start, int end, OrderByComparator<Type> orderByComparator) {
	return typePersistence.filterFindByGroupId(groupId, start, end, orderByComparator);
    }

    public Type[] filterFindByGroupId_PrevAndNext(long typeId, long groupId, OrderByComparator<Type> orderByComparator)
	    throws NoSuchTypeException {
	return typePersistence.filterFindByGroupId_PrevAndNext(typeId, groupId, orderByComparator);
    }

    public void removeByGroupId(long groupId) {
	typePersistence.removeByGroupId(groupId);
    }

    public int countByGroupId(long groupId) {
	return typePersistence.countByGroupId(groupId);
    }

    public int filterCountByGroupId(long groupId) {
	return typePersistence.filterCountByGroupId(groupId);
    }

    public void cacheResult(Type type) {
	typePersistence.cacheResult(type);
    }

    public void cacheResult(List<Type> types) {
	typePersistence.cacheResult(types);
    }

    public Type create(long typeId) {
	return typePersistence.create(typeId);
    }

    public Type remove(long typeId) throws NoSuchTypeException {
	return typePersistence.remove(typeId);
    }

    public Type updateImpl(Type type) {
	return typePersistence.updateImpl(type);
    }

    public Type findByPrimaryKey(long typeId) throws NoSuchTypeException {
	return typePersistence.findByPrimaryKey(typeId);
    }

    public Type fetchByPrimaryKey(long typeId) {
	return typePersistence.fetchByPrimaryKey(typeId);
    }

    public Map<Serializable, Type> fetchByPrimaryKeys(Set<Serializable> primaryKeys) {
	return typePersistence.fetchByPrimaryKeys(primaryKeys);
    }

    public List<Type> findAll() {
	return typePersistence.findAll();
    }

    public List<Type> findAll(int start, int end) {
	return typePersistence.findAll(start, end);
    }

    public List<Type> findAll(int start, int end, OrderByComparator<Type> orderByComparator) {
	return typePersistence.findAll(start, end, orderByComparator);
    }

    public List<Type> findAll(int start, int end, OrderByComparator<Type> orderByComparator,
	    boolean retrieveFromCache) {
	return typePersistence.findAll(start, end, orderByComparator, retrieveFromCache);
    }

    public void removeAll() {
	typePersistence.removeAll();
    }

    public int countAll() {
	return typePersistence.countAll();
    }

    public Set<String> getBadColumnNames() {
	return typePersistence.getBadColumnNames();
    }

}