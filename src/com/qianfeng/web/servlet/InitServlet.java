package com.qianfeng.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.entity.GoodInfo;
import com.qianfeng.entity.GoodType;
import com.qianfeng.service.IGoodsInfoService;
import com.qianfeng.service.IGoodsTypeService;
import com.qianfeng.service.impl.GoodsInfoServiceImpl;
import com.qianfeng.service.impl.GoodsTypeServiceImpl;

public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IGoodsTypeService gtService = new GoodsTypeServiceImpl();
	private IGoodsInfoService giService = new GoodsInfoServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if("queryAll".equals(action)){
			//商品类别的集合数据
			List<GoodType> gtList = gtService.getGoodsTypeList();
			//商品信息的集合数据
			List<GoodInfo> giList = giService.getGoodsInfoList();
			//保存
			request.setAttribute("gtList", gtList);
			request.setAttribute("giList", giList);
			//跳转
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
