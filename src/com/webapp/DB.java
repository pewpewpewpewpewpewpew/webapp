/**
 * 
 */
package com.webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ashish.kumar
 *
 */
public class DB {
	
	public static final String URL = "jdbc:sqlserver://server:1433;DatabaseName=webapp";
	
	public static Connection connect() throws SQLException, ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(URL);
	}
}
