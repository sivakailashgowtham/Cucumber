package org.example.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    private static HomePage homePageInstance;

    private HomePage(){

    }

    public static HomePage getHomePageInstance() {

        if(homePageInstance==null){
            homePageInstance=new HomePage();
        }
        return homePageInstance;
    }

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Directory']")
    private WebElement directory;

    public  WebElement getDirectory() {
        return directory;
    }
}
