package org.qa.demoqa.tests.bookStore;

import org.qa.demoqa.pages.bookStore.BookStorePage;
import org.qa.demoqa.pages.HomePage;
import org.qa.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchBookTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getBookStore();
    }

    @Test
    public void searchBookTest(){
        new BookStorePage(driver).enterBookName("Git")
                .verifyBookName("Git");
    }
}
