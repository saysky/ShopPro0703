package com.qianfeng.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.qianfeng.dao.IUserDao;
import com.qianfeng.dao.impl.UserDaoImpl;
import com.qianfeng.entity.Page;
import com.qianfeng.entity.User;
import com.qianfeng.service.IUserService;

public class UserServiceImpl implements IUserService {
	
	private IUserDao userDao = new UserDaoImpl();

	@Override
	public int checkUserName(String username) {
		return userDao.checkUserName(username);
	}

	@Override
	public int addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public User completeUserInfo(User user, String nick_name, String sex, String birthday, String phone, String email,
			String address, String code) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date shengri = null;
		try {
			shengri = sdf.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		user.setNick_name(nick_name);
		user.setSex(sex);
		user.setBirthday(shengri);
		user.setPhone(phone);
		user.setEmail(email);
		user.setAddress(address);
		user.setCodes(code);
		return user;
	}

	@Override
	public int modifyUser(User user) {
		return userDao.modifyUser(user);
	}

	@Override
	public User checkLogin(User user) {
		return userDao.checkLogin(user);
	}

	@Override
	public User checkBackLogin(User user) {
		return userDao.checkBackLogin(user);
	}

	@Override
	public List<User> queryAllUserInfo() {
		return userDao.queryAllUserInfo();
	}

	@Override
	public int updateUserLockState(int userid, int lockstate) {
		return userDao.updateUserLockState(userid,lockstate);
	}

	@Override
	public int addBackUser(User user) {
		return userDao.addBackUser(user);
	}

	@Override
	public Page<User> getPage(String currentPage) {
		Page<User> page = new Page<>(1,5);
		if(currentPage!=null){
			page.setCurrentPage(Integer.parseInt(currentPage));
		}
		
		int totalCount = userDao.getTotalCount();
		int totalPage = totalCount%page.getPageSize()==0?totalCount/page.getPageSize():totalCount/page.getPageSize()+1;
		//2-1
		int startIndex = (page.getCurrentPage()-1)*page.getPageSize();
		//select * from t_user limit 0,5
		//select * from t_user limit 5,5
		List<User> list = userDao.getUserList(startIndex,page.getPageSize());
		page.setTotalPage(totalPage);
		page.setList(list);
		return page;
	}

}
