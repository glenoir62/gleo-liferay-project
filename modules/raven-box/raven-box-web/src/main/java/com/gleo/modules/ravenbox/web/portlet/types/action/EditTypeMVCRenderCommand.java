
package com.gleo.modules.ravenbox.web.portlet.types.action;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.gleo.modules.ravenbox.model.Type;
import com.gleo.modules.ravenbox.service.TypeLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author guillaumelenoir
 *
 */
@Component(
	property = {
        	"javax.portlet.name=" + RavenBoxPortletKeys.TYPES_CONFIGURATION,
        	"mvc.command.name=/types/edit"
	}
)
public class EditTypeMVCRenderCommand implements MVCRenderCommand {

    /**
     * GroupPhotoController Logger.
     */
    protected static Log LOGGER = LogFactoryUtil.getLog(EditTypeMVCRenderCommand.class);

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

	ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
	
	String redirect = ParamUtil.getString(renderRequest, "redirect");

	long typeId = ParamUtil.getLong(renderRequest, "typeId");

	Type type = null;

	if (typeId > 0) {
	    try {
		type = TypeLocalServiceUtil.getType(typeId);
	    } catch (PortalException e) {
		LOGGER.error(type);
	    }
	}
	String title = type != null ? type.getName(themeDisplay.getLocale()) : "new-type";
	String typeTitle = type != null ? "updateType" : "addType";
	
	portletDisplay.setShowBackIcon(true);
	portletDisplay.setURLBack(redirect);
	renderResponse.setTitle(title);
	
	renderRequest.setAttribute("redirect", redirect);
	renderRequest.setAttribute("type", type);
	renderRequest.setAttribute("title", title);
	renderRequest.setAttribute("typeTitle", typeTitle);

	return "/ravenbox/types/edit.jsp";
    }

}
