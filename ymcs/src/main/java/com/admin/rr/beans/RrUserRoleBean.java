package com.admin.rr.beans;

import com.admin.rr.constants.RrConstants;

/**
 * @author jogeswarsahu
 *
 */
public class RrUserRoleBean {

	private Long userRoleId = 0L;

	private String roleName;
	private String roleDesc;
	private String menuName;
	private Long[] menuId;

	private String createdTime;
	private String createdBy;
	private String modifiedTime;
	private String modifiedBy;

	private String status = RrConstants.ONLINE;
	private String statusClass;

	/**
	 * @return the userRoleId
	 */
	public Long getUserRoleId() {
		return userRoleId;
	}

	/**
	 * @param userRoleId
	 *            the userRoleId to set
	 */
	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 *            the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the roleDesc
	 */
	public String getRoleDesc() {
		return roleDesc;
	}

	/**
	 * @param roleDesc
	 *            the roleDesc to set
	 */
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	/**
	 * @return the menuName
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * @param menuName
	 *            the menuName to set
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	/**
	 * @return the menuId
	 */
	public Long[] getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId
	 *            the menuId to set
	 */
	public void setMenuId(Long[] menuId) {
		this.menuId = menuId;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the statusClass
	 */
	public String getStatusClass() {
		return statusClass;
	}

	/**
	 * @param statusClass
	 *            the statusClass to set
	 */
	public void setStatusClass(String statusClass) {
		this.statusClass = statusClass;
	}

}
