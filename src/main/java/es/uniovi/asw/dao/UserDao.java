package es.uniovi.asw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		try {
			PreparedStatement pstmt = conn.prepareStatement(PropReader.get("USER_BY_NAME"));
<<<<<<< HEAD
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()){
				return new User(rs.getString("Fname"), rs.getInt("id"));
			}
		} catch (SQLException e) {
			return null;
		}
		return null;
	}
	
	public static User getUserById(int id) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(PropReader.get("USER_BY_ID"));
=======
			pstmt.setString(1, userName);
			ResultSet rs = pstmt.executeQuery();
>>>>>>> 0f94619c625262d4abb641d4cc6b50b8d17b6cca
			
			if (rs.next()){
				User res = new User(rs.getString("Name"), rs.getInt("ID"));
				res.setGender(rs.getInt("Gender") == 0 ? false :  true);
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
				res.setGender(rs.getInt("Gender") == 0 ? false :  true);
				return res;
			}
		} catch (SQLException e) {
			return null;
		}
		return null;
	}

}
