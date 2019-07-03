package com.qianfeng.dao;

import java.util.List;

import com.qianfeng.entity.User;

public interface IUserDao {

	int checkUserName(String username);

	int addUser(User user);

	int modifyUser(User user);

	User checkLogin(User user);

	User checkBackLogin(User user);

	List<User> queryAllUserInfo();

	int updateUserLockState(int userid, int lockstate);

	int addBackUser(User user);

	int getTotalCount();

	List<User> getUserList(int startIndex, int pageSize);

}
