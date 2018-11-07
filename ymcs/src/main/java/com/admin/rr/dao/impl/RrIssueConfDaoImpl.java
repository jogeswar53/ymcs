package com.admin.rr.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.admin.rr.dao.RrIssueConfDao;
import com.admin.rr.entity.RrIssueMaster;

/**
 * 
 * @author jogeswar
 *
 */
@Repository
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class RrIssueConfDaoImpl implements RrIssueConfDao {

	private Logger logger = LogManager.getLogger(this.getClass().getName());

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<RrIssueMaster> getOnlineIssues() {

		List<RrIssueMaster> issueMasters = new ArrayList<>();

		try {
			issueMasters = sessionFactory.getCurrentSession().createQuery("from RrIssueMaster where status='Online'")
					.list();
		} catch (Exception e) {
			logger.error("", e);
		}
		return issueMasters;
	}

}
