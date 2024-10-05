package org.qa.demoqa.pages.bookStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.qa.demoqa.pages.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="userName")
    WebElement userNameField;

    @FindBy(id="password")
    WebElement passwordField;

    @FindBy(id="login")
    WebElement loginButton;

    public ProfilePage login(String userName, String password){
        typeWithJSExecutor(userNameField, userName, 0, 500);
        type(passwordField, password);
        click(loginButton);
        return new ProfilePage(driver);
    }

    public LoginPage loginNegative(String userName, String password){
        typeWithJSExecutor(userNameField, userName, 0, 500);
        type(userNameField, userName);
        type(passwordField, password);
        click(loginButton);
        return this;
    }

}
