package org.qa.demoqa.pages.elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.dom.model.ShapeOutsideInfo;
import org.openqa.selenium.support.FindBy;
import org.qa.demoqa.pages.BasePage;

import java.lang.reflect.Field;
import java.util.List;

public class BrokenLinksImagesPage extends BasePage {
    public BrokenLinksImagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "img")
    List<WebElement> images;

    public BrokenLinksImagesPage checkBrokenImages() {
        System.out.println("Total number of images on the page: " + images.size());

        for (int i = 0; i < images.size(); i++) {
            WebElement image = images.get(i);
            String imageUrl = image.getAttribute("src");
            System.out.println("URL of image " + (i + 1) + " is " + imageUrl);
            verifyLinks(imageUrl);

            try {
                boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver)
                        .executeScript("return (type of arguments[0].naturalWidth != undefined && arguments[0].naturalWidth>0);", image);
                if (imageDisplayed) {
                    System.out.println("DISPLAY - OK");
                    System.out.println("***********************");
                } else {
                    System.out.println("DISPLAY - BROKEN");
                    System.out.println("***********************");
                }
            } catch (Exception ex) {
                System.out.println("ERROR OCCURRED");
            }
        }
        return this;
    }
}
