package cucumber.steps;

import org.junit.runner.RunWith;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

//@RunWith(Cucumber.class)
public class CommentSteps {
	
	@Given("^Im a logged user \"([^\"]*)\" with password \"([^\"]*)\"$")
    public void im_a_logged_user_something_with_password_something(String name, String pass) throws Throwable {
        System.out.println("User with name: " + name + " and pass: " + pass);
    }

    @When("^i select a proposal")
    public void i_select_a_proposal(String proposal) throws Throwable {
        System.out.println("proposal: " + proposal);
    }

    @And("^i write \"([^\"]*)\"$")
    public void i_write_something(String comment) throws Throwable {
        System.out.println("comment: ");
    }

    @Then("^it will be published$")
    public void it_will_be_publish() throws Throwable {
        System.out.println("The comment has been published.");
    }
}
