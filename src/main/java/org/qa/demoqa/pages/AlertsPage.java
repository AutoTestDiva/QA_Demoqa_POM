package org.qa.demoqa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertsPage extends BasePage{

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[normalize-space()='Alerts']")
    WebElement jsAlert;
    public AlertsPage clickOnAlertButton() {
        clickWithJSExecutor(jsAlert, 0, 600);
        return this;
    }

    public AlertsPage acceptAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();  // Закрыть alert
        }catch (NoAlertPresentException ex){
        }
        return this;
    }

    public AlertsPage acceptAlert2(String expectedAlertText) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            // Проверяем текст внутри alert
            String actualAlertText = alert.getText();
            Assert.assertEquals(actualAlertText, expectedAlertText, "You clicked a button");

            alert.accept();  // Закрыть alert
        } catch (NoAlertPresentException ex) {
            System.out.println("No alert present.");
        }
        return this;
    }
    @FindBy(id = "alertButton")
    WebElement result;
    public AlertsPage verifyResult(String message) {
    Assert.assertTrue(shouldHaveText(result, message, 5));
        return this;
    }

    @FindBy(css= "[onclick='jsConfirm()']")
    WebElement jsConfirmButton;
    public AlertsPage clickOnConfirmButton() {
        click(jsConfirmButton);
        return this;
    }

    public AlertsPage selectConfirm(String confirm) {
        if(confirm !=null && confirm.equalsIgnoreCase("ok")){
            driver.switchTo().alert().accept();
        }else if (confirm!=null && confirm.equalsIgnoreCase("cancel")){
            driver.switchTo().alert().dismiss();
        }
        return this;
    }

    @FindBy(css = "[onclick='jsPrompt()']")
    WebElement PromptButton;
    public AlertsPage clickOnPromptButton() {
        click(PromptButton);
        return this;
    }

    public AlertsPage enterMessageToAlert(String message) {
        if(message !=null){
            driver.switchTo().alert().sendKeys(message);
        }
        return this;
    }


    @FindBy(xpath = "//button[@id='alertButton']")
    WebElement buttonToSeeAlert;
    public AlertsPage clickOnButtonToSeeAlert() {
        clickWithJSExecutor(buttonToSeeAlert, 0, 200);
        return this;
    }
}
