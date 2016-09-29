package com.gleo.plugins.hexiagon.portlet.announcements.web;

import com.gleo.plugins.hexiagon.constants.AnnouncementConstants;
import com.gleo.plugins.hexiagon.constants.PortletKeys;
import com.gleo.plugins.hexiagon.model.Announcement;
import com.gleo.plugins.hexiagon.model.AnnouncementImage;
import com.gleo.plugins.hexiagon.model.Currency;
import com.gleo.plugins.hexiagon.model.Type;
import com.gleo.plugins.hexiagon.service.AnnouncementLocalServiceUtil;
import com.gleo.plugins.hexiagon.service.CurrencyLocalServiceUtil;
import com.gleo.plugins.hexiagon.service.TypeLocalServiceUtil;
import com.gleo.plugins.hexiagon.util.AnnouncementImageUtil;
import com.gleo.plugins.hexiagon.util.PortalUtil;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.CountryServiceUtil;
import com.liferay.portal.kernel.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnicodeFormatter;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author guillaumelenoir
 * Portlet implementation class AddAnnouncementController
 * 
 */
public class AddAnnouncementController extends MVCPortlet {

	protected static Log LOGGER = LogFactoryUtil.getLog(AddAnnouncementController.class);
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		
		Announcement announcement = null;
		List<Type> types = null;
		Map<Integer, AnnouncementImage> announcementImages = null;
		List<AnnouncementImage> announcementImagesList = null;
		List<Currency> currencies = null;
		List<Long> vocabularyIds = new ArrayList<Long>();
		long countryId = 0l;
		long regionId = 0l;

		long announcementId = ParamUtil.getLong(renderRequest, "announcementId");
		String redirect = ParamUtil.getString(renderRequest, "redirect");
		
		String content = UnicodeFormatter.toString(ParamUtil.getString(renderRequest, "editor"));
		
		PortletPreferences portletPreferences;
		long agreementFileEntryId = 0;
		long defaultCurrencyId = 0;
		boolean isRelatedAssetActivated =  false;

		try {
			long plid = LayoutConstants.DEFAULT_PLID;
			
			try {
				 plid = PortalUtil.getPlidFromPortletId(
					themeDisplay.getScopeGroupId(), PortletKeys.ADD_ANNOUNCEMENT_PORTLETID);
			}
			catch (PortalException e) {
				if (LOGGER.isDebugEnabled()){
					LOGGER.debug(e);
				}
				LOGGER.info("PortalException: unable to get plid for ADD_ANNOUNCEMENT_PORTLETID");
			}
			catch (SystemException se) {
				if (LOGGER.isDebugEnabled()){
					LOGGER.debug(se);
				}
				LOGGER.info("SystemException: unable to get plid for ADD_ANNOUNCEMENT_PORTLETID");
			}
			
			portletPreferences = PortletPreferencesLocalServiceUtil.getPreferences(themeDisplay.getCompanyId(), PortletKeys.PREFS_OWNER_ID_DEFAULT, PortletKeys.PREFS_OWNER_TYPE_LAYOUT, plid, PortletKeys.ADD_ANNOUNCEMENT_PORTLETID);
			
			// Get default currency from preferences
			defaultCurrencyId = GetterUtil.getLong(portletPreferences.getValue(AnnouncementConstants.DEFAULT_CURRENCY_PREFERENCES, StringPool.BLANK));
			
			// preferences = renderRequest.getPreferences();
			// From preferences
			agreementFileEntryId = GetterUtil.getLong(portletPreferences.getValue(AnnouncementConstants.AGREEMENT_FILE_ENTRYID_PREFERENCES, StringPool.BLANK));
			
			// Get isRelatedAssetActivated from preferences
			isRelatedAssetActivated = GetterUtil.getBoolean(portletPreferences.getValue(AnnouncementConstants.ACTIVATE_RELATED_ASSETS_PREFERENCES, StringPool.TRUE));
			
			Country country = CountryServiceUtil.getCountryByA2(themeDisplay.getLocale().getCountry());
			
			if (Validator.isNotNull(country)) {
				countryId = country.getCountryId();
			}
		}
		catch (SystemException se) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(se);
			}
			LOGGER.error("PortalException: unable to get preferences " + se.getMessage());
		}
		catch (PortalException pe) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(pe);
			}
			LOGGER.error("PortalException: unable to get preferences " + pe.getMessage());
		}

		// add case
		String title = "new-announcement";
		
		// get announcement and images
		if (announcementId > 0) {
			try {
				announcement = AnnouncementLocalServiceUtil.getAnnouncement(announcementId);
				title = announcement.getTitle(locale);
				content = UnicodeFormatter.toString(announcement.getContent(locale));
				announcementImagesList = announcement.getImages();
				countryId = announcement.getCountryId();
				regionId = announcement.getRegionId();

				if (Validator.isNotNull(announcementImagesList)) {
					announcementImages = new HashMap<Integer, AnnouncementImage>();
					for (AnnouncementImage announcementImage : announcementImagesList) {
						announcementImages.put(announcementImage.getOrder(), announcementImage);
					}
				}
			}
			catch (PortalException e) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(e);
				}
				LOGGER.error("PortalException: unable to get announcement " + announcementId);
			}
			catch (SystemException e) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(e);
				}
				LOGGER.error("SystemException: unable to get announcement " + announcementId);
			}

		}
		else if (themeDisplay.isSignedIn() && defaultCurrencyId == 0 && countryId != 0) {
			try {
				Currency defaultCurrency = CurrencyLocalServiceUtil.getCurrencyByCountryId(countryId);

				if (defaultCurrency != null && defaultCurrency.getCurrencyId() != 0) {
					defaultCurrencyId = defaultCurrency.getCurrencyId();
				}
			}
			catch (PortalException e) {
				LOGGER.error(e.getMessage());
			}
			catch (SystemException e) {
				LOGGER.error(e.getMessage());
			}
		}

		// get types and currencies
		try {
			// types = TypeServiceUtil.getTypesByGroupId(themeDisplay.getScopeGroupId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			types = TypeLocalServiceUtil.getTypes(themeDisplay.getScopeGroupId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
			for (Type type : types) {
				String name = type.getName(locale);
				type.setName(HtmlUtil.escape(name), locale);
			}

			currencies = CurrencyLocalServiceUtil.getCurrencies(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			List<AssetVocabulary> vocabularies = new ArrayList<AssetVocabulary>();

			Group siteGroup = themeDisplay.getSiteGroup();
			long scopeGroupId = themeDisplay.getScopeGroupId();

			vocabularies.addAll(AssetVocabularyServiceUtil.getGroupVocabularies(siteGroup.getGroupId(), false));

			if (scopeGroupId != themeDisplay.getCompanyGroupId()) {
				vocabularies.addAll(AssetVocabularyServiceUtil.getGroupVocabularies(themeDisplay.getCompanyGroupId(), false));

			}
			long classNameId = PortalUtil.getClassNameId(Announcement.class);

			// Select announcement vocabularies
			for (AssetVocabulary vocabulary : vocabularies) {
				vocabulary = vocabulary.toEscapedModel();

				int vocabularyCategoriesCount = AssetCategoryServiceUtil.getVocabularyCategoriesCount(vocabulary.getGroupId(), vocabulary.getVocabularyId());

				if (vocabularyCategoriesCount == 0) {
					continue;
				}

				// TODO
				if (vocabulary.isRequired(classNameId)){
					vocabularyIds.add(vocabulary.getVocabularyId());
				}
			}
		}
		catch (SystemException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("SystemException: unable to get types or currencies or vocabularies");
		}
		catch (PortalException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("SystemException: unable to get types or currencies or vocabularies");
		}
		
		// Preview
		renderRequest.setAttribute("previewFileURL", AnnouncementImageUtil.getImageURL(themeDisplay, agreementFileEntryId));

		// Default currencyId
		renderRequest.setAttribute("defaultCurrencyId", defaultCurrencyId);
		
		// Set isRelatedAssetActivated
		renderRequest.setAttribute("isRelatedAssetActivated", isRelatedAssetActivated);
		
		renderRequest.setAttribute("redirect", redirect);
		renderRequest.setAttribute("title", title);
		renderRequest.setAttribute("model", Announcement.class);
		renderRequest.setAttribute("imageModel", AnnouncementImage.class);
		renderRequest.setAttribute("imageBean", AnnouncementConstants.ANNOUNCEMENT_IMAGE);
		renderRequest.setAttribute("maxPrice", AnnouncementConstants.MAX_PRICE);
		renderRequest.setAttribute("types", types);
		renderRequest.setAttribute("currencies", currencies);
		renderRequest.setAttribute("announcement", announcement);
		renderRequest.setAttribute("content", content);
		renderRequest.setAttribute("announcementImages", announcementImages);
		renderRequest.setAttribute("imageLimit", AnnouncementConstants.IMAGE_LIMIT);
		renderRequest.setAttribute("vocabularyIds", vocabularyIds);

		renderRequest.setAttribute("fileSizeRule", AnnouncementConstants.IMAGE_MAX_SIZE);
		renderRequest.setAttribute("acceptFiles", AnnouncementConstants.IMAGE_EXTENSIONS);
		
		renderRequest.setAttribute("countryId", countryId);
		renderRequest.setAttribute("regionId", regionId);
		
		renderRequest.setAttribute("actionName", announcement != null ? "updateAnnouncement" : "addAnnouncement");

		super.doView(renderRequest, renderResponse);
	}
	
}
