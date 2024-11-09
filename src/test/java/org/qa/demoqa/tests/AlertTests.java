package org.qa.demoqa.tests;

import org.qa.demoqa.pages.AlertsPage;
import org.qa.demoqa.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests extends TestBase{

    @BeforeMethod
    public void preconditions(){
        new HomePage(driver).getAlerts();
    }

    @Test
    public void acceptAlert(){
        new AlertsPage(driver).clickOnAlertButton()
                .clickOnButtonToSeeAlert()
                .acceptAlert2("You clicked a button");
    }

    @Test
    public void confirmAlertTest(){
        new AlertsPage(driver).clickOnConfirmButton()
                .selectConfirm("cancel")
                .verifyResult("Cancel");
    }
    @Test
    public void sendMessageToAlertTest(){
        new AlertsPage(driver).clickOnPromptButton()
                .enterMessageToAlert("Hello!")
                .acceptAlert()
                .verifyResult("Hello!");
    }
}
