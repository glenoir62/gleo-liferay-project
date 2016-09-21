<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@include file="/jsp/init.jsp" %>

<liferay-ui:success key="country-added" message="annoucements.countries.success.added" />
<liferay-ui:success key="country-updated" message="annoucements.countries.success.updated" />
<liferay-ui:success key="country-updated-active" message="annoucements.countries.success.update.active" />

<liferay-ui:error key="country-error" message="annoucements.countries.errors" />

<aui:nav-bar cssClass="label-info">
	<aui:nav >
		<portlet:renderURL var="addCountryURL">
			<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(renderRequest) %>" />
			<portlet:param name="jspPage" value="/jsp/countries/configuration/edit.jsp"/>
	    </portlet:renderURL>
		<aui:nav-item href="${addCountryURL}" iconCssClass="icon-plus" label="annoucements.countries.add.label" />
	</aui:nav>
	
	<aui:nav >
		<portlet:actionURL var="desactivateAllCountryURL" name="desactivateAllCountry">
			<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(renderRequest) %>" />
	    </portlet:actionURL>
		<aui:nav-item href="${desactivateAllCountryURL}" iconCssClass="icon-minus" label="annoucements.countries.desactivate.all.label" />
	</aui:nav>
	<aui:nav >
		<portlet:actionURL var="activateAllCountryURL" name="activateAllCountry">
			<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(renderRequest) %>" />
	    </portlet:actionURL>
		<aui:nav-item href="${activateAllCountryURL}" iconCssClass="icon-plus" label="annoucements.countries.activate.all.label" />
	</aui:nav>
</aui:nav-bar>

<liferay-ui:search-container  searchContainer="${searchCountryContainer}" id="countries">
	<liferay-ui:search-container-results
		results="${searchCountryContainer.results}"
	/>
	
	<liferay-ui:search-container-row 
		className="com.liferay.portal.kernel.model.Country"
		keyProperty="countryId"
		modelVar="country" escapedModel="true"
	>			
		<liferay-ui:search-container-column-text
			name="name"
			value="${country.getName(locale)}"
		/>
		
		<liferay-ui:search-container-column-text
			name="a2"
			value="${country.a2}"
		/>
		
		<liferay-ui:search-container-column-text
			name="a3"
			value="${country.a3}"
		/>
		
		<liferay-ui:search-container-column-text
			name="number"
			value="${country.number}"
		/>
		
		<liferay-ui:search-container-column-text
			name="idd"
			value="${country.idd}"
		/>
		
		<liferay-ui:search-container-column-text
			name="zipRequired"
			value="${country.zipRequired}"
		/>
		
		<liferay-ui:search-container-column-text
			name="active"
			value="${country.active}"
		/>

		<liferay-ui:search-container-column-jsp
				align="right"
 				name="actions"
				path="/jsp/countries/configuration/actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="true" searchContainer="${searchCountryContainer}"/>
</liferay-ui:search-container>