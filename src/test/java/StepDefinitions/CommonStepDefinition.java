package StepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import resources.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
public class CommonStepDefinition extends base {

    @BeforeTest
    public void preConditions() throws IOException {
        driver = initializeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("^Initialize the browser with Chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {

        driver = initializeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @And("^user navigates to \"([^\"]*)\" website$")
    public void user_navigates_to_something_website(String url) throws Throwable {
        driver.get(url);

    }
    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}