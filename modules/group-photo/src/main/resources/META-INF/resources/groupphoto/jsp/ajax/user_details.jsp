<%@ include file="/groupphoto/jsp/init.jsp" %>

<div class="user-information">
	<div class="entity-details section">
		<liferay-util:include page="/groupphoto/jsp/ajax/user/details.jsp" servletContext="<%= application %>" />
	</div>

	<div class="section">
		<liferay-util:include page="/groupphoto/jsp/ajax/user/addresses.jsp" servletContext="<%= application %>" />
	</div>

	<div class="section">
		<liferay-util:include page="/groupphoto/jsp/ajax/user/common/additional_email_addresses.jsp" servletContext="<%= application %>" />
	</div>

	<div class="section">
		<liferay-util:include page="/groupphoto/jsp/ajax/user/common/websites.jsp" servletContext="<%= application %>" />
	</div>

	<div class="section">
		<liferay-util:include page="/groupphoto/jsp/ajax/user/phone_numbers.jsp" servletContext="<%= application %>" />
	</div>

	<div class="section">
		<liferay-util:include page="/groupphoto/jsp/ajax/user/instant_messenger.jsp" servletContext="<%= application %>" />
	</div>

	<div class="section">
		<liferay-util:include page="/groupphoto/jsp/ajax/user/social_network.jsp" servletContext="<%= application %>" />
	</div>

	<div class="section">
		<liferay-util:include page="/groupphoto/jsp/ajax/user/sms.jsp" servletContext="<%= application %>" />
	</div>

	<div class="section">
		<liferay-util:include page="/user/comments.jsp" servletContext="<%= application %>" />
	</div>
</div>