package com.gleo.modules.ravenbox.web.portlet.announcements.action;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.gleo.modules.ravenbox.model.Type;
import com.gleo.modules.ravenbox.service.TypeServiceUtil;
import com.gleo.modules.ravenbox.web.util.TypeUtil;
import com.gleo.modules.ravenbox.web.validator.TypeValidator;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;


/**
 * @author guillaumelenoir
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
	
	Type annoncement = TypeUtil.typeFromRequest(actionRequest);
	String successMessageKey = annoncement.isNew() ? "annoncement-added" : "annoncement-updated";

	LOGGER.info("successMessageKey " + successMessageKey);
	
	ServiceContext serviceContext = ServiceContextFactory.getInstance(Type.class.getName(), actionRequest);
	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

	try {
	    ArrayList<String> errors = new ArrayList<String>();

	    if (TypeValidator.validateType(annoncement, errors, themeDisplay.getLocale())) {
		TypeServiceUtil.addType(annoncement, serviceContext);
		SessionMessages.add(actionRequest, successMessageKey);
	    } else {
		for (String error : errors) {
		    SessionErrors.add(actionRequest, error);
		}
	    }
	} catch (SystemException se) {
	    if (LOGGER.isDebugEnabled()) {
		LOGGER.debug(se);
	    }
	    LOGGER.error("SystemException : impossible to add annoncement");
	}
    }

}
