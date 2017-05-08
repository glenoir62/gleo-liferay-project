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

package com.gleo.plugins.hexiagon.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the Favorite service. Represents a row in the &quot;Hexiagon_Favorite&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.gleo.plugins.hexiagon.model.impl.FavoriteModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.gleo.plugins.hexiagon.model.impl.FavoriteImpl}.
 * </p>
 *
 * @author guillaumelenoir
 * @see Favorite
 * @see com.gleo.plugins.hexiagon.model.impl.FavoriteImpl
 * @see com.gleo.plugins.hexiagon.model.impl.FavoriteModelImpl
 * @generated
 */
@ProviderType
public interface FavoriteModel extends BaseModel<Favorite>, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a favorite model instance should use the {@link Favorite} interface instead.
	 */

	/**
	 * Returns the primary key of this favorite.
	 *
	 * @return the primary key of this favorite
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this favorite.
	 *
	 * @param primaryKey the primary key of this favorite
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the favorite ID of this favorite.
	 *
	 * @return the favorite ID of this favorite
	 */
	public long getFavoriteId();

	/**
	 * Sets the favorite ID of this favorite.
	 *
	 * @param favoriteId the favorite ID of this favorite
	 */
	public void setFavoriteId(long favoriteId);

	/**
	 * Returns the announcement ID of this favorite.
	 *
	 * @return the announcement ID of this favorite
	 */
	public long getAnnouncementId();

	/**
	 * Sets the announcement ID of this favorite.
	 *
	 * @param announcementId the announcement ID of this favorite
	 */
	public void setAnnouncementId(long announcementId);

	/**
	 * Returns the company ID of this favorite.
	 *
	 * @return the company ID of this favorite
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this favorite.
	 *
	 * @param companyId the company ID of this favorite
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the group ID of this favorite.
	 *
	 * @return the group ID of this favorite
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this favorite.
	 *
	 * @param groupId the group ID of this favorite
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the user ID of this favorite.
	 *
	 * @return the user ID of this favorite
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this favorite.
	 *
	 * @param userId the user ID of this favorite
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this favorite.
	 *
	 * @return the user uuid of this favorite
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this favorite.
	 *
	 * @param userUuid the user uuid of this favorite
	 */
	public void setUserUuid(String userUuid);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Favorite favorite);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Favorite> toCacheModel();

	@Override
	public Favorite toEscapedModel();

	@Override
	public Favorite toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}