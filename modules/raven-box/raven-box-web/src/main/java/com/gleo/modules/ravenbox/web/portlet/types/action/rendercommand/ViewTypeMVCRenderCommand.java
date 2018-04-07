
package com.gleo.modules.ravenbox.web.portlet.types.action.rendercommand;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.gleo.modules.ravenbox.model.Announcement;
import com.gleo.modules.ravenbox.model.Type;
import com.gleo.modules.ravenbox.service.AnnouncementLocalService;
import com.gleo.modules.ravenbox.service.TypeLocalService;
import com.gleo.modules.ravenbox.service.TypeServiceUtil;
import com.gleo.modules.ravenbox.web.portlet.announcements.search.AnnouncementDisplayTerms;
import com.gleo.modules.ravenbox.web.portlet.announcements.search.AnnouncementSearch;
import com.gleo.modules.ravenbox.web.portlet.types.search.TypeSearch;
import com.gleo.modules.ravenbox.web.util.AnnouncementUtil;
import com.gleo.modules.ravenbox.web.util.TypeUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
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
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

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

		
		// create search container
		SearchContainer<Type> searchTypeContainer = new TypeSearch(renderRequest, iteratorURL);

		long groupId = themeDisplay.getScopeGroupId();
		int start = searchTypeContainer.getStart();
		int end = searchTypeContainer.getEnd();
		List<Type> types = new ArrayList<Type>();

		// Get indexer
		Indexer<Type> indexer = IndexerRegistryUtil.nullSafeGetIndexer(Type.class);
		
		// create search context
		// create search context
		SearchContext searchContext = createSearchContextFromRequest(renderRequest, searchTypeContainer,indexer, themeDisplay,
			start, end);
		Hits hits = null;
		try {
			hits = indexer.search(searchContext);
			LOGGER.info(hits.getLength());
			
		} catch (SearchException se) {
			LOGGER.error(se);
		}
		int total = 0;
		total = searchType(renderRequest, renderResponse, themeDisplay, types, total, hits);
		searchTypeContainer.setTotal(total);
		searchTypeContainer.setResults(types);
		renderRequest.setAttribute("portletURL", searchTypeContainer.getIteratorURL());
		renderRequest.setAttribute("searchTypeContainer", searchTypeContainer);
		renderRequest.setAttribute("displayStyle", displayStyle);
	
		return "/ravenbox/types/view.jsp";
    }
	
	private SearchContext createSearchContextFromRequest(RenderRequest renderRequest,
		    SearchContainer<Type> searchContainer, Indexer<Type> indexer, ThemeDisplay themeDisplay, int start, int end) {
		
			//TypeDisplayTerms displayTerms = null;
			SearchContext searchContext = SearchContextFactory.getInstance(PortalUtil.getHttpServletRequest(renderRequest));
			//displayTerms = (TypeDisplayTerms) searchContainer.getDisplayTerms();
			searchContext.setStart(start);
			searchContext.setEnd(end);
			/*
			if (displayTerms.isAdvancedSearch()) {
			    searchContext.setAndSearch(displayTerms.isAndOperator());
			} else {
			    searchContext.setKeywords(displayTerms.getKeywords());
			}
			*/
			long organizationId = themeDisplay.getScopeGroup().getOrganizationId();
		
			// Organization
			if (organizationId > 0) {
			    LinkedHashMap<String, Object> attributes = new LinkedHashMap<String, Object>();
			    attributes.put("usersOrgs", Long.valueOf(organizationId));
			    searchContext.setGroupIds(null);
			    searchContext.setAttribute("params", attributes);
			}
			
			
			// Sort
			String  orderByCol = searchContainer.getOrderByCol();
			String  orderByType = searchContainer.getOrderByType();
			
			int sortType = TypeUtil.getSortType(orderByCol);

			Sort sort = SortFactoryUtil.getSort(Type.class, sortType, orderByCol, orderByType);
		
			searchContext.setSorts(sort);
			
			QueryConfig queryConfig = new QueryConfig();
		
			queryConfig.setHighlightEnabled(true);
			searchContext.setQueryConfig(queryConfig);

			if (LOGGER.isDebugEnabled()) {
				LOGGER.info("sort" + sort);
				LOGGER.debug("orderByCol " + orderByCol);
				LOGGER.debug("orderByType " + orderByType);
				LOGGER.debug("start " + start);
				LOGGER.debug("end " + end);
				LOGGER.debug("sort " + sort);
			}
			
			return searchContext;
	    }
	    
	/**
	 * Search Type
	 * 
	 * @param renderRequest
	 * @param renderResponse
	 * @param themeDisplay
	 * @param users
	 * @param total
	 * @param hits
	 * @return
	 */
	private int searchType(RenderRequest renderRequest, RenderResponse renderResponse,
			ThemeDisplay themeDisplay, List<Type> types, int total, Hits hits) {

		if (hits != null && hits.getLength() > 0) {
			List<SearchResult> searchResultsList = SearchResultUtil.getSearchResults(hits, themeDisplay.getLocale(),
					renderRequest, renderResponse);
			total = hits.getLength();
			if (total > 0) {
				for (SearchResult searchResult : searchResultsList) {
					try {
						Type type = typeLocalService.getType(searchResult.getClassPK());
						types.add(type);
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
		return total;
	}
	
	@Reference
	protected void setTypeLocalService(
			TypeLocalService typeLocalService) {
		this.typeLocalService = typeLocalService;
	}

	private TypeLocalService typeLocalService;    
}