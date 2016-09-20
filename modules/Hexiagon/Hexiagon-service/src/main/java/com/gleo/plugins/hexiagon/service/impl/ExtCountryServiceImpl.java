package com.gleo.plugins.hexiagon.service.impl;

import java.util.List;

import com.gleo.plugins.hexiagon.service.base.ExtCountryServiceBaseImpl;
import com.liferay.portal.kernel.exception.CountryA2Exception;
import com.liferay.portal.kernel.exception.CountryA3Exception;
import com.liferay.portal.kernel.exception.CountryIddException;
import com.liferay.portal.kernel.exception.CountryNameException;
import com.liferay.portal.kernel.exception.CountryNumberException;
import com.liferay.portal.kernel.exception.NoSuchCountryException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the ext country remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.gleo.plugins.hexiagon.service.ExtCountryService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author guillaumelenoir
 * @see com.gleo.plugins.hexiagon.service.base.ExtCountryServiceBaseImpl
 * @see com.gleo.plugins.hexiagon.service.ExtCountryServiceUtil
 */
public class ExtCountryServiceImpl extends ExtCountryServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.gleo.plugins.hexiagon.service.ExtCountryServiceUtil} to access the ext country remote service.
     */
	
	public Country setActive(long countryId, boolean active) throws SystemException, PrincipalException, NoSuchCountryException {
		if (!getPermissionChecker().isOmniadmin()) {
			throw new PrincipalException();
		}
		
		Country country = countryPersistence.findByPrimaryKey(countryId);
		country.setActive(active);
		return countryPersistence.update(country);
	}
	
	public Country addCountry(boolean isActive,boolean isZipRequired, String name, String a2, String a3,
			String number, String idd) throws PortalException, SystemException {
		if (!getPermissionChecker().isOmniadmin()) {
			throw new PrincipalException();
		}
		if (Validator.isNull(name)) {
			throw new CountryNameException();
		}

		if (Validator.isNull(a2)) {
			throw new CountryA2Exception();
		}

		if (Validator.isNull(a3)) {
			throw new CountryA3Exception();
		}

		if (Validator.isNull(number)) {
			throw new CountryNumberException();
		}

		if (Validator.isNull(idd)) {
			throw new CountryIddException();
		}
		
		long countryId = counterLocalService.increment();

		Country country = countryPersistence.create(countryId);
		
		country.setName(name);
		country.setA2(a2);
		country.setA3(a3);
		country.setIdd(idd);
		country.setNumber(number);
		country.setZipRequired(isZipRequired);
		country.setActive(isActive);
		countryPersistence.update(country);
		
		return country;
	}
	
	public Country updateCountry(long countryId, boolean isActive,boolean isZipRequired, String name, String a2, String a3,
			String number, String idd) throws PortalException, SystemException {
		if (!getPermissionChecker().isOmniadmin()) {
			throw new PrincipalException();
		}
		if (Validator.isNull(name)) {
			throw new CountryNameException();
		}

		if (Validator.isNull(a2)) {
			throw new CountryA2Exception();
		}

		if (Validator.isNull(a3)) {
			throw new CountryA3Exception();
		}

		if (Validator.isNull(number)) {
			throw new CountryNumberException();
		}

		if (Validator.isNull(idd)) {
			throw new CountryIddException();
		}
		
		Country country = countryPersistence.findByPrimaryKey(countryId);
		country.setName(name);
		country.setA2(a2);
		country.setA3(a3);
		country.setIdd(idd);
		country.setNumber(number);
		country.setZipRequired(isZipRequired);
		country.setActive(isActive);
		countryPersistence.update(country);
		
		return country;
	}
	
	public int getCountriesCount() throws SystemException, PrincipalException {
		if (!getPermissionChecker().isOmniadmin()) {
			throw new PrincipalException();
		}
		return countryPersistence.countAll();
	}
	
	public List<Country> getCountries(int start, int end) throws SystemException, PrincipalException {
		if (!getPermissionChecker().isOmniadmin()) {
			throw new PrincipalException();
		}
		return countryPersistence.findAll(start, end);
	}
	
	public List<Country> getCountries(int start, int end, OrderByComparator byComparator) throws SystemException, PrincipalException {
		if (!getPermissionChecker().isOmniadmin()) {
			throw new PrincipalException();
		}
		return countryPersistence.findAll(start, end, byComparator);
	}
}
