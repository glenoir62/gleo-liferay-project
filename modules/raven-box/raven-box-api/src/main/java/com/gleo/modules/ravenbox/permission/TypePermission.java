
package com.gleo.modules.ravenbox.permission;


import org.osgi.service.component.annotations.Component;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.gleo.modules.ravenbox.model.Type;
import com.gleo.modules.ravenbox.service.TypeLocalService;
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
		property = {"model.class.name=com.gleo.modules.ravenbox.model.Type"},
		service = BaseModelPermissionChecker.class
	)
public class TypePermission implements BaseModelPermissionChecker {

	/**
	 * @param permissionChecker
	 * @param typeId
	 * @param actionId
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static void check(PermissionChecker permissionChecker, long typeId, String actionId)
			throws PortalException, SystemException {

		Type type = typeLocalService.getType(typeId);
		
		if (!contains(permissionChecker, type, actionId)) {
			throw new PrincipalException();
		}
	}

	/**
	 * @param permissionChecker
	 * @param type
	 * @param actionId
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static void check(PermissionChecker permissionChecker, Type type, String actionId)
			throws PortalException, SystemException {

		if (!contains(permissionChecker, type, actionId)) {
			throw new PrincipalException();
		}
	}

	/**
	 * @param permissionChecker
	 * @param typeId
	 * @param actionId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static boolean contains(PermissionChecker permissionChecker, long typeId, String actionId)
			throws PortalException, SystemException {

		Type type = typeLocalService.getType(typeId);

		Boolean hasPermission = StagingPermissionUtil.hasPermission(permissionChecker, type.getGroupId(),
				Type.class.getName(), type.getTypeId(), RavenBoxPortletKeys.TYPES, actionId);

		if (hasPermission != null) {
			return hasPermission.booleanValue();
		}

		return permissionChecker.hasPermission(type.getGroupId(), Type.class.getName(), type.getTypeId(), actionId);
	}

	/**
	 * @param permissionChecker
	 * @param type
	 * @param actionId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static boolean contains(PermissionChecker permissionChecker, Type type, String actionId)
			throws PortalException, SystemException {

		return permissionChecker.hasPermission(type.getGroupId(), Type.class.getName(), type.getTypeId(), actionId);
	}

	@Override
	public void checkBaseModel(PermissionChecker permissionChecker, long groupId, long primaryKey, String actionId)
			throws PortalException {
		check(permissionChecker, primaryKey, actionId);
	}
	
	@Reference
	protected void setTypeLocalService(TypeLocalService typeLocalService) {
		TypePermission.typeLocalService = typeLocalService;
	}

	private static TypeLocalService typeLocalService;
}
