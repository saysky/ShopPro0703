package com.qianfeng.service.impl;

import java.util.List;

import com.qianfeng.dao.IGoodsInfoDao;
import com.qianfeng.dao.impl.GoodsInfoDaoImpl;
import com.qianfeng.entity.GoodInfo;
import com.qianfeng.service.IGoodsInfoService;

public class GoodsInfoServiceImpl implements IGoodsInfoService {
	
	private IGoodsInfoDao giDao = new GoodsInfoDaoImpl();

	@Override
	public List<GoodInfo> getGoodsInfoList() {
		return giDao.getGoodsInfoList();
	}

	@Override
	public GoodInfo getGoodsInfoById(int id) {
		return giDao.getGoodsInfoById(id);
	}

}
