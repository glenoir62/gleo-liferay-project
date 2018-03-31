<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ include file="/init.jsp" %>

<liferay-ui:success key="announcement-added" message="com.gleo.modules.ravenbox.announcement.success.added" />
<liferay-ui:success key="announcement-updated" message="com.gleo.modules.ravenbox.announcement.success.updated" />
<liferay-ui:success key="announcement-deleted" message="com.gleo.modules.ravenbox.announcement.success.deleted" />

<liferay-ui:error key="no-announcement-deleted" message="com.gleo.modules.ravenbox.announcement.errors.announcement.deleted.unsuccessfully" />

<portlet:renderURL var="addEntryURL">
		<portlet:param name="mvcRenderCommandName" value="/types/edit" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:renderURL>
		
<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav cssClass="navbar-nav">
		<aui:nav-item label="com.gleo.modules.ravenbox.announcement.title" selected="<%= true %>" />
	</aui:nav>
	
	<aui:nav-bar-search>
		<aui:form action="" name="searchFm">
			<liferay-ui:input-search markupView="lexicon" />
		</aui:form>
	</aui:nav-bar-search>
</aui:nav-bar>

<liferay-frontend:management-bar
	includeCheckBox="<%= true %>"
	searchContainerId="userGroups"
>
	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:management-bar-display-buttons
			displayViews='<%= new String[] {"descriptive", "icon", "list"} %>'
			portletURL="<%= renderResponse.createRenderURL() %>"
			selectedDisplayStyle=""
		/>
	</liferay-frontend:management-bar-buttons>

	<liferay-frontend:management-bar-filters>
		<liferay-frontend:management-bar-navigation
			navigationKeys='<%= new String[] {"all"} %>'
			portletURL="<%= renderResponse.createRenderURL() %>"
		/>

		<liferay-frontend:management-bar-sort
			orderByCol=""
			orderByType=""
			orderColumns='<%= new String[] {"name"} %>'
			portletURL="<%= renderResponse.createRenderURL() %>"
		/>
	</liferay-frontend:management-bar-filters>

	<c:if test='<%= RavenBoxPermission.contains(permissionChecker, themeDisplay.getScopeGroupId(), "ADD_TYPE") %>'>
		<liferay-frontend:add-menu>
			<liferay-frontend:add-menu-item title='<%= LanguageUtil.get(request, "com.gleo.modules.ravenbox.announcement.add") %>' url="<%= addEntryURL %>" />
		</liferay-frontend:add-menu>
	</c:if>
</liferay-frontend:management-bar>

<div id="breadcrumb">
	<liferay-ui:breadcrumb showCurrentGroup="<%= false %>" showGuestGroup="<%= false %>" showLayout="<%= false %>" showPortletBreadcrumb="<%= true %>" />
</div>

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
		
			<liferay-ui:search-container-column-text>
				<aui:input name="announcementIds" announcement="hidden" value="${announcement.announcementId}"> 
				</aui:input>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text
				name="name"
				value="${announcement.getName(locale)}"
			/>
			
			<liferay-ui:search-container-column-jsp
				align="right"
				name="actions"
				path="/ravenbox/announcements/configuration/actions.jsp"
			/>
		</liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator paginate="true" markupView="lexicon" searchContainer="${searchAnnouncementContainer}"/>
	</liferay-ui:search-container>
</aui:form>
