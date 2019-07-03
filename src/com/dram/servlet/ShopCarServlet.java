package com.dram.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deram.service.IGoodsInfoService;
import com.deram.service.impl.GoodsInfoServiceimpl;
import com.dream.db.WebUtils;
import com.dream.entity.GoodsInfo;
import com.dream.entity.ShopCar;

public class ShopCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IGoodsInfoService giservice = new GoodsInfoServiceimpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		ShopCar shopCar = ShopCar.getShopCar(request.getSession());
		if("add".equals(action)) {
			int id = WebUtils.StringToInt(request.getParameter("id"), -1);
			int count  =  WebUtils.StringToInt(request.getParameter("count"), -1);
			
			GoodsInfo goodsInfo = giservice.getGoodsInfoById(id);
				goodsInfo.setCount(count);
				
				
				shopCar.add(goodsInfo);
				response.sendRedirect("shopcar.jsp");
		}
		else if ("update".equals(action)) {
			//修改购物车商品数量
			int id = WebUtils.StringToInt(request.getParameter("goodId"), -1);
			int count = WebUtils.StringToInt(request.getParameter("count"), -1);
			
			shopCar.update(count, id);
			response.sendRedirect("shopcar.jsp");
		}
		//删除商品
		else if ("delete".equals(action)) {
			int id = WebUtils.StringToInt(request.getParameter("id"), -1);
			shopCar.remove(id);
			response.sendRedirect("shopcar.jsp");
		}else if("clear".equals(action)){
			//清空购物车
			shopCar.getList().clear();
			response.sendRedirect("success.jsp");
		}

			
	}

}
