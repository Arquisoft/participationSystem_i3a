package es.uniovi.asw.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.model.filtrable.Filtrable;

public class Comment implements Filtrable,Removable{

	private int id;
	private int minimal;
	private String text;
	// option 1
	private Map<String, List<String>> votes;
	// option 2
	//private List<User> positiveVotes, negativeVotes;
	private User user;
	private String date;
	private Proposal proposal;
	
	public Comment(int minimalNumberVotes, User user, Proposal proposal, String text){
		//this.id=ProposalDAO.getNumberOfProposal()+1; ??
		this.minimal = minimalNumberVotes;
		this.votes = new HashMap<String, List<String>>();
		this.votes.put("Positive", new ArrayList<String>());
		this.votes.put("Negative", new ArrayList<String>());
		this.user = user;
		this.proposal = proposal;
		this.text = text;
		this.date = new SimpleDateFormat().format(new Date()); // ??
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

	public int getMinimal() {
		return minimal;
	}

	public String getText() {
		return text;
	}

	public Map<String, List<String>> getVotes() {
		return votes;
	}

	public List<String> getPositiveVotes() {
		return votes.get("Positive");
	}
	
	public List<String> getNegativeVotes() {
		return votes.get("Negative");
	}
	
	public User getUser() {
		return user;
	}

	public String getDate() {
		return date;
	}

	public Proposal getProposal() {
		return proposal;
	}
}
