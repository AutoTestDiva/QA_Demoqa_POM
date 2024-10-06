package org.qa.demoqa.tests.widgets;

import org.qa.demoqa.pages.HomePage;
import org.qa.demoqa.pages.SidePanel;
import org.qa.demoqa.pages.widgets.SliderPage;
import org.qa.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderTest extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectSlider();
    }
    @Test
    public void sliderTest(){
        new SliderPage(driver).moveSliderInHorisontalDirection()
                .assertSliderValue("100");
    }
}
