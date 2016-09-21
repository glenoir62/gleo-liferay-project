package com.gleo.plugins.hexiagon.portlet.regions.web;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.gleo.plugins.hexiagon.service.ExtRegionServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.CountryServiceUtil;
import com.liferay.portal.kernel.service.RegionServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.css-class-wrapper=regions-configuration-portlet",
		"javax.portlet.name=com_gleo_plugins_hexiagon_portlet_regions_web_RegionsConfigurationPortlet",
		"javax.portlet.display-name=Regions Configuration",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsp/regions/configuration/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.portlet-info.title=Regions Configuration",
		"javax.portlet.portlet-info.short-title=Regions Configuration",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.init-param.copy-request-parameters=false"
	},
	service = Portlet.class
)
public class RegionsConfigurationController extends MVCPortlet {
	/**
	 * DisplayCountryController Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(RegionsConfigurationController.class);
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long countryId = ParamUtil.getLong(renderRequest, "countryId", 1);
		String countryName = StringPool.BLANK;
		
		PortletURL iteratorURL = renderResponse.createRenderURL();
		iteratorURL.setParameter("countryId", String.valueOf(countryId));
		iteratorURL.setParameter("redirect", ParamUtil.getString(renderRequest, "redirect"));
		
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
		int cur = ParamUtil.getInteger(renderRequest, "curRegion", SearchContainer.DEFAULT_CUR);

		// create search container
		SearchContainer<Region> searchRegionsContainer = new SearchContainer<Region>(renderRequest, null, null, "curRegion", cur, delta, iteratorURL, null, "region-empty-results-message");
		
		int start = searchRegionsContainer.getStart();
		int end = searchRegionsContainer.getEnd();
		
		try {
			Country country = CountryServiceUtil.getCountry(countryId);
			countryName = country.getName(themeDisplay.getLocale());
			List<Region> regions = ExtRegionServiceUtil.getRegions(countryId, start, end);
			int total = ExtRegionServiceUtil.getRegionsCount(countryId);
			
			searchRegionsContainer.setTotal(total);
			searchRegionsContainer.setResults(regions);
			
		} catch (SystemException e) {
			LOGGER.error(e);
		} catch (PortalException e) {
			LOGGER.error(e);
		}
		
		renderRequest.setAttribute("countryName", countryName);
		renderRequest.setAttribute("countryId", countryId);
		renderRequest.setAttribute("searchRegionsContainer", searchRegionsContainer);
		super.doView(renderRequest, renderResponse);
	}

	/**
	 * Activate Region
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void activateRegion(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
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
 
	/**
	 * Update Region
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void updateRegion(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		
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
	}
	
	/**
	 * Add Region
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void addRegion(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		
		long countryId = ParamUtil.getLong(actionRequest, "countryId");
		boolean isActive = ParamUtil.getBoolean(actionRequest, "active");
		
		String name = ParamUtil.getString(actionRequest, "name");
		String regionCode = ParamUtil.getString(actionRequest, "regionCode");
		
		try {
			Region region = RegionServiceUtil.addRegion(countryId, regionCode, name, isActive);
			SessionMessages.add(actionRequest, "region-added");
			LOGGER.debug(region);
			actionResponse.setRenderParameter("countryId", String.valueOf(region.getCountryId()));
		} catch (Exception e) {
			LOGGER.error(e);
			SessionErrors.add(actionRequest,"region-error");
		}
	}
}