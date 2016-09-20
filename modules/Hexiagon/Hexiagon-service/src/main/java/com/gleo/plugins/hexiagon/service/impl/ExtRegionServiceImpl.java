package com.gleo.plugins.hexiagon.service.impl;

import java.util.List;

import com.gleo.plugins.hexiagon.service.base.ExtRegionServiceBaseImpl;
import com.liferay.portal.kernel.exception.NoSuchRegionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.RegionCodeException;
import com.liferay.portal.kernel.exception.RegionNameException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the ext region remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.gleo.plugins.hexiagon.service.ExtRegionService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author guillaumelenoir
 * @see com.gleo.plugins.hexiagon.service.base.ExtRegionServiceBaseImpl
 * @see com.gleo.plugins.hexiagon.service.ExtRegionServiceUtil
 */
public class ExtRegionServiceImpl extends ExtRegionServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.gleo.plugins.hexiagon.service.ExtRegionServiceUtil} to access the ext region remote service.
     */
	
	public Region setActive(long regionId, boolean active) throws SystemException, PrincipalException, NoSuchRegionException {
		if (!getPermissionChecker().isOmniadmin()) {
			throw new PrincipalException();
		}
		
		Region region = regionPersistence.findByPrimaryKey(regionId);
		region.setActive(active);
		return regionPersistence.update(region);
	}
	
	public Region updateRegion(long regionId, boolean isActive, String name, String regionCode) throws PortalException, SystemException {

		if (!getPermissionChecker().isOmniadmin()) {
			throw new PrincipalException();
		}
		
		if (Validator.isNull(regionCode)) {
			throw new RegionCodeException();
		}

		if (Validator.isNull(name)) {
			throw new RegionNameException();
		}
		
		Region region = regionPersistence.findByPrimaryKey(regionId);
		
		countryPersistence.findByPrimaryKey(region.getCountryId());
		
		region.setName(name);
		region.setRegionCode(regionCode);
		region.setActive(isActive);
		
		regionPersistence.update(region);
		
		return region;
	}
	
	public int getRegionsCount(long countryId) throws SystemException, PrincipalException {
		if (!getPermissionChecker().isOmniadmin()) {
			throw new PrincipalException();
		}
		return regionPersistence.countByCountryId(countryId);
	}
	
	public List<Region> getRegions(long countryId, int start, int end) throws SystemException, PrincipalException {
		if (!getPermissionChecker().isOmniadmin()) {
			throw new PrincipalException();
		}
		return regionPersistence.findByCountryId(countryId, start, end);
	}
	
	public List<Region> getRegions(long countryId, int start, int end, OrderByComparator orderByComparator) throws SystemException, PrincipalException {
		if (!getPermissionChecker().isOmniadmin()) {
			throw new PrincipalException();
		}
		return regionPersistence.findByCountryId(countryId, start, end, orderByComparator);
	}
}
