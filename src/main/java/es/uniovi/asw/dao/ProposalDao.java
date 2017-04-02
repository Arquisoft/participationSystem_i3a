package es.uniovi.asw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.PropReader;
import es.uniovi.asw.model.Proposal;
import es.uniovi.asw.model.User;

public class ProposalDao {
	private static Connection conn;

	public ProposalDao() {
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

	public List<Proposal> GetProposalsByMin(int min) {
		ArrayList<Proposal> ret = new ArrayList<Proposal>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(PropReader.get("PROPOSAL_BY_MINIMAL"));
			pstmt.setInt(1, min);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				UserDao.getUserByName("");
				Proposal prop = new Proposal(UserDao.getUserByID(rs.getInt("USERID")), rs.getString("Title"),
						rs.getString("Category"), rs.getString("Text"));
				User res = new User(rs.getString("Name"), rs.getInt("ID"));
				res.setGender(rs.getInt("Gender") == 0 ? false : true);
				ret.add(prop);
			}
		} catch (SQLException e) {
			return null;
		}
		return ret;
	}
	
	public List<Proposal> GetProposalByUser(int UserID) {
		ArrayList<Proposal> ret = new ArrayList<Proposal>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(PropReader.get("PROPOSAL_BY_USER_ID"));
			pstmt.setInt(1, UserID);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				UserDao.getUserByName("");
				Proposal prop = new Proposal(UserDao.getUserByID(rs.getInt("USERID")), rs.getString("Title"),
						rs.getString("Category"), rs.getString("Text"));
				User res = new User(rs.getString("Name"), rs.getInt("ID"));
				res.setGender(rs.getInt("Gender") == 0 ? false : true);
				ret.add(prop);
			}
		} catch (SQLException e) {
			return null;
		}
		return ret;
	}
}
