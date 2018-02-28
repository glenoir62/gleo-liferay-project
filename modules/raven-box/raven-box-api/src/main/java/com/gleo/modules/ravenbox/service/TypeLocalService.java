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

import com.gleo.modules.ravenbox.exception.NoSuchTypeException;
import com.gleo.modules.ravenbox.model.Type;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

/**
 * Provides the local service interface for Type. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Guillaume Lenoir
 * @see TypeLocalServiceUtil
 * @see com.gleo.modules.ravenbox.service.base.TypeLocalServiceBaseImpl
 * @see com.gleo.modules.ravenbox.service.impl.TypeLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface TypeLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TypeLocalServiceUtil} to access the type local service. Add custom service methods to {@link com.gleo.modules.ravenbox.service.impl.TypeLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the type to the database. Also notifies the appropriate model listeners.
	*
	* @param type the type
	* @return the type that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Type addType(Type type);

	/**
	* Adds the Type to the database incrementing the primary key
	*/
	public Type addType(Type type, ServiceContext serviceContext)
		throws PortalException, SystemException;

	public Type create(long typeId);

	/**
	* Creates a new type with the primary key. Does not add the type to the database.
	*
	* @param typeId the primary key for the new type
	* @return the new type
	*/
	public Type createType(long typeId);

	/**
	* Deletes the type from the database. Also notifies the appropriate model listeners.
	*
	* @param type the type
	* @return the type that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public Type deleteType(Type type);

	/**
	* Deletes the type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeId the primary key of the type
	* @return the type that was removed
	* @throws PortalException if a type with the primary key could not be found
	* @throws SystemException
	*/
	@Indexable(type = IndexableType.DELETE)
	public Type deleteType(long typeId) throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Type fetchByGroupId_First(long groupId,
		OrderByComparator<Type> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Type fetchByGroupId_Last(long groupId,
		OrderByComparator<Type> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Type fetchByPrimaryKey(Serializable primaryKey);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Type fetchByPrimaryKey(long typeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Type fetchType(long typeId);

	public Type findByGroupId_First(long groupId,
		OrderByComparator<Type> orderByComparator) throws NoSuchTypeException;

	public Type findByGroupId_Last(long groupId,
		OrderByComparator<Type> orderByComparator) throws NoSuchTypeException;

	public Type findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException;

	public Type findByPrimaryKey(long typeId) throws NoSuchTypeException;

	/**
	* Returns the type with the primary key.
	*
	* @param typeId the primary key of the type
	* @return the type
	* @throws PortalException if a type with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Type getType(long typeId) throws PortalException;

	public Type remove(Type model);

	public Type remove(Serializable primaryKey) throws NoSuchModelException;

	public Type remove(long typeId) throws NoSuchTypeException;

	public Type update(Type model);

	public Type update(Type model, ServiceContext serviceContext);

	public Type updateImpl(Type type);

	/**
	* Updates the type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param type the type
	* @return the type that was updated
	* @throws SystemException
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Type updateType(Type type) throws SystemException;

	public Type[] filterFindByGroupId_PrevAndNext(long typeId, long groupId,
		OrderByComparator<Type> orderByComparator) throws NoSuchTypeException;

	public Type[] findByGroupId_PrevAndNext(long typeId, long groupId,
		OrderByComparator<Type> orderByComparator) throws NoSuchTypeException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Session getCurrentSession() throws ORMException;

	public Session openSession() throws ORMException;

	public SystemException processException(java.lang.Exception e);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ModelListener<Type>[] getListeners();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public int countAll();

	public int countByGroupId(long groupId);

	public int filterCountByGroupId(long groupId);

	/**
	* Returns the number of types.
	*
	* @return the number of types
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTypesCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	public List<Type> filterFindByGroupId(long groupId);

	public List<Type> filterFindByGroupId(long groupId, int start, int end);

	public List<Type> filterFindByGroupId(long groupId, int start, int end,
		OrderByComparator<Type> orderByComparator);

	public List<Type> findAll();

	public List<Type> findAll(int start, int end);

	public List<Type> findAll(int start, int end,
		OrderByComparator<Type> orderByComparator);

	public List<Type> findAll(int start, int end,
		OrderByComparator<Type> orderByComparator, boolean retrieveFromCache);

	public List<Type> findByGroupId(long groupId);

	public List<Type> findByGroupId(long groupId, int start, int end);

	public List<Type> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Type> orderByComparator);

	public List<Type> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Type> orderByComparator, boolean retrieveFromCache);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Type> getTypes(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<Serializable, Type> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Set<java.lang.String> getBadColumnNames();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataSource getDataSource();

	public long countWithDynamicQuery(DynamicQuery dynamicQuery);

	public long countWithDynamicQuery(DynamicQuery dynamicQuery,
		Projection projection);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	public void cacheResult(Type type);

	public void cacheResult(List<Type> types);

	public void clearCache();

	public void clearCache(Type model);

	public void clearCache(List<Type> modelList);

	public void closeSession(Session session);

	public void flush();

	public void registerListener(ModelListener<Type> listener);

	public void removeAll();

	public void removeByGroupId(long groupId);

	public void setDataSource(DataSource dataSource);

	public void unregisterListener(ModelListener<Type> listener);
}