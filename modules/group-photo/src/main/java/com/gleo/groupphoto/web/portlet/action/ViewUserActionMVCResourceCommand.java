/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.gleo.groupphoto.web.portlet.action;

import com.gleo.groupphoto.web.constants.GroupPhotoPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.EmailAddress;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.Website;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.AddressServiceUtil;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.EmailAddressServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.PhoneServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.WebsiteServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author guillaumelenoir
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + GroupPhotoPortletKeys.GROUP_PHOTO,
	"mvc.command.name=/groupphoto/view_user" }, service = MVCResourceCommand.class)
public class ViewUserActionMVCResourceCommand extends BaseMVCResourceCommand {

    protected static Log LOGGER = LogFactoryUtil.getLog(ViewUserActionMVCResourceCommand.class);

    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

	long userId = ParamUtil.getLong(resourceRequest, "userId");
	ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

	StringBundler organizationsHTML = null;
	Contact contact = null;
	List<Organization> organizations = null;
	User user = null;
	Company company = null;
	Locale locale = themeDisplay.getLocale();

	String birthday = null;
	String jobTitle = null;
	String gender = null;

	// Get User
	if (userId > 0) {

	    try {
		user = UserLocalServiceUtil.getUser(userId);
		company = CompanyLocalServiceUtil.getCompany(user.getCompanyId());

	    } catch (PortalException e) {
		LOGGER.error(e);
	    }

	    if (user != null) {
		// Get Contact
		try {
		    contact = user.getContact();

		} catch (PortalException e) {
		    LOGGER.error(e);
		}

		// Get Organizations
		organizations = OrganizationLocalServiceUtil.getUserOrganizations(user.getUserId());
		organizationsHTML = new StringBundler(organizations.size() * 2);

		if (!organizations.isEmpty()) {
		    organizationsHTML.append(organizations.get(0).getName());
		}

		for (int i = 1; i < organizations.size(); i++) {
		    organizationsHTML.append(", ");
		    organizationsHTML.append(organizations.get(i).getName());
		}

		// Fields
		setFields(resourceRequest, contact, user, company, locale, birthday, gender, jobTitle);
		
		// Contact
		String className = Contact.class.getName();
		long classPK =  contact.getContactId();

		List<Address> personalAddresses = Collections.emptyList();
		List<Address> organizationAddresses = new ArrayList<Address>();
		List<EmailAddress> emailAddresses = Collections.emptyList();
		List<Website> websites = Collections.emptyList();
		List<Phone> personalPhones = Collections.emptyList();
		List<Phone> organizationPhones = new ArrayList<Phone>();
		
		if (classPK > 0) {
		    try {
			personalAddresses = AddressServiceUtil.getAddresses(className, classPK);
		    } catch (PortalException pe) {
			LOGGER.error(pe);
		    }

		    try {
			emailAddresses = EmailAddressServiceUtil.getEmailAddresses(className, classPK);
		    } catch (PortalException pe) {
			LOGGER.error(pe);
		    }
		    
		    try {
			websites = WebsiteServiceUtil.getWebsites(className, classPK);
		    } catch (PortalException pe) {
			LOGGER.error(pe);
		    }
		    try {
			personalPhones = PhoneServiceUtil.getPhones(className, classPK);
		    } catch (PortalException pe) {
			LOGGER.error(pe);
		    }

		}

		for (int i = 0; i < organizations.size(); i++) {
			try {
				organizationAddresses.addAll(AddressServiceUtil.getAddresses(Organization.class.getName(), organizations.get(i).getOrganizationId()));
			}
			catch (Exception e) {
			}
		}
		

		for (int i = 0; i < organizations.size(); i++) {
			try {
				organizationPhones.addAll(PhoneServiceUtil.getPhones(Organization.class.getName(), organizations.get(i).getOrganizationId()));
			}
			catch (Exception e) {
			}
		}
		
		resourceRequest.setAttribute("organizationAddresses", organizationAddresses);
		resourceRequest.setAttribute("personalAddresses", personalAddresses);
		resourceRequest.setAttribute("emailAddresses", emailAddresses);
		resourceRequest.setAttribute("organizationAddresses", organizationAddresses);
		resourceRequest.setAttribute("websites", websites);
		resourceRequest.setAttribute("personalPhones", personalPhones);
		resourceRequest.setAttribute("organizationPhones", organizationPhones);
		
		
	    }
	}

	if (LOGGER.isDebugEnabled()) {
	    LOGGER.debug("userId =" + userId);
	    LOGGER.debug("birthday =" + birthday);
	    LOGGER.debug("gender =" + gender);
	    LOGGER.debug("jobTitle =" + jobTitle);
	    
	}
	
	resourceRequest.setAttribute("organizations", organizations);
	resourceRequest.setAttribute("organizationsHTML", organizationsHTML.toString());
	resourceRequest.setAttribute("user", user);
	resourceRequest.setAttribute("contact", contact);
	resourceRequest.setAttribute("languageUtil", LanguageUtil.getLanguage());
	resourceRequest.setAttribute("locale", locale);
	
	resourceRequest.setAttribute("htmlUtil", HtmlUtil.getHtml());
	

	try {
	    include(resourceRequest, resourceResponse, "/groupphoto/jsp/ajax/user_details.jsp");
	} catch (IOException ioe) {
	    LOGGER.error(ioe);
	} catch (PortletException pe) {
	    LOGGER.error(pe);
	}

    }

    /**
     * Set fields
     * 
     * @param resourceRequest
     * @param contact
     * @param user
     * @param company
     * @param locale
     * @param birthday
     * @param gender
     * @param jobTitle 
     */
    private void setFields(ResourceRequest resourceRequest, Contact contact, User user, Company company, Locale locale,
	    String birthday, String gender, String jobTitle) {
	
	boolean isFieldEnableContactBirthday = PrefsPropsUtil.getBoolean(company.getCompanyId(),
		PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_MODEL_CONTACT_BIRTHDAY);

	if (isFieldEnableContactBirthday) {
	    Format dateFormatDate = FastDateFormatFactoryUtil.getDate(locale);
	    try {
		birthday = dateFormatDate.format(user.getBirthday());
	    } catch (PortalException e) {
		LOGGER.error(e);
	    }
	}

	jobTitle = HtmlUtil.escape(contact.getJobTitle());

	boolean isFieldEnableContactMale = PrefsPropsUtil.getBoolean(company.getCompanyId(),
		PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_MODEL_CONTACT_MALE);

	if (isFieldEnableContactMale) {
	    try {
		gender = LanguageUtil.get(locale, user.isMale() ? "male" : "female");
	    } catch (PortalException pe) {
		LOGGER.error(pe);
	    }
	}

	resourceRequest.setAttribute("birthday", birthday);
	resourceRequest.setAttribute("jobTitle", jobTitle);
	resourceRequest.setAttribute("gender", gender);
    }

}