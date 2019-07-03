package com.dream.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBManager {
	
	private static DataSource dataSource = null;
	
	static {
		dataSource = new ComboPooledDataSource();
	}
	
	//连接
	public static Connection getConnection() {
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	//关闭连接
	public static void closeAll(AutoCloseable...autoCloseables) {
		for (AutoCloseable autoCloseable : autoCloseables) {
			if (autoCloseable!=null) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
