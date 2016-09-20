<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@include file="/jsp/init.jsp" %>

<liferay-portlet:renderURL var="countriesUrl" plid="<%= themeDisplay.getPlid() %>" portletName="countryconfiguration_WAR_Hexiagonportlet" windowState="<%=  WindowState.NORMAL.toString() %>"/>

<liferay-ui:header
	backURL='${countriesUrl}'
	title='${countryName} Regions'
/>

<liferay-ui:success key="region-added" message="annoucements.region.success.added" />
<liferay-ui:success key="region-updated" message="annoucements.region.success.updated" />
<liferay-ui:success key="region-updated-active" message="annoucements.region.success.update.active" />

<liferay-ui:error key="region-error" message="annoucements.region.errors" />

<liferay-portlet:renderURL var="regionURL" plid="<%= themeDisplay.getPlid() %>" portletName="regionsconfiguration_WAR_Hexiagonportlet" windowState="<%=  WindowState.NORMAL.toString() %>">
	<portlet:param name="countryId" value="${countryId}"/>
</liferay-portlet:renderURL>

<aui:nav-bar cssClass="label-info">
	<aui:nav >
		<portlet:renderURL var="addRegionURL">
			<portlet:param name="redirect" value="<%= regionURL.toString() %>" />
			<portlet:param name="jspPage" value="/jsp/regions/configuration/edit.jsp"/>
			<portlet:param name="countryId" value="${countryId}"/>
	    </portlet:renderURL>
		<aui:nav-item href="${addRegionURL}" iconCssClass="icon-plus" label="annoucements.regions.add.label" />
	</aui:nav>
</aui:nav-bar>

<liferay-ui:search-container  searchContainer="${searchRegionsContainer}" id="regions">
	<liferay-ui:search-container-results
		results="${searchRegionsContainer.results}"
		total="${searchRegionsContainer.total}" 
	/>
	
	<liferay-ui:search-container-row 
		className="com.liferay.portal.model.Region"
		keyProperty="regionId"
		modelVar="region" escapedModel="true"
	>
		<liferay-ui:search-container-column-text
			property="regionCode"
		/>
		
		<liferay-ui:search-container-column-text
			property="name"
		/>
		
		<liferay-ui:search-container-column-text
			property="active"
		/>

		<liferay-ui:search-container-column-jsp
				align="right"
 				name="actions"
				path="/jsp/regions/configuration/actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="true" searchContainer="${searchRegionsContainer}"/>
</liferay-ui:search-container>