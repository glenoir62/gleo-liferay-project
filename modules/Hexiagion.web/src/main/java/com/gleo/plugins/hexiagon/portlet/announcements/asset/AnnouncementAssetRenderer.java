package com.gleo.plugins.hexiagon.portlet.announcements.asset;

import com.gleo.plugins.hexiagon.constants.PortletKeys;
import com.gleo.plugins.hexiagon.model.Announcement;
import com.gleo.plugins.hexiagon.model.AnnouncementImage;
import com.gleo.plugins.hexiagon.permission.AnnouncementPermission;
import com.gleo.plugins.hexiagon.util.PortalUtil;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.trash.TrashRenderer;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author guillaumelenoir
 * Announcement Asset Renderer
 */
public class AnnouncementAssetRenderer extends BaseJSPAssetRenderer<Announcement> implements TrashRenderer {

	protected static Log LOGGER = LogFactoryUtil.getLog(AnnouncementAssetRenderer.class);
	
	public AnnouncementAssetRenderer(Announcement announcement) {
		_announcement = announcement;
	}
	
	/**
	 * @param permissionChecker
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public boolean hasDeletePermission(PermissionChecker permissionChecker)
	throws PortalException, SystemException {

		return AnnouncementPermission.contains(permissionChecker, _announcement.getAnnouncementId(), ActionKeys.DELETE);
	}

	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker)
		throws PortalException, SystemException {
	
		return AnnouncementPermission.contains(permissionChecker, _announcement.getAnnouncementId(), ActionKeys.UPDATE);
	}
	
	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker)
		throws PortalException, SystemException {
	
		return AnnouncementPermission.contains(permissionChecker, _announcement.getAnnouncementId(), ActionKeys.VIEW);
		
	}
	
	@Override
	public boolean isPrintable() {
		return true;
	}
	@Override
	public long getGroupId() {

		return _announcement.getGroupId();
	}

	@Override
	public long getUserId() {

		return _announcement.getUserId();
	}

	@Override
	public String getUserName() {

		return _announcement.getUserName();
	}

	@Override
	public String getUuid() {

		return _announcement.getUuid();
	}

	@Override
	public String getClassName() {

		return Announcement.class.getName();
	}

	@Override
	public long getClassPK() {

		return _announcement.getAnnouncementId();
	}

	@Override
	public String getPortletId() {

		AssetRendererFactory<Announcement> assetRendererFactory = getAssetRendererFactory();
		return assetRendererFactory.getPortletId();
	}

	@Override
	public String getTitle(Locale locale) {

		return _announcement.getTitle(locale);
	}

	@Override
	public String getType() {

		return AnnouncementAssetRendererFactory.TYPE;
	}

	@Override
	public PortletURL getURLEdit(
			LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) throws PortalException, SystemException {
		
		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
			getControlPanelPlid(liferayPortletRequest),
			PortletKeys.ADD_ANNOUNCEMENT_PORTLETID, PortletRequest.RENDER_PHASE);

		portletURL.setParameter("announcementId", String.valueOf(_announcement.getAnnouncementId()));
		
		return portletURL;
	}

	public String getURLView(
			LiferayPortletResponse liferayPortletResponse,
			WindowState windowState) throws WindowStateException {

		
		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
			PortletKeys.ANNOUNCEMENT_DISPLAY_PORTLETID, PortletRequest.RENDER_PHASE);

		portletURL.setParameter("announcementId", String.valueOf(_announcement.getAnnouncementId()));
		portletURL.setWindowState(windowState);
		
		return portletURL.toString();
	}
	@Override
	public String getDiscussionPath() {
			return "edit_entry_discussion";
	}
	
	@Override
	public String getJspPath(HttpServletRequest request, String template) {
		if (template.equals(TEMPLATE_ABSTRACT) ||
			template.equals(TEMPLATE_FULL_CONTENT)) {

			return 	"/jsp/announcements/asset/" + template + ".jsp";
		}
		else {
			return null;
		}
	}
	
	@Override
	public String getURLViewInContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		String noSuchEntryRedirect) throws WindowStateException, PortalException, SystemException {

		long plid = LayoutConstants.DEFAULT_PLID;
		ThemeDisplay themeDisplay = (ThemeDisplay) liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			 plid = PortalUtil.getPlidFromPortletId(
				_announcement.getGroupId(), PortletKeys.ANNOUNCEMENT_DISPLAY_PORTLETID );
		}
		catch (PortalException e) {
			if (LOGGER.isDebugEnabled()){
				LOGGER.debug(e);
			}
			LOGGER.info("PortalException: unable to get plid for ANNOUNCEMENT_DISPLAY_PORTLETID");
		}
		catch (SystemException se) {
			if (LOGGER.isDebugEnabled()){
				LOGGER.debug(se);
			}
			LOGGER.info("SystemException: unable to get plid for ANNOUNCEMENT_DISPLAY_PORTLETID");
		}
		
		if (plid == LayoutConstants.DEFAULT_PLID) {
			return getURLView(liferayPortletResponse, LiferayWindowState.POP_UP).toString();
		}

		PortletURL portletURL = PortletURLFactoryUtil.create(
			liferayPortletRequest, PortletKeys.ANNOUNCEMENT_DISPLAY_PORTLETID, plid,
			PortletRequest.RENDER_PHASE);

		portletURL.setParameter(
			"announcementId", String.valueOf(_announcement.getAnnouncementId()));
		portletURL.setWindowState(LiferayWindowState.NORMAL);
		
		portletURL.setParameter("redirect",PortalUtil.getLayoutFullURL(themeDisplay));

		return portletURL.toString();
	}

	private Announcement _announcement;


	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String summary = _announcement.getContent(themeDisplay.getLocale());

		return HtmlUtil.stripHtml(StringUtil.shorten(HtmlUtil.stripHtml(summary), 200));
	}

	@Override
	public boolean include(HttpServletRequest request, HttpServletResponse response, String template) throws Exception {

		if (template.equals(TEMPLATE_FULL_CONTENT) || template.equals(TEMPLATE_ABSTRACT)) {
			
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Locale locale = themeDisplay.getLocale();
			List<AnnouncementImage> announcementImages = _announcement.getImages();
			String content  = _announcement.getContent(locale);
			
			request.setAttribute("announcementImages", announcementImages);			
			request.setAttribute("announcement", _announcement);
			request.setAttribute("content", content);
			
		}
		return super.include(request, response, template);
	}

	@Override
	public Announcement getAssetObject() {
		return _announcement;
	}
	
}
