package org.qa.demoqa.tests.form;

import org.openqa.selenium.WebDriver;
import org.qa.demoqa.data.StudentData;
import org.qa.demoqa.pages.HomePage;
import org.qa.demoqa.pages.SidePanel;
import org.qa.demoqa.pages.form.PracticeFormPage;
import org.qa.demoqa.tests.TestBase;
import org.qa.demoqa.utils.DataProviders;
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
                //.enterDate(StudentData.DATE)  //первый вариант ввода даты
                .selectDate("May", "2001", "15")   // второй вариант ввода даты
                .selectSubjects(StudentData.SUBJECTS)
                .selectHobby(StudentData.HOBBIES)
                .uploadFile(StudentData.PHOTO_PATH)
                .enterAddress(StudentData.ADDRESS)
                .selectState(StudentData.STATE)
                .selectCity(StudentData.CITY)
                .clickOnSubmitButton2()
                .assertSubmit("Thanks for submitting the form");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "studentDataFromCSVFile")
    public void fillStudentFormUsingDataProviderTest(String name, String lastName,
                                                     String email, String phone,
                                                     String dateOfBirth, String path,
                                                     String address){
        //enter personal data (name, lastname, email, phone number)
        new PracticeFormPage(driver).enterPersonalData(name, lastName, email, phone)
                .selectGender(StudentData.GENDER)
                .enterDate(dateOfBirth)
                .selectSubjects(StudentData.SUBJECTS)
                .selectHobby(StudentData.HOBBIES)
                .uploadFile(path)
                .enterAddress(address)
                .selectState(StudentData.STATE)
                .selectCity(StudentData.CITY)
                .clickOnSubmitButton2()
                .assertSubmit("Thanks for submitting the form");
    }
}
