package com.admin.rr.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.admin.rr.beans.RrUserBean;
import com.admin.rr.constants.RrConstants;
import com.admin.rr.dao.RrUserProfileConfDao;
import com.admin.rr.entity.RrCountryMaster;
import com.admin.rr.entity.RrOrganizationMaster;
import com.admin.rr.entity.RrStateMaster;
import com.admin.rr.entity.RrUserProfile;
import com.admin.rr.entity.RrUserProfile;
import com.admin.rr.entity.RrUserRoleMaster;
import com.admin.rr.service.RrCommonService;
import com.admin.rr.service.RrUserProfileConfService;
import com.admin.rr.utils.RrCommonUtils;

/**
 * @author jogeswar
 *
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class RrUserProfileConfServiceImpl implements RrUserProfileConfService {

	private static final Logger logger = LogManager.getLogger(RrUserProfileConfServiceImpl.class.getName());

	@Autowired
	RrUserProfileConfDao userProfileConfDao;

	@Autowired
	RrCommonService commonService;

	@Value("${application.upload.images.folder}")
	String imagePath;

	@Value("${application.upload.files.folder}")
	String filesPath;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String createUserProfile(RrUserBean userBean) {

		RrCountryMaster countryMaster;
		RrOrganizationMaster organizationMaster;
		RrUserRoleMaster userRoleMaster;
		RrStateMaster stateMaster;
		RrUserProfile userProfile;

		String status = RrConstants.FAILURE;

		try {
			if (null != userBean.getUserName() && !userBean.getUserName().isEmpty()) {

				// creating UserRegister Entry
				userProfile = new RrUserProfile();
				userProfile.setUserName(userBean.getUserName());
				userProfile.setUserPwd(userBean.getUpassword());

				// creating UserProfile Entry
				if ((null != userBean.getProfilePhotoImg()) && (!userBean.getProfilePhotoImg().isEmpty())) {
					userProfile.setProfilePhotoImg(commonService.decodeBase64File(userBean.getProfilePhotoImg(),
							imagePath, "user/" + (userBean.getFirstName() + "_" + System.currentTimeMillis())));
				}

				if (null != userBean.getMiddleName()) {
					userProfile.setMiddleName(userBean.getMiddleName());
				}

				countryMaster = new RrCountryMaster();
				countryMaster.setRrCountryMasterId(userBean.getCountryId());
				userProfile.setRrCountryMaster(countryMaster);

				userRoleMaster = new RrUserRoleMaster();
				userRoleMaster.setRrUserRoleMasterId(userBean.getUserRoleId());
				userProfile.setRrUserRoleMaster(userRoleMaster);

				organizationMaster = new RrOrganizationMaster();
				organizationMaster.setRrOrganizationMasterId(userBean.getOrganizationId());
				userProfile.setRrOrganizationMaster(organizationMaster);

				stateMaster = new RrStateMaster();
				stateMaster.setRrStateMasterId(userBean.getStateId());
				userProfile.setRrStateMaster(stateMaster);

				userProfile.setUserTitle(userBean.getUserTitle());
				userProfile.setFirstName(userBean.getFirstName());
				userProfile.setLastName(userBean.getLastName());
				userProfile.setUserName(userBean.getUserName());
				userProfile.setGender(userBean.getGender());
				userProfile.setEmail(userBean.getEmailId());
				userProfile.setMobile(userBean.getMobileNumber());
				userProfile.setVoterIdNo(userBean.getVoterIdNo());
				userProfile.setAdharCardNo(userBean.getAdharCardNo());

				userProfile.setPermanentAddr1(userBean.getPermanentAddr1());
				userProfile.setPermanentAddr2(userBean.getPermanentAddr2());
				userProfile.setPermanentAddr3(userBean.getPermanentAddr3());

				userProfile.setPresentAddr1(userBean.getPresentAddr1());
				userProfile.setPresentAddr2(userBean.getPresentAddr2());
				userProfile.setPresentAddr3(userBean.getPresentAddr3());

				userProfile.setDob(RrCommonUtils.getDateFromString(userBean.getDateOfBirth(), null));

				userProfile.setStatus(userBean.getStatus());
				userProfile.setCreatedTime(new Date());
				userProfile.setCreatedBy(1L);

				if (userProfileConfDao.saveOrUpdateUserProfile(userProfile) > 0) {
					status = RrConstants.SUCCESS;
				}
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserProfileConfServiceImpl at createUserProfile(): ", e);
		}

		return status;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String updateUserProfile(RrUserBean userBean) {

		RrUserProfile userProfile = null;

		String status = RrConstants.FAILURE;

		try {
			userProfile = userProfileConfDao.getUserProfileById(userBean.getUserProfileId());

			if (null != userProfile) {
				// userProfile.setClassCode(userBean.getClassCode());
				// userProfile.setClassName(userBean.getClassName());

				userProfile.setStatus(userBean.getStatus());
				userProfile.setCreatedTime(new Date());
				userProfile.setCreatedBy(1L);

				if (userProfileConfDao.saveOrUpdateUserProfile(userProfile) > 0) {
					status = RrConstants.SUCCESS;
				}
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserProfileConfServiceImpl at updateUserProfile(): ", e);
		}

		return status;
	}

	@Override
	public List<RrUserBean> getAllUserProfiles() {

		List<RrUserProfile> userProfileList = null;
		List<RrUserBean> classBeanList = new ArrayList<>();

		RrUserBean userBean = null;

		try {
			userProfileList = userProfileConfDao.getAllUserProfiles();

			if ((null != userProfileList) && (!userProfileList.isEmpty())) {
				for (RrUserProfile userProfile : userProfileList) {
					userBean = new RrUserBean();

					userBean.setUserProfileId(userProfile.getRrUserProfileId());
					userBean.setRoleName(userProfile.getRrUserRoleMaster().getRoleName());
					userBean.setUserName(userProfile.getUserName());

					userBean.setStatus(userProfile.getStatus());
					userBean.setStatusClass(RrCommonUtils.setStatusClass(userProfile.getStatus()));

					classBeanList.add(userBean);
				}
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserProfileConfServiceImpl at getAllUserProfiles(): ", e);
		}

		return classBeanList;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String deleteUserProfileById(String userProfileId) {

		String status = RrConstants.FAILURE;

		try {
			status = userProfileConfDao.deleteUserProfileById(Long.parseLong(userProfileId));
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserProfileConfServiceImpl at deleteUserProfileById(): ", e);
		}

		return status;
	}

	@Override
	public String checkDuplicateUserName(String userName) {

		String status = RrConstants.FAILURE;

		try {
			// status =
			// userProfileConfDao.deleteUserProfileById(Integer.parseInt(userProfileId));
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserProfileConfServiceImpl at checkDuplicateUserId(): ", e);
		}

		return status;
	}

}
