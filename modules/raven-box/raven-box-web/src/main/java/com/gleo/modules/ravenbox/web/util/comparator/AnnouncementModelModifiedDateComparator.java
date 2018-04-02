package com.gleo.modules.ravenbox.web.util.comparator;

import java.util.Date;

import com.gleo.modules.ravenbox.model.Announcement;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

public class AnnouncementModelModifiedDateComparator<T> extends OrderByComparator<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7314033970024057168L;

	public static final String ORDER_BY_ASC = "modifiedDate ASC";

	public static final String ORDER_BY_DESC = "modifiedDate DESC";

	public static final String[] ORDER_BY_FIELDS = { "modifiedDate" };

	public static final String ORDER_BY_MODEL_ASC = "modelAnnouncement DESC, modifiedDate ASC";

	public static final String ORDER_BY_MODEL_DESC = "modelAnnouncement DESC, modifiedDate DESC";

	public AnnouncementModelModifiedDateComparator() {
		this(false);
	}

	public AnnouncementModelModifiedDateComparator(boolean ascending) {
		_ascending = ascending;
		_orderByModel = false;
	}

	public AnnouncementModelModifiedDateComparator(boolean ascending, boolean orderByModel) {

		_ascending = ascending;
		_orderByModel = orderByModel;
	}

	@Override
	public int compare(T t1, T t2) {
		int value = 0;

		Date modifiedDate1 = getmodifiedDate(t1);
		Date modifiedDate2 = getmodifiedDate(t2);

		value = DateUtil.compareTo(modifiedDate1, modifiedDate2);

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

	protected Date getmodifiedDate(Object obj) {
		if (obj instanceof Announcement) {
			Announcement announcement = (Announcement) obj;

			return announcement.getModifiedDate();
		} else {
			return null;
		}
	}

	private final boolean _ascending;
	private final boolean _orderByModel;
}

