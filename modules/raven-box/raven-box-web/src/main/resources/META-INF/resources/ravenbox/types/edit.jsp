<%@page import="com.gleo.modules.ravenbox.model.Type"%>
<%@ include file="/init.jsp" %>

<liferay-ui:header
	backURL='${redirect}'
	title='${title}'
/>

<portlet:actionURL name="/types/add_type" var="addTypeURL" />
<portlet:actionURL name="/types/edit_type" var="editTypeURL" />

<aui:model-context bean="${type}" model="<%= Type.class %>" />

<liferay-ui:error key="type-errors" message="type-errors" />

<aui:form action="${type != null ? editTypeURL :addTypeURL}" cssClass="container-fluid-1280" method="POST" name="fm">
	<div class="lfr-form-content">
		<aui:fieldset-group markupView="lexicon">
			<aui:fieldset>
				<aui:input type="hidden" name="redirect" value="${redirect}" />
		
				<aui:input type="hidden" name="typeId"/>
		
				<liferay-ui:error key="typename-required" message="annoucements.types.errors.name.required" />
				<aui:input name="name" >
					<aui:validator name="required"/>
				</aui:input>
		
				<aui:input name="order" label="annoucements.types.order.label">
					<aui:validator name="digits"/>
				</aui:input>
			
	
				<c:if test="${type == null}">
					<aui:field-wrapper label="permissions">
						<liferay-ui:input-permissions
							modelName="<%= Type.class.getName() %>"
							/>
					</aui:field-wrapper>
				</c:if>
				
			</aui:fieldset>
		</aui:fieldset-group>
		
		<aui:button-row>
			<aui:button cssClass="btn-lg" type="submit" />
	
			<aui:button cssClass="btn-lg" type="cancel"  onClick="${redirect}" />
		</aui:button-row>
	</div>
</aui:form>