package resources;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class base {

    protected static WebDriver driver;
    public Properties prop;
    public static Logger log1;

    @BeforeSuite
    public void bsuite()throws FileNotFoundException, IOException {
        String log4jConfigFile = "C:\\git\\PHPTravels\\PHPTravels\\PHPTravelsAssignment\\src\\main\\java\\resources\\log4j2.xml";
        ConfigurationSource source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
        Configurator.initialize(null,source);
        log1 = LogManager.getLogger(base.class.getName());
    }


    public WebDriver initializeDriver() throws IOException {

        prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\git\\PHPTravels\\PHPTravels\\PHPTravelsAssignment\\src\\main\\java\\resources\\data.properties");
        prop.load(fis);

        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonali patnaik\\inmarsatqengframework\\tools\\ChromeDriver\\chromedriver.exe");
            if(driver == null){
                driver = new ChromeDriver();

        }
        }
        else if(browserName.equals("firefox")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonali patnaik\\inmarsatqengframework\\tools\\ChromeDriver\\chromedriver.exe");
            if(driver == null) {
                driver = new FirefoxDriver();
            }
        }
        else{
            driver = new InternetExplorerDriver();
        }

        return driver;

    }
    public void scrollToElement(){
        WebElement element = driver.findElement(By.xpath("//div[@class='form-group']//button[@type='submit']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

    }
//    @AfterTest
//    public void tearDown(){
//        driver.close();
//    }
//    @AfterSuite
//    public void quitDriver(){
//        driver.quit();
//    }
}

