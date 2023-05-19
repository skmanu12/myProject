package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination {
@Given("^Landed on netbanking page$")
public void Landed_on_netbanking_page() {
	System.out.println("Landed on netbanking");
}
@When("^user login application with username and password$")
public void user_login_application_with_username_and_password() {
	System.out.println("User login Into on netbanking");
}
@Then("^Home page is populated$")
public void Home_page_is_populated() {
	System.out.println("Home page is populated");
}
@Then("^Cards are displayed$")
public void Cards_are_displayed() {
	System.out.println("Cards are displayed");
}
}
