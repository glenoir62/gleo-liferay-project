
package com.gleo.modules.ravenbox.permission;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.gleo.modules.ravenbox.model.Type;
import com.gleo.modules.ravenbox.service.TypeLocalServiceUtil;
import com.liferay.exportimport.kernel.staging.permission.StagingPermissionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;

/**
 * @author guillaumelenoir
 *
 */
@OSGiBeanProperties(
	property = {"model.class.name=com.gleo.modules.ravenbox.model.Type"}
)
public class TypePermission {

    public static void check(PermissionChecker permissionChecker, long typeId, String actionId)
	    throws PortalException, SystemException {

	if (!contains(permissionChecker, typeId, actionId)) {
	    throw new PrincipalException();
	}
    }

    public static void check(PermissionChecker permissionChecker, Type type, String actionId)
	    throws PortalException, SystemException {

	if (!contains(permissionChecker, type, actionId)) {
	    throw new PrincipalException();
	}
    }

    public static boolean contains(PermissionChecker permissionChecker, long typeId, String actionId)
	    throws PortalException, SystemException {

	Type type = TypeLocalServiceUtil.getType(typeId);

	Boolean hasPermission = StagingPermissionUtil.hasPermission(permissionChecker, type.getGroupId(),
		Type.class.getName(), type.getTypeId(), RavenBoxPortletKeys.TYPES, actionId);

	if (hasPermission != null) {
	    return hasPermission.booleanValue();
	}

	return permissionChecker.hasPermission(type.getGroupId(), Type.class.getName(), type.getTypeId(), actionId);
    }

    public static boolean contains(PermissionChecker permissionChecker, Type type, String actionId)
	    throws PortalException, SystemException {

	return permissionChecker.hasPermission(type.getGroupId(), Type.class.getName(), type.getTypeId(), actionId);
    }
}
