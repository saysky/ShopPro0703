package com.qianfeng.dao;

import java.util.List;

import com.qianfeng.entity.Address;

public interface IAddressDao {

	List<Address> getAddressListByUserId(int userid);

}
