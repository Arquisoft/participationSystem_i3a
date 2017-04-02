package es.uniovi.asw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.PropReader;
import es.uniovi.asw.model.Comment;
import es.uniovi.asw.model.Proposal;
import es.uniovi.asw.model.User;

public class VoteDao {
	private static Connection conn;

	public VoteDao() {
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

	public static void SetVotes(Proposal prop) {
		try {
			PreparedStatement pstmt = conn.prepareStatement(PropReader.get("VOTE_PROP"));
			pstmt.setInt(1, prop.getId());
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getInt("Type") == 1)
					prop.AddPositive(UserDao.getUserByID(rs.getInt("VotUserID")));
				else
					prop.AddNegative(UserDao.getUserByID(rs.getInt("VotUserID")));

			}
		} catch (SQLException e) {
			return;
		}
	}

	public static int SaveVotes(Comment com) {
		List<User> pos = com.getPositiveVotes();
		List<User> neg = com.getNegativeVotes();
		for (User us : pos) {
			InsertVotesCom(com.getId(), us.getId(), 1);
		}
		for (User us : neg) {
			InsertVotesCom(com.getId(), us.getId(), 0);
		}
	}
	private static int InsertVotesCom(int PropID, int UserID, int Type) {
		try {
			PreparedStatement stmt = conn.prepareStatement(PropReader.get("VOTE_INSERT_COMM"));
			stmt.setInt(1, PropID);
			stmt.setInt(2, UserID);
			stmt.setInt(3, Type);
			return stmt.executeUpdate();

		} catch (SQLException e) {
			return 0;
		}
	}
	public static void SaveVotes(Proposal prop) {
		List<User> pos = prop.getPositiveVotes();
		List<User> neg = prop.getNegativeVotes();
		for (User us : pos) {
			InsertVotesProp(prop.getId(), us.getId(), 1);
		}
		for (User us : neg) {
			InsertVotesProp(prop.getId(), us.getId(), 0);
		}
	}

	private static int InsertVotesProp(int PropID, int UserID, int Type) {
		try {
			PreparedStatement stmt = conn.prepareStatement(PropReader.get("VOTE_INSERT"));
			stmt.setInt(1, PropID);
			stmt.setInt(2, UserID);
			stmt.setInt(3, Type);
			return stmt.executeUpdate();

		} catch (SQLException e) {
			return 0;
		}
	}
}
