package com.admin.rr.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author jogeswarsahu
 *
 */
public interface RrCommonService {

	public Map<Long, String> getCountryMap();

	public Map<Long, String> getStateMap();

	public Map<Long, String> getUserRoleMap();

	public Map<Long, String> getOrganizationMap();

	public String decodeBase64File(String sourceFileCode, String targetDirectory, String targetFile);

	public String getFileContent(MultipartFile file, HttpServletRequest request);

}
