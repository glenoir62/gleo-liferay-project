<%@ include file="/groupphoto/jsp/init.jsp" %>

<c:if test="${ not empty contact.getSmsSn() }">
	<h3 class="icon-mobile-phone"><liferay-ui:message key="sms" /></h3>

	<ul class="property-list">
		<li>${ htmlUtil.escape(contact.getSmsSn()) }</li>
	</ul>
</c:if>