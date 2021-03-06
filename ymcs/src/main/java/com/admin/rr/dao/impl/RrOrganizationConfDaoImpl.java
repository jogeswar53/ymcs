package com.admin.rr.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.rr.constants.RrConstants;
import com.admin.rr.dao.RrOrganizationConfDao;
import com.admin.rr.entity.RrOrganizationMaster;

/**
 * @author jogeswarsahu
 *
 */
@Repository
public class RrOrganizationConfDaoImpl implements RrOrganizationConfDao {

	private static final Logger logger = LogManager.getLogger(RrOrganizationConfDaoImpl.class.getName());

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public String saveOrUpdateOrganization(RrOrganizationMaster organizationMaster) {

		String status = RrConstants.FAILURE;

		try {
			sessionFactory.getCurrentSession().saveOrUpdate(organizationMaster);
			status = RrConstants.SUCCESS;
		} catch (Exception e) {
			logger.error("@@@ Exception in RrOrganizationConfDaoImpl at saveOrUpdateOrganization(): ", e);
		}

		return status;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RrOrganizationMaster> getAllOrganizations() {

		List<RrOrganizationMaster> organizationMasterList = null;

		try {
			organizationMasterList = sessionFactory.getCurrentSession()
					.createQuery("select om from RrOrganizationMaster om where om.deleteStatus=0").list();
		} catch (Exception e) {
			logger.error("@@@ Exception in RrOrganizationConfDaoImpl at getAllOrganizations(): ", e);
		}

		return organizationMasterList;
	}

	@Override
	public RrOrganizationMaster getOrganizationById(Long organizationId) {

		RrOrganizationMaster organizationMaster = null;

		try {
			organizationMaster = (RrOrganizationMaster) sessionFactory.getCurrentSession()
					.get(RrOrganizationMaster.class, organizationId);
		} catch (Exception e) {
			logger.error("@@@ Exception in RrOrganizationConfDaoImpl at getOrganizationById(): ", e);
		}
		return organizationMaster;
	}

}
