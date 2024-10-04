package org.example.utilities;

import org.example.constants.Browser;
import org.example.constants.WebUrl;
import org.example.pom.HomePage;
import org.example.pom.LoginPage;
import org.example.webdriver_manager.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class CommonUtils {

    private static CommonUtils commonUtilsInstance=null;
    private CommonUtils(){

    }
    public static CommonUtils getInstance(){
        if(commonUtilsInstance==null){
            commonUtilsInstance=new CommonUtils();
        }
        return commonUtilsInstance;
    }

    public  void LoadProperties() throws IOException {


        Properties properties=new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

      WebUrl.APP_URL= properties.getProperty("APP_URL");
      WebUrl.BROWSER=  properties.getProperty("BROWSER");
      WebUrl.UserName=  properties.getProperty("UserName");
      WebUrl.Password=  properties.getProperty("Password");
       Browser.Chrome_Driver_Location= properties.getProperty("Chrome_Driver_Location");




    }

    public void initWebElements(){
        PageFactory.initElements(DriverManager.getDriver(), LoginPage.getLoginInstance());
        PageFactory.initElements(DriverManager.getDriver(), HomePage.getHomePageInstance());
    }

    public void implicitWait(){
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public void takeScreenshot() throws IOException {
        TakesScreenshot screenshot= (TakesScreenshot) DriverManager.getDriver();
        File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
        File file=new File("D://sample1.img");
        try{
        FileHandler.copy(sourceFile,file);}
        catch (IOException e ){
            System.out.println(e.getMessage());
        }

    }
}
