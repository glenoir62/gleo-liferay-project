<%@include file="/jsp/init.jsp" %>

<% 
	pageContext.setAttribute("carriageReturn", "\r");
	pageContext.setAttribute("newLine", "\n");
%>

<aui:row cssClass="text-center">
	<div id="<portlet:namespace/>canvas_france">
	
	
	</div>
</aui:row>

<c:set var="singleQuotes">'</c:set>
<c:set var="singleQuotesReplace">\'</c:set>
<c:set var="doubleQuotes">"</c:set>
<c:set var="doubleQuotesReplace">\"</c:set>

<aui:script use="aui-base,aui-map">

A.on('domready', function(event) {
	
	var placeHolder = A.one('#<portlet:namespace />canvas_france');
	var width = placeHolder.get('offsetWidth');
	
	var paper = new Raphael(document.getElementById('<portlet:namespace />canvas_france'), 587.5, 550);
	
	if (width < 587.5) {
		paper.setViewBox(0, 0, 587.5*(587.5/width), 550*(550/(width*0.93)), true);
	}
	console.log(placeHolder.get('offsetWidth'));
	
	var attr = {
		fill: "#e5e5e5",
		stroke: "#959595",
		"stroke-width": 1,
		"stroke-linejoin": "round"
	};
	var region = {};
	
	<c:forEach var="region" items="${regions}">
		region.${region.regionCode} = paper.path(hasMapHexagon.getValue('${region.regionCode}')).attr(attr);
		region.${region.regionCode}.attr({title: '${fn:replace(fn:replace(fn:replace(fn:replace(region.name,carriageReturn,' '),newLine,' '), singleQuotes, singleQuotesReplace),doubleQuotes,doubleQuotesReplace)}', href:"${region.regionId}"});
	</c:forEach>
	
	var current = null;
	for ( var state in region) {
		region[state].color = "#c6d2ec";
		(function(st, state) {
			st[0].style.cursor = "pointer";
			st[0].onmouseover = function() {
				st.animate({
					fill : st.color
				}, 100);
				paper.safari();
			};
			st[0].onmouseout = function() {
				st.animate({
					fill : "#e5e5e5"
				}, 300);
				paper.safari();
			};
		})(region[state], state);
	}
	
	A.all("#<portlet:namespace />canvas_france a").on('click', function(event){
		event.preventDefault();
		var node = event.currentTarget;
		var regionId = node.getAttribute("href");
		
		console.log(regionId);
				
		// load IPC Search 
		Liferay.fire('LOAD_SEARCH_ANNONCEMENT_LOCALIZATION', 
			{
			      countryIdIPC : ${countryId},
			      regionIdIPC : regionId
			}
		);
	});

});

</aui:script>