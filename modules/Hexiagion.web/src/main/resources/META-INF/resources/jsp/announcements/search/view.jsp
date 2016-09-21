<%@page import="javax.portlet.PortletMode"%>
<%@page import="com.gleo.plugins.hexiagon.constants.PortletKeys"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@include file="/jsp/init.jsp" %>

<liferay-ui:success key="announcement-added" message="announcement-added"/>
<liferay-ui:success key="announcement-updated" message="announcement-updated"/>
<liferay-ui:success key="announcement-deleted" message="announcement-deleted"/>

<liferay-ui:error key="announcement-errors" message="announcement-errors" />

<%-- 
<c:if test="${hasAddRight}">
	<liferay-portlet:renderURL portletName="<%= PortletKeys.ADD_ANNOUNCEMENT_PORTLETID %>" var="addAnnouncementURL"
		    varImpl="addAnnouncementURL"
		    plid="${addAnnouncementPlid}"
			portletMode="<%= PortletMode.VIEW.toString() %>"
			windowState="<%= LiferayWindowState.NORMAL.toString() %>">
			<portlet:param name="redirect" value="<%= themeDisplay.getURLCurrent() %>"/>
	</liferay-portlet:renderURL>
	<aui:row>
		<div class="offset8" >
			<a class="btn btn-info btn-large" href="${addAnnouncementURL}">
	  		<i class="icon-plus-sign icon-large"></i>  <liferay-ui:message key="annoucements.search.button.add.label"/></a>
		</div>
	</aui:row>
</c:if>
--%>

<liferay-util:include page="/jsp/announcements/search/search.jsp" servletContext="<%= application %>" />
