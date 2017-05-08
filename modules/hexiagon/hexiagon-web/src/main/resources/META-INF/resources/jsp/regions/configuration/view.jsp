<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@include file="/jsp/init.jsp" %>
<%
	renderResponse.setTitle(renderRequest.getAttribute("countryName") + " Regions");
%>
<liferay-ui:success key="region-updated-active" message="annoucements.region.success.update.active" />

<liferay-ui:error key="region-error" message="annoucements.region.errors" />

<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav cssClass="navbar-nav">
		<portlet:renderURL var="addRegionURL">
			<portlet:param name="redirect" value="${redirect}" />
			<portlet:param name="jspPage" value="/jsp/regions/configuration/edit.jsp"/>
			<portlet:param name="countryId" value="${countryId}"/>
	    </portlet:renderURL>
		<aui:nav-item href="${addRegionURL}" iconCssClass="icon-plus" label="annoucements.regions.add.label" />
	</aui:nav>
</aui:nav-bar>

<liferay-ui:search-container  searchContainer="${searchRegionsContainer}" id="regions">
	<liferay-ui:search-container-results
		results="${searchRegionsContainer.results}"
	/>
	
	<liferay-ui:search-container-row 
		className="com.liferay.portal.kernel.model.Region"
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

	<liferay-ui:search-iterator markupView="lexicon" paginate="true" searchContainer="${searchRegionsContainer}"/>
</liferay-ui:search-container>