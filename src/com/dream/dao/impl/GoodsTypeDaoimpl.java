package com.dream.dao.impl;

import java.util.List;

import com.dream.dao.IGoodsTypeDao;
import com.dream.db.DBUtils;
import com.dream.entity.GoodsType;

public class GoodsTypeDaoimpl extends DBUtils<GoodsType> implements IGoodsTypeDao {
	
	@Override
	public List<GoodsType> getGoodsTypeList() {
		String sql = "select * from t_goods_type";
		return super.getList(sql, GoodsType.class);
	}

	@Override
	public int addGoodsType(String typename, int fatherid) {
		String sql = "insert into t_goods_type(gtype_name,gtype_parentid)values(?,?)";
		return super.commonOper(sql, typename,fatherid);
	}

	@Override
	public GoodsType queryGoodTypeById(int id) {
		String sql = "select * from t_goods_type where id=?";
		return super.getSingleInstance(sql, GoodsType.class, id);
	}

	@Override
	public int updateGoodTypeInfo(int typeid, String typename, int fatherid) {
		String sql = "update t_goods_type set gtype_name = ?,gtype_parentid = ? where id = ?";
		return super.commonOper(sql, typename,fatherid,typeid);
	}

	@Override
	public int deleteById(int id) {
		String sql = "delete from t_goods_type where id=?";
		return super.commonOper(sql, id);
	}

}
