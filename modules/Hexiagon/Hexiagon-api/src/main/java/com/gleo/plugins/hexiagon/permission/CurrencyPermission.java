
package com.gleo.plugins.hexiagon.permission;

import com.gleo.plugins.hexiagon.model.Currency;
import com.gleo.plugins.hexiagon.service.CurrencyLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;

/**
 * @author guillaumelenoir
 */
public class CurrencyPermission {

	public static void check(PermissionChecker permissionChecker, Currency Currency, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, Currency, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(PermissionChecker permissionChecker, long CurrencyId, String actionId)
		throws PortalException, SystemException {

		Currency Currency = CurrencyLocalServiceUtil.getCurrency(CurrencyId);

		check(permissionChecker, Currency, actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker, Currency currency, String actionId)
		throws PortalException, SystemException {

		Group group = GroupLocalServiceUtil.getCompanyGroup(currency.getCompanyId());

		return permissionChecker.hasPermission(group.getGroupId(), Currency.class.getName(), currency.getCurrencyId(), actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker, long CurrencyId, String actionId)
		throws PortalException, SystemException {

		Currency Currency = CurrencyLocalServiceUtil.getCurrency(CurrencyId);

		return contains(permissionChecker, Currency, actionId);
	}
}
