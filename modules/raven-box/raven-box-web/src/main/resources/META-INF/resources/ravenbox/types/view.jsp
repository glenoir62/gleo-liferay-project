<%@ include file="/init.jsp" %>

<liferay-ui:success key="type-added" message="com.gleo.modules.ravenbox.type.success.added" />
<liferay-ui:success key="type-updated" message="com.gleo.modules.ravenbox.type.success.updated" />
<liferay-ui:success key="type-deleted" message="com.gleo.modules.ravenbox.type.success.deleted" />

<liferay-ui:error key="no-type-deleted" message="com.gleo.modules.ravenbox.type.errors.type.deleted.unsuccessfully" />

<%@ include file="/ravenbox/types/toolbar.jspf" %>

<aui:form action="#" cssClass="container-fluid-1280" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="portletURL" />
	<aui:input name="redirect" type="hidden" value="<%= renderResponse.createRenderURL() %>" />
	
	<liferay-ui:search-container  searchContainer="${searchTypeContainer}" id="types">
		<liferay-ui:search-container-row 
			className="com.gleo.modules.ravenbox.model.Type"
			keyProperty="typeId"
			modelVar="type" escapedModel="true"
		>
		
		<liferay-ui:search-container-column-text
						name="Id"
						value="${type.typeId}"
					/>
					
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
						name=""
						path="/ravenbox/types/actions.jsp"
					/>
		
		</liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator paginate="true" markupView="lexicon" searchContainer="${searchTypeContainer}"/>
	</liferay-ui:search-container>
</aui:form>