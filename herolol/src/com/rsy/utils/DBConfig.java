package com.rsy.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConfig {
	//读取配置文件
	public static String driver;
	public static String url;
	public static String username;
	public static String password;
	
	static{
		//1.字节输入流
		InputStream is = DBConfig.class.getClassLoader().getResourceAsStream("db.properties");
		
		//2.Properties
		Properties ps = new Properties();
		try {
			ps.load(is);
			
			driver = ps.getProperty("driver");
			url = ps.getProperty("url");
			username = ps.getProperty("username");
			password = ps.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
