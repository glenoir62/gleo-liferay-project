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

package com.gleo.plugins.hexiagon.service.http;

import aQute.bnd.annotation.ProviderType;

import com.gleo.plugins.hexiagon.service.ExtRegionServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link ExtRegionServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author guillaumelenoir
 * @see ExtRegionServiceSoap
 * @see HttpPrincipal
 * @see ExtRegionServiceUtil
 * @generated
 */
@ProviderType
public class ExtRegionServiceHttp {
	public static com.liferay.portal.kernel.model.Region setActive(
		HttpPrincipal httpPrincipal, long regionId, boolean active)
		throws com.liferay.portal.kernel.exception.NoSuchRegionException,
			com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		try {
			MethodKey methodKey = new MethodKey(ExtRegionServiceUtil.class,
					"setActive", _setActiveParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					regionId, active);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.NoSuchRegionException) {
					throw (com.liferay.portal.kernel.exception.NoSuchRegionException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				if (e instanceof com.liferay.portal.kernel.security.auth.PrincipalException) {
					throw (com.liferay.portal.kernel.security.auth.PrincipalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.kernel.model.Region)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.kernel.model.Region updateRegion(
		HttpPrincipal httpPrincipal, long regionId, boolean isActive,
		java.lang.String name, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		try {
			MethodKey methodKey = new MethodKey(ExtRegionServiceUtil.class,
					"updateRegion", _updateRegionParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					regionId, isActive, name, regionCode);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.kernel.model.Region)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getRegionsCount(HttpPrincipal httpPrincipal,
		long countryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		try {
			MethodKey methodKey = new MethodKey(ExtRegionServiceUtil.class,
					"getRegionsCount", _getRegionsCountParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, countryId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				if (e instanceof com.liferay.portal.kernel.security.auth.PrincipalException) {
					throw (com.liferay.portal.kernel.security.auth.PrincipalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.portal.kernel.model.Region> getRegions(
		HttpPrincipal httpPrincipal, long countryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		try {
			MethodKey methodKey = new MethodKey(ExtRegionServiceUtil.class,
					"getRegions", _getRegionsParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					countryId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				if (e instanceof com.liferay.portal.kernel.security.auth.PrincipalException) {
					throw (com.liferay.portal.kernel.security.auth.PrincipalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.portal.kernel.model.Region>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.portal.kernel.model.Region> getRegions(
		HttpPrincipal httpPrincipal, long countryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.security.auth.PrincipalException {
		try {
			MethodKey methodKey = new MethodKey(ExtRegionServiceUtil.class,
					"getRegions", _getRegionsParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					countryId, start, end, orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.SystemException) {
					throw (com.liferay.portal.kernel.exception.SystemException)e;
				}

				if (e instanceof com.liferay.portal.kernel.security.auth.PrincipalException) {
					throw (com.liferay.portal.kernel.security.auth.PrincipalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.portal.kernel.model.Region>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ExtRegionServiceHttp.class);
	private static final Class<?>[] _setActiveParameterTypes0 = new Class[] {
			long.class, boolean.class
		};
	private static final Class<?>[] _updateRegionParameterTypes1 = new Class[] {
			long.class, boolean.class, java.lang.String.class,
			java.lang.String.class
		};
	private static final Class<?>[] _getRegionsCountParameterTypes2 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getRegionsParameterTypes3 = new Class[] {
			long.class, int.class, int.class
		};
	private static final Class<?>[] _getRegionsParameterTypes4 = new Class[] {
			long.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
}