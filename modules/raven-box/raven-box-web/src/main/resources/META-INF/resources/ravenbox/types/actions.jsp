<%@ include file="/init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Type type = (Type) row.getObject();

	long typeId = type.getTypeId();

	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>


<liferay-ui:icon-menu direction="left-side" markupView="lexicon">
	<c:if test="<%= TypePermission.contains(permissionChecker, typeId, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editTypeURL">
			<portlet:param name="mvcRenderCommandName" value="/types/edit" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="typeId" value="<%= String.valueOf(typeId) %>"/>
		</portlet:renderURL>
		
		<liferay-ui:icon
			message="edit"
			url="<%= editTypeURL %>"
		/>
	</c:if>

	<c:if test="<%= TypePermission.contains(permissionChecker, typeId, ActionKeys.DELETE) %>">
		<portlet:actionURL var="deleteURL" name="/types/delete_type">
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