package org.qa.demoqa.pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.qa.demoqa.pages.BasePage;

import java.util.List;

public class SelectMenuPage extends BasePage {
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "oldSelectMenu")
    WebElement oldSelectMenu;
    public SelectMenuPage selectOldStyle(String color) {
        Select select = new Select(oldSelectMenu);
        select.selectByVisibleText(color);  //get only one color
        System.out.println(select.getFirstSelectedOption().getText() + " is first");
        System.out.println("************************");

        List<WebElement> options = select.getOptions();   //get list of colors
        for (int i = 0; i<options.size(); i++){
            System.out.println(options.get(i).getText());
        }
        return this;
    }

    @FindBy(id = "react-select-4-input")
    WebElement inputSelect;
    @FindBy(css = "body > div:nth-child(6) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(8) > div:nth-child(1) > p:nth-child(3) > b:nth-child(1)")  //(css = "html")
    WebElement space;
    public SelectMenuPage multiSelect(String[] colors) {
        pause(1000);
    for (int i = 0; i < colors.length; i++) {
        if (colors[i] != null) {
            inputSelect.sendKeys(colors[i]);
            inputSelect.sendKeys(Keys.ENTER);

        }
        click(space); //click to close dropdown
    }
        return this;
    }

    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[3]")
    WebElement multiSelectContainer;
    public SelectMenuPage multiSelect1(String[] colors) {
        pause(1000);
    for (int i = 0; i < colors.length; i++) {
        if (colors[i] != null) {
            clickWithJSExecutor(multiSelectContainer, 0, 600);
            driver.findElement(By.xpath(String.format("//*[text()='%s']", colors[i]))).click();
            //  "//*[text()='%s']" - универсальный локатор, который ищет по любому тексту
            // %s - т.е. преобразование в строку
        }
        click(space); //click to close dropdown
    }
        return this;
    }

    @FindBy(id = "cars")
    WebElement cars;
    public SelectMenuPage standardMultiSelect(int index) {
        Select select = new Select(cars);
        if (select.isMultiple()){
            select.selectByIndex(index);
        }
        return this;
    }
}
