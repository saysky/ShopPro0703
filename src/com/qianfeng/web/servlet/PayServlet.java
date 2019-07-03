package com.qianfeng.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.entity.Address;
import com.qianfeng.entity.User;
import com.qianfeng.service.IAddressService;
import com.qianfeng.service.impl.AddressServiceImpl;

public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IAddressService addressService = new AddressServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter writer = response.getWriter();
		if ("checkLogin".equals(action)) {
			// 判断用户是否登录
			User user = (User) request.getSession().getAttribute("LOGIN_USER");
			if (user == null) {
				// 没有登录
				writer.write("<script>alert('您还未登录，请先进行登录!');location.href='login.jsp'</script>");
			} else {
				// 登录
				int userid = user.getId();
				List<Address> addressList = addressService.getAddressListByUserId(userid);
				request.getSession().setAttribute("addressList", addressList);
				response.sendRedirect("pay.jsp");

			}
		}
	}

}
