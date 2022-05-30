package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "2560x1440";

    }

    @Test
    void mainTest() {
        String firstName = "Ivan";
        String lastName = "Ivanov";
        String userEmail = "ivan.ivanov@gmail.com";
        String gender = "Male";
        String userNumber = "0123456789";
        String subjects = "Computer Science";
        String hobbyMusic = "Music";
        String hobbyReading = "Reading";
        String hobbySports = "Sports";
        String fileName = "testPicture.png";
        String currentAddress = "qwerty";
        String state = "Uttar Pradesh";
        String city = "Agra";

        open("automation-practice-form");
        executeJavaScript("$('#RightSide_Advertisement').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);

        $("#genterWrapper").$(byText(gender)).click();

        $("#userNumber").setValue(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1994");
        $(byText("11")).click();

        $("#subjectsInput").sendKeys(subjects);
        $("#subjectsInput").pressEnter();

        $("#hobbiesWrapper").$(byText(hobbyMusic)).click();
        $("#hobbiesWrapper").$(byText(hobbyReading)).click();
        $("#hobbiesWrapper").$(byText(hobbySports)).click();

        $("#uploadPicture").uploadFromClasspath(fileName);

        $("#currentAddress").setValue(currentAddress);

        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();

        $("#submit").click();


        $(".modal-body").shouldHave(text(firstName + " " + lastName),
                text(userEmail),
                text(gender),
                text(userNumber),
                text("11 December,1994"),
                text(subjects),
                text(hobbyMusic),
                text(hobbyReading),
                text(hobbySports),
                text(fileName),
                text(currentAddress),
                text(state + " " + city)
        );

        $("#closeLargeModal").click();
    }
}
