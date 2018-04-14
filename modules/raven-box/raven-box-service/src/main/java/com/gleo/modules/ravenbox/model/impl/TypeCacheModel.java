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

import com.gleo.modules.ravenbox.model.Type;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Type in entity cache.
 *
 * @author Guillaume Lenoir
 * @see Type
 * @generated
 */
@ProviderType
public class TypeCacheModel implements CacheModel<Type>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TypeCacheModel)) {
			return false;
		}

		TypeCacheModel typeCacheModel = (TypeCacheModel)obj;

		if (typeId == typeCacheModel.typeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, typeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{typeId=");
		sb.append(typeId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", order=");
		sb.append(order);
		sb.append(", description=");
		sb.append(description);
		sb.append(", color=");
		sb.append(color);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Type toEntityModel() {
		TypeImpl typeImpl = new TypeImpl();

		typeImpl.setTypeId(typeId);

		if (name == null) {
			typeImpl.setName(StringPool.BLANK);
		}
		else {
			typeImpl.setName(name);
		}

		typeImpl.setGroupId(groupId);
		typeImpl.setCompanyId(companyId);
		typeImpl.setOrder(order);

		if (description == null) {
			typeImpl.setDescription(StringPool.BLANK);
		}
		else {
			typeImpl.setDescription(description);
		}

		if (color == null) {
			typeImpl.setColor(StringPool.BLANK);
		}
		else {
			typeImpl.setColor(color);
		}

		typeImpl.resetOriginalValues();

		return typeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		typeId = objectInput.readLong();
		name = objectInput.readUTF();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		order = objectInput.readInt();
		description = objectInput.readUTF();
		color = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(typeId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeInt(order);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (color == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(color);
		}
	}

	public long typeId;
	public String name;
	public long groupId;
	public long companyId;
	public int order;
	public String description;
	public String color;
}