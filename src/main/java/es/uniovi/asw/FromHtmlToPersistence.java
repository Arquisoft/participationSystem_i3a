package es.uniovi.asw;

import es.uniovi.asw.dao.UserDao;
import es.uniovi.asw.model.Category;
import es.uniovi.asw.model.Proposal;
import es.uniovi.asw.model.User;

/**
 * Esta clase engloba todo el pase de la página html hasta la base de datos y Kafka, pasando también por negocio
 * 
 * Por ejemplo, si una persona clica en nueva Proposal, se llama al método newProposal
 * si una persona vota positivamente un proposal/comentario, votePositive(user,proposal/comentario)
 * etc...
 */
public class FromHtmlToPersistence {

	public void addProposal(String username, String title, Category category, String description){
		//create Proposal
		User user = UserDao.getUserByName(username);
		
		Proposal propos = new Proposal(username, title, category, description);
		//check it follows configuration rules
		
		//save on database
		
		//send it through Kafka
	}
}
