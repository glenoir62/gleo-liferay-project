package com.gleo.plugins.hexiagon.portlet.announcements.asset;

import com.gleo.plugins.hexiagon.constants.PortletKeys;
import com.gleo.plugins.hexiagon.model.Announcement;
import com.gleo.plugins.hexiagon.permission.AnnouncementPermission;
import com.gleo.plugins.hexiagon.permission.HexiagonPermission;
import com.gleo.plugins.hexiagon.service.AnnouncementLocalServiceUtil;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletURL;


/**
 * @author guillaumelenoir
 * Announcement Asset Renderer Factory
 */
public class AnnouncementAssetRendererFactory extends BaseAssetRendererFactory<Announcement> {

	public static final String CLASS_NAME = Announcement.class.getName();

	public static final String TYPE = "announcement";

	
	@Override
	public AssetRenderer<Announcement> getAssetRenderer(long classPK, int type)
		throws PortalException, SystemException {

		Announcement announcement = AnnouncementLocalServiceUtil.getAnnouncement(classPK);

		return new AnnouncementAssetRenderer(announcement);
	}
	
	@Override
	public AssetRenderer<Announcement> getAssetRenderer(long classPK)
		throws PortalException, SystemException {

		Announcement announcement = AnnouncementLocalServiceUtil.getAnnouncement(classPK);

		return new AnnouncementAssetRenderer(announcement);
	}
	
	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public String getType() {
		return TYPE;
	}
	
	@Override
	public boolean isLinkable() {
		return _LINKABLE;
	}
	
	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, long classPK, String actionId)
		throws Exception {

		return  AnnouncementPermission.contains(permissionChecker, classPK, actionId);
	}
	

	@Override
	public PortletURL getURLAdd(LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse)
		throws PortalException, SystemException {

		ThemeDisplay themeDisplay =
						(ThemeDisplay)liferayPortletRequest.getAttribute(
							WebKeys.THEME_DISPLAY);

		if (!HexiagonPermission.contains(
				themeDisplay.getPermissionChecker(),
				themeDisplay.getScopeGroupId(), "ADD_ANNOUNCEMENT")) {

			return null;
		}

		PortletURL portletURL = liferayPortletResponse.createRenderURL(
			PortletKeys.ADD_ANNOUNCEMENT_PORTLETID);

		return portletURL;
	}



	private static final boolean _LINKABLE = true;
}
