<%@ include file="/groupphoto/jsp/init.jsp" %>

<c:if test="${! websites.isEmpty()}">
	<h3 class="icon-file"><liferay-ui:message key="websites" /></h3>
	<ul class="property-list">
		<c:forEach var="website" items="${websites}">
			<c:set var="website" value="${website.toEscapedModel()}"/>

			<li class='${ (website.isPrimary() && !websites.isEmpty()) ? "icon-star" : ""}'>
				<a href="${ website.getUrl() }">${ website.getUrl() }</a>
				<liferay-ui:message key="${website.getType().getName()}" />
			</li>
		</c:forEach>
	</ul>
</c:if>