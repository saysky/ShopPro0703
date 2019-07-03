package com.dram.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deram.service.IAddressService;
import com.deram.service.impl.AddressServiceimpl;
import com.dream.entity.Address;
import com.dream.entity.User;

public class payServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAddressService addressService = new AddressServiceimpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter writer = response.getWriter();

		if ("checkLogin".equals(action)) {
			User user = (User) request.getSession().getAttribute("LOGIN");
			if (user==null) {
				writer.write("<script>alert('未登录，请登录!!!');location.href='login.jsp'</script>");
			}else {
				int userid = user.getId();
				List<Address> addressList = addressService.getAddressListByUserId(userid);
				request.getSession().setAttribute("addressList", addressList);
				response.sendRedirect("pay.jsp");
			}
		}
	}
}
