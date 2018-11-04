package com.admin.rr.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.admin.rr.beans.RrPermissionBean;
import com.admin.rr.constants.RrConstants;
import com.admin.rr.dao.RrMenuConfDao;
import com.admin.rr.dao.RrPermissionConfDao;
import com.admin.rr.dao.RrUserRoleConfDao;
import com.admin.rr.entity.RrMenus;
import com.admin.rr.entity.RrPermissionMaster;
import com.admin.rr.entity.RrUserRoleMaster;
import com.admin.rr.service.RrPermissionConfService;

/**
 * @author jogeswar
 *
 */
@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class RrPermissionConfServiceImpl implements RrPermissionConfService {

	private static final Logger logger = LogManager.getLogger(RrPermissionConfServiceImpl.class.getName());

	@Autowired
	RrPermissionConfDao permissionConfDao;

	@Autowired
	RrMenuConfDao menuConfDao;

	@Autowired
	RrUserRoleConfDao userRoleConfDao;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public List<RrPermissionBean> getAllPermissionList() {

		List<RrPermissionMaster> permissionMasterList = null;
		List<RrPermissionBean> permissionBeanList = new ArrayList<>();

		RrPermissionBean permissionBean = null;

		Long roleId = 0L;
		String status = RrConstants.STRING_EMPTY;

		List<String> menuNameList = new ArrayList<>();
		List<Integer> menuIdList = new ArrayList<>();

		String roleName = null;

		try {
			permissionMasterList = permissionConfDao.getAllPermissionList();

			if ((null != permissionMasterList) && (!permissionMasterList.isEmpty())) {

				roleId = permissionMasterList.get(0).getRrUserRoleMaster().getRrUserRoleMasterId();
				status = permissionMasterList.get(0).getStatus();

				for (RrPermissionMaster permissionMaster : permissionMasterList) {

					if (roleId != permissionMaster.getRrUserRoleMaster().getRrUserRoleMasterId()) {
						permissionBean = new RrPermissionBean();
						permissionBean.setRoleName(roleName);
						permissionBean.setRoleId(roleId);
						permissionBean.setMenuName(String.join(", ", menuNameList));
						permissionBean.setMenuId(menuIdList.toArray(new Long[0]));

						permissionBean.setStatus(status);
						permissionBean.setStatusClass(status);

						permissionBeanList.add(permissionBean);

						menuNameList = new ArrayList<>();
						menuIdList = new ArrayList<>();
						menuNameList.add(permissionMaster.getRrMenus().getTitle());
						menuIdList.add(permissionMaster.getRrMenus().getRrMenusId());
						roleName = permissionMaster.getRrUserRoleMaster().getRoleName();
					} else {
						menuNameList.add(permissionMaster.getRrMenus().getTitle());
						menuIdList.add(permissionMaster.getRrMenus().getRrMenusId());
						status = permissionMaster.getStatus();
						roleName = permissionMaster.getRrUserRoleMaster().getRoleName();
					}
					roleId = permissionMaster.getRrUserRoleMaster().getRrUserRoleMasterId();
				}
				permissionBean = new RrPermissionBean();
				permissionBean.setRoleName(roleName);
				permissionBean.setRoleId(roleId);
				permissionBean.setMenuName(String.join(", ", menuNameList));
				permissionBean.setMenuId(menuIdList.toArray(new Long[0]));

				permissionBean.setStatus(status);
				permissionBean.setStatusClass(status);

				permissionBeanList.add(permissionBean);
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrPermissionConfServiceImpl at getAllPermissionList(): ", e);
		}

		return permissionBeanList;
	}

	@Override
	public String updatePermission(RrPermissionBean permissionBean) {

		RrPermissionMaster permissionMaster = null;
		String status = RrConstants.FAILURE;

		try {
			// permissionMaster =
			// permissionConfDao.getPermissionById(permissionBean.getUserRoleId());

			/*
			 * if (null != permissionMaster) {
			 * permissionMaster.setRoleName(permissionBean.getRoleName());
			 * permissionMaster.setRoleDesc(permissionBean.getRoleDesc());
			 * permissionMaster.setUserType(permissionBean.getUserType());
			 * permissionMaster.setRoleOrder(permissionBean.getRoleOrder());
			 * 
			 * permissionMaster.setActiveStatus(permissionBean.getActiveStatus()
			 * ); permissionMaster.setModifiedTime(new Date());
			 * permissionMaster.setModifiedBy(""); status =
			 * permissionConfDao.saveOrUpdatePermission(permissionMaster); }
			 */
		} catch (Exception e) {
			logger.error("@@@ Exception in RrPermissionConfServiceImpl at updatePermission(): ", e);
		}

		return status;
	}

	@Override
	public String createPermission(RrPermissionBean permissionBean) {

		RrPermissionMaster permissionMaster = null;
		RrMenus testMenus;
		RrUserRoleMaster testUserRoleMaster;
		String status = RrConstants.FAILURE;

		try {
			if ((null != permissionBean.getRoleId()) && (null != permissionBean.getMenuId())) {

				testUserRoleMaster = new RrUserRoleMaster();
				testUserRoleMaster.setRrUserRoleMasterId(permissionBean.getRoleId());

				for (Long menuId : permissionBean.getMenuId()) {
					permissionMaster = new RrPermissionMaster();
					permissionMaster.setRrUserRoleMaster(testUserRoleMaster);

					testMenus = new RrMenus();
					testMenus.setRrMenusId(menuId.intValue());
					permissionMaster.setRrMenus(testMenus);

					permissionMaster.setStatus(permissionBean.getStatus());
					permissionMaster.setCreatedBy(1L);

					status = permissionConfDao.saveOrUpdatePermission(permissionMaster);
				}
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrPermissionConfServiceImpl at createPermission(): ", e);
		}

		return status;
	}

	@Override
	public String deletePermissionById(Integer permissionId) {

		String status = RrConstants.FAILURE;

		try {
			status = permissionConfDao.deletePermissionById(permissionId);
		} catch (Exception e) {
			logger.error("@@@ Exception in RrPermissionConfServiceImpl at deletePermissionById(): ", e);
		}

		return status;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public Map<Integer, String> getMenuMap() {

		Map<Integer, String> menuMap = new LinkedHashMap<>();

		List<RrMenus> menuList = null;

		try {
			menuList = menuConfDao.getAllMenus();

			if ((null != menuList) && (!menuList.isEmpty())) {
				for (RrMenus menu : menuList) {
					if (menu.isActiveStatus()) {
						menuMap.put(menu.getRrMenusId(), menu.getTitle());
					}
				}
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrPermissionConfServiceImpl at getMenuMap(): ", e);
		}

		return menuMap;
	}

	@Override
	public RrPermissionBean getPermissionById(Integer permissionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
