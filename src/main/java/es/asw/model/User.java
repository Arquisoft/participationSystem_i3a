package es.asw.model;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;

public class User {

	private static final long serialVersionUID = 1L;
	// Log
	private static final Logger LOG = LoggerFactory.getLogger(User.class);
	@Id
	private String id;

	private String name;
	private Integer age;
	private String password;
	private boolean isAdmin = false;

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {

	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public User(String name, Integer age) {
		LOG.info("Creating user " + name + ". age: " + age);
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public String getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		User user = (User) o;

		if (id != null ? !id.equals(user.id) : user.id != null)
			return false;
		if (name != null ? !name.equals(user.name) : user.name != null)
			return false;
		return age != null ? age.equals(user.age) : user.age == null;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (age != null ? age.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "User{" + "id='" + id + '\'' + ", name='" + name + '\''
				+ ", age=" + age + '}';
	}

	public Collection<?> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getUsername() {
		return name;
	}
	
	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}
}