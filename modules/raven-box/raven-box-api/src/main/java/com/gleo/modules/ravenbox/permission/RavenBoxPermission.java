
package com.gleo.modules.ravenbox.permission;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseResourcePermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.ResourcePermissionChecker;

import org.osgi.service.component.annotations.Component;

/**
 * @author guillaumelenoir
 *
 */
@Component(immediate = true, property = {
	"resource.name=" + RavenBoxPermission.RESOURCE_NAME }, service = ResourcePermissionChecker.class)
public class RavenBoxPermission extends BaseResourcePermissionChecker {

    public static final String RESOURCE_NAME = "com.gleo.modules.ravenbox.model";

    public static void check(PermissionChecker permissionChecker, long groupId, String actionId)
	    throws PortalException {

	if (!contains(permissionChecker, groupId, actionId)) {
	    throw new PrincipalException.MustHavePermission(permissionChecker.getUserId(), RESOURCE_NAME, groupId,
		    actionId);
	}
    }

    public static boolean contains(PermissionChecker permissionChecker, long classPK, String actionId) {
	
	String portletId = RavenBoxPortletKeys.RAVEN_BOX;

	return contains(permissionChecker, RESOURCE_NAME, portletId, classPK, actionId);
    }

    @Override
    public Boolean checkResource(PermissionChecker permissionChecker, long classPK, String actionId) {

	return contains(permissionChecker, classPK, actionId);
    }
}
