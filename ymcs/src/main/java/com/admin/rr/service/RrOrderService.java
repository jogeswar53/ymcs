package com.admin.rr.service;

import java.util.List;
import java.util.Map;

import com.admin.rr.beans.OrderBean;

/**
 * @author jogeswar
 *
 */
public interface RrOrderService {

	public Map<Long, String> getOnlineUsersMap();

	public Map<Long, String> getBrandMap();

	public Map<Long, String> getIssueMap();

	public boolean saveOrder(OrderBean orderBean);

	public boolean updateOrder(OrderBean orderBean);

	public OrderBean getOrder(Long orderId);

	public List<OrderBean> getAllOrders();

}
