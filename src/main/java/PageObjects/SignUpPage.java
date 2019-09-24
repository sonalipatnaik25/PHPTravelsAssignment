package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SignUpPage {

    public WebDriver driver;

    By firstName = By.xpath("//input[@placeholder='First Name']");
    By lastName = By.xpath("//input[@placeholder='Last Name']");
    By mobile_number = By.xpath("//input[@placeholder='Mobile Number']");
    By email = By.xpath("//input[@placeholder='Email']");
    By password = By.xpath("//input[@placeholder='Password']");
    By confirm_password = By.xpath("//input[@placeholder='Confirm Password']");
    By sign_up = By.xpath("//div[@class='form-group']//button[@type='submit']");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement fname() {
        return driver.findElement(firstName);
    }
    public WebElement lname() {
        return driver.findElement(lastName);
    }
    public WebElement mobileNumber() {
        return driver.findElement(mobile_number);
    }
    public WebElement email() {
        return driver.findElement(email);
    }
    public WebElement password() {
        return driver.findElement(password);
    }
    public WebElement confirm_password() {
        return driver.findElement(confirm_password);
    }
    public WebElement submitRequest() {
        return driver.findElement(sign_up);
    }

    public void enterUserDetails(String fname, String lname, String phone, String email, String password, String confirmPassword) {
        fname().sendKeys(fname);
        lname().sendKeys(lname);
        mobileNumber().sendKeys(phone);
        email().sendKeys(email);
        password().sendKeys(password);
        confirm_password().sendKeys(confirmPassword);
    }

    public void clickSignUp() {
        WebElement element = driver.findElement(By.xpath("//div[@class='form-group']//button[@type='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        submitRequest().click();
    }

    public void registrationPageLoadedSuccessfully() {
        Assert.assertEquals("https://www.phptravels.net/register", driver.getCurrentUrl());

    }
}

