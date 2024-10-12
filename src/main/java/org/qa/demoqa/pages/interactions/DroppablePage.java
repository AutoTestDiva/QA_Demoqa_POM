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

    public DroppablePage actionDragMeBy(int x, int y) {   //*/метод, позволяющий вложить в нужное место квадрат в квадрат
        clickWithJSExecutor(scrollDown,0,600);
        pause(1000);
        //get coordinates dragMe(from) and print
        int xOffset1 = dragMe.getLocation().getX();
        int yOffset1 = dragMe.getLocation().getY();
        System.out.println("xOffset1 --> " + xOffset1 + "yOffset1 --> " + yOffset1);

        //get coordinates dropHere(to) and print
        int xOffset = dropHere.getLocation().getX();
        int yOffset = dropHere.getLocation().getY();
        System.out.println("xOffset --> " + xOffset + "yOffset --> " + yOffset);
        //get different xOffset and yOffset
        xOffset = (xOffset - xOffset1) + x;
        yOffset = (yOffset - yOffset1) +y;
        new Actions(driver).dragAndDropBy(dragMe, xOffset, yOffset).perform();
        return this;
    }
}
