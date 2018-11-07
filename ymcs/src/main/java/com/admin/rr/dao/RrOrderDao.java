package com.admin.rr.dao;

import java.util.List;

import com.admin.rr.entity.RrOrder;

/**
 * @author jogeswar
 *
 */
public interface RrOrderDao {

	public boolean saveOrUpdateOrder(RrOrder order);

	public RrOrder getOrderById(Long orderId);

	public RrOrder getOrderByNo(String orderNo);

	public List<RrOrder> getAllOrders();

}
