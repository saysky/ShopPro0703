package com.qianfeng.service;

import java.util.List;

import com.qianfeng.entity.Address;

public interface IAddressService {

	List<Address> getAddressListByUserId(int userid);

}
