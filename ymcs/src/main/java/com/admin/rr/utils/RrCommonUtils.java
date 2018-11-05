package com.admin.rr.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.admin.rr.beans.RrMenuAttributeJSONBean;
import com.admin.rr.beans.RrMenuJSONBean;
import com.admin.rr.constants.RrConstants;
import com.admin.rr.entity.RrMenus;

/**
 * @author jogeswarsahu
 *
 */
@Component
public class RrCommonUtils {

	private static final Logger logger = LogManager.getLogger(RrCommonUtils.class.getName());

	protected static Map<Boolean, String> activeStatusValueMap = null;
	protected static Map<String, String> activeStatusClassMap = null;
	protected static Map<String, String> statusClassMap = null;
	protected static Map<String, String> statusMap = null;

	public static Map<String, String> getStatus() {

		if (statusMap == null) {
			statusMap = new HashMap<>();
			statusMap.put(RrConstants.ONLINE, RrConstants.ONLINE);
			statusMap.put(RrConstants.OFFLINE, RrConstants.OFFLINE);
		}

		return statusMap;
	}

	public static String nullSafe(Object givenString, Object defaultString) {
		return (null != givenString && !"null".equals(givenString) && givenString.toString().trim().length() > 0)
				? givenString.toString().trim().intern()
				: (String) defaultString;
	}

	public static boolean getBooleanStatus(byte status) {
		return status == 1 ? true : false;
	}

	public static byte getByteStatus(boolean status) {
		return status ? (byte) 1 : (byte) 0;
	}

	public void hasChild(List<RrMenus> menuList, int index, String menuLevel, int menuLevelLength, int count,
			List<Integer> childCatNos, StringBuilder strBuffer, String applicationUrl, Integer mId) {

		RrMenus testMenus = new RrMenus();
		count = count + 1;
		String activeClass;

		try {
			for (int i = index; i < menuList.size(); i++) {
				testMenus = menuList.get(i);
				if ((testMenus.getMenuLevel().trim().length() != 3) && (testMenus.getMenuLevel().startsWith(menuLevel))
						&& !(childCatNos.contains(testMenus.getRrMenusId()))) {

					activeClass = (mId == testMenus.getRrMenusId()) ? "active".intern() : "".intern();
					strBuffer.append("<li class='").append(activeClass).append("'><a href='").append(applicationUrl)
							.append(testMenus.getUrl()).append("'><i class='fa ").append(testMenus.getIconUrl())
							.append("'></i>").append(testMenus.getTitle()).append("</a></li>");

					childCatNos.add(testMenus.getRrMenusId());

					if (((i + 1) < menuList.size())
							&& (menuList.get(i + 1).getMenuLevel().trim().length() == menuLevelLength)) {
						strBuffer.append("</a></li>");
						hasChild(menuList, (i + 1), testMenus.getMenuLevel(), ((3 * count) + ((count - 1))), count,
								childCatNos, strBuffer, applicationUrl, mId);
					}
				}
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrCommonUtils at hasChild(): ", e);
		}
	}

	public void hasChild(RrMenuJSONBean testMenuJSONBean, List<RrMenus> menuList, int index, String categoryId,
			int idLength, int count, List<Integer> childMenuNos, Map<String, String> activeStatusMap) {

		List<RrMenuJSONBean> menuJsonList = new ArrayList<>();
		RrMenus testMenu = new RrMenus();
		count = count + 1;

		try {
			for (int i = index; i < menuList.size(); i++) {
				testMenu = menuList.get(i);
				if ((testMenu.getMenuLevel().trim().length() != 3) && (testMenu.getMenuLevel().startsWith(categoryId))
						&& !(childMenuNos.contains(testMenu.getRrMenusId()))) {

					RrMenuJSONBean catJSONBean = new RrMenuJSONBean();
					catJSONBean.setId(testMenu.getMenuLevel());
					catJSONBean.setText(testMenu.getTitle());

					RrMenuAttributeJSONBean attributeJSONBean = new RrMenuAttributeJSONBean();
					attributeJSONBean.setMenuId(testMenu.getRrMenusId());
					attributeJSONBean.setMenuLevel(testMenu.getMenuLevel());
					attributeJSONBean.setTitle(testMenu.getTitle());
					attributeJSONBean.setMenuDesc(testMenu.getDescription());
					attributeJSONBean.setMenuUrl(testMenu.getUrl());
					attributeJSONBean.setMenuIconUrl(testMenu.getIconUrl());
					attributeJSONBean.setStatus(String.valueOf(testMenu.isActiveStatus()));

					setAcviteStatus(activeStatusMap, testMenu.isActiveStatus());

					attributeJSONBean.setStatusValue(activeStatusMap.get("statusValue"));
					attributeJSONBean.setStatusClass(activeStatusMap.get("statusClass"));

					catJSONBean.setA_attr(attributeJSONBean);

					childMenuNos.add(testMenu.getRrMenusId());

					if (((i + 1) < menuList.size())
							&& (menuList.get(i + 1).getMenuLevel().trim().length() == idLength)) {
						hasChild(catJSONBean, menuList, (i + 1), testMenu.getMenuLevel(), ((3 * count) + (count - 1)),
								count, childMenuNos, activeStatusMap);
					}
					menuJsonList.add(catJSONBean);
				}
				testMenuJSONBean.setChildren(menuJsonList);
			}
		} catch (Exception e) {
			logger.error("Exception in AfCbsCommonUtil at hasChild(): ", e);
		}
	}

	public static void setAcviteStatus(Map<String, String> activeStatusMap, boolean activeStatus) {
		if (null == activeStatusValueMap) {
			activeStatusValueMap = new HashMap<>();
			activeStatusValueMap.put(false, "In Active");
			activeStatusValueMap.put(true, "Active");
		}
		if (null == activeStatusClassMap) {
			activeStatusClassMap = new HashMap<>();
			activeStatusClassMap.put("In Active", "red");
			activeStatusClassMap.put("Active", "green");
		}

		activeStatusMap.put("statusValue", activeStatusValueMap.get(activeStatus));
		activeStatusMap.put("statusClass", activeStatusClassMap.get(activeStatusValueMap.get(activeStatus)));
	}

	public static String setStatusClass(String status) {
		if (null == statusClassMap) {
			statusClassMap = new HashMap<>();
			statusClassMap.put("Offline", "red");
			statusClassMap.put("Online", "green");
		}

		return statusClassMap.get(status);
	}

	public static String getFormattedDate(Date date, String format) {
		String dateStr = null;

		try {
			DateFormat df = new SimpleDateFormat(
					((format == null) || (RrConstants.STRING_EMPTY.intern().equals(format)))
							? RrConstants.DEFAULT_DATE_FORMAT.intern()
							: format);

			if (date != null) {
				dateStr = df.format(date);
			} else {
				dateStr = RrConstants.STRING_EMPTY.intern();
			}
		} catch (Exception e) {
			logger.error("Exception in RrCommonUtils getFormattedDate", e);
		}
		return dateStr;
	}

	public static Date getDateFromString(String date, String format) {

		Date dateStr = null;

		try {
			DateFormat df = new SimpleDateFormat(
					((format == null) || (RrConstants.STRING_EMPTY.intern().equals(format)))
							? RrConstants.DEFAULT_DATE_FORMAT.intern()
							: format);

			if (date != null && !date.trim().isEmpty()) {
				dateStr = df.parse(date);
			}
		} catch (Exception e) {
			logger.error("Exception in RrCommonUtils getDateFromString", e);
		}
		return dateStr;
	}

}
