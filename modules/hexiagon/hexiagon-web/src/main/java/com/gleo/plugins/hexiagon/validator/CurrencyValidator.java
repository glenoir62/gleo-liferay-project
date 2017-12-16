
package com.gleo.plugins.hexiagon.validator;

import com.liferay.portal.kernel.util.Validator;
import com.gleo.plugins.hexiagon.model.Currency;

import java.util.List;

/**
 * @author guillaumelenoir
 *
 */
public class CurrencyValidator {

	/**
	 * @param currency
	 *            to be validated
	 * @param errors
	 *            to populate with any errors
	 * @return
	 */
	public static boolean validateCurrency(Currency currency, List<String> errors) {

		boolean valid = true;

		if (Validator.isNull(currency)) {
			errors.add("currency-errors");
			valid = false;
		}

		if (Validator.isNull(currency.getLabel())) {
			errors.add("label-required");
			valid = false;
		}

		if (Validator.isNull(currency.getSymbol())) {
			errors.add("symbol-required");
			valid = false;
		}

		return valid;
	}
}
