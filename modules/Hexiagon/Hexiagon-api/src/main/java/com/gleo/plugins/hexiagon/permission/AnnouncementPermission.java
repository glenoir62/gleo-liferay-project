
package com.gleo.plugins.hexiagon.permission;

import com.gleo.plugins.hexiagon.constants.PortletKeys;
import com.gleo.plugins.hexiagon.model.Announcement;
import com.gleo.plugins.hexiagon.service.AnnouncementLocalServiceUtil;
import com.liferay.exportimport.kernel.staging.permission.StagingPermissionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;


/**
 * @author guillaumelenoir
 */
public class AnnouncementPermission {

	public static void check(PermissionChecker permissionChecker, Announcement announcement, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, announcement, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, long announcementId, String actionId)
		throws PortalException, SystemException {

		Announcement announcement = AnnouncementLocalServiceUtil.getAnnouncement(announcementId);

		check(permissionChecker, announcement, actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker, Announcement announcement, String actionId)
		throws PortalException, SystemException {

		Boolean hasPermission =
			StagingPermissionUtil.hasPermission(permissionChecker, announcement.getGroupId(), Announcement.class.getName(), announcement.getAnnouncementId(), PortletKeys.ANNOUNCEMENT_PORTLETID, actionId);

		if (hasPermission != null) {
			return hasPermission.booleanValue();
		}

		if (permissionChecker.hasOwnerPermission(
				announcement.getCompanyId(), Announcement.class.getName(),
				announcement.getAnnouncementId(), announcement.getUserId(), actionId)) {

			return true;
		}
		
		return permissionChecker.hasPermission(announcement.getGroupId(), Announcement.class.getName(), announcement.getAnnouncementId(), actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker, long announcementId, String actionId)
		throws PortalException, SystemException {

		Announcement announcement = AnnouncementLocalServiceUtil.getAnnouncement(announcementId);

		return contains(permissionChecker, announcement, actionId);
	}
}
