package com.gleo.modules.ravenbox.web.util;

import com.gleo.modules.ravenbox.model.Type;
import com.gleo.modules.ravenbox.service.TypeLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;

/**
 * @author guillaumelenoir
 *
 */
public class TypeUtil {

    /**
     * 
     */
    private static Log LOGGER = LogFactoryUtil.getLog(TypeUtil.class);

    /**
     * Convenience method to create a Type object out of the request. Used by
     * the Add / Edit methods.
     * 
     * @param request
     * @return type
     */
    public static Type typeFromRequest(ActionRequest request) {

	Type type = null;
	long typeId = ParamUtil.getLong(request, "typeId");
	String description = ParamUtil.getString(request, "description");
	
	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

	if (Validator.isNotNull(typeId)) {
	    try {
		type = TypeLocalServiceUtil.getType(typeId);
	    } catch (PortalException pe) {
		if (LOGGER.isDebugEnabled()) {
		    LOGGER.debug(pe);
		}
		LOGGER.error("PortalException : impossible to get type for id " + typeId);
	    } catch (SystemException se) {
		if (LOGGER.isDebugEnabled()) {
		    LOGGER.debug(se);
		}
		LOGGER.error("PortalException : impossible to get type for id " + typeId);
	    }
	} else {
	    type = TypeLocalServiceUtil.createType(typeId);
	}

	type.setDescription(description);
	type.setGroupId(themeDisplay.getScopeGroupId());
	type.setOrder(ParamUtil.getInteger(request, "order"));
	type.setNameMap(LocalizationUtil.getLocalizationMap(request, "name"));

	return type;
    }
}
