<%@ include file="/init.jsp" %>

<div class="user-information">
	<div class="entity-details section">
		<%@ include file="/userdetails/jsp/user/details.jspf" %>
	</div>

	<div class="section">
		<%@ include file="/userdetails/jsp/user/addresses.jspf" %>
	</div>

	<div class="section">
		<%@ include file="/userdetails/jsp/user/common/additional_email_addresses.jspf" %>
	</div>

	<div class="section">
		<%@ include file="/userdetails/jsp/user/common/websites.jspf" %>
	</div>

	<div class="section">
		<%@ include file="/userdetails/jsp/user/phone_numbers.jspf" %>
	</div>

	<div class="section">
		<%@ include file="/userdetails/jsp/user/instant_messenger.jspf" %>
	</div>

	<div class="section">
		<%@ include file="/userdetails/jsp/user/social_network.jspf" %>
	</div>

	<div class="section">
		<%@ include file="/userdetails/jsp/user/sms.jspf" %>
	</div>

	<div class="section">
		<%@ include file="/userdetails/jsp/user/comments.jspf" %>
	</div>
</div>