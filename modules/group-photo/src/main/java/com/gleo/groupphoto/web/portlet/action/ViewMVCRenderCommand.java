
package com.gleo.groupphoto.web.portlet.action;

import com.gleo.groupphoto.web.constants.GroupPhotoPortletKeys;
import com.gleo.groupphoto.web.search.UserDisplayTerms;
import com.gleo.groupphoto.web.search.UserSearch;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserConstants;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.SearchResult;
import com.liferay.portal.kernel.search.SearchResultUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.CamelCaseUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PortletKeys;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowStateException;

import org.osgi.service.component.annotations.Component;

/**
 * @author guillaumelenoir
 *
 */
@Component(property = {
	"javax.portlet.name=" + GroupPhotoPortletKeys.GROUP_PHOTO,
	"mvc.command.name=/",
	"mvc.command.name=/groupphoto/view" })
public class ViewMVCRenderCommand implements MVCRenderCommand {

    /**
     * GroupPhotoController Logger.
     */
    protected static Log LOGGER = LogFactoryUtil.getLog(ViewMVCRenderCommand.class);

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

	PortletURL iteratorURL = renderResponse.createRenderURL();

	LOGGER.info("render");

	// create search container
	SearchContainer<User> searchContainer = new UserSearch(renderRequest, iteratorURL);
	ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

	List<User> users = new ArrayList<User>();
	int total = 0;

	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();
	PortletURL portletDirectoryURL = null;
	UserDisplayTerms displayTerms = null;
	
	try {
	    // create portletUrl
	    try {
		portletDirectoryURL = PortletURLFactoryUtil.create(renderRequest, PortletKeys.DIRECTORY,
			PortalUtil.getControlPanelPlid(renderRequest), PortletRequest.RENDER_PHASE);
		portletDirectoryURL.setWindowState(LiferayWindowState.POP_UP);
		portletDirectoryURL.setPortletMode(PortletMode.VIEW);
		portletDirectoryURL.setParameter("struts_action", "/directory/view_user");
		portletDirectoryURL.setParameter("tabs1Names", "Info");
	    } catch (PortalException pe) {
		LOGGER.error(pe);
	    }

	    // Get indexer
	    Indexer<User> indexer = IndexerRegistryUtil.nullSafeGetIndexer(User.class);

	    // create search context
	    SearchContext searchContext = SearchContextFactory.getInstance(PortalUtil.getHttpServletRequest(renderRequest));
	    displayTerms = (UserDisplayTerms) searchContainer.getDisplayTerms();
	    searchContext.setStart(start);
	    searchContext.setEnd(end);
	    
	    if (displayTerms.isAdvancedSearch()) {
		searchContext.setAndSearch(displayTerms.isAndOperator());
	    } else {
		searchContext.setKeywords(displayTerms.getKeywords());
	    }
	    
	    String navigation = ParamUtil.getString(renderRequest, "navigation", "active");
	    
	    if (!"active".equals(navigation)) {
		searchContext.setAttribute(Field.STATUS, WorkflowConstants.STATUS_INACTIVE);
	    }
	    
	    boolean orderByAsc = false;

	    if (searchContainer.getOrderByType().equals("asc")) {
		orderByAsc = true;
	    }
	    
	    String orderByType = GetterUtil.get(searchContainer.getOrderByCol(), "lastName");
	    orderByType = CamelCaseUtil.toCamelCase(orderByType);
	 

	    searchContext.setSorts(new Sort(orderByType, orderByAsc));

	    QueryConfig queryConfig = new QueryConfig();

	    queryConfig.setHighlightEnabled(true);

	    searchContext.setQueryConfig(queryConfig);

	    Hits hits = null;
	    try {
		hits = indexer.search(searchContext);
	    } catch (SearchException se) {
		if (LOGGER.isDebugEnabled()) {
		    LOGGER.debug(se);
		}
		LOGGER.error("SearchException : impossible to search users");
	    }

	    if (hits != null && hits.getLength() > 0) {
		List<SearchResult> searchResultsList = SearchResultUtil.getSearchResults(hits, themeDisplay.getLocale(),
			renderRequest, renderResponse);
		total = hits.getLength();
		if (total > 0) {
		    for (SearchResult searchResult : searchResultsList) {
			try {
			    User user = UserLocalServiceUtil.getUser(searchResult.getClassPK());
			    users.add(user);
			} catch (PortalException e) {
			    if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			    }
			    LOGGER.error("PortalException : impossible to get user " + searchResult.getClassPK());
			} catch (SystemException e) {
			    if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			    }
			    LOGGER.error("PortalException : impossible to get user " + searchResult.getClassPK());
			}

		    }
		}
	    }

	} catch (WindowStateException wse) {
	    LOGGER.error(wse);
	} catch (PortletModeException pme) {
	    LOGGER.error(pme);
	}

	if (LOGGER.isDebugEnabled()) {
	    LOGGER.debug("displayTerms " + displayTerms);
	}
	
	String toolbarItem = ParamUtil.getString(renderRequest, "toolbarItem", "view-all-users");
	String usersListView = ParamUtil.get(renderRequest, "usersListView", UserConstants.LIST_VIEW_FLAT_USERS);
	
	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setParameter("toolbarItem", toolbarItem);
	portletURL.setParameter("usersListView", usersListView);
	
	searchContainer.setTotal(total);
	searchContainer.setResults(users);
	renderRequest.setAttribute("searchUserContainer", searchContainer);
	renderRequest.setAttribute("portletURL", portletURL);
	renderRequest.setAttribute("portletDirectoryURL", portletDirectoryURL);

	return "/groupphoto/jsp/view.jsp";
    }

}
