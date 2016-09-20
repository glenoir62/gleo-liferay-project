
package com.gleo.plugins.hexiagon.service.impl;

import com.gleo.plugins.hexiagon.model.Currency;
import com.gleo.plugins.hexiagon.permission.CurrencyPermission;
import com.gleo.plugins.hexiagon.permission.HexiagonPermission;
import com.gleo.plugins.hexiagon.service.base.CurrencyServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ServiceContext;

/**
 * The implementation of the currency remote service. <p> All custom service
 * methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link org.liferay.plugin.announcement.service.CurrencyService} interface.
 * <p> This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely. </p>
 * 
 * @author guillaumelenoir
 * @see org.liferay.plugin.announcement.service.base.CurrencyServiceBaseImpl
 * @see org.liferay.plugin.announcement.service.CurrencyServiceUtil
 */
public class CurrencyServiceImpl extends CurrencyServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link org.liferay.plugin.announcement.service.CurrencyServiceUtil} to
	 * access the currency remote service.
	 */

	public Currency addCurrency(Currency currency, ServiceContext serviceContext)
		throws SystemException, PrincipalException, PortalException {

		HexiagonPermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(), "ADD_CURRENCY");

		return currencyLocalService.addCurrency(currency, serviceContext);
	}

	public Currency updateCurrency(Currency currency)
		throws SystemException, PrincipalException, PortalException {

		CurrencyPermission.check(getPermissionChecker(), currency.getCurrencyId(), ActionKeys.UPDATE);

		return currencyLocalService.updateCurrency(currency);
	}

	public Currency deleteCurrency(long currencyId, ServiceContext serviceContext)
		throws SystemException, PrincipalException, PortalException {

		CurrencyPermission.check(getPermissionChecker(), currencyId, ActionKeys.DELETE);

		return currencyLocalService.deleteCurrency(currencyId);
	}
}
