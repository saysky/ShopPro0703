package com.dram.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deram.service.IGoodsInfoService;
import com.deram.service.IGoodsTypeService;
import com.deram.service.impl.GoodsInfoServiceimpl;
import com.deram.service.impl.GoodsTypeServiceimpl;
import com.dream.entity.GoodsInfo;
import com.dream.entity.GoodsType;

public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IGoodsTypeService gtservice = new GoodsTypeServiceimpl();
	private IGoodsInfoService giservive  = new GoodsInfoServiceimpl();
    public InitServlet() {
        super();
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("queryAll".equals(action)) {
			//商品类别的数据
			List<GoodsType> gtList =  gtservice.getGoodsTypeList();
			//商品信息的集合数据
			List<GoodsInfo> giList =  giservive.getGoodsInfoList();
			//保存
			request.setAttribute("gtList", gtList);
			request.setAttribute("giList", giList);
			//跳转
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
