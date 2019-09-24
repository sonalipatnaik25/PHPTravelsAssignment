package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AccountPage {

    public WebDriver driver;

    By firstLanding = By.xpath("//strong[contains(text(),'Nothing Booked Yet')]");
    By welcomeMessage = By.xpath("//h3[@class='RTL']");
    By profile = By.xpath("//span[@class='profile-icon']");
    By bookings = By.xpath(("//a[@href='#bookings']"));
    By timeStamp = By.xpath("//div[@id='txt']");

    public AccountPage(WebDriver driver){
        this.driver = driver;
    }

    public void welcomeMessageShown(String fname, String lname){
        String message = "Hi, " + fname + " " + lname;
        Assert.assertEquals(message, driver.findElement(welcomeMessage).getText());
    }

    public void openAccountPageConfirmation(){
        Assert.assertEquals("https://www.phptravels.net/account/", driver.getCurrentUrl());
        driver.getPageSource().contains(" Nothing Booked Yet ");
    }


}

