package com.gleo.plugins.hexiagon.util;

import java.util.Enumeration;
import java.util.Map;

import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.upload.UploadPortletRequest;


/**
 * @author guillaumelenoir
 * @author guillaumelenoir
 * take a look at
 * https://github.com/liferay/liferay-plugins/blob/4aed13e3c39351b11390c0859a1670cf364cee9f/shared/portal-compat-shared/src/com/liferay/compat/portal/util/PortalUtil.java
 */
public class PortalUtil extends com.liferay.portal.kernel.util.PortalUtil {

	/**
	 * @param uploadPortletRequest
	 * @param actionResponse
	 */
	public static void copyRequestParameters(UploadPortletRequest uploadPortletRequest, ActionResponse actionResponse) {

		Map<String, String[]> renderParameters = actionResponse.getRenderParameterMap();

		actionResponse.setRenderParameter("p_p_lifecycle", "1");

		@SuppressWarnings("unchecked")
		Enumeration<String> enu = uploadPortletRequest.getParameterNames();

		while (enu.hasMoreElements()) {
			String param = enu.nextElement();

			String[] values = uploadPortletRequest.getParameterValues(param);
			
			// Don't get image url
			// data:image ;base64
			if ((param == null) || (values == null) || param.contains("Image")) {
				continue;
			}
			
			if (renderParameters.get(actionResponse.getNamespace() + param) == null) {
				actionResponse.setRenderParameter(param, values);
			}
		}
	}
}
