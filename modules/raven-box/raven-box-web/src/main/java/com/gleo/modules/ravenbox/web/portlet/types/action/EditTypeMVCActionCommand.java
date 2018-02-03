package com.gleo.modules.ravenbox.web.portlet.types.action;

import javax.portlet.ActionRequest;

import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.gleo.modules.ravenbox.constants.RavenBoxPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

/**
 * @author Julien Luczak
 * 
 */
@Component(
    property = {
        "javax.portlet.name=" + RavenBoxPortletKeys.TYPES,
        "mvc.command.name=/types/edit_type"
    },
    service = MVCActionCommand.class
)
public class EditTypeMVCActionCommand extends BaseMVCActionCommand {
	
	private static Log LOGGER = LogFactoryUtil.getLog(EditTypeMVCActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		LOGGER.info("Edit type"); 

	}

}
