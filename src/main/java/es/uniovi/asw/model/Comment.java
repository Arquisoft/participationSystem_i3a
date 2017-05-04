package es.uniovi.asw.model;

<<<<<<< HEAD
import org.springframework.data.annotation.Id;

import es.asw.model.User;

public class Comment extends AbstractVotable {

	private static int actualId = 0;

	@Id
	private String id;
	private User user; 
	private String content;
	private String idProposal;

	public Comment() {
		actualId++;
		this.id = actualId + "";
	}

	public Comment(User user, String content) {
		super();
		this.user = user;
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public String getContent() {
		return content;
	}

	public String getId() {
		return id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdProposal() {
		return idProposal;
	}

	public void setIdProposal(String idProposal) {
		this.idProposal = idProposal;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Comment comment = (Comment) o;

		if (id != null ? !id.equals(comment.id) : comment.id != null)
			return false;
		if (user != null ? !user.equals(comment.user) : comment.user != null)
			return false;
		return content != null ? content.equals(comment.content)
				: comment.content == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (user != null ? user.hashCode() : 0);
		result = 31 * result + (content != null ? content.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Comment{" + "id='" + id + '\'' + ", user=" + user
				+ ", content='" + content + '\'' + '}';
	}

	public int delete() {
		// TODO Auto-generated method stub
		return 0;
=======
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
>>>>>>> branch 'master' of https://github.com/Arquisoft/participationSystem_i3a
	}
}
