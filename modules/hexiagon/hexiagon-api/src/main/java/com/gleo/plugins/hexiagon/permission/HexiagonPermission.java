package com.gleo.plugins.hexiagon.permission;

import com.gleo.plugins.hexiagon.constants.PortletKeys;
import com.liferay.blogs.kernel.model.BlogsEntry;
import com.liferay.exportimport.kernel.staging.permission.StagingPermissionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseResourcePermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.ResourcePermissionChecker;

import org.osgi.service.component.annotations.Component;


@Component(
		immediate = true,
		property = {"resource.name=" + HexiagonPermission.RESOURCE_NAME},
		service = ResourcePermissionChecker.class
	)
public class HexiagonPermission extends BaseResourcePermissionChecker {

	public static final String RESOURCE_NAME = "com.gleo.plugins.hexiagon.model";
	
	public static void check(
			PermissionChecker permissionChecker, long groupId, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, RESOURCE_NAME, groupId, actionId);
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long groupId, String actionId) {

		return contains(
			permissionChecker, RESOURCE_NAME, PortletKeys.HEXIAGON_PORTLETID, groupId, actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long groupId, String portletId,
		String actionId) {

		Boolean hasPermission = StagingPermissionUtil.hasPermission(
			permissionChecker, groupId, RESOURCE_NAME, groupId, portletId,
			actionId);

		if (hasPermission != null) {
			return hasPermission.booleanValue();
		}

		return permissionChecker.hasPermission(
			groupId, RESOURCE_NAME, groupId, actionId);
	}

	@Override
	public Boolean checkResource(
		PermissionChecker permissionChecker, long classPK, String actionId) {

		return contains(permissionChecker, classPK, actionId);
	}
}
