package org.qa.demoqa.tests.bookStore;

import org.qa.demoqa.data.UserData;
import org.qa.demoqa.pages.HomePage;
import org.qa.demoqa.pages.SidePanel;
import org.qa.demoqa.pages.bookStore.BookStorePage;
import org.qa.demoqa.pages.bookStore.LoginPage;
import org.qa.demoqa.pages.bookStore.ProfilePage;
import org.qa.demoqa.tests.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddBookToCollectionTests extends TestBase {
    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getBookStore();
        new BookStorePage(driver).clickOnLoginButton();
        new LoginPage(driver).login(UserData.USER_NAME, UserData.USER_PASSWORD);
    }

    @Test
    public void addBookToCollectionTest(){
        new BookStorePage(driver).enterBookName(UserData.BOOK_NAME)
                .clickOnBookName()
                .addToCollection();
        new SidePanel(driver).selectProfile();
        new BookStorePage(driver).verifyBookName(UserData.BOOK_NAME);
    }
    @AfterMethod
    public void deleteBookFromCollection(){
        new ProfilePage(driver).deleteBook();
    }
}
