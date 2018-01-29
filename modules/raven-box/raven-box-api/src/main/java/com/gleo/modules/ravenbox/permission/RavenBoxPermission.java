package com.gleo.modules.ravenbox.permission;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.liferay.exportimport.kernel.staging.permission.StagingPermissionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;

@OSGiBeanProperties(
	property = {"resource.name=" + RavenBoxPermission.RESOURCE_NAME}
)
public class RavenBoxPermission {

    public static final String RESOURCE_NAME = "com.gleo.plugins.ravenbox.model";

    public static void check(PermissionChecker permissionChecker, long groupId, String actionId)
	    throws PortalException {

	if (!contains(permissionChecker, groupId, actionId)) {
	    throw new PrincipalException();
	}
    }

    public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId) {

	Boolean hasPermission = StagingPermissionUtil.hasPermission(permissionChecker, groupId, RESOURCE_NAME, groupId,
		RavenBoxPortletKeys.RAVEN_BOX, actionId);

	if (hasPermission != null) {
	    return hasPermission.booleanValue();
	}

	return permissionChecker.hasPermission(groupId, RESOURCE_NAME, groupId, actionId);
    }
}
