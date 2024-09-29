package org.qa.demoqa.tests;

import org.qa.demoqa.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{

    @Test
    public void loginPositiveTest(){
        new LoginPage(driver)
                .login("Nata", "Pnata1978!");
    }

}
