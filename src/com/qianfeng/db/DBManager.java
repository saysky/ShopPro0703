package com.qianfeng.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/***
 * 数据库管理类，负责创建连接和关闭资源
 * 
 * @author Administrator
 *
 */
public class DBManager {

	private static DataSource dataSource = null;

	static {
		dataSource = new ComboPooledDataSource();
	}

	// 得到连接对象
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	// 关闭资源
	public static void closeAll(AutoCloseable... autoCloseables) {
		for (AutoCloseable autoCloseable : autoCloseables) {
			if (autoCloseable != null) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
