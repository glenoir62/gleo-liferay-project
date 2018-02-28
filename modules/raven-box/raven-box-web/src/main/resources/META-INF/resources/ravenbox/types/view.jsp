<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ include file="/init.jsp" %>

<liferay-ui:success key="type-added" message="com.gleo.modules.ravenbox.type.success.added" />
<liferay-ui:success key="type-updated" message="com.gleo.modules.ravenbox.type.success.updated" />
<liferay-ui:success key="type-deleted" message="com.gleo.modules.ravenbox.type.success.deleted" />

<liferay-ui:error key="no-type-deleted" message="com.gleo.modules.ravenbox.type.errors.type.deleted.unsuccessfully" />

<portlet:renderURL var="addEntryURL">
		<portlet:param name="mvcRenderCommandName" value="/types/edit" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:renderURL>
		
<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav cssClass="navbar-nav">
		<aui:nav-item label="com.gleo.modules.ravenbox.type.title" selected="<%= true %>" />
	</aui:nav>
	
	<aui:nav-bar-search>
		<aui:form action="" name="searchFm">
			<liferay-ui:input-search markupView="lexicon" />
		</aui:form>
	</aui:nav-bar-search>
</aui:nav-bar>

<liferay-frontend:management-bar
	includeCheckBox="<%= true %>"
	searchContainerId="userGroups"
>
	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:management-bar-display-buttons
			displayViews='<%= new String[] {"descriptive", "icon", "list"} %>'
			portletURL="<%= renderResponse.createRenderURL() %>"
			selectedDisplayStyle=""
		/>
	</liferay-frontend:management-bar-buttons>

	<liferay-frontend:management-bar-filters>
		<liferay-frontend:management-bar-navigation
			navigationKeys='<%= new String[] {"all"} %>'
			portletURL="<%= renderResponse.createRenderURL() %>"
		/>

		<liferay-frontend:management-bar-sort
			orderByCol=""
			orderByType=""
			orderColumns='<%= new String[] {"name"} %>'
			portletURL="<%= renderResponse.createRenderURL() %>"
		/>
	</liferay-frontend:management-bar-filters>

	<c:if test='<%= RavenBoxPermission.contains(permissionChecker, themeDisplay.getScopeGroupId(), "ADD_TYPE") %>'>
		<liferay-frontend:add-menu>
			<liferay-frontend:add-menu-item title='<%= LanguageUtil.get(request, "com.gleo.modules.ravenbox.type.add") %>' url="<%= addEntryURL %>" />
		</liferay-frontend:add-menu>
	</c:if>
</liferay-frontend:management-bar>

<div id="breadcrumb">
	<liferay-ui:breadcrumb showCurrentGroup="<%= false %>" showGuestGroup="<%= false %>" showLayout="<%= false %>" showPortletBreadcrumb="<%= true %>" />
</div>

<aui:form action="#" cssClass="container-fluid-1280" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="portletURL" />
	<aui:input name="redirect" type="hidden" value="<%= renderResponse.createRenderURL() %>" />
	<aui:input name="deleteUserGroupIds" type="hidden" />
	
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
</aui:form>

<portlet:resourceURL id="/types/save_types_order" var="saveTypesOrderURL" />

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