
package com.gleo.modules.ravenbox.permission;

import com.gleo.modules.ravenbox.model.Type;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseResourcePermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;

/**
 * @author guillaumelenoir
 *
 */
@OSGiBeanProperties(property = { "model.class.name=com.gleo.modules.ravenbox.model.Type" })
public class TypePermission extends BaseResourcePermissionChecker {

    public static final String RESOURCE_NAME = "com.gleo.modules.ravenbox.model.Type";

    public static void check(PermissionChecker permissionChecker, long groupId, String actionId)
	    throws PortalException {

	if (!contains(permissionChecker, groupId, actionId)) {
	    throw new PrincipalException.MustHavePermission(permissionChecker.getUserId(), RESOURCE_NAME, groupId,
		    actionId);
	}
    }

    public static boolean contains(PermissionChecker permissionChecker, long classPK, String actionId) {

	String portletId = PortletProviderUtil.getPortletId(Type.class.getName(), PortletProvider.Action.EDIT);

	return contains(permissionChecker, RESOURCE_NAME, portletId, classPK, actionId);
    }

    @Override
    public Boolean checkResource(PermissionChecker permissionChecker, long classPK, String actionId) {

	return contains(permissionChecker, classPK, actionId);
    }
}
