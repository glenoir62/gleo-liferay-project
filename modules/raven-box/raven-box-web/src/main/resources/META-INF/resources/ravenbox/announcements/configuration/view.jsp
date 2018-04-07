<%@ include file="/init.jsp" %>

<liferay-ui:success key="announcement-added" message="com.gleo.modules.ravenbox.announcement.success.added" />
<liferay-ui:success key="announcement-updated" message="com.gleo.modules.ravenbox.announcement.success.updated" />
<liferay-ui:success key="announcement-deleted" message="com.gleo.modules.ravenbox.announcement.success.deleted" />

<liferay-ui:error key="no-announcement-deleted" message="com.gleo.modules.ravenbox.announcement.errors.announcement.deleted.unsuccessfully" />

<%@ include file="/ravenbox/announcements/configuration/toolbar.jspf" %>

<aui:form action="#" cssClass="container-fluid-1280" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="portletURL" />
	<aui:input name="redirect" type="hidden" value="<%= renderResponse.createRenderURL() %>" />
	<aui:input name="deleteUserGroupIds" type="hidden" />
	
	<liferay-ui:search-container  searchContainer="${searchAnnouncementContainer}" id="types">
	
		<liferay-ui:search-container-row 
			className="com.gleo.modules.ravenbox.model.Announcement"
			keyProperty="announcementId"
			modelVar="announcement" escapedModel="true"
		>	
			
		<c:choose>
			<c:when test='${displayStyle.equals("icon")}'>
				<%@ include file="/ravenbox/announcements/configuration/columns/icon.jspf" %>
			</c:when>
			<c:when test='${displayStyle.equals("descriptive")}'>
				<%@ include file="/ravenbox/announcements/configuration/columns/descriptive.jspf" %>
			</c:when>
			<c:otherwise>
				<%@ include file="/ravenbox/announcements/configuration/columns/list.jspf" %>
			</c:otherwise>
		</c:choose>
		</liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator displayStyle="${displayStyle}" markupView="lexicon"/>
	</liferay-ui:search-container>
</aui:form>
