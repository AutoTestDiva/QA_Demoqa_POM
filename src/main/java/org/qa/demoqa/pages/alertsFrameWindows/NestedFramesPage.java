package org.qa.demoqa.pages.alertsFrameWindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.qa.demoqa.pages.BasePage;

import java.util.List;

public class NestedFramesPage extends BasePage {

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "iframe")
    List<WebElement> iframes;

    @FindBy (id = "frame1")
    WebElement frame1;

    @FindBy (tagName = "body")
    WebElement body;
    public NestedFramesPage handleNestedIframes() {
        //return numbers of frames from main page
        System.out.println("The total numbers of iframes in the main page: " + iframes.size());
        //switch to parent iframe
        driver.switchTo().frame(frame1);
        //get the numbers from parent iframe
        System.out.println("TThe total numbers of iframes in the parent iframe:  " + iframes.size());

        //number of iframes from parent iframe

        return this;
    }
}
