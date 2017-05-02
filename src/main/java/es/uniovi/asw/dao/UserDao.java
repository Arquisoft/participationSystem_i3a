package es.uniovi.asw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.asw.model.User;
import es.uniovi.asw.PropReader;

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
		try {
			PreparedStatement pstmt = conn.prepareStatement(PropReader.get("USER_BY_NAME"));
			pstmt.setInt(1, Integer.parseInt(userName));
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()){
				User res = new User(rs.getString("Name"), rs.getInt("ID"));
				//res.setGender(rs.getInt("Gender") == 0 ? false :  true);
				return res;
			}
		} catch (SQLException e) {
			return null;
		}
		return null;
	}
	
	
	public static User getUserByID(int ID) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(PropReader.get("USER_BY_ID"));
			pstmt.setInt(1, ID);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()){
				User res = new User(rs.getString("Name"), rs.getInt("ID"));
				//res.setGender(rs.getInt("Gender") == 0 ? false :  true);
				return res;
			}
		} catch (SQLException e) {
			return null;
		}
		return null;
	}

}
