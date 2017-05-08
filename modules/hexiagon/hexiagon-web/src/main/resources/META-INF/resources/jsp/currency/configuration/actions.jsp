<%@page import="com.gleo.plugins.hexiagon.model.Currency"%>
<%@page import="com.liferay.portal.kernel.security.permission.ActionKeys"%>
<%@page import="com.gleo.plugins.hexiagon.permission.CurrencyPermission"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="/jsp/init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Currency currency = (Currency) row.getObject();

	long currencyId = currency.getCurrencyId();

	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu>
	<c:if test="<%= CurrencyPermission.contains(permissionChecker, currencyId, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editURL">
			<portlet:param name="currencyId" value="<%= String.valueOf(currencyId) %>"/>
			<portlet:param name="jspPage" value="/jsp/currencies/edit.jsp"/>
			<portlet:param name="redirect" value="<%= redirect %>"/>
		</portlet:renderURL>
		
		<liferay-ui:icon image="edit" url="<%= editURL.toString() %>" />
	</c:if>

	<c:if test="<%= CurrencyPermission.contains(permissionChecker, currencyId, ActionKeys.DELETE) %>">
		<portlet:actionURL var="deleteURL" name="deleteCurrency">
			<portlet:param name="currencyId" value="<%= String.valueOf(currencyId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>"/>
		</portlet:actionURL>
		
		<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
	</c:if>
	
	<c:if test="<%=  CurrencyPermission.contains(permissionChecker, currencyId, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= Currency.class.getName() %>"
			modelResourceDescription="<%= currency.getLabel() %>"
			resourcePrimKey="<%= String.valueOf(currencyId) %>"
			var="permissionsURL" />

		<liferay-ui:icon image="permissions" url="<%= permissionsURL %>" />
	</c:if>
</liferay-ui:icon-menu>