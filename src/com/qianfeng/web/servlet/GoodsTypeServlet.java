package com.qianfeng.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.db.WebUtils;
import com.qianfeng.entity.GoodType;
import com.qianfeng.service.IGoodsTypeService;
import com.qianfeng.service.impl.GoodsTypeServiceImpl;

/**
 * Servlet implementation class GoodsTypeServlet
 */
public class GoodsTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IGoodsTypeService gtService = new GoodsTypeServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter writer = response.getWriter();
		if("queryAllType".equals(action)){
			List<GoodType> gtList = gtService.getGoodsTypeList();
			request.getSession().setAttribute("gtList", gtList);
			response.sendRedirect("goodstype/goodstype.jsp");
		} else if("add".equals(action)){
			//添加
			String typename = request.getParameter("typename");
			int fatherid = WebUtils.StringToInt(request.getParameter("fatherid"), -1);
			
			int result = gtService.addGoodsType(typename,fatherid);
			if (result>0) {
				writer.write("<script>alert('添加类别成功!');location.href='GoodsTypeServlet?action=queryAllType'</script>");
			} else {
				writer.write("<script>alert('添加类别失败!');location.href='backLogin.jsp'</script>");
			}
		} else if("toUpdate".equals(action)){
			int id = WebUtils.StringToInt(request.getParameter("id"), -1);
			
			GoodType gt =  gtService.queryGoodTypeById(id);
			request.getSession().setAttribute("goodType", gt);
			response.sendRedirect("goodstype/goodstypeupdate.jsp");
		} else if("update".equals(action)){
			int typeid = WebUtils.StringToInt(request.getParameter("typeid"), -1);
			String typename = request.getParameter("typename");
			int fatherid = WebUtils.StringToInt(request.getParameter("fatherid"), -1);
			
			int result = gtService.updateGoodTypeInfo(typeid,typename,fatherid);
			if (result>0) {
				writer.write("<script>alert('修改类别成功!');location.href='GoodsTypeServlet?action=queryAllType'</script>");
			} else {
				writer.write("<script>alert('修改类别失败!');location.href='GoodsTypeServlet?action=queryAllType'</script>");
			}
		} else if("delete".equals(action)){
			int typeid = WebUtils.StringToInt(request.getParameter("id"), -1);
			
			int result = gtService.deleteById(typeid);
			if (result>0) {
				writer.write("<script>alert('删除类别成功!');location.href='GoodsTypeServlet?action=queryAllType'</script>");
			} else {
				writer.write("<script>alert('删除类别失败!');location.href='GoodsTypeServlet?action=queryAllType'</script>");
			}
		}
	}

}
