<%@page import="com.gleo.modules.ravenbox.model.Announcement"%>
<%@ include file="/init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Announcement announcement = (Announcement) row.getObject();

	long annoucementId = announcement.getAnnouncementId();

	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>


<liferay-ui:icon-menu direction="left-side" markupView="lexicon">
 	<c:if test="<%= AnnouncementPermission.contains(permissionChecker, annoucementId, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editAnnouncementURL">
			<portlet:param name="mvcRenderCommandName" value="/announcements/edit" />
			<portlet:param name="redirect" value="<%= renderResponse.createRenderURL().toString() %>" />
			<portlet:param name="announcementId" value="<%= String.valueOf(annoucementId) %>"/>
		</portlet:renderURL>
		
		<liferay-ui:icon
			message="edit"
			url="<%= editAnnouncementURL %>"
		/>
	</c:if>

	<c:if test="<%= AnnouncementPermission.contains(permissionChecker, typeId, ActionKeys.DELETE) %>">
		<portlet:actionURL var="deleteURL" name="/announcements/delete_announcement">
			<portlet:param name="announcementId" value="<%= String.valueOf(annoucementId) %>" />
			<portlet:param name="redirect" value="<%= renderResponse.createRenderURL().toString() %>"/>
		</portlet:actionURL>
		
		<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
		
	</c:if>
	
	<c:if test="<%=  AnnouncementPermission.contains(permissionChecker, typeId, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= Announcement.class.getName() %>"
			modelResourceDescription="<%= announcement.getTitle(locale) %>"
			resourcePrimKey="<%= String.valueOf(annoucementId) %>"
			windowState="<%= LiferayWindowState.POP_UP.toString() %>"
			var="permissionsURL" />

		<liferay-ui:icon
			message="permissions"
			method="get"
			url="<%= permissionsURL %>"
			useDialog="<%= true %>"
		/>
	</c:if>
</liferay-ui:icon-menu>