package com.gleo.plugins.hexiagon.portlet.country.action;

import com.gleo.plugins.hexiagon.constants.PortletKeys;
import com.gleo.plugins.hexiagon.service.ExtCountryServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.CountryServiceUtil;

import java.util.List;

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
		"mvc.command.name=desactivateAllCountry"
	},
	service = MVCActionCommand.class
)
public class DesactivateAllCountryMVCActionCommand 
	extends BaseMVCActionCommand {
	
	/**
	 * DesactivateAllCountryMVCActionCommand Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(DesactivateAllCountryMVCActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		try {
			List<Country> countries = CountryServiceUtil.getCountries();
			for (Country country : countries) {
				ExtCountryServiceUtil.setActive(country.getCountryId(), false);
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
		
	}
	
}
