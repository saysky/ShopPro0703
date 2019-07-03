package com.qianfeng.dao.impl;

import java.util.List;

import com.qianfeng.dao.IGoodsInfoDao;
import com.qianfeng.db.DBUtils;
import com.qianfeng.entity.GoodInfo;

public class GoodsInfoDaoImpl extends DBUtils<GoodInfo> implements IGoodsInfoDao {

	@Override
	public List<GoodInfo> getGoodsInfoList() {
		String sql = "SELECT * from t_goods_info where isdelete = 'N'";
		return super.getList(sql, GoodInfo.class);
	}

	@Override
	public GoodInfo getGoodsInfoById(int id) {
		String sql = "SELECT * from t_goods_info where id = ?";
		return super.getSingleInstance(sql, GoodInfo.class, id);
	}

}
