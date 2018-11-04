package com.admin.rr.beans;

/**
 * @author jogeswar
 *
 */
public class RrClassBean {

	private String classCode;
	private String className;

	private byte activeStatus;
	private String activeStatusValue;
	private String activeStatusClass;
	private Integer classId = 0;
	private String createdTime;
	private String createdBy;

	/**
	 * @return the classCode
	 */
	public String getClassCode() {
		return classCode;
	}

	/**
	 * @param classCode
	 *            the classCode to set
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className
	 *            the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
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
	 * @return the classId
	 */
	public Integer getClassId() {
		return classId;
	}

	/**
	 * @param classId
	 *            the classId to set
	 */
	public void setClassId(Integer classId) {
		this.classId = classId;
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
