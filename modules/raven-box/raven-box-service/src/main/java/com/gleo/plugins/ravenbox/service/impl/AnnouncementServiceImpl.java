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

package com.gleo.plugins.ravenbox.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.gleo.plugins.ravenbox.service.base.AnnouncementServiceBaseImpl;

/**
 * The implementation of the announcement remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.gleo.plugins.ravenbox.service.AnnouncementService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see AnnouncementServiceBaseImpl
 * @see com.gleo.plugins.ravenbox.service.AnnouncementServiceUtil
 */
@ProviderType
public class AnnouncementServiceImpl extends AnnouncementServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.gleo.plugins.ravenbox.service.AnnouncementServiceUtil} to access the announcement remote service.
	 */
}