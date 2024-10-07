package org.qa.demoqa.tests.widgets;

import org.qa.demoqa.pages.HomePage;
import org.qa.demoqa.pages.SidePanel;
import org.qa.demoqa.pages.widgets.SelectMenuPage;
import org.qa.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectMenuTest extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectSelectMenu();
    }
    @Test
    public void selectOldStyleTest(){
        new SelectMenuPage(driver).selectOldStyle("Blue");
    }
    @Test
    public void multiSelectTest(){
        new SelectMenuPage(driver).multiSelect(new String []{"Blue", "Black", "Red"});
    }
    @Test
    public void multiSelectTest1(){ //the same like Test  multiSelectTest
        new SelectMenuPage(driver).multiSelect(new String []{"Blue", "Black", "Red"});
    }
}
