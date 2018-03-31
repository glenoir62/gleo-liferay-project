
package com.gleo.modules.ravenbox.web.util;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.gleo.modules.ravenbox.constants.AnnouncementConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.io.ByteArrayFileInputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author guillaumelenoir
 * 
 * Utility class
 * Resize images.
 *
 */
public class AnnouncementImageUtil {

	/**
	 * AnnouncementController Logger.
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(AnnouncementImageUtil.class);

	private AnnouncementImageUtil() {

		super();
	}

	/**
	 * resize Images
	 * 
	 * @param inputStream
	 */
	public static InputStream resizeImages(InputStream inputStream) {

		RenderedImage renderedImage = null;
		ImageBag imageBag = null;
		byte[] bitsTab = null;
		ByteArrayFileInputStream byteFileInputStream = (ByteArrayFileInputStream) inputStream;

		if (byteFileInputStream != null && byteFileInputStream.getFile() != null) {
			try {
				File file = byteFileInputStream.getFile();
				imageBag = ImageToolUtil.read(byteFileInputStream);
				renderedImage = imageBag.getRenderedImage();

				renderedImage = ImageToolUtil.scale(renderedImage, AnnouncementConstants.IMAGE_MAX_HEIGHT, AnnouncementConstants.IMAGE_MAX_WIDTH);
				bitsTab = ImageToolUtil.getBytes(renderedImage, imageBag.getType());

				FileOutputStream tmpOutputStream = null;
				try {
					tmpOutputStream = new FileOutputStream(file);
					tmpOutputStream.write(bitsTab);
					byteFileInputStream = new ByteArrayFileInputStream(file, 1024, true);
				}
				catch (FileNotFoundException e) {
					LOGGER.error("FileNotFoundException: " + e);
				}
				catch (IOException e) {
					LOGGER.error("IOException: " + e);
				}
				finally {
					if (tmpOutputStream != null)
						try {
							tmpOutputStream.close();
						}
						catch (IOException e) {
							LOGGER.error("IOException: " + e);
						}
				}
			}

			catch (Exception e) {
				LOGGER.error("Exception unable to resize Image");
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(e);
				}
			}
		}

		return byteFileInputStream;
	}

	/**
	 * Get the extension of a file.
	 * 
	 * @param file
	 *            file
	 * @return file extension
	 */
	public static String getExtension(File file) {

		String ext = null;
		String s = file.getName();
		int i = s.lastIndexOf('.');

		if (i > 0 && i < s.length() - 1) {
			ext = s.substring(i + 1).toLowerCase();
		}

		return ext;
	}

	
	/**
	 * Get image url
	 * 
	 * @param themeDisplay
	 * @return
	 * @throws PortalException
	 */
	public static String getImageURL(ThemeDisplay themeDisplay, long fileEntryId) {

		String imageUrl = StringPool.BLANK;

		if (Validator.isNotNull(fileEntryId)) {
			FileEntry dlFileEntry = null;
			try {
				dlFileEntry = DLAppServiceUtil.getFileEntry(fileEntryId);

				if (dlFileEntry != null) {
					return DLUtil.getPreviewURL(dlFileEntry, dlFileEntry.getLatestFileVersion(), themeDisplay, StringPool.BLANK);
				}
			}
			catch (SystemException e) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(e);
				}
				LOGGER.error("SystemException: impossible to get url file entry name for " + fileEntryId);
			}
			catch (PortalException e) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug(e);
				}
				LOGGER.error("PortalException: impossible to get url file entry name for " + fileEntryId);
			}
		}

		return imageUrl;
	}
}
