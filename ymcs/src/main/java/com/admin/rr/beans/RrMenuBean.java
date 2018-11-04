package com.admin.rr.beans;

/**
 * @author jogeswarsahu
 *
 */
public class RrMenuBean {

	private String action = "".intern();
	private String menuName;
	private String menuDesc;
	private String menuUrl;
	private String iconUrl;
	private String parentMenuLevel;
	private byte activeStatus = 1;
	private String menuId;

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action
	 *            the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the menuName
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * @param menuName
	 *            the menuName to set
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	/**
	 * @return the menuDesc
	 */
	public String getMenuDesc() {
		return menuDesc;
	}

	/**
	 * @param menuDesc
	 *            the menuDesc to set
	 */
	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}

	/**
	 * @return the menuUrl
	 */
	public String getMenuUrl() {
		return menuUrl;
	}

	/**
	 * @param menuUrl
	 *            the menuUrl to set
	 */
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	/**
	 * @return the iconUrl
	 */
	public String getIconUrl() {
		return iconUrl;
	}

	/**
	 * @param iconUrl
	 *            the iconUrl to set
	 */
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	/**
	 * @return the parentMenuLevel
	 */
	public String getParentMenuLevel() {
		return parentMenuLevel;
	}

	/**
	 * @param parentMenuLevel
	 *            the parentMenuLevel to set
	 */
	public void setParentMenuLevel(String parentMenuLevel) {
		this.parentMenuLevel = parentMenuLevel;
	}

	/**
	 * @return the activeStatus
	 */
	public byte getActiveStatus() {
		return activeStatus;
	}

	/**
	 * @param activeStatus
	 *            the activeStatus to set
	 */
	public void setActiveStatus(byte activeStatus) {
		this.activeStatus = activeStatus;
	}

	/**
	 * @return the menuId
	 */
	public String getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId
	 *            the menuId to set
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

}
