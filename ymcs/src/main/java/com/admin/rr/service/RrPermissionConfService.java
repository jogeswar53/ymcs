package com.admin.rr.service;

import java.util.List;
import java.util.Map;

import com.admin.rr.beans.RrPermissionBean;

/**
 * @author jogeswar
 *
 */
public interface RrPermissionConfService {

	public List<RrPermissionBean> getAllPermissionList();

	public String updatePermission(RrPermissionBean permissionBean);

	public String createPermission(RrPermissionBean permissionBean);

	public RrPermissionBean getPermissionById(Integer permissionId);

	public String deletePermissionById(Integer permissionId);

	public Map<Integer, String> getMenuMap();

}
