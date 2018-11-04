package com.admin.rr.service;

import java.util.List;

import com.admin.rr.beans.RrStateBean;

/**
 * @author jogeswarsahu
 *
 */
public interface RrStateConfService {

	public List<RrStateBean> getAllStateList();

	public RrStateBean getStateById(Long stateId);

	public String createState(RrStateBean testStateBean);

	public String updateState(RrStateBean testStateBean);

	public String deleteStateById(Long stateId);

}
