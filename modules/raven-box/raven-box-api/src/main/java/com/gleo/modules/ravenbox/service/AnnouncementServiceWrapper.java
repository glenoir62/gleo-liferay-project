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

package com.gleo.modules.ravenbox.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AnnouncementService}.
 *
 * @author Guillaume Lenoir
 * @see AnnouncementService
 * @generated
 */
@ProviderType
public class AnnouncementServiceWrapper implements AnnouncementService,
	ServiceWrapper<AnnouncementService> {
	public AnnouncementServiceWrapper(AnnouncementService announcementService) {
		_announcementService = announcementService;
	}

	@Override
	public com.gleo.modules.ravenbox.model.Announcement addAnnouncement(
		com.gleo.modules.ravenbox.model.Announcement announcement,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return _announcementService.addAnnouncement(announcement, serviceContext);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Announcement deleteAnnouncement(
		long announcementId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return _announcementService.deleteAnnouncement(announcementId);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Announcement getAnnouncement(
		long announcementId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _announcementService.getAnnouncement(announcementId);
	}

	@Override
	public com.gleo.modules.ravenbox.model.Announcement updateAnnouncement(
		com.gleo.modules.ravenbox.model.Announcement announcement,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return _announcementService.updateAnnouncement(announcement,
			serviceContext);
	}

	@Override
	public int getAnnouncementsCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementService.getAnnouncementsCountByGroupId(groupId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _announcementService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.gleo.modules.ravenbox.model.Announcement> getAnnouncementsByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _announcementService.getAnnouncementsByGroupId(groupId, start,
			end);
	}

	@Override
	public AnnouncementService getWrappedService() {
		return _announcementService;
	}

	@Override
	public void setWrappedService(AnnouncementService announcementService) {
		_announcementService = announcementService;
	}

	private AnnouncementService _announcementService;
}