package com.gleo.plugins.hexiagon.portlet.announcements.web;

import com.gleo.plugins.hexiagon.constants.PortletKeys;
import com.gleo.plugins.hexiagon.model.Announcement;
import com.gleo.plugins.hexiagon.service.AnnouncementServiceUtil;
import com.gleo.plugins.hexiagon.util.PortalUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
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
 * Portlet implementation class AnnouncementsController
 */
public class AnnouncementsController extends MVCPortlet {

	/**
	 * AnnouncementsController Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(AnnouncementsController.class);
	
	/**
	 * Empty Results Message
	 */
	private String emptyResultsMessage = "announcement-empty-results-message";
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		PortletURL iteratorURL = renderResponse.createRenderURL();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
		int cur = ParamUtil.getInteger(renderRequest, "curAnnouncements", SearchContainer.DEFAULT_CUR);

		PortletURL redirectURLPortlet = PortalUtil.getLiferayPortletResponse(renderResponse).createLiferayPortletURL(themeDisplay.getPlid(), PortletKeys.ANNOUNCEMENT_DISPLAY_PORTLETID, PortletRequest.RENDER_PHASE, false);
		redirectURLPortlet.setParameter("redirect", themeDisplay.getURLCurrent());
		redirectURLPortlet.setParameter("jspPage", "/jsp/announcements/display/update_announcement_redirect.jsp");
		redirectURLPortlet.setWindowState(LiferayWindowState.POP_UP);
		
		// create search container
		SearchContainer<Announcement> searchTypeContainer = new SearchContainer<Announcement>(renderRequest, null, null, "curAnnouncements", cur, delta, iteratorURL, null, emptyResultsMessage);

		int start = searchTypeContainer.getStart();
		int end = searchTypeContainer.getEnd();

		try {
			List<Announcement> announcements = AnnouncementServiceUtil.getAnnouncementsByGroupId(themeDisplay.getScopeGroupId(), start, end);
			int total = AnnouncementServiceUtil.getAnnouncementsCountByGroupId(themeDisplay.getScopeGroupId());
			searchTypeContainer.setTotal(total);
			searchTypeContainer.setResults(announcements);
		}
		catch (SystemException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("SystemException : impossible to get searchTypeContainer");
		}

		renderRequest.setAttribute("redirectURLPortlet", redirectURLPortlet);
		renderRequest.setAttribute("searchAnnouncementContainer", searchTypeContainer);
		super.doView(renderRequest, renderResponse);
	}

}
