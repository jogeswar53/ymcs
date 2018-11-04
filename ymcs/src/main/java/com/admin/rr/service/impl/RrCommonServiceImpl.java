package com.admin.rr.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.admin.rr.constants.RrConstants;
import com.admin.rr.dao.RrCommonDao;
import com.admin.rr.dao.RrCountryConfDao;
import com.admin.rr.dao.RrOrganizationConfDao;
import com.admin.rr.dao.RrStateConfDao;
import com.admin.rr.dao.RrUserRoleConfDao;
import com.admin.rr.entity.RrCountryMaster;
import com.admin.rr.entity.RrOrganizationMaster;
import com.admin.rr.entity.RrStateMaster;
import com.admin.rr.entity.RrUserRoleMaster;
import com.admin.rr.service.RrCommonService;

/**
 * @author jogeswarsahu
 *
 */
@Service
public class RrCommonServiceImpl implements RrCommonService {

	private static final Logger logger = LogManager.getLogger(RrCommonServiceImpl.class.getName());

	@Autowired
	RrCommonDao commonDao;

	@Autowired
	RrCountryConfDao countryDao;

	@Autowired
	RrStateConfDao stateConfDao;

	@Autowired
	RrUserRoleConfDao userRoleConfDao;

	@Autowired
	RrOrganizationConfDao organizationConfDao;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public Map<Long, String> getCountryMap() {

		Map<Long, String> countryMap = new LinkedHashMap<>();
		List<RrCountryMaster> countryMasterList = null;

		try {
			countryMasterList = countryDao.getAllCountryList();

			if ((null != countryMasterList) && (!countryMasterList.isEmpty())) {
				for (RrCountryMaster country : countryMasterList) {
					if (RrConstants.ONLINE.equals(country.getStatus())) {
						countryMap.put(country.getRrCountryMasterId(), country.getCountryName());
					}
				}
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrCommonServiceImpl at getCountryMap(): ", e);
		}

		return countryMap;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public Map<Long, String> getStateMap() {

		Map<Long, String> stateMap = new LinkedHashMap<>();
		List<RrStateMaster> stateMasterList = null;

		try {
			stateMasterList = stateConfDao.getAllStateList();

			if ((null != stateMasterList) && (!stateMasterList.isEmpty())) {
				for (RrStateMaster state : stateMasterList) {
					if (RrConstants.ONLINE.equals(state.getStatus())) {
						stateMap.put(state.getRrStateMasterId(), state.getStateName());
					}
				}
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrCommonServiceImpl at getStateMap(): ", e);
		}

		return stateMap;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public Map<Long, String> getUserRoleMap() {

		Map<Long, String> userRoleMap = new LinkedHashMap<>();
		List<RrUserRoleMaster> roleMasterList = null;

		try {
			roleMasterList = userRoleConfDao.getAllUserRoleList();

			if ((null != roleMasterList) && (!roleMasterList.isEmpty())) {
				for (RrUserRoleMaster userRoleMaster : roleMasterList) {
					if (userRoleMaster.getRrUserRoleMasterId() > 1
							&& RrConstants.ONLINE.equals(userRoleMaster.getStatus())) {
						userRoleMap.put(userRoleMaster.getRrUserRoleMasterId(), userRoleMaster.getRoleName());
					}
				}
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrCommonServiceImpl at getUserRoleMap(): ", e);
		}

		return userRoleMap;
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public Map<Long, String> getOrganizationMap() {

		Map<Long, String> organizationMap = new LinkedHashMap<>();
		List<RrOrganizationMaster> organizationMasterList = null;

		try {
			organizationMasterList = organizationConfDao.getAllOrganizations();

			if ((null != organizationMasterList) && (!organizationMasterList.isEmpty())) {
				for (RrOrganizationMaster organizationMaster : organizationMasterList) {
					if (RrConstants.ONLINE.equals(organizationMaster.getStatus())) {
						organizationMap.put(organizationMaster.getRrOrganizationMasterId(),
								organizationMaster.getOrganizationName());
					}
				}
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrCommonServiceImpl at getOrganizationMap(): ", e);
		}

		return organizationMap;
	}

	@Override
	public String decodeBase64File(String sourceFileCode, String targetDirectory, String targetFileName) {

		String fileNamePath = null;
		String targetFile = targetFileName;

		try {
			String[] parts = sourceFileCode.split(",");
			String fileFormat = parts[0];
			String base64String = parts[1];

			byte[] fileByte;
			fileByte = Base64.decodeBase64(base64String);

			targetFile += "." + fileFormat.substring((fileFormat.indexOf(File.separator) + 1),
					fileFormat.indexOf(RrConstants.SEMICOLON));

			File file = new File(targetDirectory);
			if (!file.exists()) {
				file.mkdir();
			}
			fileNamePath = new StringBuilder(targetDirectory).append(targetFile).toString();
			FileUtils.writeByteArrayToFile(new File(fileNamePath), fileByte);
			fileNamePath = targetFile;
		} catch (Exception e) {
			fileNamePath = null;
			logger.error("@@@ Exception in RrCommonServiceImpl at decodeBase64(): ", e);
		}

		return fileNamePath;
	}

	@Override
	public String getFileContent(MultipartFile file, HttpServletRequest request) {

		String content = null;

		if (!file.isEmpty()) {
			StringBuilder contentBuilder = new StringBuilder();
			try (BufferedReader in = new BufferedReader(new InputStreamReader(file.getInputStream()));) {
				String str;
				while ((str = in.readLine()) != null) {
					contentBuilder.append(str);
				}
			} catch (IOException e) {
				logger.error("@@@@Exception in RrCommonServiceImpl at getFileContent() :", e);
			}
			content = contentBuilder.toString();
		}

		return content;
	}

}
