package com.kunming.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	//选择后缀名为c3p0的
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	//获取数据源对象，DataSource对象,导包要选择sql的
	public static DataSource getDataSource() {
		return dataSource;
	}
	//获取连接
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		Connection conn = JdbcUtils.getConnection();
		System.out.println(conn);
	}
	
}
