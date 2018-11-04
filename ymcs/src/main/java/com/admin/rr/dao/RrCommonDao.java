package com.admin.rr.dao;

import java.util.List;

import com.admin.rr.entity.RrMenus;

/**
 * @author jogeswarsahu
 *
 */
public interface RrCommonDao {

	public List<RrMenus> getMenuListByUserRole(Long userRoleId);

	public List<RrMenus> getMenuListByUserRole();

}
