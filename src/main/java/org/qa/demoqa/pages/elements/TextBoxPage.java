package org.qa.demoqa.pages.elements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.qa.demoqa.pages.BasePage;
import org.testng.Assert;

public class TextBoxPage extends BasePage {
    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="currentAddress")
    WebElement currentAddress;
    public TextBoxPage keyBoardEvant(String text) {
        typeWithJSExecutor(currentAddress, text, 0, 600);

        Actions actions = new Actions(driver);
        //select current address
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();//т.е. выделяем  текст с помощью Ctrl+a
        //copy current address
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();//т.е. копируем текст с помощью Ctrl+с
        //press TAB KEY to swich focus to permanent address
        actions.sendKeys(Keys.TAB).perform();
        //past current address in permanent address field
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();//т.е. вставляем текст с помощью Ctrl+v
        return this;
    }

    @FindBy(id ="permanentAddress")
    WebElement permanentAddress;
    public TextBoxPage assertCopyPastText(String text) {
        Assert.assertTrue(isTextPresent(permanentAddress, text));
        return this;
    }
}
