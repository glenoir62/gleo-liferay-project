
package com.gleo.plugins.hexiagon.model.impl;

import java.util.List;
import java.util.Locale;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowStateException;

import com.gleo.plugins.hexiagon.constants.AnnouncementConstants;
import com.gleo.plugins.hexiagon.constants.PortletKeys;
import com.gleo.plugins.hexiagon.model.Announcement;
import com.gleo.plugins.hexiagon.model.AnnouncementImage;
import com.gleo.plugins.hexiagon.model.Currency;
import com.gleo.plugins.hexiagon.model.Type;
import com.gleo.plugins.hexiagon.service.AnnouncementImageLocalServiceUtil;
import com.gleo.plugins.hexiagon.service.CurrencyLocalServiceUtil;
import com.gleo.plugins.hexiagon.service.FavoriteLocalServiceUtil;
import com.gleo.plugins.hexiagon.service.TypeLocalServiceUtil;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.message.boards.kernel.service.MBMessageLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.service.CountryServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.ratings.kernel.model.RatingsStats;
import com.liferay.ratings.kernel.service.RatingsStatsLocalServiceUtil;

/**
 * The extended model implementation for the Announcement service. Represents a
 * row in the &quot;Hexagon_Announcement&quot; database table, with each column
 * mapped to a property of this class. <p> Helper methods and all application
 * logic should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.glenoir.plugins.hexagon.model.Announcement} interface. </p>
 * 
 * @author guillaumelenoir
 */
public class AnnouncementImpl extends AnnouncementBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this class directly. All methods
	 * that expect a announcement model instance should use the {@link
	 * com.glenoir.plugins.hexagon.model.Announcement} interface instead.
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * AnnouncementImpl Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(AnnouncementImpl.class);

	public AnnouncementImpl() {

	}

	public List<AnnouncementImage> announcementImages;

	public boolean isValidAgreement;

	public boolean isFavorite;
	
	public void setAnnouncementImages(List<AnnouncementImage> announcementImages) {
		this.announcementImages = announcementImages;
	}

	public boolean isFavorite(long userId) {

		isFavorite = false;

		if (this != null) {
			try {
				isFavorite = FavoriteLocalServiceUtil.isUserFavoriteAnnouncement(userId, this.getAnnouncementId(), this.getGroupId());
			}
			catch (PortalException pe) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(pe);
				}
				LOGGER.error("SystemException : impossible to get isFavorite for announcementId " + this.getAnnouncementId() + " userId " + userId);
			}
			catch (SystemException se) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(se);
				}
				LOGGER.error("SystemException : impossible to get isFavorite for announcementId " + this.getAnnouncementId() + " userId " + userId);
			}
		}

		return isFavorite;
	}

	public boolean isValidAgreement() {

		return isValidAgreement;
	}

	public void setValidAgreement(boolean isValidAgreement) {

		this.isValidAgreement = isValidAgreement;
	}

	public List<AnnouncementImage> getAnnouncementImages() {

		return announcementImages;
	}

	public List<AnnouncementImage> getImages() {

		long announcementId = this.getAnnouncementId();
		List<AnnouncementImage> announcementImages = null;

		if (announcementId > 0) {
			try {
				announcementImages = AnnouncementImageLocalServiceUtil.getAnnouncementImageByAnnouncementId(announcementId);
			}
			catch (SystemException se) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(se);
				}
				LOGGER.error("SystemException : impossible to get images for announcement " + announcementId);
			}
		}

		return announcementImages;
	}

	public AnnouncementImage getImage() {

		long announcementId = this.getAnnouncementId();
		AnnouncementImage announcementImage = null;

		if (announcementId > 0) {
			try {
				announcementImage = AnnouncementImageLocalServiceUtil.getAnnouncementImageByAnnouncementIdOrder(announcementId, 1);
			}
			catch (SystemException se) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(se);
				}
				LOGGER.error("SystemException : impossible to get images for announcement " + announcementId);
			}
		}

		return announcementImage;

	}

	public Type getType() {

		Type type = null;

		try {
			type = TypeLocalServiceUtil.getType(this.getTypeId());
		}
		catch (PortalException pe) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(pe);
			}
			LOGGER.error("PortalException : impossible to get type " + this.getTypeId());
		}
		catch (SystemException se) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(se);
			}
			LOGGER.error("SystemException : impossible to get type " + this.getTypeId());
		}

		return type;
	}

	public String getSummary(Locale locale) {

		if (getContent(locale) == null) {
			return StringPool.BLANK;
		}
		else {
			return HtmlUtil.escape(StringUtil.shorten(HtmlUtil.extractText(getContent(locale)), 300));
		}
	}

	public int getMessagesCount() {

		int messagesCount = 0;

		try {
			messagesCount = MBMessageLocalServiceUtil.getDiscussionMessagesCount(Announcement.class.getName(), getAnnouncementId(), WorkflowConstants.STATUS_APPROVED);
		}
		catch (SystemException se) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(se);
			}
			LOGGER.error("SystemException : impossible to get messages count " + this.getAnnouncementId());
		}

		return messagesCount;
	}

	/**
	 * @return
	 */
	public int getRatingsCount() {

		int ratingsCount = 0;

		try {
			RatingsStats ratingsStats = RatingsStatsLocalServiceUtil.getStats(Announcement.class.getName(), getAnnouncementId());
			ratingsCount = ratingsStats.getTotalEntries();
		}
		catch (Exception se) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(se);
			}
			LOGGER.error("SystemException : impossible to get ratings count " + this.getAnnouncementId());
		}
		return ratingsCount;
	}

	/**
	 * @return
	 */
	public String getCurrencySymbol() {

		String symbol = StringPool.BLANK;

		if (Validator.isNotNull(getCurrencyId())) {
			try {
				Currency currency = CurrencyLocalServiceUtil.getCurrency(getCurrencyId());
				if (Validator.isNotNull(currency)) {
					symbol = currency.getSymbol();
				}
			}
			catch (PortalException pe) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(pe);
				}
				LOGGER.error("PortalException : impossible to get currency " + this.getCurrencyId());
			}
			catch (SystemException se) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(se);
				}
				LOGGER.error("SystemException : impossible to get currency " + this.getCurrencyId());
			}
		}

		return symbol;
	}

	/**
	 * @param locale
	 * @return
	 */
	public String getStatus(Locale locale) {

		return LanguageUtil.get(locale, WorkflowConstants.getStatusLabel(getStatus()));
	}
	
	public User getUser() {
		User user = null;
		
		try {
			user = UserLocalServiceUtil.getUser(getUserId());
		} catch (PortalException e) {
			LOGGER.error(e);
		} catch (SystemException e) {
			LOGGER.error(e);
		}

		return user;
	}

	/**
	 * @param locale
	 * @return
	 */
	public String getCountry(Locale locale) {

		long countryId = getCountryId();
		String countryName = StringPool.BLANK;

		if (Validator.isNotNull(countryId)) {
			Country country = null;
			try {
				country = CountryServiceUtil.getCountry(countryId);
			}
			catch (PortalException pe) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(pe);
				}
				LOGGER.error("PortalException : impossible to get country " + countryId);
			}
			catch (SystemException se) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(se);
				}
				LOGGER.error("SystemException : impossible to get country " + countryId);
			}
			if (Validator.isNotNull(country)) {
				countryName = country.getName(locale);
			}
		}
		return countryName;
	}

	/**
	 * @param liferayPortletRequest
	 * @param liferayPortletResponse
	 * @return
	 * @throws WindowStateException
	 */
	public String getAnnouncementUrl(LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse)
		throws Exception {

		long plid = LayoutConstants.DEFAULT_PLID;

		try {
			plid = PortalUtil.getPlidFromPortletId(getGroupId(), PortletKeys.ANNOUNCEMENT_DISPLAY_PORTLETID);
		}
		catch (PortalException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.info("PortalException: unable to get plid for ANNOUNCEMENT_DISPLAY_PORTLETID");
		}
		catch (SystemException se) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(se);
			}
			LOGGER.info("SystemException: unable to get plid for ANNOUNCEMENT_DISPLAY_PORTLETID");
		}

		if (plid == LayoutConstants.DEFAULT_PLID) {

			PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(PortletKeys.ANNOUNCEMENT_DISPLAY_PORTLETID, PortletRequest.RENDER_PHASE);
			portletURL.setParameter("announcementId", String.valueOf(getAnnouncementId()));
			portletURL.setWindowState(LiferayWindowState.POP_UP);
			return LiferayWindowState.POP_UP.toString();
		}

		PortletURL portletURL = PortletURLFactoryUtil.create(liferayPortletRequest, PortletKeys.ANNOUNCEMENT_DISPLAY_PORTLETID, plid, PortletRequest.RENDER_PHASE);

		portletURL.setParameter("announcementId", String.valueOf(getAnnouncementId()));
		portletURL.setWindowState(LiferayWindowState.NORMAL);
		
		long[] categoryIds = ParamUtil.getLongValues(liferayPortletRequest, "categoryIds");

		long typeId = ParamUtil.getLong(liferayPortletRequest, "typeId");
		long currencyId = ParamUtil.getLong(liferayPortletRequest, "currencyId");
		long countryId = ParamUtil.getLong(liferayPortletRequest, "countryId");
		long regionId = ParamUtil.getLong(liferayPortletRequest, "regionId");

		int filterId = ParamUtil.getInteger(liferayPortletRequest, "filterId");

		PortletPreferences preferences = liferayPortletRequest.getPreferences();

		// Pagination
		int delta = GetterUtil.getInteger(preferences.getValue("delta", String.valueOf(AnnouncementConstants.DELDA_SEARCH)));
		int page = ParamUtil.getInteger(liferayPortletRequest, "page");

		PortletURL redirectUrl = liferayPortletResponse.createRenderURL();

		redirectUrl.setParameter("typeId", String.valueOf(typeId));
		redirectUrl.setParameter("categoryIds", StringUtil.merge(categoryIds));
		redirectUrl.setParameter("currencyId", String.valueOf(currencyId));
		redirectUrl.setParameter("countryId", String.valueOf(countryId));
		redirectUrl.setParameter("regionId", String.valueOf(regionId));
		redirectUrl.setParameter("filterId", String.valueOf(filterId));
		redirectUrl.setParameter("delta", String.valueOf(delta));
		redirectUrl.setParameter("page", String.valueOf(page));

		portletURL.setParameter("redirect", redirectUrl.toString());

		return portletURL.toString();
	}
	
	public boolean hasCategories() {
		
		boolean hasCategories = false;
		
		try {
			AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(Announcement.class.getName(), this.getAnnouncementId());
			hasCategories = AssetCategoryLocalServiceUtil.getAssetEntryAssetCategoriesCount(assetEntry.getEntryId()) >=1;
		} catch (PortalException e) {
			LOGGER.error(e);
		} catch (SystemException e) {
			LOGGER.error(e);
		} catch (Exception e) {
			LOGGER.error(e);
		}
		
		return hasCategories;
	}
}
