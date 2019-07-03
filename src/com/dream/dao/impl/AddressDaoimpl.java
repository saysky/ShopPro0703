package com.dream.dao.impl;

import java.util.List;

import com.dream.dao.IAddressDao;
import com.dream.db.DBUtils;
import com.dream.entity.Address;

public class AddressDaoimpl extends DBUtils<Address> implements IAddressDao {

	@Override
	public List<Address> getAddressListByUserId(int userid) {
		String sql = "SELECT * from t_address where userid = ?";
		return super.getList(sql, Address.class, userid);
	}

	@Override
	public int addAddress(String shouhuoren, String phone, String address, int userid) {
		String sql ="insert into t_address(shouhuoren,phone,address,userid,isdefault)values(?,?,?,?,'N')";
		return super.commonOper(sql, shouhuoren,phone,address,userid);
	}

}
