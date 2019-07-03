package com.dram.servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deram.service.IOrderDetailService;
import com.deram.service.IOrderService;
import com.deram.service.impl.OrderDetailServiceimpl;
import com.deram.service.impl.OrderServiceimpl;
import com.dream.db.WebUtils;
import com.dream.entity.GoodsInfo;
import com.dream.entity.Order;
import com.dream.entity.OrderDetail;
import com.dream.entity.ShopCar;
import com.dream.entity.User;

public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IOrderService iService = new OrderServiceimpl();
	private IOrderDetailService idService = new OrderDetailServiceimpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		ShopCar shopCar = ShopCar.getShopCar(request.getSession());
		User user = (User) request.getSession().getAttribute("LOGIN");
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
			iService.addOrder(order);
			
			//添加订单明细
			for(GoodsInfo good :shopCar.getList()){
				OrderDetail od = new OrderDetail(orderId, good.getId(), good.getGoods_name(), good.getGoods_price_off(), good.getGoods_description(), good.getCount(), good.getGoods_pic(), good.getDanPrice());
				idService.addOrderDetail(od);
			}
			
			request.getSession().setAttribute("order", order);
			response.sendRedirect("ShopCarServlet?action=clear");
		}
		else if ("queryAllOrderList".equals(action)) {
			
			//查询
			List<Order> orderList = iService.queryOrder();
			List<OrderDetail> orderDetailsList =  idService.queryOrderDetail();
			//保存
			request.getSession().setAttribute("orderList", orderList);
			request.getSession().setAttribute("orderDetailsList", orderDetailsList);
			
			response.sendRedirect("order/orderlist.jsp");
			
			
		}
		else if ("orderXiang".equals(action)) {
				
			int id = WebUtils.StringToInt(request.getParameter("id"), -1);
			System.out.println(id);
			
			List<OrderDetail> oDList = idService.queryOrderXiang(id);
			
			
			
			response.sendRedirect("back/order/order.jsp");
			
		}
	}

}
