package com.qianfeng.dao.impl;

import java.util.List;

import com.qianfeng.dao.IAddressDao;
import com.qianfeng.db.DBUtils;
import com.qianfeng.entity.Address;

public class AddressDaoImpl extends DBUtils<Address> implements IAddressDao {

	@Override
	public List<Address> getAddressListByUserId(int userid) {
		String sql = "SELECT * from t_address where userid = ?";
		return super.getList(sql, Address.class, userid);
	}

}
