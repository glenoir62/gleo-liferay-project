<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ include file="/init.jsp" %>

<liferay-ui:success key="type-added" message="com.gleo.modules.ravenbox.type.success.added" />
<liferay-ui:success key="type-updated" message="com.gleo.modules.ravenbox.type.success.updated" />
<liferay-ui:success key="type-deleted" message="com.gleo.modules.ravenbox.type.success.deleted" />

<liferay-ui:error key="no-type-deleted" message="com.gleo.modules.ravenbox.type.errors.type.deleted.unsuccessfully" />

<liferay-ui:search-container  searchContainer="${searchTypeContainer}" id="types">

	<liferay-ui:search-container-row 
		className="com.gleo.modules.ravenbox.model.Type"
		keyProperty="typeId"
		modelVar="type" escapedModel="true"
	>	
	
		<liferay-ui:search-container-column-text>
			<aui:input name="typeIds" type="hidden" value="${type.typeId}"> 
			</aui:input>
		</liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text
			name="name"
			value="${type.getName(locale)}"
		/>
		
		<liferay-ui:search-container-column-text
			name="order"
			property="order"
		/>
		
		<liferay-ui:search-container-column-jsp
			align="right"
			name="actions"
			path="/ravenbox/types/actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="true" markupView="lexicon" searchContainer="${searchTypeContainer}"/>
</liferay-ui:search-container>

<c:if test='<%= RavenBoxPermission.contains(permissionChecker, themeDisplay.getScopeGroupId(), "ADD_TYPE") %>'>
	<portlet:renderURL var="addEntryURL">
		<portlet:param name="mvcRenderCommandName" value="/types/edit" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
	</portlet:renderURL>

	<liferay-frontend:add-menu>
		<liferay-frontend:add-menu-item title='<%= LanguageUtil.get(request, "com.gleo.modules.ravenbox.type.add") %>' url="<%= addEntryURL %>" />
	</liferay-frontend:add-menu>
</c:if>


<portlet:resourceURL var="saveTypesOrderURL" />

<c:if test ='<%= RavenBoxPermission.contains(permissionChecker, themeDisplay.getScopeGroupId(), "UPDATE_ORDER") %>'>
	<aui:script>
		YUI().use('sortable', function (Y) {
		
		    var log, sortable;
		
		    log = Y.one('#log');
			var container = Y.one('#<portlet:namespace/>typesSearchContainer');
			
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
		        
		        container.all('input[name=<portlet:namespace/>typeIds]');
		        
		        
			    var typeIds = container.all('input[name=<portlet:namespace/>typeIds]').get('value');
			    
			    <portlet:namespace />saveTypesOrder(typeIds);
		    });
		
		});
		
		Liferay.provide(window,'<portlet:namespace />saveTypesOrder',function(typeIds) {
		
			YUI().use(
			  'aui-io-request-deprecated',
			  function (Y) {
			    Y.io.request(
			      '${saveTypesOrderURL}',
			      {
			      	dataType: 'text/html',
			      	method: 'POST',
			      	data: {
						<portlet:namespace/>typeIds : typeIds
					}
			      }
			    );
			  }
			);
		});
	
	</aui:script>
</c:if>