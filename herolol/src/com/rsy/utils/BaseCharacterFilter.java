package com.rsy.utils;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class BaseCharacterFilter extends HttpServletRequestWrapper {
	
	private String encoding;
	
	public BaseCharacterFilter(HttpServletRequest request) {
		super(request);
		
	}

	public BaseCharacterFilter(HttpServletRequest request, String encoding) {
		super(request);
		this.encoding = encoding;
	}

	@Override
	public String getParameter(String str) {
		//获得编码后的字符串
		String strEncoding = super.getParameter(str);
		try {
			strEncoding = strEncoding == null?null:new String(strEncoding.getBytes("ISO-8859-1"),this.encoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return strEncoding;
	}
	
	
}
