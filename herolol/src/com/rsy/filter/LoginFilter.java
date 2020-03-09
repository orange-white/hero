package com.rsy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rsy.entity.Hero;

public class LoginFilter implements Filter {

	public void destroy() {
		

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//强转
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//获得session
		HttpSession session = req.getSession();
		
		Hero pet = (Hero) session.getAttribute("hero");
		if (pet == null) {
			resp.sendRedirect("login.jsp");
		} else {
			chain.doFilter(request, response);
		}

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		

	}

}
