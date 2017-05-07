package com.example.application.list;

import com.example.constants.TestpanelappPortletKeys;
import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + "control_panel.configuration"
	},
	service = PanelApp.class
)
public class TestpanelappPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return TestpanelappPortletKeys.Testpanelapp;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + TestpanelappPortletKeys.Testpanelapp + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}