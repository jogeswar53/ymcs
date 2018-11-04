package com.admin.rr.dao;

import java.util.List;

import com.admin.rr.entity.RrPermissionMaster;

/**
 * @author jogeswarsahu
 *
 */
public interface RrPermissionConfDao {

	public List<RrPermissionMaster> getAllPermissionList();

	public String saveOrUpdatePermission(RrPermissionMaster permissionMaster);

	public RrPermissionMaster getPermissionById(Integer permissionId);

	public String deletePermissionById(Integer permissionId);

}
