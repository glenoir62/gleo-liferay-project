package com.gleo.modules.ravenbox.web.portlet.types.indexer;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.gleo.modules.ravenbox.model.Type;
import com.gleo.modules.ravenbox.permission.TypePermission;
import com.gleo.modules.ravenbox.service.TypeLocalService;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelperUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.GetterUtil;

@Component(immediate = true, service = Indexer.class)
	public class TypeIndexer extends BaseIndexer<Type> {

	    public static final String CLASS_NAME = Type.class.getName();

	    public TypeIndexer() {
	    	setDefaultSelectedFieldNames(
    			Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, Field.GROUP_ID,
    			Field.PRIORITY, Field.SCOPE_GROUP_ID, Field.NAME, Field.UID);
    		setFilterSearch(true);
    		setPermissionAware(true);
    	}
	    
		@Override
		public String getClassName() {
			// TODO Auto-generated method stub
			return CLASS_NAME;
		}
	    
	    @Override
		public boolean hasPermission(
				PermissionChecker permissionChecker, String entryClassName,
				long entryClassPK, String actionId)
			throws Exception {

			return TypePermission.contains(
				permissionChecker, entryClassPK, ActionKeys.VIEW);
		}
	    
	    /*
	    @Override
		public boolean isVisible(long classPK, int status) throws Exception {
			Type entry = typeLocalService.getEntry(classPK);

			return isVisible(entry., status);
		}*/

		@Override
		protected void doDelete(Type object) throws Exception {
			deleteDocument(object.getCompanyId(), object.getTypeId());
			
		}

		@Override
		protected Document doGetDocument(Type object) throws Exception {
			Document document = getBaseModelDocument(CLASS_NAME, object);
			document.addText(Field.DESCRIPTION, object.getDescription());
			document.addNumber(Field.PRIORITY, object.getOrder());
			document.addText(Field.NAME, object.getName());

			return document;
		}

		@Override
		protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest,
				PortletResponse portletResponse) throws Exception {
			Summary summary = createSummary(document);

			summary.setMaxContentLength(200);

			return summary;
		}
		
		@Override
		protected void doReindex(Type object) throws Exception {
			Document document = getDocument(object);
			IndexWriterHelperUtil.updateDocument(
				getSearchEngineId(), object.getCompanyId(), document,
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
					public void performAction(Type entry) {
						try {
							Document document = getDocument(entry);

							indexableActionableDynamicQuery.addDocuments(document);
						}
						catch (PortalException pe) {
							if (_log.isWarnEnabled()) {
								_log.warn(
									"Unable to index blogs entry " +
										entry.getTypeId(),
									pe);
							}
						}
					}

				});
			indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());

			indexableActionableDynamicQuery.performActions();
		}
		
		@Reference
		protected void setTypeLocalService(
				TypeLocalService typeLocalService) {
			this.typeLocalService = typeLocalService;
		}

		private TypeLocalService typeLocalService;

		private static final Log _log = LogFactoryUtil.getLog(
			TypeIndexer.class);
	}