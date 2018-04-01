
package com.gleo.modules.ravenbox.web.portlet.announcements.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.gleo.modules.ravenbox.constants.AnnouncementConstants;
import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.gleo.modules.ravenbox.model.Announcement;
import com.gleo.modules.ravenbox.model.AnnouncementImage;
import com.gleo.modules.ravenbox.model.Type;
import com.gleo.modules.ravenbox.service.AnnouncementLocalService;
import com.gleo.modules.ravenbox.service.AnnouncementService;
import com.gleo.modules.ravenbox.service.TypeLocalServiceUtil;
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
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.CountryServiceUtil;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.UnicodeFormatter;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author guillaumelenoir
 *
 */
@Component(
	property = {
        	"javax.portlet.name=" + RavenBoxPortletKeys.ANNOUNCEMENTS_CONFIGURATION,
        	"mvc.command.name=/announcements/edit"
	}
)
public class EditAnnouncementMVCRenderCommand implements MVCRenderCommand {

    /**
     * GroupPhotoController Logger.
     */
    protected static Log LOGGER = LogFactoryUtil.getLog(EditAnnouncementMVCRenderCommand.class);

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

    	ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		
		Announcement announcement = null;
		List<Type> types = null;
		Map<Integer, AnnouncementImage> announcementImages = null;
		List<AnnouncementImage> announcementImagesList = null;
		
		List<Long> vocabularyIds = new ArrayList<Long>();
		long countryId = 0l;
		long regionId = 0l;

		long announcementId = ParamUtil.getLong(renderRequest, "announcementId");
		String redirect = ParamUtil.getString(renderRequest, "redirect");
		
		String content = UnicodeFormatter.toString(ParamUtil.getString(renderRequest, "editor"));
		
//		PortletPreferences portletPreferences;
//		long agreementFileEntryId = 0;
		long defaultCurrencyId = 0;
		boolean isRelatedAssetActivated =  false;
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		try {

//			portletPreferences = renderRequest.getPreferences();
			
//			// preferences = renderRequest.getPreferences();
//			// From preferences
//			agreementFileEntryId = GetterUtil.getLong(portletPreferences.getValue(AnnouncementConstants.AGREEMENT_FILE_ENTRYID_PREFERENCES, StringPool.BLANK));
//			
//			// Get isRelatedAssetActivated from preferences
//			isRelatedAssetActivated = GetterUtil.getBoolean(portletPreferences.getValue(AnnouncementConstants.ACTIVATE_RELATED_ASSETS_PREFERENCES, StringPool.TRUE));
//			
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
				announcement = announcementService.getAnnouncement(announcementId);
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

		} else {
			PortletSession portletSession = renderRequest.getPortletSession();
			
			announcement = (Announcement) portletSession.getAttribute("announcement");
			
			if (announcement == null)
				announcement = announcementLocalService.createAnnouncement(0l);
		}

		// get types
		try {
			types = TypeLocalServiceUtil.findByGroupId(themeDisplay.getScopeGroupId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			
			for (Type type : types) {
				String name = type.getName(locale);
				type.setName(HtmlUtil.escape(name), locale);
			}

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

				if (vocabulary.isRequired(classNameId, PortalUtil.getClassNameId(Announcement.class))){
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
		
		portletDisplay.setShowBackIcon(true);
		portletDisplay.setURLBack(renderResponse.createRenderURL().toString());
		renderResponse.setTitle(title);
		
		
		// Preview
		//renderRequest.setAttribute("previewFileURL", AnnouncementImageUtil.getImageURL(themeDisplay, agreementFileEntryId));

		// Default currencyId
		renderRequest.setAttribute("defaultCurrencyId", defaultCurrencyId);
		
		// Set isRelatedAssetActivated
		renderRequest.setAttribute("isRelatedAssetActivated", isRelatedAssetActivated);
		
		renderRequest.setAttribute("redirect", redirect);
		renderRequest.setAttribute("model", Announcement.class);
		renderRequest.setAttribute("imageModel", AnnouncementImage.class);
		renderRequest.setAttribute("imageBean", AnnouncementConstants.ANNOUNCEMENT_IMAGE);
		renderRequest.setAttribute("maxPrice", AnnouncementConstants.MAX_PRICE);
		renderRequest.setAttribute("types", types);
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


	return "/ravenbox/announcements/configuration/edit.jsp";
    }
    
	@Reference
	protected void setAnnouncementService(
			AnnouncementService announcementService) {
		this.announcementService = announcementService;
	}

	@Reference
	protected void setAnnouncementLocalService(
			AnnouncementLocalService announcementLocalService) {
		this.announcementLocalService = announcementLocalService;
	}

	private AnnouncementLocalService announcementLocalService;
	private AnnouncementService announcementService;

}
