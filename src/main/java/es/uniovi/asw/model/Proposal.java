package es.uniovi.asw.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.PropReader;
import es.uniovi.asw.dao.ProposalDao;
import es.uniovi.asw.filters.Filter;
import es.uniovi.asw.model.filtrable.Filtrable;

public class Proposal implements Filtrable {

	private int id;
	private int minimal;
	// option 1
	//private Map<String, List<User>> votes;
	//option 2
	private List<User> positiveVotes, negativeVotes;
	private List<Filtrable> comments;
	private String category;
	private String text;
	private User user;
	private String title;

	public Proposal(int minimalNumberVotes, User user, String title, String category, String text) {
		this.id=ProposalDao.getNewIdNumber()+1;
		this.minimal = minimalNumberVotes;
		//this.votes = new HashMap<String, List<User>>();
		//votes.put("Positive", new ArrayList<User>());
		//votes.put("Negative", new ArrayList<User>());
		this.positiveVotes = new ArrayList<User>();
		this.negativeVotes = new ArrayList<User>();
		this.comments = new ArrayList<Filtrable>();
		this.category = category;
		this.text = text;
		this.user = user;
		this.title = title;
	}


	public Proposal(User user, String title, String category, String text) {
		this(Integer.parseInt(PropReader.get("minimumVotesNumber")), user, title, category, text);
	}

	public void AddPositive(User user) {
		positiveVotes.add(user);
	}

	public void AddNegative(User user) {
		negativeVotes.add(user);
	}

	/**
	 * returns the list of comments of the proposal. It may be filtered by one
	 * of the predefined filters
	 * 
	 * @param filter
	 *            null, Category, Chronological, NAllowedWords, Popularity,
	 *            WordFinder
	 * @return
	 */
	public List<Filtrable> getComments(Filter filter) {
		return filter == null ? getComments() : filter.filter(this.comments);
	}

	/*
	 * Public?
	 */
	public int delete() {
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

	public Map<String, List<User>> getVotes() {
		Map<String, List<User>> votes = new HashMap<String, List<User>>();
		votes.put("positive", this.getPositiveVotes());
		votes.put("negative", this.getNegativeVotes());
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

	@Override
	public String toString() {
		return "Proposal [Positive votes=" + positiveVotes.size() + ", Negative votes = " + negativeVotes.size() 
				+ ", comments=" + comments.size()	+ ", category=" + category + ", text=" + text + ", user=" + user.getName() + "]";
	}

	public String getTitle() {
		return this.title;
	}


	public void addComment(Comment comment) {
		this.comments.add(comment);
	}
	
	public List<User> getPositiveVotes() {
		return positiveVotes;
	}

	public List<User> getNegativeVotes() {
		return negativeVotes;
	}


	public void SetID(int int1) {
		this.id = int1;
	}


	public void setComments(List<Filtrable> list) {
		this.comments = list;
	} 
 
}
