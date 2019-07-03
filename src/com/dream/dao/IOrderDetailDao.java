package com.dream.dao;

import java.util.List;

import com.dream.entity.OrderDetail;

public interface IOrderDetailDao {

	void addOrderDetail(OrderDetail od);

	List<OrderDetail> queryOrderDetail();

	List<OrderDetail> queryOrderXiang(int id);

}
