package StepDefinitions.common;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
public class CommonStepDefinition extends base {

    private static final Logger logger = LogManager.getLogger(CommonStepDefinition.class);

    @Before
    public static void beforeExecution() throws IOException {
        logger.info("initializing.....");
        initializeObjects();
    }

    @Given("^User is on the \"([^\"]*)\" website$")
    public void user_is_on_the_website(String url) throws Throwable {
        logger.info("User is on phptravelsnet website");
        landingPage.openUrl(url);
    }

    @Given("^User navigates to \"([^\"]*)\" Page$")
    public void user_navigates_to_Page(String page) throws Throwable {
        if (page.equals("SignUpPage")) {
            logger.info("Opening SignUp page");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            landingPage.navigateToRegistrationPage();
        }
        if (page.equals("LoginPage")) {
            logger.info("Opening Login page");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            landingPage.navigateToLoginPage();
        }
        if (page.equals("AccountPage")) {
            logger.info("Opening Account page");
        }
    }

    @Then("^The user is redirected to \"([^\"]*)\" page$")
    public void the_user_is_redirected_to_page(String page) throws Throwable {
        if (page.equals("AccountPage")) {
            logger.info("Opening Account page");
            accountPage.openAccountPageConfirmation();
        }
        if(page.equals("LoginPage")){
            logger.info(("Opening Login Page"));
            loginPage.openLoginPageConfirmation();
        }
    }


    @AfterTest
    public static void tearDown() {
        driver.close();
        driver.quit();

    }


}