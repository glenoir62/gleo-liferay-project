package com.gleo.modules.ravenbox.web.portlet.announcements.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.gleo.modules.ravenbox.model.Type;
import com.gleo.modules.ravenbox.service.TypeServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;


/**
 * @author guillaumelenoir
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
		
		long typeId = ParamUtil.getLong(actionRequest, "typeId");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Type.class.getName(), actionRequest);
		
		try {
			TypeServiceUtil.deleteType(typeId, serviceContext);
			SessionMessages.add(actionRequest, "type-deleted");
		}
		catch (SystemException se) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(se);
			}
	
			SessionErrors.add(actionRequest, se.getMessage());
			SessionErrors.add(actionRequest, "no-type-deleted");
		}

	}

}
