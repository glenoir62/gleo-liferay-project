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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.gleo.plugins.hexiagon.service.http.AnnouncementServiceSoap}.
 *
 * @author guillaumelenoir
 * @see com.gleo.plugins.hexiagon.service.http.AnnouncementServiceSoap
 * @generated
 */
@ProviderType
public class AnnouncementSoap implements Serializable {
	public static AnnouncementSoap toSoapModel(Announcement model) {
		AnnouncementSoap soapModel = new AnnouncementSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAnnouncementId(model.getAnnouncementId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setTypeId(model.getTypeId());
		soapModel.setFolderId(model.getFolderId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCurrencyId(model.getCurrencyId());
		soapModel.setTitle(model.getTitle());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setPhoneNumber(model.getPhoneNumber());
		soapModel.setPrice(model.getPrice());
		soapModel.setContent(model.getContent());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setCountryId(model.getCountryId());
		soapModel.setRegionId(model.getRegionId());
		soapModel.setCity(model.getCity());
		soapModel.setSite(model.getSite());
		soapModel.setBuilding(model.getBuilding());

		return soapModel;
	}

	public static AnnouncementSoap[] toSoapModels(Announcement[] models) {
		AnnouncementSoap[] soapModels = new AnnouncementSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AnnouncementSoap[][] toSoapModels(Announcement[][] models) {
		AnnouncementSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AnnouncementSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnnouncementSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AnnouncementSoap[] toSoapModels(List<Announcement> models) {
		List<AnnouncementSoap> soapModels = new ArrayList<AnnouncementSoap>(models.size());

		for (Announcement model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AnnouncementSoap[soapModels.size()]);
	}

	public AnnouncementSoap() {
	}

	public long getPrimaryKey() {
		return _announcementId;
	}

	public void setPrimaryKey(long pk) {
		setAnnouncementId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
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

	public long getTypeId() {
		return _typeId;
	}

	public void setTypeId(long typeId) {
		_typeId = typeId;
	}

	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getCurrencyId() {
		return _currencyId;
	}

	public void setCurrencyId(long currencyId) {
		_currencyId = currencyId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return _phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public long getPrice() {
		return _price;
	}

	public void setPrice(long price) {
		_price = price;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public long getCountryId() {
		return _countryId;
	}

	public void setCountryId(long countryId) {
		_countryId = countryId;
	}

	public long getRegionId() {
		return _regionId;
	}

	public void setRegionId(long regionId) {
		_regionId = regionId;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getSite() {
		return _site;
	}

	public void setSite(String site) {
		_site = site;
	}

	public String getBuilding() {
		return _building;
	}

	public void setBuilding(String building) {
		_building = building;
	}

	private String _uuid;
	private long _announcementId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private long _typeId;
	private long _folderId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _currencyId;
	private String _title;
	private String _emailAddress;
	private String _phoneNumber;
	private long _price;
	private String _content;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _countryId;
	private long _regionId;
	private String _city;
	private String _site;
	private String _building;
}