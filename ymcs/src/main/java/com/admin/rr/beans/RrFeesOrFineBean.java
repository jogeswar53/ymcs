package com.admin.rr.beans;

/**
 * @author jogeswar
 *
 */
public class RrFeesOrFineBean {

	private byte activeStatus = 1;
	private String activeStatusValue;
	private String activeStatusClass;
	private byte editActiveStatus;

	private String createdTime;
	private String createdBy;

	private Integer feesOrFineId = 0;

	private String classId;
	private String sectionId;
	private String studentId;
	private String feesOrFineType;
	private Float feesFineAmount;

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
	 * @return the feesOrFineId
	 */
	public Integer getFeesOrFineId() {
		return feesOrFineId;
	}

	/**
	 * @param feesOrFineId
	 *            the feesOrFineId to set
	 */
	public void setFeesOrFineId(Integer feesOrFineId) {
		this.feesOrFineId = feesOrFineId;
	}

	/**
	 * @return the classId
	 */
	public String getClassId() {
		return classId;
	}

	/**
	 * @param classId
	 *            the classId to set
	 */
	public void setClassId(String classId) {
		this.classId = classId;
	}

	/**
	 * @return the sectionId
	 */
	public String getSectionId() {
		return sectionId;
	}

	/**
	 * @param sectionId
	 *            the sectionId to set
	 */
	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

	/**
	 * @return the studentId
	 */
	public String getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId
	 *            the studentId to set
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the feesOrFineType
	 */
	public String getFeesOrFineType() {
		return feesOrFineType;
	}

	/**
	 * @param feesOrFineType
	 *            the feesOrFineType to set
	 */
	public void setFeesOrFineType(String feesOrFineType) {
		this.feesOrFineType = feesOrFineType;
	}

	/**
	 * @return the feesFineAmount
	 */
	public Float getFeesFineAmount() {
		return feesFineAmount;
	}

	/**
	 * @param feesFineAmount
	 *            the feesFineAmount to set
	 */
	public void setFeesFineAmount(Float feesFineAmount) {
		this.feesFineAmount = feesFineAmount;
	}

}
