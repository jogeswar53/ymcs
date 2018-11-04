package com.admin.rr.beans;

public class RrChangePasswordBean {

	private Integer userId;
	private String existingPassword;
	private String newPassword;
	private String reenterNewPassword;
	private String passsword;

	public String getPasssword() {
		return passsword;
	}

	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}

	public String getExistingPassword() {
		return existingPassword;
	}

	public void setExistingPassword(String existingPassword) {
		this.existingPassword = existingPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getReenterNewPassword() {
		return reenterNewPassword;
	}

	public void setReenterNewPassword(String reenterNewPassword) {
		this.reenterNewPassword = reenterNewPassword;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
