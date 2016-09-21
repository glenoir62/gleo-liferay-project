<%@page import="com.gleo.plugins.hexiagon.service.TypeLocalServiceUtil"%>
<%@page import="com.gleo.plugins.hexiagon.model.Type"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="/jsp/init.jsp" %>

<%

	String redirect = ParamUtil.getString(request, "redirect");
	
	long typeId = ParamUtil.getLong(request, "typeId");
	
	Type type = null;
	
	if (typeId > 0) {
		type = TypeLocalServiceUtil.getType(typeId);
	}

%>
<liferay-ui:header
	backURL='<%= redirect %>'
	title='<%= (type != null) ? type.getName(locale) : "new-type" %>'
/>

<aui:model-context bean="<%= type %>" model="<%= Type.class %>" />

<portlet:actionURL name='<%= (type != null) ? "updateType" : "addType" %>' var="addTypeURL" />

<liferay-ui:error key="type-errors" message="type-errors" />

<aui:form action="${addTypeURL}" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="typeId"/>

		<liferay-ui:error key="typename-required" message="annoucements.types.errors.name.required" />
		<aui:input name="name" >
			<aui:validator name="required"/>
		</aui:input>

		<aui:input name="order" label="annoucements.types.order.label">
			<aui:validator name="digits"/>
		</aui:input>
		

	</aui:fieldset>

	<c:if test="<%= type == null %>">
		<aui:field-wrapper label="permissions">
			<liferay-ui:input-permissions
				modelName="<%= Type.class.getName() %>"
				/>
		</aui:field-wrapper>
	</c:if>
	
	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel"  onClick="<%= redirect %>" />
	</aui:button-row>
</aui:form>