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

package com.gleo.plugins.hexiagon.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.gleo.plugins.hexiagon.model.Favorite;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Favorite in entity cache.
 *
 * @author guillaumelenoir
 * @see Favorite
 * @generated
 */
@ProviderType
public class FavoriteCacheModel implements CacheModel<Favorite>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FavoriteCacheModel)) {
			return false;
		}

		FavoriteCacheModel favoriteCacheModel = (FavoriteCacheModel)obj;

		if (favoriteId == favoriteCacheModel.favoriteId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, favoriteId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{favoriteId=");
		sb.append(favoriteId);
		sb.append(", announcementId=");
		sb.append(announcementId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Favorite toEntityModel() {
		FavoriteImpl favoriteImpl = new FavoriteImpl();

		favoriteImpl.setFavoriteId(favoriteId);
		favoriteImpl.setAnnouncementId(announcementId);
		favoriteImpl.setCompanyId(companyId);
		favoriteImpl.setGroupId(groupId);
		favoriteImpl.setUserId(userId);

		favoriteImpl.resetOriginalValues();

		return favoriteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		favoriteId = objectInput.readLong();

		announcementId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(favoriteId);

		objectOutput.writeLong(announcementId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);
	}

	public long favoriteId;
	public long announcementId;
	public long companyId;
	public long groupId;
	public long userId;
}