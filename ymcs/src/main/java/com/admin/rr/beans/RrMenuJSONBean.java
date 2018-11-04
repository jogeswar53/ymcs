package com.admin.rr.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jogeswarsahu
 *
 */
public class RrMenuJSONBean {

	private String text;
	private String id;
	private List<RrMenuJSONBean> children = new ArrayList<>();

	private RrMenuAttributeJSONBean a_attr = new RrMenuAttributeJSONBean();
	private RrMenuStateJSONBean state = new RrMenuStateJSONBean();

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the children
	 */
	public List<RrMenuJSONBean> getChildren() {
		return children;
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(List<RrMenuJSONBean> children) {
		this.children = children;
	}

	/**
	 * @return the a_attr
	 */
	public RrMenuAttributeJSONBean getA_attr() {
		return a_attr;
	}

	/**
	 * @param a_attr
	 *            the a_attr to set
	 */
	public void setA_attr(RrMenuAttributeJSONBean a_attr) {
		this.a_attr = a_attr;
	}

	/**
	 * @return the state
	 */
	public RrMenuStateJSONBean getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(RrMenuStateJSONBean state) {
		this.state = state;
	}

}
