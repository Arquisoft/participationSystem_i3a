package es.uniovi.asw.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import es.uniovi.asw.model.filtrable.Filtrable;

public class Comment implements Filtrable,Removable{

	private int id;
	private String text;
	// option 1
	//private Map<String, List<User>> votes;
	// option 2
	private List<User> positiveVotes, negativeVotes;
	private User user;
	private String date;
	private Proposal proposal;
	
	private String getNow() {
		return Calendar.YEAR + "/" + Calendar.MONTH + "/" + Calendar.DAY_OF_MONTH;
	}
	
	public Comment(User user, Proposal proposal, String text){
		this.positiveVotes = new ArrayList<User>();
		this.negativeVotes = new ArrayList<User>();
		this.user = user;
		this.proposal = proposal;
		this.text = text;
		this.date = getNow();
	}
	
	
	public Comment(User user, Proposal proposal, String text, int id, String Date){
		this.id = id;
		this.positiveVotes = new ArrayList<User>();
		this.negativeVotes = new ArrayList<User>();
		this.user = user;
		this.proposal = proposal;
		this.text = text;
		this.date = Date;
	}
	
	public void AddPositive(User user) {
		positiveVotes.add(user);
	}

	public void AddNegative(User user) {
		negativeVotes.add(user);
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

	public List<User> getPositiveVotes() {
		return positiveVotes;
	}
	
	public List<User> getNegativeVotes() {
		return negativeVotes;
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

	@Override
	public String toString() {
		return "Comment [text=" + text + ", Positive votes=" + Arrays.toString(positiveVotes.toArray()) + ", Negative votes= " + Arrays.toString(negativeVotes.toArray()) +
				", user=" + user + ", date=" + date + "]";
	}
}
