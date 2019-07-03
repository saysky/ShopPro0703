package com.qianfeng.service.impl;

import java.util.List;

import com.qianfeng.dao.IAddressDao;
import com.qianfeng.dao.impl.AddressDaoImpl;
import com.qianfeng.entity.Address;
import com.qianfeng.service.IAddressService;

public class AddressServiceImpl implements IAddressService {
	
	private IAddressDao addressDao = new AddressDaoImpl();

	@Override
	public List<Address> getAddressListByUserId(int userid) {
		return addressDao.getAddressListByUserId(userid);
	}

}
