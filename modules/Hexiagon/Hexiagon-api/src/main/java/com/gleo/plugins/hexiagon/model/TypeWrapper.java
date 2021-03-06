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
 * This class is a wrapper for {@link Type}.
 * </p>
 *
 * @author guillaumelenoir
 * @see Type
 * @generated
 */
@ProviderType
public class TypeWrapper implements Type, ModelWrapper<Type> {
	public TypeWrapper(Type type) {
		_type = type;
	}

	@Override
	public Class<?> getModelClass() {
		return Type.class;
	}

	@Override
	public String getModelClassName() {
		return Type.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("typeId", getTypeId());
		attributes.put("name", getName());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("order", getOrder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}
	}

	@Override
	public Type toEscapedModel() {
		return new TypeWrapper(_type.toEscapedModel());
	}

	@Override
	public Type toUnescapedModel() {
		return new TypeWrapper(_type.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _type.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _type.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _type.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _type.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Type> toCacheModel() {
		return _type.toCacheModel();
	}

	@Override
	public int compareTo(Type type) {
		return _type.compareTo(type);
	}

	/**
	* Returns the order of this type.
	*
	* @return the order of this type
	*/
	@Override
	public int getOrder() {
		return _type.getOrder();
	}

	@Override
	public int hashCode() {
		return _type.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _type.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new TypeWrapper((Type)_type.clone());
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _type.getDefaultLanguageId();
	}

	/**
	* Returns the name of this type.
	*
	* @return the name of this type
	*/
	@Override
	public java.lang.String getName() {
		return _type.getName();
	}

	/**
	* Returns the localized name of this type in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized name of this type
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId) {
		return _type.getName(languageId);
	}

	/**
	* Returns the localized name of this type in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this type
	*/
	@Override
	public java.lang.String getName(java.lang.String languageId,
		boolean useDefault) {
		return _type.getName(languageId, useDefault);
	}

	/**
	* Returns the localized name of this type in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized name of this type
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale) {
		return _type.getName(locale);
	}

	/**
	* Returns the localized name of this type in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized name of this type. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getName(java.util.Locale locale, boolean useDefault) {
		return _type.getName(locale, useDefault);
	}

	@Override
	public java.lang.String getNameCurrentLanguageId() {
		return _type.getNameCurrentLanguageId();
	}

	@Override
	public java.lang.String getNameCurrentValue() {
		return _type.getNameCurrentValue();
	}

	@Override
	public java.lang.String toString() {
		return _type.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _type.toXmlString();
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _type.getAvailableLanguageIds();
	}

	/**
	* Returns a map of the locales and localized names of this type.
	*
	* @return the locales and localized names of this type
	*/
	@Override
	public Map<java.util.Locale, java.lang.String> getNameMap() {
		return _type.getNameMap();
	}

	/**
	* Returns the company ID of this type.
	*
	* @return the company ID of this type
	*/
	@Override
	public long getCompanyId() {
		return _type.getCompanyId();
	}

	/**
	* Returns the group ID of this type.
	*
	* @return the group ID of this type
	*/
	@Override
	public long getGroupId() {
		return _type.getGroupId();
	}

	/**
	* Returns the primary key of this type.
	*
	* @return the primary key of this type
	*/
	@Override
	public long getPrimaryKey() {
		return _type.getPrimaryKey();
	}

	/**
	* Returns the type ID of this type.
	*
	* @return the type ID of this type
	*/
	@Override
	public long getTypeId() {
		return _type.getTypeId();
	}

	@Override
	public void persist() {
		_type.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {
		_type.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {
		_type.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_type.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this type.
	*
	* @param companyId the company ID of this type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_type.setCompanyId(companyId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_type.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_type.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_type.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this type.
	*
	* @param groupId the group ID of this type
	*/
	@Override
	public void setGroupId(long groupId) {
		_type.setGroupId(groupId);
	}

	/**
	* Sets the name of this type.
	*
	* @param name the name of this type
	*/
	@Override
	public void setName(java.lang.String name) {
		_type.setName(name);
	}

	/**
	* Sets the localized name of this type in the language.
	*
	* @param name the localized name of this type
	* @param locale the locale of the language
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale) {
		_type.setName(name, locale);
	}

	/**
	* Sets the localized name of this type in the language, and sets the default locale.
	*
	* @param name the localized name of this type
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setName(java.lang.String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_type.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(java.lang.String languageId) {
		_type.setNameCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized names of this type from the map of locales and localized names.
	*
	* @param nameMap the locales and localized names of this type
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, java.lang.String> nameMap) {
		_type.setNameMap(nameMap);
	}

	/**
	* Sets the localized names of this type from the map of locales and localized names, and sets the default locale.
	*
	* @param nameMap the locales and localized names of this type
	* @param defaultLocale the default locale
	*/
	@Override
	public void setNameMap(Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Locale defaultLocale) {
		_type.setNameMap(nameMap, defaultLocale);
	}

	@Override
	public void setNew(boolean n) {
		_type.setNew(n);
	}

	/**
	* Sets the order of this type.
	*
	* @param order the order of this type
	*/
	@Override
	public void setOrder(int order) {
		_type.setOrder(order);
	}

	/**
	* Sets the primary key of this type.
	*
	* @param primaryKey the primary key of this type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_type.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_type.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the type ID of this type.
	*
	* @param typeId the type ID of this type
	*/
	@Override
	public void setTypeId(long typeId) {
		_type.setTypeId(typeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TypeWrapper)) {
			return false;
		}

		TypeWrapper typeWrapper = (TypeWrapper)obj;

		if (Objects.equals(_type, typeWrapper._type)) {
			return true;
		}

		return false;
	}

	@Override
	public Type getWrappedModel() {
		return _type;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _type.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _type.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_type.resetOriginalValues();
	}

	private final Type _type;
}