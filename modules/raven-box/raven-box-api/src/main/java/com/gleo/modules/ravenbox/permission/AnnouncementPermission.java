
package com.gleo.modules.ravenbox.permission;

import org.osgi.service.component.annotations.Component;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.gleo.modules.ravenbox.model.Announcement;
import com.gleo.modules.ravenbox.service.AnnouncementLocalService;
import com.liferay.exportimport.kernel.staging.permission.StagingPermissionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import aQute.bnd.annotation.component.Reference;

/**
 * @author guillaumelenoir
 *
 */

@Component(
		property = {"model.class.name=com.gleo.modules.ravenbox.model.Announcement"},
		service = BaseModelPermissionChecker.class
	)
public class AnnouncementPermission implements BaseModelPermissionChecker {

	/**
	 * @param permissionChecker
	 * @param announcement
	 * @param actionId
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static void check(PermissionChecker permissionChecker, Announcement announcement, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, announcement, actionId)) {
			throw new PrincipalException();
		}
	}

	/**
	 * @param permissionChecker
	 * @param announcementId
	 * @param actionId
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static void check(PermissionChecker permissionChecker, long announcementId, String actionId)
			throws PortalException, SystemException {

		Announcement announcement = announcementLocalService.getAnnouncement(announcementId);

		check(permissionChecker, announcement, actionId);
	}

	/**
	 * @param permissionChecker
	 * @param announcement
	 * @param actionId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static boolean contains(PermissionChecker permissionChecker, Announcement announcement, String actionId)
			throws PortalException, SystemException {

		Boolean hasPermission = StagingPermissionUtil.hasPermission(permissionChecker, announcement.getGroupId(),
				Announcement.class.getName(), announcement.getAnnouncementId(),
				RavenBoxPortletKeys.ANNOUNCEMENTS_CONFIGURATION, actionId);

		if (hasPermission != null) {
			return hasPermission.booleanValue();
		}

		if (permissionChecker.hasOwnerPermission(announcement.getCompanyId(), Announcement.class.getName(),
				announcement.getAnnouncementId(), announcement.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(announcement.getGroupId(), Announcement.class.getName(),
				announcement.getAnnouncementId(), actionId);
	}

	/**
	 * @param permissionChecker
	 * @param announcementId
	 * @param actionId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static boolean contains(PermissionChecker permissionChecker, long announcementId, String actionId)
			throws PortalException, SystemException {

		Announcement announcement = announcementLocalService.getAnnouncement(announcementId);

		return contains(permissionChecker, announcement, actionId);
	}

	@Reference
	protected void setTypeLocalService(AnnouncementLocalService announcementLocalService) {
		AnnouncementPermission.announcementLocalService = announcementLocalService;
	}

	private static AnnouncementLocalService announcementLocalService;

	@Override
	public void checkBaseModel(PermissionChecker permissionChecker, long groupId, long primaryKey, String actionId)
			throws PortalException {
		check(permissionChecker, primaryKey, actionId);
	}
}
