package com.dream.servlet.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BackLoginFilter implements Filter {

    public BackLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		Object session = req.getSession().getAttribute("BACK_LOGIN_USER");
		
		if (session==null) {
			resp.getWriter().write("<script>alert('请先登录!!');location.href='../backLogin.jsp'</script>");
		}else {
			chain.doFilter(req, resp);
			
		}
		
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
