package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HotelSearchPage {

    public WebDriver driver;
    public WebDriverWait webDriverWait;

    private static Logger logger = LogManager.getLogger(HotelSearchPage.class);

    String hotelSearchUrl = "https://www.phptravels.net/thhotels/search/";

    By hotelSearchTab = By.xpath("//span[contains(text(),'Hotels')]");

    By hotelSearchResults = By.xpath("//table[@id='listing']");

    By filterSearchText = By.xpath("//span[@class='filterstext']//span");

    By hotelSearchList = By.xpath("//div[@class='itemscontainer']");

    public HotelSearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void confirmHotelSearchResults(){
        webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(hotelSearchList)));
        Assert.assertTrue(driver.findElement(hotelSearchTab) != null);
        Assert.assertTrue((driver.findElement(filterSearchText) != null));
        Assert.assertTrue(driver.findElements(hotelSearchResults).size() > 0);
    }

}

