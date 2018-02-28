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
 * Provides the local service utility for Type. This utility wraps
 * {@link com.gleo.modules.ravenbox.service.impl.TypeLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Guillaume Lenoir
 * @see TypeLocalService
 * @see com.gleo.modules.ravenbox.service.base.TypeLocalServiceBaseImpl
 * @see com.gleo.modules.ravenbox.service.impl.TypeLocalServiceImpl
 * @generated
 */
@ProviderType
public class TypeLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.gleo.modules.ravenbox.service.impl.TypeLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the type to the database. Also notifies the appropriate model listeners.
	*
	* @param type the type
	* @return the type that was added
	*/
	public static com.gleo.modules.ravenbox.model.Type addType(
		com.gleo.modules.ravenbox.model.Type type) {
		return getService().addType(type);
	}

	/**
	* Adds the Type to the database incrementing the primary key
	*/
	public static com.gleo.modules.ravenbox.model.Type addType(
		com.gleo.modules.ravenbox.model.Type type,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addType(type, serviceContext);
	}

	public static com.gleo.modules.ravenbox.model.Type create(long typeId) {
		return getService().create(typeId);
	}

	/**
	* Creates a new type with the primary key. Does not add the type to the database.
	*
	* @param typeId the primary key for the new type
	* @return the new type
	*/
	public static com.gleo.modules.ravenbox.model.Type createType(long typeId) {
		return getService().createType(typeId);
	}

	/**
	* Deletes the type from the database. Also notifies the appropriate model listeners.
	*
	* @param type the type
	* @return the type that was removed
	*/
	public static com.gleo.modules.ravenbox.model.Type deleteType(
		com.gleo.modules.ravenbox.model.Type type) {
		return getService().deleteType(type);
	}

	/**
	* Deletes the type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeId the primary key of the type
	* @return the type that was removed
	* @throws PortalException if a type with the primary key could not be found
	* @throws SystemException
	*/
	public static com.gleo.modules.ravenbox.model.Type deleteType(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteType(typeId);
	}

	public static com.gleo.modules.ravenbox.model.Type fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<com.gleo.modules.ravenbox.model.Type> orderByComparator) {
		return getService().fetchByGroupId_First(groupId, orderByComparator);
	}

	public static com.gleo.modules.ravenbox.model.Type fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<com.gleo.modules.ravenbox.model.Type> orderByComparator) {
		return getService().fetchByGroupId_Last(groupId, orderByComparator);
	}

	public static com.gleo.modules.ravenbox.model.Type fetchByPrimaryKey(
		java.io.Serializable primaryKey) {
		return getService().fetchByPrimaryKey(primaryKey);
	}

	public static com.gleo.modules.ravenbox.model.Type fetchByPrimaryKey(
		long typeId) {
		return getService().fetchByPrimaryKey(typeId);
	}

	public static com.gleo.modules.ravenbox.model.Type fetchType(long typeId) {
		return getService().fetchType(typeId);
	}

	public static com.gleo.modules.ravenbox.model.Type findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<com.gleo.modules.ravenbox.model.Type> orderByComparator)
		throws com.gleo.modules.ravenbox.exception.NoSuchTypeException {
		return getService().findByGroupId_First(groupId, orderByComparator);
	}

	public static com.gleo.modules.ravenbox.model.Type findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<com.gleo.modules.ravenbox.model.Type> orderByComparator)
		throws com.gleo.modules.ravenbox.exception.NoSuchTypeException {
		return getService().findByGroupId_Last(groupId, orderByComparator);
	}

	public static com.gleo.modules.ravenbox.model.Type findByPrimaryKey(
		java.io.Serializable primaryKey)
		throws com.liferay.portal.kernel.exception.NoSuchModelException {
		return getService().findByPrimaryKey(primaryKey);
	}

	public static com.gleo.modules.ravenbox.model.Type findByPrimaryKey(
		long typeId)
		throws com.gleo.modules.ravenbox.exception.NoSuchTypeException {
		return getService().findByPrimaryKey(typeId);
	}

	/**
	* Returns the type with the primary key.
	*
	* @param typeId the primary key of the type
	* @return the type
	* @throws PortalException if a type with the primary key could not be found
	*/
	public static com.gleo.modules.ravenbox.model.Type getType(long typeId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getType(typeId);
	}

	public static com.gleo.modules.ravenbox.model.Type remove(
		com.gleo.modules.ravenbox.model.Type model) {
		return getService().remove(model);
	}

	public static com.gleo.modules.ravenbox.model.Type remove(
		java.io.Serializable primaryKey)
		throws com.liferay.portal.kernel.exception.NoSuchModelException {
		return getService().remove(primaryKey);
	}

	public static com.gleo.modules.ravenbox.model.Type remove(long typeId)
		throws com.gleo.modules.ravenbox.exception.NoSuchTypeException {
		return getService().remove(typeId);
	}

	public static com.gleo.modules.ravenbox.model.Type update(
		com.gleo.modules.ravenbox.model.Type model) {
		return getService().update(model);
	}

	public static com.gleo.modules.ravenbox.model.Type update(
		com.gleo.modules.ravenbox.model.Type model,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {
		return getService().update(model, serviceContext);
	}

	public static com.gleo.modules.ravenbox.model.Type updateImpl(
		com.gleo.modules.ravenbox.model.Type type) {
		return getService().updateImpl(type);
	}

	/**
	* Updates the type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param type the type
	* @return the type that was updated
	* @throws SystemException
	*/
	public static com.gleo.modules.ravenbox.model.Type updateType(
		com.gleo.modules.ravenbox.model.Type type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateType(type);
	}

	public static com.gleo.modules.ravenbox.model.Type[] filterFindByGroupId_PrevAndNext(
		long typeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<com.gleo.modules.ravenbox.model.Type> orderByComparator)
		throws com.gleo.modules.ravenbox.exception.NoSuchTypeException {
		return getService()
				   .filterFindByGroupId_PrevAndNext(typeId, groupId,
			orderByComparator);
	}

	public static com.gleo.modules.ravenbox.model.Type[] findByGroupId_PrevAndNext(
		long typeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<com.gleo.modules.ravenbox.model.Type> orderByComparator)
		throws com.gleo.modules.ravenbox.exception.NoSuchTypeException {
		return getService()
				   .findByGroupId_PrevAndNext(typeId, groupId, orderByComparator);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.Session getCurrentSession()
		throws com.liferay.portal.kernel.dao.orm.ORMException {
		return getService().getCurrentSession();
	}

	public static com.liferay.portal.kernel.dao.orm.Session openSession()
		throws com.liferay.portal.kernel.dao.orm.ORMException {
		return getService().openSession();
	}

	public static com.liferay.portal.kernel.exception.SystemException processException(
		java.lang.Exception e) {
		return getService().processException(e);
	}

	public static com.liferay.portal.kernel.model.ModelListener<com.gleo.modules.ravenbox.model.Type>[] getListeners() {
		return getService().getListeners();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static int countAll() {
		return getService().countAll();
	}

	public static int countByGroupId(long groupId) {
		return getService().countByGroupId(groupId);
	}

	public static int filterCountByGroupId(long groupId) {
		return getService().filterCountByGroupId(groupId);
	}

	/**
	* Returns the number of types.
	*
	* @return the number of types
	*/
	public static int getTypesCount() {
		return getService().getTypesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<com.gleo.modules.ravenbox.model.Type> filterFindByGroupId(
		long groupId) {
		return getService().filterFindByGroupId(groupId);
	}

	public static java.util.List<com.gleo.modules.ravenbox.model.Type> filterFindByGroupId(
		long groupId, int start, int end) {
		return getService().filterFindByGroupId(groupId, start, end);
	}

	public static java.util.List<com.gleo.modules.ravenbox.model.Type> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.gleo.modules.ravenbox.model.Type> orderByComparator) {
		return getService()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	public static java.util.List<com.gleo.modules.ravenbox.model.Type> findAll() {
		return getService().findAll();
	}

	public static java.util.List<com.gleo.modules.ravenbox.model.Type> findAll(
		int start, int end) {
		return getService().findAll(start, end);
	}

	public static java.util.List<com.gleo.modules.ravenbox.model.Type> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.gleo.modules.ravenbox.model.Type> orderByComparator) {
		return getService().findAll(start, end, orderByComparator);
	}

	public static java.util.List<com.gleo.modules.ravenbox.model.Type> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.gleo.modules.ravenbox.model.Type> orderByComparator,
		boolean retrieveFromCache) {
		return getService()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	public static java.util.List<com.gleo.modules.ravenbox.model.Type> findByGroupId(
		long groupId) {
		return getService().findByGroupId(groupId);
	}

	public static java.util.List<com.gleo.modules.ravenbox.model.Type> findByGroupId(
		long groupId, int start, int end) {
		return getService().findByGroupId(groupId, start, end);
	}

	public static java.util.List<com.gleo.modules.ravenbox.model.Type> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.gleo.modules.ravenbox.model.Type> orderByComparator) {
		return getService().findByGroupId(groupId, start, end, orderByComparator);
	}

	public static java.util.List<com.gleo.modules.ravenbox.model.Type> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.gleo.modules.ravenbox.model.Type> orderByComparator,
		boolean retrieveFromCache) {
		return getService()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
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
	public static java.util.List<com.gleo.modules.ravenbox.model.Type> getTypes(
		int start, int end) {
		return getService().getTypes(start, end);
	}

	public static java.util.Map<java.io.Serializable, com.gleo.modules.ravenbox.model.Type> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getService().fetchByPrimaryKeys(primaryKeys);
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getService().getBadColumnNames();
	}

	public static javax.sql.DataSource getDataSource() {
		return getService().getDataSource();
	}

	public static long countWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().countWithDynamicQuery(dynamicQuery);
	}

	public static long countWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().countWithDynamicQuery(dynamicQuery, projection);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static void cacheResult(com.gleo.modules.ravenbox.model.Type type) {
		getService().cacheResult(type);
	}

	public static void cacheResult(
		java.util.List<com.gleo.modules.ravenbox.model.Type> types) {
		getService().cacheResult(types);
	}

	public static void clearCache() {
		getService().clearCache();
	}

	public static void clearCache(com.gleo.modules.ravenbox.model.Type model) {
		getService().clearCache(model);
	}

	public static void clearCache(
		java.util.List<com.gleo.modules.ravenbox.model.Type> modelList) {
		getService().clearCache(modelList);
	}

	public static void closeSession(
		com.liferay.portal.kernel.dao.orm.Session session) {
		getService().closeSession(session);
	}

	public static void flush() {
		getService().flush();
	}

	public static void registerListener(
		com.liferay.portal.kernel.model.ModelListener<com.gleo.modules.ravenbox.model.Type> listener) {
		getService().registerListener(listener);
	}

	public static void removeAll() {
		getService().removeAll();
	}

	public static void removeByGroupId(long groupId) {
		getService().removeByGroupId(groupId);
	}

	public static void setDataSource(javax.sql.DataSource dataSource) {
		getService().setDataSource(dataSource);
	}

	public static void unregisterListener(
		com.liferay.portal.kernel.model.ModelListener<com.gleo.modules.ravenbox.model.Type> listener) {
		getService().unregisterListener(listener);
	}

	public static TypeLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TypeLocalService, TypeLocalService> _serviceTracker =
		ServiceTrackerFactory.open(TypeLocalService.class);
}