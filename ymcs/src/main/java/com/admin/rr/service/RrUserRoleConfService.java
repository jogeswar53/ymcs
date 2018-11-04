package com.admin.rr.service;

import java.util.List;

import com.admin.rr.beans.RrUserRoleBean;

/**
 * @author jogeswar
 *
 */
public interface RrUserRoleConfService {

	public List<RrUserRoleBean> getAllUserRoleList();

	public String updateUserRole(RrUserRoleBean userRoleBean);

	public String createUserRole(RrUserRoleBean userRoleBean, Long userProfileId);

	public String deleteUserRoleById(Long userRoleId);

	public RrUserRoleBean getUserRoleById(Long userRoleId);

}
