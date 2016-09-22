package com.gleo.plugins.hexiagon.portlet.countries.action;

import com.gleo.plugins.hexiagon.constants.PortletKeys;
import com.gleo.plugins.hexiagon.service.ExtRegionServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.CountryServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	    immediate = true,
	    property = {
	       "javax.portlet.name=" + PortletKeys.HEXIAGON_COUNTRY_CONFIGURATION,
	       "mvc.command.name=/jsp/regions/configuration"
	    },
	    service = MVCRenderCommand.class
	)
public class RegionsViewMVCRenderCommand implements MVCRenderCommand {

	/**
	 * RegionsViewMVCRenderCommand Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(RegionsViewMVCRenderCommand.class);
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long countryId = ParamUtil.getLong(renderRequest, "countryId");
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
		
		return "/jsp/regions/configuration/view.jsp";
	}

}
