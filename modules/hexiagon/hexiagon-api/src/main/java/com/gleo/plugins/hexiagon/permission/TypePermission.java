
package com.gleo.plugins.hexiagon.permission;

import com.gleo.plugins.hexiagon.constants.PortletKeys;
import com.gleo.plugins.hexiagon.model.Type;
import com.gleo.plugins.hexiagon.service.TypeLocalService;
import com.gleo.plugins.hexiagon.service.TypeLocalServiceUtil;
import com.liferay.exportimport.kernel.staging.permission.StagingPermissionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author guillaumelenoir
 */
@Component(
		property = {"model.class.name=com.gleo.plugins.hexiagon.model.Type"},
		service = BaseModelPermissionChecker.class
	)
public class TypePermission implements BaseModelPermissionChecker {

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

		Type type = _typeLocalService.getType(typeId);

		Boolean hasPermission = StagingPermissionUtil.hasPermission(permissionChecker, type.getGroupId(), Type.class.getName(), type.getTypeId(), PortletKeys.TYPE_PORTLETID, actionId);

		if (hasPermission != null) {
			return hasPermission.booleanValue();
		}

		return permissionChecker.hasPermission(type.getGroupId(), Type.class.getName(), type.getTypeId(), actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker, Type type, String actionId)
		throws PortalException, SystemException {

		return permissionChecker.hasPermission(type.getGroupId(), Type.class.getName(), type.getTypeId(), actionId);
	}
	
	@Override
	public void checkBaseModel(
			PermissionChecker permissionChecker, long groupId, long primaryKey,
			String actionId)
		throws PortalException {

		check(permissionChecker, primaryKey, actionId);
	}
	
	@Reference(unbind = "-")
	protected void setTypeLocalService(TypeLocalService typeLocalService) {

		_typeLocalService = typeLocalService;
	}

	private static TypeLocalService _typeLocalService;
}
