package com.deram.service.impl;

import java.util.List;

import com.deram.service.IAddressService;
import com.dream.dao.IAddressDao;
import com.dream.dao.impl.AddressDaoimpl;
import com.dream.entity.Address;

public class AddressServiceimpl implements IAddressService {
	private IAddressDao idDao = new AddressDaoimpl();
	@Override
	public List<Address> getAddressListByUserId(int userid) {
		// TODO Auto-generated method stub
		return idDao.getAddressListByUserId(userid);
	}
	@Override
	public int addAddress(String shouhuoren, String phone, String address, int userid) {
		// TODO Auto-generated method stub
		return idDao.addAddress(shouhuoren,phone,address,userid);
	}


}
