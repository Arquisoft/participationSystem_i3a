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

			while (rs.next()) {
				UserDao.getUserByName("");
				Proposal prop = new Proposal(UserDao.getUserByID(rs.getInt("USERID")), rs.getString("Title"),
						rs.getString("Category"), rs.getString("Text"));
				User res = new User(rs.getString("Name"), rs.getInt("ID"));
				res.setGender(rs.getInt("Gender") == 0 ? false : true);
				VoteDao.SetVotes(prop);
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
			while (rs.next()) {
				Proposal prop = new Proposal(UserDao.getUserByID(rs.getInt("USERID")), rs.getString("Title"),
						rs.getString("Category"), rs.getString("Text"));
				User res = new User(rs.getString("Name"), rs.getInt("ID"));
				res.setGender(rs.getInt("Gender") == 0 ? false : true);
				VoteDao.SetVotes(prop);
				ret.add(prop);
			}
		} catch (SQLException e) {
			return null;
		}
		return ret;
	}
	
	public static List<Proposal> getAllProposals() {
		try {
			PreparedStatement pstmt = conn.prepareStatement(PropReader.get("PROPOSAL_ALL"));
			
			ResultSet rs = pstmt.executeQuery();
			
			List<Proposal> propos = new ArrayList<Proposal>();
			
			while (rs.next()){
				Proposal prop = new Proposal(UserDao.getUserByID(rs.getInt("USERID")),
										rs.getString("Title"),rs.getString("Category"),rs.getString("text"));
				prop.SetID(rs.getInt("ID"));
				VoteDao.SetVotes(prop);
				propos.add(prop);
			} 
			return propos;
		} catch (SQLException e) {
			return null;
		}
	}
	
	private static boolean exists(Proposal proposal) {
		try {
			PreparedStatement stmt = conn.prepareStatement(PropReader.get("PROPOSAL_EXISTS"));
			stmt.setInt(1, proposal.getId());
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
				return true;
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public static int save(Proposal proposal) {
		
		try {
			if(exists(proposal)) {
				VoteDao.SaveVotes(proposal);
				return 1;
			}
			
			PreparedStatement stmt = conn.prepareStatement(PropReader.get("PROPOSAL_INSERT"));

			stmt.setInt(1, proposal.getMinimal());
			stmt.setString(2, proposal.getText());
			stmt.setInt(3, proposal.getUser().getId());
			stmt.setString(4, proposal.getTitle());
			stmt.setString(5, proposal.getCategory());
			VoteDao.SaveVotes(proposal);
			return stmt.executeUpdate();		

		} catch (SQLException e) {
			return 0;		
		}
	}
	
		public List<Proposal> GetProposalByCategory(String category) {
		ArrayList<Proposal> ret = new ArrayList<Proposal>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(PropReader.get("PROPOSAL_BY_CATEGORY"));
			pstmt.setString(1, category);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Proposal prop = new Proposal(UserDao.getUserByID(rs.getInt("USERID")), rs.getString("Title"),
						rs.getString("Category"), rs.getString("Text"));
				User res = new User(rs.getString("Name"), rs.getInt("ID"));
				res.setGender(rs.getInt("Gender") == 0 ? false : true);
				VoteDao.SetVotes(prop);
				ret.add(prop);
			}
		} catch (SQLException e) {
			return null;
		}
		return ret;
	}

		public static int getNewIdNumber() {
			try {
				PreparedStatement stmt = conn.prepareStatement(PropReader.get("PROPOSAL_NEW_ID"));
				
				ResultSet rs = stmt.executeQuery();
				
			if(rs.next())
				return rs.getInt(1);
			
			return 0;
				
			} catch (SQLException e) {
				return 0;		
			}
		}
}
