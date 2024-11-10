package org.qa.demoqa.pages.elements;

import org.openqa.selenium.WebDriver;
import org.qa.demoqa.pages.BasePage;
import java.awt.Robot;
import java.awt.event.KeyEvent;



public class UploadPage extends BasePage {
    public UploadPage(WebDriver driver) {
        super(driver);
    }

    public UploadPage performKeyEventWithRobot() {
        pause(1000);
        Robot robot = new Robot();

        return this;
    }
}
