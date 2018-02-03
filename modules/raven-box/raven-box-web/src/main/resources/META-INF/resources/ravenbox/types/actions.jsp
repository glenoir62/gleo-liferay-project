<%@ include file="/init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Type type = (Type) row.getObject();

	long typeId = type.getTypeId();

	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu direction="left-side" markupView="lexicon">
	<c:if test="<%= TypePermission.contains(permissionChecker, typeId, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editURL">
			<portlet:param name="typeId" value="<%= String.valueOf(typeId) %>"/>
			<portlet:param name="jspPage" value="/jsp/types/edit.jsp"/>
			<portlet:param name="redirect" value="<%= redirect %>"/>
		</portlet:renderURL>
		
		<liferay-ui:icon image="edit" url="<%= editURL.toString() %>" />
	</c:if>

	<c:if test="<%= TypePermission.contains(permissionChecker, typeId, ActionKeys.DELETE) %>">
		<portlet:actionURL var="deleteURL" name="deleteType">
			<portlet:param name="typeId" value="<%= String.valueOf(typeId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>"/>
		</portlet:actionURL>
		
		<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
	</c:if>
	
	<c:if test="<%=  TypePermission.contains(permissionChecker, typeId, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= Type.class.getName() %>"
			modelResourceDescription="<%= type.getName(locale) %>"
			resourcePrimKey="<%= String.valueOf(typeId) %>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
	</c:if>
</liferay-ui:icon-menu>