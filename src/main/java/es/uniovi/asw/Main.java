package es.uniovi.asw;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import es.uniovi.asw.dao.UserDao;
import es.uniovi.asw.menus.MainMenu;
import es.uniovi.asw.menus.Menu;
import es.uniovi.asw.model.User;

public class Main {

	private static BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
	private static User currentUser = null;

	public static void main (String[] args){
		logUser();
		/* Users:
		 * ID		NAME					EMAIL					  GENDER
		 * 1		Jorge Tarari		jorge@example.cpm				1
		 *1679344	Andrei Manu			uo240704@uniovi.es				1
		 *9940449	Ana Torres Pardo	ana@example.com					0
		 *19160962	Luis Lopez Fernando	luis@example.com				1
		 *90500084	Juan Torres Pardo	juan@example.com				1
		 */
		///currentUser = new User("Andrei Manu", 1679344);
		mainMenu();  
	}
	
	private static User logUser(){
		new UserDao();
		try {
			while (currentUser == null) {
				System.out.println("Log with a valid user (National ID)");
				currentUser = UserDao.getUserByID(Integer.parseInt(console.readLine()));
			}
		} catch (IOException e) {
			currentUser = null;
		}
		
		return currentUser;
	}
	
	private static void mainMenu(){
		String option = "";
		Menu currentMenu = MainMenu.getInstance();
		
		while (!"exit".equals(option)){
			System.out.println("");
			currentMenu.showOptions();
			try{  
				option = console.readLine();
				Menu newMenu = currentMenu.chooseOption(Integer.parseInt(option), currentUser);
				currentMenu = (newMenu == null) ? currentMenu:newMenu;
			} catch (IllegalArgumentException e){
				if (!"exit".equals(option))
					System.out.println("That's not a valid option");
			} catch (Exception e){
				System.out.println("Something went wrong");
			}
		}
		
		System.out.println("Bye!");
	}
}