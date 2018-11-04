package com.admin.rr.dao;

import com.admin.rr.entity.RrUserProfile;

public interface RrUserManagementDao {

	public RrUserProfile getUserDetailsByUserName(String userName, String uPassword);

	public String updateUser(RrUserProfile userProfile);

	public RrUserProfile getAdminUserById(Integer userId);

	public boolean checkUserName(String userName);

	public String deleteUser(Integer userId);

	public boolean checkRoleName(String roleName);

	public String deleteRole(Integer roleId);

	public String[] getRolePermissionsById(String roleId);

}
