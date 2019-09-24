package StepDefinitions;

import StepDefinitions.common.base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class LoginStepDefinition extends base {

    @Given("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enters_and(String email, String password) throws Throwable {
        loginPage.enterLogonDetails(email, password);
    }

    @When("^User clicks on login button$")
    public void user_clicks_on_login_button() throws Throwable {
        loginPage.login().click();
    }

    @Then("^User is not logged and the page shows the error message \"([^\"]*)\"$")
    public void user_is_not_logged_and_the_page_shows_the_error_message(String error_message) throws Throwable {
        loginPage.logInValidations(error_message);
    }


}

