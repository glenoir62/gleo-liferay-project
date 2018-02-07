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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Announcement. This utility wraps
 * {@link com.gleo.modules.ravenbox.service.impl.AnnouncementServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Guillaume Lenoir
 * @see AnnouncementService
 * @see com.gleo.modules.ravenbox.service.base.AnnouncementServiceBaseImpl
 * @see com.gleo.modules.ravenbox.service.impl.AnnouncementServiceImpl
 * @generated
 */
@ProviderType
public class AnnouncementServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.gleo.modules.ravenbox.service.impl.AnnouncementServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.gleo.modules.ravenbox.model.Announcement addAnnouncement(
		com.gleo.modules.ravenbox.model.Announcement announcement,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return getService().addAnnouncement(announcement, serviceContext);
	}

	public static com.gleo.modules.ravenbox.model.Announcement deleteAnnouncement(
		long announcementId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return getService().deleteAnnouncement(announcementId);
	}

	public static com.gleo.modules.ravenbox.model.Announcement getAnnouncement(
		long announcementId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAnnouncement(announcementId);
	}

	public static com.gleo.modules.ravenbox.model.Announcement updateAnnouncement(
		com.gleo.modules.ravenbox.model.Announcement announcement,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		return getService().updateAnnouncement(announcement, serviceContext);
	}

	public static int getAnnouncementsCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAnnouncementsCountByGroupId(groupId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.gleo.modules.ravenbox.model.Announcement> getAnnouncementsByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAnnouncementsByGroupId(groupId, start, end);
	}

	public static AnnouncementService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AnnouncementService, AnnouncementService> _serviceTracker =
		ServiceTrackerFactory.open(AnnouncementService.class);
}