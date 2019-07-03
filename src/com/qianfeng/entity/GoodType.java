package com.qianfeng.entity;

import java.io.Serializable;

public class GoodType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1447086296001466264L;
	private int id;
	private String gtype_name;
	private int gtype_parentid;
	private String gtype_pic;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGtype_name() {
		return gtype_name;
	}

	public void setGtype_name(String gtype_name) {
		this.gtype_name = gtype_name;
	}

	public int getGtype_parentid() {
		return gtype_parentid;
	}

	public void setGtype_parentid(int gtype_parentid) {
		this.gtype_parentid = gtype_parentid;
	}

	public String getGtype_pic() {
		return gtype_pic;
	}

	public void setGtype_pic(String gtype_pic) {
		this.gtype_pic = gtype_pic;
	}

}
