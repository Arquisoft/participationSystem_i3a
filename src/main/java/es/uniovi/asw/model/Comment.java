package es.uniovi.asw.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.model.filtrable.Filtrable;

public class Comment implements Filtrable,Removable{

	private int id;
	private String text;
	// option 1
	private Map<String, List<User>> votes;
	// option 2
	//private List<User> positiveVotes, negativeVotes;
	private User user;
	private java.sql.Date date;
	private Proposal proposal;
	
	public Comment(User user, Proposal proposal, String text){
		//this.id=ProposalDAO.getNumberOfProposal()+1; ??
		this.votes = new HashMap<String, List<User>>();
		this.votes.put("Positive", new ArrayList<User>());
		this.votes.put("Negative", new ArrayList<User>());
		this.user = user;
		this.proposal = proposal;
		this.text = text;
		Date dt = new Date();
		this.date = new java.sql.Date(dt.getDay(), dt.getMonth(), dt.getYear());
	}
	
	public void AddPositive(User user) {
		votes.get("Positive").add(user);
	}

	public void AddNegative(User user) {
		votes.get("Negative").add(user);
	}
	
	/*
	 * Public ?
	 */
	public int delete(){
		// return CommentDAO.delete(this);
		return 0;
	}

	public int getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public Map<String, List<User>> getVotes() {
		return votes;
	}

	public List<User> getPositiveVotes() {
		return votes.get("Positive");
	}
	
	public List<User> getNegativeVotes() {
		return votes.get("Negative");
	}
	
	public User getUser() {
		return user;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public Proposal getProposal() {
		return proposal;
	}
}
