package com.gleo.modules.ravenbox.web.portlet.announcements.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.gleo.modules.ravenbox.model.Announcement;
import com.gleo.modules.ravenbox.service.AnnouncementLocalService;
import com.gleo.modules.ravenbox.service.AnnouncementService;
import com.gleo.modules.ravenbox.web.util.AnnouncementUtil;
import com.gleo.modules.ravenbox.web.validator.AnnouncementValidator;
import com.liferay.asset.kernel.exception.AssetCategoryException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;


/**
 * @author guillaumelenoir
 * 
 * Adds a new Announcement to the database
 *
 */
@Component(
    property = {
        "javax.portlet.name=" + RavenBoxPortletKeys.ANNOUNCEMENTS_CONFIGURATION,
        "mvc.command.name=/announcements/add_announcement"
    },
    service = MVCActionCommand.class
)
public class AddAnnouncementMVCActionCommand extends BaseMVCActionCommand {

    /**
     * The Logger
     */
    private static Log LOGGER = LogFactoryUtil.getLog(AddAnnouncementMVCActionCommand.class);

    /**
     * Add annoncement in bdd
     * 
     * @param actionRequest
     * @param actionResponse
     * @throws Exception
     */
    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
    	
    	PortletSession portletSession = actionRequest.getPortletSession();
    	
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay) uploadPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Announcement announcement;
		try {
			announcement = AnnouncementUtil.announcementFromRequest(uploadPortletRequest, themeDisplay);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Announcement.class.getName(),
					uploadPortletRequest);

			ArrayList<String> errors = new ArrayList<String>();

			if (AnnouncementValidator.validateAnnouncement(announcement, errors, themeDisplay.getLocale())) {
				announcement = announcementService.addAnnouncement(announcement, serviceContext);
				SessionMessages.add(actionRequest, "announcement-added");
			} else {
				for (String error : errors) {
					SessionErrors.add(actionRequest, error);
				}
				
				LiferayPortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, RavenBoxPortletKeys.ANNOUNCEMENTS_CONFIGURATION, PortletRequest.RENDER_PHASE);
				portletURL.setWindowState(actionRequest.getWindowState());
				portletURL.setParameter("mvcRenderCommandName", "/announcements/edit");
				portletSession.setAttribute("announcement", announcement, PortletSession.PORTLET_SCOPE);
				
				sendRedirect(actionRequest, actionResponse, portletURL.toString());
			}
		}catch (Exception e) {
			LOGGER.error(e);
		}
    }

	@Reference
	protected void setAnnouncementService(
			AnnouncementService announcementService) {
		this.announcementService = announcementService;
	}

	private AnnouncementService announcementService;

}
