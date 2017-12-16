package com.gleo.plugins.hexiagon.portlet.currency.action;

import com.gleo.plugins.hexiagon.constants.PortletKeys;
import com.gleo.plugins.hexiagon.model.Currency;
import com.gleo.plugins.hexiagon.portlet.currency.util.CurrencyUtil;
import com.gleo.plugins.hexiagon.service.CurrencyServiceUtil;
import com.gleo.plugins.hexiagon.util.PortalUtil;
import com.gleo.plugins.hexiagon.validator.CurrencyValidator;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author guillaumelenoir
 *
 */
@Component(
	property = {
		"javax.portlet.name=" + PortletKeys.HEXIAGON_CURRENCY_CONFIGURATION,
		"mvc.command.name=updateCurrency"
	},
	service = MVCActionCommand.class
)
public class UpdateCurrencyMVCActionCommand extends BaseMVCActionCommand {

	/**
	 * UpdateCurrencyMVCActionCommand Logger.
	 */
	protected static Log log = LogFactoryUtil.getLog(UpdateCurrencyMVCActionCommand.class);
	
	
	/**
	 * Update a Currency to the database
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		Currency currency =  CurrencyUtil.currencyFromRequest(actionRequest);
		try {

			ArrayList<String> errors = new ArrayList<String>();

			if (CurrencyValidator.validateCurrency(currency, errors)) {

				CurrencyServiceUtil.updateCurrency(currency);
				SessionMessages.add(actionRequest, "currency-updated");
			}
			else {
				for (String error : errors) {
					SessionErrors.add(actionRequest, error);
				}
				PortalUtil.copyRequestParameters(actionRequest, actionResponse);
				actionResponse.setRenderParameter("jspPage", "/jsp/currencies/edit.jsp");
			}
		}
		catch (SystemException e) {
			if (log.isDebugEnabled()) {
				log.debug(e);
			}
			if (Validator.isNotNull(currency)) {
				log.error("SystemException : impossible to update currency for " + currency.getCurrencyId());
			}
		}
		
		actionResponse.setRenderParameter("currencyId", String.valueOf(currency.getCurrencyId()));
		actionResponse.setRenderParameter("mvcPath", "/jsp/currency/configuration/edit.jsp");
		
	}

}
