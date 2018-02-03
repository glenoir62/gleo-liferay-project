package com.gleo.modules.ravenbox.web.portlet.types.action.resources;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.gleo.modules.ravenbox.model.Type;
import com.gleo.modules.ravenbox.permission.RavenBoxPermission;
import com.gleo.modules.ravenbox.service.TypeLocalServiceUtil;
import com.gleo.modules.ravenbox.web.portlet.types.action.AddTypeMVCActionCommand;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;


/**
 * @author guillaumelenoir
 *
 */
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name="+RavenBoxPortletKeys.TYPES,
	        "mvc.command.name=/types/save_types_order"
	    },
	    service = MVCResourceCommand.class
	)
public class SaveTypesOrderMVCResourceCommand extends BaseMVCResourceCommand {

    /**
     * The Logger
     */
    private static Log LOGGER = LogFactoryUtil.getLog(SaveTypesOrderMVCResourceCommand.class);

    /**
     * Save order types
     * 
     * @param resourceRequest
     * @param resourceResponse
     * @throws Exception
     */
    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
	    throws Exception {

	long[] typeIds = ParamUtil.getLongValues(resourceRequest, "typeIds");
	Type type = null;
	ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

	// Save orders.
	// Permission Check.
	if (RavenBoxPermission.contains(themeDisplay.getPermissionChecker(), themeDisplay.getScopeGroupId(),
		"UPDATE_ORDER")) {
	    for (int i = 0; i < typeIds.length; i++) {
		long typeId = typeIds[i];

		try {
		    type = TypeLocalServiceUtil.getType(typeId);
		    type.setOrder(typeIds.length - i);
		    TypeLocalServiceUtil.updateType(type);
		} catch (PortalException e) {
		    if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(e);
		    }
		    if (Validator.isNotNull(type)) {
			LOGGER.error("SystemException : impossible to update type for " + type.getTypeId());
		    }
		} catch (SystemException e) {
		    if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(e);
		    }
		    if (Validator.isNotNull(type)) {
			LOGGER.error("SystemException : impossible to update type for " + type.getTypeId());
		    }
		}
	    }
	}

    }

}
