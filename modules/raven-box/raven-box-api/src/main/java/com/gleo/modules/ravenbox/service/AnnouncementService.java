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

package com.gleo.modules.ravenbox.service;

import aQute.bnd.annotation.ProviderType;

import com.gleo.modules.ravenbox.model.Announcement;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

/**
 * Provides the remote service interface for Announcement. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Guillaume Lenoir
 * @see AnnouncementServiceUtil
 * @see com.gleo.modules.ravenbox.service.base.AnnouncementServiceBaseImpl
 * @see com.gleo.modules.ravenbox.service.impl.AnnouncementServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(property =  {
	"json.web.service.context.name=ravenbox", "json.web.service.context.path=Announcement"}, service = AnnouncementService.class)
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface AnnouncementService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnnouncementServiceUtil} to access the announcement remote service. Add custom service methods to {@link com.gleo.modules.ravenbox.service.impl.AnnouncementServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public Announcement addAnnouncement(Announcement announcement,
		ServiceContext serviceContext)
		throws PortalException, SystemException, PrincipalException;

	public Announcement deleteAnnouncement(long announcementId)
		throws PortalException, SystemException, PrincipalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Announcement getAnnouncement(long announcementId)
		throws PortalException, SystemException;

	public Announcement updateAnnouncement(Announcement announcement,
		ServiceContext serviceContext)
		throws PortalException, SystemException, PrincipalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAnnouncementsCountByGroupId(long groupId)
		throws SystemException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Announcement> getAnnouncementsByGroupId(long groupId,
		int start, int end) throws SystemException;
}