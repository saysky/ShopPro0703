package com.dream.dao;

import java.util.List;

import com.dream.entity.GoodsType;

public interface IGoodsTypeDao {

	List<GoodsType> getGoodsTypeList = null;

	List<GoodsType> getGoodsTypeList();

	int addGoodsType(String typename, int fatherid);

	GoodsType queryGoodTypeById(int id);

	int updateGoodTypeInfo(int typeid, String typename, int fatherid);

	int deleteById(int id);

}
