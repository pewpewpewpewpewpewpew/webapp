package com.webapp.dao;

import com.webapp.model.User;

public interface UserDao {
	
	User getUserById(int id);
	User findUser(String username, String password);
}
