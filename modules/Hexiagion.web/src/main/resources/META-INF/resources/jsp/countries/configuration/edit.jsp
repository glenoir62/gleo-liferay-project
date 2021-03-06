<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.service.CountryServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Country"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="/jsp/init.jsp" %>

<liferay-ui:success key="country-added" message="annoucements.countries.success.added" />
<liferay-ui:success key="country-updated" message="annoucements.countries.success.updated" />

<%

	String redirect = ParamUtil.getString(request, "redirect");
	
	long countryId = ParamUtil.getLong(request, "countryId");
	
	Country country = null;
	
	if (countryId > 0) {
		country = CountryServiceUtil.getCountry(countryId);
	}
	
	portletDisplay.setShowBackIcon(true);
	portletDisplay.setURLBack(redirect);
	renderResponse.setTitle(country != null ? country.getName(locale) : "new-country");

%>

<aui:model-context bean="<%= country %>" model="<%= Country.class %>" />

<portlet:actionURL name='<%= (country != null) ? "updateCountry" : "addCountry" %>' var="updateCountryURL">
	<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:actionURL>

<liferay-ui:error key="country-errors" message="type-errors" />

<aui:form cssClass="container-fluid-1280" action="${updateCountryURL}" method="POST" name="fm">
	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset>
			<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
	
			<aui:input type="hidden" name="countryId"/>
	
			<aui:input name="name" >
				<aui:validator name="required"/>
			</aui:input>
			<aui:input name="a2" >
				<aui:validator name="required"/>
			</aui:input>
			<aui:input name="a3" >
				<aui:validator name="required"/>
			</aui:input>
			<aui:input name="number" >
				<aui:validator name="required"/>
			</aui:input>
			<aui:input name="idd" >
				<aui:validator name="required"/>
			</aui:input>
			<aui:input name="zipRequired" >
			</aui:input>
			<aui:input name="active" >
			</aui:input>
		</aui:fieldset>
	</aui:fieldset-group>
	
	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>