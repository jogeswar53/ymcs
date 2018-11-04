package com.admin.rr.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.rr.constants.RrConstants;
import com.admin.rr.dao.RrUserRoleConfDao;
import com.admin.rr.entity.RrUserRoleMaster;

/**
 * @author jogeswarsahu
 *
 */
@Repository
public class RrUserRoleConfDaoImpl implements RrUserRoleConfDao {

	private static final Logger logger = LogManager.getLogger(RrUserRoleConfDaoImpl.class.getName());

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<RrUserRoleMaster> getAllUserRoleList() {

		List<RrUserRoleMaster> userRoleMasterList = null;

		try {
			userRoleMasterList = sessionFactory.getCurrentSession()
					.createQuery("select rm from RrUserRoleMaster rm where rm.deleteStatus=0").list();
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserRoleConfDaoImpl at getAllUserRoleList(): ", e);
		}
		return userRoleMasterList;
	}

	@Override
	public String saveOrUpdateUserRole(RrUserRoleMaster userRoleMaster) {

		String status = RrConstants.FAILURE;

		try {
			sessionFactory.getCurrentSession().saveOrUpdate(userRoleMaster);
			status = RrConstants.SUCCESS;
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserRoleConfDaoImpl at saveOrUpdateUserRole(): ", e);
		}

		return status;
	}

	@Override
	public RrUserRoleMaster getUserRoleById(Long userRoleId) {

		RrUserRoleMaster userRoleMaster = null;

		try {
			userRoleMaster = (RrUserRoleMaster) sessionFactory.getCurrentSession()
					.get(RrUserRoleMaster.class, userRoleId);
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserRoleConfDaoImpl at getUserRoleById(): ", e);
		}

		return userRoleMaster;
	}

	@Override
	public String deleteUserRoleById(Long userRoleId) {

		RrUserRoleMaster userRoleMaster = null;
		String status = RrConstants.FAILURE;

		try {
			Session session = sessionFactory.getCurrentSession();

			userRoleMaster = getUserRoleById(userRoleId);

			if (null != userRoleMaster) {
				userRoleMaster.setStatus("Deleted");
				session.saveOrUpdate(userRoleMaster);
				status = RrConstants.SUCCESS;
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrUserRoleConfDaoImpl at deleteUserRoleById(): ", e);
		}

		return status;
	}

}
