package es.uniovi.asw.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.PropReader;
import es.uniovi.asw.filters.Filter;
import es.uniovi.asw.model.filtrable.Filtrable;

public class Proposal implements Filtrable{

	private int id;
	private int minimal;
	// option 1
	private Map<String, List<String>> votes;
	// option 2
	//private List<User> positiveVotes, negativeVotes;
	private List<Filtrable> comments;
	private String category;
	private String text;
	private User user;
	private String title;

//	public Proposal(int minimalNumberVotes, User user, String category, String text){
//		//this.id=ProposalDAO.getNumberOfProposal()+1; ??
//		this.minimal = minimalNumberVotes;
//		this.votes = new HashMap<String, List<String>>();
//		this.comments = new ArrayList<Filtrable>();
//		this.category = category;
//		this.text = text;
//		this.user = user;
//	}
	
	public Proposal(User user, String title, String category, String text) {
		this.minimal = Integer.parseInt(PropReader.get("minimumVotesNumber"));
		this.votes = new HashMap<String, List<String>>();
		this.comments = new ArrayList<Filtrable>();
		this.category = category;
		this.text = text;
		this.user = user;
		this.title = title;
	}


	/**
	 * returns the list of comments of the proposal. It may be filtered by one of the predefined filters
	 * @param filter null, Category, Chronological, NAllowedWords, Popularity, WordFinder
	 * @return
	 */
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

	public String getCategory() {
		return category;
	}
	
	public User getUser() {
		return user;
	}
	public void SetUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Proposal [id=" + id + ", minimal=" + minimal + ", votes=" + votes + ", comments=" + comments
				+ ", category=" + category + ", text=" + text + ", user=" + user + "]";
	}


	public String getTitle() {
		return this.title;
	}


	public void addComment(Comment comment) {
		this.comments.add(comment);
	}
	
}
