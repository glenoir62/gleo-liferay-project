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

package com.gleo.modules.ravenbox.service.impl;

import com.gleo.modules.ravenbox.model.Announcement;
import com.gleo.modules.ravenbox.service.base.AnnouncementServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the announcement remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.gleo.modules.ravenbox.service.AnnouncementService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see AnnouncementServiceBaseImpl
 * @see com.gleo.modules.ravenbox.service.AnnouncementServiceUtil
 */
@ProviderType
public class AnnouncementServiceImpl extends AnnouncementServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link
     * com.glenoir.plugins.hexagon.service.AnnouncementServiceUtil} to access
     * the announcement remote service.
     */

    public Announcement addAnnouncement(Announcement announcement, ServiceContext serviceContext)
	    throws SystemException, PrincipalException, PortalException {

//	HexiagonPermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(), "ADD_ANNOUNCEMENT");

	return announcementLocalService.addAnnouncement(announcement, serviceContext);
    }

    public Announcement updateAnnouncement(Announcement announcement, ServiceContext serviceContext)
	    throws SystemException, PrincipalException, PortalException {

//	AnnouncementPermission.check(getPermissionChecker(), announcement.getAnnouncementId(), ActionKeys.UPDATE);

	return announcementLocalService.updateAnnouncement(announcement, serviceContext);
    }

    public Announcement deleteAnnouncement(long announcementId)
	    throws SystemException, PrincipalException, PortalException {

//	AnnouncementPermission.check(getPermissionChecker(), announcementId, ActionKeys.DELETE);

	return announcementLocalService.deleteAnnouncement(announcementId);
    }

    public Announcement getAnnouncement(long announcementId) throws SystemException, PortalException {

//	AnnouncementPermission.check(getPermissionChecker(), announcementId, ActionKeys.VIEW);
	return announcementLocalService.getAnnouncement(announcementId);
    }

    public List<Announcement> getAnnouncementsByGroupId(long groupId, int start, int end) throws SystemException {
	return announcementPersistence.filterFindByGroupId(groupId, start, end);
    }

    public int getAnnouncementsCountByGroupId(long groupId) throws SystemException {
	return announcementPersistence.filterCountByGroupId(groupId);
    }
}