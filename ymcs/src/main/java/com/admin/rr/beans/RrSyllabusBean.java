package com.admin.rr.beans;

/**
 * @author jogeswarsahu
 *
 */
public class RrSyllabusBean {

	private Integer classCode;
	private String className;
	private String syllabusCode;
	private String syllabusName;

	private byte activeStatus = 1;
	private String activeStatusValue;
	private String activeStatusClass;
	private byte editActiveStatus;
	private Integer syllabusId = 0;
	private String createdTime;
	private String createdBy;

	/**
	 * @return the classCode
	 */
	public Integer getClassCode() {
		return classCode;
	}

	/**
	 * @param classCode
	 *            the classCode to set
	 */
	public void setClassCode(Integer classCode) {
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
	 * @return the syllabusCode
	 */
	public String getSyllabusCode() {
		return syllabusCode;
	}

	/**
	 * @param syllabusCode
	 *            the syllabusCode to set
	 */
	public void setSyllabusCode(String syllabusCode) {
		this.syllabusCode = syllabusCode;
	}

	/**
	 * @return the syllabusName
	 */
	public String getSyllabusName() {
		return syllabusName;
	}

	/**
	 * @param syllabusName
	 *            the syllabusName to set
	 */
	public void setSyllabusName(String syllabusName) {
		this.syllabusName = syllabusName;
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
	 * @return the syllabusId
	 */
	public Integer getSyllabusId() {
		return syllabusId;
	}

	/**
	 * @param syllabusId
	 *            the syllabusId to set
	 */
	public void setSyllabusId(Integer syllabusId) {
		this.syllabusId = syllabusId;
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
