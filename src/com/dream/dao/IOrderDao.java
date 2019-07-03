package com.dream.dao;

import java.util.List;

import com.dream.entity.Order;

public interface IOrderDao {

	void addOrder(Order order);

	List<Order> queryOrder();

}
