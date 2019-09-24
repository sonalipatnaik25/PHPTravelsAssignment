package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverUtils {

    protected static WebDriver driver;
    public static Properties prop;

    public static WebDriver initializeDriver() throws IOException {

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

}
