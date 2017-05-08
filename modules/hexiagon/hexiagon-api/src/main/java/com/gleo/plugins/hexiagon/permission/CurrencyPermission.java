
package com.gleo.plugins.hexiagon.permission;

import com.gleo.plugins.hexiagon.model.Currency;
import com.gleo.plugins.hexiagon.service.CurrencyLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author guillaumelenoir
 */
@Component(
		property = {"model.class.name=com.gleo.plugins.hexiagon.model.Currency"},
		service = BaseModelPermissionChecker.class
	)
public class CurrencyPermission implements BaseModelPermissionChecker {

	public static void check(PermissionChecker permissionChecker, Currency Currency, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, Currency, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, long CurrencyId, String actionId)
		throws PortalException, SystemException {

		Currency Currency = _currencyLocalService.getCurrency(CurrencyId);

		check(permissionChecker, Currency, actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker, Currency currency, String actionId)
		throws PortalException, SystemException {

		Group group = GroupLocalServiceUtil.getCompanyGroup(currency.getCompanyId());

		return permissionChecker.hasPermission(group.getGroupId(), Currency.class.getName(), currency.getCurrencyId(), actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker, long CurrencyId, String actionId)
		throws PortalException, SystemException {

		Currency Currency = _currencyLocalService.getCurrency(CurrencyId);

		return contains(permissionChecker, Currency, actionId);
	}
	
	@Override
	public void checkBaseModel(
			PermissionChecker permissionChecker, long groupId, long primaryKey,
			String actionId)
		throws PortalException {

		check(permissionChecker, primaryKey, actionId);
	}
	
	@Reference(unbind = "-")
	protected void setCurrencyLocalService(CurrencyLocalService currencyLocalService) {

		_currencyLocalService = currencyLocalService;
	}

	private static CurrencyLocalService _currencyLocalService;
}
