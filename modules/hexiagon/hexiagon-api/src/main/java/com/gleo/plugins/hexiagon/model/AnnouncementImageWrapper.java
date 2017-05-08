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
 * This class is a wrapper for {@link AnnouncementImage}.
 * </p>
 *
 * @author guillaumelenoir
 * @see AnnouncementImage
 * @generated
 */
@ProviderType
public class AnnouncementImageWrapper implements AnnouncementImage,
	ModelWrapper<AnnouncementImage> {
	public AnnouncementImageWrapper(AnnouncementImage announcementImage) {
		_announcementImage = announcementImage;
	}

	@Override
	public Class<?> getModelClass() {
		return AnnouncementImage.class;
	}

	@Override
	public String getModelClassName() {
		return AnnouncementImage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("announcementImageId", getAnnouncementImageId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("announcementId", getAnnouncementId());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("description", getDescription());
		attributes.put("order", getOrder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long announcementImageId = (Long)attributes.get("announcementImageId");

		if (announcementImageId != null) {
			setAnnouncementImageId(announcementImageId);
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

		Long announcementId = (Long)attributes.get("announcementId");

		if (announcementId != null) {
			setAnnouncementId(announcementId);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}
	}

	@Override
	public AnnouncementImage toEscapedModel() {
		return new AnnouncementImageWrapper(_announcementImage.toEscapedModel());
	}

	@Override
	public AnnouncementImage toUnescapedModel() {
		return new AnnouncementImageWrapper(_announcementImage.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _announcementImage.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _announcementImage.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _announcementImage.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _announcementImage.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<AnnouncementImage> toCacheModel() {
		return _announcementImage.toCacheModel();
	}

	@Override
	public int compareTo(AnnouncementImage announcementImage) {
		return _announcementImage.compareTo(announcementImage);
	}

	/**
	* Returns the order of this announcement image.
	*
	* @return the order of this announcement image
	*/
	@Override
	public int getOrder() {
		return _announcementImage.getOrder();
	}

	@Override
	public int hashCode() {
		return _announcementImage.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _announcementImage.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new AnnouncementImageWrapper((AnnouncementImage)_announcementImage.clone());
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _announcementImage.getDefaultLanguageId();
	}

	/**
	* Returns the description of this announcement image.
	*
	* @return the description of this announcement image
	*/
	@Override
	public java.lang.String getDescription() {
		return _announcementImage.getDescription();
	}

	/**
	* Returns the localized description of this announcement image in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized description of this announcement image
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId) {
		return _announcementImage.getDescription(languageId);
	}

	/**
	* Returns the localized description of this announcement image in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this announcement image
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId,
		boolean useDefault) {
		return _announcementImage.getDescription(languageId, useDefault);
	}

	/**
	* Returns the localized description of this announcement image in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized description of this announcement image
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale) {
		return _announcementImage.getDescription(locale);
	}

	/**
	* Returns the localized description of this announcement image in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this announcement image. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale,
		boolean useDefault) {
		return _announcementImage.getDescription(locale, useDefault);
	}

	@Override
	public java.lang.String getDescriptionCurrentLanguageId() {
		return _announcementImage.getDescriptionCurrentLanguageId();
	}

	@Override
	public java.lang.String getDescriptionCurrentValue() {
		return _announcementImage.getDescriptionCurrentValue();
	}

	/**
	* Returns the user uuid of this announcement image.
	*
	* @return the user uuid of this announcement image
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _announcementImage.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _announcementImage.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _announcementImage.toXmlString();
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _announcementImage.getAvailableLanguageIds();
	}

	/**
	* Returns a map of the locales and localized descriptions of this announcement image.
	*
	* @return the locales and localized descriptions of this announcement image
	*/
	@Override
	public Map<java.util.Locale, java.lang.String> getDescriptionMap() {
		return _announcementImage.getDescriptionMap();
	}

	/**
	* Returns the announcement ID of this announcement image.
	*
	* @return the announcement ID of this announcement image
	*/
	@Override
	public long getAnnouncementId() {
		return _announcementImage.getAnnouncementId();
	}

	/**
	* Returns the announcement image ID of this announcement image.
	*
	* @return the announcement image ID of this announcement image
	*/
	@Override
	public long getAnnouncementImageId() {
		return _announcementImage.getAnnouncementImageId();
	}

	/**
	* Returns the company ID of this announcement image.
	*
	* @return the company ID of this announcement image
	*/
	@Override
	public long getCompanyId() {
		return _announcementImage.getCompanyId();
	}

	/**
	* Returns the file entry ID of this announcement image.
	*
	* @return the file entry ID of this announcement image
	*/
	@Override
	public long getFileEntryId() {
		return _announcementImage.getFileEntryId();
	}

	/**
	* Returns the group ID of this announcement image.
	*
	* @return the group ID of this announcement image
	*/
	@Override
	public long getGroupId() {
		return _announcementImage.getGroupId();
	}

	/**
	* Returns the primary key of this announcement image.
	*
	* @return the primary key of this announcement image
	*/
	@Override
	public long getPrimaryKey() {
		return _announcementImage.getPrimaryKey();
	}

	/**
	* Returns the user ID of this announcement image.
	*
	* @return the user ID of this announcement image
	*/
	@Override
	public long getUserId() {
		return _announcementImage.getUserId();
	}

	@Override
	public void persist() {
		_announcementImage.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {
		_announcementImage.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {
		_announcementImage.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	* Sets the announcement ID of this announcement image.
	*
	* @param announcementId the announcement ID of this announcement image
	*/
	@Override
	public void setAnnouncementId(long announcementId) {
		_announcementImage.setAnnouncementId(announcementId);
	}

	/**
	* Sets the announcement image ID of this announcement image.
	*
	* @param announcementImageId the announcement image ID of this announcement image
	*/
	@Override
	public void setAnnouncementImageId(long announcementImageId) {
		_announcementImage.setAnnouncementImageId(announcementImageId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_announcementImage.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this announcement image.
	*
	* @param companyId the company ID of this announcement image
	*/
	@Override
	public void setCompanyId(long companyId) {
		_announcementImage.setCompanyId(companyId);
	}

	/**
	* Sets the description of this announcement image.
	*
	* @param description the description of this announcement image
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_announcementImage.setDescription(description);
	}

	/**
	* Sets the localized description of this announcement image in the language.
	*
	* @param description the localized description of this announcement image
	* @param locale the locale of the language
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale) {
		_announcementImage.setDescription(description, locale);
	}

	/**
	* Sets the localized description of this announcement image in the language, and sets the default locale.
	*
	* @param description the localized description of this announcement image
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_announcementImage.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
		_announcementImage.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descriptions of this announcement image from the map of locales and localized descriptions.
	*
	* @param descriptionMap the locales and localized descriptions of this announcement image
	*/
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, java.lang.String> descriptionMap) {
		_announcementImage.setDescriptionMap(descriptionMap);
	}

	/**
	* Sets the localized descriptions of this announcement image from the map of locales and localized descriptions, and sets the default locale.
	*
	* @param descriptionMap the locales and localized descriptions of this announcement image
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Locale defaultLocale) {
		_announcementImage.setDescriptionMap(descriptionMap, defaultLocale);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_announcementImage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_announcementImage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_announcementImage.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the file entry ID of this announcement image.
	*
	* @param fileEntryId the file entry ID of this announcement image
	*/
	@Override
	public void setFileEntryId(long fileEntryId) {
		_announcementImage.setFileEntryId(fileEntryId);
	}

	/**
	* Sets the group ID of this announcement image.
	*
	* @param groupId the group ID of this announcement image
	*/
	@Override
	public void setGroupId(long groupId) {
		_announcementImage.setGroupId(groupId);
	}

	@Override
	public void setNew(boolean n) {
		_announcementImage.setNew(n);
	}

	/**
	* Sets the order of this announcement image.
	*
	* @param order the order of this announcement image
	*/
	@Override
	public void setOrder(int order) {
		_announcementImage.setOrder(order);
	}

	/**
	* Sets the primary key of this announcement image.
	*
	* @param primaryKey the primary key of this announcement image
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_announcementImage.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_announcementImage.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this announcement image.
	*
	* @param userId the user ID of this announcement image
	*/
	@Override
	public void setUserId(long userId) {
		_announcementImage.setUserId(userId);
	}

	/**
	* Sets the user uuid of this announcement image.
	*
	* @param userUuid the user uuid of this announcement image
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_announcementImage.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnnouncementImageWrapper)) {
			return false;
		}

		AnnouncementImageWrapper announcementImageWrapper = (AnnouncementImageWrapper)obj;

		if (Objects.equals(_announcementImage,
					announcementImageWrapper._announcementImage)) {
			return true;
		}

		return false;
	}

	@Override
	public AnnouncementImage getWrappedModel() {
		return _announcementImage;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _announcementImage.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _announcementImage.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_announcementImage.resetOriginalValues();
	}

	private final AnnouncementImage _announcementImage;
}