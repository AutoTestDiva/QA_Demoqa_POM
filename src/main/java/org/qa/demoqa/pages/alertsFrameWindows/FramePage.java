package org.qa.demoqa.pages.alertsFrameWindows;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.qa.demoqa.pages.BasePage;

import java.util.List;

public class FramePage extends BasePage {
    public FramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName="iframe")
    List<WebElement> iframes;
    public FramePage returnListOfFrames() {
        //using ifame tag
        System.out.println("The total numbers of iframes: " + iframes.size());
        //or using JSExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer numberOfIframes = Integer.parseInt(js.executeScript("return window.length")
                .toString());
        System.out.println("The total numbers of iframes: " + numberOfIframes);
        return this;
    }

    @FindBy(id = "sampleHeading")
    WebElement sampleHeading;
    public FramePage switchToIframeByIndex(int index) {
        driver.switchTo().frame(index);
        System.out.println("Text of the iframe: " + sampleHeading.getText());
        return this;
    }

    @FindBy(id = "frame1")
    WebElement frame1;


    @FindBy(id = "framesWrapper")
    WebElement framesWrapper;
    public FramePage switchToIframeByID() {
        driver.switchTo().frame(frame1);
        System.out.println("Text of the iframe: " + sampleHeading.getText());
        driver.switchTo().defaultContent();
        System.out.println("Text of the iframe: " + framesWrapper.getText());
        return this;
    }
}
