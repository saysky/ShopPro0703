package com.dream.dao.impl;

import java.util.Date;
import java.util.List;

import com.dream.dao.IUserDao;
import com.dream.db.DBUtils;
import com.dream.entity.User;

public class UserDaoimpl extends DBUtils<User> implements IUserDao {

	@Override
	public int checkUserName(String username) {
		String sql = "select count(*) from t_user where user_name = ?";
		return super.getCount(sql, username);
	}

	@Override
	public int addUser(User user) {
		String sql = "insert into t_user(user_name,pwd)values(?,?)";
		return super.commonOper(sql, user.getUser_name(),user.getPwd());
	}

	@Override
	public int modifyUser(User u) {
		String sql = "update t_user set nick_name=?,sex=?,birthday=?,phone=?,codes=?,email=?,address=?,isadmin=?,regist_date=?,lockstate=? where user_name=?";
		return super.commonOper(sql, u.getNick_name(), u.getSex(), u.getBirthday(), u.getPhone(), u.getCodes(),
				u.getEmail(), u.getAddress(), "N", new Date(), 0, u.getUser_name());
	}

	@Override
	public User checkLogin(User user) {
		String sql = "SELECT * from t_user where user_name = ? and pwd = ?";
		return super.getSingleInstance(sql, User.class, user.getUser_name(),user.getPwd());
	}

	@Override
	public User checkBackLogin(User user) {
		String sql = "select * from t_user where user_name=? and pwd=? and isadmin='Y'";
		return super.getSingleInstance(sql, User.class, user.getUser_name(),user.getPwd());
	}

	@Override
	public List<User> queryAllUserInfo() {
		String sql = "select * from t_user";
		return super.getList(sql, User.class);
	}

	@Override
	public int updateUserLockState(int userid, int lockstate) {
		String sql = "update t_user set lockstate = ? where id = ?";
		return super.commonOper(sql, lockstate, userid);
	}

	@Override
	public int addBackUser(User u) {
		String sql = "insert into t_user values(null,?,?,?,?,?,?,?,?,?,?,?,?)";
		return super.commonOper(sql, u.getUser_name(), u.getNick_name(), u.getPwd(), u.getSex(), u.getBirthday(),
				u.getPhone(), u.getEmail(), u.getRegist_date(), u.getAddress(), u.getCodes(), u.getIsadmin(), 0);
	}

	@Override
	public int getTotalCount() {
		String sql = "select count(*) from t_user";
		return super.getCount(sql);
	}

	@Override
	public List<User> getUserList(int startIndex, int pageSize) {
		String sql = "select * from t_user limit ?,?";
		return super.getList(sql, User.class, startIndex,pageSize);
	}

}
