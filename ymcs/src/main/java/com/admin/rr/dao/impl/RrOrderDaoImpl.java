package com.admin.rr.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.rr.dao.RrOrderDao;
import com.admin.rr.entity.RrOrder;

/**
 * @author jogeswar
 *
 */
@Repository
public class RrOrderDaoImpl implements RrOrderDao {

	private Logger logger = LogManager.getLogger(this.getClass().getName());

	@Autowired
	SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.admin.rr.dao.RrOrderDao#saveOrUpdateOrder()
	 */
	@Override
	public boolean saveOrUpdateOrder(RrOrder order) {

		boolean isSuccessYes = false;

		try {
			sessionFactory.getCurrentSession().saveOrUpdate(order);
			isSuccessYes = true;
		} catch (Exception e) {
			logger.error("", e);
		}

		return isSuccessYes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.admin.rr.dao.RrOrderDao#getOrderById(java.lang.Long)
	 */
	@Override
	public RrOrder getOrderById(Long orderId) {

		RrOrder order = null;

		try {
			order = (RrOrder) sessionFactory.getCurrentSession().get(RrOrder.class, orderId);
		} catch (Exception e) {
			logger.error("", e);
		}

		return order;
	}

}
