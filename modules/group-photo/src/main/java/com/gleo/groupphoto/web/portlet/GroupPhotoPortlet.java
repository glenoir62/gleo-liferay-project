
package com.gleo.groupphoto.web.portlet;

import com.gleo.groupphoto.web.constants.GroupPhotoPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author guillaumelenoir
 */
@Component(immediate = true, property = {
	"com.liferay.portlet.css-class-wrapper=group-photo-portlet",
	"com.liferay.portlet.display-category=category.sample",
	"com.liferay.portlet.header-portlet-css=/groupphoto/css/main.css",
	"com.liferay.portlet.icon=/groupphoto/icons/groupphoto.png",
	"com.liferay.portlet.render-weight=50",
	"com.liferay.portlet.scopeable=true",
	"com.liferay.portlet.use-default-template=true",
	"javax.portlet.display-name=Group Photo",
	"javax.portlet.expiration-cache=0",
	"javax.portlet.init-param.always-display-default-configuration-icons=true",
	"javax.portlet.init-param.template-path=/",
	"javax.portlet.name=" + GroupPhotoPortletKeys.GROUP_PHOTO,
	"javax.portlet.resource-bundle=content.Language",
	"javax.portlet.security-role-ref=power-user,user",
	"javax.portlet.supports.mime-type=text/html"
}, service = Portlet.class)
public class GroupPhotoPortlet extends MVCPortlet {

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
	    throws IOException, PortletException {

	super.doView(renderRequest, renderResponse);
    }
	
    
}
