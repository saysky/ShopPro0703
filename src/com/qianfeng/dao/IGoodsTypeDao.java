package com.qianfeng.dao;

import java.util.List;

import com.qianfeng.entity.GoodType;

public interface IGoodsTypeDao {

	List<GoodType> getGoodsTypeList();

	int addGoodsType(String typename, int fatherid);

	GoodType queryGoodTypeById(int id);

	int updateGoodTypeInfo(int typeid, String typename, int fatherid);

	int deleteById(int typeid);

}
