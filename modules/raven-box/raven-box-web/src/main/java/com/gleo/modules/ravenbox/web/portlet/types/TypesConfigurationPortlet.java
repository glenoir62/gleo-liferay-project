package com.gleo.modules.ravenbox.web.portlet.types;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.gleo.modules.ravenbox.model.Type;
import com.gleo.modules.ravenbox.service.TypeServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.css-class-wrapper=types-configuration-portlet",
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.icon=/ravenbox/icons/icon.png",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.scopeable=true",
		"com.liferay.portlet.use-default-template=true",
		"com.liferay.portlet.add-default-resource=true",
		"javax.portlet.display-name=Types Configuration",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.always-display-default-configuration-icons=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/ravenbox/types/view.jsp",
		"javax.portlet.name=" + RavenBoxPortletKeys.TYPES,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class TypesConfigurationPortlet extends MVCPortlet{

	/**
	 * TypesConfigurationPortlet Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(TypesConfigurationPortlet.class);

	/**
	 * Empty Results Message
	 */
	private String emptyResultsMessage = "no-entries-were-found";

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		PortletURL iteratorURL = renderResponse.createRenderURL();
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
		int cur = ParamUtil.getInteger(renderRequest, "curTypes", SearchContainer.DEFAULT_CUR);
		
		long groupId = themeDisplay.getScopeGroupId();

		// create search container
		SearchContainer<Type> searchTypeContainer = new SearchContainer<Type>(renderRequest, null, null, "curTypes", cur, delta, iteratorURL, null, emptyResultsMessage);

		int start = searchTypeContainer.getStart();
		int end = searchTypeContainer.getEnd();

		try {
			List<Type> types = TypeServiceUtil.getTypesByGroupId(groupId, start, end);
			int total = TypeServiceUtil.getTypesCount(groupId);
			searchTypeContainer.setTotal(total);
			searchTypeContainer.setResults(types);
		}
		catch (SystemException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("SystemException : impossible to get searchTypeContainer");
		}
		
		renderRequest.setAttribute("searchTypeContainer", searchTypeContainer);
		
		super.doView(renderRequest, renderResponse);
	}
}
