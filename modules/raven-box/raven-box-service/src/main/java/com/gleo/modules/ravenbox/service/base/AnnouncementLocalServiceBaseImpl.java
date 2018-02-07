/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.gleo.modules.ravenbox.service.base;

import aQute.bnd.annotation.ProviderType;

import com.gleo.modules.ravenbox.model.Announcement;
import com.gleo.modules.ravenbox.service.AnnouncementLocalService;
import com.gleo.modules.ravenbox.service.persistence.AnnouncementImagePersistence;
import com.gleo.modules.ravenbox.service.persistence.AnnouncementPersistence;
import com.gleo.modules.ravenbox.service.persistence.CurrencyPersistence;
import com.gleo.modules.ravenbox.service.persistence.FavoritePersistence;
import com.gleo.modules.ravenbox.service.persistence.TypePersistence;

import com.liferay.asset.kernel.service.persistence.AssetEntryPersistence;
import com.liferay.asset.kernel.service.persistence.AssetLinkPersistence;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerRegistryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.message.boards.kernel.service.persistence.MBMessagePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.liferay.social.kernel.service.persistence.SocialActivityPersistence;

import com.liferay.trash.kernel.service.persistence.TrashVersionPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the announcement local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.gleo.modules.ravenbox.service.impl.AnnouncementLocalServiceImpl}.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see com.gleo.modules.ravenbox.service.impl.AnnouncementLocalServiceImpl
 * @see com.gleo.modules.ravenbox.service.AnnouncementLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class AnnouncementLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements AnnouncementLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.gleo.modules.ravenbox.service.AnnouncementLocalServiceUtil} to access the announcement local service.
	 */

	/**
	 * Adds the announcement to the database. Also notifies the appropriate model listeners.
	 *
	 * @param announcement the announcement
	 * @return the announcement that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Announcement addAnnouncement(Announcement announcement) {
		announcement.setNew(true);

		return announcementPersistence.update(announcement);
	}

	/**
	 * Creates a new announcement with the primary key. Does not add the announcement to the database.
	 *
	 * @param announcementId the primary key for the new announcement
	 * @return the new announcement
	 */
	@Override
	public Announcement createAnnouncement(long announcementId) {
		return announcementPersistence.create(announcementId);
	}

	/**
	 * Deletes the announcement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param announcementId the primary key of the announcement
	 * @return the announcement that was removed
	 * @throws PortalException if a announcement with the primary key could not be found
	 * @throws SystemException
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Announcement deleteAnnouncement(long announcementId)
		throws PortalException, SystemException {
		return announcementPersistence.remove(announcementId);
	}

	/**
	 * Deletes the announcement from the database. Also notifies the appropriate model listeners.
	 *
	 * @param announcement the announcement
	 * @return the announcement that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Announcement deleteAnnouncement(Announcement announcement) {
		return announcementPersistence.remove(announcement);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Announcement.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return announcementPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gleo.modules.ravenbox.model.impl.AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return announcementPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gleo.modules.ravenbox.model.impl.AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return announcementPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return announcementPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return announcementPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public Announcement fetchAnnouncement(long announcementId) {
		return announcementPersistence.fetchByPrimaryKey(announcementId);
	}

	/**
	 * Returns the announcement matching the UUID and group.
	 *
	 * @param uuid the announcement's UUID
	 * @param groupId the primary key of the group
	 * @return the matching announcement, or <code>null</code> if a matching announcement could not be found
	 */
	@Override
	public Announcement fetchAnnouncementByUuidAndGroupId(String uuid,
		long groupId) {
		return announcementPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the announcement with the primary key.
	 *
	 * @param announcementId the primary key of the announcement
	 * @return the announcement
	 * @throws PortalException if a announcement with the primary key could not be found
	 */
	@Override
	public Announcement getAnnouncement(long announcementId)
		throws PortalException {
		return announcementPersistence.findByPrimaryKey(announcementId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(announcementLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Announcement.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("announcementId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(announcementLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Announcement.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"announcementId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(announcementLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Announcement.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("announcementId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {
		final ExportActionableDynamicQuery exportActionableDynamicQuery = new ExportActionableDynamicQuery() {
				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary = portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(stagedModelType,
						modelAdditionCount);

					long modelDeletionCount = ExportImportHelperUtil.getModelDeletionCount(portletDataContext,
							stagedModelType);

					manifestSummary.addModelDeletionCount(stagedModelType,
						modelDeletionCount);

					return modelAdditionCount;
				}
			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(new ActionableDynamicQuery.AddCriteriaMethod() {
				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					Criterion modifiedDateCriterion = portletDataContext.getDateRangeCriteria(
							"modifiedDate");
					Criterion statusDateCriterion = portletDataContext.getDateRangeCriteria(
							"statusDate");

					if ((modifiedDateCriterion != null) &&
							(statusDateCriterion != null)) {
						Disjunction disjunction = RestrictionsFactoryUtil.disjunction();

						disjunction.add(modifiedDateCriterion);
						disjunction.add(statusDateCriterion);

						dynamicQuery.add(disjunction);
					}

					Property workflowStatusProperty = PropertyFactoryUtil.forName(
							"status");

					if (portletDataContext.isInitialPublication()) {
						dynamicQuery.add(workflowStatusProperty.ne(
								WorkflowConstants.STATUS_IN_TRASH));
					}
					else {
						StagedModelDataHandler<?> stagedModelDataHandler = StagedModelDataHandlerRegistryUtil.getStagedModelDataHandler(Announcement.class.getName());

						dynamicQuery.add(workflowStatusProperty.in(
								stagedModelDataHandler.getExportableStatuses()));
					}
				}
			});

		exportActionableDynamicQuery.setCompanyId(portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Announcement>() {
				@Override
				public void performAction(Announcement announcement)
					throws PortalException {
					StagedModelDataHandlerUtil.exportStagedModel(portletDataContext,
						announcement);
				}
			});
		exportActionableDynamicQuery.setStagedModelType(new StagedModelType(
				PortalUtil.getClassNameId(Announcement.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return announcementLocalService.deleteAnnouncement((Announcement)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return announcementPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the announcements matching the UUID and company.
	 *
	 * @param uuid the UUID of the announcements
	 * @param companyId the primary key of the company
	 * @return the matching announcements, or an empty list if no matches were found
	 */
	@Override
	public List<Announcement> getAnnouncementsByUuidAndCompanyId(String uuid,
		long companyId) {
		return announcementPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of announcements matching the UUID and company.
	 *
	 * @param uuid the UUID of the announcements
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of announcements
	 * @param end the upper bound of the range of announcements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching announcements, or an empty list if no matches were found
	 */
	@Override
	public List<Announcement> getAnnouncementsByUuidAndCompanyId(String uuid,
		long companyId, int start, int end,
		OrderByComparator<Announcement> orderByComparator) {
		return announcementPersistence.findByUuid_C(uuid, companyId, start,
			end, orderByComparator);
	}

	/**
	 * Returns the announcement matching the UUID and group.
	 *
	 * @param uuid the announcement's UUID
	 * @param groupId the primary key of the group
	 * @return the matching announcement
	 * @throws PortalException if a matching announcement could not be found
	 */
	@Override
	public Announcement getAnnouncementByUuidAndGroupId(String uuid,
		long groupId) throws PortalException {
		return announcementPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the announcements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gleo.modules.ravenbox.model.impl.AnnouncementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of announcements
	 * @param end the upper bound of the range of announcements (not inclusive)
	 * @return the range of announcements
	 */
	@Override
	public List<Announcement> getAnnouncements(int start, int end) {
		return announcementPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of announcements.
	 *
	 * @return the number of announcements
	 */
	@Override
	public int getAnnouncementsCount() {
		return announcementPersistence.countAll();
	}

	/**
	 * Updates the announcement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param announcement the announcement
	 * @return the announcement that was updated
	 * @throws SystemException
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Announcement updateAnnouncement(Announcement announcement)
		throws SystemException {
		return announcementPersistence.update(announcement);
	}

	/**
	 * Returns the announcement local service.
	 *
	 * @return the announcement local service
	 */
	public AnnouncementLocalService getAnnouncementLocalService() {
		return announcementLocalService;
	}

	/**
	 * Sets the announcement local service.
	 *
	 * @param announcementLocalService the announcement local service
	 */
	public void setAnnouncementLocalService(
		AnnouncementLocalService announcementLocalService) {
		this.announcementLocalService = announcementLocalService;
	}

	/**
	 * Returns the announcement persistence.
	 *
	 * @return the announcement persistence
	 */
	public AnnouncementPersistence getAnnouncementPersistence() {
		return announcementPersistence;
	}

	/**
	 * Sets the announcement persistence.
	 *
	 * @param announcementPersistence the announcement persistence
	 */
	public void setAnnouncementPersistence(
		AnnouncementPersistence announcementPersistence) {
		this.announcementPersistence = announcementPersistence;
	}

	/**
	 * Returns the announcement image local service.
	 *
	 * @return the announcement image local service
	 */
	public com.gleo.modules.ravenbox.service.AnnouncementImageLocalService getAnnouncementImageLocalService() {
		return announcementImageLocalService;
	}

	/**
	 * Sets the announcement image local service.
	 *
	 * @param announcementImageLocalService the announcement image local service
	 */
	public void setAnnouncementImageLocalService(
		com.gleo.modules.ravenbox.service.AnnouncementImageLocalService announcementImageLocalService) {
		this.announcementImageLocalService = announcementImageLocalService;
	}

	/**
	 * Returns the announcement image persistence.
	 *
	 * @return the announcement image persistence
	 */
	public AnnouncementImagePersistence getAnnouncementImagePersistence() {
		return announcementImagePersistence;
	}

	/**
	 * Sets the announcement image persistence.
	 *
	 * @param announcementImagePersistence the announcement image persistence
	 */
	public void setAnnouncementImagePersistence(
		AnnouncementImagePersistence announcementImagePersistence) {
		this.announcementImagePersistence = announcementImagePersistence;
	}

	/**
	 * Returns the currency local service.
	 *
	 * @return the currency local service
	 */
	public com.gleo.modules.ravenbox.service.CurrencyLocalService getCurrencyLocalService() {
		return currencyLocalService;
	}

	/**
	 * Sets the currency local service.
	 *
	 * @param currencyLocalService the currency local service
	 */
	public void setCurrencyLocalService(
		com.gleo.modules.ravenbox.service.CurrencyLocalService currencyLocalService) {
		this.currencyLocalService = currencyLocalService;
	}

	/**
	 * Returns the currency persistence.
	 *
	 * @return the currency persistence
	 */
	public CurrencyPersistence getCurrencyPersistence() {
		return currencyPersistence;
	}

	/**
	 * Sets the currency persistence.
	 *
	 * @param currencyPersistence the currency persistence
	 */
	public void setCurrencyPersistence(CurrencyPersistence currencyPersistence) {
		this.currencyPersistence = currencyPersistence;
	}

	/**
	 * Returns the favorite local service.
	 *
	 * @return the favorite local service
	 */
	public com.gleo.modules.ravenbox.service.FavoriteLocalService getFavoriteLocalService() {
		return favoriteLocalService;
	}

	/**
	 * Sets the favorite local service.
	 *
	 * @param favoriteLocalService the favorite local service
	 */
	public void setFavoriteLocalService(
		com.gleo.modules.ravenbox.service.FavoriteLocalService favoriteLocalService) {
		this.favoriteLocalService = favoriteLocalService;
	}

	/**
	 * Returns the favorite persistence.
	 *
	 * @return the favorite persistence
	 */
	public FavoritePersistence getFavoritePersistence() {
		return favoritePersistence;
	}

	/**
	 * Sets the favorite persistence.
	 *
	 * @param favoritePersistence the favorite persistence
	 */
	public void setFavoritePersistence(FavoritePersistence favoritePersistence) {
		this.favoritePersistence = favoritePersistence;
	}

	/**
	 * Returns the type local service.
	 *
	 * @return the type local service
	 */
	public com.gleo.modules.ravenbox.service.TypeLocalService getTypeLocalService() {
		return typeLocalService;
	}

	/**
	 * Sets the type local service.
	 *
	 * @param typeLocalService the type local service
	 */
	public void setTypeLocalService(
		com.gleo.modules.ravenbox.service.TypeLocalService typeLocalService) {
		this.typeLocalService = typeLocalService;
	}

	/**
	 * Returns the type persistence.
	 *
	 * @return the type persistence
	 */
	public TypePersistence getTypePersistence() {
		return typePersistence;
	}

	/**
	 * Sets the type persistence.
	 *
	 * @param typePersistence the type persistence
	 */
	public void setTypePersistence(TypePersistence typePersistence) {
		this.typePersistence = typePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Returns the asset entry local service.
	 *
	 * @return the asset entry local service
	 */
	public com.liferay.asset.kernel.service.AssetEntryLocalService getAssetEntryLocalService() {
		return assetEntryLocalService;
	}

	/**
	 * Sets the asset entry local service.
	 *
	 * @param assetEntryLocalService the asset entry local service
	 */
	public void setAssetEntryLocalService(
		com.liferay.asset.kernel.service.AssetEntryLocalService assetEntryLocalService) {
		this.assetEntryLocalService = assetEntryLocalService;
	}

	/**
	 * Returns the asset entry persistence.
	 *
	 * @return the asset entry persistence
	 */
	public AssetEntryPersistence getAssetEntryPersistence() {
		return assetEntryPersistence;
	}

	/**
	 * Sets the asset entry persistence.
	 *
	 * @param assetEntryPersistence the asset entry persistence
	 */
	public void setAssetEntryPersistence(
		AssetEntryPersistence assetEntryPersistence) {
		this.assetEntryPersistence = assetEntryPersistence;
	}

	/**
	 * Returns the asset link local service.
	 *
	 * @return the asset link local service
	 */
	public com.liferay.asset.kernel.service.AssetLinkLocalService getAssetLinkLocalService() {
		return assetLinkLocalService;
	}

	/**
	 * Sets the asset link local service.
	 *
	 * @param assetLinkLocalService the asset link local service
	 */
	public void setAssetLinkLocalService(
		com.liferay.asset.kernel.service.AssetLinkLocalService assetLinkLocalService) {
		this.assetLinkLocalService = assetLinkLocalService;
	}

	/**
	 * Returns the asset link persistence.
	 *
	 * @return the asset link persistence
	 */
	public AssetLinkPersistence getAssetLinkPersistence() {
		return assetLinkPersistence;
	}

	/**
	 * Sets the asset link persistence.
	 *
	 * @param assetLinkPersistence the asset link persistence
	 */
	public void setAssetLinkPersistence(
		AssetLinkPersistence assetLinkPersistence) {
		this.assetLinkPersistence = assetLinkPersistence;
	}

	/**
	 * Returns the message-boards message local service.
	 *
	 * @return the message-boards message local service
	 */
	public com.liferay.message.boards.kernel.service.MBMessageLocalService getMBMessageLocalService() {
		return mbMessageLocalService;
	}

	/**
	 * Sets the message-boards message local service.
	 *
	 * @param mbMessageLocalService the message-boards message local service
	 */
	public void setMBMessageLocalService(
		com.liferay.message.boards.kernel.service.MBMessageLocalService mbMessageLocalService) {
		this.mbMessageLocalService = mbMessageLocalService;
	}

	/**
	 * Returns the message-boards message persistence.
	 *
	 * @return the message-boards message persistence
	 */
	public MBMessagePersistence getMBMessagePersistence() {
		return mbMessagePersistence;
	}

	/**
	 * Sets the message-boards message persistence.
	 *
	 * @param mbMessagePersistence the message-boards message persistence
	 */
	public void setMBMessagePersistence(
		MBMessagePersistence mbMessagePersistence) {
		this.mbMessagePersistence = mbMessagePersistence;
	}

	/**
	 * Returns the social activity local service.
	 *
	 * @return the social activity local service
	 */
	public com.liferay.social.kernel.service.SocialActivityLocalService getSocialActivityLocalService() {
		return socialActivityLocalService;
	}

	/**
	 * Sets the social activity local service.
	 *
	 * @param socialActivityLocalService the social activity local service
	 */
	public void setSocialActivityLocalService(
		com.liferay.social.kernel.service.SocialActivityLocalService socialActivityLocalService) {
		this.socialActivityLocalService = socialActivityLocalService;
	}

	/**
	 * Returns the social activity persistence.
	 *
	 * @return the social activity persistence
	 */
	public SocialActivityPersistence getSocialActivityPersistence() {
		return socialActivityPersistence;
	}

	/**
	 * Sets the social activity persistence.
	 *
	 * @param socialActivityPersistence the social activity persistence
	 */
	public void setSocialActivityPersistence(
		SocialActivityPersistence socialActivityPersistence) {
		this.socialActivityPersistence = socialActivityPersistence;
	}

	/**
	 * Returns the trash version local service.
	 *
	 * @return the trash version local service
	 */
	public com.liferay.trash.kernel.service.TrashVersionLocalService getTrashVersionLocalService() {
		return trashVersionLocalService;
	}

	/**
	 * Sets the trash version local service.
	 *
	 * @param trashVersionLocalService the trash version local service
	 */
	public void setTrashVersionLocalService(
		com.liferay.trash.kernel.service.TrashVersionLocalService trashVersionLocalService) {
		this.trashVersionLocalService = trashVersionLocalService;
	}

	/**
	 * Returns the trash version persistence.
	 *
	 * @return the trash version persistence
	 */
	public TrashVersionPersistence getTrashVersionPersistence() {
		return trashVersionPersistence;
	}

	/**
	 * Sets the trash version persistence.
	 *
	 * @param trashVersionPersistence the trash version persistence
	 */
	public void setTrashVersionPersistence(
		TrashVersionPersistence trashVersionPersistence) {
		this.trashVersionPersistence = trashVersionPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.gleo.modules.ravenbox.model.Announcement",
			announcementLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.gleo.modules.ravenbox.model.Announcement");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return AnnouncementLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Announcement.class;
	}

	protected String getModelClassName() {
		return Announcement.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = announcementPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = AnnouncementLocalService.class)
	protected AnnouncementLocalService announcementLocalService;
	@BeanReference(type = AnnouncementPersistence.class)
	protected AnnouncementPersistence announcementPersistence;
	@BeanReference(type = com.gleo.modules.ravenbox.service.AnnouncementImageLocalService.class)
	protected com.gleo.modules.ravenbox.service.AnnouncementImageLocalService announcementImageLocalService;
	@BeanReference(type = AnnouncementImagePersistence.class)
	protected AnnouncementImagePersistence announcementImagePersistence;
	@BeanReference(type = com.gleo.modules.ravenbox.service.CurrencyLocalService.class)
	protected com.gleo.modules.ravenbox.service.CurrencyLocalService currencyLocalService;
	@BeanReference(type = CurrencyPersistence.class)
	protected CurrencyPersistence currencyPersistence;
	@BeanReference(type = com.gleo.modules.ravenbox.service.FavoriteLocalService.class)
	protected com.gleo.modules.ravenbox.service.FavoriteLocalService favoriteLocalService;
	@BeanReference(type = FavoritePersistence.class)
	protected FavoritePersistence favoritePersistence;
	@BeanReference(type = com.gleo.modules.ravenbox.service.TypeLocalService.class)
	protected com.gleo.modules.ravenbox.service.TypeLocalService typeLocalService;
	@BeanReference(type = TypePersistence.class)
	protected TypePersistence typePersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = com.liferay.asset.kernel.service.AssetEntryLocalService.class)
	protected com.liferay.asset.kernel.service.AssetEntryLocalService assetEntryLocalService;
	@ServiceReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	@ServiceReference(type = com.liferay.asset.kernel.service.AssetLinkLocalService.class)
	protected com.liferay.asset.kernel.service.AssetLinkLocalService assetLinkLocalService;
	@ServiceReference(type = AssetLinkPersistence.class)
	protected AssetLinkPersistence assetLinkPersistence;
	@ServiceReference(type = com.liferay.message.boards.kernel.service.MBMessageLocalService.class)
	protected com.liferay.message.boards.kernel.service.MBMessageLocalService mbMessageLocalService;
	@ServiceReference(type = MBMessagePersistence.class)
	protected MBMessagePersistence mbMessagePersistence;
	@ServiceReference(type = com.liferay.social.kernel.service.SocialActivityLocalService.class)
	protected com.liferay.social.kernel.service.SocialActivityLocalService socialActivityLocalService;
	@ServiceReference(type = SocialActivityPersistence.class)
	protected SocialActivityPersistence socialActivityPersistence;
	@ServiceReference(type = com.liferay.trash.kernel.service.TrashVersionLocalService.class)
	protected com.liferay.trash.kernel.service.TrashVersionLocalService trashVersionLocalService;
	@ServiceReference(type = TrashVersionPersistence.class)
	protected TrashVersionPersistence trashVersionPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}