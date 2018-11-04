package com.admin.rr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.admin.rr.beans.RrStateBean;
import com.admin.rr.constants.RrConstants;
import com.admin.rr.dao.RrStateConfDao;
import com.admin.rr.entity.RrCountryMaster;
import com.admin.rr.entity.RrStateMaster;
import com.admin.rr.service.RrStateConfService;
import com.admin.rr.utils.RrCommonUtils;

/**
 * @author jogeswarsahu
 *
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class RrStateConfServiceImpl implements RrStateConfService {

	private static final Logger logger = LogManager.getLogger(RrStateConfServiceImpl.class.getName());

	@Autowired
	RrStateConfDao stateConfDao;

	@Override
	public List<RrStateBean> getAllStateList() {

		List<RrStateBean> stateBeanList = new ArrayList<>();
		List<RrStateMaster> stateMasterList = null;

		RrStateBean stateBean;

		try {
			stateMasterList = stateConfDao.getAllStateList();

			if ((null != stateMasterList) && (!stateMasterList.isEmpty())) {
				for (RrStateMaster stateMaster : stateMasterList) {
					stateBean = new RrStateBean();
					stateBean.setStateId(stateMaster.getRrStateMasterId());
					stateBean.setCountryName(stateMaster.getRrCountryMaster().getCountryName());
					stateBean.setStateCode(stateMaster.getStateCode());
					stateBean.setStateName(stateMaster.getStateName());

					stateBean.setStatus(stateMaster.getStatus());
					stateBean.setStatusClass(RrCommonUtils.setStatusClass(stateMaster.getStatus()));

					stateBeanList.add(stateBean);
				}
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrStateConfServiceImpl at getAllStateList(): ", e);
		}

		return stateBeanList;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String createState(RrStateBean stateBean) {

		String status = RrConstants.FAILURE;
		RrStateMaster stateMaster = null;

		try {
			stateMaster = new RrStateMaster();
			stateMaster.setStatus(stateBean.getStatus());

			stateMaster.setStateCode(stateBean.getStateCode());
			stateMaster.setStateName(stateBean.getStateName());
			RrCountryMaster countryMaster = new RrCountryMaster();
			countryMaster.setRrCountryMasterId(stateBean.getCountryCode());
			stateMaster.setRrCountryMaster(countryMaster);

			status = stateConfDao.saveOrUpdateState(stateMaster);
		} catch (Exception e) {
			logger.error("@@@ Exception in RrStateConfServiceImpl at createState(): ", e);
		}

		return status;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String updateState(RrStateBean stateBean) {

		String status = RrConstants.FAILURE;
		RrStateMaster stateMaster = null;

		try {
			stateMaster = stateConfDao.getStateById(stateBean.getStateId());

			if (null != stateMaster) {
				stateMaster.setStatus(stateBean.getStatus());
				stateMaster.setModifiedBy(1L);

				stateMaster.setStateCode(stateBean.getStateCode());
				stateMaster.setStateName(stateBean.getStateName());
				RrCountryMaster countryMaster = new RrCountryMaster();
				countryMaster.setRrCountryMasterId(stateBean.getCountryCode());
				stateMaster.setRrCountryMaster(countryMaster);

				status = stateConfDao.saveOrUpdateState(stateMaster);
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrStateConfServiceImpl at updateState(): ", e);
		}

		return status;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public String deleteStateById(Long stateId) {

		String status = RrConstants.FAILURE;

		try {
			status = stateConfDao.deleteStateById(stateId);
		} catch (Exception e) {
			logger.error("@@@ Exception in RrStateConfServiceImpl at deleteStateById(): ", e);
		}

		return status;
	}

	@Override
	public RrStateBean getStateById(Long stateId) {

		RrStateMaster stateMaster = null;
		RrStateBean stateBean = new RrStateBean();

		try {
			stateMaster = stateConfDao.getStateById(stateId);

			if (null != stateMaster) {
				stateBean.setCountryCode(stateMaster.getRrCountryMaster().getRrCountryMasterId());
				stateBean.setStateCode(stateMaster.getStateCode());
				stateBean.setStateName(stateMaster.getStateName());
				stateBean.setStatus(stateMaster.getStatus());
			}
		} catch (Exception e) {
			logger.error("@@@ Exception in RrStateConfServiceImpl at getStateById(): ", e);
		}

		return stateBean;
	}

}
