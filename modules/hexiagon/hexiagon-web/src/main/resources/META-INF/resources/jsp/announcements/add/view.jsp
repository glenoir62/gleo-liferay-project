<%@page import="com.gleo.plugins.hexiagon.model.Announcement"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@include file="/jsp/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<liferay-ui:header
	backURL="${redirect}"
	title='${title}'
/>

<aui:model-context bean="${announcement}" model="${model}" />

<portlet:actionURL var="editAnnouncementURL" windowState="normal" name="${actionName}">
	<portlet:param name="redirect" value="${redirect}"/>
</portlet:actionURL>

<liferay-ui:success key="announcement-added" message="annoucements.add.success.added"/>
<liferay-ui:success key="announcement-updated" message="annoucements.add.success.updated"/>
<liferay-ui:success key="announcement-deleted" message="annoucements.add.success.deleted"/>

<liferay-ui:error key="announcement-errors" message="announcement-errors" />

<aui:form action="${editAnnouncementURL}" enctype="multipart/form-data" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value='${redirect}' />
		<aui:input type="hidden" name="announcementId"/>

		<liferay-ui:error key="announcementtitle-required" message="annoucements.add.announcement.title.required" />
		<aui:input name="title" label="annoucements.add.title.label"/>
		<hr>
		
		<liferay-ui:error key="announcementtype-required" message="annoucements.add.errors.type.required" />
		<aui:field-wrapper name="typeId" label="annoucements.add.type.label" inlineField="right">
			<c:forEach var="type" items="${types}">
				<aui:input inlineField="true" type="radio" label="${type.getName(locale)}" localized="false" name="typeId" value="${type.getTypeId()}" checked="${announcement.typeId eq type.typeId}"/>
			</c:forEach>
		</aui:field-wrapper>
		<hr>
		
		<liferay-ui:panel iconCssClass="icon-info" defaultState="open" extended="true" id="announcementInfo" persistState="false" title="annoucements.add.panel.informations.title">
			<aui:row>					 
				<aui:col span="4" >
					<aui:row fluid="true">
						<liferay-ui:error key="announcementprice-required" message="annoucements.add.panel.informations.errors.price.required" />
						<aui:input name="price" label="annoucements.add.panel.informations.price.label"/>
					</aui:row>
					
					<aui:row fluid="true">
						<aui:select name="currencyId" label="annoucements.add.panel.informations.currency.label" showEmptyOption="true">
							<c:forEach var="currency" items="${currencies}">
								<aui:option label="${currency.getSymbol()}" value="${currency.getCurrencyId()}" useModelValue="<%= false %>" selected="${announcement ne null ? announcement.getCurrencyId() == currency.getCurrencyId() : defaultCurrencyId == currency.getCurrencyId()}"></aui:option>
				 			</c:forEach>
						</aui:select>
					</aui:row>
					
					<aui:input name="city" label="annoucements.add.panel.informations.city.label"/>
				</aui:col>
				
				<aui:col span="4">
					<liferay-ui:error key="announcementemail-required" message="annoucements.add.panel.informations.errors.email.required" />
					<liferay-ui:error key="announcementemail-format-error"	message="annoucements.add.panel.informations.email.format.error" />
					
					<aui:input name="emailAddress" label="annoucements.add.panel.informations.emailAddress.label"/>
			
					<liferay-ui:error key="announcementphonenumber-required" message="annoucements.add.panel.informations.errors.phonenumber.required" />
					<liferay-ui:error key="announcementphonenumber-format-error" message="annoucements.add.panel.informations.errors.phonenumber.format.error" />
					
					<aui:input name="phoneNumber" label="annoucements.add.panel.informations.phoneNumber.label" />
					
					<aui:input name="site" label="annoucements.add.panel.informations.site.label"/>
				</aui:col>
				
				<aui:col span="4">
					<liferay-ui:error key="announcementcountry-required" message="annoucements.add.errors.country.required" />
					<aui:select label="annoucements.add.panel.informations.country.label" name="countryId" showEmptyOption="true"/>
		
					<liferay-ui:error key="announcementregion-required" message="annoucements.add.errors.region.required" />
					<aui:select label="annoucements.add.panel.informations.region.label" name="regionId" showEmptyOption="true"/>
					
					<aui:input name="building" label="annoucements.add.panel.informations.building.label"/>
				</aui:col>
			</aui:row>
		</liferay-ui:panel>
		
		<liferay-ui:panel iconCssClass="icon-sitemap" defaultState="open" extended="true" id="announcementCategorizationPanel" persistState="false" title="annoucements.add.panel.categories.title">
			<aui:field-wrapper>
					<liferay-ui:asset-categories-selector classPK="${announcement.announcementId}" className="${model.getName()}" ></liferay-ui:asset-categories-selector>
			 </aui:field-wrapper>
		</liferay-ui:panel>
		
		<br>
		<liferay-ui:error key="announcementcontent-required" message="annoucements.add.panel.categories.errors.content.required" />
		<aui:field-wrapper label="annoucements.add.panel.categories.content.label" name="editor">
			<liferay-ui:input-editor name="editor" resizable="true"></liferay-ui:input-editor>
		</aui:field-wrapper>
		
		<aui:row>
		<c:forEach begin="1" end="${imageLimit}" var="index">
			<div class="span4">
			<c:set value="${announcementImages[index]}" var="announcementImage" />
			
			<liferay-ui:error key="image-size-error${index}" message="annoucements.add.images.errors.image.size.error" />
			<liferay-ui:error key="image-extension-error${index}" message="annoucements.add.images.errors.image.extension.error" />
			
	     	<liferay-ui:panel iconCssClass="icon-picture" defaultState="open" extended="true" id="announcementAbstractPanel${index}" persistState="false" title="annoucements.add.images.image.${index}">
					<aui:input type="hidden" name="announcementImageId${index}" value='${announcementImage.announcementImageId}' />
					<aui:input type="hidden" name="imageDisabled${index}" value="false"/>
					<aui:input type="hidden" name="order" value="false"/>
							
					<a class="btn btn-warning" href="javascript:;" id="<portlet:namespace/>${index}DeleteImage" onclick="<portlet:namespace/>${index}DeleteImage();">
						<liferay-ui:message key="delete"/>
					</a>
					<br>
					<br>
					
					<div id="<portlet:namespace/>placeholderImage${index}" class="text-center well">
						<c:set value="${announcementImages[index]}" var="announcementImage" />
						
						<c:set value="<%= themeDisplay.getScopeGroupName() %>" var="announcementImageDescription" />
						<c:set value="<%= themeDisplay.getCompanyLogo() %>" var="announcementImageUrl" />
						
						<c:if test="${announcementImage ne null}">
							<c:set value="${announcementImage.getImageURL(themeDisplay)}" var="announcementImageUrl" />
							<c:set value="${announcementImage.getDescription(locale)}" var="announcementImageDescription" />
						</c:if>
						<img id="<portlet:namespace/>${index}Image" style="max-width: 150px;" class="img-rounded" alt="${announcementImageDescription}" src="${announcementImageUrl}" />
					</div>
					
					<br>
					<aui:input type="hidden" name="announcementImageUrlSrc${index}" value="${announcementImageUrl}"></aui:input>
					
					<aui:input type="hidden" name="order" value="false"/>
					<aui:script use="aui-base">
						
						Liferay.provide(
								window,
								'<portlet:namespace/>${index}DeleteImage',
								function() {
									var A = AUI();
						
									var buttonText = 'cancel';
									var disabled = true;
						
									var imageInputNode = A.one('#<portlet:namespace/>image${index}');
						
									if (imageInputNode.get('disabled')) {
										buttonText = 'delete';
										disabled = false;
										
									}
									
									A.one('#<portlet:namespace/>${index}DeleteImage').setContent(buttonText);
									A.one('#<portlet:namespace/>imageDisabled${index}').attr('value', disabled);
						
									imageInputNode.attr('disabled', disabled);
						
									A.one('#<portlet:namespace/>${index}Image').toggle();
								},
								['aui-base']
							);
					</aui:script>
	
					<aui:fieldset>
						<aui:input inlineField="true" name="image${index}" type="file" label="annoucements.add.images.image.label"/>
						<aui:script use="aui-base">
							A.one('#<portlet:namespace/>image${index}').on('change',function(event){
								var id = this.attr('id');
				            	var input = document.getElementById(id);
				            	
								if (input.files && input.files[0]) {
							       var reader = new FileReader();
							       
							       reader.onload = function (e) {
							       		
							       		A.one('#<portlet:namespace/>announcementImageUrlSrc${index}').val(e.target.result);
							       		
							       		if (A.one('#<portlet:namespace/>${index}Image')) {
							       			A.one('#<portlet:namespace/>${index}Image').attr('src', e.target.result);
							       		} else {
							       			A.one('#<portlet:namespace/>placeholderImage${index}').append(A.Node.create('<img id="<portlet:namespace/>${index}Image" class="img-rounded" alt="${announcementImage.getDescription(locale)}" src="'+ e.target.result +'" />'));
							       		}
							       		
							       }
							       reader.readAsDataURL(input.files[0]);
							   }
							});
						</aui:script>
					</aui:fieldset>
					
					<aui:fieldset>
						<c:set value="${announcementImage}" var="bean" />
						
						<c:if test="${bean eq null}">
							<c:set value="${imageBean}" var="bean" />
						</c:if>
						<aui:input helpMessage="describe-your-announcement-for-visually-impaired" inlineField="true" label="annoucements.add.images.description.label" field="description" name="description${index}" id="description${index}" fieldParam="description${index}" model="${imageModel}" bean="${bean}" />
					</aui:fieldset>

			</liferay-ui:panel>
			</div>
		</c:forEach>
		</aui:row>
		
		<div style="clear: both;" />
		<br>
		<br>
		
		<liferay-ui:error key="announcementagreement-required" message="annoucements.add.agreement.required" />
		<aui:field-wrapper name="agreement" label="annoucements.add.agreement.label" inlineField="right">
			<aui:input name="agreement" type="checkbox" label="annoucements.add.agreement.approve" checked="${announcement ne null}">
			</aui:input>
			<br>
			<aui:a href="${previewFileURL}" label="annoucements.add.agreement.show.label" target="_blank" />
		</aui:field-wrapper>
	</aui:fieldset>
	
	<%--
		<c:if test="${announcement eq null}">
			<aui:field-wrapper label="annoucements.add.permissions.label">
				<liferay-ui:input-permissions
					modelName="${model.getName()}"
					/>
			</aui:field-wrapper>
		</c:if>
	--%>
	
	<c:if test="${isRelatedAssetActivated}">
		<liferay-ui:panel defaultState="closed" extended="<%= false %>" id="artistAssetLinksPanel" persistState="<%= true %>" title="annoucements.add.permissions.related.assets.title">
			<aui:fieldset>
				<liferay-ui:input-asset-links
					className="<%= Announcement.class.getName() %>"
					classPK="${announcement.announcementId}"
				/>
			</aui:fieldset>
		</liferay-ui:panel>
	</c:if>
	
	<aui:button-row>
		<aui:button type="submit" cssClass="btn btn-primary" onClick="${renderResponse.getNamespace()}extractCodeFromEditor();" />

		<aui:button type="cancel" onClick="${redirect}"/>
	</aui:button-row>
</aui:form>

<aui:script use="aui-base,aui-form-validator,liferay-form,liferay-dynamic-select">

	new Liferay.DynamicSelect(
			[
				{
					select: '<portlet:namespace />countryId',
					selectData: Liferay.Address.getCountries,
					selectDesc: 'nameCurrentValue',
					selectSort: '<%= true %>',
					selectId: 'countryId',
					selectVal: '${countryId}'
				},
				{
					select: '<portlet:namespace />regionId',
					selectData: Liferay.Address.getRegions,
					selectDesc: 'name',
					selectId: 'regionId',
					selectVal: '${regionId}'
				}
			]
		);
	
	A.on('domready', function(event){
		A.config.FormValidator.STRINGS.fileSizeRule ='Image should be < ${fileSizeRule}.';
		
		A.config.FormValidator.RULES.fileSizeRule = function(val, fieldNode, ruleValue) {
		     	var name = fieldNode.attr('id');
		     	var input = document.getElementById(name);
		        var fileSize = input.files[0].size;
		         
		return ((fileSize < ${fileSizeRule}) || fieldNode.get('disabled'));
		 };
		 
		var rules = {
			<portlet:namespace/>title: {
			 	required: true
			},
			<portlet:namespace/>typeId: {
			 	required: true
			},
			<portlet:namespace/>agreementCheckbox: {
			 	required: true
			},
			<portlet:namespace/>editor: {
			 	required: true
			},
			<portlet:namespace/>emailAddress: {
			 	email: true,
			 	required: true
			},
			<portlet:namespace/>phoneNumber: {
				digits: true,
				minLength: 5,
				maxLength: 10,
				required: true
			},
			<portlet:namespace/>countryId: {
				min: 1
			},
			<portlet:namespace/>regionId: {
				min: 1
			},
			<portlet:namespace/>price: {
			 	required: true,
			 	number: true,
			 	range:  [0,${maxPrice}]
			},
			<c:forEach var="vocabularyId" items="${vocabularyIds}">
				<portlet:namespace/>assetCategoryIds_${vocabularyId}: {
					 	required: true
				},
			</c:forEach>
			<c:forEach begin="1" end="${imageLimit}" var="index">
				<portlet:namespace/>image${index}: {
				 	acceptFiles: '${acceptFiles}',
				 	fileSizeRule: true
				},
			</c:forEach>		
		};
		
		var fieldStrings = {
			<portlet:namespace/>countryId: {
				min: '<liferay-ui:message key="this-field-is-required" />'
			},
			<portlet:namespace/>regionId: {
				min: '<liferay-ui:message key="this-field-is-required" />'
			}
		};
		var validator = new A.FormValidator({
			boundingBox: document.<portlet:namespace />fm,
			rules: rules,
			fieldStrings: fieldStrings,
			validateOnBlur: true
		});
	});
</aui:script>

<aui:script>
	function <portlet:namespace />initEditor() {
		return "${content}";
	}
	
	function <portlet:namespace />extractCodeFromEditor() {
	   document.<portlet:namespace />fm.<portlet:namespace />editor.value = window.<portlet:namespace />editor.getHTML();
	}
</aui:script>
 