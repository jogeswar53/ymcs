package com.admin.rr.dao;

import java.util.List;

import com.admin.rr.entity.RrMenus;

/**
 * @author jogeswarsahu
 *
 */
public interface RrMenuConfDao {

	public List<RrMenus> getAllMenus();

	public Long getMenuCount(String queryString, String condition);

	public String saveOrUpdateMenu(RrMenus RrMenu);

	public String deleteMenuById(Integer menuId);

	public RrMenus getMenuById(Integer menuId);

}
