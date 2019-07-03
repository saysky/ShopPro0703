package com.dream.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String user_name;
	private String nick_name;
	private int pwd;
	private String sex;
	private Date birthday;
	private String phone;
	private String codes;
	private String email;
	private String address;
	private String isadmin;
	private Date regist_date;
	private int lockstate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIsadmin() {
		return isadmin;
	}

	public void setIsadmin(String isadmin) {
		this.isadmin = isadmin;
	}

	public Date getRegist_date() {
		return regist_date;
	}

	public void setRegist_date(Date regist_date) {
		this.regist_date = regist_date;
	}

	public int getLockstate() {
		return lockstate;
	}

	public void setLockstate(int lockstate) {
		this.lockstate = lockstate;
	}

	public int getPwd() {
		return pwd;
	}

	public void setPwd(int pwd) {
		this.pwd = pwd;
	}

	public String getCodes() {
		return codes;
	}

	public void setCodes(String codes) {
		this.codes = codes;
	}

	public User(String user_name, int pwd) {
		super();
		this.user_name = user_name;
		this.pwd = pwd;
	}
	
	

	
	public User(String user_name, String nick_name, int pwd, String sex, Date birthday, String phone, String codes,
			String email, String address, String isadmin, Date regist_date) {
		super();
		this.user_name = user_name;
		this.nick_name = nick_name;
		this.pwd = pwd;
		this.sex = sex;
		this.birthday = birthday;
		this.phone = phone;
		this.codes = codes;
		this.email = email;
		this.address = address;
		this.isadmin = isadmin;
		this.regist_date = regist_date;
	}
	
	

	public User(int id, String user_name, String nick_name, int pwd, String sex, Date birthday, String phone,
			String codes, String email, String address, String isadmin) {
		super();
		this.id = id;
		this.user_name = user_name;
		this.nick_name = nick_name;
		this.pwd = pwd;
		this.sex = sex;
		this.birthday = birthday;
		this.phone = phone;
		this.codes = codes;
		this.email = email;
		this.address = address;
		this.isadmin = isadmin;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
