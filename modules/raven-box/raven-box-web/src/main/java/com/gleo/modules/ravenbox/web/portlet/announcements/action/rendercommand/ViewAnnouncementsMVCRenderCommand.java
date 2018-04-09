
package com.gleo.modules.ravenbox.web.portlet.announcements.action.rendercommand;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.gleo.modules.ravenbox.model.Announcement;
import com.gleo.modules.ravenbox.model.Type;
import com.gleo.modules.ravenbox.service.AnnouncementLocalService;
import com.gleo.modules.ravenbox.service.TypeLocalServiceUtil;
import com.gleo.modules.ravenbox.service.TypeService;
import com.gleo.modules.ravenbox.web.portlet.announcements.search.AnnouncementDisplayTerms;
import com.gleo.modules.ravenbox.web.portlet.announcements.search.AnnouncementSearch;
import com.gleo.modules.ravenbox.web.util.AnnouncementUtil;
import com.liferay.frontend.taglib.servlet.taglib.ManagementBarFilterItem;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

/**
 * @author guillaumelenoir
 *
 */
@Component(
	property = {
        	"javax.portlet.name=" + RavenBoxPortletKeys.ANNOUNCEMENTS_CONFIGURATION,
        	"mvc.command.name=/"
	}
)
public class ViewAnnouncementsMVCRenderCommand implements MVCRenderCommand {
    
    /**
     * ViewAnnouncementsMVCRenderCommand Logger.
     */
    protected static Log LOGGER = LogFactoryUtil.getLog(ViewAnnouncementsMVCRenderCommand.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

//		PortletSession portletSession = renderRequest.getPortletSession();
//		portletSession.removeAttribute("announcement", PortletSession.PORTLET_SCOPE);

		PortalPreferences portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);
		String displayStyle = portalPreferences.getValue(RavenBoxPortletKeys.ANNOUNCEMENTS_CONFIGURATION, "display-style", "icon");
		
		PortletURL iteratorURL = renderResponse.createRenderURL();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		// create search container
		SearchContainer<Announcement> announcementSearchContainer = new AnnouncementSearch(renderRequest, iteratorURL);

		int total = 0;
		List<Announcement> announcements = new ArrayList<Announcement>();

		int start = announcementSearchContainer.getStart();
		int end = announcementSearchContainer.getEnd();

		try {
			// Get indexer
			Indexer<Announcement> indexer = IndexerRegistryUtil.nullSafeGetIndexer(Announcement.class);
			
			// create search context
			SearchContext searchContext = createSearchContextFromRequest(renderRequest, announcementSearchContainer,indexer, themeDisplay,
				start, end);
			
			Hits hits = null;
			
			try {
			    hits = indexer.search(searchContext);
			} catch (SearchException se) {
			    if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(se);
			    }
			    LOGGER.error("SearchException : impossible to search announcements");
			}

			total = searchAnnouncement(renderRequest, renderResponse, themeDisplay, announcements, total, hits);
			announcementSearchContainer.setTotal(total);
			announcementSearchContainer.setResults(announcements);
			
			// Get types
			List<Type> types = typeService.getTypesByGroupId(themeDisplay.getScopeGroupId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
			List<ManagementBarFilterItem> managementBarFilterItems = new ArrayList<ManagementBarFilterItem>();
			
			try {

				managementBarFilterItems.add(new ManagementBarFilterItem("All",
						LanguageUtil.get(themeDisplay.getLocale(), "all"),
						PortletURLUtil.clone(announcementSearchContainer.getIteratorURL(), renderResponse).toString()));
			} catch (PortletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
			if (types != null && types.size() > 0) {

				for (Type type : types) {

					try {
						PortletURL portletURL = PortletURLUtil.clone(announcementSearchContainer.getIteratorURL(),
								renderResponse);
						portletURL.setParameter("typeId", String.valueOf(type.getTypeId()));
						ManagementBarFilterItem managementBarFilterItem = new ManagementBarFilterItem(
								String.valueOf(type.getTypeId()), type.getName(themeDisplay.getLocale()),
								portletURL.toString());
						managementBarFilterItems.add(managementBarFilterItem);
					} catch (PortletException e) {
						if (LOGGER.isDebugEnabled()) {
							LOGGER.debug(e);
						}
						LOGGER.error("PortletException : impossible to clone announcementSearchContainer.getIteratorURL");
					}
				}
			}
			long typeId = GetterUtil.getLong(searchContext.getAttribute("typeId"));
			String managementBarFilterItemLabel = "All";

			if (typeId > 0) {
				announcementSearchContainer.getIteratorURL().setParameter("typeId", String.valueOf(typeId));
				try {
					Type type = TypeLocalServiceUtil.getType(typeId);

					if (Validator.isNotNull(type)) {
						managementBarFilterItemLabel = type.getName(themeDisplay.getLocale());
					}
				} catch (PortalException e) {
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug(e);
					}
					LOGGER.error("PortalException : impossible to get type id " + typeId);
				}

			}
			renderRequest.setAttribute("managementBarFilterItemLabel", managementBarFilterItemLabel);
			renderRequest.setAttribute("managementBarFilterItems", managementBarFilterItems);
		} catch (SystemException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("SystemException : impossible to get announcement search");
		}
		
		renderRequest.setAttribute("portletURL", announcementSearchContainer.getIteratorURL());
		renderRequest.setAttribute("searchAnnouncementContainer", announcementSearchContainer);
		renderRequest.setAttribute("displayStyle", displayStyle);
		return "/ravenbox/announcements/configuration/view.jsp";
	}
	

    /**
     * Create Search Context From Request
     * 
     * @param renderRequest
     * @param searchContainer
     * @param indexer 
     * @param themeDisplay
     * @param start
     * @param end
     * @return
     */
    private SearchContext createSearchContextFromRequest(RenderRequest renderRequest,
	    SearchContainer<Announcement> searchContainer, Indexer<Announcement> indexer, ThemeDisplay themeDisplay, int start, int end) {
	
		AnnouncementDisplayTerms displayTerms = null;
		SearchContext searchContext = SearchContextFactory.getInstance(PortalUtil.getHttpServletRequest(renderRequest));
		displayTerms = (AnnouncementDisplayTerms) searchContainer.getDisplayTerms();
		searchContext.setStart(start);
		searchContext.setEnd(end);
	
		if (displayTerms.isAdvancedSearch()) {
		    searchContext.setAndSearch(displayTerms.isAndOperator());
		} else {
		    searchContext.setKeywords(displayTerms.getKeywords());
		}
		
		long organizationId = themeDisplay.getScopeGroup().getOrganizationId();
	
		// Organization
		if (organizationId > 0) {
		    LinkedHashMap<String, Object> attributes = new LinkedHashMap<String, Object>();
		    attributes.put("usersOrgs", Long.valueOf(organizationId));
		    searchContext.setGroupIds(null);
		    searchContext.setAttribute("params", attributes);
		}
	
		// Navigation
		String navigation = ParamUtil.getString(renderRequest, "navigation", "active");
	
		if (!"active".equals(navigation)) {
		    searchContext.setAttribute(Field.STATUS, WorkflowConstants.STATUS_INACTIVE);
		}
		
		// Sort
		String  orderByCol = searchContainer.getOrderByCol();
		String  orderByType = searchContainer.getOrderByType();
		
		if (orderByCol.equals("create-date")) {
			orderByCol = Field.CREATE_DATE;
		}
		else if (orderByCol.equals("modified-date")) {
			orderByCol = Field.MODIFIED_DATE;
		}
		
		int sortType = AnnouncementUtil.getSortType(orderByCol);

		Sort sort = SortFactoryUtil.getSort(Announcement.class, sortType, orderByCol, orderByType);
	
		searchContext.setSorts(sort);
		
		QueryConfig queryConfig = new QueryConfig();
	
		queryConfig.setHighlightEnabled(true);
		searchContext.setQueryConfig(queryConfig);

		if (LOGGER.isDebugEnabled()) {
			LOGGER.info("sort" + sort);
			LOGGER.debug("orderByCol " + orderByCol);
			LOGGER.debug("orderByType " + orderByType);
			LOGGER.debug("displayTerms " + displayTerms);
			LOGGER.debug("navigation " + navigation);
			LOGGER.debug("start " + start);
			LOGGER.debug("end " + end);
			LOGGER.debug("sort " + sort);
		}
		
		return searchContext;
    }
    
    
	/**
	 * Search Announcement
	 * 
	 * @param renderRequest
	 * @param renderResponse
	 * @param themeDisplay
	 * @param users
	 * @param total
	 * @param hits
	 * @return
	 */
	private int searchAnnouncement(RenderRequest renderRequest, RenderResponse renderResponse,
			ThemeDisplay themeDisplay, List<Announcement> announcements, int total, Hits hits) {

		if (hits != null && hits.getLength() > 0) {
			List<SearchResult> searchResultsList = SearchResultUtil.getSearchResults(hits, themeDisplay.getLocale(),
					renderRequest, renderResponse);
			total = hits.getLength();

			if (total > 0) {
				for (SearchResult searchResult : searchResultsList) {
					try {
						Announcement announcement = announcementLocalService.getAnnouncement(searchResult.getClassPK());
						announcements.add(announcement);
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
	protected void setAnnouncementLocalService(
			AnnouncementLocalService announcementLocalService) {
		this.announcementLocalService = announcementLocalService;
	}

	private AnnouncementLocalService announcementLocalService;
	
	@Reference
	protected void setTypeService(
			TypeService typeService) {
		this.typeService = typeService;
	}

	private TypeService typeService;

}
