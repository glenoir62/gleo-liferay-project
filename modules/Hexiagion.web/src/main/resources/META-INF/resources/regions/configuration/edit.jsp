<%@page import="com.liferay.portal.service.RegionServiceUtil"%>
<%@page import="com.liferay.portal.model.Region"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="/jsp/init.jsp" %>

<%

	String redirect = ParamUtil.getString(request, "redirect");
	
	long regionId = ParamUtil.getLong(request, "regionId");
	
	Region region = null;
	
	if (regionId > 0) {
		region = RegionServiceUtil.getRegion(regionId);
	}

%>
<liferay-ui:header
	backURL='<%= redirect %>'
	title='<%= (region != null) ? region.getName(): "new-region" %>'
/>

<aui:model-context bean="<%= region %>" model="<%= Region.class %>" />

<portlet:actionURL name='<%= (region != null) ? "updateRegion" : "addRegion" %>' var="updateRegionURL" />

<liferay-ui:error key="region-errors" message="type-errors" />

<aui:form action="${updateRegionURL}" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="regionId"/>
		
		<c:set var="countryIdName">
			<portlet:namespace/>countryId
		</c:set>
		
		<input type="hidden" name="${countryIdName}" value="<%= ParamUtil.getLong(request, "countryId") %>" />
		
		<aui:input name="regionCode" >
			<aui:validator name="required"/>
		</aui:input>
		<aui:input name="name" >
			<aui:validator name="required"/>
		</aui:input>
		<aui:input name="active" >
			<aui:validator name="required"/>
		</aui:input>
	</aui:fieldset>
	
	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>