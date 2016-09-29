package com.gleo.plugins.hexiagon.portlet.types.web;

import com.gleo.plugins.hexiagon.model.Type;
import com.gleo.plugins.hexiagon.service.TypeLocalServiceUtil;
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

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author guillaumelenoir
 * Portlet implementation class TypesController
 */
public class TypesController extends MVCPortlet {
 
	/**
	 * TypeController Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(TypesController.class);

	/**
	 * Empty Results Message
	 */
	private String emptyResultsMessage = "type-empty-results-message";

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
			List<Type> types = TypeLocalServiceUtil.getTypes(groupId, start, end);
			int total = TypeLocalServiceUtil.getTypesCount(groupId);
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
