package com.webapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.webapp.DB;
import com.webapp.model.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User findUser(String username, String password) {
		try(Connection conn = DB.connect()) {
			String query = "select * from user where username=" + username + " and password=" + password;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			User user = null;
			while(rs.next()) {
				user = new User(rs.getString("username"), rs.getString("password"));
				user.setId(rs.getInt("id"));
			}
			stmt.close();
			rs.close();
			return user;
		} catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public User getUserById(int id) {
		try(Connection conn = DB.connect()) {
			String query = "select * from user where id=" + id;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			User user = null;
			while(rs.next()) {
				user = new User(rs.getString("username"), rs.getString("password"));
				user.setId(rs.getInt("id"));
			}
			stmt.close();
			rs.close();
			return user;
		} catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
}
