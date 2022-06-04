package tests;

import org.junit.jupiter.api.Test;

public class PracticeFormTests extends TestBase {

    @Test
    void setFields() {
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

        String fullNameLine = "Student Name";
        String emailLine = "Student Email";
        String genderLine = "Gender";
        String mobileLine = "Mobile";
        String dateOfBirthLine = "Date of Birth";
        String subjectsLine = "Subjects";
        String hobbiesLine = "Hobbies";
        String pictureLine = "Picture";
        String addressLine = "Address";
        String stateAndCityLine = "State and City";

        practiceForm.openPage()
                .setFullName(firstName, lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setMobileNumber(userNumber)
                .setDayOfBirth("11", "December", "1994")
                .setSubject(subject)
                .setHobbies(hobbyMusic, hobbyReading, hobbySports)
                .uploadPicture(fileName)
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .submit();

        practiceForm.checkResult(fullNameLine, firstName + " " + lastName)
                .checkResult(emailLine, userEmail)
                .checkResult(genderLine, gender)
                .checkResult(mobileLine, userNumber)
                .checkResult(dateOfBirthLine, "11 December,1994")
                .checkResult(subjectsLine, subject)
                .checkResult(hobbiesLine, hobbyMusic + ", " + hobbyReading + ", " + hobbySports)
                .checkResult(pictureLine, fileName)
                .checkResult(addressLine, currentAddress)
                .checkResult(stateAndCityLine, state + " " + city);
    }
}
