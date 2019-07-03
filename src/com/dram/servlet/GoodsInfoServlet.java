package com.dram.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deram.service.IGoodsInfoService;
import com.deram.service.impl.GoodsInfoServiceimpl;
import com.dream.db.WebUtils;
import com.dream.entity.GoodsInfo;
import com.dream.entity.Page;
import com.dream.entity.User;

public class GoodsInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IGoodsInfoService giservice = new GoodsInfoServiceimpl();
	private IGoodsInfoService giService = new GoodsInfoServiceimpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter writer = response.getWriter();
		if ("queryById".equals(action)) {
			//通过商品id查询商品对象
			int id = WebUtils.StringToInt(request.getParameter("id"), -1);
			GoodsInfo gi = giservice.getGoodsInfoById(id);
			//保存
			request.setAttribute("goodsInfo", gi);
			//跳转
			request.getRequestDispatcher("introduction.jsp").forward(request, response);
		}
		else if ("queryAllGoodsInfo".equals(action)) {
			List<GoodsInfo> goodsInfos =  giService.queryAllGoodsInfo();
//			String currentPage = request.getParameter("currentPage");
//			Page<User> page = iuservice.getPage(currentPage);
//			page.setUrl("back/UserServlet?action=queryAllUserInfo");
			request.getSession().setAttribute("goodsInfos", goodsInfos);
			
			response.sendRedirect("goods/goodsList.jsp");
		}
//		else if ("update".equals(action)) {
//			
//		}
		else if ("delete".equals(action)) {
			int id =  WebUtils.StringToInt(request.getParameter("id"), -1);
			
			int res =  giService.deleteById(id);
			
			if (res>0) {
				writer.write("<script>alert('删除成功!!');location.href='GoodsInfoServlet?action=queryAllGoodsInfo'</script>");
			}else {
				writer.write("<script>alert('删除失败!!');location.href='GoodsInfoServlet?action=queryAllGoodsInfo'</script>");
			}
			
		}
	}

}
