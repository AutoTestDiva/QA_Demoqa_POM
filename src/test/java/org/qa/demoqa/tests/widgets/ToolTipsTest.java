package org.qa.demoqa.tests.widgets;

import org.qa.demoqa.pages.HomePage;
import org.qa.demoqa.pages.SidePanel;
import org.qa.demoqa.pages.widgets.ToolTipsPage;
import org.qa.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ToolTipsTest extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getWidgets();
        new SidePanel(driver).selectToolTips().hideIframes();
    }
    @Test   // позволяет проверить всплывающую подсказку при наведении кур сора на кнопку/поле/выделенное синим цветом слово
    public void toolTipsTest(){
        new ToolTipsPage(driver).hoverToolTips()
                .assertToolTips("buttonToolTip");  //проверяем текст во всплывающей подсказке

    }
}
