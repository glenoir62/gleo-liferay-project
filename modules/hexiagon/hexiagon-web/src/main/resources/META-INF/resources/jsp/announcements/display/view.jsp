
<%@page import="javax.portlet.PortletMode"%>
<%@page import="com.gleo.plugins.hexiagon.constants.PortletKeys"%>
<%@page import="com.gleo.plugins.hexiagon.model.Announcement"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.security.auth.PrincipalException"%>
<%@page import="com.gleo.plugins.hexiagon.exception.NoSuchAnnouncementException"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="javax.portlet.WindowState"%>

<%@page import="javax.portlet.WindowState"%>
<%@include file="/jsp/init.jsp" %>

<liferay-ui:header
	backURL='<%= ParamUtil.getString(renderRequest, "redirect") %>'
	title='${announcement.getTitle(locale)}'
/>

<liferay-ui:success key="announcement-added" message="annoucements.display.success.added"/>
<liferay-ui:success key="announcement-updated" message="annoucements.display.success.updated"/>
<liferay-ui:success key="announcement-deleted" message="annoucements.display.success.deleted"/>

<liferay-ui:error key="announcement-errors" message="annoucements.display.errors" />

<liferay-ui:error exception="<%= NoSuchAnnouncementException.class %>" message="annoucements.display.errors.no.announcement" />
<liferay-ui:error exception="<%= PrincipalException.class %>" message="you-do-not-have-the-required-permissions" />

<c:if test="${announcement.userId > 0}">

	<c:if test="${hasEditRight}">
		<aui:nav-bar>
			<c:if test="${hasEditRight}">
				<aui:nav>
					<aui:nav-item id="edit${announcement.announcementId}" iconCssClass="icon-edit" label="annoucements.display.edit.label" />
				</aui:nav>
			</c:if>
			
			<c:if test="${hasDeleteRigth}">
				<aui:nav>
					
					<liferay-portlet:actionURL portletName="<%= PortletKeys.ADD_ANNOUNCEMENT_PORTLETID %>" var="deleteURL"
					    varImpl="deleteAnnouncement" name="deleteAnnouncement" 
					    plid="${addAnnouncementPlid}"
						portletMode="<%= PortletMode.VIEW.toString() %>"
						windowState="<%= LiferayWindowState.NORMAL.toString() %>">
						<portlet:param name="announcementId" value="${announcement.announcementId}" />
						<portlet:param name="redirect" value='<%= ParamUtil.getString(renderRequest, "redirect")  %>'/>
					</liferay-portlet:actionURL>
				
					<aui:nav-item href="${deleteURL}" iconCssClass="icon-remove" label="annoucements.display.delete.label" id="deleteAnnouncement${announcement.announcementId}"/>
				</aui:nav>
			</c:if>
			
			<c:if test="<%= PortalUtil.isOmniadmin(themeDisplay.getUserId()) %>">
				<aui:nav>
					<liferay-security:permissionsURL
					modelResource="<%= Announcement.class.getName() %>"
					modelResourceDescription="${announcement.getTitle(locale)}"
					resourcePrimKey="${announcement.announcementId}"
					windowState="<%= LiferayWindowState.POP_UP.toString() %>"
					var="permissionsURL"
					/>
					
				
					<aui:nav-item href="${permissionsURL}" iconCssClass="icon-pencil" label="annoucements.display.permission.label" useDialog="true" title="permissions"/>
				</aui:nav>
			</c:if>
			
			
		</aui:nav-bar>
	</c:if>
	
	<br>
	<liferay-util:include page="/jsp/announcements/asset/full_content.jsp" servletContext="<%= application %>">
	</liferay-util:include>
	
	<br>
	
	<aui:container>
		<aui:row>
			<portlet:actionURL name="invokeTaglibDiscussion" var="discussionURL" >
				<portlet:param name="announcementId" value="${announcement.announcementId}"/>
			</portlet:actionURL>
			
			<liferay-ui:discussion
				subject="${announcement.getTitle(locale)}"
				className="<%= Announcement.class.getName() %>"
				classPK="${announcement.announcementId}"
				formAction="${discussionURL}"
				formName="fm2"
				userId="${themeDisplay.getUserId()}"
			/>
		</aui:row>
	</aui:container>
	
	<c:if test="${hasEditRight}">
		<aui:script use="aui-base">
			A.one('#<portlet:namespace/>deleteAnnouncement${announcement.announcementId}').on('click', function (event) {
	       		return confirm('<liferay-ui:message key="are-you-sure-you-want-to-delete-this-entry"/>') ? true : event.preventDefault();
	    	});
	    	
	    	A.one('#<portlet:namespace/>edit${announcement.announcementId}').on('click', function (event) {
				Liferay.Util.openWindow(
					{
						id: '${renderResponse.getNamespace()}editAnnouncement',
						title: '${titlePopUp}',
						uri:'${uriPopUp}',
						dialog:{
								destroyOnHide: true,
								width: '60%',
								height: '100%'
						}
					}
				);
			});
		</aui:script>
	</c:if>
	
</c:if>