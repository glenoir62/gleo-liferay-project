
package com.gleo.modules.ravenbox.web.portlet.announcements.action.rendercommand;

import java.util.List;

import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.gleo.modules.ravenbox.model.Announcement;
import com.gleo.modules.ravenbox.service.AnnouncementLocalService;
import com.gleo.modules.ravenbox.service.AnnouncementService;
import com.gleo.modules.ravenbox.service.AnnouncementServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author guillaumelenoir
 *
 */
@Component(
	property = {
        	"javax.portlet.name=" + RavenBoxPortletKeys.ANNOUNCEMENTS_CONFIGURATION,
        	"mvc.command.name=/"
	}
)
public class ViewAnnouncementsMVCRenderCommand implements MVCRenderCommand {

	/**
     * Empty Results Message
     */
    private String emptyResultsMessage = "announcement-empty-results-message";
    
    /**
     * ViewAnnouncementsMVCRenderCommand Logger.
     */
    protected static Log LOGGER = LogFactoryUtil.getLog(ViewAnnouncementsMVCRenderCommand.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

		PortletSession portletSession = renderRequest.getPortletSession();
		portletSession.removeAttribute("announcement", PortletSession.PORTLET_SCOPE);

		PortletURL iteratorURL = renderResponse.createRenderURL();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
				SearchContainer.DEFAULT_DELTA);
		int cur = ParamUtil.getInteger(renderRequest, "curAnnouncements", SearchContainer.DEFAULT_CUR);

		// create search container
		SearchContainer<Announcement> searchTypeContainer = new SearchContainer<Announcement>(renderRequest, null, null,
				"curAnnouncements", cur, delta, iteratorURL, null, emptyResultsMessage);

		int start = searchTypeContainer.getStart();
		int end = searchTypeContainer.getEnd();

		try {
			List<Announcement> announcements = announcementService
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

		renderRequest.setAttribute("searchAnnouncementContainer", searchTypeContainer);

		return "/ravenbox/announcements/configuration/view.jsp";
	}
    
	@Reference
	protected void setAnnouncementService(
			AnnouncementService announcementService) {
		this.announcementService = announcementService;
	}

	@Reference
	protected void setAnnouncementLocalService(
			AnnouncementLocalService announcementLocalService) {
		this.announcementLocalService = announcementLocalService;
	}

	private AnnouncementLocalService announcementLocalService;
	private AnnouncementService announcementService;

}
