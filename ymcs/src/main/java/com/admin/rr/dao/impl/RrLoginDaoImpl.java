package com.admin.rr.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.rr.constants.RrHBQueries;
import com.admin.rr.dao.RrLoginDao;
import com.admin.rr.entity.RrUserProfile;

/**
 * @author jogeswar
 *
 */
@Repository
public class RrLoginDaoImpl implements RrLoginDao {

	private Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public RrUserProfile getUserByUserName(String userName, String uPassword) {

		RrUserProfile userProfileDetails = null;

		try {
			Query query = sessionFactory.getCurrentSession().createQuery(RrHBQueries.AF_GET_ACTIVE_USER_BY_EMAIL);
			query.setParameter("userName", userName);
			query.setParameter("uPassword", uPassword);
			query.setMaxResults(1);
			userProfileDetails = (RrUserProfile) query.uniqueResult();
		} catch (Exception e) {
			logger.error("@@@@ Exception in RrUserManagementDaoImpl at getUserByUserName() :", e);
		}

		return userProfileDetails;
	}

}
