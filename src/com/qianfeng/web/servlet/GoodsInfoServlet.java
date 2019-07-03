package com.qianfeng.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.db.WebUtils;
import com.qianfeng.entity.GoodInfo;
import com.qianfeng.service.IGoodsInfoService;
import com.qianfeng.service.impl.GoodsInfoServiceImpl;
public class GoodsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private IGoodsInfoService giService = new GoodsInfoServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if("queryById".equals(action)){
			//通过商品id查询商品对象
			int id = WebUtils.StringToInt(request.getParameter("id"),-1);
			GoodInfo gi = giService.getGoodsInfoById(id);
			request.setAttribute("goodInfo", gi);
			request.getRequestDispatcher("introduction.jsp").forward(request, response);
			
		}
	}

}
