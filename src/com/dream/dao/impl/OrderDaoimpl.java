package com.dream.dao.impl;

import java.util.Date;
import java.util.List;

import com.dream.dao.IOrderDao;
import com.dream.db.DBUtils;
import com.dream.entity.Order;

public class OrderDaoimpl extends DBUtils<Order> implements IOrderDao {

	@Override
	public void addOrder(Order o) {
		String sql = "insert into t_order values(?,?,?,?,?,?,null,null,?,?,?,?)";
		super.commonOper(sql, o.getId(), o.getO_sendtype(), o.getO_paytype(), o.getO_paycount(), new Date(), 1,
				o.getUserid(), o.getO_shperson(), o.getO_shphone(), o.getO_shaddress());
	}

	@Override
	public List<Order> queryOrder() {
		String sql = "select * from t_order";
		return super.getList(sql, Order.class);
	}

}
