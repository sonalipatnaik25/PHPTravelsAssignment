package StepDefinitions;

import PageObjects.AccountPage;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import resources.base;

@RunWith(Cucumber.class)
public class LoginStepDefinition extends base {

    LandingPage land;
    LoginPage loginPage;
    AccountPage accountPage;

    @Given("^user clicks on Login from MyAccount$")
    public void user_clicks_on_Login_from_MyAccount() throws Throwable {
        land = new LandingPage(driver);
        land.clickAccount().click();
        land.clickLogin().click();
    }

    @Given("^the user is redirected to Login page$")
    public void the_user_is_redirected_to_Login_page() throws Throwable {
        driver.getPageSource().contains("LOGIN");
    }

    @Given("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enters_and(String email, String password) throws Throwable {
        loginPage = new LoginPage(driver);
        loginPage.email().sendKeys(email);
        loginPage.password().sendKeys(password);
        Thread.sleep(2000);
    }

    @When("^User clicks on login button$")
    public void user_clicks_on_login_button() throws Throwable {
        loginPage.login().click();
    }

    @Then("^User is not logged and the page shows the error message \"([^\"]*)\"$")
    public void user_is_not_logged_and_the_page_shows_the_error_message(String error_message) throws Throwable {
        loginPage.logInValidations(error_message);
    }

    @Then("^User is logged in successfully and the Account Page displays the greeting message for \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_is_logged_in_successfully_and_the_Account_Page_displays_the_greeting_message_for_and(String firstName, String lastName) throws Throwable {
        accountPage = new AccountPage(driver);
        accountPage.confirmSuccessfulLogin(firstName, lastName);
    }


}

