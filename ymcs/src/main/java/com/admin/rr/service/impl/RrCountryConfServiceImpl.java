package com.admin.rr.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.admin.rr.beans.RrCountryBean;
import com.admin.rr.constants.RrConstants;
import com.admin.rr.dao.RrCountryConfDao;
import com.admin.rr.entity.RrCountryMaster;
import com.admin.rr.service.RrCountryConfService;
import com.admin.rr.utils.RrCommonUtils;

/**
 * @author jogeswarsahu
 *
 */
@Service
public class RrCountryConfServiceImpl implements RrCountryConfService {

	private static final Logger logger = LogManager.getLogger(RrCountryConfServiceImpl.class.getName());

	@Autowired
	RrCountryConfDao countryConfDao;

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public List<RrCountryBean> getAllCountryList() {

		List<RrCountryBean> countryList = new ArrayList<>();
		List<RrCountryMaster> countryMasterList = null;

		RrCountryBean countryBean;

		try {
			countryMasterList = countryConfDao.getAllCountryList();

			if ((null != countryMasterList) && (!countryMasterList.isEmpty())) {
				for (RrCountryMaster country : countryMasterList) {
					countryBean = new RrCountryBean();
					countryBean.setCountryId(country.getRrCountryMasterId());
					countryBean.setCountryCode(country.getCountryCode());
					countryBean.setCountryName(country.getCountryName());
					countryBean.setCurrencyCode(country.getCurrencyCode());
					countryBean.setCurrencyName(country.getCurrencyName());
					countryBean.setIsdCode(country.getIsdCode());

					countryBean.setStatus(country.getStatus());
					countryBean.setStatusClass(RrCommonUtils.setStatusClass(country.getStatus()));

					countryList.add(countryBean);
				}
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrCountryConfServiceImpl at getAllCountryList(): ", e);
		}

		return countryList;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String createCountry(RrCountryBean countryBean) {

		String status = RrConstants.FAILURE;

		RrCountryMaster countryMaster = null;

		try {
			countryMaster = new RrCountryMaster();

			countryMaster.setCreatedTime(new Date());
			countryMaster.setCreatedBy(1L);

			countryMaster.setStatus(countryBean.getStatus());
			countryMaster.setCountryCode(countryBean.getCountryCode());
			countryMaster.setCountryName(countryBean.getCountryName());
			countryMaster.setCurrencyCode(countryBean.getCurrencyCode());
			countryMaster.setCurrencyName(countryBean.getCurrencyName());
			countryMaster.setIsdCode(countryBean.getIsdCode());

			status = countryConfDao.createUpdateCountry(countryMaster);
		} catch (Exception e) {
			logger.error("@@@ Exception in RrCountryConfServiceImpl at createCountry(): ", e);
		}

		return status;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String updateCountry(RrCountryBean countryBean) {

		String status = RrConstants.FAILURE;

		RrCountryMaster countryMaster = null;

		try {
			countryMaster = countryConfDao.getCountryById(countryBean.getCountryId());

			if (null != countryMaster) {
				countryMaster.setModifiedTime(new Date());
				countryMaster.setModifiedBy(1L);

				countryMaster.setStatus(countryBean.getStatus());
				countryMaster.setCountryCode(countryBean.getCountryCode());
				countryMaster.setCountryName(countryBean.getCountryName());
				countryMaster.setCurrencyCode(countryBean.getCurrencyCode());
				countryMaster.setCurrencyName(countryBean.getCurrencyName());
				countryMaster.setIsdCode(countryBean.getIsdCode());

				status = countryConfDao.createUpdateCountry(countryMaster);
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrCountryConfServiceImpl at updateCountry(): ", e);
		}

		return status;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String deleteCountryById(Long countryId) {

		String status = RrConstants.FAILURE;

		try {
			status = countryConfDao.deleteCountryById(countryId);
		} catch (Exception e) {
			logger.error("@@@ Exception in RrCountryConfServiceImpl at deleteCountryById(): ", e);
		}

		return status;
	}

}
