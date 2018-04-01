
package com.gleo.modules.ravenbox.web.portlet.announcements.search;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import javax.portlet.PortletRequest;

/**
 * @author guillaumelenoir
 */
public class AnnouncementSearchTerms extends AnnouncementDisplayTerms {

    public AnnouncementSearchTerms(PortletRequest portletRequest) {
	super(portletRequest);

	price = ParamUtil.getInteger(portletRequest, PRICE);
	groupId = DAOParamUtil.getLong(portletRequest, GROUP_ID);
	status = ParamUtil.getInteger(
		portletRequest, STATUS, WorkflowConstants.STATUS_APPROVED);
	groupId = ParamUtil.getLong(portletRequest, GROUP_ID);
    }

}
