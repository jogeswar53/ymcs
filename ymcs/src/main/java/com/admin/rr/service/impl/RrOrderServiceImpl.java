package com.admin.rr.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.rr.beans.OrderBean;
import com.admin.rr.constants.RrConstants;
import com.admin.rr.dao.RrOrderDao;
import com.admin.rr.dao.RrUserProfileConfDao;
import com.admin.rr.entity.RrBrandMaster;
import com.admin.rr.entity.RrOrder;
import com.admin.rr.entity.RrUserProfile;
import com.admin.rr.service.RrOrderService;
import com.admin.rr.utils.RrCommonUtils;

/**
 * @author jogeswar
 *
 */
@Service
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
	 * @see com.admin.rr.service.RrOrderService#saveOrder(com.admin.rr.beans.
	 * OrderBean)
	 */
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

		boolean isSuccessYes = false;

		try {
			brandMaster = new RrBrandMaster();
			brandMaster.setRrBrandMasterId(orderBean.getBrandId());
			order.setRrBrandMaster(brandMaster);

			userProfile = new RrUserProfile();
			userProfile.setRrUserProfileId(orderBean.getUserProfileId());
			order.setRrUserProfile(userProfile);

			order.setOrderNo(String.valueOf(System.currentTimeMillis()));
			order.setFirstName(orderBean.getFirstName());
			order.setLastName(orderBean.getLastName());
			order.setMobileNo(orderBean.getMobileNo());
			order.setEmailId(orderBean.getEmailId());
			order.setAddress(orderBean.getAddress());
			order.setModel(orderBean.getModel());
			order.setDueTime(RrCommonUtils.getDateFromString(orderBean.getDueTime(), null));
			order.setAccessories(orderBean.getAccessories());
			order.setPaidAmount(orderBean.getPaidAmount());
			order.setIssue(orderBean.getIssue());
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
	@Override
	public boolean updateOrder(OrderBean orderBean) {

		RrOrder order = null;
		boolean isSuccessYes = false;

		try {
			order = orderDao.getOrderById(orderBean.getOrderId());

			if (null != order) {
				setOrder(order, orderBean);
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
				orderBean.setAccessories(order.getAccessories());
				orderBean.setAddress(order.getAddress());
				orderBean.setCreatedBy(order.getCreatedBy());
				// orderBean.setCreatedTime(order.getCreatedTime());
				// orderBean.setDueTime(order.getDueTime());
				orderBean.setEmailId(order.getEmailId());
				orderBean.setFirstName(order.getFirstName());
				orderBean.setIssue(order.getIssue());
				orderBean.setIssueDescription(order.getIssueDescription());
				orderBean.setLastName(order.getLastName());
				orderBean.setMobileNo(order.getMobileNo());
				orderBean.setModel(order.getModel());
				orderBean.setOrderNo(order.getOrderNo());
				orderBean.setPaidAmount(order.getPaidAmount());
				orderBean.setBrandId(order.getRrBrandMaster().getRrBrandMasterId());
				orderBean.setUserProfileId(order.getRrUserProfile().getRrUserProfileId());
			}
		} catch (Exception e) {
			logger.error("", e);
		}

		return orderBean;
	}

}
