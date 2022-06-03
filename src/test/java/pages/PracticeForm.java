package pages;

import pages.components.CalendarComponents;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class PracticeForm {
    CalendarComponents calendarComponents = new CalendarComponents();

    public PracticeForm openPage() {
        open("automation-practice-form");
        executeJavaScript("$('#RightSide_Advertisement').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public PracticeForm setFullName(String firstName, String lastName) {
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);

        return this;
    }

    public PracticeForm setEmail(String email) {
        $("#userEmail").setValue(email);

        return this;
    }

    public PracticeForm setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();

        return this;
    }

    public PracticeForm setMobileNumber(String mobileNumber) {
        $("#userNumber").setValue(mobileNumber);

        return this;
    }

    public PracticeForm setDayOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponents.setDate(day, month, year);

        return this;
    }

    public PracticeForm setSubject(String subject) {
        $("#subjectsInput").sendKeys(subject);
        $("#subjectsInput").pressEnter();

        return this;
    }

    public PracticeForm setHobbies(String hobbyMusic, String hobbyReading, String hobbySports) {
        $("#hobbiesWrapper").$(byText(hobbyMusic)).click();
        $("#hobbiesWrapper").$(byText(hobbyReading)).click();
        $("#hobbiesWrapper").$(byText(hobbySports)).click();

        return this;
    }

    public PracticeForm setHobbies(String hobby1, String hobby2) {
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();

        return this;
    }

    public PracticeForm setHobbies(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();

        return this;
    }

    public PracticeForm uploadPicture(String fileName) {
        $("#uploadPicture").uploadFromClasspath(fileName);

        return this;
    }

    public PracticeForm setcurrentAddress(String address) {
        $("#currentAddress").setValue(address);

        return this;
    }

    public PracticeForm setStateAndCity(String state, String city) {
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();

        return this;
    }

    public void submit() {
        $("#submit").click();
    }
}
