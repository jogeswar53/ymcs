package com.admin.rr.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.admin.rr.beans.OrderBean;
import com.admin.rr.constants.RrConstants;
import com.admin.rr.dao.RrOrderDao;
import com.admin.rr.dao.RrUserProfileConfDao;
import com.admin.rr.entity.RrBrandMaster;
import com.admin.rr.entity.RrIssueMaster;
import com.admin.rr.entity.RrOrder;
import com.admin.rr.entity.RrUserProfile;
import com.admin.rr.service.RrOrderService;
import com.admin.rr.utils.RrCommonUtils;

/**
 * @author jogeswar
 *
 */
@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class RrOrderServiceImpl implements RrOrderService {

	private Logger logger = LogManager.getLogger(this.getClass().getName());

	@Autowired
	RrUserProfileConfDao userProfileConfDao;

	@Autowired
	RrOrderDao orderDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.admin.rr.service.RrOrderService#getOnlineUsersMap()
	 */
	@Override
	public Map<Long, String> getOnlineUsersMap() {

		List<RrUserProfile> userProfileList = null;
		Map<Long, String> userMap = new HashMap<>();

		try {
			userProfileList = userProfileConfDao.getAllUserProfiles();

			if ((null != userProfileList) && (!userProfileList.isEmpty())) {
				for (RrUserProfile userProfile : userProfileList) {
					if (RrConstants.ONLINE.equals(userProfile.getStatus())) {
						userMap.put(userProfile.getRrUserProfileId(), userProfile.getUserName());
					}
				}
			}
		} catch (Exception e) {
			logger.error("", e);
		}

		return userMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.admin.rr.service.RrOrderService#getBrandMap()
	 */
	@Override
	public Map<Long, String> getBrandMap() {

		Map<Long, String> brandMap = new HashMap<>();

		try {
			brandMap.put(1L, "Cannon");
		} catch (Exception e) {
			logger.error("", e);
		}

		return brandMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.admin.rr.service.RrOrderService#getIssueMap()
	 */
	@Override
	public Map<Long, String> getIssueMap() {

		Map<Long, String> issueMap = new HashMap<>();

		try {
			issueMap.put(1L, "Lense is not working");
		} catch (Exception e) {
			logger.error("", e);
		}

		return issueMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.admin.rr.service.RrOrderService#saveOrder(com.admin.rr.beans.
	 * OrderBean)
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public boolean saveOrder(OrderBean orderBean) {

		RrOrder order = null;
		boolean isSuccessYes = false;

		try {
			order = new RrOrder();
			isSuccessYes = setOrder(order, orderBean);
		} catch (Exception e) {
			logger.error("", e);
		}
		return isSuccessYes;
	}

	private boolean setOrder(RrOrder order, OrderBean orderBean) {

		RrBrandMaster brandMaster;
		RrUserProfile userProfile;
		RrIssueMaster issueMaster;

		boolean isSuccessYes = false;

		try {
			brandMaster = new RrBrandMaster();
			brandMaster.setRrBrandMasterId(orderBean.getBrandId());
			order.setRrBrandMaster(brandMaster);

			userProfile = new RrUserProfile();
			userProfile.setRrUserProfileId(orderBean.getUserProfileId());
			order.setRrUserProfile(userProfile);

			issueMaster = new RrIssueMaster();
			issueMaster.setRrIssueMasterId(orderBean.getIssueId());
			order.setRrIssueMaster(issueMaster);

			order.setOrderNo(String.valueOf(System.currentTimeMillis()));
			order.setFirstName(orderBean.getFirstName());
			order.setLastName(orderBean.getLastName());
			order.setMobileNo(orderBean.getMobileNo());
			order.setEmailId(orderBean.getEmailId());
			order.setAddress(orderBean.getAddress());
			order.setModel(orderBean.getModel());
			order.setDueTime(RrCommonUtils.getDateFromString(orderBean.getDueTime(), RrConstants.DATE_FORMAT.intern()));
			order.setAccessories(orderBean.getAccessories());
			order.setPaidAmount(orderBean.getPaidAmount());
			order.setIssueDescription(orderBean.getIssueDescription());
			order.setStatus(RrConstants.ONLINE);
			order.setCreatedBy(orderBean.getCreatedBy());

			orderBean.getAccessories();
			orderBean.getAddress();

			isSuccessYes = orderDao.saveOrUpdateOrder(order);

		} catch (Exception e) {
			logger.error("", e);
		}

		return isSuccessYes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.admin.rr.service.RrOrderService#updateOrder(java.lang.Long)
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	@Override
	public boolean updateOrder(OrderBean orderBean) {

		RrOrder order = null;
		boolean isSuccessYes = false;

		try {
			order = orderDao.getOrderById(orderBean.getOrderId());

			if (null != order) {
				isSuccessYes = setOrder(order, orderBean);
			}
		} catch (Exception e) {
			logger.error("", e);
		}

		return isSuccessYes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.admin.rr.service.RrOrderService#getOrder(java.lang.Long)
	 */
	@Override
	public OrderBean getOrder(Long orderId) {

		RrOrder order = null;
		OrderBean orderBean = new OrderBean();

		try {
			order = orderDao.getOrderById(orderId);

			if (null != order) {
				orderBean.setOrderId(order.getRrOrderId());
				orderBean.setAccessories(order.getAccessories());
				orderBean.setAddress(order.getAddress());
				orderBean.setCreatedBy(order.getCreatedBy());
				orderBean.setEmailId(order.getEmailId());
				orderBean.setFirstName(order.getFirstName());
				orderBean.setIssueId(order.getRrIssueMaster().getRrIssueMasterId());
				orderBean.setIssueName(order.getRrIssueMaster().getIssueName());
				orderBean.setIssueDescription(order.getIssueDescription());
				orderBean.setLastName(order.getLastName());
				orderBean.setMobileNo(order.getMobileNo());
				orderBean.setModel(order.getModel());
				orderBean.setOrderNo(order.getOrderNo());
				orderBean.setPaidAmount(order.getPaidAmount());
				orderBean.setBrandId(order.getRrBrandMaster().getRrBrandMasterId());
				orderBean.setBrandName(order.getRrBrandMaster().getBrandName());
				orderBean.setUserProfileId(order.getRrUserProfile().getRrUserProfileId());
				orderBean.setUserName(order.getRrUserProfile().getUserName());
				orderBean.setDueTime(
						RrCommonUtils.getFormattedDate(order.getDueTime(), RrConstants.DATE_FORMAT.intern()));
				orderBean.setCreatedTime(
						RrCommonUtils.getFormattedDate(order.getCreatedTime(), RrConstants.DATE_FORMAT.intern()));
			}
		} catch (Exception e) {
			logger.error("", e);
		}

		return orderBean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.admin.rr.service.RrOrderService#getAllOrders()
	 */
	@Override
	public List<OrderBean> getAllOrders() {

		List<OrderBean> orderBeans = new ArrayList<>();
		List<RrOrder> orders = null;

		OrderBean orderBean = null;

		try {
			orders = orderDao.getAllOrders();

			if (null != orders) {

				for (RrOrder order : orders) {
					orderBean = new OrderBean();

					orderBean.setOrderId(order.getRrOrderId());
					orderBean.setUserProfileId(order.getRrUserProfile().getRrUserProfileId());
					orderBean.setUserName(order.getRrUserProfile().getUserName());
					orderBean.setOrderNo(order.getOrderNo());
					orderBean.setFirstName(order.getFirstName());
					orderBean.setMiddleName(order.getMiddleName());
					orderBean.setLastName(order.getLastName());
					orderBean.setMobileNo(order.getMobileNo());
					orderBean.setEmailId(order.getEmailId());
					orderBean.setAddress(order.getAddress());
					orderBean.setBrandId(order.getRrBrandMaster().getRrBrandMasterId());
					orderBean.setBrandName(order.getRrBrandMaster().getBrandName());
					orderBean.setModel(order.getModel());
					orderBean.setDueTime(
							RrCommonUtils.getFormattedDate(order.getDueTime(), RrConstants.DATE_FORMAT.intern()));
					orderBean.setAccessories(order.getAccessories());
					orderBean.setPaidAmount(order.getPaidAmount());
					orderBean.setIssueId(order.getRrIssueMaster().getRrIssueMasterId());
					orderBean.setIssueName(order.getRrIssueMaster().getIssueName());
					orderBean.setIssueDescription(order.getIssueDescription());
					orderBean.setCreatedTime(
							RrCommonUtils.getFormattedDate(order.getCreatedTime(), RrConstants.DATE_FORMAT.intern()));
					orderBean.setCreatedBy(order.getCreatedBy());
					orderBean.setStatus(order.getStatus());

					orderBeans.add(orderBean);
				}
			}
		} catch (Exception e) {
			logger.error("", e);
		}

		return orderBeans;
	}

}
