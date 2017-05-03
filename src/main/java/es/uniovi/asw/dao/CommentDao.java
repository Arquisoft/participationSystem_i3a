package es.uniovi.asw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.PropReader;
import es.uniovi.asw.kafka.KafkaProducer; 
import es.uniovi.asw.model.Comment;
import es.uniovi.asw.model.Proposal;
import es.uniovi.asw.model.filtrable.Filtrable;

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
			String[] notAllowed = PropReader.get("notAllowedWords").toString().split(",");
			for(String s : notAllowed) {
				if(comment.getContent().contains(s))
					throw new IllegalArgumentException("Word not allowed: " + s);
			}
			PreparedStatement stmt = conn.prepareStatement(PropReader.get("COMM_INSERT"));
			stmt.setString(1, comment.getContent());
			stmt.setString(2, comment.getUser().getId()); 
			stmt.setString(3, comment.getIdProposal());
			//stmt.setDate(4, comment.getDate());
			kfc.SendMessage("Comment", "New Comment");
			return stmt.executeUpdate();		

		} catch (SQLException e) {
			return 0;		
		}
	}
	
	public static List<Comment> getCommentsOf(Proposal proposal){
		try { 
			PreparedStatement stmt = conn.prepareStatement(PropReader.get("COMMENT_BY_PROPOSAL"));
			stmt.setString(1, proposal.getId());
			
			ResultSet rs = stmt.executeQuery();		
			
			List<Comment> comments = new ArrayList<Comment>();
			while(rs.next()){
				comments.add(new Comment(null, rs.getString("Text")));
			}
			
			return comments;
			
		} catch (SQLException e) {
			return null;		
		}
	}
}
