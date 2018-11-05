package com.admin.rr.dao.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.admin.rr.constants.RrConstants;
import com.admin.rr.dao.RrCountryConfDao;
import com.admin.rr.entity.RrCountryMaster;

/**
 * @author jogeswarsahu
 *
 */
@Repository
public class RrCountryConfDaoImpl implements RrCountryConfDao {

	private static final Logger logger = LogManager.getLogger(RrCountryConfDaoImpl.class.getName());

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<RrCountryMaster> getAllCountryList() {

		List<RrCountryMaster> countryList = null;

		try {
			countryList = sessionFactory.getCurrentSession()
					.createQuery("select cm from RrCountryMaster cm where cm.status in ('Online', 'Offline')").list();
		} catch (Exception e) {
			logger.error("@@@ Exception in RrCountryConfDaoImpl at getAllCountryList(): ", e);
		}

		return countryList;
	}

	@Override
	public String createUpdateCountry(RrCountryMaster countryMaster) {

		String status = RrConstants.FAILURE;

		try {
			sessionFactory.getCurrentSession().saveOrUpdate(countryMaster);
			status = RrConstants.SUCCESS;
		} catch (Exception e) {
			logger.error("@@@ Exception in RrCountryConfDaoImpl at createUpdateCountry(): ", e);
		}

		return status;
	}

	@Override
	public RrCountryMaster getCountryById(Long countryId) {

		RrCountryMaster testCountryMaster = null;

		try {
			testCountryMaster = (RrCountryMaster) sessionFactory.getCurrentSession().get(RrCountryMaster.class,
					countryId);
		} catch (Exception e) {
			logger.error("@@@ Exception in RrCountryConfDaoImpl at getCountryById(): ", e);
		}

		return testCountryMaster;
	}

	@Override
	public String deleteCountryById(Long countryId) {

		RrCountryMaster countryMaster = null;
		String status = RrConstants.FAILURE;

		try {
			Session session = sessionFactory.getCurrentSession();

			countryMaster = getCountryById(countryId);

			if (null != countryMaster) {
				countryMaster.setStatus("Deleted");
				session.saveOrUpdate(countryMaster);
				status = RrConstants.SUCCESS;
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrCountryConfDaoImpl at deleteCountryById(): ", e);
		}

		return status;
	}

}
