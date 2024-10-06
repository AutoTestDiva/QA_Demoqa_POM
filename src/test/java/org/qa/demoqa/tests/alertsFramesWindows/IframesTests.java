package org.qa.demoqa.tests.alertsFramesWindows;

import org.qa.demoqa.pages.HomePage;
import org.qa.demoqa.pages.SidePanel;
import org.qa.demoqa.pages.alertsFrameWindows.FramePage;
import org.qa.demoqa.pages.alertsFrameWindows.NestedFramesPage;
import org.qa.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframesTests extends TestBase {

    @BeforeMethod
    public void preconditions(){
        new HomePage(driver).getAlertsFramesWindows();
    }

    @Test
    public void iframesTest(){
        new SidePanel(driver).selectFrame();
        new FramePage(driver).returnListOfFrames().switchToIframeByIndex(2);
    }

    @Test
    public void  switchToIframeByIDTest(){
        new SidePanel(driver).selectFrame();
        new FramePage(driver).switchToIframeByID();
    }

    @Test
    public void handleNestedIframeTest(){
        new SidePanel(driver).selectNestedFrames();
        new NestedFramesPage(driver). handleNestedIframes();
    }
}
