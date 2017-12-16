
<%@include file="init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>

<liferay-ui:search-container id="users"
	searchContainer="${searchUserContainer}" var="searchUserContainer" total="${searchUserContainer.total}">


		<liferay-ui:search-container-row
			className="com.liferay.portal.kernel.model.User" keyProperty="userId"
			modelVar="user2" cssClass="entry-card lfr-asset-item">
			<liferay-ui:search-container-column-text>
				<liferay-frontend:vertical-card
					cssClass="entry-display-style"
					imageUrl="${user2.getPortraitURL(themeDisplay)}"
					title="${user2.getFullName()}"
					url="#"
				>
<%-- 				<liferay-frontend:vertical-card-sticker-bottom> --%>
<!-- 					<div class="sticker sticker-bottom file-icon-color-3"> -->
<!-- 						PDF -->
<!-- 					</div> -->
<!-- 					<div class="file-icon-color-0 sticker sticker-right"> -->
<%-- 						<aui:icon cssClass="icon-monospaced" image="lock" markupView="lexicon" message="locked" /> --%>
<!-- 					</div> -->
<%-- 				</liferay-frontend:vertical-card-sticker-bottom> --%>
					
<%-- 					<liferay-frontend:vertical-card-header> --%>
<%-- 						${user2.birthday} --%>
<%-- 					</liferay-frontend:vertical-card-header> --%>
					
					<liferay-frontend:vertical-card-footer>
						<aui:workflow-status markupView="lexicon" showIcon="<%= false %>" showLabel="<%= false %>" status="${user2.status}" />
					</liferay-frontend:vertical-card-footer>
				</liferay-frontend:vertical-card>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
	<liferay-ui:search-iterator displayStyle="icon" markupView="lexicon"/>
</liferay-ui:search-container>


<aui:script use="aui-base">

	A.all('#<portlet:namespace/>users .user-photo-group').on('click', function(event){
		event.preventDefault();
		var currentNode = event.currentTarget.one('input[type=checkbox]');
		var userId = currentNode.get('value');
		
		if (userId) {
			var portletURL = '${portletDirectoryURL}';
			var namespace = Liferay.Util.getPortletNamespace('<%= PortletKeys.DIRECTORY %>');
			portletURL = portletURL + '&' + namespace + 'p_u_i_d' + '=' + userId;
			
			Liferay.Util.openWindow (
		        {
	     			dialog: {
						destroyOnHide: true,
						width: 650,
						height: 450
					},
					title: Liferay.Language.get("User"),
		            id: '<portlet:namespace/>window-directory-user',
		            uri: portletURL
		        }
		    );
		}
	});

</aui:script>
