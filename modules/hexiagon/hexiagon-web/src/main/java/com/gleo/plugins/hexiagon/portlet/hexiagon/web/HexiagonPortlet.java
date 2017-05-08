package com.gleo.plugins.hexiagon.portlet.hexiagon.web;

import com.gleo.plugins.hexiagon.constants.PortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.CountryServiceUtil;
import com.liferay.portal.kernel.service.RegionServiceUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author guillaumelenoir
 *
 */
@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.hexiagon",
			"com.liferay.portlet.instanceable=false",
			"com.liferay.portlet.css-class-wrapper=hexiagon-portlet",
			"javax.portlet.name=" + PortletKeys.HEXIAGON_PORTLETID,
			"javax.portlet.display-name=Hexiagon Portlet",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/jsp/currency/configuration/view.jsp",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user",
			"javax.portlet.init-param.copy-request-parameters=false",
			"javax.portlet.supports.mime-type=text/html"
		},
		service = Portlet.class
	)
public class HexiagonPortlet extends MVCPortlet {
	
	protected static Log LOGGER = LogFactoryUtil.getLog(HexiagonPortlet.class);
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		List<Region> regions = null;
		
		try {
			Country france = CountryServiceUtil.getCountryByA2(Locale.FRANCE.getCountry());
			
			if (Validator.isNotNull(france)) {
				regions = RegionServiceUtil.getRegions(france.getCountryId());
				renderRequest.setAttribute("countryId", france.getCountryId());
			}
		}
		catch (PortalException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.debug("PortalException : impossible to get " + Locale.FRANCE.getCountry());
		}
		catch (SystemException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.debug("SystemException : impossible to get " + Locale.FRANCE.getCountry());
		}
		
		renderRequest.setAttribute("regions", regions);
		
		super.doView(renderRequest, renderResponse);
	}

}
