<%@ include file="/groupphoto/jsp/init.jsp" %>


<c:if test="${!personalAddresses.isEmpty() || !organizationAddresses.isEmpty()}">
	<h3 class="icon-home"><liferay-ui:message key="address" /></h3>

	<c:if test="${!organizationAddresses.isEmpty()}">
		<div>
			<h4><liferay-ui:message key="organization-address" /></h4>

			<ul class="property-list">
				 <c:forEach var="address" items="${organizationAddresses}">
				 	
					<li class="${address.isPrimary() ? "icon-star" : StringPool.BLANK}">
 						<%@ include file="/groupphoto/jsp/ajax/user/common/addresses_address.jsp" %>
					</li>
				</c:forEach>
			</ul>
		</div>
	</c:if>
	
	<c:if test="${not empty personalAddresses.isEmpty()}">
		<div>
			<h4><liferay-ui:message key="personal-address" /></h4>

			<ul class="property-list">
				<c:forEach var="address" items="${personalAddresses}">

					<li class='${(address.isPrimary() && !personalAddresses.isEmpty()) ? "icon-star" : "" }'>
						<%@ include file="/groupphoto/jsp/ajax/user/common/addresses_address.jsp" %>
					</li>
				</c:forEach>
			</ul>
		</div>
	</c:if>
</c:if>
