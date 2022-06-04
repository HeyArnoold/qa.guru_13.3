package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponents;
import pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class PracticeForm {
    private SelenideElement firstNameInput = $("#firstName"), lastNameInput = $("#lastName");
    private SelenideElement emailInput = $("#userEmail");
    private SelenideElement genderElement = $("#genterWrapper");
    private SelenideElement mobileNumberInput = $("#userNumber");
    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private CalendarComponents calendarComponents = new CalendarComponents();
    private SelenideElement subjectInput = $("#subjectsInput");
    private SelenideElement hobbyElement = $("#hobbiesWrapper");
    private SelenideElement pictureInput = $("#uploadPicture");
    private SelenideElement addressInput = $("#currentAddress");
    private SelenideElement stateElement = $("#state");
    private SelenideElement cityElement = $("#city");
    private SelenideElement submitElement = $("#submit");
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

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

    public PracticeForm submit() {
        submitElement.click();

        return this;
    }

    public PracticeForm checkResult(String key, String value) {
        resultsTableComponent.checkResult(key, value);

        return this;
    }
}
