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
				align="right"
				name="actions"
				path="/ravenbox/announcements/configuration/actions.jsp"
			/>
		</liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator paginate="true" markupView="lexicon" searchContainer="${searchAnnouncementContainer}"/>
	</liferay-ui:search-container>
</aui:form>
