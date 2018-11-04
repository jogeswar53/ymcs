package com.admin.rr.beans;

/**
 * @author jogeswar
 *
 */
public class RrNotificationBean {

	private Integer notificationId = 0;
	private String action;

	private String notificationName;
	private String notificationDesc;
	private String scheduledTime;
	private byte notificationStatus;
	private String createdTime;
	private String createdBy;
	private String modifiedTime;
	private String modifiedBy;

	private byte activeStatus = 1;
	private String activeStatusValue;
	private String activeStatusClass;
	private byte editActiveStatus;

	/**
	 * @return the notificationId
	 */
	public Integer getNotificationId() {
		return notificationId;
	}

	/**
	 * @param notificationId
	 *            the notificationId to set
	 */
	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
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
	 * @return the notificationName
	 */
	public String getNotificationName() {
		return notificationName;
	}

	/**
	 * @param notificationName
	 *            the notificationName to set
	 */
	public void setNotificationName(String notificationName) {
		this.notificationName = notificationName;
	}

	/**
	 * @return the notificationDesc
	 */
	public String getNotificationDesc() {
		return notificationDesc;
	}

	/**
	 * @param notificationDesc
	 *            the notificationDesc to set
	 */
	public void setNotificationDesc(String notificationDesc) {
		this.notificationDesc = notificationDesc;
	}

	/**
	 * @return the scheduledTime
	 */
	public String getScheduledTime() {
		return scheduledTime;
	}

	/**
	 * @param scheduledTime
	 *            the scheduledTime to set
	 */
	public void setScheduledTime(String scheduledTime) {
		this.scheduledTime = scheduledTime;
	}

	/**
	 * @return the notificationStatus
	 */
	public byte getNotificationStatus() {
		return notificationStatus;
	}

	/**
	 * @param notificationStatus
	 *            the notificationStatus to set
	 */
	public void setNotificationStatus(byte notificationStatus) {
		this.notificationStatus = notificationStatus;
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
	 * @return the modifiedTime
	 */
	public String getModifiedTime() {
		return modifiedTime;
	}

	/**
	 * @param modifiedTime
	 *            the modifiedTime to set
	 */
	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy
	 *            the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
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

}
