<%@ include file="/groupphoto/jsp/init.jsp" %>

<h2>${user.fullName}</h2>

<div class="details">
	<liferay-ui:user-portrait
		imageCssClass="user-icon-lg"
		userId="${user.userId}"
	/>

	<dl class="property-list">
		<c:if test="${not empty user.displayEmailAddress}">
			<dt>
				<liferay-ui:message key="email-address" />
			</dt>
			<dd>
				${user.displayEmailAddress}
			</dd>
		</c:if>

		<c:if test="${not empty birthday}">
			<dt>
				<liferay-ui:message key="birthday" />
			</dt>
			<dd>
				${birthday}
			</dd>
		</c:if>

		<c:if test="${not empty jobTitle}">
			<dt>
				<liferay-ui:message key="job-title" />
			</dt>
			<dd>
				${jobTitle}
			</dd>
		</c:if>

		<c:if test="${not empty gender}">
			<dt>
				<liferay-ui:message key="gender" />
			</dt>
			<dd>
				${gender}
			</dd>
		</c:if>

		<c:if test="${!organizations.isEmpty()}">
			<dt>
				<c:choose>
					<c:when test="${organizations.size() > 1 }">
						<liferay-ui:message key="organizations" />
					</c:when>
					<c:otherwise>
						<liferay-ui:message key="organization" />
					</c:otherwise>
				</c:choose>
			</dt>
			<dd>
				${organizationsHTML}
			</dd>
		</c:if>
	</dl>
</div>