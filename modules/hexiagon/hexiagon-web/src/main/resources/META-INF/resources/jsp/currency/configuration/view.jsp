<%@page import="com.gleo.plugins.hexiagon.permission.HexiagonPermission"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@include file="/jsp/init.jsp" %>

<liferay-ui:success key="currency-added" message="annoucements.currencies.success.added" />
<liferay-ui:success key="currency-updated" message="annoucements.currencies.success.updated" />
<liferay-ui:success key="currency-deleted" message="annoucements.currencies.success.deleted" />

<liferay-ui:error key="no-currency-deleted" message="annoucements.currencies.errors.deleted" />
<liferay-ui:error key="use-currency" message="annoucements.currencies.errors.some.announcements.use.this.currency" />


	<aui:nav-bar cssClass="label-info">
		<aui:nav >
			<portlet:renderURL var="addTypeURL">
				<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(renderRequest) %>" />
				<portlet:param name="jspPage" value="/jsp/currencies/edit.jsp"/>
		    </portlet:renderURL>
		    
			<aui:nav-item href="${addTypeURL}" iconCssClass="icon-plus" label="annoucements.currencies.add.label" />
			
		</aui:nav>
	</aui:nav-bar>

<liferay-ui:search-container id="currencies" searchContainer="${searchCurrencyContainer}" var="searchCurrencyContainer">
	<liferay-ui:search-container-results
		results="${searchCurrencyContainer.results}"
	/>

	<aui:input name="tabs1" type="hidden" value="currencies" />
	
	<liferay-ui:search-container-row 
		className="com.gleo.plugins.hexiagon.model.Currency"
		keyProperty="currencyId"
		modelVar="currency" escapedModel="true"
	>
	
		<liferay-ui:search-container-column-text>
			<aui:input name="currencyIds" type="hidden" value="${currency.currencyId}"> 
			</aui:input>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text
			name="label"
			property="label"
		/>
		
		<liferay-ui:search-container-column-text
			name="annoucements.currencies.symbol.label"
			property="symbol"
		/>
		
		<liferay-ui:search-container-column-text
			name="order"
			property="order"
		/>
		
		<liferay-ui:search-container-column-jsp
			align="right" 
			name="actions" 
			path="/jsp/currency/configuration/actions.jsp" 
		/> 
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="true" searchContainer="${searchCurrencyContainer}"/>
</liferay-ui:search-container>

<portlet:resourceURL var="saveCurrenciesOrderURL" />

<c:if test ='<%= HexiagonPermission.contains(permissionChecker, themeDisplay.getScopeGroupId(), "UPDATE_ORDER") %>'>
	<aui:script>
	YUI().use('sortable', function (Y) {
	
	    var log, sortable;
	
	    log = Y.one('#log');
		var container = Y.one('#<portlet:namespace/>currenciesSearchContainer');
		
	    // Our sortable list instance.
	    sortable = new Y.Sortable({
	    	container: container,
	        nodes    : 'table tbody tr',
	        opacity  : '0.5'
	    });
	
	    sortable.delegate.after('drag:end', function (e) {
	        var node = sortable.delegate.get('currentNode'),
	            prev = node.previous(),
	            next = node.next(),
	            msg  = 'Moved ' + node.one('td').get('text');
	        
	        container.all('input[name=<portlet:namespace/>currencyIds]');
	        
	        
		    var currencyIds = container.all('input[name=<portlet:namespace/>currencyIds]').get('value');
		    
		    <portlet:namespace />saveCurrenciesOrder(currencyIds);
	    });
	
	});
	
	Liferay.provide(window,'<portlet:namespace />saveCurrenciesOrder',function(currencyIds) {
	
		YUI().use(
		  'aui-io-request-deprecated',
		  function (Y) {
		    Y.io.request(
		      '${saveCurrenciesOrderURL}',
		      {
		      	datacurrency: 'text/html',
		      	method: 'POST',
		      	data: {
					<portlet:namespace/>currencyIds : currencyIds
				}
		      }
		    );
		  }
		);
	});
	
	</aui:script>
</c:if>