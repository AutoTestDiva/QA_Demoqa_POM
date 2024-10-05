package org.qa.demoqa.pages.bookStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qa.demoqa.pages.BasePage;
import org.testng.Assert;

import java.time.Duration;

public class BookStorePage extends BasePage {

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="searchBox")
    WebElement searchBox;
    public BookStorePage enterBookName(String book) {
        typeWithJSExecutor(searchBox, book, 0, 500);
        return this;
    }

    @FindBy(xpath = "//span[@class='mr-2']/a")
    WebElement bookName;
    public BookStorePage verifyBookName(String book) {
        Assert.assertTrue(isTextPresent(bookName, book));
             return this;
    }

    @FindBy(id="login")
    WebElement loginButton;
    public LoginPage clickOnLoginButton() {
        click(loginButton);
        return new LoginPage(driver);
    }

    public BookStorePage clickOnBookName() {
        clickWithJSExecutor(bookName, 0, 500);
        return this;
    }

    @FindBy(css = ".text-right.fullButton")
    WebElement addBookButton;
    public BookStorePage addToCollection() {
    clickWithJSExecutor(addBookButton, 0, 500);
    pause(300);
    driver.switchTo().alert().accept();
        return this;
    }
}
