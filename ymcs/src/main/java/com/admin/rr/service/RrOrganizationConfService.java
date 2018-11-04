package com.admin.rr.service;

import java.util.List;

import com.admin.rr.beans.RrOrganizationBean;

/**
 * @author jogeswarsahu
 *
 */
public interface RrOrganizationConfService {

	public String createOrganization(RrOrganizationBean organizationBean);

	public String updateOrganization(RrOrganizationBean organizationBean);

	public List<RrOrganizationBean> getAllOrganizations();

	public RrOrganizationBean getOrganizationById(Long organizationId);

}
