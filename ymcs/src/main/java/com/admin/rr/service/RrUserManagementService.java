package com.admin.rr.service;

import java.util.List;

import org.json.JSONObject;

import com.admin.rr.beans.RrAdminRolesBean;
import com.admin.rr.beans.RrAdminUserBean;
import com.admin.rr.beans.RrChangePasswordBean;
import com.admin.rr.beans.RrUserBean;

public interface RrUserManagementService {

	public RrAdminUserBean authenticateUser(RrAdminUserBean adminUserBean);

	public String updateAdminUser(JSONObject userJson);

	public String createUser(RrAdminUserBean adminUserBean);

	public boolean checkUserName(String userName);

	public String deleteUser(Integer userId);

	public RrAdminUserBean getUserDetailsByUserName(String userName);

	public List<RrUserBean> getAdminUsers();

	public Boolean checkRoleName(String roleName);

	public String changePassword(RrChangePasswordBean changePasswordBean);

	public String createRole(RrAdminRolesBean adminRolesBean);

	public void updateRole(RrAdminRolesBean adminRolesBean);

	public String deleteRole(Integer roleId);

//	public Map<AfCbsPermissionValues, Map<Byte, String>> permissionActionsForvalues(
//			List<AfCbsPermissionValues> permissionValues, Map<Byte, String> permissionActions);

	public RrAdminRolesBean getRoleById(String roleId);

	public String[] getRolePermissionsById(String roleId);

}
