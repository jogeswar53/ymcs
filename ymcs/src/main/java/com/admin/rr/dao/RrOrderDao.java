package com.admin.rr.dao;

import com.admin.rr.entity.RrOrder;

/**
 * @author jogeswar
 *
 */
public interface RrOrderDao {

	public boolean saveOrUpdateOrder(RrOrder order);

	public RrOrder getOrderById(Long orderId);

}
