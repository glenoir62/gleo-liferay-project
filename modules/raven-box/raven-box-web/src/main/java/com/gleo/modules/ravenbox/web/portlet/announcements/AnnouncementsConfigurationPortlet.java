package com.gleo.modules.ravenbox.web.portlet.announcements;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.gleo.modules.ravenbox.model.Announcement;
import com.gleo.modules.ravenbox.service.AnnouncementServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
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
			"com.liferay.portlet.css-class-wrapper=announcements-configuration-portlet",
			"com.liferay.portlet.display-category=category.hidden",
			"com.liferay.portlet.icon=/ravenbox/icons/icon.png",
			"com.liferay.portlet.render-weight=50",
			"com.liferay.portlet.scopeable=true",
			"com.liferay.portlet.use-default-template=true",
			"com.liferay.portlet.add-default-resource=true",
			"javax.portlet.display-name=Announcements configuration",
			"javax.portlet.expiration-cache=0",
			"javax.portlet.init-param.always-display-default-configuration-icons=true",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/ravenbox/announcements/configuration/view.jsp",
			"javax.portlet.name=" + RavenBoxPortletKeys.ANNOUNCEMENTS_CONFIGURATION,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user",
			"javax.portlet.supports.mime-type=text/html" 
		},
		service = Portlet.class)
public class AnnouncementsConfigurationPortlet extends MVCPortlet {

    /**
     * AnnouncementsController Logger.
     */
    protected static Log LOGGER = LogFactoryUtil.getLog(AnnouncementsConfigurationPortlet.class);

    /**
     * Empty Results Message
     */
    private String emptyResultsMessage = "announcement-empty-results-message";

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

    	PortletSession portletSession = renderRequest.getPortletSession();
    	portletSession.removeAttribute("announcement", PortletSession.PORTLET_SCOPE);
    	
		PortletURL iteratorURL = renderResponse.createRenderURL();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
				SearchContainer.DEFAULT_DELTA);
		int cur = ParamUtil.getInteger(renderRequest, "curAnnouncements", SearchContainer.DEFAULT_CUR);

		// PortletURL redirectURLPortlet =
		// PortalUtil.getLiferayPortletResponse(renderResponse).createLiferayPortletURL(
		// themeDisplay.getPlid(), PortletKeys.ANNOUNCEMENT_DISPLAY_PORTLETID,
		// PortletRequest.RENDER_PHASE, false);
		// redirectURLPortlet.setParameter("redirect",
		// themeDisplay.getURLCurrent());
		// redirectURLPortlet.setParameter("jspPage",
		// "/jsp/announcements/display/update_announcement_redirect.jsp");
		// redirectURLPortlet.setWindowState(LiferayWindowState.POP_UP);

		// create search container
		SearchContainer<Announcement> searchTypeContainer = new SearchContainer<Announcement>(renderRequest, null, null,
				"curAnnouncements", cur, delta, iteratorURL, null, emptyResultsMessage);

		int start = searchTypeContainer.getStart();
		int end = searchTypeContainer.getEnd();

		try {
			List<Announcement> announcements = AnnouncementServiceUtil
					.getAnnouncementsByGroupId(themeDisplay.getScopeGroupId(), start, end);
			int total = AnnouncementServiceUtil.getAnnouncementsCountByGroupId(themeDisplay.getScopeGroupId());
			searchTypeContainer.setTotal(total);
			searchTypeContainer.setResults(announcements);
		} catch (SystemException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("SystemException : impossible to get searchTypeContainer");
		}

		// renderRequest.setAttribute("redirectURLPortlet", redirectURLPortlet);
		renderRequest.setAttribute("searchAnnouncementContainer", searchTypeContainer);
		super.doView(renderRequest, renderResponse);
	}

}
