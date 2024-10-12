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
    public SidePanel getBookStore() {
        clickWithJSExecutor(bookStore, 0, 600);
        return new SidePanel(driver);
    }


    @FindBy(xpath = "//a[.='JavaScript Alerts']")
    WebElement alertsLink;
    public AlertsPage getAlerts() {
        click (alertsLink);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//a[.='Multiple Windows']")
    WebElement windowsLink;
    public WindowPage getMultipleWindows() {
        click(windowsLink);
        return new WindowPage(driver);
    }

    @FindBy(xpath = "//a[.='Form Authentication']")
    WebElement formLink;
    public JSExecutor getFormAuthentication() {
        click(formLink);
        return new JSExecutor(driver);
    }

    @FindBy(css=".top-card:nth-child(1)")
    WebElement elements;
    public SidePanel getElements() {
        clickWithJSExecutor(elements, 0, 400);
        return new SidePanel(driver);
    }

    @FindBy(css=".top-card:nth-child(3)")
    WebElement alertsFramesWindows;
    public SidePanel getAlertsFramesWindows() {
        clickWithJSExecutor(alertsFramesWindows,0,200);
        return new SidePanel(driver);
    }

    @FindBy(css=".top-card:nth-child(4)")
    WebElement widgets;
    public SidePanel getWidgets() {
        clickWithJSExecutor(widgets,0,300);
        return new SidePanel(driver);
    }

    @FindBy(css=".top-card:nth-child(2)")
    WebElement forms;
    public SidePanel getForms() {
        clickWithJSExecutor(forms, 0, 600);
        return new SidePanel(driver);
    }

    @FindBy(css=".top-card:nth-child(5)")
    WebElement interactions;
    public SidePanel getInteractions() {
        clickWithJSExecutor(interactions,0,600);
        return new SidePanel(driver);
    }
}
