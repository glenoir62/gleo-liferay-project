
package com.gleo.modules.ravenbox.web.portlet.announcements.workflow;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.gleo.modules.ravenbox.model.Announcement;
import com.gleo.modules.ravenbox.service.AnnouncementLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;

/**
 * @author guillaumelenoir
 * Announcement workflow handler
 */
@Component(
	    property = {"model.class.name=com.gleo.modules.ravenbox.model.Announcement"},
	    service = WorkflowHandler.class
	)
public class AnnouncementWorkflowHandler extends BaseWorkflowHandler<Announcement> {

	/**
	 * Get className
	 * 
	 * @return classname
	 */
	public String getClassName() {

		return CLASS_NAME;
	}

	/**
	 * Get Type
	 * 
	 * @param locale
	 * @return type
	 */
	public String getType(Locale locale) {

		return LanguageUtil.get(locale, "model.resource." + CLASS_NAME);

	}

	/**
	 * Update status
	 * 
	 * @param status
	 * @param workflowContext
	 * @return announcement updated
	 * @throws PortalException
	 * @throws SystemException
	 */
	public Announcement updateStatus(int status, Map<String, Serializable> workflowContext)
		throws PortalException, SystemException {

		long userId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		long resourcePrimKey = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		ServiceContext serviceContext = (ServiceContext) workflowContext.get("serviceContext");

		return announcementLocalService.updateStatus(userId, resourcePrimKey, status, serviceContext);
	}

	@Reference
	protected void setAnnouncementLocalService(
			AnnouncementLocalService announcementLocalService) {
		this.announcementLocalService = announcementLocalService;
	}

	private AnnouncementLocalService announcementLocalService;
	
	/**
	 * Classname
	 */
	public static final String CLASS_NAME = Announcement.class.getName();

}
