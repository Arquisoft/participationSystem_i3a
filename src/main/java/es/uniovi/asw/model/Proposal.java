package es.uniovi.asw.model;

<<<<<<< HEAD
import java.util.ArrayList; 
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.annotation.Id;

import es.asw.model.User;
import es.asw.model.*;

public class Proposal extends AbstractVotable {

	@Id
	private String id;

	private User author;
	private HashMap<String, Comment> comments = new HashMap<String, Comment>();
	private boolean isAccepted;
	private String category;
	private String title;
	private String content;
	private Date expirationDate;

	public void setId(String id) {
		this.id = id;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public void setComments(HashMap<String, Comment> comments) {
		this.comments = comments;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Proposal() {
		setExpirationDate();
	}

	public Proposal(User author, String category, String title,
			String content) {
		setExpirationDate();
		this.author = author;
		this.category = category;
		this.title = title;
		this.content = content;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public User getAuthor() {
		return author;
	}

	public HashMap<String, Comment> getComments() {
		return comments;
	}

	public List<Comment> getCommentsList() {

		return new ArrayList<Comment>(comments.values());

	}

	public String getCategory() {
		return category;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getId() {
		return id;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	private void setExpirationDate() {
		this.expirationDate = DateUtils.addDays(new Date(), Configuration
				.getInstance().getExpirationDays());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Proposal proposal = (Proposal) o;

		if (isAccepted != proposal.isAccepted)
			return false;
		if (id != null ? !id.equals(proposal.id) : proposal.id != null)
			return false;
		if (author != null ? !author.equals(proposal.author)
				: proposal.author != null)
			return false;
		if (comments != null ? !comments.equals(proposal.comments)
				: proposal.comments != null)
			return false;
		if (category != null ? !category.equals(proposal.category)
				: proposal.category != null)
			return false;
		if (title != null ? !title.equals(proposal.title)
				: proposal.title != null)
			return false;
		if (content != null ? !content.equals(proposal.content)
				: proposal.content != null)
			return false;
		return expirationDate != null ? expirationDate.equals(
				proposal.expirationDate) : proposal.expirationDate == null;

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (author != null ? author.hashCode() : 0);
		result = 31 * result + (comments != null ? comments.hashCode() : 0);
		result = 31 * result + (isAccepted ? 1 : 0);
		result = 31 * result + (category != null ? category.hashCode() : 0);
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (content != null ? content.hashCode() : 0);
		result = 31 * result + (expirationDate != null ? expirationDate
				.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Proposal{" + "id='" + id + '\'' + ", author=" + author
				+ ", comments=" + comments + ", isAccepted=" + isAccepted
				+ ", category='" + category + '\'' + ", title='" + title + '\''
				+ ", content='" + content + '\'' + ", expirationDate="
				+ expirationDate + '}';
	}

	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}
=======
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
		return "Proposal [Positive votes=" + votes.get("Positive").size() + ", Negative votes = " + votes.get("Negative").size() 
				+ ", comments=" + comments.size()	+ ", category=" + category + ", text=" + text + ", user=" + user.getName() + "]";
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
 
>>>>>>> branch 'master' of https://github.com/Arquisoft/participationSystem_i3a
}
