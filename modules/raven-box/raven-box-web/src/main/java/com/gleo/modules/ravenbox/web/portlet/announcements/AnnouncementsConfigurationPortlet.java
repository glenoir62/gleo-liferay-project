package com.gleo.modules.ravenbox.web.portlet.announcements;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.gleo.modules.ravenbox.model.Announcement;
import com.gleo.modules.ravenbox.service.AnnouncementServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author guillaumelenoir
 *
 */
@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.css-class-wrapper=announcements-configuration-portlet",
			"com.liferay.portlet.display-category=category.hidden",
			"com.liferay.portlet.icon=/ravenbox/icons/icon.png",
			"com.liferay.portlet.render-weight=50",
			"com.liferay.portlet.scopeable=true",
			"com.liferay.portlet.use-default-template=true",
			"com.liferay.portlet.add-default-resource=true",
			"javax.portlet.display-name=Announcements configuration",
			"javax.portlet.expiration-cache=0",
			"javax.portlet.init-param.always-display-default-configuration-icons=true",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/ravenbox/announcements/configuration/view.jsp",
			"javax.portlet.name=" + RavenBoxPortletKeys.ANNOUNCEMENTS_CONFIGURATION,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user",
			"javax.portlet.supports.mime-type=text/html" 
		},
		service = Portlet.class)
public class AnnouncementsConfigurationPortlet extends MVCPortlet {


}
