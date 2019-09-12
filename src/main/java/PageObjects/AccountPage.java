package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AccountPage {

    public WebDriver driver;

    By firstLanding = By.xpath("//strong[contains(text(),'Nothing Booked Yet')]");
    By greetingsMessage = By.xpath("//h3[@class='RTL']");
    By profile = By.xpath("//span[@class='profile-icon']");
    By bookings = By.xpath(("//a[@href='#bookings']"));
    By timeStamp = By.xpath("//div[@id='txt']");

    public AccountPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement firstLandingAfterLogin(){
        return driver.findElement(firstLanding);
    }
    public WebElement getTimeStamp(){
        return driver.findElement(timeStamp);
    }

    public  WebElement getProfile(){
        return driver.findElement(profile);
    }

    public void confirmSuccessfulLogin(String fname, String lname){
        Assert.assertTrue(driver.findElement(firstLanding) != null);
        driver.getPageSource().contains("Hi, " + fname+ " " + lname);
        driver.getCurrentUrl().contains("http://www.phptravels.net/account/");

    }


}

