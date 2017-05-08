<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.asset.kernel.model.AssetRenderer"%>
<%@page import="com.liferay.asset.kernel.AssetRendererFactoryRegistryUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetRendererFactory"%>
<%@page import="com.gleo.plugins.hexiagon.constants.PortletKeys"%>
<%@page import="com.gleo.plugins.hexiagon.model.Announcement"%>
<%@page import="com.gleo.plugins.hexiagon.permission.AnnouncementPermission"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.security.permission.ActionKeys"%>

<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="/jsp/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Announcement announcement = (Announcement)row.getObject();

long groupId = announcement.getGroupId();
long announcementId = announcement.getAnnouncementId();

String redirect = PortalUtil.getCurrentURL(renderRequest);

AssetRendererFactory assetRendererFactory = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(Announcement.class.getName());
AssetRenderer assetRenderer = assetRendererFactory.getAssetRenderer(announcement.getAnnouncementId());

%>

<liferay-ui:icon-menu>

	<c:if test="<%= AnnouncementPermission.contains(permissionChecker, announcementId, ActionKeys.UPDATE) %>">
		
		<liferay-portlet:renderURL portletName="<%= PortletKeys.ADD_ANNOUNCEMENT_PORTLETID %>" var="updateAnnouncementURL"
			    varImpl="updateAnnouncementURL"
			    plid="<%= themeDisplay.getPlid() %>"
				portletMode="<%= PortletMode.VIEW.toString() %>"
				windowState="<%= LiferayWindowState.POP_UP.toString() %>">
				<portlet:param name="announcementId" value="<%= String.valueOf(announcementId) %>"/>
				<portlet:param name="redirect" value="<%= assetRenderer.getURLView(PortalUtil.getLiferayPortletResponse(renderResponse), LiferayWindowState.POP_UP).toString() %>"/>
		</liferay-portlet:renderURL>
		
		<liferay-ui:icon image="edit" url="${updateAnnouncementURL}" useDialog="true"/>
	</c:if>

	<c:if test="<%= AnnouncementPermission.contains(permissionChecker, announcementId, ActionKeys.DELETE) %>">
		
		<liferay-portlet:actionURL var="deleteURL" name="deleteAnnouncement" portletName="<%= PortletKeys.ADD_ANNOUNCEMENT_PORTLETID %>">
			<portlet:param name="announcementId" value="<%= String.valueOf(announcementId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>"/>
		</liferay-portlet:actionURL>
		
		<liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
	</c:if>
	
	<c:if test="<%=  AnnouncementPermission.contains(permissionChecker, announcementId, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= Announcement.class.getName() %>"
			modelResourceDescription="<%= announcement.getTitle(locale) %>"
			resourcePrimKey="<%= String.valueOf(announcementId) %>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
	</c:if>
</liferay-ui:icon-menu>