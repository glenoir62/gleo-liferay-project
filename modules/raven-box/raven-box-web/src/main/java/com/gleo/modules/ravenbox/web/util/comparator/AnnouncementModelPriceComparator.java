package com.gleo.modules.ravenbox.web.util.comparator;

import com.gleo.modules.ravenbox.model.Announcement;
import com.liferay.portal.kernel.util.OrderByComparator;

public class AnnouncementModelPriceComparator<T> extends OrderByComparator<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3755648954832186208L;

	public static final String ORDER_BY_ASC = "price ASC";

	public static final String ORDER_BY_DESC = "price DESC";

	public static final String[] ORDER_BY_FIELDS = { "price" };

	public static final String ORDER_BY_MODEL_ASC = "modelAnnouncement DESC, price ASC";

	public static final String ORDER_BY_MODEL_DESC = "modelAnnouncement DESC, price DESC";

	public AnnouncementModelPriceComparator() {
		this(false);
	}

	public AnnouncementModelPriceComparator(boolean ascending) {

		_ascending = ascending;
		_orderByModel = false;
	}

	public AnnouncementModelPriceComparator(boolean ascending, boolean orderByModel) {

		_ascending = ascending;
		_orderByModel = orderByModel;
	}

	public int compare(T t1, T t2) {
		int value = 0;

		Long readCount1 = getprice(t1);
		Long readCount2 = getprice(t2);

		value = readCount1.compareTo(readCount2);

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

	protected long getprice(Object obj) {
		if (obj instanceof Announcement) {
			Announcement announcement = (Announcement) obj;

			return announcement.getPrice();
		}

		return 0;
	}

	private final boolean _ascending;
	private final boolean _orderByModel;

}
