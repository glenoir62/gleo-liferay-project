
package com.gleo.plugins.hexiagon.validator;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

import com.gleo.plugins.hexiagon.model.Announcement;
import com.gleo.plugins.hexiagon.model.AnnouncementImage;
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

		if (StringUtils.isEmpty(announcement.getTitle(locale))) {
			errors.add("announcementtitle-required");
			valid = false;
		}

		if (announcement.getPrice() < 0 || !Validator.isNumber(String.valueOf(announcement.getPrice()))) {
			errors.add("announcementprice-required");
			valid = false;
		}

		if (StringUtils.isEmpty(announcement.getContent(locale))) {
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
		
		if (announcement.getRegionId() <= 0) {
			errors.add("announcementregion-required");
			valid = false;
		}

		return valid;
	}
}
