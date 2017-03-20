package es.uniovi.asw.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.controller.Filter;
import es.uniovi.asw.model.filtrable.Filtrable;

public class Proposal implements Filtrable{

	private int id,minimal;
	// option 1
	private Map<String, List<String>> votes;
	// option 2
	//private List<User> positiveVotes, negativeVotes;
	private List<Filtrable> comments;
	private Category category;
	private String text;
	private User user;
	

	public Proposal(int minimalNumberVotes, User user, Category category, String text){
		//this.id=ProposalDAO.getNumberOfProposal()+1; ??
		this.minimal = minimalNumberVotes;
		this.votes = new HashMap<String, List<String>>();
		this.comments = new ArrayList<Filtrable>();
		this.category = category;
		this.text = text;
		this.user = user;
	}
	
	public List<Filtrable> getComments(Filter filter){
		return filter == null ? getComments() : filter.filter(this.comments);
	}
	
	/*
	 * Public?
	 */
	public int delete(){
		// return ProposalDAO.delete(this);
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

	public List<Filtrable> getComments() {
		return comments;
	}

	public Category getCategory() {
		return category;
	}
	
	public User getUser() {
		return user;
	}
}
