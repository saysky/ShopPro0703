package com.qianfeng.service;

import java.util.List;

import com.qianfeng.entity.GoodInfo;

public interface IGoodsInfoService {

	List<GoodInfo> getGoodsInfoList();

	GoodInfo getGoodsInfoById(int id);

}
