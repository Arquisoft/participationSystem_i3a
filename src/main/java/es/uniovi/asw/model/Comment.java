package es.uniovi.asw.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import es.uniovi.asw.model.filtrable.Filtrable;

public class Comment implements Filtrable{

	private int id;
	private String text;
	private Map<String, List<String>> votes;
	private User user;
	private Date date;
	
	void delete(){
		//CommentDAO.delete(this);
	}
}
