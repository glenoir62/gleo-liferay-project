<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@include file="/jsp/init.jsp" %>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>


<liferay-ui:success key="your-request-completed-successfully" message="your-request-completed-successfully" />
<portlet:actionURL var="saveVocabularyPreferencesURL" windowState="normal" name="saveVocabularyPreferences">
	<portlet:param name="redirect" value='<%=redirect %>'/>
</portlet:actionURL>

<aui:form action="${saveVocabularyPreferencesURL}" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%=redirect %>" />

		<aui:input name="delta" value="${delta}" label="annoucements.search.edit.delta.label"/>
		
		<aui:input type="checkbox" name="isUserAnnouncements" label="annoucements.search.edit.is.user.announcements.label" value="${isUserAnnouncements}" checked="${isUserAnnouncements eq true}"/>

		<aui:input type="checkbox" name="isFavoriteUserAnnouncements" label="annoucements.search.edit.is.user.favorite.announcements.label" value="${isFavoriteUserAnnouncements}" checked="${isFavoriteUserAnnouncements eq true}"/>
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel" onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>