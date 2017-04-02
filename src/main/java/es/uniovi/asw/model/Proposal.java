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
	private Map<String, List<User>> votes;
	// option 2
	// private List<User> positiveVotes, negativeVotes;
	private List<Filtrable> comments;
	private String category;
	private String text;
	private User user;
	private String title;

	public Proposal(int minimalNumberVotes, User user, String category, String text) {
		this.id=ProposalDao.getNewIdNumber()+1;
		this.minimal = minimalNumberVotes;
		this.votes = new HashMap<String, List<User>>();
		votes.put("Positive", new ArrayList<User>());
		votes.put("Negative", new ArrayList<User>());
		this.comments = new ArrayList<Filtrable>();
		this.category = category;
		this.text = text;
		this.user = user;
	}


	public Proposal(User user, String title, String category, String text) {
		this.minimal = Integer.parseInt(PropReader.get("minimumVotesNumber"));
		this.votes = new HashMap<String, List<User>>();
		votes.put("Positive", new ArrayList<User>());
		votes.put("Negative", new ArrayList<User>());
		this.comments = new ArrayList<Filtrable>();
		this.category = category;
		this.text = text;
		this.user = user;
		this.title = title;
	}

	public void AddPositive(User user) {
		votes.get("Positive").add(user);
	}

	public void AddNegative(User user) {
		votes.get("Negative").add(user);
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
	
	public List<User> getPositiveVotes() {
		return votes.get("Positive");
	}

	public List<User> getNegativeVotes() {
		return votes.get("Negative");
	}


	public void SetID(int int1) {
		this.id = int1;
	}


	public void setComments(List<Filtrable> list) {
		this.comments = list;
	} 
 
}
