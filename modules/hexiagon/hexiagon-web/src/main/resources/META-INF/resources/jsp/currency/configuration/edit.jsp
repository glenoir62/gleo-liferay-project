<%@page import="com.liferay.portal.kernel.service.CountryServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Country"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassInvoker"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.util.ClassResolverUtil"%>
<%@page import="com.liferay.portal.kernel.util.MethodKey"%>
<%@page import="com.gleo.plugins.hexiagon.model.Currency"%>
<%@page import="com.gleo.plugins.hexiagon.service.CurrencyLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@include file="/jsp/init.jsp" %>

<%

	String redirect = ParamUtil.getString(request, "redirect");
	
	long currencyId = ParamUtil.getLong(request, "currencyId");
	
	Currency currency = null;
	
	if (currencyId > 0) {
		currency = CurrencyLocalServiceUtil.getCurrency(currencyId);
	}
	
	// Well well well ...
	MethodKey methodKey = new MethodKey(
	ClassResolverUtil.resolveByPortalClassLoader("com.liferay.portlet.currencyconverter.util.CurrencyUtil"),
		"getAllSymbols",
		new Class<?>[] {
			PageContext.class
		});
	
	Map<String, String> currenciesMap = (Map<String, String>) PortalClassInvoker.invoke(true, methodKey, pageContext);
	
	List<Country> countries = CountryServiceUtil.getCountries();

%>
<c:set  var="currencyEntrySet" value="<%= currenciesMap.entrySet() %>"/>

<liferay-ui:header
	backURL='<%= redirect %>'
	title='<%= (currency != null) ? currency.getLabel() : "new-currency" %>'
/>

<aui:model-context bean="<%= currency %>" model="<%= Currency.class %>" />

<portlet:actionURL name='<%= (currency != null) ? "updateCurrency" : "addCurrency" %>' var="addCurrencyURL" />

<liferay-ui:error key="currency-errors" message="currency-errors" />

<aui:form action="${addCurrencyURL}" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="currencyId" />

		<liferay-ui:error key="label-required" message="annoucements.currencies.errors.label.required" />
		<aui:select name="label" label="Label" showEmptyOption="true" >
			<c:forEach var="currencyEntry" items="${currencyEntrySet}">
				<aui:option label="currency.${currencyEntry.key}" value="${currencyEntry.value}"/>
			</c:forEach>
		</aui:select>
		
		<liferay-ui:error key="symbol-required" message="annoucements.currencies.errors.symbol.required" />
		<aui:input name="symbol" label="annoucements.currencies.symbol.label">
			<aui:validator name="required"/>
		</aui:input>

		<aui:input name="order" label="annoucements.currencies.order.label">
			<aui:validator name="digits"/>
		</aui:input>
		
		<aui:select name="countryId" label="annoucements.currencies.country.label" showEmptyOption="true" >
			<c:forEach var="country" items="<%= countries %>">
				<aui:option label="${country.getName(locale)}" value="${country.countryId}"/>
			</c:forEach>
		</aui:select>

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>

<aui:script use="aui-base,aui-event,aui-node">

	var rules = {
			<portlet:namespace />label: {
		 	required: true
		}
	};
	
	var validator1 = new A.FormValidator({
		boundingBox: document.<portlet:namespace />fm,
		rules: rules
	});
	
</aui:script>
