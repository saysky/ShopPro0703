package com.deram.service;

import java.util.List;

import com.dream.entity.OrderDetail;

public interface IOrderDetailService {

	void addOrderDetail(OrderDetail od);

	List<OrderDetail> queryOrderDetail();

	List<OrderDetail> queryOrderXiang(int id);

}
