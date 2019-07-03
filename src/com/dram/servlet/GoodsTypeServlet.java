package com.dram.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deram.service.IGoodsInfoService;
import com.deram.service.IGoodsTypeService;
import com.deram.service.impl.GoodsInfoServiceimpl;
import com.deram.service.impl.GoodsTypeServiceimpl;
import com.dream.db.WebUtils;
import com.dream.entity.GoodsInfo;
import com.dream.entity.GoodsType;

public class GoodsTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IGoodsTypeService gtService = new GoodsTypeServiceimpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter writer = response.getWriter();
		
		List<GoodsType> gtList = gtService.getGoodsTypeList();
		request.getSession().setAttribute("gtList", gtList);
		if ("queryAllType".equals(action)) {
			request.getRequestDispatcher("goodstype/goodstype.jsp").forward(request, response);		
		}
		else if ("add".equals(action)) {
			String typename = request.getParameter("typename");
			int fatherid = WebUtils.StringToInt(request.getParameter("fatherid"), -1);
			
			int reslut = gtService.addGoodsType(typename,fatherid);
			if (reslut>0) {
				writer.write("<script>alert('添加成功!!!');location.href='GoodsTypeServlet?action=queryAllType'</script>");
			}else {
				writer.write("<script>alert('添加失败!!!');location.href='backLogin.jsp'</script>");
			}
		}
		else if ("toUpdate".equals(action)) {
			 int id = WebUtils.StringToInt(request.getParameter("id"), -1);
			 
				GoodsType gt =  gtService.queryGoodTypeById(id);
				request.getSession().setAttribute("goodsType", gt);
				response.sendRedirect("goodstype/goodstypeupdate.jsp");

		}else if ("update".equals(action)) {
			int typeid = WebUtils.StringToInt(request.getParameter("typeid"), -1);
			String typename = request.getParameter("typename");
			int fatherid = WebUtils.StringToInt(request.getParameter("fatherid"), -1);
			
			int result = gtService.updateGoodTypeInfo(typeid,typename,fatherid);
			if (result>0) {
				writer.write("<script>alert('修改类别成功!');location.href='GoodsTypeServlet?action=queryAllType'</script>");
			} else {
				writer.write("<script>alert('修改类别失败!');location.href='GoodsTypeServlet?action=queryAllType'</script>");
			}
		}
		else if ("delete".equals(action)) {
			 int id = WebUtils.StringToInt(request.getParameter("id"), -1);
			 
			 int res = gtService.deleteById(id);
			// System.out.println(res);
			 if (res>0) {
					writer.write("<script>alert('删除类别成功!');location.href='GoodsTypeServlet?action=queryAllType'</script>");
				} else {
					writer.write("<script>alert('删除类别失败!');location.href='GoodsTypeServlet?action=queryAllType'</script>");
				}
			 
		}
	}

}
