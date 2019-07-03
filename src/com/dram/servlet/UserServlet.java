package com.dram.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deram.service.IUserService;
import com.deram.service.impl.UserServiceimpl;
import com.dream.db.WebUtils;
import com.dream.entity.Page;
import com.dream.entity.User;


public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IUserService iuservice = new UserServiceimpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		PrintWriter writer = response.getWriter();
		if ("checkNameExits".equals(action)) {
			String username = request.getParameter("username");
			int result =  iuservice.checkUserName(username);
			//System.out.println(result);
			if (result>0) {
				writer.write("1");
			}else {
				writer.write("0");
			}
		}
		else if ("regist".equals(action)) {
			String username = request.getParameter("username");
			int password = WebUtils.StringToInt(request.getParameter("password"), -1);
			
			User user = new User(username,password);
			int resluts = iuservice.addUser(user);
			//System.out.println(resluts);
			if (resluts>0) {
				request.getSession().setAttribute("REGIST_USER", user);
				writer.write("<script>alert('注册成功!请完善您的信息!');location.href='information.jsp'</script>");
			}else {
				writer.write("<script>alert('注册失败!请重新注册!');location.href='register.jsp'</script>");
			}
		}
		else if ("modifeRegistInfo".equals(action)) {
			
			String nick_name = request.getParameter("nick_name");
			String sex = request.getParameter("sex");
			String birthday = request.getParameter("birthday");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			String code = request.getParameter("code");
			
			User user = (User) request.getSession().getAttribute("REGIST_USER");

			user = iuservice.completeUserInfo(user,nick_name,sex,birthday,phone,email,address,code);
			int result = iuservice.modifyUser(user);
			if (result>0) {
				writer.write("<script>alert('完善用户信息成功!');location.href='home.jsp'</script>");
			}else {
				writer.write("<script>alert('完善用户信息失败!');location.href='information.jsp'</script>");
			}
		}
		else if ("login".equals(action)) {
			String username = request.getParameter("username");
			int password = WebUtils.StringToInt(request.getParameter("password"), -1);
			User user = new User(username,password);
			user =  iuservice.checkLogin(user);
			if (user!=null) {
				
				//账户冻结
				if(user.getLockstate()==1){
					writer.write("<script>alert('账户被冻结!');location.href='login.jsp'</script>");
				}else{
					request.getSession().setAttribute("LOGIN_USER", user);
					writer.write("<script>alert('登录成功!');location.href='home.jsp'</script>");
				}
				request.getSession().setAttribute("LOGIN", user);
				writer.write("<script>alert('登录成功!');location.href='home.jsp'</script>");
			}
			else {
				writer.write("<script>alert('登录失败!');location.href='login.jsp'</script>");
			}
		}
		else if ("backlogin".equals(action)) {
			String username = request.getParameter("username");
			int password = WebUtils.StringToInt(request.getParameter("password"), -1);
			
			User user  = new User(username, password);
			user = iuservice.checkBackLogin(user);
			
			if (user!=null) {
				request.getSession().setAttribute("BACK_LOGIN_USER", user);
				writer.write("<script>alert('登录成功!!');location.href='back/main.jsp'</script>");
			}
			else {
				writer.write("<script>alert('登录失败!!');location.href='backLogin.jsp'</script>");
			}
			
		}
		else if ("zhuxiao".equals(action)) {
			request.getSession().removeAttribute("LOGIN");
			response.sendRedirect("home.jsp");
		}
		else if ("queryAllUserInfo".equals(action)) {
			//查询所有的用户
			//List<User> userList =  iuservice.queryAllUserInfo();
			String currentPage = request.getParameter("currentPage");
			Page<User> page = iuservice.getPage(currentPage);
			page.setUrl("back/UserServlet?action=queryAllUserInfo");
			//存起来
			request.getSession().setAttribute("page", page);
			
			response.sendRedirect("user/userinfo.jsp");
			}
		else if ("updateUserLockState".equals(action)) {
			int userid = WebUtils.StringToInt(request.getParameter("userid"), -1);
			int lockstate = WebUtils.StringToInt(request.getParameter("lockstate"), -1);
			
			int result = iuservice.updateUserLockState(userid,lockstate);
			//System.out.println(result);
			if (result>0) {
				writer.write("<script>alert('修改状态成功!');location.href='back/UserServlet?action=queryAllUserInfo'</script>");
			} else {
				writer.write("<script>alert('修改状态失败!');location.href='back/UserServlet?action=queryAllUserInfo'</script>");
			}
		}
		else if ("add".equals(action)) {
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
			
			int result = iuservice.addBackUser(user);
			if (result>0) {
				writer.write("<script>alert('添加用户成功!');location.href='UserServlet?action=queryAllUserInfo'</script>");
			} else {
				writer.write("<script>alert('添加用户失败!');location.href='UserServlet?action=queryAllUserInfo'</script>");
			}
		}
	}

}
