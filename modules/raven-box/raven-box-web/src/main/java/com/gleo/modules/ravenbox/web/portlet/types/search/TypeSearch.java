package com.gleo.modules.ravenbox.web.portlet.types.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.gleo.modules.ravenbox.model.Announcement;
import com.gleo.modules.ravenbox.model.Type;
import com.gleo.modules.ravenbox.web.portlet.announcements.search.AnnouncementDisplayTerms;
import com.gleo.modules.ravenbox.web.portlet.announcements.search.AnnouncementSearch;
import com.gleo.modules.ravenbox.web.portlet.announcements.search.AnnouncementSearchTerms;
import com.gleo.modules.ravenbox.web.util.AnnouncementUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletProvider;
import com.liferay.portal.kernel.portlet.PortletProviderUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

public class TypeSearch extends SearchContainer<Type> {
	
	/**
	 * Default empty result message
	 */
	public static final String EMPTY_RESULTS_MESSAGE = "type-empty-results-message";

	/**
	 * Default cur param
	 */
	public static final String DEFAULT_CUR_PARAM = "curTypes";
	
	/**
	 * The Logger
	 */
	private static final Log LOGGER = LogFactoryUtil.getLog(AnnouncementSearch.class);

	/**
	 * AnnouncementSearch
	 * 
	 * @param portletRequest
	 * @param iteratorURL
	 */
	public TypeSearch(PortletRequest portletRequest, PortletURL iteratorURL) {
		this(portletRequest, DEFAULT_CUR_PARAM, iteratorURL);
	}
	
	public static List<String> headerNames = new ArrayList<>();
	public static Map<String, String> orderableHeaders = new HashMap<>();
	
	static {
		headerNames.add("Id");
		headerNames.add("companyId");
		headerNames.add("groupId");
		headerNames.add("email-address");
		headerNames.add("name");

		orderableHeaders.put("Id", "Id");
		orderableHeaders.put("companyId", "companyId");
		orderableHeaders.put("groupId", "groupId");
		orderableHeaders.put("name", "name");
	}

    /**
     * AnnouncementSearch
     * 
     * @param portletRequest
     * @param curParam
     * @param iteratorURL
     */
	public TypeSearch(PortletRequest portletRequest, String curParam, PortletURL iteratorURL) {

		//"javax.portlet.init-param.mvc-command-names-default-views=/document_library/view",
		super(portletRequest, new AnnouncementDisplayTerms(portletRequest), new AnnouncementSearchTerms(portletRequest),
				curParam, DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		PortletConfig portletConfig = (PortletConfig) portletRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);

		AnnouncementDisplayTerms displayTerms = (AnnouncementDisplayTerms) getDisplayTerms();
		AnnouncementSearchTerms searchTerms = (AnnouncementSearchTerms) getSearchTerms();

		String portletId = PortletProviderUtil.getPortletId(Announcement.class.getName(), PortletProvider.Action.VIEW);
		String portletName = portletConfig.getPortletName();

		if (!portletId.equals(portletName)) {
			displayTerms.setStatus(WorkflowConstants.STATUS_APPROVED);
			searchTerms.setStatus(WorkflowConstants.STATUS_APPROVED);
		}

		iteratorURL.setParameter(AnnouncementDisplayTerms.STATUS, String.valueOf(displayTerms.getStatus()));

		iteratorURL.setParameter(AnnouncementDisplayTerms.GROUP_ID, String.valueOf(displayTerms.getGroupId()));
		iteratorURL.setParameter(AnnouncementDisplayTerms.PRICE, String.valueOf(displayTerms.getPrice()));
		iteratorURL.setParameter(AnnouncementDisplayTerms.ORGANIZATION_ID,
				String.valueOf(displayTerms.getOrganizationId()));

		try {
			PortalPreferences preferences = PortletPreferencesFactoryUtil.getPortalPreferences(portletRequest);

			String orderByCol = ParamUtil.getString(portletRequest, "orderByCol");
			String orderByType = ParamUtil.getString(portletRequest, "orderByType");

			if (Validator.isNotNull(orderByCol) && Validator.isNotNull(orderByType)) {

				preferences.setValue(portletId, "announcement-order-by-col", orderByCol);
				preferences.setValue(portletId, "announcement-order-by-type", orderByType);
			} else {
				orderByCol = preferences.getValue(portletId, "announcement-order-by-col", Field.CREATE_DATE);
				orderByType = preferences.getValue(portletId, "announcement-order-by-type", "asc");
			}
			
			boolean orderByModel = false;
			//OrderByComparator<Type> orderByComparator = TypeUtil.get//.getAnnouncementOrderByComparator(orderByCol, orderByType, orderByModel);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			//setOrderByComparator(orderByComparator);
		} catch (Exception e) {
			LOGGER.error(e);
		}
	}
}
