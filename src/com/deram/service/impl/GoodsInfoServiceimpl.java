package com.deram.service.impl;

import java.util.List;

import com.deram.service.IGoodsInfoService;
import com.dream.dao.IGoodsInfoDao;
import com.dream.dao.impl.GoodsInfoDaoimpl;
import com.dream.entity.GoodsInfo;

public class GoodsInfoServiceimpl implements IGoodsInfoService {
	
	private IGoodsInfoDao giDao = new GoodsInfoDaoimpl();
	@Override
	public List<GoodsInfo> getGoodsInfoList() {
		// TODO Auto-generated method stub
		return giDao.getGoodsInfoList();
	}
	@Override
	public GoodsInfo getGoodsInfoById(int id) {
		// TODO Auto-generated method stub
		return giDao.getGoodsInfoById(id);
	}
	@Override
	public List<GoodsInfo> queryAllGoodsInfo() {
		// TODO Auto-generated method stub
		return giDao.queryAllGoodsInfo();
	}
	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return giDao.deleteById(id);
	}

}
