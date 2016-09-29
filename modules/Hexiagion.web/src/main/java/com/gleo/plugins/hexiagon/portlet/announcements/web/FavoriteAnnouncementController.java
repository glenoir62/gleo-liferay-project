package com.gleo.plugins.hexiagon.portlet.announcements.web;

import com.gleo.plugins.hexiagon.model.Announcement;
import com.gleo.plugins.hexiagon.service.AnnouncementLocalServiceUtil;
import com.gleo.plugins.hexiagon.service.FavoriteLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author guillaumelenoir
 * Portlet implementation class FavoriteAnnouncementController
 */
public class FavoriteAnnouncementController extends MVCPortlet {

	/**
	 * FavoriteAnnouncementController Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(FavoriteAnnouncementController.class);
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL iteratorURL = renderResponse.createRenderURL();
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
		int cur = ParamUtil.getInteger(renderRequest, "curFavorite", SearchContainer.DEFAULT_CUR);

		// create search container
		SearchContainer<Announcement> searchAnnouncementContainer = new SearchContainer<Announcement>(renderRequest, null, null, "curFavorite", cur, delta, iteratorURL, null, "empty-result");
		
		if(themeDisplay.isSignedIn()) {


			int start = searchAnnouncementContainer.getStart();
			int end = searchAnnouncementContainer.getEnd();
			long userId = themeDisplay.getUserId();
			long groupId = themeDisplay.getScopeGroupId();
			
			try {
				int total = FavoriteLocalServiceUtil.countUserFavoriteAnnouncement(userId, groupId);
				List<Announcement> announcements =  AnnouncementLocalServiceUtil.getFavoritesAnnouncementsByGroupIUserId(groupId, userId, start, end);

				searchAnnouncementContainer.setTotal(total);
				searchAnnouncementContainer.setResults(announcements);
			}
			catch (SystemException se) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(se);
				}
				LOGGER.error("SystemException : impossible to get favorite announcements for user " +  userId);
			}
			catch (PortalException pe) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(pe);
				}
				LOGGER.error("PortalException : impossible to get favorite announcements for user " +  userId);
			}
		}
		renderRequest.setAttribute("searchAnnouncementContainer", searchAnnouncementContainer);
		
		super.doView(renderRequest, renderResponse);
	}
 

}
