package com.gleo.modules.ravenbox.web.util.comparator;

import java.util.Date;

import com.gleo.modules.ravenbox.model.Announcement;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

public class AnnouncementModelCreateDateComparator<T> extends OrderByComparator<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7314033970024059168L;

	public static final String ORDER_BY_ASC = "createDate ASC";

	public static final String ORDER_BY_DESC = "createDate DESC";

	public static final String[] ORDER_BY_FIELDS = { "createDate" };

	public static final String ORDER_BY_MODEL_ASC = "modelAnnouncement DESC, createDate ASC";

	public static final String ORDER_BY_MODEL_DESC = "modelAnnouncement DESC, createDate DESC";

	public AnnouncementModelCreateDateComparator() {
		this(false);
	}

	public AnnouncementModelCreateDateComparator(boolean ascending) {
		_ascending = ascending;
		_orderByModel = false;
	}

	public AnnouncementModelCreateDateComparator(boolean ascending, boolean orderByModel) {

		_ascending = ascending;
		_orderByModel = orderByModel;
	}

	@Override
	public int compare(T t1, T t2) {
		int value = 0;

		Date createDate1 = getCreateDate(t1);
		Date createDate2 = getCreateDate(t2);

		value = DateUtil.compareTo(createDate1, createDate2);

		if (_ascending) {
			return value;
		} else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_orderByModel) {
			if (_ascending) {
				return ORDER_BY_MODEL_ASC;
			} else {
				return ORDER_BY_MODEL_DESC;
			}
		} else {
			if (_ascending) {
				return ORDER_BY_ASC;
			} else {
				return ORDER_BY_DESC;
			}
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	protected Date getCreateDate(Object obj) {
		if (obj instanceof Announcement) {
			Announcement announcement = (Announcement) obj;

			return announcement.getCreateDate();
		} else {
			return null;
		}
	}

	private final boolean _ascending;
	private final boolean _orderByModel;

}