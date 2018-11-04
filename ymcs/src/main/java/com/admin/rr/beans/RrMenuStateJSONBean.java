package com.admin.rr.beans;

/**
 * @author jogeswarsahu
 *
 */
public class RrMenuStateJSONBean {

	private boolean opened;
	private boolean disabled;
	private boolean selected;

	/**
	 * @return the opened
	 */
	public boolean isOpened() {
		return opened;
	}

	/**
	 * @param opened
	 *            the opened to set
	 */
	public void setOpened(boolean opened) {
		this.opened = opened;
	}

	/**
	 * @return the disabled
	 */
	public boolean isDisabled() {
		return disabled;
	}

	/**
	 * @param disabled
	 *            the disabled to set
	 */
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	/**
	 * @return the selected
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * @param selected
	 *            the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
