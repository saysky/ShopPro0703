package com.deram.service.impl;

import java.util.List;

import com.deram.service.IOrderDetailService;
import com.dream.dao.IOrderDetailDao;
import com.dream.dao.impl.OrderDetailDaoimpl;
import com.dream.entity.OrderDetail;

public class OrderDetailServiceimpl implements IOrderDetailService {
	private IOrderDetailDao iodDao = new OrderDetailDaoimpl();
	@Override
	public void addOrderDetail(OrderDetail od) {
		iodDao.addOrderDetail(od);
		
	}
	@Override
	public List<OrderDetail> queryOrderDetail() {
		// TODO Auto-generated method stub
		return iodDao.queryOrderDetail();
	}
	@Override
	public List<OrderDetail> queryOrderXiang(int id) {
		// TODO Auto-generated method stub
		return iodDao.queryOrderXiang(id);
	}

}
