package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LandingPage {

    private WebDriver driver;

    public WebDriverWait webDriverWait;

    static final Logger logger = LogManager.getLogger(LandingPage.class);

    By account = By.xpath("//nav[contains(@class, 'navbar')]//li[@id='li_myaccount']/a");

    By SignUp = By.xpath("//nav[@class='navbar navbar-default']//ul[@class='dropdown-menu']//li[2]//a[1]");

    By Login = By.xpath("//nav[@class='navbar navbar-default']//ul[@class='dropdown-menu']//li[1]//a[1]");

    By hotel = By.xpath("//span[contains(text(),'Hotels')]");

    By hotelsearchlocator = By.xpath("//*[@id='s2id_location']");

    By hotelSearchText = By.xpath("//*[@id='select2-drop']/div/input"); //By.id("s2id_location");

    By hotelCityDropdown = By.xpath("//*[@id='select2-drop']/ul/li");

    By checkInDate = By.xpath("//div[@id='dpd1']//input[@placeholder='Check in']");

    By checkOutDate = By.xpath("//input[@placeholder='Check out']");

    By travellers = By.xpath("//input[@id='htravellersInput']");

    By adultPlsButton = By.xpath("//button[@id='hadultPlusBtn']//i[@class='fa fa-plus']");

    By kidPlusButton = By.xpath("//button[@id='hchildPlusBtn']//i[@class='fa fa-plus']");

    By hotelSearchButton = By.xpath("//form[@name='fthhotelsSearch']//button[@type='submit']");

    By resultTable = By.xpath("//*[@id='select2-drop']/ul/li/ul/li[1]/div");

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement clickAccount() {
        return driver.findElement(account);
    }

    public WebElement clickSignUp() {
        return driver.findElement(SignUp);
    }

    public WebElement clickLogin() {
        return driver.findElement(Login);
    }

    public WebElement clickHotelTab() {
        return driver.findElement(hotel);
    }

    public WebElement clickHotelSearchLocator() {
        return driver.findElement(hotelsearchlocator);
    }

    public WebElement enterHotelSearchText() {
        return driver.findElement(hotelSearchText);
    }

    public WebElement getCityDropdown() {
        return driver.findElement(hotelCityDropdown);
    }

    public WebElement getCheckInDate() {
        return driver.findElement(checkInDate);
    }

    public WebElement getCheckoutDate() {
        return driver.findElement(checkOutDate);
    }

    public WebElement getTravellers() {
        return driver.findElement(travellers);
    }

    public WebElement getHotelSearchButton() {
        return driver.findElement(hotelSearchButton);
    }

   public void navigateToRegistrationPage(){
        clickAccount().click();
        clickSignUp().click();
   }

    public void navigateToLoginPage(){
        clickAccount().click();
        clickLogin().click();
    }

   public void openUrl(String url){
        driver.get(url);
   }

    public void searchHotelsPrepare(String hotelCityName, String checkinDate, String checkoutDate, int adults, int child) throws InterruptedException {
        logger.info("Hotel Search Data...");
        clickHotelSearchLocator().click();
        enterHotelSearchText().sendKeys(hotelCityName);
        webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(hotelCityDropdown));
        Assert.assertTrue(driver.findElements(hotelCityDropdown).size() > 0);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(resultTable));
        driver.findElement(resultTable).click();
        getCheckInDate().sendKeys(checkinDate);
        getCheckoutDate().sendKeys(checkoutDate);
        getTravellers().click();

    }

}
