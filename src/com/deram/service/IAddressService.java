package com.deram.service;

import java.util.List;

import com.dream.entity.Address;

public interface IAddressService {

	List<Address> getAddressListByUserId(int userid);

	int addAddress(String shouhuoren, String phone, String address, int userid);



}
