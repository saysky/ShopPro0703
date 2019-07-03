package com.qianfeng.dao.impl;

import java.util.List;

import com.qianfeng.dao.IGoodsTypeDao;
import com.qianfeng.db.DBUtils;
import com.qianfeng.entity.GoodType;

public class GoodsTypeDaoImpl extends DBUtils<GoodType> implements IGoodsTypeDao {

	@Override
	public List<GoodType> getGoodsTypeList() {
		String sql = "select * from t_goods_type";
		return super.getList(sql, GoodType.class);
	}

	@Override
	public int addGoodsType(String typename, int fatherid) {
		String sql = "insert into t_goods_type(gtype_name,gtype_parentid)values(?,?)";
		return super.commonOper(sql, typename,fatherid);
	}

	@Override
	public GoodType queryGoodTypeById(int id) {
		String sql = "select * from t_goods_type where id = ?";
		return super.getSingleInstance(sql, GoodType.class, id);
	}

	@Override
	public int updateGoodTypeInfo(int typeid, String typename, int fatherid) {
		String sql = "update t_goods_type set gtype_name = ?,gtype_parentid = ? where id = ?";
		return super.commonOper(sql, typename,fatherid,typeid);
	}

	@Override
	public int deleteById(int typeid) {
		String sql = "delete from t_goods_type where id = ?";
		return super.commonOper(sql, typeid);
	}

}
