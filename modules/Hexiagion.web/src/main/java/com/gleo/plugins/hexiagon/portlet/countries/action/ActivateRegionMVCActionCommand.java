package com.gleo.plugins.hexiagon.portlet.countries.action;

import com.gleo.plugins.hexiagon.constants.PortletKeys;
import com.gleo.plugins.hexiagon.service.ExtRegionServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		property = {
			"javax.portlet.name=" + PortletKeys.HEXIAGON_COUNTRY_CONFIGURATION,
			"mvc.command.name=activateRegion"
		},
		service = MVCActionCommand.class
	)
public class ActivateRegionMVCActionCommand
	extends BaseMVCActionCommand {

	/**
	 * ActivateRegionMVCActionCommand Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(ActivateRegionMVCActionCommand.class);
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long regionId = ParamUtil.getLong(actionRequest, "regionId");
		boolean isActive = ParamUtil.getBoolean(actionRequest, "isActive");
		
		try {
			Region region = ExtRegionServiceUtil.setActive(regionId, !isActive);
			
			SessionMessages.add(actionRequest, "region-updated-active");
			LOGGER.debug(region);
			actionResponse.setRenderParameter("countryId", String.valueOf(region.getCountryId()));
		} catch (Exception e) {
			LOGGER.error(e);
			SessionErrors.add(actionRequest,"region-error");
		}
		
	}

}
