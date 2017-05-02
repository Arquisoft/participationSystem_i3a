package es.uniovi.asw.menus;
;

public interface Menu {

	public Menu chooseOption(int option, es.asw.model.User currentUser);
	public void showOptions();
}
 