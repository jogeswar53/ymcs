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

import com.admin.rr.beans.RrOrganizationBean;
import com.admin.rr.constants.RrConstants;
import com.admin.rr.dao.RrOrganizationConfDao;
import com.admin.rr.entity.RrCountryMaster;
import com.admin.rr.entity.RrOrganizationMaster;
import com.admin.rr.entity.RrStateMaster;
import com.admin.rr.service.RrOrganizationConfService;
import com.admin.rr.utils.RrCommonUtils;

/**
 * @author jogeswarsahu
 *
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class RrOrganizationConfServiceImpl implements RrOrganizationConfService {

	private static final Logger logger = LogManager.getLogger(RrOrganizationConfServiceImpl.class.getName());

	@Autowired
	RrOrganizationConfDao organizationConfDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String createOrganization(RrOrganizationBean organizationBean) {

		String status = RrConstants.FAILURE;

		RrOrganizationMaster organizationMaster = null;
		RrCountryMaster testCountryMaster = null;
		RrStateMaster testStateMaster = null;

		try {
			organizationMaster = new RrOrganizationMaster();
			testCountryMaster = new RrCountryMaster();
			testCountryMaster.setRrCountryMasterId(organizationBean.getCountryCode());
			organizationMaster.setRrCountryMaster(testCountryMaster);
			testStateMaster = new RrStateMaster();
			testStateMaster.setRrStateMasterId(organizationBean.getStateCode());
			organizationMaster.setRrStateMaster(testStateMaster);

			organizationMaster.setOrganizationCode(organizationBean.getOrganizationCode());
			organizationMaster.setOrganizationName(organizationBean.getOrganizationName());
			organizationMaster.setOrganizationAddr1(organizationBean.getOrganizationAddr1());
			organizationMaster.setOrganizationAddr2(organizationBean.getOrganizationAddr2());
			organizationMaster.setOrganizationAddr3(organizationBean.getOrganizationAddr3());
			organizationMaster.setDistrict(organizationBean.getDistrict());
			organizationMaster.setPincode(organizationBean.getPincode());
			organizationMaster.setStatus(organizationBean.getStatus());

			organizationMaster.setCreatedTime(new Date());
			organizationMaster.setCreatedBy(1L);

			organizationConfDao.saveOrUpdateOrganization(organizationMaster);
		} catch (Exception e) {
			logger.error("@@@ Exception in RrOrganizationConfServiceImpl at createOrganization(): ", e);
		}

		return status;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String updateOrganization(RrOrganizationBean organizationBean) {

		String status = RrConstants.FAILURE;

		RrOrganizationMaster organizationMaster = null;
		RrCountryMaster testCountryMaster = null;
		RrStateMaster testStateMaster = null;

		try {
			organizationMaster = organizationConfDao.getOrganizationById(organizationBean.getOrganizationId());

			if (null != organizationMaster) {
				testCountryMaster = new RrCountryMaster();
				testCountryMaster.setRrCountryMasterId(organizationBean.getCountryCode());
				organizationMaster.setRrCountryMaster(testCountryMaster);
				testStateMaster = new RrStateMaster();
				testStateMaster.setRrStateMasterId(organizationBean.getStateCode());
				organizationMaster.setRrStateMaster(testStateMaster);

				organizationMaster.setOrganizationCode(organizationBean.getOrganizationCode());
				organizationMaster.setOrganizationName(organizationBean.getOrganizationName());
				organizationMaster.setOrganizationAddr1(organizationBean.getOrganizationAddr1());
				organizationMaster.setOrganizationAddr2(organizationBean.getOrganizationAddr2());
				organizationMaster.setOrganizationAddr3(organizationBean.getOrganizationAddr3());
				organizationMaster.setDistrict(organizationBean.getDistrict());
				organizationMaster.setPincode(organizationBean.getPincode());
				organizationMaster.setStatus(organizationBean.getStatus());

				organizationMaster.setModifiedTime(new Date());
				organizationMaster.setModifiedBy(1L);

				status = organizationConfDao.saveOrUpdateOrganization(organizationMaster);
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrOrganizationConfServiceImpl at createOrganization(): ", e);
		}

		return status;
	}

	@Override
	public List<RrOrganizationBean> getAllOrganizations() {

		List<RrOrganizationBean> organizationBeanList = new ArrayList<>();
		List<RrOrganizationMaster> organizationMasterList = null;

		RrOrganizationBean organizationBean = null;

		try {
			organizationMasterList = organizationConfDao.getAllOrganizations();

			if ((null != organizationMasterList) && (!organizationMasterList.isEmpty())) {
				for (RrOrganizationMaster organization : organizationMasterList) {
					organizationBean = new RrOrganizationBean();
					organizationBean.setOrganizationId(organization.getRrOrganizationMasterId());
					organizationBean.setCountryName(organization.getRrCountryMaster().getCountryName());
					organizationBean.setStateName(organization.getRrStateMaster().getStateName());
					organizationBean.setOrganizationCode(organization.getOrganizationCode());
					organizationBean.setOrganizationName(organization.getOrganizationName());
					organizationBean.setOrganizationAddr1(organization.getOrganizationAddr1());
					organizationBean.setOrganizationAddr2(organization.getOrganizationAddr2());
					organizationBean.setOrganizationAddr3(organization.getOrganizationAddr3());
					organizationBean.setDistrict(organization.getDistrict());
					organizationBean.setPincode(organization.getPincode());

					organizationBean.setStatus(organization.getStatus());
					organizationBean.setStatusClass(RrCommonUtils.setStatusClass(organization.getStatus()));

					organizationBeanList.add(organizationBean);
				}
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrOrganizationConfServiceImpl at getAllOrganizations(): ", e);
		}

		return organizationBeanList;
	}

	@Override
	public RrOrganizationBean getOrganizationById(Long organizationId) {

		RrOrganizationBean organizationBean = new RrOrganizationBean();
		RrOrganizationMaster organizationMaster = null;

		try {
			organizationMaster = organizationConfDao.getOrganizationById(organizationId);

			if (null != organizationMaster) {
				organizationBean.setOrganizationId(organizationMaster.getRrOrganizationMasterId());
				organizationBean.setCountryCode(organizationMaster.getRrCountryMaster().getRrCountryMasterId());
				organizationBean.setStateCode(organizationMaster.getRrStateMaster().getRrStateMasterId());
				organizationBean.setOrganizationCode(organizationMaster.getOrganizationCode());
				organizationBean.setOrganizationName(organizationMaster.getOrganizationName());
				organizationBean.setOrganizationAddr1(organizationMaster.getOrganizationAddr1());
				organizationBean.setOrganizationAddr2(organizationMaster.getOrganizationAddr2());
				organizationBean.setOrganizationAddr3(organizationMaster.getOrganizationAddr3());
				organizationBean.setDistrict(organizationMaster.getDistrict());
				organizationBean.setPincode(organizationMaster.getPincode());
				organizationBean.setStatus(organizationMaster.getStatus());
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrOrganizationConfServiceImpl at getOrganizationById(): ", e);
		}

		return organizationBean;
	}

}
