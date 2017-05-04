package cucumber.steps;

import java.util.List;

import org.junit.runner.RunWith;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

//@RunWith(Cucumber.class)
public class LoginSteps {

	  @Given("^a list of users:$")
	  public void a_list_of_users(List<User> users) throws Throwable {
	    for (User u: users) {
	      System.out.println("Inserting user..." + u.name + " - " + u.password);
	    }
	  }
	
	  @When("^I login with name \"(.+)\" and password \"(.+)\"$")
	  public void i_login_with_name_and_password(String name, String password) throws Throwable {
	    System.out.println("Login with values..." + name + " - " + password);
	  }
	
	  @Then("^I enter in session$")
	  public void i_receive_a_welcome_message() throws Throwable {
		  System.out.println("Wellcome value received");
	  }
	  
	  public static class User {
	    private String name;
	    private String password;
	  }
}