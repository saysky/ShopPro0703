package com.dram.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deram.service.IAddressService;
import com.deram.service.impl.AddressServiceimpl;
import com.dream.entity.User;

public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAddressService iaservice = new AddressServiceimpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter writer = response.getWriter();
		if ("addAddress".equals(action)) {
			String shouhuoren = request.getParameter("shouhuoren");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			User user = (User) request.getSession().getAttribute("LOGIN");
			int userid = user.getId();
			//System.out.println(shouhuoren+"--"+phone+"--"+address);
			int re =  iaservice.addAddress(shouhuoren,phone,address,userid);
			
			if (re>0) {
				writer.write("<script>alert('修改成功!!!');location.href='pay.jsp'</script>");
			}else {
				writer.write("<script>alert('修改失败!!!');location.href='addAddress.jsp'</script>");
			}		
		}		
	}
}
