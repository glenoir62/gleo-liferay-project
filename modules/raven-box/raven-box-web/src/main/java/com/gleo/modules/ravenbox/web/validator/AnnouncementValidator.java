
package com.gleo.modules.ravenbox.web.validator;

import java.util.List;
import java.util.Locale;

import com.gleo.modules.ravenbox.model.Announcement;
import com.gleo.modules.ravenbox.model.AnnouncementImage;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author guillaumelenoir
 *
 */
public class AnnouncementValidator {

	/**
	 * @param announcement
	 *            to be validated
	 * @param errors
	 *            to populate with any errors
	 * @return
	 */
	public static boolean validateAnnouncement(Announcement announcement, List<String> errors, Locale locale) {

		boolean valid = true;

		if (Validator.isNull(announcement)) {
			errors.add("announcement-errors");
			valid = false;
		}

		List<AnnouncementImage> announcementImages = announcement.getAnnouncementImages();

		if (Validator.isNotNull(announcementImages)) {
			// Image validation
			for (AnnouncementImage announcementImage : announcementImages) {
				valid = valid && AnnouncementImageValidator.validateAnnouncementImage(announcementImage, errors);
			}
		}

		if (Validator.isBlank(announcement.getTitle(locale))) {
			errors.add("announcementtitle-required");
			valid = false;
		}

		if (announcement.getPrice() < 0 || !Validator.isNumber(String.valueOf(announcement.getPrice()))) {
			errors.add("announcementprice-required");
			valid = false;
		}

		if (Validator.isBlank(announcement.getContent(locale))) {
			errors.add("announcementcontent-required");
			valid = false;
		}

		if (!Validator.isEmailAddress(announcement.getEmailAddress())) {
			errors.add("announcementemail-format-error");
			valid = false;
		}

		if (!Validator.isPhoneNumber(announcement.getPhoneNumber())) {
			errors.add("announcementphonenumber-format-error");
			valid = false;
		}

		if (Validator.isNull(announcement.getTypeId())) {
			errors.add("announcementtype-required");
			valid = false;
		}
		
		if (!announcement.isValidAgreement()) {
			errors.add("announcementagreement-required");
			valid = false;
		}
		
		if (announcement.getCountryId() <= 0) {
			errors.add("announcementcountry-required");
			valid = false;
		}

		return valid;
	}
}
