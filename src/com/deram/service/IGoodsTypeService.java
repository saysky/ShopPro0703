package com.deram.service;

import java.util.List;

import com.dream.entity.GoodsType;

public interface IGoodsTypeService {

	List<GoodsType> getGoodsTypeList();

	int addGoodsType(String typename, int fatherid);

	GoodsType queryGoodTypeById(int id);

	int updateGoodTypeInfo(int typeid, String typename, int fatherid);

	int deleteById(int id);

}
