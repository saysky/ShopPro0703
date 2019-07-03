package com.qianfeng.service.impl;

import java.util.List;

import com.qianfeng.dao.IGoodsTypeDao;
import com.qianfeng.dao.impl.GoodsTypeDaoImpl;
import com.qianfeng.entity.GoodType;
import com.qianfeng.service.IGoodsTypeService;

public class GoodsTypeServiceImpl implements IGoodsTypeService {
	
	private IGoodsTypeDao gtDao = new GoodsTypeDaoImpl();

	@Override
	public List<GoodType> getGoodsTypeList() {
		return gtDao.getGoodsTypeList();
	}

	@Override
	public int addGoodsType(String typename, int fatherid) {
		return gtDao.addGoodsType(typename,fatherid);
	}

	@Override
	public GoodType queryGoodTypeById(int id) {
		return gtDao.queryGoodTypeById(id);
	}

	@Override
	public int updateGoodTypeInfo(int typeid, String typename, int fatherid) {
		return gtDao.updateGoodTypeInfo(typeid,typename,fatherid);
	}

	@Override
	public int deleteById(int typeid) {
		return gtDao.deleteById(typeid);
	}

}
