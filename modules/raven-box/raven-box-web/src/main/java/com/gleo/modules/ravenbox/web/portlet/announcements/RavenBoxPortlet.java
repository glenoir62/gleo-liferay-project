package com.gleo.modules.ravenbox.web.portlet.announcements;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author guillaumelenoir
 *
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.css-class-wrapper=raven-box-portlet",
		"com.liferay.portlet.display-category=category.ravenbox",
		"com.liferay.portlet.icon=/ravenbox/types/icons/ravenbox.png",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.scopeable=true",
		"com.liferay.portlet.use-default-template=true",
		"com.liferay.portlet.add-default-resource=true",
		"javax.portlet.display-name=Types",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.always-display-default-configuration-icons=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.name=" + RavenBoxPortletKeys.RAVEN_BOX,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class RavenBoxPortlet extends MVCPortlet {
    
}