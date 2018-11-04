package com.admin.rr.beans;

public class RrAdminRolesBean {

	private String roleName;
	private Integer roleId;
	private String[] rolePermisionId;
	private String description;
	private String[] permissionActions;
	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getDescription() {
		return description;
	}

	public String[] getRolePermisionId() {
		return rolePermisionId;
	}

	public void setRolePermisionId(String[] rolePermisionId) {
		this.rolePermisionId = rolePermisionId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getPermissionActions() {
		return permissionActions;
	}

	public void setPermissionActions(String[] permissionActions) {
		this.permissionActions = permissionActions;
	}

}
