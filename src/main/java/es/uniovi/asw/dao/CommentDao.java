package es.uniovi.asw.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.uniovi.asw.PropReader;
import es.uniovi.asw.model.Comment;
import es.uniovi.asw.model.Proposal;

public class CommentDao {

	private static Connection conn;
	
	public CommentDao() {
		try {
			openConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void openConn() throws SQLException {
		try {
			if (conn == null) {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(PropReader.get("DATABASE_URL"), PropReader.get("DATABASE_USER"),
						PropReader.get("DATABASE_PASS"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int save(Comment comment) {
		try {
			PreparedStatement stmt = conn.prepareStatement(PropReader.get("COMMENT_INSERT"));

			stmt.setInt(1, comment.getUser().getId());
			stmt.setString(2, comment.getText());
			stmt.setString(3, ¡¡fecha!!);
			stmt.setString(4, proposal.getText());
			
			return stmt.executeUpdate();		

		} catch (SQLException e) {
			return 0;		
		}
	}

}
