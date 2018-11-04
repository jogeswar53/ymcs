package com.admin.rr.dao;

import java.util.List;

import com.admin.rr.entity.RrUserProfile;

/**
 * @author jogeswar
 *
 */
public interface RrUserProfileConfDao {

	public Long saveOrUpdateUserProfile(RrUserProfile userProfile);

	public RrUserProfile getUserProfileById(Long userProfileId);

	public List<RrUserProfile> getAllUserProfiles();

	public String deleteUserProfileById(Long userProfileId);

	public String checkDuplicateUserName(String userName);

}
