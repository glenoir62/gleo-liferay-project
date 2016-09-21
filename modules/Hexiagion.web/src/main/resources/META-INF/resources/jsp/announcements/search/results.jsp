
<%@page import="com.gleo.plugins.hexiagon.model.Announcement"%>
<%@page import="javax.portlet.WindowState"%>
<%@include file="/jsp/init.jsp"%>

<hr>
	<c:if test="${total <= 0}">
		<aui:row>
			<div class="alert text-center">
				<liferay-ui:message key="there-are-no-results" />
			</div>
		</aui:row>
	</c:if>
	<aui:row>
		<div class="span12 text-center">
			<liferay-ui:message key="annoucements.search.total.label"/> : ${total}
			<liferay-ui:message key="annoucements.search.page.label"/> : ${page+1}
		</div>
	</aui:row>
	<c:if test="${not empty parentCategoryList}">
		<aui:row>
		<div class="span12 text-center">
			<liferay-ui:message key="annoucements.search.categories.label"/> :
			<c:forEach items="${parentCategoryList}" var="parentCategory">
				${parentCategory}
			</c:forEach>
		</div>
		</aui:row>
	</c:if>
<hr>

<c:forEach items="${announcements}" var="announcement">
	<c:set var="announcementImage" value="${announcement.getImage()}"></c:set>
	
	<aui:row>
		<div class="span10 offset1">
			<aui:row>
				<div class="span12">
					<h3>					
						<strong><a href="${announcement.getAnnouncementUrl(liferayPortletRequest, liferayPortletResponse)}">${announcement.getTitle(locale)}</a></strong>
					</h3>
				</div>
			</aui:row>
			<aui:row>
				<div class="span3">
					<c:if test="${announcementImage ne null}">
						<img class="thumbnail"
						id="${announcementImage.announcementId}"
						alt="${announcementImage.getDescription(locale)}"
						src="${announcementImage.getImageURL(themeDisplay)}">
					</c:if>
					
				</div>
				<div class="span6">
					${announcement.getSummary(themeDisplay.locale)}
				</div>
				<div class="span3">
					<aui:row cssClass="well">
						<p><strong><liferay-ui:message key="annoucements.search.price.label"></liferay-ui:message> : ${announcement.price} ${announcement.getCurrencySymbol()}</strong></p>
						<p><i class="icon-comment"></i> ${announcement.getMessagesCount()} |
						<i class="icon-thumbs-up"></i> ${announcement.getRatingsCount()} </p>
					</aui:row>
				</div>
			</aui:row>
			<hr>
			<aui:row>
				<div class="span12">
					<p>
						<i class="icon-user icon-large" style="color:#00a2fb"></i> <liferay-ui:message key="By"></liferay-ui:message> ${announcement.userName} |
						<i class="icon-calendar-empty icon-large" style="color:#00a2fb"></i> <fmt:formatDate type="date" value="${announcement.createDate}" /> |
						<i class="icon-calendar icon-large" style="color:#00a2fb"></i> <fmt:formatDate type="both" value="${announcement.modifiedDate}" /> | 
						<i class="icon-cloud icon-large" style="color:#00a2fb"></i> ${announcement.getType().getName(locale)} |
						<i class="icon-tags icon-large"  style="color:#6B62D0"></i>
							<liferay-ui:asset-categories-summary
							className="<%= Announcement.class.getName() %>"
							classPK="${announcement.announcementId}"
							/>
					</p>
				</div>
			</aui:row>
		</div>
	</aui:row>
	<hr>
</c:forEach>

<c:if test='${total >= delda}'>
	<div class="pagination pagination-centered pagination-large" id='<portlet:namespace/>announcementPagination'>
		<ul>
			<li class="<c:if test='${page <= 0}'>disabled</c:if> ">
				<a target="_self" href="" title="<liferay-ui:message key="Previous"/>" onclick="<c:if test='${page-1 >= 0}'><portlet:namespace/>search(${page-1},true);</c:if>return false;">&larr; <liferay-ui:message key="Previous"/></a>
			</li>
			<c:forEach begin="1" step="${delda}" end="${total}" var="pageNumber" varStatus="varStatus">
				<li class="<c:if test='${page+1 == varStatus.count}'>disabled</c:if>">
					<a target="_self" href="" title="${varStatus.count}" onclick="<c:if test='${page+1 != varStatus.count}'><portlet:namespace/>search(${varStatus.count-1},true);</c:if>return false;">${varStatus.count}</a>
				</li>
			</c:forEach>
			<li class="<c:if test='${total <= end}'>disabled</c:if> ">
				<a target="_self" href="" title="<liferay-ui:message key="Next"/>" onclick="<c:if test='${total > end}'><portlet:namespace/>search(${page+1},true);</c:if>return false;"><liferay-ui:message key="Next"/> &rarr;</a>
			</li>
		</ul>
	</div>
</c:if>