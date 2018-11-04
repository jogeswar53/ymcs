package com.admin.rr.service.impl;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.admin.rr.beans.RrAdminUserBean;
import com.admin.rr.constants.RrConstants;
import com.admin.rr.dao.RrLoginDao;
import com.admin.rr.entity.RrUserProfile;
import com.admin.rr.service.RrLoginService;
import com.admin.rr.utils.RrCommonUtils;

/**
 * @author jogeswar
 *
 */
@Service
public class RrLoginServiceImpl implements RrLoginService {

	private Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	RrLoginDao loginDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public RrAdminUserBean authenticateUser(RrAdminUserBean adminUserBean) {

		RrUserProfile userProfile = null;
		RrAdminUserBean bean = new RrAdminUserBean();

		String userName;
		String uPassword;

		try {
			userName = RrCommonUtils.nullSafe(adminUserBean.getUserName(), RrConstants.STRING_EMPTY);
			uPassword = RrCommonUtils.nullSafe(adminUserBean.getPassword(), RrConstants.STRING_EMPTY);

			if ((!userName.isEmpty()) && (!uPassword.isEmpty())) {

				userProfile = loginDao.getUserByUserName(userName.trim(), uPassword.trim());

				if (null != userProfile) {
					userProfile.setLastLoginTime(new Date());
					// loginDao.updateUser(userProfile);

					bean.setUserId(userProfile.getUserName());
					bean.setUserProfileDetailsId(userProfile.getRrUserProfileId());
					bean.setFirstName(userProfile.getFirstName());
					bean.setLastName(userProfile.getLastName());
					bean.setUserRole(userProfile.getRrUserRoleMaster().getRrUserRoleMasterId());
					bean.setProfileImg(userProfile.getProfilePhotoImg());

					if (RrConstants.OFFLINE.equals(userProfile.getStatus())) {
						bean.setErrorMsg("You have been denied access. Please contact Admin.");
					} else if (RrConstants.DELETED.equals(userProfile.getStatus())) {
						bean.setErrorMsg("User does not exist.");
					}
				} else {
					bean.setErrorMsg("Invalid user name and password!!");
				}
			} else {
				bean.setErrorMsg("User name and password field can't be empty.!!");
			}
		} catch (Exception e) {
			logger.error("@@@@ Exception in RrUserManagementServiceImpl authenticateUser() :" + e);
		}

		return bean;
	}

}
