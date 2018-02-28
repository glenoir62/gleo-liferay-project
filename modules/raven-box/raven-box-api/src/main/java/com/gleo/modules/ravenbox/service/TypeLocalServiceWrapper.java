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
 * Provides a wrapper for {@link TypeLocalService}.
 *
 * @author Guillaume Lenoir
 * @see TypeLocalService
 * @generated
 */
@ProviderType
public class TypeLocalServiceWrapper implements TypeLocalService,
	ServiceWrapper<TypeLocalService> {
	public TypeLocalServiceWrapper(TypeLocalService typeLocalService) {
		_typeLocalService = typeLocalService;
	}

	/**
	* Adds the type to the database. Also notifies the appropriate model listeners.
	*
	* @param type the type
	* @return the type that was added
	*/
	@Override
	public com.gleo.modules.ravenbox.model.Type addType(
		com.gleo.modules.ravenbox.model.Type type) {
		return _typeLocalService.addType(type);
	}

	/**
	* Adds the Type to the database incrementing the primary key
	*/
	@Override
	public com.gleo.modules.ravenbox.model.Type addType(
		com.gleo.modules.ravenbox.model.Type type,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeLocalService.addType(type, serviceContext);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Type create(long typeId) {
		return _typeLocalService.create(typeId);
	}

	/**
	* Creates a new type with the primary key. Does not add the type to the database.
	*
	* @param typeId the primary key for the new type
	* @return the new type
	*/
	@Override
	public com.gleo.modules.ravenbox.model.Type createType(long typeId) {
		return _typeLocalService.createType(typeId);
	}

	/**
	* Deletes the type from the database. Also notifies the appropriate model listeners.
	*
	* @param type the type
	* @return the type that was removed
	*/
	@Override
	public com.gleo.modules.ravenbox.model.Type deleteType(
		com.gleo.modules.ravenbox.model.Type type) {
		return _typeLocalService.deleteType(type);
	}

	/**
	* Deletes the type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeId the primary key of the type
	* @return the type that was removed
	* @throws PortalException if a type with the primary key could not be found
	* @throws SystemException
	*/
	@Override
	public com.gleo.modules.ravenbox.model.Type deleteType(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _typeLocalService.deleteType(typeId);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Type fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<com.gleo.modules.ravenbox.model.Type> orderByComparator) {
		return _typeLocalService.fetchByGroupId_First(groupId, orderByComparator);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Type fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<com.gleo.modules.ravenbox.model.Type> orderByComparator) {
		return _typeLocalService.fetchByGroupId_Last(groupId, orderByComparator);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Type fetchByPrimaryKey(
		java.io.Serializable primaryKey) {
		return _typeLocalService.fetchByPrimaryKey(primaryKey);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Type fetchByPrimaryKey(long typeId) {
		return _typeLocalService.fetchByPrimaryKey(typeId);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Type fetchType(long typeId) {
		return _typeLocalService.fetchType(typeId);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Type findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<com.gleo.modules.ravenbox.model.Type> orderByComparator)
		throws com.gleo.modules.ravenbox.exception.NoSuchTypeException {
		return _typeLocalService.findByGroupId_First(groupId, orderByComparator);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Type findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<com.gleo.modules.ravenbox.model.Type> orderByComparator)
		throws com.gleo.modules.ravenbox.exception.NoSuchTypeException {
		return _typeLocalService.findByGroupId_Last(groupId, orderByComparator);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Type findByPrimaryKey(
		java.io.Serializable primaryKey)
		throws com.liferay.portal.kernel.exception.NoSuchModelException {
		return _typeLocalService.findByPrimaryKey(primaryKey);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Type findByPrimaryKey(long typeId)
		throws com.gleo.modules.ravenbox.exception.NoSuchTypeException {
		return _typeLocalService.findByPrimaryKey(typeId);
	}

	/**
	* Returns the type with the primary key.
	*
	* @param typeId the primary key of the type
	* @return the type
	* @throws PortalException if a type with the primary key could not be found
	*/
	@Override
	public com.gleo.modules.ravenbox.model.Type getType(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _typeLocalService.getType(typeId);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Type remove(
		com.gleo.modules.ravenbox.model.Type model) {
		return _typeLocalService.remove(model);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Type remove(
		java.io.Serializable primaryKey)
		throws com.liferay.portal.kernel.exception.NoSuchModelException {
		return _typeLocalService.remove(primaryKey);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Type remove(long typeId)
		throws com.gleo.modules.ravenbox.exception.NoSuchTypeException {
		return _typeLocalService.remove(typeId);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Type update(
		com.gleo.modules.ravenbox.model.Type model) {
		return _typeLocalService.update(model);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Type update(
		com.gleo.modules.ravenbox.model.Type model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {
		return _typeLocalService.update(model, serviceContext);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Type updateImpl(
		com.gleo.modules.ravenbox.model.Type type) {
		return _typeLocalService.updateImpl(type);
	}

	/**
	* Updates the type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param type the type
	* @return the type that was updated
	* @throws SystemException
	*/
	@Override
	public com.gleo.modules.ravenbox.model.Type updateType(
		com.gleo.modules.ravenbox.model.Type type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _typeLocalService.updateType(type);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Type[] filterFindByGroupId_PrevAndNext(
		long typeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<com.gleo.modules.ravenbox.model.Type> orderByComparator)
		throws com.gleo.modules.ravenbox.exception.NoSuchTypeException {
		return _typeLocalService.filterFindByGroupId_PrevAndNext(typeId,
			groupId, orderByComparator);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Type[] findByGroupId_PrevAndNext(
		long typeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<com.gleo.modules.ravenbox.model.Type> orderByComparator)
		throws com.gleo.modules.ravenbox.exception.NoSuchTypeException {
		return _typeLocalService.findByGroupId_PrevAndNext(typeId, groupId,
			orderByComparator);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _typeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _typeLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _typeLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.Session getCurrentSession()
		throws com.liferay.portal.kernel.dao.orm.ORMException {
		return _typeLocalService.getCurrentSession();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.Session openSession()
		throws com.liferay.portal.kernel.dao.orm.ORMException {
		return _typeLocalService.openSession();
	}

	@Override
	public com.liferay.portal.kernel.exception.SystemException processException(
		java.lang.Exception e) {
		return _typeLocalService.processException(e);
	}

	@Override
	public com.liferay.portal.kernel.model.ModelListener<com.gleo.modules.ravenbox.model.Type>[] getListeners() {
		return _typeLocalService.getListeners();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _typeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _typeLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public int countAll() {
		return _typeLocalService.countAll();
	}

	@Override
	public int countByGroupId(long groupId) {
		return _typeLocalService.countByGroupId(groupId);
	}

	@Override
	public int filterCountByGroupId(long groupId) {
		return _typeLocalService.filterCountByGroupId(groupId);
	}

	/**
	* Returns the number of types.
	*
	* @return the number of types
	*/
	@Override
	public int getTypesCount() {
		return _typeLocalService.getTypesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _typeLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _typeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gleo.modules.ravenbox.model.impl.TypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _typeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gleo.modules.ravenbox.model.impl.TypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _typeLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.gleo.modules.ravenbox.model.Type> filterFindByGroupId(
		long groupId) {
		return _typeLocalService.filterFindByGroupId(groupId);
	}

	@Override
	public java.util.List<com.gleo.modules.ravenbox.model.Type> filterFindByGroupId(
		long groupId, int start, int end) {
		return _typeLocalService.filterFindByGroupId(groupId, start, end);
	}

	@Override
	public java.util.List<com.gleo.modules.ravenbox.model.Type> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.gleo.modules.ravenbox.model.Type> orderByComparator) {
		return _typeLocalService.filterFindByGroupId(groupId, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.gleo.modules.ravenbox.model.Type> findAll() {
		return _typeLocalService.findAll();
	}

	@Override
	public java.util.List<com.gleo.modules.ravenbox.model.Type> findAll(
		int start, int end) {
		return _typeLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<com.gleo.modules.ravenbox.model.Type> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.gleo.modules.ravenbox.model.Type> orderByComparator) {
		return _typeLocalService.findAll(start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.gleo.modules.ravenbox.model.Type> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.gleo.modules.ravenbox.model.Type> orderByComparator,
		boolean retrieveFromCache) {
		return _typeLocalService.findAll(start, end, orderByComparator,
			retrieveFromCache);
	}

	@Override
	public java.util.List<com.gleo.modules.ravenbox.model.Type> findByGroupId(
		long groupId) {
		return _typeLocalService.findByGroupId(groupId);
	}

	@Override
	public java.util.List<com.gleo.modules.ravenbox.model.Type> findByGroupId(
		long groupId, int start, int end) {
		return _typeLocalService.findByGroupId(groupId, start, end);
	}

	@Override
	public java.util.List<com.gleo.modules.ravenbox.model.Type> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.gleo.modules.ravenbox.model.Type> orderByComparator) {
		return _typeLocalService.findByGroupId(groupId, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.gleo.modules.ravenbox.model.Type> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.gleo.modules.ravenbox.model.Type> orderByComparator,
		boolean retrieveFromCache) {
		return _typeLocalService.findByGroupId(groupId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns a range of all the types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gleo.modules.ravenbox.model.impl.TypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of types
	* @param end the upper bound of the range of types (not inclusive)
	* @return the range of types
	*/
	@Override
	public java.util.List<com.gleo.modules.ravenbox.model.Type> getTypes(
		int start, int end) {
		return _typeLocalService.getTypes(start, end);
	}

	@Override
	public java.util.Map<java.io.Serializable, com.gleo.modules.ravenbox.model.Type> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return _typeLocalService.fetchByPrimaryKeys(primaryKeys);
	}

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames() {
		return _typeLocalService.getBadColumnNames();
	}

	@Override
	public javax.sql.DataSource getDataSource() {
		return _typeLocalService.getDataSource();
	}

	@Override
	public long countWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _typeLocalService.countWithDynamicQuery(dynamicQuery);
	}

	@Override
	public long countWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _typeLocalService.countWithDynamicQuery(dynamicQuery, projection);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _typeLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _typeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public void cacheResult(com.gleo.modules.ravenbox.model.Type type) {
		_typeLocalService.cacheResult(type);
	}

	@Override
	public void cacheResult(
		java.util.List<com.gleo.modules.ravenbox.model.Type> types) {
		_typeLocalService.cacheResult(types);
	}

	@Override
	public void clearCache() {
		_typeLocalService.clearCache();
	}

	@Override
	public void clearCache(com.gleo.modules.ravenbox.model.Type model) {
		_typeLocalService.clearCache(model);
	}

	@Override
	public void clearCache(
		java.util.List<com.gleo.modules.ravenbox.model.Type> modelList) {
		_typeLocalService.clearCache(modelList);
	}

	@Override
	public void closeSession(com.liferay.portal.kernel.dao.orm.Session session) {
		_typeLocalService.closeSession(session);
	}

	@Override
	public void flush() {
		_typeLocalService.flush();
	}

	@Override
	public void registerListener(
		com.liferay.portal.kernel.model.ModelListener<com.gleo.modules.ravenbox.model.Type> listener) {
		_typeLocalService.registerListener(listener);
	}

	@Override
	public void removeAll() {
		_typeLocalService.removeAll();
	}

	@Override
	public void removeByGroupId(long groupId) {
		_typeLocalService.removeByGroupId(groupId);
	}

	@Override
	public void setDataSource(javax.sql.DataSource dataSource) {
		_typeLocalService.setDataSource(dataSource);
	}

	@Override
	public void unregisterListener(
		com.liferay.portal.kernel.model.ModelListener<com.gleo.modules.ravenbox.model.Type> listener) {
		_typeLocalService.unregisterListener(listener);
	}

	@Override
	public TypeLocalService getWrappedService() {
		return _typeLocalService;
	}

	@Override
	public void setWrappedService(TypeLocalService typeLocalService) {
		_typeLocalService = typeLocalService;
	}

	private TypeLocalService _typeLocalService;
}