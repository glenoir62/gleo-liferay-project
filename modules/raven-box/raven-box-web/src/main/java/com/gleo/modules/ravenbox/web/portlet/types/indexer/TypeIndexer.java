package com.gleo.modules.ravenbox.web.portlet.types.indexer;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.gleo.modules.ravenbox.model.Type;
import com.gleo.modules.ravenbox.service.TypeLocalService;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.GetterUtil;

@Component(immediate = true, service = Indexer.class)
public class TypeIndexer extends BaseIndexer<Type> {

	public static final String CLASS_NAME = Type.class.getName();

	public TypeIndexer() {
		setPermissionAware(true);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public String[] getClassNames() {
		return new String[] {
				CLASS_NAME
		};
	}
	
	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, String entryClassName,
			long entryClassPK, String actionId)
		throws Exception {

//		return TypePermission.contains(
//			permissionChecker, entryClassPK, ActionKeys.VIEW);
		
		return true;
	}
	
	@Override
	public void postProcessContextBooleanFilter(
			BooleanFilter contextBooleanFilter, SearchContext searchContext)
		throws Exception {


	}
	
	@Override
	public void postProcessSearchQuery(
			BooleanQuery searchQuery, SearchContext searchContext)
		throws Exception {

		if (searchContext.getAttributes() == null) {
			return;
		}

	}
	
	@Override
	public boolean isVisible(long classPK, int status) throws Exception {
		return true;
	}

	@Override
	protected void doDelete(Type type) throws Exception {
		deleteDocument(type.getCompanyId(), type.getTypeId());
	}

	@Override
	protected Document doGetDocument(Type type) throws Exception {
		Document document = getBaseModelDocument(RavenBoxPortletKeys.TYPES_CONFIGURATION , type);

		document.addKeyword(Field.COMPANY_ID, type.getCompanyId());
		document.addKeyword(Field.GROUP_ID, getSiteGroupId(type.getGroupId()));
		document.addKeyword(Field.SCOPE_GROUP_ID, type.getGroupId());
		document.addNumber(Field.PRIORITY, type.getOrder());
		document.addKeyword("typeId", type.getTypeId());
		document.addLocalizedKeyword(Field.TITLE, type.getNameMap());
		LOGGER.info(type.getNameMap());
		LOGGER.info(document);

		return document;
	}

	@Override
	protected Summary doGetSummary(
		Document document, Locale locale, String snippet,
		PortletRequest portletRequest, PortletResponse portletResponse) {

		Summary summary = createSummary(document);

		summary.setMaxContentLength(200);

		return summary;
	}

	@Override
	protected void doReindex(Type type) throws Exception {
		Document document = getDocument(type);

		indexWriterHelper.updateDocument(
			getSearchEngineId(), type.getCompanyId(), document,
			isCommitImmediately());
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Type entry = typeLocalService.getType(classPK);

		doReindex(entry);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		reindexEntries(companyId);
	}

	protected void reindexEntries(long companyId) throws PortalException {
		final IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			typeLocalService.getIndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {

				}

			});
		indexableActionableDynamicQuery.setCompanyId(companyId);
		indexableActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Type>() {

				@Override
				public void performAction(Type type) {
					try {
						Document document = getDocument(type);

						if (document != null) {
							indexableActionableDynamicQuery.addDocuments(document);
						}
					}
					catch (PortalException pe) {
						if (LOGGER.isWarnEnabled()) {
							LOGGER.warn(
								"Unable to index Type " +
									type.getTypeId(),
								pe);
						}
					}
				}

			});
		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());

		indexableActionableDynamicQuery.performActions();
	}

	@Reference
	public void setTypeLocalService(TypeLocalService typeLocalService) {
		this.typeLocalService = typeLocalService;
	}
	
	@Reference
	public void setIndexWriterHelper(IndexWriterHelper indexWriterHelper) {
		this.indexWriterHelper = indexWriterHelper;
	}


	protected IndexWriterHelper indexWriterHelper;

	protected TypeLocalService typeLocalService;

	private static final Log LOGGER = LogFactoryUtil.getLog(
			TypeIndexer.class);

}