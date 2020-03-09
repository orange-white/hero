package com.rsy.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	//�������ݿ�ķ���
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	private String driver=DBConfig.driver;
	private String url=DBConfig.url;
	private String user=DBConfig.username;
	private String pass=DBConfig.password;
	
	//��ȡ���Ӷ���ķ���
	public Connection getConnection(){
		//1.��������
		try {
			Class.forName(driver);
			//2.��ȡ���Ӷ���
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
	
	//��ѯ
	public ResultSet query(String sql, Object[] obj) {
		//1.��ȡ���Ӷ���
		getConnection();
		try {
			//2.��ȡPreparedStatement����
			pst = conn.prepareStatement(sql);
			//3.��sql�е�ռλ����ֵ
			for (int i = 0; i < obj.length; i++) {
				pst.setObject(i + 1, obj[i]);
			}
			//4.ִ��sql���ؽ��
			rs = pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	//�޸�
	public int update(String sql, Object[] obj) {
		//1.��ȡ���Ӷ���
		getConnection();
		int res=-1;
		try {
			//2.��ȡPreparedStatement����
			pst = conn.prepareStatement(sql);
			//3.��sql�е�ռλ����ֵ
			for (int i = 0; i < obj.length; i++) {
				pst.setObject(i + 1, obj[i]);
			}
			//4.ִ��sql���ؽ��
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	//�ر�	
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
