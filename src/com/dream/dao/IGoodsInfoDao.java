package com.dream.dao;

import java.util.List;

import com.dream.entity.GoodsInfo;

public interface IGoodsInfoDao {

	List<GoodsInfo> getGoodsInfoList();

	GoodsInfo getGoodsInfoById(int id);

	List<GoodsInfo> queryAllGoodsInfo();

	int deleteById(int id);

}
