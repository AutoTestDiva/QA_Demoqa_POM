package org.qa.demoqa.tests.widgets;

import org.qa.demoqa.pages.HomePage;
import org.qa.demoqa.pages.SidePanel;
import org.qa.demoqa.pages.widgets.MenuPage;
import org.qa.demoqa.pages.widgets.SliderPage;
import org.qa.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuTest extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectMenu();
    }
    @Test
    public void menuTest() {
        new MenuPage(driver).selectSubMenu()
                .assertSubMenu();
    }
}
