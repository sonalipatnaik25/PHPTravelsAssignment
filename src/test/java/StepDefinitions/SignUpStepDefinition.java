package StepDefinitions;

import PageObjects.AccountPage;
import PageObjects.LandingPage;
import PageObjects.SignUpPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import resources.base;

@RunWith(Cucumber.class)
public class SignUpStepDefinition extends base {
    LandingPage land;
    SignUpPage reg;
    AccountPage account;

    @Given("^User enters his firstname \"([^\"]*)\", lastname \"([^\"]*)\", mobile number \"([^\"]*)\", email \"([^\"]*)\", password \"([^\"]*)\", confirm password \"([^\"]*)\"$")
    public void user_enters_his_firstname_something_lastname_something_mobile_number_something_email_something_password_something_confirm_password_something(String firstname, String lastname, String mobilenumber, String email, String password, String confirmpassword) throws Throwable {

        reg = new SignUpPage(driver);
        reg.fname().sendKeys(firstname);
        reg.lname().sendKeys(lastname);
        reg.mobileNumber().sendKeys(mobilenumber);
        reg.email().sendKeys(email);
        reg.password().sendKeys(password);
        reg.confirm_password().sendKeys(confirmpassword);


    }

    @When("^User clicks on Sign up button$")
    public void user_clicks_on_sign_up_button() throws Throwable {
        WebElement element = driver.findElement(By.xpath("//div[@class='form-group']//button[@type='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        reg.submitRequest().click();
    }

    @Then("^User is registered successfully$")
    public void user_is_registered_successfully() throws Throwable {
        account = new AccountPage(driver);
        driver.getPageSource().contains(" Nothing Booked Yet ");

    }

    @Then("^User is not registered successfully and the error message \"([^\"]*)\" is shown on the page$")
    public void user_is_not_registered_successfully_and_the_error_message_something_is_shown_on_the_page(String errormessage) throws Throwable {
        driver.getPageSource().contains(errormessage);
    }



    @And("^user clicks on Signup from MyAccount$")
    public void user_clicks_on_signup_from_myaccount() throws Throwable {
        land = new LandingPage(driver);
        land.clickAccount().click();
        land.clickSignUp().click();

    }

    @And("^the user is redirected to \"([^\"]*)\" page$")
    public void the_user_is_redirected_to_something_page(String strArg1) throws Throwable {
       // reg.registrationPageLoadedSuccessfully();
        driver.getPageSource().contains("SIGN UP");
    }

}