package com.gleo.plugins.hexiagon.portlet.countries.web;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.gleo.plugins.hexiagon.util.CountryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.sample",
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=Hexiagion country display Portlet",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/jsp/countries/view.jsp",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user",
			"javax.portlet.init-param.copy-request-parameters=false"
		},
		service = Portlet.class
	)
public class DisplayCountryController extends MVCPortlet {
 
	/**
	 * DisplayCountryController Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(DisplayCountryController.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long countryId = ParamUtil.getLong(renderRequest, "countryId");

		// Set Country
		countryId = CountryUtil.getCountryIdByLocal(countryId, themeDisplay);
		
		renderRequest.setAttribute("countryId", countryId);
		renderRequest.setAttribute("regionId", ParamUtil.getLong(renderRequest, "regionId"));
		
		super.doView(renderRequest, renderResponse);
	}
}
