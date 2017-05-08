<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.service.RegionServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Region"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="/jsp/init.jsp" %>

<liferay-ui:success key="region-added" message="annoucements.region.success.added" />
<liferay-ui:success key="region-updated" message="annoucements.region.success.updated" />

<%

	String redirect = ParamUtil.getString(request, "redirect");
	
	long regionId = ParamUtil.getLong(request, "regionId");
	
	Region region = null;
	
	if (regionId > 0) {
		region = RegionServiceUtil.getRegion(regionId);
	}
	
	portletDisplay.setShowBackIcon(true);
	portletDisplay.setURLBack(redirect);
	renderResponse.setTitle(region != null ? region.getName() : "new-region");

%>

<aui:model-context bean="<%= region %>" model="<%= Region.class %>" />

<portlet:actionURL name='<%= (region != null) ? "updateRegion" : "addRegion" %>' var="updateRegionURL" >
	<portlet:param name="redirect" value="<%= redirect %>" />
</portlet:actionURL>

<liferay-ui:error key="region-errors" message="type-errors" />

<aui:form cssClass="container-fluid-1280" action="${updateRegionURL}" method="POST" name="fm">
	<aui:fieldset-group markupView="lexicon">
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
			</aui:input>
		</aui:fieldset>
	</aui:fieldset-group>
	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>