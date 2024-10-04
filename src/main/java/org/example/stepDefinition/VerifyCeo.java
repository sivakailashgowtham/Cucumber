package org.example.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.constants.WebUrl;
import org.example.pom.HomePage;
import org.example.pom.LoginPage;
import org.example.utilities.CommonUtils;
import org.example.webdriver_manager.DriverManager;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.time.Duration;

public class VerifyCeo {

    @Given("user logged into HOME page")
    public void user_logged_into_home_page() throws IOException {
        DriverManager.getDriver().get(WebUrl.APP_URL);
        CommonUtils.getInstance().implicitWait();
        try{
        LoginPage.getLoginInstance();
        LoginPage.getLoginInstance().enterUserName(WebUrl.UserName);
        LoginPage.getLoginInstance().enterPassWord(WebUrl.Password);
        LoginPage.getLoginInstance().clickLogin();}
        catch (Exception e) {

            CommonUtils.getInstance().takeScreenshot();

        }


        String url=DriverManager.getDriver().getCurrentUrl();

        if(url.contains("dashboard")){
            System.out.println("logged");
        }


    }

    @When("user clicks directory options from menu bar")
    public void user_clicks_directory_options_from_menu_bar() {
        HomePage.getHomePageInstance();
        HomePage.getHomePageInstance().getDirectory().click();

    }

    @When("user selects job title as {string} from dropdown")
    public void user_selects_job_title_as_from_dropdown(String string) {
        System.out.println("dropdown");

    }

    @When("user clicks search button")
    public void user_clicks_search_button() {
        System.out.println("search button");

    }

    @Then("user should see the CEO name AS {string}")
    public void user_should_see_the_ceo_name_as(String string) {
        System.out.println("done");

    }


}
