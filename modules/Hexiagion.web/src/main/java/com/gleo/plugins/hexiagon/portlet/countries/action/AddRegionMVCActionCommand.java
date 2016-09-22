package com.gleo.plugins.hexiagon.portlet.countries.action;

import com.gleo.plugins.hexiagon.constants.PortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RegionServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		property = {
			"javax.portlet.name=" + PortletKeys.HEXIAGON_COUNTRY_CONFIGURATION,
			"mvc.command.name=addRegion"
		},
		service = MVCActionCommand.class
	)
public class AddRegionMVCActionCommand
	extends BaseMVCActionCommand {

	/**
	 * AddRegionMVCActionCommand Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(AddRegionMVCActionCommand.class);
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		long countryId = ParamUtil.getLong(actionRequest, "countryId");
		boolean isActive = ParamUtil.getBoolean(actionRequest, "active");
		
		String name = ParamUtil.getString(actionRequest, "name");
		String regionCode = ParamUtil.getString(actionRequest, "regionCode");
		Region region = null;
		try {
			region = RegionServiceUtil.addRegion(countryId, regionCode, name, isActive);
			SessionMessages.add(actionRequest, "region-added");
			LOGGER.debug(region);
			actionResponse.setRenderParameter("countryId", String.valueOf(region.getCountryId()));
		} catch (Exception e) {
			LOGGER.error(e);
			SessionErrors.add(actionRequest,"region-error");
		}
		
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		
		actionResponse.setRenderParameter("redirect", redirect);
		if(region != null)
			actionResponse.setRenderParameter("regionId", String.valueOf(region.getRegionId()));
		actionResponse.setRenderParameter("mvcPath", "/jsp/regions/configuration/edit.jsp");
	}

}
