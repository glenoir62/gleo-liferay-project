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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Favorite}.
 * </p>
 *
 * @author guillaumelenoir
 * @see Favorite
 * @generated
 */
@ProviderType
public class FavoriteWrapper implements Favorite, ModelWrapper<Favorite> {
	public FavoriteWrapper(Favorite favorite) {
		_favorite = favorite;
	}

	@Override
	public Class<?> getModelClass() {
		return Favorite.class;
	}

	@Override
	public String getModelClassName() {
		return Favorite.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("favoriteId", getFavoriteId());
		attributes.put("announcementId", getAnnouncementId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long favoriteId = (Long)attributes.get("favoriteId");

		if (favoriteId != null) {
			setFavoriteId(favoriteId);
		}

		Long announcementId = (Long)attributes.get("announcementId");

		if (announcementId != null) {
			setAnnouncementId(announcementId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public Favorite toEscapedModel() {
		return new FavoriteWrapper(_favorite.toEscapedModel());
	}

	@Override
	public Favorite toUnescapedModel() {
		return new FavoriteWrapper(_favorite.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _favorite.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _favorite.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _favorite.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _favorite.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Favorite> toCacheModel() {
		return _favorite.toCacheModel();
	}

	@Override
	public int compareTo(Favorite favorite) {
		return _favorite.compareTo(favorite);
	}

	@Override
	public int hashCode() {
		return _favorite.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _favorite.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new FavoriteWrapper((Favorite)_favorite.clone());
	}

	/**
	* Returns the user uuid of this favorite.
	*
	* @return the user uuid of this favorite
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _favorite.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _favorite.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _favorite.toXmlString();
	}

	/**
	* Returns the announcement ID of this favorite.
	*
	* @return the announcement ID of this favorite
	*/
	@Override
	public long getAnnouncementId() {
		return _favorite.getAnnouncementId();
	}

	/**
	* Returns the company ID of this favorite.
	*
	* @return the company ID of this favorite
	*/
	@Override
	public long getCompanyId() {
		return _favorite.getCompanyId();
	}

	/**
	* Returns the favorite ID of this favorite.
	*
	* @return the favorite ID of this favorite
	*/
	@Override
	public long getFavoriteId() {
		return _favorite.getFavoriteId();
	}

	/**
	* Returns the group ID of this favorite.
	*
	* @return the group ID of this favorite
	*/
	@Override
	public long getGroupId() {
		return _favorite.getGroupId();
	}

	/**
	* Returns the primary key of this favorite.
	*
	* @return the primary key of this favorite
	*/
	@Override
	public long getPrimaryKey() {
		return _favorite.getPrimaryKey();
	}

	/**
	* Returns the user ID of this favorite.
	*
	* @return the user ID of this favorite
	*/
	@Override
	public long getUserId() {
		return _favorite.getUserId();
	}

	@Override
	public void persist() {
		_favorite.persist();
	}

	/**
	* Sets the announcement ID of this favorite.
	*
	* @param announcementId the announcement ID of this favorite
	*/
	@Override
	public void setAnnouncementId(long announcementId) {
		_favorite.setAnnouncementId(announcementId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_favorite.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this favorite.
	*
	* @param companyId the company ID of this favorite
	*/
	@Override
	public void setCompanyId(long companyId) {
		_favorite.setCompanyId(companyId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_favorite.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_favorite.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_favorite.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the favorite ID of this favorite.
	*
	* @param favoriteId the favorite ID of this favorite
	*/
	@Override
	public void setFavoriteId(long favoriteId) {
		_favorite.setFavoriteId(favoriteId);
	}

	/**
	* Sets the group ID of this favorite.
	*
	* @param groupId the group ID of this favorite
	*/
	@Override
	public void setGroupId(long groupId) {
		_favorite.setGroupId(groupId);
	}

	@Override
	public void setNew(boolean n) {
		_favorite.setNew(n);
	}

	/**
	* Sets the primary key of this favorite.
	*
	* @param primaryKey the primary key of this favorite
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_favorite.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_favorite.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this favorite.
	*
	* @param userId the user ID of this favorite
	*/
	@Override
	public void setUserId(long userId) {
		_favorite.setUserId(userId);
	}

	/**
	* Sets the user uuid of this favorite.
	*
	* @param userUuid the user uuid of this favorite
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_favorite.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FavoriteWrapper)) {
			return false;
		}

		FavoriteWrapper favoriteWrapper = (FavoriteWrapper)obj;

		if (Objects.equals(_favorite, favoriteWrapper._favorite)) {
			return true;
		}

		return false;
	}

	@Override
	public Favorite getWrappedModel() {
		return _favorite;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _favorite.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _favorite.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_favorite.resetOriginalValues();
	}

	private final Favorite _favorite;
}