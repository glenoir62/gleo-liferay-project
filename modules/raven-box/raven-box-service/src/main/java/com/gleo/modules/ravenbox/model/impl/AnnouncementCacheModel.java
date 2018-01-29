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

package com.gleo.modules.ravenbox.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.gleo.modules.ravenbox.model.Announcement;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Announcement in entity cache.
 *
 * @author Guillaume Lenoir
 * @see Announcement
 * @generated
 */
@ProviderType
public class AnnouncementCacheModel implements CacheModel<Announcement>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnnouncementCacheModel)) {
			return false;
		}

		AnnouncementCacheModel announcementCacheModel = (AnnouncementCacheModel)obj;

		if (announcementId == announcementCacheModel.announcementId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, announcementId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", announcementId=");
		sb.append(announcementId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", typeId=");
		sb.append(typeId);
		sb.append(", folderId=");
		sb.append(folderId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", currencyId=");
		sb.append(currencyId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", price=");
		sb.append(price);
		sb.append(", content=");
		sb.append(content);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", countryId=");
		sb.append(countryId);
		sb.append(", regionId=");
		sb.append(regionId);
		sb.append(", city=");
		sb.append(city);
		sb.append(", site=");
		sb.append(site);
		sb.append(", building=");
		sb.append(building);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Announcement toEntityModel() {
		AnnouncementImpl announcementImpl = new AnnouncementImpl();

		if (uuid == null) {
			announcementImpl.setUuid(StringPool.BLANK);
		}
		else {
			announcementImpl.setUuid(uuid);
		}

		announcementImpl.setAnnouncementId(announcementId);
		announcementImpl.setCompanyId(companyId);
		announcementImpl.setGroupId(groupId);
		announcementImpl.setUserId(userId);
		announcementImpl.setTypeId(typeId);
		announcementImpl.setFolderId(folderId);

		if (userName == null) {
			announcementImpl.setUserName(StringPool.BLANK);
		}
		else {
			announcementImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			announcementImpl.setCreateDate(null);
		}
		else {
			announcementImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			announcementImpl.setModifiedDate(null);
		}
		else {
			announcementImpl.setModifiedDate(new Date(modifiedDate));
		}

		announcementImpl.setCurrencyId(currencyId);

		if (title == null) {
			announcementImpl.setTitle(StringPool.BLANK);
		}
		else {
			announcementImpl.setTitle(title);
		}

		if (emailAddress == null) {
			announcementImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			announcementImpl.setEmailAddress(emailAddress);
		}

		if (phoneNumber == null) {
			announcementImpl.setPhoneNumber(StringPool.BLANK);
		}
		else {
			announcementImpl.setPhoneNumber(phoneNumber);
		}

		announcementImpl.setPrice(price);

		if (content == null) {
			announcementImpl.setContent(StringPool.BLANK);
		}
		else {
			announcementImpl.setContent(content);
		}

		announcementImpl.setStatus(status);
		announcementImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			announcementImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			announcementImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			announcementImpl.setStatusDate(null);
		}
		else {
			announcementImpl.setStatusDate(new Date(statusDate));
		}

		announcementImpl.setCountryId(countryId);
		announcementImpl.setRegionId(regionId);

		if (city == null) {
			announcementImpl.setCity(StringPool.BLANK);
		}
		else {
			announcementImpl.setCity(city);
		}

		if (site == null) {
			announcementImpl.setSite(StringPool.BLANK);
		}
		else {
			announcementImpl.setSite(site);
		}

		if (building == null) {
			announcementImpl.setBuilding(StringPool.BLANK);
		}
		else {
			announcementImpl.setBuilding(building);
		}

		announcementImpl.resetOriginalValues();

		return announcementImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		announcementId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();

		typeId = objectInput.readLong();

		folderId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		currencyId = objectInput.readLong();
		title = objectInput.readUTF();
		emailAddress = objectInput.readUTF();
		phoneNumber = objectInput.readUTF();

		price = objectInput.readLong();
		content = objectInput.readUTF();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();

		countryId = objectInput.readLong();

		regionId = objectInput.readLong();
		city = objectInput.readUTF();
		site = objectInput.readUTF();
		building = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(announcementId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(typeId);

		objectOutput.writeLong(folderId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(currencyId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (phoneNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phoneNumber);
		}

		objectOutput.writeLong(price);

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		objectOutput.writeLong(countryId);

		objectOutput.writeLong(regionId);

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (site == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(site);
		}

		if (building == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(building);
		}
	}

	public String uuid;
	public long announcementId;
	public long companyId;
	public long groupId;
	public long userId;
	public long typeId;
	public long folderId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long currencyId;
	public String title;
	public String emailAddress;
	public String phoneNumber;
	public long price;
	public String content;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long countryId;
	public long regionId;
	public String city;
	public String site;
	public String building;
}