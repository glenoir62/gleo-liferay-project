package com.gleo.modules.ravenbox.web.portlet.types.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author Julien Luczak
 * 
 */
@Component(
	immediate=true,
    property = {
    		
        "javax.portlet.name=" + RavenBoxPortletKeys.TYPES_CONFIGURATION,
        "mvc.command.name=/types/change_display_style"
    },
    service = MVCActionCommand.class
)
public class ChangeDisplayStyleTypeMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		hideDefaultSuccessMessage(actionRequest);

		String displayStyle = ParamUtil.getString(
			actionRequest, "displayStyle");

		PortalPreferences portalPreferences =
			PortletPreferencesFactoryUtil.getPortalPreferences(actionRequest);

		portalPreferences.setValue(RavenBoxPortletKeys.TYPES_CONFIGURATION, "display-style", displayStyle);
		

	}

}
