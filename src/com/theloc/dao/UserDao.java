package com.theloc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.theloc.model.User;

public class UserDao {
	Connection conn = null;
	PreparedStatement stm = null;
	public boolean checkLogin(String username, String password) {
		DAO dao = new DAO();
		conn = dao.Ketnoi();
		String query = "SELECT * FROM user WHERE username=? AND password=?";

		try {
			stm = conn.prepareStatement(query);

			stm.setString(1, username);
			stm.setString(2, password);

			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				return true;
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean checkSignUp(User user) {
		DAO dao = new DAO();
		conn = dao.Ketnoi();
		String query = "INSERT INTO user(username, password) VALUES (?,?)";
		try {
			PreparedStatement stm = conn.prepareStatement(query);
			stm.setString(1, user.getUserName());
			stm.setString(2, user.getPassWord());
			if(user.getUserName().equals("")||user.getPassWord().equals("")) {
				System.out.println("add False!!!");
				return false;
			}else {
				stm.executeUpdate();

				System.out.println("added person information");
				return true;
			}
		} catch (SQLException e) {
			return false;
		}
	}
}
