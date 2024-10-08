package org.qa.demoqa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
   public WebDriver driver;
    @BeforeMethod
    public void init(){
        System.err.close(); //отключает вывод системных ошибок
        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        //driver.get("https://the-internet.herokuapp.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled= false)
    public void tearDown(){
        driver.quit();
    }
}
