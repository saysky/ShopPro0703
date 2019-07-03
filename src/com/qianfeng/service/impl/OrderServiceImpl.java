package com.qianfeng.service.impl;

import com.qianfeng.dao.IOrderDao;
import com.qianfeng.dao.impl.OrderDaoImpl;
import com.qianfeng.entity.Order;
import com.qianfeng.service.IOrderService;

public class OrderServiceImpl implements IOrderService {
	
	private IOrderDao orderDao = new OrderDaoImpl();

	@Override
	public void addOrder(Order order) {
		orderDao.addOrder(order);
	}

}
