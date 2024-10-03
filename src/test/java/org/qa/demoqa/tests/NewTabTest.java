package org.qa.demoqa.tests;

import org.qa.demoqa.pages.HomePage;
import org.qa.demoqa.pages.WindowPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTabTest extends TestBase{
    @BeforeMethod
    public void preconditions(){
        new HomePage(driver).getMultipleWindows();
    }

    @Test
    public void switchToNewTabTest(){
        new WindowPage(driver).switchToNewTab(1)
                .verifyNewTabTitle("New Window");

    }
}
