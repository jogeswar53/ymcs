package com.admin.rr.service;

import java.util.List;

import com.admin.rr.beans.RrMenuBean;
import com.admin.rr.beans.RrMenuJSONBean;

/**
 * @author jogeswarsahu
 *
 */
public interface RrMenuConfService {

	public List<RrMenuJSONBean> getMenuJson();

	public String createMenu(RrMenuBean testMenuBean);

	public String updateMenu(RrMenuBean testMenuBean);

	public String deleteMenuById(String menuId);

}
