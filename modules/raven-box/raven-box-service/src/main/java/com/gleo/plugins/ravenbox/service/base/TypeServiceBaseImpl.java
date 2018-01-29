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

package com.gleo.plugins.ravenbox.service.base;

import com.gleo.plugins.ravenbox.model.Type;
import com.gleo.plugins.ravenbox.service.TypeService;
import com.gleo.plugins.ravenbox.service.persistence.AnnouncementImagePersistence;
import com.gleo.plugins.ravenbox.service.persistence.AnnouncementPersistence;
import com.gleo.plugins.ravenbox.service.persistence.CurrencyPersistence;
import com.gleo.plugins.ravenbox.service.persistence.FavoritePersistence;
import com.gleo.plugins.ravenbox.service.persistence.TypePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the type remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.gleo.plugins.ravenbox.service.impl.TypeServiceImpl}.
 * </p>
 *
 * @author Guillaume Lenoir
 * @see com.gleo.plugins.ravenbox.service.impl.TypeServiceImpl
 * @see com.gleo.plugins.ravenbox.service.TypeServiceUtil
 * @generated
 */
public abstract class TypeServiceBaseImpl extends BaseServiceImpl
	implements TypeService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.gleo.plugins.ravenbox.service.TypeServiceUtil} to access the type remote service.
	 */

	/**
	 * Returns the announcement local service.
	 *
	 * @return the announcement local service
	 */
	public com.gleo.plugins.ravenbox.service.AnnouncementLocalService getAnnouncementLocalService() {
		return announcementLocalService;
	}

	/**
	 * Sets the announcement local service.
	 *
	 * @param announcementLocalService the announcement local service
	 */
	public void setAnnouncementLocalService(
		com.gleo.plugins.ravenbox.service.AnnouncementLocalService announcementLocalService) {
		this.announcementLocalService = announcementLocalService;
	}

	/**
	 * Returns the announcement remote service.
	 *
	 * @return the announcement remote service
	 */
	public com.gleo.plugins.ravenbox.service.AnnouncementService getAnnouncementService() {
		return announcementService;
	}

	/**
	 * Sets the announcement remote service.
	 *
	 * @param announcementService the announcement remote service
	 */
	public void setAnnouncementService(
		com.gleo.plugins.ravenbox.service.AnnouncementService announcementService) {
		this.announcementService = announcementService;
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
	public com.gleo.plugins.ravenbox.service.AnnouncementImageLocalService getAnnouncementImageLocalService() {
		return announcementImageLocalService;
	}

	/**
	 * Sets the announcement image local service.
	 *
	 * @param announcementImageLocalService the announcement image local service
	 */
	public void setAnnouncementImageLocalService(
		com.gleo.plugins.ravenbox.service.AnnouncementImageLocalService announcementImageLocalService) {
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
	public com.gleo.plugins.ravenbox.service.CurrencyLocalService getCurrencyLocalService() {
		return currencyLocalService;
	}

	/**
	 * Sets the currency local service.
	 *
	 * @param currencyLocalService the currency local service
	 */
	public void setCurrencyLocalService(
		com.gleo.plugins.ravenbox.service.CurrencyLocalService currencyLocalService) {
		this.currencyLocalService = currencyLocalService;
	}

	/**
	 * Returns the currency remote service.
	 *
	 * @return the currency remote service
	 */
	public com.gleo.plugins.ravenbox.service.CurrencyService getCurrencyService() {
		return currencyService;
	}

	/**
	 * Sets the currency remote service.
	 *
	 * @param currencyService the currency remote service
	 */
	public void setCurrencyService(
		com.gleo.plugins.ravenbox.service.CurrencyService currencyService) {
		this.currencyService = currencyService;
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
	public com.gleo.plugins.ravenbox.service.FavoriteLocalService getFavoriteLocalService() {
		return favoriteLocalService;
	}

	/**
	 * Sets the favorite local service.
	 *
	 * @param favoriteLocalService the favorite local service
	 */
	public void setFavoriteLocalService(
		com.gleo.plugins.ravenbox.service.FavoriteLocalService favoriteLocalService) {
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
	public com.gleo.plugins.ravenbox.service.TypeLocalService getTypeLocalService() {
		return typeLocalService;
	}

	/**
	 * Sets the type local service.
	 *
	 * @param typeLocalService the type local service
	 */
	public void setTypeLocalService(
		com.gleo.plugins.ravenbox.service.TypeLocalService typeLocalService) {
		this.typeLocalService = typeLocalService;
	}

	/**
	 * Returns the type remote service.
	 *
	 * @return the type remote service
	 */
	public TypeService getTypeService() {
		return typeService;
	}

	/**
	 * Sets the type remote service.
	 *
	 * @param typeService the type remote service
	 */
	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
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
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService getClassNameService() {
		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {
		this.classNameService = classNameService;
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
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {
		this.userService = userService;
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
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return TypeService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Type.class;
	}

	protected String getModelClassName() {
		return Type.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = typePersistence.getDataSource();

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

	@BeanReference(type = com.gleo.plugins.ravenbox.service.AnnouncementLocalService.class)
	protected com.gleo.plugins.ravenbox.service.AnnouncementLocalService announcementLocalService;
	@BeanReference(type = com.gleo.plugins.ravenbox.service.AnnouncementService.class)
	protected com.gleo.plugins.ravenbox.service.AnnouncementService announcementService;
	@BeanReference(type = AnnouncementPersistence.class)
	protected AnnouncementPersistence announcementPersistence;
	@BeanReference(type = com.gleo.plugins.ravenbox.service.AnnouncementImageLocalService.class)
	protected com.gleo.plugins.ravenbox.service.AnnouncementImageLocalService announcementImageLocalService;
	@BeanReference(type = AnnouncementImagePersistence.class)
	protected AnnouncementImagePersistence announcementImagePersistence;
	@BeanReference(type = com.gleo.plugins.ravenbox.service.CurrencyLocalService.class)
	protected com.gleo.plugins.ravenbox.service.CurrencyLocalService currencyLocalService;
	@BeanReference(type = com.gleo.plugins.ravenbox.service.CurrencyService.class)
	protected com.gleo.plugins.ravenbox.service.CurrencyService currencyService;
	@BeanReference(type = CurrencyPersistence.class)
	protected CurrencyPersistence currencyPersistence;
	@BeanReference(type = com.gleo.plugins.ravenbox.service.FavoriteLocalService.class)
	protected com.gleo.plugins.ravenbox.service.FavoriteLocalService favoriteLocalService;
	@BeanReference(type = FavoritePersistence.class)
	protected FavoritePersistence favoritePersistence;
	@BeanReference(type = com.gleo.plugins.ravenbox.service.TypeLocalService.class)
	protected com.gleo.plugins.ravenbox.service.TypeLocalService typeLocalService;
	@BeanReference(type = TypeService.class)
	protected TypeService typeService;
	@BeanReference(type = TypePersistence.class)
	protected TypePersistence typePersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameService.class)
	protected com.liferay.portal.kernel.service.ClassNameService classNameService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
}