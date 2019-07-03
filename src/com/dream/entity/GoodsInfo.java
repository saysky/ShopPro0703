package com.dream.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class GoodsInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String goods_name;
	private String goods_description;
	private String goods_pic;
	private double goods_price;
	private int goods_stock;
	private double goods_price_off;
	private double goods_discount;
	private int goods_fatherid;
	private int goods_parentid;
	private String isdelete;
	private int count;//临时属性
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoods_description() {
		return goods_description;
	}

	public void setGoods_description(String goods_description) {
		this.goods_description = goods_description;
	}

	public String getGoods_pic() {
		return goods_pic;
	}

	public void setGoods_pic(String goods_pic) {
		this.goods_pic = goods_pic;
	}

	public double getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(double goods_price) {
		this.goods_price = goods_price;
	}

	public int getGoods_stock() {
		return goods_stock;
	}

	public void setGoods_stock(int goods_stock) {
		this.goods_stock = goods_stock;
	}

	public double getGoods_price_off() {
		return goods_price_off;
	}

	public void setGoods_price_off(double goods_price_off) {
		this.goods_price_off = goods_price_off;
	}

	public double getGoods_discount() {
		return goods_discount;
	}

	public void setGoods_discount(double goods_discount) {
		this.goods_discount = goods_discount;
	}

	public int getGoods_fatherid() {
		return goods_fatherid;
	}

	public void setGoods_fatherid(int goods_fatherid) {
		this.goods_fatherid = goods_fatherid;
	}

	public int getGoods_parentid() {
		return goods_parentid;
	}

	public void setGoods_parentid(int goods_parentid) {
		this.goods_parentid = goods_parentid;
	}

	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	/**
	 * 单个商品的总价
	 */
	public double getDanPrice(){
		BigDecimal disPrice = new BigDecimal(String.valueOf(this.goods_price_off));
		BigDecimal count = new BigDecimal(String.valueOf(this.count));
		BigDecimal danPrice = disPrice.multiply(count);
		return danPrice.doubleValue();
	}
}
