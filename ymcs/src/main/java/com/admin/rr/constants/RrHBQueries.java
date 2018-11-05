package com.admin.rr.constants;

public class RrHBQueries {

	/***
	 * 
	 * rradminportal query
	 * 
	 */

	public static final String Af_GET_ROLE_PERMISSIONS_BY_ID = "select afarp from AfCbsAdminRolePermissions iparp where afarp.afCbsAdminRoles=:roleId";

	/**
	 * Start of menu query
	 */
	public static final String GET_MAX_MENU_LEVEL = "select max(menuLevel) from RrMenus where length(menuLevel)=3";

	public static final String GET_MAX_SUB_MENU_LEVEL = "select max(substring(menuLevel, -3)) from RrMenus where menuLevel like :condition";

	/**
	 * End of menu query
	 */

	/**
	 * Start of login query
	 */
	public static final String AF_GET_ACTIVE_USER_BY_EMAIL = "select user from RrUserProfile user"
			+ " where user.userName=:userName and user.userPwrd=md5(:uPassword)";

	/**
	 * End of login query
	 */

	private RrHBQueries() {
	}

}
