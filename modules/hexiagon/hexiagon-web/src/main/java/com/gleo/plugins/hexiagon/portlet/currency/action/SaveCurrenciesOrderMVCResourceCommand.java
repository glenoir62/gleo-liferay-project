package com.gleo.plugins.hexiagon.portlet.currency.action;

import com.gleo.plugins.hexiagon.constants.PortletKeys;
import com.gleo.plugins.hexiagon.model.Currency;
import com.gleo.plugins.hexiagon.permission.HexiagonPermission;
import com.gleo.plugins.hexiagon.service.CurrencyLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author guillaumelenoir
 *
 */
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+ PortletKeys.HEXIAGON_CURRENCY_CONFIGURATION,
	        "mvc.command.name=saveCurrenciesOrder"
	    },
	    service = MVCResourceCommand.class
	)
public class SaveCurrenciesOrderMVCResourceCommand implements MVCResourceCommand {

	/**
	 * SaveCurrenciesOrderMVCResourceCommand Logger.
	 */
	protected static Log log = LogFactoryUtil.getLog(SaveCurrenciesOrderMVCResourceCommand.class);
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		long[] currencyIds = ParamUtil.getLongValues(resourceRequest, "currencyIds");
		Currency currency = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		// Save orders.
		// Permission Check.
		if (HexiagonPermission.contains(themeDisplay.getPermissionChecker(), themeDisplay.getScopeGroupId(), "UPDATE_ORDER")) {
			for (int i = 0; i < currencyIds.length; i++) {
				long currencyId = currencyIds[i];
	
				try {
					currency = CurrencyLocalServiceUtil.getCurrency(currencyId);
					currency.setOrder(currencyIds.length - i);
					CurrencyLocalServiceUtil.updateCurrency(currency);
				}
				catch (PortalException e) {
					if (log.isDebugEnabled()) {
						log.debug(e);
					}
					if (Validator.isNotNull(currency)) {
						log.error("SystemException : impossible to update currency for " + currency.getCurrencyId());
					}
					return true;
				}
				catch (SystemException e) {
					if (log.isDebugEnabled()) {
						log.debug(e);
					}
					if (Validator.isNotNull(currency)) {
						log.error("SystemException : impossible to update currency for " + currency.getCurrencyId());
					}
					return true;
				}
			}
		}
		return false;
	}

}
