package es.uniovi.asw.menus;

import es.uniovi.asw.dao.CommentDao;
import es.uniovi.asw.dao.ProposalDao;
import es.uniovi.asw.model.Comment;
import es.uniovi.asw.model.Proposal;
import es.uniovi.asw.model.User;

public class CommentMenu extends AbstractMenu{

	private static CommentMenu menu = null;
	
	public static CommentMenu getInstance(){
		if (menu == null)
			menu = new CommentMenu();
		return menu;
	}
	
	public void voteComment(){
		System.out.println("TODO: votar un comentario positivo o negativo");
	}
	
	private CommentMenu(){
		this.menuOptions.add("TODO");
	}

	public void commentProposal(User currentUser) {
		try {
			System.out.println("Please choose which proposal to comment");

			Proposal propos = ProposalDao.getAllProposals().get(Integer.parseInt(console.readLine()));
			
			System.out.println("You've chosen " + propos.getTitle());
			System.out.println("Write your comment:");

			Comment comment = new Comment(currentUser, propos, console.readLine());
			
			propos.addComment(comment);
			
			System.out.println(propos.toString());
			System.out.println(propos.getComments().get(0).toString());
			
			CommentDao.save(comment);
			
		} catch (Exception e){
			System.out.println("That's not valid");
		}
	}
}
