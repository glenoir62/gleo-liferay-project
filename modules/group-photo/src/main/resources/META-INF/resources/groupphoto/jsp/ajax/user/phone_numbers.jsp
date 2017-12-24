<%@ include file="/groupphoto/jsp/init.jsp" %>

<c:if test="${!personalPhones.isEmpty() || !organizationPhones.isEmpty() }">
	<h3 class="icon-phone-sign"><liferay-ui:message key="phones" /></h3>

	<c:if test="${!organizationPhones.isEmpty() }">
		<h4><liferay-ui:message key="organization-phones" /></h4>

		<ul class="property-list">
			
			<c:forEach var="phone" items="${organizationPhones}">

				<li class='${(phone.isPrimary() && !organizationPhones.isEmpty()) ? "icon-star" : StringPool.BLANK }'>
					${htmlUtil.escape(phone.getNumber())} ${phone.getExtension()} <liferay-ui:message key="${phone.getType().getName()}" />
				</li>
			</c:forEach>

		</ul>
	</c:if>

	<c:if test="${!personalPhones.isEmpty() }">
		<h4><liferay-ui:message key="personal-phones" /></h4>

		<ul class="property-list">
			<c:forEach var="phone" items="${personalPhones}">

				<li class='${(phone.isPrimary() && !personalPhones.isEmpty()) ? "icon-star" : StringPool.BLANK }'>
					${htmlUtil.escape(phone.getNumber())}${phone.getExtension()} <liferay-ui:message key="${phone.getType().getName()}" />
				</li>
			</c:forEach>

		</ul>
	</c:if>
</c:if>