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

import com.gleo.plugins.hexiagon.model.AnnouncementImage;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AnnouncementImage in entity cache.
 *
 * @author guillaumelenoir
 * @see AnnouncementImage
 * @generated
 */
@ProviderType
public class AnnouncementImageCacheModel implements CacheModel<AnnouncementImage>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnnouncementImageCacheModel)) {
			return false;
		}

		AnnouncementImageCacheModel announcementImageCacheModel = (AnnouncementImageCacheModel)obj;

		if (announcementImageId == announcementImageCacheModel.announcementImageId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, announcementImageId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{announcementImageId=");
		sb.append(announcementImageId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", announcementId=");
		sb.append(announcementId);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", order=");
		sb.append(order);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AnnouncementImage toEntityModel() {
		AnnouncementImageImpl announcementImageImpl = new AnnouncementImageImpl();

		announcementImageImpl.setAnnouncementImageId(announcementImageId);
		announcementImageImpl.setCompanyId(companyId);
		announcementImageImpl.setGroupId(groupId);
		announcementImageImpl.setUserId(userId);
		announcementImageImpl.setAnnouncementId(announcementId);
		announcementImageImpl.setFileEntryId(fileEntryId);

		if (description == null) {
			announcementImageImpl.setDescription(StringPool.BLANK);
		}
		else {
			announcementImageImpl.setDescription(description);
		}

		announcementImageImpl.setOrder(order);

		announcementImageImpl.resetOriginalValues();

		return announcementImageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		announcementImageId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();

		announcementId = objectInput.readLong();

		fileEntryId = objectInput.readLong();
		description = objectInput.readUTF();

		order = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(announcementImageId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(announcementId);

		objectOutput.writeLong(fileEntryId);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeInt(order);
	}

	public long announcementImageId;
	public long companyId;
	public long groupId;
	public long userId;
	public long announcementId;
	public long fileEntryId;
	public String description;
	public int order;
}