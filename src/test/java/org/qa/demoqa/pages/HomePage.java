package org.qa.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css=".top-card:nth-child(6)")
    WebElement bookStore;
    public SidePanel getBook() {
        clickWithJSExecutor(bookStore, 0, 600);
        return new SidePanel(driver);
    }
}
