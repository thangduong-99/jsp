package com.theloc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DAO {

	Connection conn=null;
	public Connection Ketnoi() {
		String bdUrl = "jdbc:mysql://localhost:3306/jsp?useUnicode=true&characterEncoding=UTF-8";
		String dbClass = "com.mysql.jdbc.Driver";

		try {
			Class.forName(dbClass);
			conn = DriverManager.getConnection(bdUrl, "root", "");
			System.out.println("database connected");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
