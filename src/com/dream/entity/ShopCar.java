package com.dream.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class ShopCar {
	//商品集合
	private List<GoodsInfo> list = new  ArrayList<>();

	public List<GoodsInfo> getList() {
		return list;
	}

	public void setList(List<GoodsInfo> list) {
		this.list = list;
	}
	
	public static ShopCar getShopCar(HttpSession session) {
		
		ShopCar shopCar = (ShopCar)session.getAttribute("SHOP_CAR");
		if(shopCar == null) {
			shopCar = new ShopCar();
			session.setAttribute("SHOP_CAR", shopCar);
		}
		
		return shopCar;
	}
	
	//添加商品
	public void add(GoodsInfo good) {
		boolean flag =	true;
		for (GoodsInfo goodsInfo : list) {
			if (goodsInfo.getId()==good.getId()) {
				goodsInfo.setCount(goodsInfo.getCount()+good.getCount());
				flag = false;
				return;
			}
		}
		if (flag) {
			//没有该商品，添加到购物车
			list.add(good);
		}
	}
	//修改商品数量
	public void update(int count,int id) {
		for (GoodsInfo goodsInfo : list) {
			if (goodsInfo.getId() == id) {
				goodsInfo.setCount(count);
				return;
			}
		}
		
	}
	//移除商品
	public void remove(int id) {
		for (GoodsInfo goodsInfo : list) {
			if (goodsInfo.getId() == id) {
				list.remove(goodsInfo);
				return; 
			}
		}
	}
	//获取购物车商品总价
	public double getTotalPrice() {
		BigDecimal totalprice = new BigDecimal(String.valueOf(0));
		for (GoodsInfo goodsInfo : list) {
			totalprice = totalprice.add(new BigDecimal(String.valueOf(goodsInfo.getDanPrice())));
		}
		return totalprice.doubleValue();
	}
	//获取购物车商品数量
	public int getTypeCount() {
		return list.size();
	}
}















