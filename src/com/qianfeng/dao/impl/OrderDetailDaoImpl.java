package com.qianfeng.dao.impl;

import com.qianfeng.dao.IOrderDetailDao;
import com.qianfeng.db.DBUtils;
import com.qianfeng.entity.OrderDetail;

public class OrderDetailDaoImpl extends DBUtils<OrderDetail> implements IOrderDetailDao {

	@Override
	public void addOrderDetail(OrderDetail od) {
		String sql = "insert into t_order_detail values(null,?,?,?,?,?,?,?,?)";
		super.commonOper(sql, od.getO_orderid(), od.getGoodsid(), od.getGoodsname(), od.getGoodsprice(),
				od.getGoods_description(), od.getGoodsnum(), od.getGoodspic(), od.getGoods_total_price());
	}

}
