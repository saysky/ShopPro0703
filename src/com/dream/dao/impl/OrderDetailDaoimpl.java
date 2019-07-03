package com.dream.dao.impl;

import java.util.List;

import com.dream.dao.IOrderDetailDao;
import com.dream.db.DBUtils;
import com.dream.entity.OrderDetail;

public class OrderDetailDaoimpl extends DBUtils<OrderDetail> implements IOrderDetailDao {

	@Override
	public void addOrderDetail(OrderDetail od) {
		String sql = "insert into t_order_detail values(null,?,?,?,?,?,?,?,?)";
		super.commonOper(sql, od.getO_orderid(), od.getGoodsid(), od.getGoodsname(), od.getGoodsprice(),
				od.getGoods_description(), od.getGoodsnum(), od.getGoodspic(), od.getGoods_total_price());
		
	}

	@Override
	public List<OrderDetail> queryOrderDetail() {
		String sql = "select * from t_order_detail";
		return super.getList(sql, OrderDetail.class);
	}

	@Override
	public List<OrderDetail> queryOrderXiang(int id) {
		
		String sql = "select * from t_order_detail where id=?";
		return super.getList(sql, OrderDetail.class, id);
	}

}
