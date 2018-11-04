package com.admin.rr.dao;

import com.admin.rr.entity.RrUserProfile;

/**
 * @author jogeswar
 *
 */
public interface RrLoginDao {

	public RrUserProfile getUserByUserName(String userName, String uPassword);

}
