package com.gleo.plugins.hexiagon.portlet.announcements.web;

import com.gleo.plugins.hexiagon.constants.PortletKeys;
import com.gleo.plugins.hexiagon.exception.NoSuchAnnouncementException;
import com.gleo.plugins.hexiagon.model.Announcement;
import com.gleo.plugins.hexiagon.model.AnnouncementImage;
import com.gleo.plugins.hexiagon.permission.AnnouncementPermission;
import com.gleo.plugins.hexiagon.service.AnnouncementServiceUtil;
import com.gleo.plugins.hexiagon.util.PortalUtil;
import com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author guillaumelenoir
 * Portlet implementation class AnnouncementDisplayPortlet
 * 
 */
public class AnnouncementDisplayPortlet extends MVCPortlet {

	/**
	 * AnnouncementViewController Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(AnnouncementDisplayPortlet.class);

	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		long announcementId = ParamUtil.getLong(renderRequest,"announcementId");
		Announcement announcement = null;
		String content = StringPool.BLANK;
		boolean hasEditRight = false;
		boolean hasDeleteRigth = false;
		boolean hasPermissionRight = false;

		if (announcementId > 0) {
			try {
				
				//Increment view
				AssetEntryLocalServiceUtil.incrementViewCounter(themeDisplay.getUserId(), Announcement.class.getName(), announcementId);
				
				//Get announcement
				announcement = AnnouncementServiceUtil.getAnnouncement(announcementId);
				List<AnnouncementImage> announcementImages = announcement.getImages();
				content  = announcement.getContent(locale);
				hasEditRight = AnnouncementPermission.contains(themeDisplay.getPermissionChecker(), announcementId, ActionKeys.UPDATE);
				hasDeleteRigth = AnnouncementPermission.contains(themeDisplay.getPermissionChecker(), announcementId, ActionKeys.DELETE);
				hasPermissionRight = AnnouncementPermission.contains(themeDisplay.getPermissionChecker(), announcementId, ActionKeys.PERMISSIONS);

				AssetRendererFactory<?> assetRendererFactory = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(Announcement.class.getName());
				AssetRenderer<?> assetRenderer = assetRendererFactory.getAssetRenderer(announcementId);
				
				PortletURL redirectURL = PortalUtil.getLiferayPortletResponse(renderResponse).createLiferayPortletURL(themeDisplay.getPlid(), PortletKeys.ANNOUNCEMENT_DISPLAY_PORTLETID, PortletRequest.RENDER_PHASE, false);
				redirectURL.setParameter("redirect", themeDisplay.getURLCurrent());
				redirectURL.setParameter("jspPage", "/jsp/announcements/display/update_announcement_redirect.jsp");
				redirectURL.setWindowState(LiferayWindowState.POP_UP);
				
				PortletURL editPortletURL = assetRenderer.getURLEdit(PortalUtil.getLiferayPortletRequest(renderRequest), PortalUtil.getLiferayPortletResponse(renderResponse), LiferayWindowState.POP_UP, redirectURL);
				
				String titlePopUp = LanguageUtil.format(themeDisplay.getLocale(), "edit-x", HtmlUtil.escape(assetRenderer.getTitle(locale)));
				String uriPopUp = HtmlUtil.escapeJS(editPortletURL.toString());
				
				renderRequest.setAttribute("titlePopUp", titlePopUp);
				renderRequest.setAttribute("uriPopUp", uriPopUp);
				renderRequest.setAttribute("announcementImages", announcementImages);
				renderRequest.setAttribute("hasEditRight", hasEditRight);
				renderRequest.setAttribute("hasDeleteRigth", hasDeleteRigth);
				renderRequest.setAttribute("hasPermissionRight", hasPermissionRight);
			}
			catch (PrincipalException pe) {
				SessionErrors.add(renderRequest, PrincipalException.class);
			}
			catch (PortalException e) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(e.getMessage());
				}
				LOGGER.error("PortalException: unable to get announcement id "+announcementId);
			}
			catch (SystemException e) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(e.getMessage());
				}
				LOGGER.error("SystemException: unable to get announcement id "+announcementId);
			}
			catch (Exception e) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(e.getMessage());
				}
				LOGGER.error("Exception: unable to get announcement id "+announcementId);
			}
			
			renderRequest.setAttribute("announcement", announcement);
			renderRequest.setAttribute("content", content);
			
		} else {
			SessionErrors.add(renderRequest, NoSuchAnnouncementException.class);
		}
		super.doView(renderRequest, renderResponse);
	}
}
