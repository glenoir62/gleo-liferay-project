
package com.gleo.modules.ravenbox.web.portlet.types.action.rendercommand;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.gleo.modules.ravenbox.model.Type;
import com.gleo.modules.ravenbox.service.TypeServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Julien Luczak
 *
 */
@Component(
		property = {
	        	"javax.portlet.name=" + RavenBoxPortletKeys.TYPES_CONFIGURATION,
	        	"mvc.command.name=/"
		}
	)
public class ViewTypeMVCRenderCommand implements MVCRenderCommand {
	
	protected static Log LOGGER = LogFactoryUtil.getLog(ViewTypeMVCRenderCommand.class);
	
	private String emptyResultsMessage = "type-empty-results-message";
	
	@Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
		PortalPreferences portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortalUtil.addPortletBreadcrumbEntry(themeDisplay.getRequest(), LanguageUtil.get(themeDisplay.getRequest(), "com.gleo.modules.ravenbox.type.title"), null);
		
		String displayStyle = portalPreferences.getValue(RavenBoxPortletKeys.TYPES_CONFIGURATION, "display-style", "icon");
		PortletURL iteratorURL = renderResponse.createRenderURL();

		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
			SearchContainer.DEFAULT_DELTA);
		int cur = ParamUtil.getInteger(renderRequest, "curTypes", SearchContainer.DEFAULT_CUR);

		long groupId = themeDisplay.getScopeGroupId();

		// create search container
		SearchContainer<Type> searchTypeContainer = new SearchContainer<Type>(renderRequest, null, null, "curTypes",
			cur, delta, iteratorURL, null, emptyResultsMessage);

		int start = searchTypeContainer.getStart();
		int end = searchTypeContainer.getEnd();

		try {
		    List<Type> types = TypeServiceUtil.getTypesByGroupId(groupId, start, end);
		    int total = TypeServiceUtil.getTypesCount(groupId);
		    searchTypeContainer.setTotal(total);
		    searchTypeContainer.setResults(types);
		} catch (SystemException e) {
		    if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(e);
		    }
		    LOGGER.error("SystemException : impossible to get searchTypeContainer");
		}

		renderRequest.setAttribute("searchTypeContainer", searchTypeContainer);
		renderRequest.setAttribute("displayStyle", displayStyle);
	
		return "/ravenbox/types/view.jsp";
    }
	
}