
package com.gleo.plugins.hexiagon.portlet.announcements.indexer;

import com.gleo.plugins.hexiagon.constants.PortletKeys;
import com.gleo.plugins.hexiagon.model.Announcement;
import com.gleo.plugins.hexiagon.service.AnnouncementLocalServiceUtil;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.message.boards.kernel.service.MBMessageLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelperUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.TermsFilter;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.ratings.kernel.model.RatingsStats;
import com.liferay.ratings.kernel.service.RatingsStatsLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.apache.commons.lang.StringUtils;

/**
 * @author guillaumelenoir
 *
 */
public class AnnouncementIndexer extends BaseIndexer<Announcement> {

	private static final Log log = LogFactoryUtil.getLog(
			AnnouncementIndexer.class);
	
	public static final String[] CLASS_NAMES = {
		Announcement.class.getName()
	};

	public static final String PORTLET_ID = PortletKeys.ANNOUNCEMENT_PORTLETID;

	public AnnouncementIndexer() {

		setPermissionAware(true);
	}

	public String[] getClassNames() {

		return CLASS_NAMES;
	}

	@Override
	protected void doReindex(String className, long classPK)
		throws Exception {

		Announcement announcement = AnnouncementLocalServiceUtil.getAnnouncement(classPK);

		doReindex(announcement);
	}

	@Override
	protected void doReindex(String[] ids)
		throws Exception {

		long companyId = GetterUtil.getLong(ids[0]);

		reindexEntries(companyId);
	}

	protected void reindexEntries(long companyId)
		throws PortalException, SystemException {

		final IndexableActionableDynamicQuery indexableActionableDynamicQuery = AnnouncementLocalServiceUtil.getIndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setAddCriteriaMethod(new ActionableDynamicQuery.AddCriteriaMethod() {

			@Override
			public void addCriteria(DynamicQuery dynamicQuery) {
				Property property = PropertyFactoryUtil.forName("status");

				dynamicQuery.add(property.eq(WorkflowConstants.STATUS_IN_TRASH));
			}

		});
		indexableActionableDynamicQuery.setCompanyId(companyId);
		indexableActionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Announcement>() {

					@Override
					public void performAction(Announcement announcement) {
						try {

							Document document = getDocument(announcement);

							indexableActionableDynamicQuery.addDocuments(document);
						} catch (PortalException pe) {
							if (log.isWarnEnabled()) {
								log.warn("Unable to index annoncement " + announcement.getAnnouncementId(), pe);
							}
						}
					}

				});
		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());

		indexableActionableDynamicQuery.performActions();
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {

		return PORTLET_ID;
	}

	@Override
	public void postProcessSearchQuery(BooleanQuery searchQuery, SearchContext searchContext)
		throws Exception {

		if (searchContext.getAttributes() == null) {
			return;
		}

		addSearchLocalizedTerm(searchQuery, searchContext, Field.TITLE, true);
	}

	@Override
	public void postProcessContextBooleanFilter(
			BooleanFilter contextBooleanFilter, SearchContext searchContext)
		throws Exception {

		addStatus(contextBooleanFilter, searchContext);

		int announcementId = GetterUtil.getInteger(searchContext.getAttribute("announcementId"));
		long currencyId = GetterUtil.getLong(searchContext.getAttribute("currencyId"));
		long typeId = GetterUtil.getLong(searchContext.getAttribute("typeId"));
		long regionId = GetterUtil.getLong(searchContext.getAttribute("regionId"));
		long countryId = GetterUtil.getLong(searchContext.getAttribute("countryId"));
		
		boolean isUserAnnouncements = GetterUtil.getBoolean(searchContext.getAttribute("isUserAnnouncements"));;

		if (announcementId != 0) {
			contextBooleanFilter.addRequiredTerm("announcementId", announcementId);
		}

		if (currencyId != 0) {
			contextBooleanFilter.addRequiredTerm("currencyId", currencyId);
		}

		if (typeId != 0) {
			contextBooleanFilter.addRequiredTerm("typeId", typeId);
		}
		
		if (regionId != 0) {
			contextBooleanFilter.addRequiredTerm("regionId", regionId);
		}
		
		if (countryId != 0) {
			contextBooleanFilter.addRequiredTerm("countryId", countryId);
		}
		
		if (isUserAnnouncements) {
			BooleanFilter statusBooleanFilter = new BooleanFilter();
			statusBooleanFilter.addRequiredTerm(Field.USER_ID, searchContext.getUserId());
			contextBooleanFilter.add(statusBooleanFilter, BooleanClauseOccur.MUST);
		}
	}

	@Override
	protected void addSearchAssetCategoryIds(
			BooleanFilter queryBooleanFilter, SearchContext searchContext)
		throws Exception {

		addSearchAnyCategories(queryBooleanFilter, searchContext);

	}

	@Override
	public String getPortletId() {

		return PORTLET_ID;
	}
	
	protected void addSearchAnyCategories(BooleanFilter queryBooleanFilter, SearchContext searchContext)
			throws Exception {

		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();

		long[] anyCategoryIds = searchContext.getAssetCategoryIds();

		if (anyCategoryIds.length == 0) {
			return;
		}

		long[] filteredAnyCategoryIds = filterCategoryIds(permissionChecker, anyCategoryIds);

		if (filteredAnyCategoryIds.length == 0) {
			addImpossibleTerm(queryBooleanFilter, Field.ASSET_CATEGORY_IDS);

			return;
		}

		TermsFilter categoryIdsTermsFilter = new TermsFilter(Field.ASSET_CATEGORY_IDS);

		for (long anyCategoryId : filteredAnyCategoryIds) {
			AssetCategory assetCategory = AssetCategoryLocalServiceUtil.fetchAssetCategory(anyCategoryId);

			if (assetCategory == null) {
				continue;
			}

			List<Long> categoryIds = new ArrayList<>();

			if (GetterUtil.getBoolean(PropsUtil.get(PropsKeys.ASSET_CATEGORIES_SEARCH_HIERARCHICAL))) {
				categoryIds.addAll(AssetCategoryLocalServiceUtil.getSubcategoryIds(anyCategoryId));
			}

			if (categoryIds.isEmpty()) {
				categoryIds.add(anyCategoryId);
			}

			categoryIdsTermsFilter
					.addValues(ArrayUtil.toStringArray(categoryIds.toArray(new Long[categoryIds.size()])));
		}

		queryBooleanFilter.add(categoryIdsTermsFilter, BooleanClauseOccur.MUST);
	}
	
	public static long[] filterCategoryIds(
			PermissionChecker permissionChecker, long[] categoryIds)
		throws PortalException {

		List<Long> viewableCategoryIds = new ArrayList<>();

		for (long categoryId : categoryIds) {
//			AssetCategory category =
//				AssetCategoryLocalServiceUtil.fetchCategory(categoryId);

//			if ((category != null) &&
//				AssetCategoryPermission.contains(
//					permissionChecker, categoryId, ActionKeys.VIEW)) {

				viewableCategoryIds.add(categoryId);
//			}
		}

		return ArrayUtil.toArray(
			viewableCategoryIds.toArray(new Long[viewableCategoryIds.size()]));
	}

	
	protected void addImpossibleTerm(BooleanFilter queryBooleanFilter, String field) throws Exception {

		queryBooleanFilter.addTerm(field, "-1", BooleanClauseOccur.MUST);
	}
	
	@Override
	public String getClassName() {
		return Announcement.class.getName();
	}

	@Override
	protected void doDelete(Announcement announcement) throws Exception {
		deleteDocument(announcement.getCompanyId(), announcement.getAnnouncementId());
		
	}

	@Override
	protected Document doGetDocument(Announcement announcement) throws Exception {
		int commentsCount = 0;
		double ratingsCount = 0;
		if (announcement != null && !announcement.isNew()) {
			commentsCount = MBMessageLocalServiceUtil.getDiscussionMessagesCount(Announcement.class.getName(), announcement.getAnnouncementId(), WorkflowConstants.STATUS_APPROVED);
			RatingsStats ratingsStats = RatingsStatsLocalServiceUtil.getStats(Announcement.class.getName(), announcement.getAnnouncementId());
			ratingsCount = ratingsStats.getAverageScore();
		}

		Document document = getBaseModelDocument(PORTLET_ID, announcement);

		document.addDate(Field.MODIFIED_DATE, announcement.getModifiedDate());
		document.addDate(Field.CREATE_DATE, announcement.getCreateDate());
		document.addLocalizedKeyword(Field.TITLE, announcement.getTitleMap());
		document.addKeyword("announcementId", announcement.getAnnouncementId());
		document.addKeyword("currencyId", announcement.getCurrencyId());
		document.addKeyword("price", announcement.getPrice());
		document.addKeyword("typeId", announcement.getTypeId());
		document.addKeyword("regionId", announcement.getRegionId());
		document.addKeyword("countryId", announcement.getCountryId());

		document.addNumber(Field.COMMENTS, commentsCount);
		document.addNumber(Field.RATINGS, ratingsCount);

		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest,
			PortletResponse portletResponse) throws Exception {
		String title = document.get(locale, Field.TITLE);

		String content = snippet;

		if (StringUtils.isEmpty(snippet)) {
			content = document.get(Field.DESCRIPTION);

			if (StringUtils.isEmpty(content)) {
				content = StringUtil.shorten(document.get(Field.CONTENT), 200);
			}
		}

		Summary summary = new Summary(locale, title, content);

		summary.setMaxContentLength(200);

		return summary;
	}

	@Override
	protected void doReindex(Announcement announcement) throws Exception {
		Document document = getDocument(announcement);

		IndexWriterHelperUtil.updateDocument(
				getSearchEngineId(), announcement.getCompanyId(), document, false);
	}
}
