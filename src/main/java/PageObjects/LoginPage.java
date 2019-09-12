package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;

    By email = By.xpath("//input[@placeholder='Email']");
    By password = By.xpath("//input[@placeholder='Password']");
    By login = By.xpath("//form[@id='loginfrm']//button[@type='submit']");
    By errorMessage = By.xpath("//div[@class='alert alert-danger']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement email(){
        return driver.findElement(email);
    }
    public WebElement password(){
        return driver.findElement(password);
    }
    public WebElement login(){
        return driver.findElement(login);
    }
    public WebElement getErrorMessage(){
        return driver.findElement(errorMessage);
    }

    public void logInValidations(String errorMessage){
        getErrorMessage().getText().contains(errorMessage);
    }

}

