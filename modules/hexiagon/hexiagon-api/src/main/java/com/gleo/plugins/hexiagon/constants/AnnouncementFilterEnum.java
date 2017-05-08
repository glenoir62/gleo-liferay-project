
package com.gleo.plugins.hexiagon.constants;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;

/**
 * Filter enum
 */
public enum AnnouncementFilterEnum {

	/**
	 * decreasing price
	 */
	DECREASINGPRICE(1, "price", Sort.LONG_TYPE, true, "decreasing-price"),

	/**
	 * increasing price
	 */
	INCREASINGPRICE(2, "price", Sort.LONG_TYPE, false, "increasing-price"),

// Asynchronous message bus V2
//	/**
//	 * most commented
//	 */
//	MOSTCOMMENTED(Field.COMMENTS, Sort.LONG_TYPE, true, "most-commented"),
//
//	/**
//	 * most popular
//	 */
//	MOSTRATED(Field.RATINGS, Sort.DOUBLE_TYPE, true, "most-popular"),
//
//	/**
//	 * most viewed
//	 */
//	MOSTVIEWED(Field.VIEW_COUNT, Sort.INT_TYPE, true, "most-viewed"),

	/**
	 * create date
	 */
	CREATEDATE(3, Field.CREATE_DATE, Sort.LONG_TYPE, true, "create-date"),
	
	/**
	 * update date
	 */
	UPDATEDATE(4, Field.MODIFIED_DATE, Sort.LONG_TYPE, true, "update-date");

	/**
	 * @param field
	 * @param type
	 * @param asc
	 */
	private AnnouncementFilterEnum(int fieldId, String field, int type, boolean asc, String key) {

		this.fieldId = fieldId;
		this.field = field;
		this.type = type;
		this.asc = asc;
		this.key = key;
	}

	public int getFieldId() {

		return fieldId;
	}
	
	public String getField() {

		return field;
	}

	public int getType() {

		return type;
	}

	public boolean isAsc() {

		return asc;
	}

	public String getKey() {

		return key;
	}

	private int fieldId;
	
	private String field;

	private int type;

	private String key;

	private boolean asc;

}
