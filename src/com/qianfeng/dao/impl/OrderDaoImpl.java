package com.qianfeng.dao.impl;

import java.util.Date;

import com.qianfeng.dao.IOrderDao;
import com.qianfeng.db.DBUtils;
import com.qianfeng.entity.Order;

public class OrderDaoImpl extends DBUtils<Order> implements IOrderDao {

	@Override
	public void addOrder(Order o) {
		String sql = "insert into t_order values(?,?,?,?,?,?,null,null,?,?,?,?)";
		super.commonOper(sql, o.getId(), o.getO_sendtype(), o.getO_paytype(), o.getO_paycount(), new Date(), 1,
				o.getUserid(), o.getO_shperson(), o.getO_shphone(), o.getO_shaddress());
	}

}
