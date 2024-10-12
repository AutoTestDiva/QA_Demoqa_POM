package org.qa.demoqa.pages.interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.qa.demoqa.pages.BasePage;
import org.testng.Assert;

public class DroppablePage extends BasePage {

    public DroppablePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "simpleDropContainer")
    WebElement scrollDown;
    @FindBy(id = "draggable")
    WebElement dragMe;

    @FindBy(id = "droppable")
    WebElement dropHere;

    public DroppablePage actionDragMe() {
        clickWithJSExecutor(scrollDown,0,600);
        pause(1000);
        new Actions(driver).dragAndDrop(dragMe, dropHere).perform();
        return this;
    }
    public DroppablePage assertDropped(String text) {
        Assert.assertTrue(isTextPresent(dropHere, text));
        return this;
    }
}
