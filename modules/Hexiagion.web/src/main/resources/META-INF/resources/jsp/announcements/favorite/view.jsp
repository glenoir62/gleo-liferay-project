<%@page import="com.gleo.plugins.hexiagon.constants.PortletKeys"%>
<%@page import="com.gleo.plugins.hexiagon.permission.HexiagonPermission"%>
<%@include file="/jsp/init.jsp" %>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>

<liferay-ui:success key="announcement-added" message="annoucements.favorite.success.added"/>
<liferay-ui:success key="announcement-updated" message="annoucements.favorite.success.updated"/>
<liferay-ui:success key="announcement-deleted" message="annoucements.favorite.success.deleted"/>

<liferay-ui:error key="announcement-errors" message="annoucements.favorite.errors" />

<liferay-ui:search-container  searchContainer="${searchAnnouncementContainer}" var="searchAnnouncementContainer">
	<liferay-ui:search-container-results
		results="${searchAnnouncementContainer.results}"
		total="${searchAnnouncementContainer.total}"
	/>

	<liferay-ui:search-container-row
		className="com.gleo.plugins.hexiagon.model.Announcement"
		keyProperty="announcementId"
		modelVar="announcement" escapedModel="true" 
	>
		<liferay-ui:search-container-column-text
			name="name"
			value="${announcement.getTitle(locale)}"
		/>

		<liferay-ui:search-container-column-text
			name="price"
			property="price"
		/>
		
		<liferay-ui:search-container-column-text
			name="email-address"
			property="emailAddress"
		/>

		<liferay-ui:search-container-column-text
			name="phone-number"
			property="phoneNumber"
		/>
		
		<liferay-ui:search-container-column-text
			name="type"
			value="${announcement.getType().getName(locale)}"
		/>
		
		<liferay-ui:search-container-column-text
			name="status"
			value="${announcement.getStatus(locale)}"
		/>
		
		<liferay-ui:search-container-column-text
			name="country"
			value="${announcement.getCountry(locale)}"
		/>

		<liferay-ui:search-container-column-jsp
			name="actions"
			path="/jsp/announcements/actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="true" searchContainer="${searchAnnouncementContainer}"/>
</liferay-ui:search-container>