package org.qa.demoqa.pages.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.qa.demoqa.pages.BasePage;
import org.testng.Assert;

public class SliderPage extends BasePage {
    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".range-slider")
    WebElement sliderContainer;
    public SliderPage moveSliderInHorisontalDirection() {
    new Actions(driver).dragAndDropBy(sliderContainer, 286, 0).perform();
        return this;
    }

    @FindBy(id = "sliderValue")
    WebElement sliderValue;
    public SliderPage assertSliderValue(String number) {
        Assert.assertEquals(getValueAttribute(sliderValue, "value"), number);
        return this;
    }

    private String getValueAttribute(WebElement element, String name) {
        return element.getAttribute(name);  //возвращает значение аттрибута в виде строки
    }


}
