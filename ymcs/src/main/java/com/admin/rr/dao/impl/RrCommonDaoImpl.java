package com.admin.rr.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.admin.rr.dao.RrCommonDao;
import com.admin.rr.entity.RrMenus;

/**
 * @author jogeswarsahu
 *
 */
@Repository
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class RrCommonDaoImpl implements RrCommonDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.admin.test.dao.RrCommonDao#getMenuList()
	 */
	public static final Logger logger = LogManager.getLogger(RrCommonDaoImpl.class.getName());

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<RrMenus> getMenuListByUserRole(Long userRoleId) {

		List<RrMenus> menuList = new ArrayList<>();
		StringBuilder queryBuffer = new StringBuilder("select pm.rrMenus from RrPermissionMaster pm")
				.append(" where pm.status='Online' and pm.rrMenus.activeStatus=1")
				.append(" and pm.rrMenus.deleteStatus=0 and pm.rrUserRoleMaster.rrUserRoleMasterId=:userRoleId")
				.append(" order by pm.rrMenus.menuLevel");
		// StringBuilder queryBuffer = new StringBuilder("select pm from RrMenus
		// pm where pm.activeStatus=1 and pm.deleteStatus=0")
		// .append(" order by pm.menuLevel");

		try {
			// Query query =
			// sessionFactory.getCurrentSession().createQuery(queryBuffer.toString());
			Query query = sessionFactory.getCurrentSession().createQuery(queryBuffer.toString())
					.setParameter("userRoleId", userRoleId);
			menuList = query.list();
		} catch (Exception e) {
			logger.error("@@@ Exception in RrCommonDaoImpl at getMenuList(): ", e);
		}

		return menuList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RrMenus> getMenuListByUserRole() {

		List<RrMenus> menuList = new ArrayList<>();

		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					"select tm from RrMenus tm where tm.activeStatus=1 and tm.deleteStatus=0 order by tm.menuLevel");
			menuList = query.list();
		} catch (Exception e) {
			logger.error("@@@ Exception in RrCommonDaoImpl at getMenuList(): ", e);
		}

		return menuList;
	}

}
