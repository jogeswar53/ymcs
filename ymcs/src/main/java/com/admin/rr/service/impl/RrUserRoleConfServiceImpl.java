package com.admin.rr.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.admin.rr.beans.RrUserRoleBean;
import com.admin.rr.constants.RrConstants;
import com.admin.rr.dao.RrUserRoleConfDao;
import com.admin.rr.entity.RrMenus;
import com.admin.rr.entity.RrPermissionMaster;
import com.admin.rr.entity.RrUserRoleMaster;
import com.admin.rr.service.RrUserRoleConfService;
import com.admin.rr.utils.RrCommonUtils;

/**
 * @author jogeswar
 *
 */
@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class RrUserRoleConfServiceImpl implements RrUserRoleConfService {

	private static final Logger logger = LogManager.getLogger(RrUserRoleConfServiceImpl.class.getName());

	@Autowired
	RrUserRoleConfDao userRoleConfDao;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public List<RrUserRoleBean> getAllUserRoleList() {

		List<RrUserRoleMaster> roleMasterList = null;
		List<RrUserRoleBean> userRoleBeanList = new ArrayList<>();
		List<String> menuNameList = null;

		RrUserRoleBean userRoleBean = null;

		try {
			roleMasterList = userRoleConfDao.getAllUserRoleList();

			if (null != roleMasterList) {
				for (RrUserRoleMaster userRoleMaster : roleMasterList) {
					userRoleBean = new RrUserRoleBean();
					userRoleBean.setUserRoleId(userRoleMaster.getRrUserRoleMasterId());
					userRoleBean.setRoleName(userRoleMaster.getRoleName());
					userRoleBean.setRoleDesc(userRoleMaster.getRoleDesc());

					userRoleBean.setStatus(userRoleMaster.getStatus());
					userRoleBean.setStatusClass(RrCommonUtils.setStatusClass(userRoleMaster.getStatus()));

					if ((null != userRoleMaster.getRrPermissionMasters())
							&& (!userRoleMaster.getRrPermissionMasters().isEmpty())) {
						menuNameList = new ArrayList<>();
						for (RrPermissionMaster permissionMaster : userRoleMaster.getRrPermissionMasters()) {
							menuNameList.add(permissionMaster.getRrMenus().getTitle());
						}

						if (!menuNameList.isEmpty()) {
							Collections.sort(menuNameList);
						}

						userRoleBean.setMenuName(String.join(", ", menuNameList));
					}

					userRoleBeanList.add(userRoleBean);
				}
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserRoleConfServiceImpl at getAllUserRoleList(): ", e);
		}

		return userRoleBeanList;
	}

	@Override
	public String updateUserRole(RrUserRoleBean userRoleBean) {

		RrUserRoleMaster userRoleMaster = null;
		String status = RrConstants.FAILURE;

		try {
			userRoleMaster = userRoleConfDao.getUserRoleById(userRoleBean.getUserRoleId());

			if (null != userRoleMaster) {
				userRoleMaster.setRoleName(userRoleBean.getRoleName());
				userRoleMaster.setRoleDesc(userRoleBean.getRoleDesc());

				userRoleMaster.setStatus(userRoleBean.getStatus());
				userRoleMaster.setModifiedBy(1L);
				status = userRoleConfDao.saveOrUpdateUserRole(userRoleMaster);
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserRoleConfServiceImpl at updateUserRole(): ", e);
		}

		return status;
	}

	@Override
	public String createUserRole(RrUserRoleBean userRoleBean, Long userProfileId) {

		RrUserRoleMaster userRoleMaster = null;
		RrPermissionMaster permissionMaster = null;
		RrMenus menus;

		Set<RrPermissionMaster> permissionMasters = new HashSet<>(0);

		String status = RrConstants.FAILURE;

		try {
			if ((null != userRoleBean.getRoleName()) && (null != userRoleBean.getRoleDesc())) {
				userRoleMaster = new RrUserRoleMaster();

				userRoleMaster.setRoleName(userRoleBean.getRoleName());
				userRoleMaster.setRoleDesc(userRoleBean.getRoleDesc());

				for (Long menuId : userRoleBean.getMenuId()) {
					permissionMaster = new RrPermissionMaster();
					permissionMaster.setRrUserRoleMaster(userRoleMaster);

					menus = new RrMenus();
					menus.setRrMenusId(menuId.intValue());
					permissionMaster.setRrMenus(menus);

					permissionMaster.setStatus(userRoleBean.getStatus());
					permissionMaster.setCreatedBy(userProfileId);

					permissionMasters.add(permissionMaster);
				}

				if (!permissionMasters.isEmpty()) {
					userRoleMaster.setRrPermissionMasters(permissionMasters);
				}
				userRoleMaster.setStatus(userRoleBean.getStatus());
				userRoleMaster.setCreatedBy(userProfileId);

				status = userRoleConfDao.saveOrUpdateUserRole(userRoleMaster);
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserRoleConfServiceImpl at createUserRole(): ", e);
		}

		return status;
	}

	@Override
	public String deleteUserRoleById(Long syllabusId) {

		String status = RrConstants.FAILURE;

		try {
			status = userRoleConfDao.deleteUserRoleById(syllabusId);
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserRoleConfServiceImpl at deleteUserRoleById(): ", e);
		}

		return status;
	}

	@Override
	public RrUserRoleBean getUserRoleById(Long userRoleId) {

		RrUserRoleBean userRoleBean = new RrUserRoleBean();
		RrUserRoleMaster userRoleMaster = null;

		try {
			userRoleMaster = userRoleConfDao.getUserRoleById(userRoleId);

			if (null != userRoleMaster) {
				userRoleBean = new RrUserRoleBean();
				userRoleBean.setUserRoleId(userRoleMaster.getRrUserRoleMasterId());
				userRoleBean.setRoleName(userRoleMaster.getRoleName());
				userRoleBean.setRoleDesc(userRoleMaster.getRoleDesc());
				userRoleBean.setStatus(userRoleMaster.getStatus());
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserRoleConfServiceImpl at getUserRoleById(): ", e);
		}

		return userRoleBean;
	}

}
