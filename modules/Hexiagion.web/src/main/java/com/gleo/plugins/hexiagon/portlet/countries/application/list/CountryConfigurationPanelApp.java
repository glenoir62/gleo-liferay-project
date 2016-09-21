package com.gleo.plugins.hexiagon.portlet.countries.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"panel.app.order:Integer=500",
			"panel.category.key=" + PanelCategoryKeys.CONTROL_PANEL_CONFIGURATION
		},
		service = PanelApp.class
	)
public class CountryConfigurationPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return "com_gleo_plugins_hexiagon_portlet_regions_web_RegionsConfigurationPortlet";
	}
	
	@Override
	public boolean isShow(PermissionChecker permissionChecker, Group group) {
		return permissionChecker.isOmniadmin();
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=com_gleo_plugins_hexiagon_portlet_regions_web_RegionsConfigurationPortlet)",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}
}
