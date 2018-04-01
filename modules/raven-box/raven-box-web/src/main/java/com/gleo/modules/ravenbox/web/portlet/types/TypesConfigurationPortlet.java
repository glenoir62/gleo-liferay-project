package com.gleo.modules.ravenbox.web.portlet.types;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.css-class-wrapper=types-configuration-portlet",
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.icon=/ravenbox/icons/icon.png",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.scopeable=true",
		"com.liferay.portlet.use-default-template=true",
		"com.liferay.portlet.add-default-resource=true",
		"javax.portlet.display-name=Types Configuration",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.always-display-default-configuration-icons=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/ravenbox/types/view.jsp",
		"javax.portlet.name=" + RavenBoxPortletKeys.TYPES_CONFIGURATION,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=administrator",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = Portlet.class
)
public class TypesConfigurationPortlet extends MVCPortlet{
	
}
