package com.admin.rr.beans;

public class RrAdminUserBean {

	private String lastName;
	private String firstName;
	private String userName;
	private String password;
	private String mobileNumber;
	private String dateOfBirth;
	private String gender;
	private String profileImg;
	private String userType;
	private String createdTime;
	private Long userRole;
	private Long userProfileDetailsId;
	private int statusType;
	private String userId;
	private String errorMsg;
	private Long roleId;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Long getUserRole() {
		return userRole;
	}

	public void setUserRole(Long userRole) {
		this.userRole = userRole;
	}

	public int getStatusType() {
		return statusType;
	}

	public void setStatusType(int statusType) {
		this.statusType = statusType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the profileImg
	 */
	public String getProfileImg() {
		return profileImg;
	}

	/**
	 * @param profileImg
	 *            the profileImg to set
	 */
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
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
	 * @return the userProfileDetailsId
	 */
	public Long getUserProfileDetailsId() {
		return userProfileDetailsId;
	}

	/**
	 * @param userProfileDetailsId the userProfileDetailsId to set
	 */
	public void setUserProfileDetailsId(Long userProfileDetailsId) {
		this.userProfileDetailsId = userProfileDetailsId;
	}

}
