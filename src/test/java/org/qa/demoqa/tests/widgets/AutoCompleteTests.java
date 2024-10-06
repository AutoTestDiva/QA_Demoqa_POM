package org.qa.demoqa.tests.widgets;

import org.qa.demoqa.pages.HomePage;
import org.qa.demoqa.pages.SidePanel;
import org.qa.demoqa.pages.widgets.AutoCompletePage;
import org.qa.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutoCompleteTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectAutoComplete();
    }
    @Test
    public void autoCompleteTest(){
        new AutoCompletePage(driver).autoComplete()
                .assertAutoComplete("Magenta");
    }
}
