package org.qa.demoqa.pages.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.qa.demoqa.pages.BasePage;
import org.testng.Assert;

public class MenuPage extends BasePage {
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Main Item 2']")
    WebElement mainItem2;

    @FindBy(xpath = "//a[.='SUB SUB LIST »']")
    WebElement subSubList;
    public MenuPage selectSubMenu() {
        pause(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(mainItem2).perform(); //метод moveToElement - выбирает определенный элемент на сранице
        actions.moveToElement(subSubList).perform();
        return this;
    }

    public MenuPage assertSubMenu() {
        Assert.assertTrue(subSubList.isDisplayed());  //т.е. isDisplayed() проверяет, есть ли этот элемент на странице
        return this;
    }
}
