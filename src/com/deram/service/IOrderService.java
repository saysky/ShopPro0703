package com.deram.service;

import java.util.List;

import com.dream.entity.Order;

public interface IOrderService {

	void addOrder(Order order);

	List<Order> queryOrder();

}
