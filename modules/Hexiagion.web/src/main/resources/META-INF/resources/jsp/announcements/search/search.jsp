<%@include file="/jsp/init.jsp" %>

<div id='<portlet:namespace/>show'>
	<br>
	<aui:nav-bar>
		<aui:nav-bar-search cssClass="span3">
			<br>
			<aui:select name="type" label="annoucements.search.type.label" id="type">
				<aui:option label="" value="" />
				<c:forEach items='${types}' var="type">
					<aui:option label="${type.name}" value="${type.typeId}" selected="${type.typeId == typeId}"/>
				</c:forEach>
			</aui:select>
		</aui:nav-bar-search>

		<aui:nav-bar-search cssClass="offset1 span3">
			<br>
			<aui:select name="currency" label="annoucements.search.currency.label" id="currency">
				<aui:option label="" value="" />
				<c:forEach items='${currencies}' var="currency">
					<aui:option label="${currency.symbol}" value="${currency.currencyId}" selected="${currency.currencyId == defaultCurrencyId}"/>
				</c:forEach>
			</aui:select>
		</aui:nav-bar-search>

		<aui:nav-bar-search cssClass="offset1 span3">
			<br>
			<aui:select name="filter" label="annoucements.search.filter.label" id="filter">
				<aui:option label="" value="" />
				<c:forEach items='${filterEnum}' var="filter">
					<c:set var="filterLabel" >
						<liferay-ui:message key='${filter.getKey()}'/>
					</c:set>
					<c:set var="isSelected" value="${filter.fieldId == filterId}"/>
					<aui:option label="${filterLabel}" value="${filter.fieldId}" selected="${isSelected}" />
				</c:forEach>
			</aui:select>
		</aui:nav-bar-search>
	</aui:nav-bar>
	<%-- 
		<aui:row>
			<p>
				<button class="btn btn-large btn-block btn-primary" type="button" onclick="<portlet:namespace />search();"><i class="icon-search"></i> <liferay-ui:message key="annoucements.search.button.search.label"/></button>
			</p>
		</aui:row>
	--%>
	<aui:row>
		<div id = "<portlet:namespace/>searchPlaceHolder">
			<liferay-util:include page="/jsp/announcements/search/results.jsp" servletContext="<%= application %>" />
		</div>
	</aui:row>
</div>
                
<aui:script use="aui-base">
// var categoryIdsTabIpc for IPC

var categoryIdsTabIpc = '';
var countryIdIpc = ${countryId};
var regionIdIpc = ${regionId};

// load initial Search
A.on('domready', function(event){
	
	if ('${activeSearch}') {
		
		// checked node
		var categoryIdsTabIpc = '${categoryIds}'.split(',');		
		var typeId = '${typeId}';
		var filter = '${filter}';
		var page = '${page}';
		var currencyId = '${currencyId}';
				
		<portlet:namespace />searchParam(typeId, currencyId, filter, page);
	}
	
	// Search after select changement.
	A.all("#<portlet:namespace/>show select").on('change', function(event){
		<portlet:namespace />search();
	});
});
	
var Lang = A.Lang;

getCN = A.getClassName;

var STR_RESPONSE_DATA = 'responseData';

var REGEX_TREE_NODE_ID = /(\d+)$/;

var CSS_TREE_NODE_CHECKBOX = getCN('tree', 'node', 'checkbox');

var CHECKBOX_TPL = '<input class="' + CSS_TREE_NODE_CHECKBOX + '" type="checkbox" />';

// Search
Liferay.provide(window,'<portlet:namespace />search',function(page,isAnim) {
	
	YUI().use('node', function (Y) {

		var typeId = Y.one('#<portlet:namespace />type').get('value');
		var currencyId = Y.one('#<portlet:namespace />currency').get('value');
		var filter = Y.one('#<portlet:namespace />filter').get('value');
				
		<portlet:namespace />searchParam(typeId, currencyId, filter, page, isAnim);
		
	});
});

Liferay.on(
   'LOAD_SEARCH_ANNONCEMENT_LOCALIZATION',
   function(data) {
		countryIdIpc = data.countryIdIPC;
		regionIdIpc = data.regionIdIPC;
		
		<portlet:namespace />search(0,false);
   }		
);

Liferay.on(
   'LOAD_SEARCH_ANNONCEMENT_CATEGORIES',
   function(data) {
		categoryIdsTabIpc = data.categoryIdsTabIpc;		
		<portlet:namespace />search(0,false);
   }		
);



Liferay.provide(window,'<portlet:namespace />searchParam',function(typeId, currencyId, filter, page,isAnim) {
	YUI().use('aui-io-request','node','anim', function (Y) {
		var searchPlaceHolder = Y.one('#<portlet:namespace />searchPlaceHolder');
		searchPlaceHolder.plug(A.LoadingMask, { background: '#e3f5ff' });
		searchPlaceHolder.loadingmask.show();
		Y.io.request(
		      '${searchUrl}',
		      {
		        dataType: 'text/html',
		        method: 'POST',
		        data: {
						<portlet:namespace />categoryIds : categoryIdsTabIpc,
						<portlet:namespace />typeId : typeId,
						<portlet:namespace />currencyId : currencyId,
						<portlet:namespace />filterId : filter,
						<portlet:namespace/>regionId : regionIdIpc,
						<portlet:namespace/>countryId : countryIdIpc,
						<portlet:namespace/>page : page,
					},
		        on: {
					complete: function(event, id, obj) {
						searchPlaceHolder.loadingmask.hide();
					},
			       	success: function() {
			            // gets the result of this asynchronous request
			            
			            var data = this.get(STR_RESPONSE_DATA);
			            
			            if (searchPlaceHolder) {
			            	 searchPlaceHolder.setHTML(data);
			            	 // laod animation
			            	 if (isAnim) {
				            	 var anim = new Y.Anim({
									  duration: 0.6,
									  node: Y.UA.gecko ? 'html' : 'body',
									  easing: Y.Easing.easeBoth,
									  to: {
									    scrollTop: Y.one('#p_p_id<portlet:namespace/>').getXY()[1]
									  }
								});
							
								anim.run();
							}
			            }
			    	}
		        }
		     }
		);
	});
});

</aui:script>

