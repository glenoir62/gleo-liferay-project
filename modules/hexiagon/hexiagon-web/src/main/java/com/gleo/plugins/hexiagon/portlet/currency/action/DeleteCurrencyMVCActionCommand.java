package com.gleo.plugins.hexiagon.portlet.currency.action;

import com.gleo.plugins.hexiagon.constants.PortletKeys;
import com.gleo.plugins.hexiagon.model.Currency;
import com.gleo.plugins.hexiagon.service.CurrencyServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

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
		"mvc.command.name=deleteCurrency"
	},
	service = MVCActionCommand.class
)
public class DeleteCurrencyMVCActionCommand extends BaseMVCActionCommand {

	/**
	 * DeleteCurrencyMVCActionCommand Logger.
	 */
	protected static Log log = LogFactoryUtil.getLog(DeleteCurrencyMVCActionCommand.class);
	
	

	/**
	 * Deletes a currency from the database.
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		long currencyId = ParamUtil.getLong(actionRequest, "currencyId");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Currency.class.getName(), actionRequest);

		try {
			CurrencyServiceUtil.deleteCurrency(currencyId, serviceContext);
			SessionMessages.add(actionRequest, "currency-deleted");
		}
		catch (SystemException e) {
			if (log.isDebugEnabled()) {
				log.debug(e);
			}

			SessionErrors.add(actionRequest, e.getMessage());
			SessionErrors.add(actionRequest, "no-currency-deleted");
		}
		catch (PortalException e) {
			if (log.isDebugEnabled()) {
				log.debug(e);
			}

			SessionErrors.add(actionRequest, e.getMessage());
			SessionErrors.add(actionRequest, "no-currency-deleted");
		}
		
	}

}
