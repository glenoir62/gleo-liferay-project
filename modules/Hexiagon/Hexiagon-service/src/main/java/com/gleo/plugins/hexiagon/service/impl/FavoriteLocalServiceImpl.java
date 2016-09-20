package com.gleo.plugins.hexiagon.service.impl;

import com.gleo.plugins.hexiagon.model.Favorite;
import com.gleo.plugins.hexiagon.service.base.FavoriteLocalServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the favorite local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.glenoir.plugins.hexagon.service.FavoriteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author guillaumelenoir
 * @see com.gleo.plugins.hexiagon.hexagon.service.base.FavoriteLocalServiceBaseImpl
 * @see com.glenoir.plugins.hexagon.service.FavoriteLocalServiceUtil
 */
public class FavoriteLocalServiceImpl extends FavoriteLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.glenoir.plugins.hexagon.service.FavoriteLocalServiceUtil} to access the favorite local service.
     */
	
	public Favorite addUserFavoriteAnnouncement(long announcementId, ServiceContext serviceContext) throws SystemException {
		long companyId = serviceContext.getCompanyId();
		long favoriteId = CounterLocalServiceUtil.increment(Favorite.class.getName());
		long userId = serviceContext.getUserId();
		long groupId = announcementPersistence.fetchByPrimaryKey(announcementId).getGroupId();
		
		Favorite favoriteAnnouncement = favoriteLocalService.createFavorite(favoriteId);
		favoriteAnnouncement.setCompanyId(companyId);
		favoriteAnnouncement.setGroupId(groupId);
		favoriteAnnouncement.setUserId(userId);
		favoriteAnnouncement.setAnnouncementId(announcementId);
		
		// Add favorite

		return favoritePersistence.update(favoriteAnnouncement);
	}
	
	public void removeUserFavoriteAnnouncement(long announcementId, ServiceContext serviceContext) throws SystemException {
		long userId = serviceContext.getUserId();
		long groupId = announcementPersistence.fetchByPrimaryKey(announcementId).getGroupId();
		
		Favorite favoriteAnnouncement = favoritePersistence.fetchByA_U(announcementId, userId, groupId);
		
		if (Validator.isNotNull(favoriteAnnouncement)) {
			favoritePersistence.remove(favoriteAnnouncement);
		}
	}
	
	public boolean isUserFavoriteAnnouncement(long userId, long announcementId, long groupId) throws SystemException, PortalException {
		int count = favoritePersistence.countByA_U(announcementId, userId, groupId);
		return count == 1 ? true : false;
	}
	
	public int countUserFavoriteAnnouncement (long userId, long groupId) throws SystemException, PortalException {
		int count = favoritePersistence.countByUserIdGroupId(userId, groupId);
		return count;
	}
}
