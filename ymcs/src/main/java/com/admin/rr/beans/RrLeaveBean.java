package com.admin.rr.beans;

/**
 * @author jogeswar
 *
 */
public class RrLeaveBean {

	private Integer leaveId = 0;
	private String action;

	private byte leaveName;
	private String leaveNames;
	private String leaveType;
	private String startDate;
	private String endDate;
	private String requesterComment;
	private String document;

	public Integer getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(Integer leaveId) {
		this.leaveId = leaveId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public byte getLeaveName() {
		return leaveName;
	}

	public void setLeaveName(byte leaveName) {
		this.leaveName = leaveName;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getRequesterComment() {
		return requesterComment;
	}

	public void setRequesterComment(String requesterComment) {
		this.requesterComment = requesterComment;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getLeaveNames() {
		return leaveNames;
	}

	public void setLeaveNames(String leaveNames) {
		this.leaveNames = leaveNames;
	}

}