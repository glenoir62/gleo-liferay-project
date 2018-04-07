package com.gleo.modules.ravenbox.web.portlet.announcements.indexer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.gleo.modules.ravenbox.model.Announcement;
import com.gleo.modules.ravenbox.service.AnnouncementLocalService;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.message.boards.kernel.service.MBMessageLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.TermsFilter;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ClassResolverUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.ratings.kernel.model.RatingsStats;
import com.liferay.ratings.kernel.service.RatingsStatsLocalServiceUtil;

@Component(immediate = true, service = Indexer.class)
public class AnnouncementIndexer extends BaseIndexer<Announcement> {

	@Reference
	protected void setAnnouncementLocalService(AnnouncementLocalService announcementLocalService) {
		this.announcementLocalService = announcementLocalService;
	}

	@Reference
	protected void setIndexWriterHelper(IndexWriterHelper indexWriterHelper) {
		this.indexWriterHelper = indexWriterHelper;
	}

	@Reference
	protected void setAssetCategoryLocalService(AssetCategoryLocalService assetCategoryLocalService) {
		this.assetCategoryLocalService = assetCategoryLocalService;
	}

	private AssetCategoryLocalService assetCategoryLocalService;

	/**
	 * AnnouncementService
	 */
	private AnnouncementLocalService announcementLocalService;

	/**
	 * IndexWriterHelper
	 */
	protected IndexWriterHelper indexWriterHelper;

	private static final Log LOGGER = LogFactoryUtil.getLog(AnnouncementIndexer.class);

	/**
	 * Announcement Classname
	 */
	public static final String CLASS_NAME = Announcement.class.getName();

	/**
	 * Announcement PORTLET_ID
	 */
	public static final String PORTLET_ID = RavenBoxPortletKeys.ANNOUNCEMENTS_CONFIGURATION;

	public static final boolean ASSET_CATEGORIES_SEARCH_HIERARCHICAL = GetterUtil
			.getBoolean(PropsUtil.get(PropsKeys.ASSET_CATEGORIES_SEARCH_HIERARCHICAL));

	public AnnouncementIndexer() {
		setDefaultSelectedFieldNames(Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.CONTENT, Field.ENTRY_CLASS_NAME,
				Field.ENTRY_CLASS_PK, Field.GROUP_ID, Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID, Field.TITLE,
				Field.UID);
		setFilterSearch(true);
		setPermissionAware(true);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
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
			commentsCount = MBMessageLocalServiceUtil.getDiscussionMessagesCount(Announcement.class.getName(),
					announcement.getAnnouncementId(), WorkflowConstants.STATUS_APPROVED);
			RatingsStats ratingsStats = RatingsStatsLocalServiceUtil.getStats(Announcement.class.getName(),
					announcement.getAnnouncementId());
			ratingsCount = ratingsStats.getAverageScore();
		}

		Document document = getBaseModelDocument(PORTLET_ID, announcement);

		document.addDate(Field.MODIFIED_DATE, announcement.getModifiedDate());
		document.addDate(Field.CREATE_DATE, announcement.getCreateDate());
		document.addLocalizedKeyword(Field.TITLE, announcement.getTitleMap());
		document.addKeyword("announcementId", announcement.getAnnouncementId());
		document.addNumber("price", announcement.getPrice());
		document.addKeyword("phone", announcement.getPhoneNumber());
		document.addNumber("typeId", announcement.getTypeId());
		document.addLocalizedKeyword("typeName", announcement.getType().getNameMap());
		document.addKeyword("regionId", announcement.getRegionId());
		document.addKeyword("countryId", announcement.getCountryId());
//		document.addLocalizedKeyword("regionName", announcement.getRegion());
//		document.addLocalizedKeyword("countryName", announcement.getCountry());
		
		document.addKeyword("emailAddress", announcement.getEmailAddress());

		document.addNumber(Field.COMMENTS, commentsCount);
		document.addNumber(Field.RATINGS, ratingsCount);
		
		LOGGER.info("announcement = "+ document);

		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest,
			PortletResponse portletResponse) throws Exception {
		String title = document.get(locale, Field.TITLE);

		String content = snippet;

		if (Validator.isNull(snippet)) {
			content = document.get(Field.DESCRIPTION);

			if (Validator.isNull(content)) {
				content = StringUtil.shorten(document.get(Field.CONTENT), 200);
			}
		}

		// String resourcePrimKey = document.get(Field.ENTRY_CLASS_PK);
		// portletURL.setParameter("action", "full_content");
		// portletURL.setParameter("resourcePrimKey", resourcePrimKey);

		return new Summary(title, content);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {

		Announcement announcement = announcementLocalService.getAnnouncement(classPK);

		doReindex(announcement);

	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		reindexEntries(companyId);

	}

	protected void reindexEntries(long companyId) throws PortalException {
		final IndexableActionableDynamicQuery indexableActionableDynamicQuery = announcementLocalService
				.getIndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setAddCriteriaMethod(new ActionableDynamicQuery.AddCriteriaMethod() {

			@Override
			public void addCriteria(DynamicQuery dynamicQuery) {
//				Property displayDateProperty = PropertyFactoryUtil.forName("displayDate");
//
//				dynamicQuery.add(displayDateProperty.lt(new Date()));

				Property statusProperty = PropertyFactoryUtil.forName("status");

				Integer[] statuses = { WorkflowConstants.STATUS_APPROVED, WorkflowConstants.STATUS_IN_TRASH };

				dynamicQuery.add(statusProperty.in(statuses));
			}

		});
		indexableActionableDynamicQuery.setCompanyId(companyId);
		indexableActionableDynamicQuery
				.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Announcement>() {

					@Override
					public void performAction(Announcement entry) {
						try {
							Document document = getDocument(entry);

							indexableActionableDynamicQuery.addDocuments(document);
						} catch (PortalException pe) {
							if (LOGGER.isWarnEnabled()) {
								LOGGER.warn("Unable to index announcement entry " + entry.getAnnouncementId(), pe);
							}
						}
					}

				});
		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());

		indexableActionableDynamicQuery.performActions();
	}

	@Override
	protected void doReindex(Announcement announcement) throws Exception {
		Document document = getDocument(announcement);

		indexWriterHelper.updateDocument(getSearchEngineId(), announcement.getCompanyId(), document,
				isCommitImmediately());

	}

	@Override
	public void postProcessSearchQuery(BooleanQuery searchQuery, SearchContext searchContext) throws Exception {

		if (searchContext.getAttributes() == null) {
			return;
		}

		addSearchLocalizedTerm(searchQuery, searchContext, Field.TITLE, true);
	}

	@Override
	protected void addSearchAssetCategoryIds(BooleanFilter booleanFilter, SearchContext searchContext)
			throws Exception {

		addSearchAnyCategories(booleanFilter, searchContext);
	}

	/**
	 * @param contextQuery
	 * @param searchContext
	 * @throws Exception
	 */
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
			AssetCategory assetCategory = assetCategoryLocalService.fetchAssetCategory(anyCategoryId);

			if (assetCategory == null) {
				continue;
			}

			List<Long> categoryIds = new ArrayList<>();

			if (ASSET_CATEGORIES_SEARCH_HIERARCHICAL) {
				categoryIds.addAll(assetCategoryLocalService.getSubcategoryIds(anyCategoryId));
			}

			if (categoryIds.isEmpty()) {
				categoryIds.add(anyCategoryId);
			}

			categoryIdsTermsFilter
					.addValues(ArrayUtil.toStringArray(categoryIds.toArray(new Long[categoryIds.size()])));
		}

		queryBooleanFilter.add(categoryIdsTermsFilter, BooleanClauseOccur.MUST);
	}

	/**
	 * @param permissionChecker
	 * @param categoryIds
	 * @return
	 * @throws PortalException
	 */
	public long[] filterCategoryIds(PermissionChecker permissionChecker, long[] categoryIds) throws PortalException {

		String portalLevelClassName = "com.liferay.portlet.asset.service.permission.AssetCategoryPermission";
		String requiredPortalLevelMthodName = "contains";
		Class<?>[] parameterTypePortalArray = { PermissionChecker.class, AssetCategory.class, String.class };

		List<Long> viewableCategoryIds = new ArrayList<>();

		for (long categoryId : categoryIds) {
			AssetCategory category = assetCategoryLocalService.fetchCategory(categoryId);

			Object[] valuesPortalArray = { permissionChecker, category, ActionKeys.VIEW };
			MethodKey getSessionUsers = new MethodKey(
					ClassResolverUtil.resolveByPortalClassLoader(portalLevelClassName), requiredPortalLevelMthodName,
					parameterTypePortalArray);

			try {
				if ((category != null)
						&& GetterUtil.getBoolean(PortalClassInvoker.invoke(getSessionUsers, valuesPortalArray))) {
					viewableCategoryIds.add(categoryId);
				}
			} catch (Exception e) {
				LOGGER.error(e);
			}
		}

		return ArrayUtil.toArray(viewableCategoryIds.toArray(new Long[viewableCategoryIds.size()]));
	}

	/**
	 * @param queryBooleanFilter
	 * @param field
	 * @throws Exception
	 */
	protected void addImpossibleTerm(BooleanFilter queryBooleanFilter, String field) throws Exception {

		queryBooleanFilter.addTerm(field, "-1", BooleanClauseOccur.MUST);
	}
	
	@Override
	public void postProcessSearchQuery(
			BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter,
			SearchContext searchContext)
		throws Exception {

		addStatus(fullQueryBooleanFilter, searchContext);
		
		boolean isUserAnnouncements = GetterUtil.getBoolean(searchContext.getAttribute("isUserAnnouncements"));;

		int announcementId = GetterUtil.getInteger(searchContext.getAttribute("announcementId"));
		long currencyId = GetterUtil.getLong(searchContext.getAttribute("currencyId"));
		long typeId = GetterUtil.getLong(searchContext.getAttribute("typeId"));
		long regionId = GetterUtil.getLong(searchContext.getAttribute("regionId"));
		long countryId = GetterUtil.getLong(searchContext.getAttribute("countryId"));

		if (announcementId != 0) {
			searchQuery.addRequiredTerm("announcementId", announcementId);
		}

		if (currencyId != 0) {
			searchQuery.addRequiredTerm("currencyId", currencyId);
		}

		if (typeId != 0) {
			searchQuery.addRequiredTerm("typeId", typeId);
		}
		
		if (regionId != 0) {
			searchQuery.addRequiredTerm("regionId", regionId);
		}
		
		if (countryId != 0) {
			searchQuery.addRequiredTerm("countryId", countryId);
		}

		if (isUserAnnouncements) {
			
			BooleanQuery userIdQuery = new BooleanQueryImpl();
			userIdQuery.addRequiredTerm(Field.USER_ID, searchContext.getUserId());
			searchQuery.add(userIdQuery, BooleanClauseOccur.MUST);
		}
		
	}

}
