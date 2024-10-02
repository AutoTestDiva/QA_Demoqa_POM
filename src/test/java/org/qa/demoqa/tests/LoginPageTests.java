package org.qa.demoqa.tests;

import org.qa.demoqa.pages.HomePage;
import org.qa.demoqa.pages.LoginPage;
import org.qa.demoqa.pages.SidePanel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getBook();
        new SidePanel(driver).selectLogin();
    }


    @Test
    public void loginPositiveTest(){
        new LoginPage(driver)
                .login("Nata", "Pnata1978!")
                .verifyUserName("Nata");
    }

}
