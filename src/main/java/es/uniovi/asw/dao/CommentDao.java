package es.uniovi.asw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.uniovi.asw.PropReader;
import es.uniovi.asw.kafka.KafkaProducer;
import es.uniovi.asw.model.Comment;

public class CommentDao {

	private static Connection conn;
	private static KafkaProducer kfc;
	public CommentDao() {
		try {
			kfc = new KafkaProducer();
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
			PreparedStatement stmt = conn.prepareStatement(PropReader.get("COMM_INSERT"));
			stmt.setString(1, comment.getText());
			stmt.setInt(2, comment.getUser().getId());
			stmt.setInt(3, comment.getProposal().getId());
			stmt.setDate(4, comment.getDate());
			kfc.SendMessage("Comment", "New Comment");
			return stmt.executeUpdate();		

		} catch (SQLException e) {
			return 0;		
		}
	}
}
