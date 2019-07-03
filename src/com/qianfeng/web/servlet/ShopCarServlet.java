package com.qianfeng.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.db.WebUtils;
import com.qianfeng.entity.GoodInfo;
import com.qianfeng.entity.ShopCar;
import com.qianfeng.service.IGoodsInfoService;
import com.qianfeng.service.impl.GoodsInfoServiceImpl;

public class ShopCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private IGoodsInfoService giService = new GoodsInfoServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		//得到购物车
		ShopCar shopCar = ShopCar.getShopCar(request.getSession());
		if("add".equals(action)){
			//向购物车中添加商品
			int id = WebUtils.StringToInt(request.getParameter("id"), -1);
			int count = WebUtils.StringToInt(request.getParameter("count"), -1);
			
			GoodInfo goodInfo = giService.getGoodsInfoById(id);
			goodInfo.setCount(count);
			
			shopCar.add(goodInfo);
			response.sendRedirect("shopcar.jsp");
		}else if("update".equals(action)){
			//修改购物车商品数量
			int id = WebUtils.StringToInt(request.getParameter("goodId"), -1);
			int count = WebUtils.StringToInt(request.getParameter("count"), -1);
			String tag = request.getParameter("tag");
						
			shopCar.update(count, id);
			if("frompay".equals(tag)){
				response.getWriter().write("1");
			}else{
				response.sendRedirect("shopcar.jsp");
			}
			
		} else if("delete".equals(action)){
			//删除购物车商品
			int id = WebUtils.StringToInt(request.getParameter("id"), -1);
			
			shopCar.remove(id);
			response.sendRedirect("shopcar.jsp");
		} else if("clear".equals(action)){
			//清空购物车
			shopCar.getList().clear();
			response.sendRedirect("success.jsp");
		}
	}

}
