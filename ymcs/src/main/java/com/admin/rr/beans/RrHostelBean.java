package com.admin.rr.beans;

/**
 * @author jogeswar
 *
 */
public class RrHostelBean {

	private byte activeStatus = 1;
	private String activeStatusValue;
	private String activeStatusClass;
	private byte editActiveStatus;
	private String action;
	private Integer hostelId = 0;
	private String createdTime;
	private String createdBy;

	private String hostelCode;
	private String hostelName;
	private String hostelAddress;
	private String hostelContactNo;
	private String wardenName;
	private String wardenContactNo;

	/**
	 * @return the hostelCode
	 */
	public String getHostelCode() {
		return hostelCode;
	}

	/**
	 * @param hostelCode
	 *            the hostelCode to set
	 */
	public void setHostelCode(String hostelCode) {
		this.hostelCode = hostelCode;
	}

	/**
	 * @return the hostelName
	 */
	public String getHostelName() {
		return hostelName;
	}

	/**
	 * @param hostelName
	 *            the hostelName to set
	 */
	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
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
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action
	 *            the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the hostelId
	 */
	public Integer getHostelId() {
		return hostelId;
	}

	/**
	 * @param hostelId
	 *            the hostelId to set
	 */
	public void setHostelId(Integer hostelId) {
		this.hostelId = hostelId;
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

	/**
	 * @return the hostelAddress
	 */
	public String getHostelAddress() {
		return hostelAddress;
	}

	/**
	 * @param hostelAddress
	 *            the hostelAddress to set
	 */
	public void setHostelAddress(String hostelAddress) {
		this.hostelAddress = hostelAddress;
	}

	/**
	 * @return the hostelContactNo
	 */
	public String getHostelContactNo() {
		return hostelContactNo;
	}

	/**
	 * @param hostelContactNo
	 *            the hostelContactNo to set
	 */
	public void setHostelContactNo(String hostelContactNo) {
		this.hostelContactNo = hostelContactNo;
	}

	/**
	 * @return the wardenName
	 */
	public String getWardenName() {
		return wardenName;
	}

	/**
	 * @param wardenName
	 *            the wardenName to set
	 */
	public void setWardenName(String wardenName) {
		this.wardenName = wardenName;
	}

	/**
	 * @return the wardenContactNo
	 */
	public String getWardenContactNo() {
		return wardenContactNo;
	}

	/**
	 * @param wardenContactNo
	 *            the wardenContactNo to set
	 */
	public void setWardenContactNo(String wardenContactNo) {
		this.wardenContactNo = wardenContactNo;
	}

}
