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

package com.gleo.modules.ravenbox.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Announcement service. Represents a row in the &quot;ravenbox_Announcement&quot; database table, with each column mapped to a property of this class.
 *
 * @author Guillaume Lenoir
 * @see AnnouncementModel
 * @see com.gleo.modules.ravenbox.model.impl.AnnouncementImpl
 * @see com.gleo.modules.ravenbox.model.impl.AnnouncementModelImpl
 * @generated
 */
@ImplementationClassName("com.gleo.modules.ravenbox.model.impl.AnnouncementImpl")
@ProviderType
public interface Announcement extends AnnouncementModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.gleo.modules.ravenbox.model.impl.AnnouncementImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Announcement, Long> ANNOUNCEMENT_ID_ACCESSOR = new Accessor<Announcement, Long>() {
			@Override
			public Long get(Announcement announcement) {
				return announcement.getAnnouncementId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Announcement> getTypeClass() {
				return Announcement.class;
			}
		};

	public void setAnnouncementImages(
		java.util.List<AnnouncementImage> announcementImages);

	public boolean isFavorite(long userId);

	public boolean isValidAgreement();

	public void setValidAgreement(boolean isValidAgreement);

	public java.util.List<AnnouncementImage> getAnnouncementImages();

	public java.util.List<AnnouncementImage> getImages();

	public AnnouncementImage getImage();

	public Type getType();

	public java.lang.String getSummary(java.util.Locale locale);

	public int getMessagesCount();

	/**
	* @return
	*/
	public int getRatingsCount();

	/**
	* @return
	*/
	public java.lang.String getCurrencySymbol();

	/**
	* @param locale
	* @return
	*/
	public java.lang.String getStatus(java.util.Locale locale);

	public com.liferay.portal.kernel.model.User getUser();

	/**
	* @param locale
	* @return
	*/
	public com.liferay.portal.kernel.model.Country getCountry();

	/**
	* @param locale
	* @return
	*/
	public com.liferay.portal.kernel.model.Region getRegion();

	/**
	* @param locale
	* @return
	*/
	public java.lang.String getCountryName(java.util.Locale locale);

	/**
	* @param liferayPortletRequest
	* @param liferayPortletResponse
	* @return
	* @throws WindowStateException
	*/
	public java.lang.String getAnnouncementUrl(
		com.liferay.portal.kernel.portlet.LiferayPortletRequest liferayPortletRequest,
		com.liferay.portal.kernel.portlet.LiferayPortletResponse liferayPortletResponse)
		throws java.lang.Exception;

	public boolean hasCategories();
}