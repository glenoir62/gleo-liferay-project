<%@ include file="init.jsp" %>

<portlet:renderURL var="searchURL">
	<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(renderRequest) %>" />
	<portlet:param name="searchView" value="true" />
</portlet:renderURL>

<aui:form action="${searchURL}" method="post" name="fm">
	<liferay-util:include page="/groupphoto/jsp/toolbar.jsp" servletContext="<%= application %>" />
</aui:form>

<div id="<portlet:namespace />users">
	<liferay-util:include page="/groupphoto/jsp/view_search.jsp" servletContext="<%= application %>" />
</div>