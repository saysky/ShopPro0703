package com.qianfeng.service.impl;

import com.qianfeng.dao.IOrderDetailDao;
import com.qianfeng.dao.impl.OrderDetailDaoImpl;
import com.qianfeng.entity.OrderDetail;
import com.qianfeng.service.IOrderDetailService;

public class OrderDetailServiceImpl implements IOrderDetailService {
	
	private IOrderDetailDao odDao = new OrderDetailDaoImpl();

	@Override
	public void addOrderDetail(OrderDetail od) {
		odDao.addOrderDetail(od);
	}

}
