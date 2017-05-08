package com.gleo.plugins.hexiagon.constants;

import com.gleo.plugins.hexiagon.model.AnnouncementImage;
import com.gleo.plugins.hexiagon.service.AnnouncementImageLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;

public class AnnouncementConstants {
	
	private AnnouncementConstants() {
		super();
	}
	
	/**
	 * Enabled delete scheduler
	 */
	public static final boolean ANNONCEMENTS_SCHEDULER_DELETE_ENABLED = GetterUtil.getBoolean(PropsUtil.get(PropsKeys.ANNONCEMENTS_SCHEDULER_DELETE_ENABLED));
	
	/**
	 * Default period
	 */
	public static final int ANNONCEMENTS_DEFAULT_PERIOD_TO_DELETE_IN_DAYS = GetterUtil.getInteger(PropsUtil.get(PropsKeys.ANNONCEMENTS_DEFAULT_PERIOD_TO_DELETE_IN_DAYS));
	
	/**
	 * Image limit for an announcement
	 */
	public static final int IMAGE_LIMIT = GetterUtil.getInteger(PropsUtil.get(PropsKeys.ANNONCEMENTS_IMAGE_LIMIT));
	
	/**
	 * Max price for an announcement
	 */
	public static final long MAX_PRICE = GetterUtil.getLong(PropsUtil.get(PropsKeys.ANNONCEMENTS_MAX_PRICE));

	/**
	 * Max image height for the resizing process 
	 */
	public static final int IMAGE_MAX_HEIGHT = GetterUtil.getInteger(PropsUtil.get(PropsKeys.ANNONCEMENTS_IMAGE_MAX_HEIGHT));

	/**
	 * Max image width for the resizing process 
	 */
	public static final int IMAGE_MAX_WIDTH = GetterUtil.getInteger(PropsUtil.get(PropsKeys.ANNONCEMENTS_IMAGE_MAX_WIDTH));

	/**
	 * Max image size
	 */
	public static final long IMAGE_MAX_SIZE = GetterUtil.getInteger(PropsUtil.get(PropsKeys.ANNONCEMENTS_IMAGE_MAX_SIZE));

	/**
	 * Extensions
	 */
	public static final String IMAGE_EXTENSIONS = PropsUtil.get(PropsKeys.ANNONCEMENTS_IMAGE_EXTENSIONS);
	
	/**
	 * Default delta search
	 */
	public static int DELDA_SEARCH = GetterUtil.getInteger(PropsUtil.get(PropsKeys.ANNONCEMENTS_DEFAULT_DELDA_SEARCH));
	
	/**
	 * Announcement portlet repository
	 */
	public static final String ANNOUNCEMENT_PORTLET_REPOSITORY = "AnnouncementPortletRepository";
	
	/**
	 * Empty announcement Image for aui taglib
	 */
	public static final AnnouncementImage ANNOUNCEMENT_IMAGE = AnnouncementImageLocalServiceUtil.createAnnouncementImage(0L);

	
	/**
	 * AGREEMENT_FILE_ENTRYID_PREFERENCES
	 */
	public static final String AGREEMENT_FILE_ENTRYID_PREFERENCES = "agreementFileEntryId";
	
	/**
	 * DEFAULT_CURRENCY_PREFERENCES
	 */
	public static final String DEFAULT_CURRENCY_PREFERENCES = "defaultCurrencyPreferences";
	
	/**
	 * ACTIVATE_RELATED_ASSETS_PREFERENCES
	 */
	public static final String ACTIVATE_RELATED_ASSETS_PREFERENCES = "activateRelatedAssets";

	public static final String DEFAULT_PERIOD_TO_DELETE_IN_DAYS = "defaultPeriodToDeleteInDays";
	
}
