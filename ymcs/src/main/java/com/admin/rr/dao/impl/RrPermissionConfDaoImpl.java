package com.admin.rr.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.rr.constants.RrConstants;
import com.admin.rr.dao.RrPermissionConfDao;
import com.admin.rr.entity.RrPermissionMaster;

/**
 * @author jogeswarsahu
 *
 */
@Repository
public class RrPermissionConfDaoImpl implements RrPermissionConfDao {

	private static final Logger logger = LogManager.getLogger(RrPermissionConfDaoImpl.class.getName());

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<RrPermissionMaster> getAllPermissionList() {

		List<RrPermissionMaster> permissionMasterList = null;

		try {
			permissionMasterList = sessionFactory.getCurrentSession()
					.createQuery(
							"select pm from RrPermissionMaster pm where pm.status in ('Online', 'Offline') order by pm.rrUserRoleMaster.rrUserRoleMasterId")
					.list();
		} catch (Exception e) {
			logger.error("@@@ Exception in RrPermissionConfDaoImpl at getAllPermissionList(): ", e);
		}
		return permissionMasterList;
	}

	@Override
	public String saveOrUpdatePermission(RrPermissionMaster permissionMaster) {

		String status = RrConstants.FAILURE;

		try {
			sessionFactory.getCurrentSession().saveOrUpdate(permissionMaster);
			status = RrConstants.SUCCESS;
		} catch (Exception e) {
			logger.error("@@@ Exception in RrPermissionConfDaoImpl at saveOrUpdatePermission(): ", e);
		}

		return status;
	}

	@Override
	public RrPermissionMaster getPermissionById(Integer permissionId) {

		RrPermissionMaster permissionMaster = null;

		try {
			permissionMaster = (RrPermissionMaster) sessionFactory.getCurrentSession().get(RrPermissionMaster.class,
					permissionId);
		} catch (Exception e) {
			logger.error("@@@ Exception in RrPermissionConfDaoImpl at getPermissionById(): ", e);
		}

		return permissionMaster;
	}

	@Override
	public String deletePermissionById(Integer permissionId) {

		RrPermissionMaster permissionMaster = null;
		String status = RrConstants.FAILURE;

		try {
			Session session = sessionFactory.getCurrentSession();

			permissionMaster = getPermissionById(permissionId);

			if (null != permissionMaster) {
				permissionMaster.setStatus("Deleted");
				session.saveOrUpdate(permissionMaster);
				status = RrConstants.SUCCESS;
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrPermissionConfDaoImpl at deletePermissionById(): ", e);
		}

		return status;
	}

}
