package com.admin.rr.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.admin.rr.constants.RrConstants;
import com.admin.rr.dao.RrMenuConfDao;
import com.admin.rr.entity.RrMenus;

/**
 * @author jogeswarsahu
 *
 */
@Repository
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
public class RrMenuConfDaoImpl implements RrMenuConfDao {

	private static final Logger logger = LogManager.getLogger(RrMenuConfDaoImpl.class.getName());

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<RrMenus> getAllMenus() {

		List<RrMenus> menuList = null;

		try {
			StringBuilder queryBuilder = new StringBuilder("select tm from RrMenus tm")
					.append(" where tm.deleteStatus=0 order by tm.menuLevel");
			Query query = sessionFactory.getCurrentSession().createQuery(queryBuilder.toString());
			menuList = query.list();
		} catch (Exception e) {
			logger.error("@@@ Exception in RrMenuConfDaoImpl at getAllMenus(): ", e);
		}

		return menuList;
	}

	@Override
	public Long getMenuCount(String queryString, String condition) {

		String result = "0".intern();

		try {
			Query query = sessionFactory.getCurrentSession().createQuery(queryString);

			if (condition.length() > 0) {
				query.setParameter("condition", condition);
			}
			result = (String) query.uniqueResult();

			if (result == null) {
				result = "0".intern();
			}
		} catch (Exception e) {
			logger.error("@@@@ Exception in RrMenuConfDaoImpl at getMenuCount :", e);
		}

		return Long.parseLong(result);
	}

	@Override
	public String saveOrUpdateMenu(RrMenus testMenu) {

		String status = RrConstants.FAILURE;

		try {
			sessionFactory.getCurrentSession().saveOrUpdate(testMenu);
			status = RrConstants.SUCCESS;
		} catch (Exception e) {
			logger.error("@@@ Exception in RrMenuConfDaoImpl at saveOrUpdateMenu(): ", e);
		}

		return status;
	}

	@Override
	public String deleteMenuById(Integer menuId) {

		RrMenus testMenu = null;
		String status = RrConstants.FAILURE;

		try {
			Session session = sessionFactory.getCurrentSession();

			testMenu = (RrMenus) session.get(RrMenus.class, menuId);

			if (null != testMenu) {
				testMenu.setDeleteStatus(true);
				session.saveOrUpdate(testMenu);
				status = RrConstants.SUCCESS;
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrMenuConfDaoImpl at deleteMenuById(): ", e);
		}

		return status;
	}

	@Override
	public RrMenus getMenuById(Integer menuId) {

		RrMenus testMenu = null;

		try {
			Session session = sessionFactory.getCurrentSession();
			testMenu = (RrMenus) session.get(RrMenus.class, menuId);
		} catch (Exception e) {
			logger.error("@@@ Exception in RrMenuConfDaoImpl at getMenuById(): ", e);
		}

		return testMenu;
	}

}
