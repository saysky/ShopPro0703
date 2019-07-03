package com.deram.service;

import java.util.List;

import com.dream.entity.GoodsInfo;
import com.dream.entity.Page;
import com.dream.entity.User;

public interface IGoodsInfoService {

	List<GoodsInfo> getGoodsInfoList();

	GoodsInfo getGoodsInfoById(int id);

	List<GoodsInfo> queryAllGoodsInfo();

	int deleteById(int id);


}
