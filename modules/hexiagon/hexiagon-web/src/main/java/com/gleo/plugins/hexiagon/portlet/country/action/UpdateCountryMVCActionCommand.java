package com.gleo.plugins.hexiagon.portlet.country.action;

import com.gleo.plugins.hexiagon.constants.PortletKeys;
import com.gleo.plugins.hexiagon.service.ExtCountryServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
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
		"javax.portlet.name=" + PortletKeys.HEXIAGON_COUNTRY_CONFIGURATION,
		"mvc.command.name=updateCountry"
	},
	service = MVCActionCommand.class
)
public class UpdateCountryMVCActionCommand
	extends BaseMVCActionCommand {

	/**
	 * UpdateCountryMVCActionCommand Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(UpdateCountryMVCActionCommand.class);
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long countryId = ParamUtil.getLong(actionRequest, "countryId");
		boolean isActive = ParamUtil.getBoolean(actionRequest, "active");
		boolean isZipRequired = ParamUtil.getBoolean(actionRequest, "zipRequired");
		
		String name = ParamUtil.getString(actionRequest, "name");
		String a2 = ParamUtil.getString(actionRequest, "a2");
		String a3 = ParamUtil.getString(actionRequest, "a3");
		String number = ParamUtil.getString(actionRequest, "number");
		String idd = ParamUtil.getString(actionRequest, "idd");
		
		try {
			ExtCountryServiceUtil.updateCountry(countryId, isActive, isZipRequired, name, a2, a3, number, idd);
			SessionMessages.add(actionRequest, "country-updated");
		} catch (Exception e) {
			LOGGER.error(e);
			SessionErrors.add(actionRequest,"country-error");
		}
		
	}

}
