package tests;

import org.junit.jupiter.api.Test;

import static tests.DataForTests.*;

public class PracticeFormTests extends TestBase {

    @Test
    void setFields() {


        practiceForm.openPage()
                .setFullName(FIRST_NAME, LAST_NAME)
                .setEmail(USER_EMAIL)
                .setGender(GENDER)
                .setMobileNumber(USER_NUMBER)
                .setDayOfBirth("11", "December", "1994")
                .setSubject(SUBJECTS)
                .setHobbies(HOBBY_MUSIC, HOBBY_READING, HOBBY_SPORTS)
                .uploadPicture(FILE_NAME)
                .setCurrentAddress(CURRENT_ADDRESS)
                .setStateAndCity(STATE, CITY)
                .submit();

        practiceForm.checkResult(FULL_NAME_LINE, FIRST_NAME + " " + LAST_NAME)
                .checkResult(EMAIL_LINE, USER_EMAIL)
                .checkResult(GENDER_LINE, GENDER)
                .checkResult(MOBILE_LINE, USER_NUMBER)
                .checkResult(DATE_OF_BIRTH_LINE, "11 December,1994")
                .checkResult(SUBJECTS_LINE, SUBJECTS)
                .checkResult(HOBBIES_LINE, HOBBY_MUSIC + ", " + HOBBY_READING + ", " + HOBBY_SPORTS)
                .checkResult(PICTURE_LINE, FILE_NAME)
                .checkResult(ADDRESS_LINE, CURRENT_ADDRESS)
                .checkResult(STATE_AND_CITY_LINE, STATE + " " + CITY);
    }
}
