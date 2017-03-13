package es.uniovi.asw.model;

public class User {

	private int id;
	private String name,email;
	private boolean gender;
	
	public User(String name, String email, boolean gender) {
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
	 * true for men, false for women
	 * @return
	 */
	public boolean isGender() {
		return gender;
	}
	
	
}
