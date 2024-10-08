package org.qa.demoqa.pages.form;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.qa.demoqa.pages.BasePage;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }



    @FindBy (id = "firstName")
    WebElement firstName;

    @FindBy (id = "lastName")
    WebElement lastName;

    @FindBy (id = "userEmail")
    WebElement userEmail;

    @FindBy (id = "userNumber")
    WebElement userNumber;
    public PracticeFormPage enterPersonalData(String name, String lName, String email, String number) {
        typeWithJSExecutor(firstName, name,0,600);
        typeWithJSExecutor(lastName, lName,0,600);
        typeWithJSExecutor(userEmail, email,0,600);
        typeWithJSExecutor(userNumber, number,0,600);
        return this;
    }

    @FindBy (css = "[for='gender-radio-1']")
    WebElement male;

    @FindBy (css = "[for='gender-radio-2']")
    WebElement female;

    @FindBy (css = "[for='gender-radio-3']")
    WebElement other;
    public PracticeFormPage selectGender(String gender) {
        if (gender.equals("Male")){
            click(male);
        } else if (gender.equals("Female")) {
            click(female);
        }else {
            click(other);
        }
        return this;
    }

    @FindBy (id = "dateOfBirthInput")
    WebElement dateOfBirthInput;
    public PracticeFormPage enterDate(String date) {
        click(dateOfBirthInput);

        String os = System.getProperty("os.name");///позволяет выбрать операционную систему (например Windows
        System.out.println(("My os is " + os));

        if (os.startsWith("Mac")){
            dateOfBirthInput.sendKeys(Keys.COMMAND, "a"); //т.е. нажимаем Command+A на Linux and Mac
        }else {
            dateOfBirthInput.sendKeys(Keys.CONTROL, "a"); //т.е. нажимаем Ctrl+A на Windows, т.к. нам надо выделить все поле
        }
        dateOfBirthInput.sendKeys(date);        //ввожу свою дату
        dateOfBirthInput.sendKeys(Keys.ENTER);  //нажимаю ENTER
        return this;
    }
    @FindBy (id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage selectSubjects(String[] subjects) {
        for (int i =0; i<subjects.length; i++ ){
            if (subjects[i] != null){
                typeWithJSExecutor(subjectsInput, subjects[i],0,600);
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }
    @FindBy(css = "[for='hobbies-checkbox-1']")
    WebElement sports;

    @FindBy(css = "[for='hobbies-checkbox-2']")
    WebElement reading;

    @FindBy(css = "[for='hobbies-checkbox-3']")
    WebElement music;

    public PracticeFormPage selectHobby(String[] hobbies) {
        for (int i =0; i<hobbies.length; i++ ) {
            if (hobbies[i].equals("Sports")) {
                click(sports);
            }
            if (hobbies[i].equals("Reading")) {
                click(reading);
            }
            if (hobbies[i].equals("Music")) {
                click(music);
            }
        }
            return this;
    }
}
