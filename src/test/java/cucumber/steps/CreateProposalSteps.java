package cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//@RunWith(Cucumber.class)
public class CreateProposalSteps {

	@Given("^Im a logged user with name \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void im_a_logged_user(String name,String pass) throws Throwable {
       System.out.println("User with name: " + name + " and password: " + pass);
    }
	
	@When("^i write it \"([^\"]*)\"$")
    public void i_write_the_content(String proposal) throws Throwable {
    	System.out.println("Proposal's content: " + proposal);
    }
	
	@And("^i put a tittle \"([^\"]*)\"$")
    public void i_put_a_title(String title) throws Throwable {
    	System.out.println("Proposal's title: " + title);
    }
	
	@And("^i select a category $")
    public void i_select_a_category(String category) throws Throwable {
    	System.out.println("Proposal's category: " + category);
    }
	
	@Then("^it will be published$")
    public void it_will_be_published() throws Throwable {
        System.out.println("The proposal has been published.");
    }
}
