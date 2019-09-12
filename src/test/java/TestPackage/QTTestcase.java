package TestPackage;

import PageObjects.AccountPage;
import PageObjects.LandingPage;

import PageObjects.SignUpPage;
import org.testng.Assert;
import resources.base;

import org.testng.annotations.Test;

import java.io.IOException;


public class QTTestcase extends base{

@Test
    public void basePageNavigation() throws IOException, InterruptedException {
    driver = initializeDriver();

    driver.get(prop.getProperty("url"));

    LandingPage land = new LandingPage(driver);

    land.clickAccount().click();

    land.clickSignUp().click();

    land.clickAccount().click();

    SignUpPage reg = new SignUpPage(driver);

    AccountPage acc = new AccountPage(driver);

    reg.fname().sendKeys("fname");
    reg.lname().sendKeys("lname");
    reg.mobileNumber().sendKeys("7574585");
    reg.email().sendKeys("a.b@c.com");
    reg.password().sendKeys("a.b@c.com");
    reg.confirm_password().sendKeys("a.b@c.com");

    reg.submitRequest().click();

    }
}
