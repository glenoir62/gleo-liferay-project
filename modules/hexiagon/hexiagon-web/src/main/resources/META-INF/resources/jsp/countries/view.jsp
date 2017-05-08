<%@include file="/jsp/init.jsp" %>

<liferay-ui:panel iconCssClass="icon-map-marker" defaultState="open" extended="true" id="localization" persistState="false" title="announcement.countries.panel.localization">

<aui:select label="country" name="countryId" showEmptyOption="true" />
		
<aui:select label="region" name="regionId" showEmptyOption="true" />

</liferay-ui:panel>
<aui:script use="aui-base,aui-form-validator,liferay-form,liferay-dynamic-select">
	new Liferay.DynamicSelect(
		[
			{
				select: '<portlet:namespace />countryId',
				selectData: Liferay.Address.getCountries,
				selectDesc: 'nameCurrentValue',
				selectSort: '<%= true %>',
				selectId: 'countryId',
				selectVal: '${countryId}'
			},
			{
				select: '<portlet:namespace />regionId',
				selectData: Liferay.Address.getRegions,
				selectDesc: 'name',
				selectId: 'regionId',
				selectVal: '${regionId}'
			}
		]
	);
	
	var countrySelect = A.one('#<portlet:namespace/>countryId');
	var regionSelect = A.one('#<portlet:namespace/>regionId');

	countrySelect.on('change', function(event){
		<portlet:namespace />loadIPC();
	});
	
	regionSelect.on('change', function(event){
		<portlet:namespace />loadIPC();
	});
	
	Liferay.provide(window,'<portlet:namespace />loadIPC',function() {
		var countryId = countrySelect.get('value');
		var regionId = regionSelect.get('value');
				
		// load IPC Search 
		Liferay.fire('LOAD_SEARCH_ANNONCEMENT_LOCALIZATION', 
			{
			      countryIdIPC : countryId,
			      regionIdIPC : regionId
			}
		);
	});
</aui:script>