package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HotelSearchPage {

    public WebDriver driver;

    By hotelSearchTab = By.xpath("//span[contains(text(),'Hotels')]");

    By hotelSearchResults = By.xpath("//table[@id='listing']");

    By filterSearchText = By.xpath("//span[@class='filterstext']//span");

    public HotelSearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void confirmHotelSearchResults(){
        Assert.assertTrue(driver.findElement(hotelSearchTab) != null);
        Assert.assertTrue((driver.findElement(filterSearchText) != null));
        Assert.assertTrue(driver.findElements(hotelSearchResults).size() > 0);
    }




}

