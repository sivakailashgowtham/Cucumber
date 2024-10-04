package org.example.webdriver_manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.constants.Browser;
import org.example.constants.WebUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    private static final Logger LOGGER= LogManager.getLogger(DriverManager.class);

    private static WebDriver driver=null;

    public static void launchBrowser() {

        try{
            switch (WebUrl.BROWSER){
                case "chrome":
                   WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
