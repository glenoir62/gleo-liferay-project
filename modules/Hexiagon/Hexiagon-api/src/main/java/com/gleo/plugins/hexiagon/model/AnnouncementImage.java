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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the AnnouncementImage service. Represents a row in the &quot;Hexiagon_AnnouncementImage&quot; database table, with each column mapped to a property of this class.
 *
 * @author guillaumelenoir
 * @see AnnouncementImageModel
 * @see com.gleo.plugins.hexiagon.model.impl.AnnouncementImageImpl
 * @see com.gleo.plugins.hexiagon.model.impl.AnnouncementImageModelImpl
 * @generated
 */
@ImplementationClassName("com.gleo.plugins.hexiagon.model.impl.AnnouncementImageImpl")
@ProviderType
public interface AnnouncementImage extends AnnouncementImageModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.gleo.plugins.hexiagon.model.impl.AnnouncementImageImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AnnouncementImage, Long> ANNOUNCEMENT_IMAGE_ID_ACCESSOR =
		new Accessor<AnnouncementImage, Long>() {
			@Override
			public Long get(AnnouncementImage announcementImage) {
				return announcementImage.getAnnouncementImageId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AnnouncementImage> getTypeClass() {
				return AnnouncementImage.class;
			}
		};

	public java.lang.Boolean isActive();

	public void setActive(java.lang.Boolean isActive);

	public java.io.InputStream getInputStream();

	public void setInputStream(java.io.InputStream inputStream);

	public java.lang.String getImageURL(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay);
}