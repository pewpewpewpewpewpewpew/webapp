package com.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webapp.DB;
import com.webapp.dao.UserDao;
import com.webapp.dao.UserDaoImpl;
import com.webapp.model.User;
import com.webapp.service.UserService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/frontend/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        userService = new UserService();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(!userService.isLoggedIn(request.getSession())) {
			User user = userService.findUser(username, password);
			if(user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
			} else {
				request.setAttribute("message", "Invalid username/password combination!");
			}
		} else {
			response.sendRedirect("home");			
		}
	}

}
