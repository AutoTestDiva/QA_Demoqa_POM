package org.qa.demoqa.pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.qa.demoqa.pages.BasePage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class LinksPage extends BasePage {
    public LinksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName ="a")
    List<WebElement> allLinks;
        public LinksPage getAllLinks() {
        System.out.println("Total number of links on the page: " + allLinks.size());
        String url;

        Iterator<WebElement> iterator = allLinks.iterator();
        while (iterator.hasNext()){
            url = iterator.next().getText();
            System.out.println(url);
        }
        return this;
    }

    public void checkBrokenLinks() {
        for (int i=0; i <allLinks.size(); i++){
            WebElement el = allLinks.get(i);
            String url = el.getAttribute("href");
            verifyLinks(url);
        }
    }

    private void verifyLinks(String linkUrl) {
            try {
                //this is connection
                URL url = new URL(linkUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setConnectTimeout(5000);
                connection.connect();

                //this is result/response
                if (connection.getResponseCode() >= 400) {
                    System.out.println(linkUrl + "-" + connection.getResponseMessage() + " is a brokenLink");
                } else {
                    System.out.println(linkUrl + "-" + connection.getResponseMessage());
                }
            }catch (Exception ex){
                System.out.println(linkUrl + "-" + ex.getMessage() + " is a brokenLink");
            }

    }
}
