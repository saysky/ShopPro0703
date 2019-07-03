package com.dream.db;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 增删改查
 * 
 * */
public class DBUtils<T> {
	
	private static Connection connection;
	private static PreparedStatement pst;
	private static ResultSet rs;
	private static ResultSetMetaData metaData;
	
	//公共的增删改
	public static int commonOper(String sql,Object...params){
		//update user set username=?,pwd=? where id =?
		try {
			connection = DBManager.getConnection();
			//开启事务
			connection.setAutoCommit(false);
			pst = connection.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				pst.setObject(i+1, params[i]);
			}
			int result = pst.executeUpdate();
			//System.out.println("受影响的行数:"+result);
			//提交事务
			connection.commit();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			if(connection!=null){
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally{
			DBManager.closeAll(pst,connection);
		}
		
		return -1;
	}
	
	/**
	 * 查询集合数据
	 * @return
	 */
	public List<T> getList(String sql,Class<T> clazz,Object...params){
		List<T> list = new ArrayList<>();
		try {
			//得到连接对象
			connection = DBManager.getConnection();
			//得到预编译对象
			pst = connection.prepareStatement(sql);
			//循环给sql中的参数赋值
			for(int i=0;i<params.length;i++){
				pst.setObject(i+1, params[i]);
			}
			//执行查询操作，得到结果集
			rs = pst.executeQuery();
			//得到结果集中列的信息（列的名称，列的个数等）
			metaData = rs.getMetaData();
			//获取列的个数
			int columnCount = metaData.getColumnCount();
			while(rs.next()){
				//实例化对象
				T ins = clazz.newInstance();
				for(int i=1;i<=columnCount;i++){
					//得到resultSet中列的名称
					String columnName = metaData.getColumnName(i);
					//得到列对应的值
					Object value = rs.getObject(i);
					//Field field = clazz.getDeclaredField("name");
					//field.set(user,"zs");
					//通过列名得到属性Field对象
					Field field = clazz.getDeclaredField(columnName);
					//设置一个访问权限
					field.setAccessible(true);
					//通过反射给对象中的属性赋值
					field.set(ins, value);
				}
				//把对象添加到集合中
				list.add(ins);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	/**
	 * 查询单个对象数据
	 * @return
	 */
	public T getSingleInstance(String sql,Class<T> clazz,Object...params){
		try {
			connection = DBManager.getConnection();
			pst = connection.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				pst.setObject(i+1, params[i]);
			}
			rs = pst.executeQuery();
			metaData = rs.getMetaData();
			//获取列的个数
			int columnCount = metaData.getColumnCount();
			if(rs.next()){
				T ins = clazz.newInstance();
				for(int i=1;i<=columnCount;i++){
					String columnName = metaData.getColumnName(i);
					Object value = rs.getObject(i);
					//Field field = clazz.getDeclaredField("name");
					//field.set(user,"zs");
					Field field = clazz.getDeclaredField(columnName);
					//设置一个访问权限
					field.setAccessible(true);
					field.set(ins, value);
				}
				return ins;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static int getCount(String sql,Object...params){
		int count = 0;
		try {
			connection = DBManager.getConnection();
			//开启事务
			connection.setAutoCommit(false);
			pst = connection.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				pst.setObject(i+1, params[i]);
			}
			rs = pst.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
			//提交事务
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if(connection!=null){
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally{
			DBManager.closeAll(pst,connection);
		}
		
		return count;
	}
	
}
