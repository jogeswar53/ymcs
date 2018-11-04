package com.admin.rr.service;

import java.util.List;

import com.admin.rr.beans.RrUserBean;

/**
 * @author jogeswar
 *
 */
public interface RrUserProfileConfService {

	public String createUserProfile(RrUserBean userBean);

	public String updateUserProfile(RrUserBean userBean);

	public List<RrUserBean> getAllUserProfiles();

	public String deleteUserProfileById(String userProfileId);

	public String checkDuplicateUserName(String userName);

}
