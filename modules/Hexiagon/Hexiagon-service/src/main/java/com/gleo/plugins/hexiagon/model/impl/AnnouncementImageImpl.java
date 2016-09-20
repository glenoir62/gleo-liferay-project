package com.gleo.plugins.hexiagon.model.impl;

import java.io.InputStream;

import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * The extended model implementation for the AnnouncementImage service. Represents a row in the &quot;Hexagon_AnnouncementImage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.glenoir.plugins.hexagon.model.AnnouncementImage} interface.
 * </p>
 *
 * @author guillaumelenoir
 */
public class AnnouncementImageImpl extends AnnouncementImageBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a announcement image model instance should use the {@link com.glenoir.plugins.hexagon.model.AnnouncementImage} interface instead.
     */

    private InputStream inputStream;
    
    private Boolean isActive;
    
	public Boolean isActive() {
	
		return isActive;
	}
	
	public void setActive(Boolean isActive) {
	
		this.isActive = isActive;
	}

	public AnnouncementImageImpl() {
    }
	
	public InputStream getInputStream() {
	
		return inputStream;
	}
	
	public void setInputStream(InputStream inputStream) {
	
		this.inputStream = inputStream;
	}
	
	public String getImageURL(ThemeDisplay themeDisplay) {

		String url = StringPool.BLANK;

		FileEntry fileEntry = null;
		if (Validator.isNotNull(this.getFileEntryId())) {
			try {
				fileEntry = PortletFileRepositoryUtil.getPortletFileEntry(this.getFileEntryId());
				url = DLUtil.getPreviewURL(
					fileEntry, fileEntry.getLatestFileVersion(), themeDisplay,
					StringPool.BLANK);
			}
			catch (PortalException e) {
				e.printStackTrace();
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
		}
				
		return url;
	}
}
