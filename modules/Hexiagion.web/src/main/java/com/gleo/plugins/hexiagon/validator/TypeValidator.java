
package com.gleo.plugins.hexiagon.validator;

import com.liferay.portal.kernel.util.Validator;
import com.gleo.plugins.hexiagon.model.Type;

import java.util.List;
import java.util.Locale;

/**
 * @author guillaumelenoir
 *
 */
public class TypeValidator {

	/**
	 * Validate Type
	 * 
	 * @param type
	 * @param errors
	 * @return valid
	 */
	public static boolean validateType(Type type, List<String> errors, Locale locale) {

		boolean valid = true;

		if (Validator.isNull(type)) {
			errors.add("type-errors");
			valid = false;
		}

		if (Validator.isNull(type.getName(locale))) {
			errors.add("typename-required");
			valid = false;
		}

		return valid;
	}
}
