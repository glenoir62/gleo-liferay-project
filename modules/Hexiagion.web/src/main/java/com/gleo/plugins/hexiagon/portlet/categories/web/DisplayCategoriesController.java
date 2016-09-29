package com.gleo.plugins.hexiagon.portlet.categories.web;

import com.gleo.plugins.hexiagon.model.Announcement;
import com.gleo.plugins.hexiagon.util.PortalUtil;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author guillaumelenoir
 * Portlet implementation class DisplayCategoriesController
 */
public class DisplayCategoriesController extends MVCPortlet {
	
	/**
	 * DisplayCategoriesController Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(DisplayCategoriesController.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		List<AssetVocabulary> vocabularies = new ArrayList<AssetVocabulary>();
		Map<AssetVocabulary, List<AssetCategory>> vocabulariesMap = new HashMap<AssetVocabulary, List<AssetCategory>>();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long[] categoryIds = ParamUtil.getLongValues(renderRequest, "categoryIds");
		try {

			Group siteGroup = themeDisplay.getSiteGroup();
			long scopeGroupId = themeDisplay.getScopeGroupId();
			vocabularies.addAll(AssetVocabularyServiceUtil.getGroupVocabularies(siteGroup.getGroupId(), false));
			
			if (scopeGroupId != themeDisplay.getCompanyGroupId()) {
				vocabularies.addAll(AssetVocabularyServiceUtil.getGroupVocabularies(themeDisplay.getCompanyGroupId(), false));
			}

			long classNameId = PortalUtil.getClassNameId(Announcement.class);

			// Select announcement vocabularies for announcement only.
			for (AssetVocabulary vocabulary : vocabularies) {
				vocabulary = vocabulary.toEscapedModel();

				int vocabularyCategoriesCount = AssetCategoryServiceUtil.getVocabularyCategoriesCount(vocabulary.getGroupId(), vocabulary.getVocabularyId());

				if (vocabularyCategoriesCount == 0) {
					continue;
				}

				//TODO
				if (vocabulary.isRequired(classNameId)){
					List<AssetCategory> assetCategories = AssetCategoryServiceUtil.getVocabularyRootCategories(themeDisplay.getScopeGroupId(), vocabulary.getVocabularyId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
					vocabulariesMap.put(vocabulary, assetCategories);
				}
			}
		}
		catch (SystemException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("SystemException: unable to get types or currencies or vocabularies");
		}
		catch (PortalException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("SystemException: unable to get types or currencies or vocabularies");
		}
		
		renderRequest.setAttribute("vocabulariesMap", vocabulariesMap);
		renderRequest.setAttribute("categoryIds", StringUtil.merge(categoryIds));
		renderRequest.setAttribute("htmlUtil", HtmlUtil.getHtml());

		super.doView(renderRequest, renderResponse);
	}
}
