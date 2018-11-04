package com.admin.rr.dao;

import java.util.List;

import com.admin.rr.entity.RrStateMaster;

/**
 * @author jogeswarsahu
 *
 */
public interface RrStateConfDao {

	public List<RrStateMaster> getAllStateList();

	public String saveOrUpdateState(RrStateMaster stateMaster);

	public RrStateMaster getStateById(Long stateId);

	public String deleteStateById(Long stateId);

}
