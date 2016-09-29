
package com.gleo.plugins.hexiagon.portlet.search.web;

import com.gleo.plugins.hexiagon.constants.AnnouncementFilterEnum;
import com.gleo.plugins.hexiagon.constants.PortletKeys;
import com.gleo.plugins.hexiagon.model.Currency;
import com.gleo.plugins.hexiagon.model.Type;
import com.gleo.plugins.hexiagon.permission.HexiagonPermission;
import com.gleo.plugins.hexiagon.service.CurrencyLocalServiceUtil;
import com.gleo.plugins.hexiagon.service.TypeLocalServiceUtil;
import com.gleo.plugins.hexiagon.util.CountryUtil;
import com.gleo.plugins.hexiagon.util.CurrencyUtil;
import com.gleo.plugins.hexiagon.util.PortalUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author guillaumelenoir
 * Portlet implementation class AnnoucementSearchController
 */
public class AnnoucementSearchController extends MVCPortlet {

	/**
	 * AnnoucementSearchController Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(AnnoucementSearchController.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<Type> types = null;
		List<Currency> currencies = null;

		boolean hasAddRight = false;

		long plid = LayoutConstants.DEFAULT_PLID;

		try {
			plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), PortletKeys.ADD_ANNOUNCEMENT_PORTLETID);
		}
		catch (PortalException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.info("PortalException: unable to get plid for ANNOUNCEMENT_DISPLAY_PORTLETID");
		}
		catch (SystemException se) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(se);
			}
			LOGGER.info("SystemException: unable to get plid for ANNOUNCEMENT_DISPLAY_PORTLETID");
		}

		try {
			types = TypeLocalServiceUtil.getTypes(themeDisplay.getScopeGroupId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		}
		catch (SystemException se) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(se);
			}
			LOGGER.error("SystemException : impossible to get types");
		}
		
		try {
			currencies = CurrencyLocalServiceUtil.getCurrencies(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		}
		catch (SystemException se) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(se);
			}
			LOGGER.error("SystemException : impossible to get currencies");
		}
		
		// Set default currency from countryId
		long countryId = CountryUtil.getCountryIdByLocal(0, themeDisplay);
		long defaultCurrencyId = CurrencyUtil.getCurrencyByCountryId(countryId);
		
		if (defaultCurrencyId > 0) {
			renderRequest.setAttribute("defaultCurrencyId", defaultCurrencyId);
		}
		
		
		// Create search Url
		PortletURL portletURL =  PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(renderRequest) , PortletKeys.ANNOUNCEMENT_SEARCH_PORTLETID, themeDisplay.getPlid() ,PortletRequest.RESOURCE_PHASE);
		portletURL.setParameter("mvcPath", "/jsp/announcements/search/results.jsp");
		
		hasAddRight = HexiagonPermission.contains(themeDisplay.getPermissionChecker(), themeDisplay.getScopeGroupId(), "ADD_ANNOUNCEMENT");

		renderRequest.setAttribute("searchUrl", portletURL.toString());
		renderRequest.setAttribute("types", types);
		renderRequest.setAttribute("defaultCurrencyId", defaultCurrencyId);
		renderRequest.setAttribute("currencies", currencies);
		renderRequest.setAttribute("hasAddRight", hasAddRight);
		renderRequest.setAttribute("filterEnum", AnnouncementFilterEnum.values());
		renderRequest.setAttribute("addAnnouncementPlid", plid);

		//doSearch(renderRequest, renderResponse.createRenderURL());

		super.doView(renderRequest, renderResponse);
	}


}
