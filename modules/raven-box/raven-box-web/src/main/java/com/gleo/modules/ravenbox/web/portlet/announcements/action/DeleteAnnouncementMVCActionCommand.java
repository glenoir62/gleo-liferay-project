package com.gleo.modules.ravenbox.web.portlet.announcements.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.gleo.modules.ravenbox.service.AnnouncementService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;


/**
 * @author guillaumelenoir
 * Deletes a Announcement from the database.
 *
 */
@Component(
    property = {
        "javax.portlet.name=" + RavenBoxPortletKeys.ANNOUNCEMENTS_CONFIGURATION,
        "mvc.command.name=/announcements/delete_announcement"
    },
    service = MVCActionCommand.class
)
public class DeleteAnnouncementMVCActionCommand extends BaseMVCActionCommand {
	
	private static Log LOGGER = LogFactoryUtil.getLog(DeleteAnnouncementMVCActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		long announcementId = ParamUtil.getLong(actionRequest, "announcementId");

		try {
			if (Validator.isNotNull(announcementId)) {
				announcementService.deleteAnnouncement(announcementId);
				SessionMessages.add(actionRequest, "announcement-deleted");

			} else {
				SessionErrors.add(actionRequest, "announcement-errors");
			}
		} catch (PortalException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error(e.getMessage());
			SessionErrors.add(actionRequest, "permission-error");
		} catch (SystemException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error(e.getMessage());
			SessionErrors.add(actionRequest, "permission-error");
		}

	}
	
	@Reference
	protected void setAnnouncementService(
			AnnouncementService announcementService) {
		this.announcementService = announcementService;
	}

	private AnnouncementService announcementService;


}
