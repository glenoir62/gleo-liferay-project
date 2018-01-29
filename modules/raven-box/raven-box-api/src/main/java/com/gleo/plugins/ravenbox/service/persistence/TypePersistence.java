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

package com.gleo.plugins.ravenbox.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.gleo.plugins.ravenbox.exception.NoSuchTypeException;
import com.gleo.plugins.ravenbox.model.Type;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Guillaume Lenoir
 * @see com.gleo.plugins.ravenbox.service.persistence.impl.TypePersistenceImpl
 * @see TypeUtil
 * @generated
 */
@ProviderType
public interface TypePersistence extends BasePersistence<Type> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TypeUtil} to access the type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the types where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching types
	*/
	public java.util.List<Type> findByGroupId(long groupId);

	/**
	* Returns a range of all the types where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of types
	* @param end the upper bound of the range of types (not inclusive)
	* @return the range of matching types
	*/
	public java.util.List<Type> findByGroupId(long groupId, int start, int end);

	/**
	* Returns an ordered range of all the types where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of types
	* @param end the upper bound of the range of types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching types
	*/
	public java.util.List<Type> findByGroupId(long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Type> orderByComparator);

	/**
	* Returns an ordered range of all the types where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of types
	* @param end the upper bound of the range of types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching types
	*/
	public java.util.List<Type> findByGroupId(long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Type> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first type in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type
	* @throws NoSuchTypeException if a matching type could not be found
	*/
	public Type findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Type> orderByComparator)
		throws NoSuchTypeException;

	/**
	* Returns the first type in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching type, or <code>null</code> if a matching type could not be found
	*/
	public Type fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Type> orderByComparator);

	/**
	* Returns the last type in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type
	* @throws NoSuchTypeException if a matching type could not be found
	*/
	public Type findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Type> orderByComparator)
		throws NoSuchTypeException;

	/**
	* Returns the last type in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching type, or <code>null</code> if a matching type could not be found
	*/
	public Type fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Type> orderByComparator);

	/**
	* Returns the types before and after the current type in the ordered set where groupId = &#63;.
	*
	* @param typeId the primary key of the current type
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next type
	* @throws NoSuchTypeException if a type with the primary key could not be found
	*/
	public Type[] findByGroupId_PrevAndNext(long typeId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Type> orderByComparator)
		throws NoSuchTypeException;

	/**
	* Removes all the types where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of types where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching types
	*/
	public int countByGroupId(long groupId);

	/**
	* Caches the type in the entity cache if it is enabled.
	*
	* @param type the type
	*/
	public void cacheResult(Type type);

	/**
	* Caches the types in the entity cache if it is enabled.
	*
	* @param types the types
	*/
	public void cacheResult(java.util.List<Type> types);

	/**
	* Creates a new type with the primary key. Does not add the type to the database.
	*
	* @param typeId the primary key for the new type
	* @return the new type
	*/
	public Type create(long typeId);

	/**
	* Removes the type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param typeId the primary key of the type
	* @return the type that was removed
	* @throws NoSuchTypeException if a type with the primary key could not be found
	*/
	public Type remove(long typeId) throws NoSuchTypeException;

	public Type updateImpl(Type type);

	/**
	* Returns the type with the primary key or throws a {@link NoSuchTypeException} if it could not be found.
	*
	* @param typeId the primary key of the type
	* @return the type
	* @throws NoSuchTypeException if a type with the primary key could not be found
	*/
	public Type findByPrimaryKey(long typeId) throws NoSuchTypeException;

	/**
	* Returns the type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param typeId the primary key of the type
	* @return the type, or <code>null</code> if a type with the primary key could not be found
	*/
	public Type fetchByPrimaryKey(long typeId);

	@Override
	public java.util.Map<java.io.Serializable, Type> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the types.
	*
	* @return the types
	*/
	public java.util.List<Type> findAll();

	/**
	* Returns a range of all the types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of types
	* @param end the upper bound of the range of types (not inclusive)
	* @return the range of types
	*/
	public java.util.List<Type> findAll(int start, int end);

	/**
	* Returns an ordered range of all the types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of types
	* @param end the upper bound of the range of types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of types
	*/
	public java.util.List<Type> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Type> orderByComparator);

	/**
	* Returns an ordered range of all the types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link TypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of types
	* @param end the upper bound of the range of types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of types
	*/
	public java.util.List<Type> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Type> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the types from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of types.
	*
	* @return the number of types
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}