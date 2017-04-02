package es.uniovi.asw.dao;

import es.uniovi.asw.PropReader;
import es.uniovi.asw.model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserDao {
	private static Connection conn;
	
	public UserDao() {
		try {
			openConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void openConn() throws SQLException {
		try {
		if(conn == null) {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(PropReader.get("DATABASE_URL"),
					PropReader.get("DATABASE_USER"), PropReader.get("DATABASE_PASS"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static User getUserByName(String userName) {
		return null;
		//TODO
	}

}
