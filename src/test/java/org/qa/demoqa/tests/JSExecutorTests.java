package org.qa.demoqa.tests;

import org.qa.demoqa.data.UserData;
import org.qa.demoqa.pages.HomePage;
import org.qa.demoqa.pages.JSExecutor;
import org.testng.annotations.Test;

public class JSExecutorTests extends TestBase{

    @Test
    public void jsExecutorTest(){
        new HomePage(driver).getFormAuthentication();
        new JSExecutor(driver)
                .enterDataWithJSE(UserData.USER_NAME, UserData.USER_PASSWORD)
                .clickOnLoginButtonWithJSE()
                .checkURLWithJSE();  //shows URL
    }
}
/* JSExecutor commands:
refresh page - "history.go(0);"
check all text - "return document.documentElement.innerText;"
navigate to new page - "window.location = 'https://demoqa.com';" //go on another page
check title of page - "return document.title;" //print name/title of all page
 */
