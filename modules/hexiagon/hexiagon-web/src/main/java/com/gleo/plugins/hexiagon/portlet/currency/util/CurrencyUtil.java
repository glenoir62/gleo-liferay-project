package com.gleo.plugins.hexiagon.portlet.currency.util;

import com.gleo.plugins.hexiagon.model.Currency;
import com.gleo.plugins.hexiagon.portlet.currency.action.UpdateCurrencyMVCActionCommand;
import com.gleo.plugins.hexiagon.service.CurrencyLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;

public class CurrencyUtil {

	/**
	 * CurrencyUtil Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(CurrencyUtil.class);
	
	/**
	 * Convenience method to create a Currency object out of the request. Used
	 * by the Add / Edit methods.
	 * 
	 * @param request
	 * @return
	 */
	public static Currency currencyFromRequest(ActionRequest request) {

		Currency currency = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long currencyId = ParamUtil.getLong(request, "currencyId");
		long companyId = themeDisplay.getCompanyId();
		long countryId = ParamUtil.getLong(request, "countryId");
		
		if (Validator.isNotNull(currencyId)) {
			try {
				currency = CurrencyLocalServiceUtil.getCurrency(currencyId);
			}
			catch (PortalException pe) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(pe);
				}
				LOGGER.error("PortalException : impossible to get  currency for id " + currencyId);
			}
			catch (SystemException se) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(se);
				}
				LOGGER.error("PortalException : impossible to get currency for id " + currencyId);
			}
		}
		else {
			currency = CurrencyLocalServiceUtil.createCurrency(currencyId);
		}
		currency.setCountryId(countryId);
		currency.setCompanyId(companyId);
		currency.setOrder(ParamUtil.getInteger(request, "order"));
		currency.setSymbol(ParamUtil.getString(request, "symbol"));
		currency.setLabel(ParamUtil.getString(request, "label"));

		return currency;
	}
}
