package com.admin.rr.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.admin.rr.beans.RrMenuAttributeJSONBean;
import com.admin.rr.beans.RrMenuBean;
import com.admin.rr.beans.RrMenuJSONBean;
import com.admin.rr.beans.RrMenuStateJSONBean;
import com.admin.rr.constants.RrConstants;
import com.admin.rr.constants.RrHBQueries;
import com.admin.rr.dao.RrMenuConfDao;
import com.admin.rr.entity.RrMenus;
import com.admin.rr.service.RrMenuConfService;
import com.admin.rr.utils.RrCommonUtils;

/**
 * @author jogeswarsahu
 *
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class RrMenuConfServiceImpl implements RrMenuConfService {

	private static final Logger logger = LogManager.getLogger(RrMenuConfServiceImpl.class.getName());

	@Autowired
	RrMenuConfDao testMenuConfDao;

	public List<RrMenuJSONBean> getMenuJson() {

		List<RrMenuJSONBean> menuJsonBeanList = new ArrayList<>();
		List<RrMenus> menuList = null;
		List<Integer> childMenuNos = new ArrayList<>();

		boolean isFirstTimeYes = true;
		RrMenus menu;
		RrMenuJSONBean menuJsonBean;
		RrMenuAttributeJSONBean attributeJsonBean;
		Map<String, String> activeStatusMap = new HashMap<>();

		try {
			menuList = testMenuConfDao.getAllMenus();

			if ( (null != menuList) && (!menuList.isEmpty()) ) {
				for (int i = 0; i < menuList.size(); i++) {
					menu = menuList.get(i);

					if (menu.getMenuLevel().trim().length() == 3) {
						menuJsonBean = new RrMenuJSONBean();
						menuJsonBean.setId(menu.getMenuLevel());
						menuJsonBean.setText(menu.getTitle());

						attributeJsonBean = new RrMenuAttributeJSONBean();

						attributeJsonBean.setMenuId(menu.getRrMenusId());
						attributeJsonBean.setMenuLevel(menu.getMenuLevel());
						attributeJsonBean.setTitle(menu.getTitle());
						attributeJsonBean.setMenuDesc(menu.getDescription());
						attributeJsonBean.setMenuUrl(menu.getUrl());
						attributeJsonBean.setMenuIconUrl(menu.getIconUrl());
						attributeJsonBean.setStatus(String.valueOf(menu.isActiveStatus()));

						RrCommonUtils.setAcviteStatus(activeStatusMap, menu.isActiveStatus());

						attributeJsonBean.setStatusValue(activeStatusMap.get("statusValue"));
						attributeJsonBean.setStatusClass(activeStatusMap.get("statusClass"));

						menuJsonBean.setA_attr(attributeJsonBean);

						if (isFirstTimeYes) {
							isFirstTimeYes = false;
							RrMenuStateJSONBean stateJsonBean = new RrMenuStateJSONBean();
							stateJsonBean.setSelected(true);
							menuJsonBean.setState(stateJsonBean);
						}

						new RrCommonUtils().hasChild(menuJsonBean, menuList, (i + 1), menu.getMenuLevel(),
								(3 * 3 + 2), 3, childMenuNos, activeStatusMap);

						menuJsonBeanList.add(menuJsonBean);
					}
				}
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrMenuConfServiceImpl at getMenuJson(): ", e);
		}

		return menuJsonBeanList;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String createMenu(RrMenuBean testMenuBean) {

		String status = RrConstants.FAILURE;
		Long rowValue = 0L;

		RrMenus menu = new RrMenus();

		try {
			if (null != testMenuBean.getMenuName() && !testMenuBean.getMenuName().isEmpty()) {
				if (null != testMenuBean.getParentMenuLevel() && !testMenuBean.getParentMenuLevel().isEmpty()) {
					String condition = testMenuBean.getParentMenuLevel().trim() + "-%";
					rowValue = testMenuConfDao.getMenuCount(RrHBQueries.GET_MAX_SUB_MENU_LEVEL, condition);

					if (rowValue == 0) {
						menu.setMenuLevel(testMenuBean.getParentMenuLevel().trim() + "-001".intern());
					} else {
						int newValue = rowValue.intValue() + 1;
						if (newValue < 10) {
							menu.setMenuLevel(testMenuBean.getParentMenuLevel().trim() + "-00".intern() + newValue);
						} else if (newValue < 100) {
							menu.setMenuLevel(testMenuBean.getParentMenuLevel().trim() + "-0".intern() + newValue);
						} else if (newValue >= 100) {
							menu.setMenuLevel(testMenuBean.getParentMenuLevel().trim() + "-".intern() + newValue);
						}
					}
				} else {
					rowValue = testMenuConfDao.getMenuCount(RrHBQueries.GET_MAX_MENU_LEVEL, RrConstants.STRING_EMPTY);

					int newValue = rowValue.intValue() + 1;

					if (newValue < 10) {
						menu.setMenuLevel("00" + newValue);
					} else if (newValue < 100) {
						menu.setMenuLevel("0" + newValue);
					} else if (newValue >= 100) {
						menu.setMenuLevel(String.valueOf(newValue));
					}
				}
				menu.setCreatedBy(1L);
				menu.setCreatedTime(new Date());
				menu.setDescription(testMenuBean.getMenuDesc());
				menu.setIconUrl(testMenuBean.getIconUrl());
				menu.setTitle(testMenuBean.getMenuName());
				menu.setUrl(testMenuBean.getMenuUrl());

				menu.setDeleteStatus(false);
				menu.setActiveStatus(RrCommonUtils.getBooleanStatus(testMenuBean.getActiveStatus()));

				status = testMenuConfDao.saveOrUpdateMenu(menu);
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrMenuConfServiceImpl at createMenu(): ", e);
		}

		return status;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String updateMenu(RrMenuBean testMenuBean) {

		String status = RrConstants.FAILURE;
		RrMenus menu = null;

		try {
			if (null != testMenuBean.getMenuName() && !testMenuBean.getMenuName().isEmpty()) {
				menu = testMenuConfDao.getMenuById(Integer.parseInt(testMenuBean.getMenuId()));

				if (null != menu) {
					menu.setModifiedBy(1L);
					menu.setModifiedTime(new Date());
					menu.setDescription(testMenuBean.getMenuDesc());
					menu.setIconUrl(testMenuBean.getIconUrl());
					menu.setTitle(testMenuBean.getMenuName());
					menu.setUrl(testMenuBean.getMenuUrl());

					menu.setDeleteStatus(false);
					menu.setActiveStatus(RrCommonUtils.getBooleanStatus(testMenuBean.getActiveStatus()));

					status = testMenuConfDao.saveOrUpdateMenu(menu);
				}
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrMenuConfServiceImpl at createMenu(): ", e);
		}

		return status;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String deleteMenuById(String menuId) {

		String status = RrConstants.FAILURE;

		try {
			status = testMenuConfDao.deleteMenuById(Integer.parseInt(menuId));
		} catch (Exception e) {
			logger.error("@@@ Exception in RrMenuConfServiceImpl at deleteMenuById(): ", e);
		}

		return status;
	}

}
