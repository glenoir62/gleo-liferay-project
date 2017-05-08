<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.service.PortletLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Portlet"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@include file="/jsp/init.jsp" %>

<%
String redirect = request.getParameter("redirect");

redirect = PortalUtil.escapeRedirect(redirect);

Portlet selPortlet = PortletLocalServiceUtil.getPortletById(company.getCompanyId(), portletDisplay.getId());

%>

<aui:script use="aui-base">
	Liferay.fire(
		'closeWindow',
		{
			id: '<portlet:namespace />editAnnouncement',
			portletAjaxable: <%= selPortlet.isAjaxable() %>,

			<c:choose>
				<c:when test="<%= redirect != null %>">
					redirect: '<%= HtmlUtil.escapeJS(redirect) %>'
				</c:when>
				<c:otherwise>
					refresh: '<%= portletDisplay.getId() %>'
				</c:otherwise>
			</c:choose>
		}
	);
</aui:script>