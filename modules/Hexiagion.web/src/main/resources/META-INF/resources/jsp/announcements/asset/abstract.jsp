<%@include file="/jsp/init.jsp" %>

<c:set var="announcementImage" value="${announcement.getImage()}"></c:set>

<aui:row >
	<div class="span3 ">
		<br>
		<p>
			<i class="icon-cloud icon-large" style="color:#00a2fb"></i> ${announcement.getType().getName(locale)}
		</p>
	</div>
	<c:if test="${announcement.price > 0}">
		<div class="offset1 span7 well">
			<p>
				<liferay-ui:message key="annoucements.asset.abstract.price.label"/> : ${announcement.price} ${announcement.getCurrencySymbol()}</strong>
			</p>
		</div>
	</c:if>
</aui:row>
<br>
<aui:row>
	<div class="span3">
		<c:if test="${announcementImage ne null}">
			<img class="thumbnail"
			id="${announcementImage.announcementId}"
			alt="${announcementImage.getDescription(locale)}"
			src="${announcementImage.getImageURL(themeDisplay)}">
		</c:if>
	</div>
	<div class="offset1 span7">
	<p>
		${announcement.getSummary(locale)}
	</p>

	</div>
</aui:row>