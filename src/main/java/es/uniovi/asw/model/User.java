package es.uniovi.asw.model;

public class User {

	private int id;
	private String name;
	private String email;
	private boolean gender;
	
	public User(String name, String email, boolean gender) {
		//this.id=UserDAO.getNumberOfUsers()+1;
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	/**
	 * @return true for men, false for women
	 */
	public boolean isGender() {
		return gender;
	}
	
	
}
