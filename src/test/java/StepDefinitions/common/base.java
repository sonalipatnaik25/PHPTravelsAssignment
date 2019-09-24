package StepDefinitions.common;


import PageObjects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.WebDriverUtils;

import java.io.IOException;

public abstract class base {

    public static int TIMEOUTINSECONDS = 20;

    protected static WebDriver driver;
    protected static WebDriverWait webDriverWait;
    protected static LandingPage landingPage;
    protected static LoginPage loginPage;
    protected static SignUpPage signUpPage;
    protected static HotelSearchPage hotelSearchPage;
    protected static AccountPage accountPage;

    public static void initializeObjects() throws IOException {
        driver = WebDriverUtils.initializeDriver();
        landingPage = new LandingPage(driver);
        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        hotelSearchPage = new HotelSearchPage(driver);
        accountPage = new AccountPage(driver);

    }
    public void scrollToElement(){
        WebElement element = driver.findElement(By.xpath("//div[@class='form-group']//button[@type='submit']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

    }

    public void waitTillElementIsVisible(WebDriver driver, WebElement webElement ){
        webDriverWait = new WebDriverWait(driver, TIMEOUTINSECONDS);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }



}

