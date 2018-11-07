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

import com.admin.rr.dao.RrBrandConfDao;
import com.admin.rr.entity.RrBrandMaster;

/**
 * 
 * @author jogeswar
 *
 */
@Repository
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class RrBrandConfDaoImpl implements RrBrandConfDao {

	private Logger logger = LogManager.getLogger(this.getClass().getName());

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<RrBrandMaster> getOnlineBrands() {

		List<RrBrandMaster> brandMasters = new ArrayList<>();

		try {
			brandMasters = sessionFactory.getCurrentSession().createQuery("from RrBrandMaster where status='Online'")
					.list();
		} catch (Exception e) {
			logger.error("", e);
		}
		return brandMasters;
	}

}
