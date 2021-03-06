
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.model.Region"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@include file="/jsp/init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Region region = (Region) row.getObject();

	boolean isActive = region.getActive();
	String label = isActive?"desactive":"active";
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>
		
<liferay-ui:icon-menu direction="left-side" markupView="lexicon">
	<c:if test="${themeDisplay.getPermissionChecker().isOmniadmin()}">
		<portlet:renderURL var="editURL">
			<portlet:param name="regionId" value="<%= String.valueOf(region.getRegionId()) %>"/>
			<portlet:param name="jspPage" value="/jsp/regions/configuration/edit.jsp"/>
			<portlet:param name="redirect" value="<%= redirect %>"/>
		</portlet:renderURL>
		
		<liferay-ui:icon image="edit" url="<%= editURL.toString() %>" />
		
		<portlet:actionURL var="activateURL" name="activateRegion">
			<portlet:param name="regionId" value="<%= String.valueOf(region.getRegionId()) %>"/>
			<portlet:param name="isActive" value="<%= String.valueOf(isActive) %>" />
			<portlet:param name="redirect" value="<%= redirect %>"/>
		</portlet:actionURL>
		
		<liferay-ui:icon image='<%= isActive?"delete":"check" %>' message='<%= isActive?"desactivate":"activate" %>' label='true' url="<%= activateURL.toString() %>" />
		
	</c:if>
	
</liferay-ui:icon-menu>