package com.deram.service.impl;

import java.util.List;

import com.deram.service.IOrderService;
import com.dream.dao.IOrderDao;
import com.dream.dao.impl.OrderDaoimpl;
import com.dream.entity.Order;

public class OrderServiceimpl implements IOrderService {

	private IOrderDao ioDao = new OrderDaoimpl();
	@Override
	public void addOrder(Order order) {
		ioDao.addOrder(order);
		
	}
	@Override
	public List<Order> queryOrder() {
		// TODO Auto-generated method stub
		return ioDao.queryOrder();
	}

}
