package com.admin.rr.beans;

public class RrEmailManagementBean {

	private String title;
	private String content;
	private Integer userId;
	private Integer emId;
	private String name;
	private String type;
	private byte emailStatus = 1;
	private byte contentType = -1;

	public byte getContentType() {
		return contentType;
	}

	public void setContentType(byte contentType) {
		this.contentType = contentType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEmId() {
		return emId;
	}

	public void setEmId(Integer emId) {
		this.emId = emId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the emailStatus
	 */
	public byte getEmailStatus() {
		return emailStatus;
	}

	/**
	 * @param emailStatus
	 *            the emailStatus to set
	 */
	public void setEmailStatus(byte emailStatus) {
		this.emailStatus = emailStatus;
	}
}
