package es.uniovi.asw.model;

import java.util.List;
import java.util.Map;

import es.uniovi.asw.controller.Filter;

public class Proposal {

	private int id,minimal;
	private Map<String, List<String>> votes;
	private List<Comment> comments;
	private Category category;
	
	public List<Comment> getComments(Filter filter){
		//return filter.filter(this.comments);
		return this.comments;
	}
	
	void delete(){
		// ProposalDAO.delete(this);
	}
}
