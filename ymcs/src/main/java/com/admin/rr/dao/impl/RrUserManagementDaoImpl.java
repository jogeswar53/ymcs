package com.admin.rr.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.admin.entity.AfCbsAdminRolePermissions;
//import com.admin.entity.AfCbsAdminRoles;
//import com.admin.entity.AfCbsAdminUser;
import com.admin.rr.constants.RrConstants;
import com.admin.rr.constants.RrHBQueries;
import com.admin.rr.dao.RrUserManagementDao;
import com.admin.rr.entity.RrUserProfile;

@Repository
public class RrUserManagementDaoImpl implements RrUserManagementDao {

	private Logger logger = LogManager.getLogger(RrUserManagementDaoImpl.class.getName());

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public RrUserProfile getUserDetailsByUserName(String userName, String uPassword) {

		RrUserProfile userProfile = null;

		try {
			Query query = sessionFactory.getCurrentSession().createQuery(RrHBQueries.AF_GET_ACTIVE_USER_BY_EMAIL);
			query.setParameter("userName", userName);
			query.setParameter("uPassword", uPassword);
			query.setMaxResults(1);
			userProfile = (RrUserProfile) query.uniqueResult();
		} catch (Exception e) {
			logger.error("@@@@ Exception in RrUserManagementDaoImpl at getUserDetailsByUserName() :", e);
		}

		return userProfile;
	}

	@Override
	public String updateUser(RrUserProfile userProfile) {

		String status = RrConstants.FAILURE.intern();

		try {
			sessionFactory.getCurrentSession().saveOrUpdate(userProfile);
			status = RrConstants.SUCCESS.intern();
		} catch (ConstraintViolationException e) {
			status = RrConstants.FAILURE.intern();
			logger.error("@@@@ ConstraintViolationException in RrUserManagementDaoImpl at updateUser() :" + e);
		} catch (Exception e) {
			status = RrConstants.FAILURE.intern();
			logger.error("@@@@ Exception in RrUserManagementDaoImpl at updateUser() :", e);
		}

		return status;
	}

	// @Override
	// public AfCbsAdminUser getAdminUserById(Integer userId) {
	//
	// AfCbsAdminUser adminUser = null;
	//
	// try {
	// Session session = sessionFactory.getCurrentSession();
	// adminUser = (AfCbsAdminUser) session.get(AfCbsAdminUser.class, userId);
	// } catch (Exception e) {
	// logger.error("@@@@ Exception in RrUserManagementDaoImpl at
	// getAdminUserById() :", e);
	// }
	//
	// return adminUser;
	// }

	// @Override
	// public String createUser(AfCbsAdminUser adminUser) {
	//
	// String status = RrConstants.FAILURE.intern();
	//
	// try {
	// sessionFactory.getCurrentSession().saveOrUpdate(adminUser);
	// status = RrConstants.SUCCESS.intern();
	// } catch (ConstraintViolationException e) {
	// status = RrConstants.FAILURE.intern();
	// logger.error("@@@@ ConstraintViolationException in
	// RrUserManagementDaoImpl at createUser() :", e);
	// } catch (Exception e) {
	// status = RrConstants.FAILURE.intern();
	// logger.error("@@@@ Exception in RrUserManagementDaoImpl at createUser()
	// :", e);
	// }
	//
	// return status;
	// }

	// @Override
	// public boolean checkUserName(String userName) {
	//
	// AfCbsAdminUser adminUser = null;
	// boolean flag = false;
	//
	// try {
	// Query query =
	// sessionFactory.getCurrentSession().createQuery(RrHBQueries.AF_ADMIN_USER_BY_NAME);
	// query.setString("userName", userName);
	// adminUser = (AfCbsAdminUser) query.uniqueResult();
	//
	// if (adminUser != null)
	// flag = true;
	// else
	// flag = false;
	// } catch (Exception e) {
	// logger.error("@@@@ Exception in RrUserManagementDaoImpl at
	// checkUserName() :", e);
	// }
	//
	// return flag;
	// }

	@Override
	public String deleteUser(Integer userId) {

		String deleteStatus = RrConstants.STRING_EMPTY.intern();

		try {
			// AfCbsAdminUser adminUser = (AfCbsAdminUser)
			// sessionFactory.getCurrentSession().get(AfCbsAdminUser.class,
			// userId);
			// if (null != adminUser) {
			// adminUser.setStatus((byte) 0);
			// String userName = adminUser.getUserName();
			// userName = userName + "_#deleted" + "_" + userId;
			// adminUser.setUserName(userName);
			// }
			// sessionFactory.getCurrentSession().merge(adminUser);
			deleteStatus = "User  Deleted Successfully";
		} catch (Exception e) {
			deleteStatus = "User not Deleted Exception is Occure";
			logger.error("@@@@ Exception in RrUserManagementDaoImpl at deleteUser() :", e);
		}

		return deleteStatus;
	}

	// @SuppressWarnings("unchecked")
	// @Override
	// public List<AfCbsAdminUser> getAdminUsers() {
	//
	// List<AfCbsAdminUser> userList = new ArrayList<>();
	//
	// try {
	// Session session = sessionFactory.getCurrentSession();
	// Query query = session.createQuery(RrHBQueries.AF_ADMIN_USER);
	// userList = query.list();
	// } catch (Exception e) {
	// logger.error("@@@@ Exception in RrUserManagementDaoImpl at
	// getAdminUsers() :", e);
	// }
	//
	// return userList;
	// }

	@Override
	public boolean checkRoleName(String roleName) {

		// AfCbsAdminRoles roles = null;
		boolean flag = false;

		// try {
		// Query query =
		// sessionFactory.getCurrentSession().createQuery(RrHBQueries.AF_ADMIN_ROLE_BY_NAME);
		// query.setString("roleName", roleName);
		//
		// roles = (AfCbsAdminRoles) query.uniqueResult();
		//
		// if (roles != null)
		// flag = true;
		// else
		// flag = false;
		// } catch (Exception e) {
		// logger.error("@@@@ Exception in RrUserManagementDaoImpl at
		// checkRoleName() :", e);
		// }

		return flag;
	}

	@Override
	public String deleteRole(Integer roleId) {

		String deleteStatus = RrConstants.STRING_EMPTY.intern();

		try {
			// AfCbsAdminRoles afAdminRoles = (AfCbsAdminRoles)
			// sessionFactory.getCurrentSession().get(AfCbsAdminRoles.class,
			// roleId);
			// if (null != afAdminRoles) {
			// afAdminRoles.setStatus((byte) 0);
			// String roleName = afAdminRoles.getRoleName();
			// roleName = roleName + "_#deleted" + "_" + roleId;
			// afAdminRoles.setRoleName(roleName);
			//
			// sessionFactory.getCurrentSession().merge(afAdminRoles);
			// deleteStatus = "Role Deleted Successfully";
			// }
		} catch (Exception e) {
			deleteStatus = "Role not Deleted Exception is Occure";
			logger.error("@@@@ Exception in RrUserManagementDaoImpl at deleteRole() :", e);
		}

		return deleteStatus;
	}

	// @Override
	// public String createRole(AfCbsAdminRoles afAdminRoles) {
	//
	// String status;
	//
	// try {
	// sessionFactory.getCurrentSession().saveOrUpdate(afAdminRoles);
	// status = RrConstants.SUCCESS.intern();
	// } catch (ConstraintViolationException ce) {
	// status = RrConstants.FAILURE.intern();
	// logger.error("@@@@ Exception in RrUserManagementDaoImpl at
	// createRole()ce: ", ce);
	// } catch (Exception e) {
	// status = RrConstants.FAILURE.intern();
	// logger.error("@@@@ Exception in RrUserManagementDaoImpl at createRole()
	// :", e);
	// }
	//
	// return status;
	// }

	// @Override
	// public void updateRole(AfCbsAdminRoles afAdminRoles) {
	// try {
	// sessionFactory.getCurrentSession().merge(afAdminRoles);
	// } catch (ConstraintViolationException ce) {
	// logger.error("@@@@ Exception in RrUserManagementDaoImpl at
	// updateRole()ce: ", ce);
	// } catch (Exception e) {
	// logger.error("@@@@ Exception in RrUserManagementDaoImpl at updateRole()
	// :", e);
	// }
	// }

	// @Override
	// public AfCbsAdminRoles getRoleById(String roleId) {
	//
	// AfCbsAdminRoles afAdminRoles = null;
	// String roleIdTemp = (null != roleId) ? roleId.trim().intern() :
	// RrConstants.STRING_EMPTY.intern();
	//
	// if (roleIdTemp.length() > 0) {
	// try {
	// Session session = sessionFactory.getCurrentSession();
	// afAdminRoles = (AfCbsAdminRoles) session.get(AfCbsAdminRoles.class, new
	// Integer(roleIdTemp));
	// } catch (Exception e) {
	// logger.error("@@@@ Exception in RrUserManagementDaoImpl at getRoleById()
	// :", e);
	// }
	// }
	//
	// return afAdminRoles;
	// }

	@SuppressWarnings("unchecked")
	@Override
	public String[] getRolePermissionsById(String roleId) {

		// List<AfCbsAdminRolePermissions> afAdminRolesList = null;
		String[] getRolePermission = null;
		String roleIdTemp = (null != roleId) ? roleId.trim().intern() : RrConstants.STRING_EMPTY.intern();

		if (roleIdTemp.length() > 0) {
			try {
				Session session = sessionFactory.getCurrentSession();
				Query query = session.createQuery(RrHBQueries.Af_GET_ROLE_PERMISSIONS_BY_ID);
				query.setInteger("roleId", Integer.parseInt(roleIdTemp));
				// afAdminRolesList = query.list();
			} catch (Exception e) {
				logger.error("@@@@ Exception in RrUserManagementDaoImpl at getRolePermissionsById() :", e);
			}
		} // if

		// if (null != afAdminRolesList) {
		// getRolePermission = new String[afAdminRolesList.size()];
		// int count = 0;
		// for (AfCbsAdminRolePermissions afAdminRolePermissions :
		// afAdminRolesList) {
		// getRolePermission[count] =
		// String.valueOf(afAdminRolePermissions.getPermissionStatus());
		// count++;
		// } // for each
		// }

		return getRolePermission;
	}

	@Override
	public boolean checkUserName(String userName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RrUserProfile getAdminUserById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
	// public String createAdminRolePermission(AfCbsAdminRolePermissions
	// afAdminRolePermissions) {
	//
	// String status;
	//
	// try {
	// sessionFactory.getCurrentSession().saveOrUpdate(afAdminRolePermissions);
	// status = RrConstants.SUCCESS.intern();
	// } catch (ConstraintViolationException ce) {
	// status = RrConstants.FAILURE.intern();
	// logger.error("@@@@ ConstraintViolationException in
	// RrUserManagementDaoImpl at createAdminRolePermission()ce: ", ce);
	// } catch (Exception e) {
	// status = RrConstants.FAILURE.intern();
	// logger.error("@@@@ Exception in RrUserManagementDaoImpl at
	// createAdminRolePermission() :", e);
	// }
	//
	// return status;
	// }
}
