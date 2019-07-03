package com.qianfeng.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qianfeng.db.WebUtils;
import com.qianfeng.entity.Page;
import com.qianfeng.entity.User;
import com.qianfeng.service.IUserService;
import com.qianfeng.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IUserService userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter writer = response.getWriter();
		if ("checkNameExits".equals(action)) {
			// 得到用户名
			String username = request.getParameter("username");
			int result = userService.checkUserName(username);
			if (result > 0) {
				// 有用户名
				writer.write("1");
			} else {
				writer.write("0");
			}
		} else if ("regist".equals(action)) {
			//
			String username = request.getParameter("username");
			int password = WebUtils.StringToInt(request.getParameter("password"), -1);

			User user = new User(username, password);
			int result = userService.addUser(user);
			if (result > 0) {
				request.getSession().setAttribute("REGIST_USER", user);
				writer.write("<script>alert('注册成功!请完善您的信息!');location.href='information.jsp'</script>");
			} else {
				writer.write("<script>alert('注册失败!');location.href='regist.jsp'</script>");
			}
		} else if ("modifeRegistInfo".equals(action)) {
			String nick_name = request.getParameter("nick_name");
			String sex = request.getParameter("sex");
			String birthday = request.getParameter("birthday");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			String code = request.getParameter("code");

			// 得到注册用户
			User user = (User) request.getSession().getAttribute("REGIST_USER");
			//
			user = userService.completeUserInfo(user, nick_name, sex, birthday, phone, email, address, code);

			int result = userService.modifyUser(user);
			if (result > 0) {
				writer.write("<script>alert('完善用户信息成功!');location.href='home.jsp'</script>");
			} else {
				writer.write("<script>alert('完善用户信息失败!');location.href='home.jsp'</script>");
			}
		} else if ("login".equals(action)) {
			String username = request.getParameter("username");
			int password = WebUtils.StringToInt(request.getParameter("password"), -1);

			User user = new User(username, password);
			user = userService.checkLogin(user);
			if (user != null) {
				if(user.getLockstate()==1){
					writer.write("<script>alert('账户被冻结!');location.href='login.jsp'</script>");
				}else{
					request.getSession().setAttribute("LOGIN_USER", user);
					writer.write("<script>alert('登录成功!');location.href='home.jsp'</script>");
				}
				
			} else {
				writer.write("<script>alert('登录失败!');location.href='login.jsp'</script>");
			}
		} else if ("zhuxiao".equals(action)) {
			// 注销
			request.getSession().removeAttribute("LOGIN_USER");
			response.sendRedirect("home.jsp");
		} else if("backlogin".equals(action)){
			//后端的登录
			String username = request.getParameter("username");
			int password = WebUtils.StringToInt(request.getParameter("password"), -1);
			
			
			User user = new User(username, password);
			user = userService.checkBackLogin(user);
			if (user != null) {
				request.getSession().setAttribute("BACK_LOGIN_USER", user);
				writer.write("<script>alert('登录成功!');location.href='back/main.jsp'</script>");
			} else {
				writer.write("<script>alert('登录失败!');location.href='backLogin.jsp'</script>");
			}
		} else if("queryAllUserInfo".equals(action)){
			//查询所有的用户
			//List<User> userList = userService.queryAllUserInfo();
			String currentPage = request.getParameter("currentPage");
			Page<User> page = userService.getPage(currentPage);
			page.setUrl("back/UserServlet?action=queryAllUserInfo");
			request.getSession().setAttribute("page", page);
			response.sendRedirect("user/userinfo.jsp");
		}else if("updateUserLockState".equals(action)){
			int userid = WebUtils.StringToInt(request.getParameter("userid"), -1);
			int lockstate = WebUtils.StringToInt(request.getParameter("lockstate"), -1);
			
			int result = userService.updateUserLockState(userid,lockstate);
			if (result>0) {
				writer.write("<script>alert('修改状态成功!');location.href='back/UserServlet?action=queryAllUserInfo'</script>");
			} else {
				writer.write("<script>alert('修改状态失败!');location.href='back/UserServlet?action=queryAllUserInfo'</script>");
			}
		} else if("add".equals(action)){
			String username = request.getParameter("username");
			int password = WebUtils.StringToInt(request.getParameter("password"),-1);
			String nick_name = request.getParameter("nickname");
			String role = request.getParameter("role");
			String sex = request.getParameter("sex");
			SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd");
			
			String birthday = request.getParameter("birthday");
			Date shengri = null;
			try {
				shengri = sf.parse(birthday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String code = request.getParameter("code");
			
			User user = new User(username, nick_name, password, sex, shengri, phone, code, email, address, role, new Date());
			
			int result = userService.addBackUser(user);
			if (result>0) {
				writer.write("<script>alert('添加用户成功!');location.href='UserServlet?action=queryAllUserInfo'</script>");
			} else {
				writer.write("<script>alert('添加用户失败!');location.href='UserServlet?action=queryAllUserInfo'</script>");
			}
		}
	}

}
