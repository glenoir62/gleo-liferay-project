package com.gleo.plugins.hexiagon.portlet.announcements.listener;

import com.gleo.plugins.hexiagon.constants.AnnouncementConstants;
import com.gleo.plugins.hexiagon.constants.PortletKeys;
import com.gleo.plugins.hexiagon.model.Announcement;
import com.gleo.plugins.hexiagon.service.AnnouncementLocalServiceUtil;
import com.gleo.plugins.hexiagon.util.PortalUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.LinkedHashMap;
import java.util.List;

import javax.portlet.PortletPreferences;

import org.joda.time.DateTime;

/**
 * @author guillaumelenoir
 *
 */
public class AnnouncementsScheduler implements MessageListener {
	
	/**
	 * The logger.
	 */
	private static final Log LOGGER = LogFactoryUtil.getLog(AnnouncementsScheduler.class);
	
//	/**
//	 * Default delta
//	 */
//	private static int DELTA = 1000;
	
	/**
	 * Delete all announcements by expiration date
	 * Fire every day at midnight
	 * 0 0 0 * * ?
	 * Change it from liferay-portlet.properties
	 * 
	 * @param message
	 * @throws MessageListenerException
	 */
	public void receive(Message message) throws MessageListenerException {
		LOGGER.info("BEGIN : delete all announcements by expiration date");
		
		if (AnnouncementConstants.ANNONCEMENTS_SCHEDULER_DELETE_ENABLED) {
			try {
				
				List<Company> companies = CompanyLocalServiceUtil.getCompanies();
				
				deleteAnnoucementsFromCompanies(companies);
			} catch (Exception e) {
				LOGGER.error(e);
			}
		}
		
		LOGGER.info("END : delete all announcements by expiration date");
	}

	/**
	 * Delete Annoucements From Companies
	 * 
	 * @param companies
	 * @throws SystemException
	 * @throws PortalException
	 */
	private void deleteAnnoucementsFromCompanies(List<Company> companies)
			throws SystemException, PortalException {
		
		for (Company company : companies) {
			LinkedHashMap<String, Object> params = new LinkedHashMap<String, Object>(2);
			params.put("site", true);
			params.put("active", true);
			
			List<Group> groups = GroupLocalServiceUtil.search(company.getCompanyId(), StringPool.BLANK, params, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
			deleteAnnouncementsFromGroups(groups);
		}
	}

	/**
	 * Delete Announcements From Groups
	 * 
	 * @param groups
	 * @throws PortalException
	 * @throws SystemException
	 */
	private void deleteAnnouncementsFromGroups(List<Group> groups)
			throws PortalException, SystemException {
		for (Group group : groups) {
			long announcementDisplayPlid = PortalUtil.getPlidFromPortletId(group.getGroupId(), PortletKeys.ADD_ANNOUNCEMENT_PORTLETID);
			
			if (announcementDisplayPlid != LayoutConstants.DEFAULT_PLID) {
				Layout announcementDisplayLayout = LayoutLocalServiceUtil.getLayout(announcementDisplayPlid);
				PortletPreferences announcementDisplayRelatedAssetsPreferences = PortletPreferencesFactoryUtil.getLayoutPortletSetup(announcementDisplayLayout, PortletKeys.ADD_ANNOUNCEMENT_PORTLETID);
				
				// Time to live for an announcement
				int days = GetterUtil.getInteger(announcementDisplayRelatedAssetsPreferences.getValue(AnnouncementConstants.DEFAULT_PERIOD_TO_DELETE_IN_DAYS, String.valueOf(AnnouncementConstants.ANNONCEMENTS_DEFAULT_PERIOD_TO_DELETE_IN_DAYS)));	
				
				if (group != null) {
					
					long groupId = group.getGroupId();
					
					LOGGER.info("Days = " + days);
					LOGGER.info("GroupId = " + groupId);
					
					deleteAnnouncements(days, groupId);
				}
			}
		}
	}

	/**
	 * Delete Announcements
	 * 
	 * @param days
	 * @throws SystemException
	 */
	private void deleteAnnouncements(int days, long groupId) throws SystemException {
		DateTime dateMinus = DateTime.now();
		dateMinus = dateMinus.minusDays(days);

		DynamicQuery dynamicQuery = AnnouncementLocalServiceUtil.dynamicQuery();
		
		dynamicQuery.add(PropertyFactoryUtil.forName(Field.STATUS).eq(WorkflowConstants.STATUS_ANY));
		dynamicQuery.add(PropertyFactoryUtil.forName(Field.CREATE_DATE).lt(dateMinus.toDate()));
		dynamicQuery.add(PropertyFactoryUtil.forName(Field.GROUP_ID).eq(groupId));
		
		long count = AnnouncementLocalServiceUtil.dynamicQueryCount(dynamicQuery);
		
		LOGGER.info("Get " + count +" announcements to delete");
		
		if(count > 0) {
			
			List<Announcement> announcements = AnnouncementLocalServiceUtil.dynamicQuery(dynamicQuery, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
			// Delete Announcement
			AnnouncementLocalServiceUtil.deleteAnnouncements(announcements);
			
			// For perf ?
			
/*			int start = 0;
			int end = 0;
			int page = 1;
			
			// Not the best way !
			double limit = Math.floor(count / DELTA) + (count% DELTA ==0?0:1);
			
			while (page <= limit) {
				start = end;
				end = page * DELTA;
				
				if(end > count) {
					end = GetterUtil.getInteger(count);
				}
				page ++;
				
				@SuppressWarnings("unchecked")
				List<Announcement> announcements = (List<Announcement>) AnnouncementLocalServiceUtil.dynamicQuery(dynamicQuery, start, end);
				
				// Delete Announcement
				AnnouncementLocalServiceUtil.deleteAnnouncements(announcements);
			}
*/		
		}
	}
 }  
