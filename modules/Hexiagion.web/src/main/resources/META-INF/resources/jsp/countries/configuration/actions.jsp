
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.model.Country"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="/jsp/init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Country country = (Country) row.getObject();

	boolean isActive = country.getActive();
	String label = isActive?"desactive":"active";

	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu markupView="lexicon">
	<c:if test="${themeDisplay.getPermissionChecker().isOmniadmin()}">
		<portlet:renderURL var="editURL">
			<portlet:param name="countryId" value="<%= String.valueOf(country.getCountryId()) %>"/>
			<portlet:param name="jspPage" value="/jsp/countries/configuration/edit.jsp"/>
			<portlet:param name="redirect" value="<%= redirect %>"/>
		</portlet:renderURL>
		
		<liferay-ui:icon image="edit" url="<%= editURL.toString() %>" markupView="lexicon" />
		
		<liferay-portlet:renderURL var="regionEditURL" windowState="<%=  WindowState.NORMAL.toString() %>">
			<portlet:param name="mvcRenderCommandName" value="/jsp/regions/configuration" />
			<portlet:param name="countryId" value="<%= String.valueOf(country.getCountryId()) %>"/>
			<portlet:param name="redirect" value="<%= redirect %>"/>
		</liferay-portlet:renderURL>
		
		<liferay-ui:icon image="edit" message="edit-regions" url="<%= regionEditURL.toString() %>" markupView="lexicon" />
		
		<portlet:actionURL var="activateURL" name="activateCountry">
			<portlet:param name="countryId" value="<%= String.valueOf(country.getCountryId()) %>"/>
			<portlet:param name="isActive" value="<%= String.valueOf(isActive) %>" />
			<portlet:param name="redirect" value="<%= redirect %>"/>
		</portlet:actionURL>
		
		<liferay-ui:icon image='<%= isActive?"delete":"check" %>' message='<%= isActive?"desactivate":"activate" %>' label='true' url="<%= activateURL.toString() %>" markupView="lexicon" />
		
	</c:if>
	
</liferay-ui:icon-menu>