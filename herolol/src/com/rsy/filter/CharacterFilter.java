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

import com.rsy.utils.BaseCharacterFilter;

public class CharacterFilter implements Filter {
	
	private String encoding;

	public void destroy() {
		

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		//强转
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		//post请求
		req.setCharacterEncoding(this.encoding);
		//post响应
		resp.setCharacterEncoding(this.encoding);
		resp.setContentType("text/html;charset="+this.encoding);
		
		
		//获得请求方式
		if (("get").equalsIgnoreCase(req.getMethod())) {
			//装饰器
			req = new BaseCharacterFilter(req,this.encoding);
		}
		arg2.doFilter(arg0, arg1);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		//获得当前Filter编码
		String filterEncoding = filterConfig.getInitParameter("encoding").trim();
		if (filterEncoding != null && !"".equals(filterEncoding)) {
			this.encoding = filterEncoding;
		}
		System.out.println(encoding);
	}

}
