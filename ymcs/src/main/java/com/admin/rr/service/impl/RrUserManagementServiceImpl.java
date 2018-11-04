package com.admin.rr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//import com.admin.dao.AfCbsCommonDao;
//import com.admin.entity.AfCbsAdminRolePermissions;
//import com.admin.entity.AfCbsAdminRoles;
//import com.admin.entity.AfCbsAdminUser;
import com.admin.rr.beans.RrAdminRolesBean;
import com.admin.rr.beans.RrAdminUserBean;
import com.admin.rr.beans.RrChangePasswordBean;
import com.admin.rr.beans.RrUserBean;
import com.admin.rr.constants.RrConstants;
import com.admin.rr.dao.RrUserManagementDao;
import com.admin.rr.entity.RrUserProfile;
import com.admin.rr.service.RrUserManagementService;
import com.admin.rr.utils.RrCommonUtils;
//import com.admin.service.AfCbsCommonService;
//import com.admin.utils.AfCbsCommonUtil;
//import com.admin.utils.AfCbsServiceProviderUtil;

@Component
@Transactional(readOnly = true)
public class RrUserManagementServiceImpl implements RrUserManagementService {

	private Logger logger = LogManager.getLogger(RrUserManagementServiceImpl.class.getName());

	@Autowired
	RrUserManagementDao userManagementDAO;

	// @Autowired
	// AfCbsCommonDao commonDAO;

	// @Autowired
	// AfCbsCommonUtil afCbsCommonUtil;

	// @Autowired
	// AfCbsCommonService commonService;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public RrAdminUserBean authenticateUser(RrAdminUserBean adminUserBean) {

		RrUserProfile userProfile = null;
		RrAdminUserBean bean = new RrAdminUserBean();
		;

		String userName;
		String uPassword;

		try {
			userName = RrCommonUtils.nullSafe(adminUserBean.getUserName(), RrConstants.STRING_EMPTY);
			uPassword = RrCommonUtils.nullSafe(adminUserBean.getPassword(), RrConstants.STRING_EMPTY);

			/*
			 * if ((!userName.isEmpty()) && (!uPassword.isEmpty())) {
			 * 
			 * userProfile =
			 * userManagementDAO.getUserDetailsByUserName(userName.trim(),
			 * uPassword.trim());
			 * 
			 * if (null != userProfile) { userProfile.setLastLoginTime(new
			 * Date()); //userManagementDAO.updateUser(userProfile);
			 * 
			 * bean.setUserId(userProfile.getUserId());
			 * bean.setFirstName(userProfile.getFirstName());
			 * bean.setUserRole(userProfile.getRrUserRoleMaster().
			 * getRrUserRoleMasterId());
			 * 
			 * if (!userProfile.isActiveStatus()) { bean.
			 * setErrorMsg("You have been denied access. Please contact Admin."
			 * ); } else if (userProfile.isDeleteStatus()) {
			 * bean.setErrorMsg("User does not exist."); } else if (
			 * (!userProfile.getRrUserRoleMaster().getActiveStatus()) &&
			 * (userProfile.getRrUserRoleMaster().getDeleteStatus())) { bean.
			 * setErrorMsg("User Role does not exist. Please contact Admin."); }
			 * } else { bean.setErrorMsg("Invalid user name and password!!"); }
			 * } else {
			 * bean.setErrorMsg("User name and password field can't be empty.!!"
			 * ); }
			 */
		} catch (Exception e) {
			logger.error("@@@@ Exception in RrUserManagementServiceImpl authenticateUser() :" + e);
		}

		return bean;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String updateAdminUser(JSONObject userJson) {

		Integer userId = -1;
		Integer roleId = -1;
		// AfCbsAdminRoles adminRoles = null;
		String status = RrConstants.STRING_EMPTY.intern();

		try {
			userId = userJson.getInt("userId");
			roleId = userJson.getInt("roleId");
			// AfCbsAdminUser adminUser =
			// userManagementDAO.getAdminUserById(userId);

			// if (!adminUser.getAfCbsAdminRoles().getRoleId().equals(roleId)) {
			//// adminRoles = commonDAO.getAdminRoleById(roleId);
			// adminUser.setAfCbsAdminRoles(adminRoles);
			// }
			// adminUser.setFirstName(userJson.getString("firstName"));
			// adminUser.setLastName(userJson.getString("lastName"));
			// adminUser.setMobileNumber(userJson.getString("mobileNumber"));
			// adminUser.setDateOfBirth(AfCbsServiceProviderUtil.getInstance()
			// .getDateFromString(userJson.getString("dateofbirth"),
			// RrConstants.DEFAULT_DATE_FORMAT.intern()));
			// adminUser.setGender(String.valueOf(userJson.getString("gender").charAt(0)));
			// adminUser.setUserName(userJson.getString("emailId"));
			// adminUser.setUserStatus((byte) userJson.getInt("statusType"));
			// adminUser.setModifiedBy(1);
			// adminUser.setModifiedTime(new Date());

			// status = userManagementDAO.updateUser(adminUser);
		} catch (Exception e) {
			logger.error("@@@@ Exception in RrUserManagementServiceImpl updateAdminUser() :" + e);
		}

		return status;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String createUser(RrAdminUserBean adminUserBean) {

		// AfCbsAdminUser adminUser = new AfCbsAdminUser();
		String status = RrConstants.STRING_EMPTY.intern();

		try {
			// adminUser.setFirstName(adminUserBean.getFirstName());
			// adminUser.setLastName(adminUserBean.getLastName());
			// adminUser.setMobileNumber(adminUserBean.getMobileNumber());
			// adminUser.setDateOfBirth(AfCbsServiceProviderUtil.getInstance()
			// .getDateFromString(adminUserBean.getDateOfBirth(),
			// RrConstants.DEFAULT_DATE_FORMAT.intern()));
			// adminUser.setGender(String.valueOf(adminUserBean.getGender().charAt(0)));
			// adminUser.setUserName(adminUserBean.getUserName());
			// adminUser.setPassword(adminUserBean.getPassword());
			// adminUser.setAfCbsAdminRoles(commonDAO.getAdminRoleById(adminUserBean.getUserRole()));
			// adminUser.setUserStatus((byte) adminUserBean.getStatusType());
			// adminUser.setCreatedBy(1);
			// adminUser.setCreatedTime(new Date());
			// adminUser.setStatus((byte) 1);

			// status = userManagementDAO.createUser(adminUser);
		} catch (Exception e) {
			logger.debug("Exception in Usermanagement ServiceImpl createUser()" + e);
			return "failure";
		}

		return status;
	}

	@Override
	public boolean checkUserName(String userName) {

		boolean userNameExist = false;

		try {
			userNameExist = userManagementDAO.checkUserName(userName);
		} catch (Exception e) {
			logger.error("@@Exception in checkUserName", e);
		}

		return userNameExist;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String deleteUser(Integer userId) {

		String deleteStatus = RrConstants.STRING_EMPTY.intern();

		try {
			deleteStatus = userManagementDAO.deleteUser(userId);
		} catch (Exception e) {
			logger.error("@@@@ Exception in RrUserManagementServiceImpl deleteUser() :" + e);
		}

		return deleteStatus;
	}

	@Override
	public RrAdminUserBean getUserDetailsByUserName(String userName) {

		RrAdminUserBean bean = null;
		// AfCbsAdminUser afAdminUser = new AfCbsAdminUser();

		try {
			/*
			 * afAdminUser =
			 * userManagementDAO.getUserDetailsByUserName(userName);
			 * 
			 * if (null != afAdminUser) { bean = new TestAdminUserBean();
			 * bean.setUserId(afAdminUser.getUserId());
			 * bean.setPassword(afAdminUser.getPassword()); }
			 */
		} catch (Exception e) {
			logger.error("@@@@ Exception in RrUserManagementServiceImpl authenticateUser() :" + e);
		}

		return bean;
	}

	@Override
	public List<RrUserBean> getAdminUsers() {

		// List<AfCbsAdminUser> afAdminUserList = null;
		List<RrUserBean> userList = new ArrayList<>();
		int userStatus;
		String dateStr = RrConstants.STRING_EMPTY.intern();

		try {
			// afAdminUserList = userManagementDAO.getAdminUsers();

			// for (AfCbsAdminUser afAdminUser : afAdminUserList) {
			// RrUserBean userBean = new RrUserBean();
			// userBean.setUserId(afAdminUser.getUserId());
			// userBean.setFirstName(afAdminUser.getFirstName() != null ?
			// afAdminUser.getFirstName()
			// : RrConstants.STRING_EMPTY.intern());
			// userBean.setLastName(afAdminUser.getLastName() != null ?
			// afAdminUser.getLastName()
			// : RrConstants.STRING_EMPTY.intern());
			// dateStr =
			// AfCbsServiceProviderUtil.getInstance().getFormattedDate(afAdminUser.getLastLogin(),
			// "dd MMM yyyy HH:mm a");
			// if (dateStr != null &&
			// !dateStr.equals(TestConstants.STRING_EMPTY.intern()))
			// userBean.setLastLogin(dateStr + " IST");
			// else
			// userBean.setLastLogin(dateStr);
			// if (afAdminUser.getDateOfBirth() != null) {
			// userBean.setDateOfBirth(AfCbsServiceProviderUtil.getInstance().getFormattedDate(
			// afAdminUser.getDateOfBirth(),
			// RrConstants.DEFAULT_DATE_FORMAT.intern()));
			// }
			// userBean.setGender("M".intern().equals(afAdminUser.getGender()) ?
			// TestConstants.MALE.intern()
			// : "F".intern().equals(afAdminUser.getGender()) ?
			// TestConstants.FEMALE.intern()
			// : TestConstants.STRING_EMPTY.intern());
			// userBean.setMobileNumber(afAdminUser.getMobileNumber());
			// userBean.setUserName(afAdminUser.getUserName());
			// userBean.setRole(afAdminUser.getAfCbsAdminRoles().getRoleName());
			// userBean.setRoleId(afAdminUser.getAfCbsAdminRoles().getRoleId());
			// userStatus = afAdminUser.getUserStatus();
			// userBean.setUserStatusCode(userStatus);

			// if (1 == userStatus) {
			// userBean.setUserStatus(TestConstants.STATUS_ACTIVE);
			// userBean.setUserStatusClass(TestConstants.STATUS_CLASS_GREEN);
			// }
			// if (0 == userStatus) {
			// userBean.setUserStatus(TestConstants.STATUS_IN_ACTIVE);
			// userBean.setUserStatusClass(TestConstants.STATUS_CLASS_RED);
			// }
			// userList.add(userBean);
			// }
		} catch (Exception e) {
			logger.error("@@@@ Exception in RrUserManagementServiceImpl campaignManagement() :" + e);
		}

		return userList;

	}

	@Override
	public Boolean checkRoleName(String roleName) {

		boolean userRoleExist = false;

		try {
			userRoleExist = userManagementDAO.checkRoleName(roleName);
		} catch (Exception e) {
			logger.error("@@Exception in checkRoleName", e);
		}

		return userRoleExist;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String changePassword(RrChangePasswordBean changePasswordBean) {

		String message = RrConstants.STRING_EMPTY.intern();
		// AfCbsAdminUser afAdminUser = new AfCbsAdminUser();

		try {
			// afAdminUser =
			// userManagementDAO.getAdminUserById(changePasswordBean.getUserId());
			// if (null != afAdminUser) {
			// afAdminUser.setPassword(null !=
			// changePasswordBean.getNewPassword()
			// ? changePasswordBean.getNewPassword().trim() :
			// RrConstants.STRING_EMPTY.intern());

			// message = userManagementDAO.updateUser(afAdminUser);
			// if ("success".equals(message))
			// message = "Your password is updated successfully";
			// }
		} catch (Exception e) {
			logger.error("@@Exception in RrUserManagementServiceImpl at changePassword()", e);
		}

		return message;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String createRole(RrAdminRolesBean adminRolesBean) {

		String roleName = RrConstants.STRING_EMPTY.intern();
		String description = RrConstants.STRING_EMPTY.intern();
		String roleStatus = RrConstants.STRING_EMPTY.intern();
		String permissionStatus = RrConstants.STRING_EMPTY.intern();
		// AfCbsAdminRoles afAdminRoles = new AfCbsAdminRoles();
		// Set<AfCbsAdminRolePermissions> afAdminRolePermissionses = new
		// HashSet<>(0);
		// List<AfCbsPermissionValues> listAfPermissionValues = null;
		String action = RrConstants.STRING_EMPTY.intern();

		try {
			roleName = adminRolesBean.getRoleName();
			roleName = (null != roleName) ? roleName.trim() : RrConstants.STRING_EMPTY.intern();
			// afAdminRoles.setRoleName(roleName);
			description = adminRolesBean.getDescription();
			description = (null != description) ? description.trim() : RrConstants.STRING_EMPTY.intern();
			// afAdminRoles.setDescription(description);
			// afAdminRoles.setStatus(RrConstants.STATUS_ACTIVE_VALUE);
			// afAdminRoles.setCreatedTime(new Date());
			// afAdminRoles.setCreatedBy(adminRolesBean.getUserId());

			// roleStatus = userManagementDAO.createRole(afAdminRoles);
			if ("success".equalsIgnoreCase(roleStatus)) {
				// listAfPermissionValues = commonDAO.getPermissionValues();
				Integer permissionId = null;
				String[] rolePermissionIds = adminRolesBean.getRolePermisionId();
				// for (AfCbsPermissionValues permissions :
				// listAfPermissionValues) {
				// permissionId = permissions.getPermissionId();
				action = RrConstants.STRING_EMPTY.intern();
				// AfCbsAdminRolePermissions afAdminRolePermissions = new
				// AfCbsAdminRolePermissions();
				// afAdminRolePermissions.setAfCbsAdminRoles(afAdminRoles);
				// afAdminRolePermissions.setAfCbsPermissionValues(permissions);
				// action += permissionId;
				// if (Arrays.asList(rolePermissionIds).contains(action))
				// afAdminRolePermissions.setPermissionStatus(RrConstants.CHECKBOX_STATUS_CHECKED);
				// else
				// afAdminRolePermissions.setPermissionStatus(RrConstants.CHECKBOX_STATUS_UNCHECKED);

				// afAdminRolePermissions.setCreatedTime(new Date());
				// afAdminRolePermissions.setCreatedBy(adminRolesBean.getUserId());
				// afAdminRolePermissionses.add(afAdminRolePermissions);

				// permissionStatus =
				// userManagementDAO.createAdminRolePermission(afAdminRolePermissions);
				// } // for each
			} // if ends
		} catch (Exception e) {
			logger.error("@@@@ Exception in RrUserManagementServiceImpl createRole() :" + e);
			return "failure";
		}

		return permissionStatus;

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateRole(RrAdminRolesBean adminRolesBean) {

		String roleName = RrConstants.STRING_EMPTY.intern();
		String description = RrConstants.STRING_EMPTY.intern();
		String action;
		// AfCbsAdminRoles afAdminRoles = null;
		// Set<AfCbsAdminRolePermissions> afAdminRolePermissionses = new
		// HashSet<>();
//		List<AfCbsPermissionValues> listAfPermissionValues = new ArrayList<>();

		try {
			// afAdminRoles =
			// userManagementDAO.getRoleById(String.valueOf(adminRolesBean.getRoleId()));

			// if (null != afAdminRoles) {
			// roleName = adminRolesBean.getRoleName();
			// roleName = (null != roleName) ? roleName.trim() :
			// RrConstants.STRING_EMPTY.intern();
			// afAdminRoles.setRoleName(roleName);
			//
			// description = adminRolesBean.getDescription();
			// description = (null != description) ? description.trim() :
			// RrConstants.STRING_EMPTY.intern();
			// afAdminRoles.setDescription(description);
			//
			// afAdminRoles.setStatus(RrConstants.STATUS_ACTIVE_VALUE);
			//
			// afAdminRoles.setModifiedTime(new Date());
			// afAdminRoles.setModifiedBy(adminRolesBean.getUserId());
			// String[] rolePermissionIds = adminRolesBean.getRolePermisionId();
			//
			// afAdminRolePermissionses =
			// afAdminRoles.getAfCbsAdminRolePermissionses();
			//
			// if (null != afAdminRolePermissionses) {
			// for (AfCbsAdminRolePermissions permissions :
			// afAdminRolePermissionses) {
			// action =
			// String.valueOf(permissions.getAfCbsPermissionValues().getPermissionId());
			// if (Arrays.asList(rolePermissionIds).contains(action))
			// permissions.setPermissionStatus(RrConstants.CHECKBOX_STATUS_CHECKED);
			// else
			// permissions.setPermissionStatus(RrConstants.CHECKBOX_STATUS_UNCHECKED);
			// afAdminRolePermissionses.add(permissions);
			// } // for each
			// afAdminRoles.setAfCbsAdminRolePermissionses(afAdminRolePermissionses);
			// }
			//
			// if (null != afAdminRolePermissionses &&
			// !afAdminRolePermissionses.isEmpty()) {
			//
			// afAdminRolePermissionses = new HashSet<>(0);
			// listAfPermissionValues = commonDAO.getPermissionValues();
			// Integer permissionId = null;
			//
			// for (AfCbsPermissionValues permissions : listAfPermissionValues)
			// {
			// permissionId = permissions.getPermissionId();
			//
			// action = RrConstants.STRING_EMPTY.intern();
			// AfCbsAdminRolePermissions afAdminRolePermissions = new
			// AfCbsAdminRolePermissions();
			// afAdminRolePermissions.setAfCbsAdminRoles(afAdminRoles);
			// afAdminRolePermissions.setAfCbsPermissionValues(permissions);
			// action += permissionId;
			// if (Arrays.asList(rolePermissionIds).contains(action))
			// afAdminRolePermissions.setPermissionStatus(RrConstants.CHECKBOX_STATUS_CHECKED);
			// else
			// afAdminRolePermissions.setPermissionStatus(RrConstants.CHECKBOX_STATUS_UNCHECKED);
			//
			// afAdminRolePermissions.setPermissionStatus(RrConstants.CHECKBOX_STATUS_UNCHECKED);
			// afAdminRolePermissions.setCreatedTime(new Date());
			// afAdminRolePermissions.setCreatedBy(adminRolesBean.getUserId());
			// afAdminRolePermissionses.add(afAdminRolePermissions);
			// } // for each
			// }
			// afAdminRoles.setAfCbsAdminRolePermissionses(afAdminRolePermissionses);
			//
			// userManagementDAO.updateRole(afAdminRoles);
			// } // if notnull
		} catch (Exception e) {
			logger.error("@@@@ Exception in RrUserManagementServiceImpl updateRole() :" + e);
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String deleteRole(Integer roleId) {

		String deleteStatus = RrConstants.STRING_EMPTY.intern();

		try {
			deleteStatus = userManagementDAO.deleteRole(roleId);
		} catch (Exception e) {
			logger.error("@@@@ Exception in RrUserManagementServiceImpl deleteRole() :", e);
		}

		return deleteStatus;
	}

	// @Override
	// public Map<AfCbsPermissionValues, Map<Byte, String>>
	// permissionActionsForvalues(
	// List<AfCbsPermissionValues> permissionValues, Map<Byte, String>
	// permissions) {
	//
	// Map<AfCbsPermissionValues, Map<Byte, String>> permissionActionsForvalues
	// = new LinkedHashMap<>();
	// Map<Byte, String> permissionActions = null;
	//
	// try {
	// for (AfCbsPermissionValues afPermissionValues : permissionValues) {
	// permissionActions = new LinkedHashMap<>();
	// permissionActions.putAll(permissions);
	//
	// if (1 == afPermissionValues.getPermissionId() || 4 ==
	// afPermissionValues.getPermissionId()
	// || 5 == afPermissionValues.getPermissionId() || 6 ==
	// afPermissionValues.getPermissionId()
	// || 7 == afPermissionValues.getPermissionId()) {
	// permissionActions.remove(RrConstants.PERMISSION_ACTIONS_EXPORT);
	// permissionActionsForvalues.put(afPermissionValues, permissionActions);
	// } else if (2 == afPermissionValues.getPermissionId() || 3 ==
	// afPermissionValues.getPermissionId()) {
	// permissionActions.remove(RrConstants.PERMISSION_ACTIONS_DELETE);
	// permissionActions.remove(RrConstants.PERMISSION_ACTIONS_EXPORT);
	// permissionActionsForvalues.put(afPermissionValues, permissionActions);
	// } else if (8 == afPermissionValues.getPermissionId() || 9 ==
	// afPermissionValues.getPermissionId()) {
	// permissionActions.remove(RrConstants.PERMISSION_ACTIONS_ADD);
	// permissionActions.remove(RrConstants.PERMISSION_ACTIONS_EXPORT);
	// permissionActionsForvalues.put(afPermissionValues, permissionActions);
	// } else {
	// permissionActions.remove(RrConstants.PERMISSION_ACTIONS_ADD);
	// permissionActions.remove(RrConstants.PERMISSION_ACTIONS_EDIT);
	// permissionActions.remove(RrConstants.PERMISSION_ACTIONS_DELETE);
	// permissionActionsForvalues.put(afPermissionValues, permissionActions);
	// }
	// } // for each
	// } catch (Exception e) {
	// logger.error("@@@@ Exception in RrUserManagementServiceImpl
	// permissionActionsForvalues() :", e);
	// }
	//
	// return permissionActionsForvalues;
	// }

	@Override
	public RrAdminRolesBean getRoleById(String roleId) {

		// AfCbsAdminRoles afAdminRoles = null;
		String roleName = RrConstants.STRING_EMPTY.intern();
		String description = RrConstants.STRING_EMPTY.intern();
		RrAdminRolesBean adminRolesBean = new RrAdminRolesBean();
		// Set<AfCbsAdminRolePermissions> afAdminRolePermissionses = null;
		List<String> checkedActions = new ArrayList<>();

		try {
			// afAdminRoles = userManagementDAO.getRoleById(roleId);

			// if (null != afAdminRoles) {
			// roleName = afAdminRoles.getRoleName();
			// roleName = (null != roleName) ? roleName.trim() :
			// RrConstants.STRING_EMPTY.intern();
			// adminRolesBean.setRoleName(roleName);
			//
			// adminRolesBean.setRoleId(afAdminRoles.getRoleId());
			// description = afAdminRoles.getDescription();
			// description = (null != description) ? description.trim() :
			// RrConstants.STRING_EMPTY.intern();
			// adminRolesBean.setDescription(description);
			//
			// afAdminRolePermissionses =
			// afAdminRoles.getAfCbsAdminRolePermissionses();
			// if (null != afAdminRolePermissionses) {
			// for (AfCbsAdminRolePermissions permissions :
			// afAdminRolePermissionses) {
			// if (permissions.getPermissionStatus() ==
			// RrConstants.CHECKBOX_STATUS_CHECKED) {
			// checkedActions
			// .add(String.valueOf(permissions.getAfCbsPermissionValues().getPermissionId()));
			// } // if
			// } // for each
			// adminRolesBean.setRolePermisionId(checkedActions.toArray(new
			// String[checkedActions.size()]));
			// }
			// }
		} catch (Exception e) {
			logger.error("@@@@ Exception in RrUserManagementServiceImpl getRoleById() :", e);
		}

		return adminRolesBean;
	}

	@Override
	public String[] getRolePermissionsById(String roleId) {
		return userManagementDAO.getRolePermissionsById(roleId);
	}

}
