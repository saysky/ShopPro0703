package com.deram.service.impl;

import java.util.List;

import com.deram.service.IGoodsTypeService;
import com.dream.dao.IGoodsTypeDao;
import com.dream.dao.impl.GoodsTypeDaoimpl;
import com.dream.entity.GoodsType;

public class GoodsTypeServiceimpl implements IGoodsTypeService {
	
	private IGoodsTypeDao gtDao = new GoodsTypeDaoimpl();
	
	@Override
	public List<GoodsType> getGoodsTypeList() {
		// TODO Auto-generated method stub
		return gtDao.getGoodsTypeList();
	}

	@Override
	public int addGoodsType(String typename, int fatherid) {
		// TODO Auto-generated method stub
		return gtDao.addGoodsType(typename,fatherid);
	}

	@Override
	public GoodsType queryGoodTypeById(int id) {
		// TODO Auto-generated method stub
		return gtDao.queryGoodTypeById(id);
	}

	@Override
	public int updateGoodTypeInfo(int typeid, String typename, int fatherid) {
		// TODO Auto-generated method stub
		return gtDao.updateGoodTypeInfo(typeid,typename,fatherid);
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		return gtDao.deleteById(id);
	}

}
