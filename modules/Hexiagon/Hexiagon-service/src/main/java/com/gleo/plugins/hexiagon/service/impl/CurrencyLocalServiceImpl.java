package com.gleo.plugins.hexiagon.service.impl;

import com.gleo.plugins.hexiagon.model.Currency;
import com.gleo.plugins.hexiagon.service.base.CurrencyLocalServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.NoSuchCountryException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;

/**
 * The implementation of the currency local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.liferay.plugin.announcement.service.CurrencyLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author guillaumelenoir
 * @see org.liferay.plugin.announcement.service.base.CurrencyLocalServiceBaseImpl
 * @see org.liferay.plugin.announcement.service.CurrencyLocalServiceUtil
 */
public class CurrencyLocalServiceImpl extends CurrencyLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link org.liferay.plugin.announcement.service.CurrencyLocalServiceUtil} to access the currency local service.
     */
	
	/**
	 * Adds the currency to the database incrementing the primary key
	 * @throws PortalException 
	 *
	 */
	public Currency addCurrency(Currency currency, ServiceContext serviceContext) throws SystemException, PortalException {
		long companyId = serviceContext.getCompanyId();
		long groupId = serviceContext.getScopeGroupId();
		long currencyId = CounterLocalServiceUtil.increment(Currency.class.getName());
		long userId = serviceContext.getUserId();
		long countryId = currency.getCountryId();
		
		if (countryId > 0) {
			countryPersistence.findByPrimaryKey(countryId);
		}

		currency.setCompanyId(companyId);
		currency.setCurrencyId(currencyId);
		currency = currencyPersistence.update(currency);
		
		// Resources
		if (serviceContext.isAddGroupPermissions() ||
			serviceContext.isAddGuestPermissions()) {

			resourceLocalService.addResources(
				currency.getCompanyId(), groupId, userId,
				Currency.class.getName(), currencyId, false,
				serviceContext.isAddGroupPermissions(), serviceContext.isAddGuestPermissions());
		}
		else {
			resourceLocalService.addModelResources(
				currency.getCompanyId(), groupId, userId,
				Currency.class.getName(), currencyId, serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
		}
		

		return currency;
	}

	/**
	 * Delete the currency to the database
	 *
	 */
//	public Currency deleteCurrency(Currency currency) throws SystemException, PortalException {
//
//		if (Validator.isNotNull(currency)) {
//			long currencyId = currency.getCurrencyId();
//			if (announcementLocalService.getAnnouncementsCountByCurrencyId(currencyId) == 0) {
//				currency = super.deleteCurrency(currency);
//				resourceLocalService.deleteResource(currency.getCompanyId(), Currency.class.getName(), ResourceConstants.SCOPE_COMPANY, currency.getPrimaryKey());
//			} else {
//				throw new SystemException("use-currency");
//			}
//		}
//		return currency;
//	}
	
	/**
	 * Delete the currency to the database
	 *
	 */
	public Currency deleteCurrency(long currencyId) throws SystemException, PortalException {
		Currency currency = currencyLocalService.getCurrency(currencyId);
		return deleteCurrency(currency);
	}

	public Currency updateCurrency(Currency currency)
		throws SystemException {

		long countryId = currency.getCountryId();
		
		if (countryId > 0) {
			try {
				countryPersistence.findByPrimaryKey(countryId);
			}
			catch (NoSuchCountryException e) {
				throw new SystemException("no country exist with countryId = " + countryId);
			}
		}
		
		currencyPersistence.clearCache(currency);
		return super.updateCurrency(currency);
	}
	
	public Currency getCurrencyByCountryId(long countryId) throws SystemException, PortalException {
		int count = currencyPersistence.countByCountryId(countryId);
		Currency currency = null;
		if(count >= 1) {
			currency = currencyPersistence.findByCountryId(countryId);
		}
		return currency;
	}

}
