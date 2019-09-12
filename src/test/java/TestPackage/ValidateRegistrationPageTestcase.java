package TestPackage;

import PageObjects.LandingPage;
import PageObjects.SignUpPage;
import org.testng.annotations.Test;
import resources.base;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class ValidateRegistrationPageTestcase extends base{

@Test
    public void basePageNavigation() throws IOException, InterruptedException {
    driver = initializeDriver();

    driver.get(prop.getProperty("url"));


    SignUpPage reg = new SignUpPage(driver);

    reg.fname().sendKeys("fname");
    reg.lname().sendKeys("lname");
    reg.mobileNumber().sendKeys("7574585");
    reg.email().sendKeys("a.b@c.com");
    reg.password().sendKeys("pass01a");
    reg.confirm_password().sendKeys("pass01a");

    reg.submitRequest().click();

    }
}
