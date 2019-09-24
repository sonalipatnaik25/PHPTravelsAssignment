package StepDefinitions;

import StepDefinitions.common.base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
public class SignUpStepDefinition extends base {

    private static Logger logger = LogManager.getLogger(SignUpStepDefinition.class);

    @Given("^User enters firstname \"([^\"]*)\", lastname \"([^\"]*)\", mobile number \"([^\"]*)\", email \"([^\"]*)\", password \"([^\"]*)\", confirm password \"([^\"]*)\"$")
    public void user_enters_firstname_something_lastname_something_mobile_number_something_email_something_password_something_confirm_password_something(String firstname, String lastname, String mobilenumber, String email, String password, String confirmpassword) throws Throwable {
        signUpPage.enterUserDetails(firstname, lastname, mobilenumber, email, password, confirmpassword);
    }

    @When("^User clicks on Sign up button$")
    public void user_clicks_on_sign_up_button() throws Throwable {
       signUpPage.clickSignUp();
    }


    @Then("^User is not registered successfully and the error message \"([^\"]*)\" is shown on the page$")
    public void user_is_not_registered_successfully_and_the_error_message_something_is_shown_on_the_page(String errormessage) throws Throwable {
        driver.getPageSource().contains(errormessage);
    }

    @And("^the user is redirected to \"([^\"]*)\" page$")
    public void the_user_is_redirected_to_something_page(String strArg1) throws Throwable {
        driver.getPageSource().contains("SIGN UP");
    }
    @Then("^Greeting message shown for \"([^\"]*)\", \"([^\"]*)\"$")
    public void greeting_message_shown_for(String fname, String lname) throws Throwable {
        accountPage.welcomeMessageShown(fname, lname);
    }

}