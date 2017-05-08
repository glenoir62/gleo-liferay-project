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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author guillaumelenoir
 * @generated
 */
@ProviderType
public class FavoriteSoap implements Serializable {
	public static FavoriteSoap toSoapModel(Favorite model) {
		FavoriteSoap soapModel = new FavoriteSoap();

		soapModel.setFavoriteId(model.getFavoriteId());
		soapModel.setAnnouncementId(model.getAnnouncementId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());

		return soapModel;
	}

	public static FavoriteSoap[] toSoapModels(Favorite[] models) {
		FavoriteSoap[] soapModels = new FavoriteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FavoriteSoap[][] toSoapModels(Favorite[][] models) {
		FavoriteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FavoriteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FavoriteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FavoriteSoap[] toSoapModels(List<Favorite> models) {
		List<FavoriteSoap> soapModels = new ArrayList<FavoriteSoap>(models.size());

		for (Favorite model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FavoriteSoap[soapModels.size()]);
	}

	public FavoriteSoap() {
	}

	public long getPrimaryKey() {
		return _favoriteId;
	}

	public void setPrimaryKey(long pk) {
		setFavoriteId(pk);
	}

	public long getFavoriteId() {
		return _favoriteId;
	}

	public void setFavoriteId(long favoriteId) {
		_favoriteId = favoriteId;
	}

	public long getAnnouncementId() {
		return _announcementId;
	}

	public void setAnnouncementId(long announcementId) {
		_announcementId = announcementId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	private long _favoriteId;
	private long _announcementId;
	private long _companyId;
	private long _groupId;
	private long _userId;
}