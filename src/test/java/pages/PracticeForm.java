package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponents;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class PracticeForm {
    SelenideElement firstNameInput = $("#firstName"), lastNameInput = $("#lastName"); 
    SelenideElement emailInput = $("#userEmail");
    SelenideElement genderElement = $("#genterWrapper");
    SelenideElement mobileNumberInput = $("#userNumber");
    SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    CalendarComponents calendarComponents = new CalendarComponents();
    SelenideElement subjectInput = $("#subjectsInput");
    SelenideElement hobbyElement = $("#hobbiesWrapper");
    SelenideElement pictureInput = $("#uploadPicture");
    SelenideElement addressInput = $("#currentAddress");
    SelenideElement stateElement = $("#state");
    SelenideElement cityElement = $("#city");
    SelenideElement submitElement = $("#submit");

    public PracticeForm openPage() {
        open("automation-practice-form");
        executeJavaScript("$('#RightSide_Advertisement').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public PracticeForm setFullName(String firstName, String lastName) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);

        return this;
    }

    public PracticeForm setEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    public PracticeForm setGender(String gender) {
        genderElement.$(byText(gender)).click();

        return this;
    }

    public PracticeForm setMobileNumber(String mobileNumber) {
        mobileNumberInput.setValue(mobileNumber);

        return this;
    }

    public PracticeForm setDayOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponents.setDate(day, month, year);

        return this;
    }

    public PracticeForm setSubject(String subject) {
        subjectInput.sendKeys(subject);
        subjectInput.pressEnter();

        return this;
    }

    public PracticeForm setHobbies(String hobbyMusic, String hobbyReading, String hobbySports) {
        hobbyElement.$(byText(hobbyMusic)).click();
        hobbyElement.$(byText(hobbyReading)).click();
        hobbyElement.$(byText(hobbySports)).click();

        return this;
    }

    public PracticeForm setHobbies(String hobby1, String hobby2) {
        hobbyElement.$(byText(hobby1)).click();
        hobbyElement.$(byText(hobby2)).click();

        return this;
    }

    public PracticeForm setHobbies(String hobby) {
        hobbyElement.$(byText(hobby)).click();

        return this;
    }

    public PracticeForm uploadPicture(String fileName) {
        pictureInput.uploadFromClasspath(fileName);

        return this;
    }

    public PracticeForm setCurrentAddress(String address) {
        addressInput.setValue(address);

        return this;
    }

    public PracticeForm setStateAndCity(String state, String city) {
        stateElement.click();
        $(byText(state)).click();
        cityElement.click();
        $(byText(city)).click();

        return this;
    }

    public void submit() {
        submitElement.click();
    }
}
