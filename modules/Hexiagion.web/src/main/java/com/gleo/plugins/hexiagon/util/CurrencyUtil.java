
package com.gleo.plugins.hexiagon.util;

import com.gleo.plugins.hexiagon.model.Currency;
import com.gleo.plugins.hexiagon.service.CurrencyLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class CurrencyUtil {

	/**
	 * CurrencyUtil Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(CurrencyUtil.class);

	public static long getCurrencyByCountryId(long countryId) {

		long currencyId = 0;
		
		if (countryId > 0) {

			try {
				Currency currency = CurrencyLocalServiceUtil.getCurrencyByCountryId(countryId);
				if (currency != null && currency.getCurrencyId() > 0) {
					currencyId = currency.getCurrencyId();
				}
			}
			catch (PortalException pe) {
				LOGGER.error(pe);
			}
			catch (SystemException se) {
				LOGGER.error(se);
			}
		}
		return currencyId;
	}

}
