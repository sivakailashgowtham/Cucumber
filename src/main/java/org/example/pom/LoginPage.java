package org.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    private static LoginPage loginInstance;

    private LoginPage(){

    }

    public static LoginPage getLoginInstance(){
        if(loginInstance==null){
            loginInstance=new LoginPage();
        }
        return loginInstance;
    }

    @FindBy(name = "username")
    private WebElement userName;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement login;

//    public WebElement getUserName() {
//        return userName;
//    }
//
//    public WebElement getPassword() {
//        return password;
//    }
//
//    public WebElement getLogin() {
//        return login;
//    }

    public void enterUserName(String UserName){
        userName.sendKeys(UserName);
    }

    public void enterPassWord(String passWord){
        password.sendKeys(passWord);

    }

    public void clickLogin(){
        login.click();
    }
}
