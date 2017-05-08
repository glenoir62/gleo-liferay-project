
package com.gleo.plugins.hexiagon.portlet.currency.web;

import com.gleo.plugins.hexiagon.constants.PortletKeys;
import com.gleo.plugins.hexiagon.model.Currency;
import com.gleo.plugins.hexiagon.service.CurrencyLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author guillaumelenoir
 * Portlet implementation class CurrencyConfigurationPortlet
 */
@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.hidden",
			"com.liferay.portlet.instanceable=false",
			"com.liferay.portlet.css-class-wrapper=currency-configuration-portlet",
			"javax.portlet.name=" + PortletKeys.HEXIAGON_CURRENCY_CONFIGURATION,
			"javax.portlet.display-name=Currency Configuration",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/jsp/currency/configuration/view.jsp",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user",
			"javax.portlet.init-param.copy-request-parameters=false",
			"javax.portlet.supports.mime-type=text/html"
		},
		service = Portlet.class
	)
public class CurrencyConfigurationPortlet extends MVCPortlet {

	/**
	 * CurrencyConfigurationPortlet portlet Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(CurrencyConfigurationPortlet.class);

	/**
	 * Empty Results Message
	 */
	private String emptyResultsMessage = "currency-empty-results-message";

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		PortletURL iteratorURL = renderResponse.createRenderURL();
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, SearchContainer.DEFAULT_DELTA);
		int cur = ParamUtil.getInteger(renderRequest, "curCurrencies", SearchContainer.DEFAULT_CUR);

		// create search container
		SearchContainer<Currency> searchCurrencyContainer = new SearchContainer<Currency>(renderRequest, null, null, "curCurrencies", cur, delta, iteratorURL, null, emptyResultsMessage);

		int start = searchCurrencyContainer.getStart();
		int end = searchCurrencyContainer.getEnd();

		try {
			List<Currency> currencies = CurrencyLocalServiceUtil.getCurrencies(start, end);
			int total = CurrencyLocalServiceUtil.getCurrenciesCount();

			searchCurrencyContainer.setTotal(total);
			searchCurrencyContainer.setResults(currencies);
		}
		catch (SystemException e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(e);
			}
			LOGGER.error("SystemException : impossible to get searchCurrencyContainer");
		}

		renderRequest.setAttribute("searchCurrencyContainer", searchCurrencyContainer);

		super.doView(renderRequest, renderResponse);
	}

}
