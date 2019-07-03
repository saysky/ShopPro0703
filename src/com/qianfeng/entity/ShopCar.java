package com.qianfeng.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * 购物车
 * @author asus
 *
 */
public class ShopCar {
	
	//商品集合
	private List<GoodInfo> list = new ArrayList<>();
	
	
	//购物车
	public static ShopCar getShopCar(HttpSession session){
		ShopCar shopCar = (ShopCar) session.getAttribute("SHOP_CAR");
		if(shopCar==null){
			shopCar = new ShopCar();
			session.setAttribute("SHOP_CAR", shopCar);
		}
		return shopCar;
	}
	
	
	/**
	 * 添加商品
	 * @return
	 */
	public void add(GoodInfo goodInfo){
		boolean flag = true;
		for (GoodInfo good : list) {
			if(good.getId()==goodInfo.getId()){
				good.setCount(good.getCount()+goodInfo.getCount());
				flag = false;
				return;
			}
		}
		
		if(flag){
			//没有该商品，则添加到购物车
			list.add(goodInfo);
		}
	}
	
	/**
	 * 修改商品数量
	 * @return
	 */
	public void update(int count,int id){
		for (GoodInfo goodInfo : list) {
			if(goodInfo.getId()==id){
				goodInfo.setCount(count);
				return;
			}
		}
	}
	
	/**
	 * 移除商品
	 * @return
	 */
	public void remove(int id){
		for (GoodInfo goodInfo : list) {
			if(goodInfo.getId()==id){
				list.remove(goodInfo);
				return;
			}
		}
	}
	
	/**
	 * 得到购物车商品总价
	 * @return
	 */
	public double getTotalPrice(){
		BigDecimal totalPrice = new BigDecimal(String.valueOf(0));
		for (GoodInfo goodInfo : list) {
			totalPrice = totalPrice.add(new BigDecimal(String.valueOf(goodInfo.getDanPrice())));
		}
		return totalPrice.doubleValue();
	}
	
	/**
	 * 得到购物车商品数量
	 * @return
	 */
	public int getTypeCount(){
		return list.size();
	}
	
	

	public List<GoodInfo> getList() {
		return list;
	}

	public void setList(List<GoodInfo> list) {
		this.list = list;
	}
	
	
	

}
