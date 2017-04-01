package es.uniovi.asw.menus;

public class ProposalMenu extends AbstractMenu{

	private static ProposalMenu menu = null;
	
	public static ProposalMenu getInstance() {
		if (menu == null)
			menu = new ProposalMenu();
		return menu;		
	}

	public void addProposal(){
		System.out.println("TODO: pedir datos al usuario (categoría, título y texto)  y añadir nueva propuesta");
	}
	
	public void listProposals(){
		System.out.println("TODO: mostrar todas las propuestas guardadas en la base de datos");
	}
	
	public void voteProposal(){
		System.out.println("TODO: votar una propuesta positivo o negativo");
	}
}
