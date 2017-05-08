package com.gleo.plugins.hexiagon.portlet.country.web;

import com.gleo.plugins.hexiagon.constants.PortletKeys;
import com.gleo.plugins.hexiagon.service.ExtCountryServiceUtil;
import com.gleo.plugins.hexiagon.util.PortalUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.hidden",
			"com.liferay.portlet.instanceable=false",
			"com.liferay.portlet.css-class-wrapper=country-configuration-portlet",
			"javax.portlet.name=" + PortletKeys.HEXIAGON_COUNTRY_CONFIGURATION,
			"javax.portlet.display-name=Country Configuration",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/jsp/country/configuration/view.jsp",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user",
			"javax.portlet.init-param.copy-request-parameters=false",
			"javax.portlet.supports.mime-type=text/html"
		},
		service = Portlet.class
	)
public class CountryConfigurationPortlet extends MVCPortlet {

	/**
	 * CountryConfigurationPortlet Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(CountryConfigurationPortlet.class);
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		PortletURL iteratorURL = renderResponse.createRenderURL();
		
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 100);
		int cur = ParamUtil.getInteger(renderRequest, "curCountry", SearchContainer.DEFAULT_CUR);

		// create search container
		SearchContainer<Country> searchCountryContainer = new SearchContainer<Country>( renderRequest, null, null, "curCountry", cur, delta, iteratorURL, null, "country-empty-results-message", "taglib-empty-search-result-message-header");
		
		int start = searchCountryContainer.getStart();
		int end = searchCountryContainer.getEnd();
		
		try {
			List<Country> countries = ExtCountryServiceUtil.getCountries(start, end);
			int total = ExtCountryServiceUtil.getCountriesCount();
			searchCountryContainer.setTotal(total);
			searchCountryContainer.setResults(countries);
		}
		catch (SystemException e) {
			LOGGER.error(e);
		} catch (PrincipalException pe) {
			LOGGER.error(pe);
		}
		
		renderRequest.setAttribute("redirect", PortalUtil.getCurrentURL(renderRequest));
		renderRequest.setAttribute("searchCountryContainer", searchCountryContainer);
		
		super.doView(renderRequest, renderResponse);
	}
	
}
