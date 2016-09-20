package com.gleo.plugins.hexiagon.service.impl;

import java.util.List;

import com.gleo.plugins.hexiagon.model.Type;
import com.gleo.plugins.hexiagon.permission.HexiagonPermission;
import com.gleo.plugins.hexiagon.permission.TypePermission;
import com.gleo.plugins.hexiagon.service.base.TypeServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ServiceContext;

/**
 * The implementation of the type remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.glenoir.plugins.hexagon.service.TypeService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author guillaumelenoir
 * @see com.gleo.plugins.hexiagon.hexagon.service.base.TypeServiceBaseImpl
 * @see com.glenoir.plugins.hexagon.service.TypeServiceUtil
 */
public class TypeServiceImpl extends TypeServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.glenoir.plugins.hexagon.service.TypeServiceUtil} to access the type remote service.
     */
	
	public Type addType(Type type, ServiceContext serviceContext)
		throws SystemException, PrincipalException, PortalException {

		HexiagonPermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(), "ADD_TYPE");

		return typeLocalService.addType(type, serviceContext);
	}

	public Type updateType(Type type)
		throws SystemException, PrincipalException, PortalException {

		TypePermission.check(getPermissionChecker(), type.getTypeId(), ActionKeys.UPDATE);

		return typeLocalService.updateType(type);
	}

	public Type deleteType(long typeId, ServiceContext serviceContext)
		throws SystemException, PrincipalException, PortalException {

		TypePermission.check(getPermissionChecker(), typeId, ActionKeys.DELETE);

		return typeLocalService.deleteType(typeId);
	}

	public List<Type> getTypesByGroupId(long groupId, int start, int end)
		throws SystemException {

		return typePersistence.filterFindByGroupId(groupId, start, end);
	}

}
