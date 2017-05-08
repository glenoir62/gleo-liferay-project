<%@page import="com.gleo.plugins.hexiagon.constants.PortletKeys"%>
<%@page import="com.gleo.plugins.hexiagon.permission.HexiagonPermission"%>
<%@include file="/jsp/init.jsp" %>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>

<liferay-ui:success key="announcement-added" message="annoucements.search.success.added" />
<liferay-ui:success key="announcement-updated" message="annoucements.search.success.updated" />
<liferay-ui:success key="announcement-deleted" message="annoucements.search.success.deleted" />

<liferay-ui:error key="announcement-errors" message="announcement-errors" />

<c:if test='<%= HexiagonPermission.contains(permissionChecker, themeDisplay.getScopeGroupId(), "ADD_ANNOUNCEMENT") %>'>
	<aui:nav-bar cssClass="label-info">
		<aui:nav >
			<liferay-portlet:renderURL portletName="<%= PortletKeys.ADD_ANNOUNCEMENT_PORTLETID %>" var="addAnnouncementURL"
				    varImpl="addAnnouncementURL"
					portletMode="<%= PortletMode.VIEW.toString() %>"
					windowState="<%= LiferayWindowState.POP_UP.toString() %>">
				<portlet:param name="redirect" value="${redirectURLPortlet}"/>
			</liferay-portlet:renderURL>

			<aui:nav-item href="${addAnnouncementURL}" useDialog="true" iconCssClass="icon-plus" label="annoucements.search.add.button.announcement" id="editAnnouncement" />
			
		</aui:nav>
	</aui:nav-bar>
</c:if>

<liferay-ui:search-container  searchContainer="${searchAnnouncementContainer}" var="searchAnnouncementContainer">
	<liferay-ui:search-container-results
		results="${searchAnnouncementContainer.results}"
		total="${searchAnnouncementContainer.total}"
	/>

	<aui:input name="tabs1" type="hidden" value="announcement" />
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

<%--
<aui:script use="aui-base">
	
	Liferay.provide(window,'<portlet:namespace />openDialog',function(event) {
		event.preventDefault();

		var currentTarget = event.currentTarget;

		var config = currentTarget.getData();
		
		if (!config.uri) {
			config.uri = currentTarget.getData('href') || currentTarget.attr('href');
		}

		if (!config.title) {
			config.title = currentTarget.attr('title');
		}
		
		config.dialog = {
				destroyOnHide: true,
				width: '60%'
			};
		

		Liferay.Util.openWindow(config);
	});
	
	Liferay.delegateClick('<portlet:namespace/>addAnnouncement', function(event) {
		<portlet:namespace />openDialog(event);
	});
		
</aui:script>
--%>