package com.dream.dao;

import java.util.List;

import com.dream.entity.Address;

public interface IAddressDao {

	List<Address> getAddressListByUserId(int userid);

	int addAddress(String shouhuoren, String phone, String address, int userid);

}
