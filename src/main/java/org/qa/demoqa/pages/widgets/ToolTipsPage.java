package org.qa.demoqa.pages.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.qa.demoqa.pages.BasePage;
import org.testng.Assert;

public class ToolTipsPage extends BasePage {
    public ToolTipsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "toolTipButton")
    WebElement toolTipTextField;

    public ToolTipsPage hoverToolTips() {
        pause(2000);
        new Actions(driver).moveToElement(toolTipTextField).perform();
        pause(1000);
        return this;
    }

    public ToolTipsPage assertToolTips(String value) {
        clickWithJSExecutor(toolTipTextField,0,300);
        pause(1000);
        Assert.assertEquals(getValueAttribute(toolTipTextField, "aria-describedby"), value);
        return this;
    }
}
