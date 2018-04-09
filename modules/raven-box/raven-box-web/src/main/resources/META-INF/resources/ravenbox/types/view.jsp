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
			<c:choose>
				<c:when test='${displayStyle.equals("icon")}'>
					<%@ include file="/ravenbox/types/columns/icon.jspf" %>
				</c:when>
				<c:when test='${displayStyle.equals("descriptive")}'>
					<%@ include file="/ravenbox/types/columns/descriptive.jspf" %>
				</c:when>
				<c:otherwise>
					<%@ include file="/ravenbox/types/columns/list.jspf" %>
				</c:otherwise>
			</c:choose>
		</liferay-ui:search-container-row>
	
		<liferay-ui:search-iterator displayStyle="${displayStyle}" markupView="lexicon"/>
	</liferay-ui:search-container>
</aui:form>