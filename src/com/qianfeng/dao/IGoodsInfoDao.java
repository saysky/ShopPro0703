package com.qianfeng.dao;

import java.util.List;

import com.qianfeng.entity.GoodInfo;

public interface IGoodsInfoDao {

	List<GoodInfo> getGoodsInfoList();

	GoodInfo getGoodsInfoById(int id);

}
