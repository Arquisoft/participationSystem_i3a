package es.uniovi.asw.menus;

import java.io.IOException;

import es.uniovi.asw.dao.CategoryDao;
import es.uniovi.asw.model.Proposal;
import es.uniovi.asw.model.User;

public class ProposalMenu extends AbstractMenu{

	private static ProposalMenu menu = null;
	
	
	public static ProposalMenu getInstance() {
		if (menu == null)
			menu = new ProposalMenu();
		return menu;		
	}

	public void addProposal(User user){
		try {
			String category = askForCategory();
			
			System.out.println("Please type the title of your proposal");
			
			String title = console.readLine();
			
			System.out.println("Please type the description of your proposal");
			
			String text = console.readLine(); 
					
			Proposal proposal = new Proposal(user, title, category, text);
			
			System.out.println(proposal.toString());
			
			// Meter en base de datos
			// user tiene sólo id y name
			
		} catch (Exception e){
			System.out.println("The proposal cretion was not completed. Try again.");
			return;
		}

	}
	
	public void listProposals(){
		System.out.println("TODO: mostrar todas las propuestas guardadas en la base de datos");
	}
	
	public void voteProposal(){
		System.out.println("TODO: votar una propuesta positivo o negativo");
	}
	
	private ProposalMenu(){		
		this.menuOptions.add("TODO");
	}
	
	private String askForCategory() throws NumberFormatException, IOException{
		String[] categories = CategoryDao.listCategories();
		int theChosen = 0;
		while(true){
			System.out.println("\n----------\nChoose a category (type its number)\n---------");
			for (int n = 0; n < categories.length; n++)
				System.out.println(n+1 + ". " + categories[n]);
			
			theChosen = Integer.parseInt(console.readLine());
			try{
				return categories[theChosen-1];
			} catch(Exception e){
				System.out.println("That's not valid");
			}
		}
	}
}
