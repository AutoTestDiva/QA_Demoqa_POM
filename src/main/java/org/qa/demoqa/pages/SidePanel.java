package org.qa.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.qa.demoqa.pages.alertsFrameWindows.FramePage;
import org.qa.demoqa.pages.alertsFrameWindows.NestedFramesPage;
import org.qa.demoqa.pages.bookStore.LoginPage;
import org.qa.demoqa.pages.bookStore.ProfilePage;
import org.qa.demoqa.pages.elements.BrokenLinksImagesPage;
import org.qa.demoqa.pages.elements.LinksPage;

public class SidePanel extends BasePage{

    public SidePanel(WebDriver driver) {
        super(driver);
    }

    @FindBy(css=".show #item-0")
    WebElement login;
    public LoginPage selectLogin() {
        clickWithJSExecutor(login, 0,600);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//span[.='Profile']")
    WebElement profile;
    public ProfilePage selectProfile() {
        clickWithJSExecutor(profile, 0, 600);
        return new ProfilePage(driver);
    }

    @FindBy(xpath = "//span[.='Links']")
    WebElement links;
    public LinksPage selectLinks() {
        clickWithJSExecutor(links, 0, 300);
        return new LinksPage(driver);
    }

    @FindBy(xpath = "//span[.='Broken Links - Images']")
    WebElement brokenLinksImages;
    public BrokenLinksImagesPage selectBrokenLinksImages() {
        clickWithJSExecutor(brokenLinksImages, 0, 600);
        return new BrokenLinksImagesPage(driver);
    }

    @FindBy(xpath = "//span[.='Frames']")
    WebElement frames;
    public FramePage selectFrame() {
        clickWithJSExecutor(frames, 0, 300);
        return new FramePage(driver);
    }

    @FindBy(xpath = "//span[.='Nested Frames']")
    WebElement nestedFrames;
    public NestedFramesPage selectNestedFrames() {
        clickWithJSExecutor(nestedFrames, 0, 300);
        return new NestedFramesPage(driver);
    }
}
