package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests extends TestBase {

    @Test
    void mainTest() {
        String firstName = "Ivan";
        String lastName = "Ivanov";
        String userEmail = "ivan.ivanov@gmail.com";
        String gender = "Male";
        String userNumber = "0123456789";
        String subject = "Computer Science";
        String hobbyMusic = "Music";
        String hobbyReading = "Reading";
        String hobbySports = "Sports";
        String fileName = "testPicture.png";
        String currentAddress = "qwerty";
        String state = "Uttar Pradesh";
        String city = "Agra";

        practiceForm.openPage()
                .setFullName(firstName, lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setMobileNumber(userNumber)
                .setDayOfBirth("11", "December", "1994")
                .setSubject(subject)
                .setHobbies(hobbyMusic, hobbyReading, hobbySports)
                .uploadPicture(fileName)
                .setcurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .submit();


        $(".modal-body").shouldHave(text(firstName + " " + lastName),
                text(userEmail),
                text(gender),
                text(userNumber),
                text("11 December,1994"),
                text(subject),
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
