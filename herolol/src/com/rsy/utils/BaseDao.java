package com.rsy.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	//访问数据库的方法
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	private String driver=DBConfig.driver;
	private String url=DBConfig.url;
	private String user=DBConfig.username;
	private String pass=DBConfig.password;
	
	//获取连接对象的方法
	public Connection getConnection(){
		//1.加载驱动
		try {
			Class.forName(driver);
			//2.获取连接对象
			conn = DriverManager.getConnection(url,user,pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	//查询
	public ResultSet query(String sql, Object[] obj) {
		//1.获取连接对象
		getConnection();
		try {
			//2.获取PreparedStatement对象
			pst = conn.prepareStatement(sql);
			//3.向sql中的占位符赋值
			for (int i = 0; i < obj.length; i++) {
				pst.setObject(i + 1, obj[i]);
			}
			//4.执行sql返回结果
			rs = pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	//修改
	public int update(String sql, Object[] obj) {
		//1.获取连接对象
		getConnection();
		int res=-1;
		try {
			//2.获取PreparedStatement对象
			pst = conn.prepareStatement(sql);
			//3.向sql中的占位符赋值
			for (int i = 0; i < obj.length; i++) {
				pst.setObject(i + 1, obj[i]);
			}
			//4.执行sql返回结果
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	//关闭	
		public void close() {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			

		}
}
