
package com.gleo.modules.ravenbox.web.portlet.announcements.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.Date;

import javax.portlet.PortletRequest;

/**
 * @author guillaumelenoir
 */
public class AnnouncementDisplayTerms extends DisplayTerms {

    /**
     * Modified date
     */
    public static final String MODIFIED_DATE = "modifiedDate";
    
    /**
     * Create date
     */
    public static final String CREATE_DATE = "createDate";
    
    /**
     * Price
     */
    public static final String PRICE = "price";
    
    /**
     * OrganizationId
     */
    public static final String ORGANIZATION_ID = "organizationId";

    /**
     * Status display term
     */
    public static final String STATUS = "status";
    
    /**
     * UserGroupId display term
     */
    public static final String GROUP_ID = "groupId";

    public AnnouncementDisplayTerms(PortletRequest portletRequest) {
	super(portletRequest);

	String statusString = ParamUtil.getString(portletRequest, STATUS);

	if (Validator.isNotNull(statusString)) {
	    status = GetterUtil.getInteger(statusString);
	}

//	modidiedDate = ParamUtil.getDate(portletRequest, MODIFIED_DATE);
//	createDate = ParamUtil.getDate(portletRequest, CREATE_DATE);
	price = ParamUtil.getInteger(portletRequest, PRICE);
	groupId = ParamUtil.getLong(portletRequest, GROUP_ID);
	organizationId = ParamUtil.getLong(portletRequest, ORGANIZATION_ID);
	
    }

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getModidiedDate() {
		return modidiedDate;
	}

	public void setModidiedDate(Date modidiedDate) {
		this.modidiedDate = modidiedDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public boolean isActive() {

		if (status == WorkflowConstants.STATUS_APPROVED) {
			return true;
		} else {
			return false;
		}
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

    protected int price;
    protected Date modidiedDate;
    protected Date createDate;
    protected long organizationId;
    protected int status;
    protected long groupId;

}
