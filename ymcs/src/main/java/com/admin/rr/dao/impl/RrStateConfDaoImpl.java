package com.admin.rr.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.rr.constants.RrConstants;
import com.admin.rr.dao.RrStateConfDao;
import com.admin.rr.entity.RrStateMaster;

/**
 * @author jogeswarsahu
 *
 */
@Repository
public class RrStateConfDaoImpl implements RrStateConfDao {

	private static final Logger logger = LogManager.getLogger(RrStateConfDaoImpl.class.getName());

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<RrStateMaster> getAllStateList() {

		List<RrStateMaster> stateMasterList = null;

		try {
			stateMasterList = sessionFactory.getCurrentSession()
					.createQuery("select sm from RrStateMaster sm where sm.status in ('Online', 'Offline')").list();
		} catch (Exception e) {
			logger.error("@@@ Exception in RrStateConfDaoImpl at getAllStateList(): ", e);
		}
		return stateMasterList;
	}

	@Override
	public String saveOrUpdateState(RrStateMaster stateMaster) {

		String status = RrConstants.FAILURE;

		try {
			sessionFactory.getCurrentSession().saveOrUpdate(stateMaster);
			status = RrConstants.SUCCESS;
		} catch (Exception e) {
			logger.error("@@@ Exception in RrStateConfDaoImpl at saveOrUpdateState(): ", e);
		}

		return status;
	}

	@Override
	public RrStateMaster getStateById(Long stateId) {

		RrStateMaster stateMaster = null;

		try {
			stateMaster = (RrStateMaster) sessionFactory.getCurrentSession().get(RrStateMaster.class, stateId);
		} catch (Exception e) {
			logger.error("@@@ Exception in RrStateConfDaoImpl at getStateById(): ", e);
		}

		return stateMaster;
	}

	@Override
	public String deleteStateById(Long stateId) {

		RrStateMaster stateMaster = null;
		String status = RrConstants.FAILURE;

		try {
			Session session = sessionFactory.getCurrentSession();

			stateMaster = getStateById(stateId);

			if (null != stateMaster) {
				stateMaster.setStatus("Deleted");
				session.saveOrUpdate(stateMaster);
				status = RrConstants.SUCCESS;
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrStateConfDaoImpl at deleteStateById(): ", e);
		}

		return status;
	}

}
