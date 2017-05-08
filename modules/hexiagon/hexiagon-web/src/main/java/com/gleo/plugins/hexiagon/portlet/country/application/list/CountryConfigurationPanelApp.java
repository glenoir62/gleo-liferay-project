package com.gleo.plugins.hexiagon.portlet.country.application.list;

import com.gleo.plugins.hexiagon.constants.PortletKeys;
import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author guillaumelenoir
 *
 */
@Component(
		immediate = true,
		property = {
			"panel.app.order:Integer=500",
			"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
		},
		service = PanelApp.class
	)
public class CountryConfigurationPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return PortletKeys.HEXIAGON_CURRENCY_CONFIGURATION;
	}
	
	@Override
	public boolean isShow(PermissionChecker permissionChecker, Group group) {
		return permissionChecker.isOmniadmin();
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + PortletKeys.HEXIAGON_CURRENCY_CONFIGURATION + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}
	
}