package org.qa.demoqa.tests.elements;

import org.qa.demoqa.pages.HomePage;
import org.qa.demoqa.pages.SidePanel;
import org.qa.demoqa.pages.elements.TextBoxPage;
import org.qa.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getElements();
        new SidePanel(driver).selectTextBox(). hideIframes();
    }
    @Test
    public void keyBoardEventTest(){
        new TextBoxPage(driver).keyBoardEvant("Str 1")
                .assertCopyPastText("Str 1");

    }
}
