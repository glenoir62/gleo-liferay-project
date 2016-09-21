<%@include file="/jsp/init.jsp" %>

<div id='<portlet:namespace/>viewAnnouncementCategories'>
	<c:forEach items="${vocabulariesMap}" var="vocabulary">
		<liferay-ui:panel iconCssClass="icon-circle-blank" defaultState="open" extended="true" id="announcementCategoryAbstractPanel${vocabulary.key.vocabularyId}" persistState="false" title="${vocabulary.key.getTitle(locale)}">
			<div id='<portlet:namespace/>Tree${vocabulary.key.vocabularyId}'>
			
			</div>
		</liferay-ui:panel>
		
		<aui:script use="aui-base,aui-tree-view">

			getCN = A.getClassName;
			
			 var CSS_CLASSES = {
				file: {
					iconCheck: getCN('icon', 'check'),
					iconCollapsed: getCN('icon', 'tags'),
					iconExpanded: getCN('icon', 'tags'),
					iconHitAreaCollapsed: [getCN('tree', 'hitarea'), getCN('icon', 'plus', 'sign')].join(' '),
					iconHitAreaExpanded: [getCN('tree', 'hitarea'), getCN('icon', 'minus', 'sign')].join(' '),
					iconLeaf:  getCN('icon', 'tag'),
					iconLoading: getCN('icon', 'refresh'),
					iconUncheck:  getCN('icon', 'check')
				},
				normal: {
					iconCheck: getCN('icon', 'check'),
					iconHitAreaCollapsed: [getCN('tree', 'hitarea'), getCN('icon', 'plus')].join(' '),
					iconHitAreaExpanded: [getCN('tree', 'hitarea'), getCN('icon', 'minus')].join(' '),
					iconLoading: getCN('icon', 'refresh'),
					iconUncheck:  getCN('icon', 'check')
				}
			};
			  
			  var REGEX_TREE_NODE_ID = /(\d+)$/;
			  var categoryIdsTab = '${categoryIds}'.split(',');
			   
				function confIO() {
					this.conf = {
						cache : true,
						url : '${themeDisplay.getPathMain()}' + '/asset/get_categories',
						formatter : function(json) {
							var output = [];
				
							A.each(json, function(node) {
							
								var item = {
									label : Liferay.Util.escapeHTML(node.name),
									leaf : !node.hasChildren,
									id : "<portlet:namespace/>" + node.categoryId,
									io : new confIO().conf,
									cache : true,
									expanded : false,
									type : 'check',
									checked : (A.Array.indexOf(categoryIdsTab, String(node.categoryId)) != -1),
									after : { checkedChange : function(e){ <portlet:namespace />loadSearch(e);}},
									cssClasses:  CSS_CLASSES
								};
				
								output.push(item);
							});
				
							return output;
						},
						cfg : {
							data : function(treeNode) {
				
								var data = {
									p_auth : Liferay.authToken
								};
				
								var treeId = treeNode.get('id');
				
								if (treeId) {
									var match = treeId.match(REGEX_TREE_NODE_ID);
									var assetId = match && match[1];
									data.categoryId = assetId;
								}
								return data;
							}
						}
					};
				}
	
			    var treeView  = new A.TreeViewDD(
			      {
			        boundingBox: '#<portlet:namespace/>Tree${vocabulary.key.vocabularyId}',
			        children:  [
								<c:forEach items="${vocabulary.value}" var="category">
									{ 	
										expanded: false,
										cache: true,
										label: Liferay.Util.escapeHTML("${htmlUtil.escapeJS(category.getTitle(locale))}"),
										leaf: ${category.leftCategoryId+1 eq category.rightCategoryId},
										type:'check',
										id : '<portlet:namespace />${category.categoryId}',
										io: new confIO().conf,
										value: ${category.categoryId},
										checked : (A.Array.indexOf(categoryIdsTab,'${category.categoryId}') != -1),
										after : { checkedChange : function(e){ <portlet:namespace />loadSearch(e);}},
										cssClasses:  CSS_CLASSES
									},
								</c:forEach>
			        			],
			      }
			    ).render();
			    
		</aui:script>
	</c:forEach>
	</div>

<aui:script use="aui-base">
	var REGEX_TREE_NODE_ID = /(\d+)$/;
	
	Liferay.provide(window,'<portlet:namespace />loadSearch',function(e) {
		var currentNode = e.currentTarget;
		var categoryIds = A.all('#<portlet:namespace/>viewAnnouncementCategories .tree-node-checked');
		var categoryIdsTab = [];
		
		// get checked node
		if (currentNode.isChecked()) {
			var currentNodeId =	currentNode.get('id');
			if (currentNodeId) {
				var match = currentNodeId.match(REGEX_TREE_NODE_ID);
				categoryIdsTab.push(match && match[1]);
			}	
		}
		
		A.each(categoryIds, function(item, index, collection) {
			var parent = item.get('parentNode');
			var nodeId = parent.get('id');
			var categoryId = '';
			
			if (nodeId && nodeId != currentNode.get('id')) {
				var match = nodeId.match(REGEX_TREE_NODE_ID);
				categoryIdsTab.push(match && match[1]);
			}
		});
		
		// load IPC Search 
		Liferay.fire('LOAD_SEARCH_ANNONCEMENT_CATEGORIES', 
			{
			      categoryIdsTabIpc : categoryIdsTab
			}
		);
	});
</aui:script>