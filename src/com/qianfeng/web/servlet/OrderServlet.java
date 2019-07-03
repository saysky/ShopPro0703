package com.qianfeng.web.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.entity.GoodInfo;
import com.qianfeng.entity.Order;
import com.qianfeng.entity.OrderDetail;
import com.qianfeng.entity.ShopCar;
import com.qianfeng.entity.User;
import com.qianfeng.service.IOrderDetailService;
import com.qianfeng.service.IOrderService;
import com.qianfeng.service.impl.OrderDetailServiceImpl;
import com.qianfeng.service.impl.OrderServiceImpl;

public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IOrderService orderService = new OrderServiceImpl();
	private IOrderDetailService odService = new OrderDetailServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		ShopCar shopCar = ShopCar.getShopCar(request.getSession());
		User user = (User) request.getSession().getAttribute("LOGIN_USER");
		if("add".equals(action)){
			//
			String person = request.getParameter("shouhuoren");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String express = request.getParameter("express");
			String pay = request.getParameter("bank");	
			
			//当前的年份+5个0-9随机数
			Calendar calendar = Calendar.getInstance();
			int year = calendar.get(Calendar.YEAR);
			Random random = new Random();
			StringBuffer sbBuffer = new StringBuffer();
			for(int i=1;i<=5;i++){
				sbBuffer.append(random.nextInt(10));
			}
			int orderId = Integer.parseInt(year+sbBuffer.toString());
			Order order = new Order(orderId, express, pay, shopCar.getTotalPrice(), user.getId(), person, phone, address);
			//添加订单
			orderService.addOrder(order);
			
			//添加订单明细
			for(GoodInfo good :shopCar.getList()){
				OrderDetail od = new OrderDetail(orderId, good.getId(), good.getGoods_name(), good.getGoods_price_off(), good.getGoods_description(), good.getCount(), good.getGoods_pic(), good.getDanPrice());
				odService.addOrderDetail(od);
			}
			
			request.getSession().setAttribute("order", order);
			response.sendRedirect("ShopCarServlet?action=clear");
		}
	}

}
