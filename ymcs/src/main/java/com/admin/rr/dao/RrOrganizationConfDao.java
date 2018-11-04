package com.admin.rr.dao;

import java.util.List;

import com.admin.rr.entity.RrOrganizationMaster;

/**
 * @author jogeswarsahu
 *
 */
public interface RrOrganizationConfDao {

	public String saveOrUpdateOrganization(RrOrganizationMaster organizationMaster);

	public List<RrOrganizationMaster> getAllOrganizations();

	public RrOrganizationMaster getOrganizationById(Long organizationId);

}
