package es.uniovi.asw.model;

import java.util.List; 

public class Util {

	public int delete (Proposal proposal){
		//return proposal.delete();
		return 0;
	}
	public int delete (Comment comment){
		//return comment.delete();
		return 0;
	}
	public int delete (List<Removable> listRemovables){
		int correctDeletion = 1;
		for (Removable rem : listRemovables)
			if (rem.delete() == 0)
				correctDeletion = 0;
		return correctDeletion;
	}
	
	public int add(Proposal proposal){
		
		return 0;
	}
	public int add (Comment comment){
		
		return 0;
	}

	
	
}
