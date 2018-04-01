package com.gleo.modules.ravenbox.web.portlet.types.action.actioncommand;

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
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Julien Luczak
 * 
 */
@Component(
    property = {
        "javax.portlet.name=" + RavenBoxPortletKeys.TYPES_CONFIGURATION,
        "mvc.command.name=/types/edit_type"
    },
    service = MVCActionCommand.class
)
public class EditTypeMVCActionCommand extends BaseMVCActionCommand {
	
    /**
     * 
     */
    private static Log LOGGER = LogFactoryUtil.getLog(EditTypeMVCActionCommand.class);

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
	LOGGER.info("Edit type");
	Type type = TypeUtil.typeFromRequest(actionRequest);
	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

	try {
	    ArrayList<String> errors = new ArrayList<String>();

	    if (TypeValidator.validateType(type, errors, themeDisplay.getLocale())) {
		TypeServiceUtil.updateType(type);
		SessionMessages.add(actionRequest, "type-updated");
	    } else {
		for (String error : errors) {
		    SessionErrors.add(actionRequest, error);
		}

		PortalUtil.copyRequestParameters(actionRequest, actionResponse);
	    }

	} catch (SystemException se) {
	    if (LOGGER.isDebugEnabled()) {
		LOGGER.debug(se);
	    }
	    if (Validator.isNotNull(type)) {
		LOGGER.error("SystemException : impossible to update type for " + type.getTypeId());
	    }

	}
    }

}
