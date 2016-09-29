
package com.gleo.plugins.hexiagon.portlet.categories.web;

import com.gleo.plugins.hexiagon.portlet.categories.dto.Asset;
import com.gleo.plugins.hexiagon.portlet.categories.dto.Category;
import com.gleo.plugins.hexiagon.portlet.categories.dto.Vocabulary;
import com.gleo.plugins.hexiagon.util.PortalUtil;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.joda.time.DateTime;

/**
 * Portlet implementation class CategoryImportExportController
 */
public class CategoriesImporterController extends MVCPortlet {

	private static final Log LOGGER = LogFactoryUtil.getLog(CategoriesImporterController.class);

	/**
	 * @param resourceRequest
	 * @return
	 * @throws PortletException
	 * @throws IOException
	 */
	public Asset generateXML(ResourceRequest resourceRequest)
		throws PortletException, IOException {

		Asset asset = new Asset();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();

		try {
			Locale siteDefaultLocale = PortalUtil.getSiteDefaultLocale(groupId);
			// get all the vocabulary for group
			List<AssetVocabulary> assetVocabularyList = AssetVocabularyLocalServiceUtil.getGroupVocabularies(themeDisplay.getScopeGroupId());
			ArrayList<Vocabulary> vocabularyList = new ArrayList<Vocabulary>();

			for (AssetVocabulary assetVocabulary : assetVocabularyList) {
				Vocabulary vocabulary = new Vocabulary();

				// get child(first level) category for vocabulary
				List<AssetCategory> vocabularyCategories = AssetCategoryLocalServiceUtil.getVocabularyRootCategories(assetVocabulary.getVocabularyId(), -1, -1, null);

				List<Category> categoryList = new ArrayList<Category>();

				for (AssetCategory assetCategory : vocabularyCategories) {
					Category category = new Category();

					category.setTitle(assetCategory.getTitle(siteDefaultLocale));
					category.setDescription(assetCategory.getDescription(siteDefaultLocale));
					// get child categories
					int childCount = AssetCategoryLocalServiceUtil.getChildCategoriesCount(assetCategory.getCategoryId());
					category.setChildCategoryCount(childCount);
					if (childCount > 0) {
						category.setCategory(getChildCategory(assetCategory.getCategoryId(), siteDefaultLocale));
					}

					categoryList.add(category);
				}
				vocabulary.setTotalChildCount(AssetCategoryLocalServiceUtil.getVocabularyCategoriesCount(assetVocabulary.getVocabularyId()));
				vocabulary.setTitle(assetVocabulary.getTitle(siteDefaultLocale));
				vocabulary.setDescription(assetVocabulary.getDescription(siteDefaultLocale));
				vocabulary.setCategory(categoryList);
				vocabularyList.add(vocabulary);
			}
			asset.setCompanyName(themeDisplay.getCompany().getName());
			asset.setVocabularyList(vocabularyList);

		}
		catch (PortalException e) {
			LOGGER.error("Error while export category structure" + e.getMessage(), e);
		}
		catch (SystemException e) {
			LOGGER.error("Error while export category" + e.getMessage(), e);
		}
		return asset;
	}

	/**
	 * @param categoryId
	 * @param siteDefaultLocale
	 * @return
	 */
	public List<Category> getChildCategory(long categoryId, Locale siteDefaultLocale) {

		List<Category> categoryList = new ArrayList<Category>();
		try {
			List<AssetCategory> childCategory = AssetCategoryLocalServiceUtil.getChildCategories(categoryId);
			for (AssetCategory assetCategory : childCategory) {
				Category category = new Category();
				category.setTitle(assetCategory.getTitle(Locale.ENGLISH));
				category.setDescription(assetCategory.getDescription(Locale.ENGLISH));
				int childCount = AssetCategoryLocalServiceUtil.getChildCategoriesCount(assetCategory.getCategoryId());
				category.setChildCategoryCount(childCount);
				if (childCount > 0) {
					category.setCategory(getChildCategory(assetCategory.getCategoryId(), siteDefaultLocale));
				}
				categoryList.add(category);
			}
		}
		catch (SystemException e) {
			LOGGER.error("Error while get child category structure" + e.getMessage(), e);
		}
		return categoryList;
	}

	/**
	 * @param asset
	 * @param resourceRequest
	 * @param resourceResponse
	 * @throws IOException
	 */
	private void writeXML(Asset asset, ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException {

		try {
			// create JAXB context and instantiate marshaller
			JAXBContext context = JAXBContext.newInstance(Asset.class);

			String filename = "export" + DateTime.now().toString("yyyyMMdd");
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			marshaller.marshal(asset, baos);
			resourceResponse.setContentType("application/xml");
			resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + ".xml\" ");
			resourceResponse.setContentLength(baos.size());
			OutputStream out = resourceResponse.getPortletOutputStream();
			baos.writeTo(out);
			out.flush();
			out.close();
		}
		catch (JAXBException e) {
			LOGGER.error("Error while generate file" + e.getMessage(), e);
		}
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortletException {

		Asset asset = generateXML(resourceRequest);
		writeXML(asset, resourceRequest, resourceResponse);
	}

	@ProcessAction(name = "import")
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
		throws IOException, PortletException {

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		File file = uploadPortletRequest.getFile("fileCategory");
		try {
			Locale siteDefaultLocale = PortalUtil.getSiteDefaultLocale(themeDisplay.getScopeGroupId());
			readXML(themeDisplay, file, siteDefaultLocale);
		}
		catch (PortalException e) {
			LOGGER.error(e);
		}
		catch (SystemException e) {
			LOGGER.error(e);
		}

	};

	/**
	 * @param themeDisplay
	 * @param file
	 * @param siteDefaultLocale
	 */
	public void readXML(ThemeDisplay themeDisplay, File file, Locale siteDefaultLocale) {

		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setScopeGroupId(themeDisplay.getScopeGroupId());
		Asset asset = getAssetFromXml(file);
		List<Vocabulary> vocabularyList = asset.getVocabulariesList();
		for (Vocabulary vocab : vocabularyList) {
			Map<Locale, String> titleMap = new HashMap<Locale, String>();
			titleMap.put(siteDefaultLocale, vocab.getTitle());
			Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
			descriptionMap.put(siteDefaultLocale, vocab.getDescription());
			AssetVocabulary createdVocabulary = null;
			try {
				createdVocabulary = AssetVocabularyLocalServiceUtil.addVocabulary(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), vocab.getTitle(), titleMap, descriptionMap, null, serviceContext);
				LOGGER.info("Import :  new vocabulary created :" + vocab.getTitle() + " : category_id : " + createdVocabulary.getVocabularyId());
			}
			catch (PortalException e) {
				try {
					createdVocabulary = AssetVocabularyLocalServiceUtil.getGroupVocabulary(themeDisplay.getScopeGroupId(), vocab.getTitle());
					LOGGER.info("Import : vocabulary already exist :" + vocab.getTitle() + " : category_id : " + createdVocabulary.getVocabularyId());
				}
				catch (PortalException e1) {
					LOGGER.error("Error while get vocabulary with name : " + vocab.getTitle() + "  :: " + e.getMessage(), e);
				}
				catch (SystemException e1) {
					LOGGER.error("Error while get vocabulary with name : " + vocab.getTitle() + "  :: " + e.getMessage(), e);
				}
			}
			catch (SystemException e) {
				LOGGER.error("Error while create vocabulary with name : " + vocab.getTitle() + "  :: " + e.getMessage(), e);
			}
			List<Category> categories = vocab.getCategory();
			if (categories != null && !categories.isEmpty()) {
				for (Category cat : categories) {
					getChildCategory(cat, 0, themeDisplay, siteDefaultLocale, createdVocabulary.getVocabularyId(), serviceContext);
				}
			}
		}
	}

	/**
	 * @param cat
	 * @param parentCategoryId
	 * @param themeDisplay
	 * @param siteDefaultLocale
	 * @param vocabularyId
	 * @param serviceContext
	 */
	private void getChildCategory(Category cat, long parentCategoryId, ThemeDisplay themeDisplay, Locale siteDefaultLocale, long vocabularyId, ServiceContext serviceContext) {

		Map<Locale, String> titleMap = new HashMap<Locale, String>();
		titleMap.put(siteDefaultLocale, cat.getTitle());
		Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
		descriptionMap.put(siteDefaultLocale, cat.getDescription());
		AssetCategory createdCategory = null;
		try {
			createdCategory = AssetCategoryLocalServiceUtil.addCategory(themeDisplay.getUserId(),themeDisplay.getScopeGroupId(), parentCategoryId, titleMap, descriptionMap, vocabularyId, null, serviceContext);
			LOGGER.info("Import :  new category created :" + cat.getTitle() + " : category_id : " + createdCategory.getCategoryId());
		}
		catch (PortalException e) {
			try {

				DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(AssetCategory.class);
				dynamicQuery.add(PropertyFactoryUtil.forName("name").eq(cat.getTitle()));
				
				List<AssetCategory> createdCategoryList = AssetCategoryLocalServiceUtil.dynamicQuery(dynamicQuery);
				for (AssetCategory catt : createdCategoryList) {
					if (catt.getParentCategoryId() == parentCategoryId && catt.getGroupId() == themeDisplay.getScopeGroupId()) {
						createdCategory = catt;
						LOGGER.info("Import : category already exist :" + cat.getTitle() + " : category_id : " + createdCategory.getCategoryId());
						break;
					}
				}
			}
			catch (SystemException e1) {
				LOGGER.error("Error while search category vocabulary with name : " + cat.getTitle() + "  :: " + e1.getMessage(), e1);
			}
		}
		catch (SystemException e) {
			LOGGER.error("Error while create category with name : " + cat.getTitle() + "  :: " + e.getMessage(), e);
		}
		if (cat.getCategory() != null && !cat.getCategory().isEmpty()) {
			for (Category childCat : cat.getCategory()) {
				getChildCategory(childCat, createdCategory.getCategoryId(), themeDisplay, siteDefaultLocale, vocabularyId, serviceContext);
			}
		}
	}

	/**
	 * @param file
	 * @return
	 */
	private Asset getAssetFromXml(File file) {

		Asset asset = null;
		try {
			if (file != null) {
				JAXBContext jaxbContext = JAXBContext.newInstance(Asset.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				asset = (Asset) jaxbUnmarshaller.unmarshal(file);
				return asset;
			}
		}
		catch (JAXBException e) {
			LOGGER.error("Error while unmarshal for file : " + e.getMessage(), e);
		}
		return asset;
	}
}
