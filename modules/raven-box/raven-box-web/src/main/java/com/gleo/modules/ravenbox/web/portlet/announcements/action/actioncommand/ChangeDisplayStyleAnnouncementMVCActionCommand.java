package com.gleo.modules.ravenbox.web.portlet.announcements.action.actioncommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author Guillaume Lenoir
 * 
 */
@Component(
	immediate=true,
    property = {
        "javax.portlet.name=" + RavenBoxPortletKeys.ANNOUNCEMENTS_CONFIGURATION,
        "javax.portlet.name=" + RavenBoxPortletKeys.TYPES_CONFIGURATION,
        "mvc.command.name=/announcements/change_display_style"
    },
    service = MVCActionCommand.class
)
public class ChangeDisplayStyleAnnouncementMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		hideDefaultSuccessMessage(actionRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		String displayStyle = ParamUtil.getString(actionRequest, "displayStyle");

		PortalPreferences portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(actionRequest);

		portalPreferences.setValue(portletDisplay.getId(), "display-style", displayStyle);

	}

}
