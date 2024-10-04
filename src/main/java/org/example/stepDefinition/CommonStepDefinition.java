package org.example.stepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.constants.Browser;
import org.example.constants.WebUrl;
import org.example.utilities.CommonUtils;
import org.example.webdriver_manager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CommonStepDefinition {

    WebDriver driver;
    String ScenarioName;

    private static final Logger LOGGER= LogManager.getLogger(CommonStepDefinition.class);

    @Before
    public void beforeScenario(Scenario scenario){
      LOGGER.info("Execution Started");

        try{
            LOGGER.info("Instantiate Common utils");
             ScenarioName = scenario.getName();

            LOGGER.info("Loading properties file");
            CommonUtils.getInstance().LoadProperties();
            LOGGER.info("checking driver is null or not");

            if(DriverManager.getDriver()==null){

            DriverManager.launchBrowser();
            CommonUtils.getInstance().initWebElements();}
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
