package org.qa.demoqa.tests.interactions;

import org.qa.demoqa.pages.HomePage;
import org.qa.demoqa.pages.SidePanel;
import org.qa.demoqa.pages.interactions.DroppablePage;
import org.qa.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDragTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getInteractions();
        new SidePanel(driver).selectDroppable().hideIframes();
    }
@Test
    public void dragMeTest(){
        new DroppablePage(driver).actionDragMe()
                .assertDropped("Dropped!");
}
    @Test
    public void dragMeByTest(){
        new DroppablePage(driver).actionDragMeBy(20,50)  //приблизительно пиксели по бокам и сверху
                .assertDropped("Dropped!");
    }

}
