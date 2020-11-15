/**
 * 
 */
package com.webapp.service;

import javax.servlet.http.HttpSession;

import com.webapp.dao.UserDao;
import com.webapp.dao.UserDaoImpl;
import com.webapp.model.User;

/**
 * @author ashish.kumar
 *
 */
public class UserService {
	
	private UserDao userDao = null;
	
	public UserService() {
		userDao = new UserDaoImpl();
	}
	
	public boolean isLoggedIn(HttpSession session) {
		if(session.getAttribute("user") == null) return false;
		else return true;
	}
	
	public User findUser(String username, String password) {
		return userDao.findUser(username, password);
	}
	
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}
}
