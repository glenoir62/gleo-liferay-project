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

package com.gleo.plugins.hexiagon.service.base;

import aQute.bnd.annotation.ProviderType;

import com.gleo.plugins.hexiagon.model.Currency;
import com.gleo.plugins.hexiagon.service.CurrencyLocalService;
import com.gleo.plugins.hexiagon.service.persistence.AnnouncementImagePersistence;
import com.gleo.plugins.hexiagon.service.persistence.AnnouncementPersistence;
import com.gleo.plugins.hexiagon.service.persistence.CurrencyPersistence;
import com.gleo.plugins.hexiagon.service.persistence.FavoritePersistence;
import com.gleo.plugins.hexiagon.service.persistence.TypePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.CountryPersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the currency local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.gleo.plugins.hexiagon.service.impl.CurrencyLocalServiceImpl}.
 * </p>
 *
 * @author guillaumelenoir
 * @see com.gleo.plugins.hexiagon.service.impl.CurrencyLocalServiceImpl
 * @see com.gleo.plugins.hexiagon.service.CurrencyLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class CurrencyLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements CurrencyLocalService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.gleo.plugins.hexiagon.service.CurrencyLocalServiceUtil} to access the currency local service.
	 */

	/**
	 * Adds the currency to the database. Also notifies the appropriate model listeners.
	 *
	 * @param currency the currency
	 * @return the currency that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Currency addCurrency(Currency currency) {
		currency.setNew(true);

		return currencyPersistence.update(currency);
	}

	/**
	 * Creates a new currency with the primary key. Does not add the currency to the database.
	 *
	 * @param currencyId the primary key for the new currency
	 * @return the new currency
	 */
	@Override
	public Currency createCurrency(long currencyId) {
		return currencyPersistence.create(currencyId);
	}

	/**
	 * Deletes the currency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param currencyId the primary key of the currency
	 * @return the currency that was removed
	 * @throws PortalException if a currency with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Currency deleteCurrency(long currencyId) throws PortalException {
		return currencyPersistence.remove(currencyId);
	}

	/**
	 * Deletes the currency from the database. Also notifies the appropriate model listeners.
	 *
	 * @param currency the currency
	 * @return the currency that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Currency deleteCurrency(Currency currency) {
		return currencyPersistence.remove(currency);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Currency.class,
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
		return currencyPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gleo.plugins.hexiagon.model.impl.CurrencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return currencyPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gleo.plugins.hexiagon.model.impl.CurrencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return currencyPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return currencyPersistence.countWithDynamicQuery(dynamicQuery);
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
		return currencyPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public Currency fetchCurrency(long currencyId) {
		return currencyPersistence.fetchByPrimaryKey(currencyId);
	}

	/**
	 * Returns the currency with the primary key.
	 *
	 * @param currencyId the primary key of the currency
	 * @return the currency
	 * @throws PortalException if a currency with the primary key could not be found
	 */
	@Override
	public Currency getCurrency(long currencyId) throws PortalException {
		return currencyPersistence.findByPrimaryKey(currencyId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(currencyLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Currency.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("currencyId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(currencyLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Currency.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("currencyId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(currencyLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Currency.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("currencyId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return currencyLocalService.deleteCurrency((Currency)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return currencyPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the currencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.gleo.plugins.hexiagon.model.impl.CurrencyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of currencies
	 * @param end the upper bound of the range of currencies (not inclusive)
	 * @return the range of currencies
	 */
	@Override
	public List<Currency> getCurrencies(int start, int end) {
		return currencyPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of currencies.
	 *
	 * @return the number of currencies
	 */
	@Override
	public int getCurrenciesCount() {
		return currencyPersistence.countAll();
	}

	/**
	 * Updates the currency in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param currency the currency
	 * @return the currency that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Currency updateCurrency(Currency currency) {
		return currencyPersistence.update(currency);
	}

	/**
	 * Returns the announcement local service.
	 *
	 * @return the announcement local service
	 */
	public com.gleo.plugins.hexiagon.service.AnnouncementLocalService getAnnouncementLocalService() {
		return announcementLocalService;
	}

	/**
	 * Sets the announcement local service.
	 *
	 * @param announcementLocalService the announcement local service
	 */
	public void setAnnouncementLocalService(
		com.gleo.plugins.hexiagon.service.AnnouncementLocalService announcementLocalService) {
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
	public com.gleo.plugins.hexiagon.service.AnnouncementImageLocalService getAnnouncementImageLocalService() {
		return announcementImageLocalService;
	}

	/**
	 * Sets the announcement image local service.
	 *
	 * @param announcementImageLocalService the announcement image local service
	 */
	public void setAnnouncementImageLocalService(
		com.gleo.plugins.hexiagon.service.AnnouncementImageLocalService announcementImageLocalService) {
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
	public CurrencyLocalService getCurrencyLocalService() {
		return currencyLocalService;
	}

	/**
	 * Sets the currency local service.
	 *
	 * @param currencyLocalService the currency local service
	 */
	public void setCurrencyLocalService(
		CurrencyLocalService currencyLocalService) {
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
	public com.gleo.plugins.hexiagon.service.FavoriteLocalService getFavoriteLocalService() {
		return favoriteLocalService;
	}

	/**
	 * Sets the favorite local service.
	 *
	 * @param favoriteLocalService the favorite local service
	 */
	public void setFavoriteLocalService(
		com.gleo.plugins.hexiagon.service.FavoriteLocalService favoriteLocalService) {
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
	public com.gleo.plugins.hexiagon.service.TypeLocalService getTypeLocalService() {
		return typeLocalService;
	}

	/**
	 * Sets the type local service.
	 *
	 * @param typeLocalService the type local service
	 */
	public void setTypeLocalService(
		com.gleo.plugins.hexiagon.service.TypeLocalService typeLocalService) {
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
	 * Returns the country persistence.
	 *
	 * @return the country persistence
	 */
	public CountryPersistence getCountryPersistence() {
		return countryPersistence;
	}

	/**
	 * Sets the country persistence.
	 *
	 * @param countryPersistence the country persistence
	 */
	public void setCountryPersistence(CountryPersistence countryPersistence) {
		this.countryPersistence = countryPersistence;
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

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.gleo.plugins.hexiagon.model.Currency",
			currencyLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.gleo.plugins.hexiagon.model.Currency");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CurrencyLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Currency.class;
	}

	protected String getModelClassName() {
		return Currency.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = currencyPersistence.getDataSource();

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

	@BeanReference(type = com.gleo.plugins.hexiagon.service.AnnouncementLocalService.class)
	protected com.gleo.plugins.hexiagon.service.AnnouncementLocalService announcementLocalService;
	@BeanReference(type = AnnouncementPersistence.class)
	protected AnnouncementPersistence announcementPersistence;
	@BeanReference(type = com.gleo.plugins.hexiagon.service.AnnouncementImageLocalService.class)
	protected com.gleo.plugins.hexiagon.service.AnnouncementImageLocalService announcementImageLocalService;
	@BeanReference(type = AnnouncementImagePersistence.class)
	protected AnnouncementImagePersistence announcementImagePersistence;
	@BeanReference(type = CurrencyLocalService.class)
	protected CurrencyLocalService currencyLocalService;
	@BeanReference(type = CurrencyPersistence.class)
	protected CurrencyPersistence currencyPersistence;
	@BeanReference(type = com.gleo.plugins.hexiagon.service.FavoriteLocalService.class)
	protected com.gleo.plugins.hexiagon.service.FavoriteLocalService favoriteLocalService;
	@BeanReference(type = FavoritePersistence.class)
	protected FavoritePersistence favoritePersistence;
	@BeanReference(type = com.gleo.plugins.hexiagon.service.TypeLocalService.class)
	protected com.gleo.plugins.hexiagon.service.TypeLocalService typeLocalService;
	@BeanReference(type = TypePersistence.class)
	protected TypePersistence typePersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = CountryPersistence.class)
	protected CountryPersistence countryPersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}