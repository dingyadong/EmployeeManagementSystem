package com.chinasofti.ssm01.jdbc;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, PropertyVetoException {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/weixinServer?useUnicode=true&characterEncoding=UTF-8");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("abc123");
        comboPooledDataSource.setInitialPoolSize(20);//初始化数据库连接池容量
        comboPooledDataSource.setAcquireIncrement(5);//每次申请个数
        comboPooledDataSource.setMaxPoolSize(40);//申请数据库连接池最大容量
        comboPooledDataSource.setMinPoolSize(2);//申请数据库连接池最小容量(剩余量)
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println(connection);

	}
}
