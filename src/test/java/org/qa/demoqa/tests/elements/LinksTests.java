package org.qa.demoqa.tests.elements;

import org.qa.demoqa.pages.HomePage;
import org.qa.demoqa.pages.SidePanel;
import org.qa.demoqa.pages.elements.LinksPage;
import org.qa.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getElements();
    }
 @Test
 public void getAllLinksTest(){
        new SidePanel(driver).selectLinks();
        new LinksPage(driver).getAllLinks();
 }
 @Test
    public void checkBrokenLinksTest(){
     new SidePanel(driver).selectLinks();
     new LinksPage(driver).checkBrokenLinks();
 }
}
