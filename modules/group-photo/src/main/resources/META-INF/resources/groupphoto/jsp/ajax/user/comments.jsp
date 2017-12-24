
<%
User selUser = (User)request.getAttribute("user.selUser");
%>

<c:if test="<%= Validator.isNotNull(selUser.getComments()) %>">
	<h3 class="icon-comment"><liferay-ui:message key="comments" /></h3>

	<%= MBUtil.getBBCodeHTML(selUser.getComments(), themeDisplay.getPathThemeImages()) %>
</c:if>