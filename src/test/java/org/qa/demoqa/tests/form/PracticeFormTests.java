package org.qa.demoqa.tests.form;

import org.openqa.selenium.WebDriver;
import org.qa.demoqa.data.StudentData;
import org.qa.demoqa.pages.HomePage;
import org.qa.demoqa.pages.SidePanel;
import org.qa.demoqa.pages.form.PracticeFormPage;
import org.qa.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm()
                .hideIframes();   //метод, скрывающий рекламу на сайте (костыль, по сути баг)
    }
    @Test
    public void fillStudentFormTest(){
        //enter personal data (name, lastname, email, phone number)
        new PracticeFormPage(driver).enterPersonalData(StudentData.FIRST_NAME, StudentData.LAST_NAME,
                StudentData.EMAIL, StudentData.PHONE_NUMBER)
                .selectGender(StudentData.GENDER)
                .enterDate(StudentData.DATE)
                .selectSubjects(StudentData.SUBJECTS)
                .selectHobby(StudentData.HOBBIES)
                .uploadFile(StudentData.PHOTO_PATH)
                .enterAddress(StudentData.ADDRESS)
                .selectState(StudentData.STATE)
                .selectCity(StudentData.CITY)
                .clickOnSubmitButton2();
    }
}
