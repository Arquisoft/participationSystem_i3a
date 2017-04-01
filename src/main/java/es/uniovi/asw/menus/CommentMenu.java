package es.uniovi.asw.menus;

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
}
