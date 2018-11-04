package com.admin.rr.beans;

/**
 * @author jogeswar
 *
 */
public class RrSectionBean {

	private String sectionCode;
	private String sectionName;

	private byte activeStatus = 1;
	private String activeStatusValue;
	private String activeStatusClass;
	private byte editActiveStatus;
	private Integer sectionId = 0;
	private String createdTime;
	private String createdBy;

	/**
	 * @return the sectionCode
	 */
	public String getSectionCode() {
		return sectionCode;
	}

	/**
	 * @param sectionCode
	 *            the sectionCode to set
	 */
	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}

	/**
	 * @return the sectionName
	 */
	public String getSectionName() {
		return sectionName;
	}

	/**
	 * @param sectionName
	 *            the sectionName to set
	 */
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	/**
	 * @return the activeStatus
	 */
	public byte getActiveStatus() {
		return activeStatus;
	}

	/**
	 * @param activeStatus
	 *            the activeStatus to set
	 */
	public void setActiveStatus(byte activeStatus) {
		this.activeStatus = activeStatus;
	}

	/**
	 * @return the activeStatusValue
	 */
	public String getActiveStatusValue() {
		return activeStatusValue;
	}

	/**
	 * @param activeStatusValue
	 *            the activeStatusValue to set
	 */
	public void setActiveStatusValue(String activeStatusValue) {
		this.activeStatusValue = activeStatusValue;
	}

	/**
	 * @return the activeStatusClass
	 */
	public String getActiveStatusClass() {
		return activeStatusClass;
	}

	/**
	 * @param activeStatusClass
	 *            the activeStatusClass to set
	 */
	public void setActiveStatusClass(String activeStatusClass) {
		this.activeStatusClass = activeStatusClass;
	}

	/**
	 * @return the editActiveStatus
	 */
	public byte getEditActiveStatus() {
		return editActiveStatus;
	}

	/**
	 * @param editActiveStatus
	 *            the editActiveStatus to set
	 */
	public void setEditActiveStatus(byte editActiveStatus) {
		this.editActiveStatus = editActiveStatus;
	}

	/**
	 * @return the sectionId
	 */
	public Integer getSectionId() {
		return sectionId;
	}

	/**
	 * @param sectionId
	 *            the sectionId to set
	 */
	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	/**
	 * @return the createdTime
	 */
	public String getCreatedTime() {
		return createdTime;
	}

	/**
	 * @param createdTime
	 *            the createdTime to set
	 */
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
