package com.gleo.modules.ravenbox.web.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.gleo.modules.ravenbox.constants.AnnouncementConstants;
import com.gleo.modules.ravenbox.model.Announcement;
import com.gleo.modules.ravenbox.model.AnnouncementImage;
import com.gleo.modules.ravenbox.service.AnnouncementImageLocalServiceUtil;
import com.gleo.modules.ravenbox.service.AnnouncementLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

public class AnnouncementUtil {

	/**
	 * Convenience method to create a Announcement object out of the request.
	 * Used by the Add / Edit methods.
	 * 
	 * @throws SystemException
	 * @throws PortalException
	 */
	public static Announcement announcementFromRequest(UploadPortletRequest uploadPortletRequest, ThemeDisplay themeDisplay)
			throws IOException, PortalException, SystemException {

		Announcement announcement = null;

		long announcementId = ParamUtil.getLong(uploadPortletRequest, "announcementId");
		long companyId = themeDisplay.getCompanyId();
		long groupId = themeDisplay.getScopeGroupId();
		long userId = themeDisplay.getUserId();

		long countryId = ParamUtil.getLong(uploadPortletRequest, "countryId");
		long regionId = ParamUtil.getLong(uploadPortletRequest, "regionId");
	
		String city = HtmlUtil.escape(ParamUtil.getString(uploadPortletRequest, "city"));
	
		String building = HtmlUtil.escape(ParamUtil.getString(uploadPortletRequest, "building"));
		String site = HtmlUtil.escape(ParamUtil.getString(uploadPortletRequest, "site"));

		if (Validator.isNotNull(announcementId)) {
			announcement = AnnouncementLocalServiceUtil.getAnnouncement(announcementId);
		} else {
			announcement = AnnouncementLocalServiceUtil.createAnnouncement(announcementId);
		}

		Map<String, FileItem[]> multipartParameterMap = uploadPortletRequest.getMultipartParameterMap();
		List<AnnouncementImage> announcementImages = new ArrayList<AnnouncementImage>();

		String imagePrefix = "image";

		// images
		for (int i = 1; i <= AnnouncementConstants.IMAGE_LIMIT; i++) {
			boolean isImageDisabled = ParamUtil.getBoolean(uploadPortletRequest, "imageDisabled" + i);
			String imageName = imagePrefix + i;

			if (multipartParameterMap.keySet().contains(imageName) || isImageDisabled) {
				InputStream inputStream = uploadPortletRequest.getFileAsStream(imageName);

				AnnouncementImage image = null;
				long announcementImageId = ParamUtil.getLong(uploadPortletRequest, "announcementImageId" + i);

				if (Validator.isNotNull(announcementImageId)) {
					image = AnnouncementImageLocalServiceUtil.getAnnouncementImage(announcementImageId);
				} else {
					image = AnnouncementImageLocalServiceUtil.createAnnouncementImage(announcementImageId);
				}

				image.setDescriptionMap(LocalizationUtil.getLocalizationMap(uploadPortletRequest, "description" + i));
				image.setAnnouncementId(announcementId);

				// resize Image
				if (Validator.isNotNull(inputStream)) {
					image.setInputStream(AnnouncementImageUtil.resizeImages(inputStream));
				}
				image.setOrder(i);
				image.setGroupId(groupId);
				image.setCompanyId(companyId);
				image.setUserId(userId);
				image.setActive(!isImageDisabled);
				announcementImages.add(image);
			}
		}

		announcement.setValidAgreement(ParamUtil.getBoolean(uploadPortletRequest, "agreement"));
		announcement.setAnnouncementImages(announcementImages);
		announcement.setAnnouncementId(announcementId);
	
		announcement.setTitleMap(LocalizationUtil.getLocalizationMap(uploadPortletRequest, "title"));
		announcement.setTitle(HtmlUtil.escape(ParamUtil.getString(uploadPortletRequest, "title")));
		String content = ParamUtil.getString(uploadPortletRequest, "editor");
		announcement.setContent(content, themeDisplay.getLocale());
		announcement.setTypeId(ParamUtil.getLong(uploadPortletRequest, "typeId"));
		announcement.setPrice(ParamUtil.getLong(uploadPortletRequest, "price"));
		announcement.setCurrencyId(ParamUtil.getLong(uploadPortletRequest, "currencyId"));

		announcement.setEmailAddress(HtmlUtil.escape(ParamUtil.getString(uploadPortletRequest, "emailAddress")));
		announcement.setPhoneNumber(HtmlUtil.escape(ParamUtil.getString(uploadPortletRequest, "phoneNumber")));
		announcement.setCompanyId(companyId);
		announcement.setGroupId(groupId);
		announcement.setUserId(userId);
		announcement.setRegionId(regionId);
		announcement.setCountryId(countryId);

		announcement.setCity(city);
		announcement.setBuilding(building);
		announcement.setSite(site);

		return announcement;
	}
}
