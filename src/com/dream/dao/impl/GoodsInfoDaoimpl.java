package com.dream.dao.impl;

import java.util.List;

import com.dream.dao.IGoodsInfoDao;
import com.dream.db.DBUtils;
import com.dream.entity.GoodsInfo;

public class GoodsInfoDaoimpl extends DBUtils<GoodsInfo> implements IGoodsInfoDao {

	@Override
	public List<GoodsInfo> getGoodsInfoList() {
		String sql = "SELECT * from t_goods_info where isdelete = 'N'";
		return super.getList(sql, GoodsInfo.class);
	}

	@Override
	public GoodsInfo getGoodsInfoById(int id) {
		String sql = "select * from t_goods_info where id = ?";
		return super.getSingleInstance(sql, GoodsInfo.class, id);
	}

	@Override
	public List<GoodsInfo> queryAllGoodsInfo() {
		String sql = "select * from t_goods_info";
		// TODO Auto-generated method stub
		return super.getList(sql, GoodsInfo.class);
	}

	@Override
	public int deleteById(int id) {
		String sql ="delete from t_goods_info where id=?";
		return super.commonOper(sql, id);
	}

}
