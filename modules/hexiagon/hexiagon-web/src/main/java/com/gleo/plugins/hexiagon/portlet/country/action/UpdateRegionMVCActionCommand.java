package com.gleo.plugins.hexiagon.portlet.country.action;

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
			"mvc.command.name=updateRegion"
		},
		service = MVCActionCommand.class
	)
public class UpdateRegionMVCActionCommand
	extends BaseMVCActionCommand {

	/**
	 * UpdateRegionMVCActionCommand Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(UpdateRegionMVCActionCommand.class);
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long regionId = ParamUtil.getLong(actionRequest, "regionId");
		boolean isActive = ParamUtil.getBoolean(actionRequest, "active");
		
		String name = ParamUtil.getString(actionRequest, "name");
		String regionCode = ParamUtil.getString(actionRequest, "regionCode");
		
		try {
			Region region = ExtRegionServiceUtil.updateRegion(regionId, isActive, name, regionCode);
			
			SessionMessages.add(actionRequest, "region-updated");
			LOGGER.debug(region);
			actionResponse.setRenderParameter("countryId", String.valueOf(region.getCountryId()));
		} catch (Exception e) {
			LOGGER.error(e);
			SessionErrors.add(actionRequest,"region-error");
		}
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		
		actionResponse.setRenderParameter("redirect", redirect);
		actionResponse.setRenderParameter("regionId", String.valueOf(regionId));
		actionResponse.setRenderParameter("mvcPath", "/jsp/region/configuration/edit.jsp");
	}
}
