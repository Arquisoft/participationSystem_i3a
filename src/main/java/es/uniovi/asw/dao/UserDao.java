package es.uniovi.asw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.uniovi.asw.PropReader;
import es.uniovi.asw.model.User;

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
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static User getUserByName(String userName) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(PropReader.get(""));
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()){
				return new User(rs.getString("Fname"), rs.getInt("id"));
			}
		} catch (SQLException e) {
			return null;
		}
		return null;
	}

}
