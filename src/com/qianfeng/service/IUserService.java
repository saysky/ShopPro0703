package com.qianfeng.service;

import java.util.List;

import com.qianfeng.entity.Page;
import com.qianfeng.entity.User;

public interface IUserService {

	int checkUserName(String username);

	int addUser(User user);

	User completeUserInfo(User user, String nick_name, String sex, String birthday, String phone, String email,
			String address, String code);

	int modifyUser(User user);

	User checkLogin(User user);

	User checkBackLogin(User user);

	List<User> queryAllUserInfo();

	int updateUserLockState(int userid, int lockstate);

	int addBackUser(User user);

	Page<User> getPage(String currentPage);

}
