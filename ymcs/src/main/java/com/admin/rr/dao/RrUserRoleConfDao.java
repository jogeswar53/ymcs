package com.admin.rr.dao;

import java.util.List;

import com.admin.rr.entity.RrUserRoleMaster;

/**
 * @author jogeswarsahu
 *
 */
public interface RrUserRoleConfDao {

	public List<RrUserRoleMaster> getAllUserRoleList();

	public String saveOrUpdateUserRole(RrUserRoleMaster userRoleMaster);

	public RrUserRoleMaster getUserRoleById(Long userRoleId);

	public String deleteUserRoleById(Long userRoleId);

}
