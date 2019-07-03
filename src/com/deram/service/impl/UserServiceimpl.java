package com.deram.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.deram.service.IUserService;
import com.dream.dao.IUserDao;
import com.dream.dao.impl.UserDaoimpl;
import com.dream.entity.Page;
import com.dream.entity.User;

public class UserServiceimpl implements IUserService {
	
	private IUserDao iuDao = new UserDaoimpl();
	
	@Override
	public int checkUserName(String username) {
		return iuDao.checkUserName(username);
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return iuDao.addUser(user);
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
		// TODO Auto-generated method stub
		return iuDao.modifyUser(user);
	}

	@Override
	public User checkLogin(User user) {
		// TODO Auto-generated method stub
		return iuDao.checkLogin(user);
	}

	@Override
	public User checkBackLogin(User user) {
		// TODO Auto-generated method stub
		return iuDao.checkBackLogin(user);
	}

	@Override
	public List<User> queryAllUserInfo() {
		// TODO Auto-generated method stub
		return iuDao.queryAllUserInfo();
	}

	@Override
	public int updateUserLockState(int userid, int lockstate) {
		// TODO Auto-generated method stub
		return iuDao.updateUserLockState(userid,lockstate);
	}

	@Override
	public int addBackUser(User user) {
		// TODO Auto-generated method stub
		return iuDao.addBackUser(user);
	}

	@Override
	public Page<User> getPage(String currentPage) {
		Page<User> page = new Page<>(1,5);
		if(currentPage!=null){
			page.setCurrentPage(Integer.parseInt(currentPage));
		}
		
		int totalCount = iuDao.getTotalCount();
		int totalPage = totalCount%page.getPageSize()==0?totalCount/page.getPageSize():totalCount/page.getPageSize()+1;
		//2-1
		int startIndex = (page.getCurrentPage()-1)*page.getPageSize();
		//select * from t_user limit 0,5
		//select * from t_user limit 5,5
		List<User> list = iuDao.getUserList(startIndex,page.getPageSize());
		page.setTotalPage(totalPage);
		page.setList(list);
		return page;
	}


}
