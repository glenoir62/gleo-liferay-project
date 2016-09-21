<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.petra.content.ContentUtil"%>

<%@include file="../../init.jsp"%>
<portlet:resourceURL var="exportURL" />

<portlet:actionURL var="importURL" >
   <portlet:param name="name" value="import"/>
</portlet:actionURL>

<liferay-ui:panel id="export" title="annoucements.categories.importer.export.label" collapsible="<%=true %>" extended="<%= true %>" persistState="<%= false %>">
	<aui:button  href="${exportURL}" value="export" cssClass="btn-primary" />	
</liferay-ui:panel>

<liferay-ui:panel id="import" title="annoucements.categories.importer.import.label" collapsible="true" extended="<%= true %>" persistState="<%= false %>">
	<aui:form action="${importURL}" enctype="multipart/form-data" method="POST" name="fm">
		<aui:input inlineField="true" name="fileCategory" type="file" label="annoucements.categories.importer.panel.xml.label">
			<aui:validator name="acceptFiles">'xml'</aui:validator>
			<aui:validator name="required"/>
		</aui:input>
		<aui:button-row>
			<aui:button type="submit" value="import"/>
		</aui:button-row>
	</aui:form>
	
	<pre><%= HtmlUtil.escape(ContentUtil.get("export_example.xml")) %></pre>
</liferay-ui:panel>