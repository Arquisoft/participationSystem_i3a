package cucumber.steps;

import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import es.uniovi.asw.Main;

@SuppressWarnings("deprecation")
@ContextConfiguration(classes = Main.class, loader = SpringApplicationContextLoader.class)
@IntegrationTest
@WebAppConfiguration
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
