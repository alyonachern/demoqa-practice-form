package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalWindow;

public class AuthorizationFormTest extends TestBase {

    public static final String URL = "/automation-practice-form";
    String firstName = "Alyona";
    String lastName = "Chernyakova";
    String email = "test@test.com";
    String sex = "Female";
    String phoneNumber = "1234567890";
    String monthOfBirth = "June";
    String yearOfBirth = "1995";
    String dayOfBirth = "03";
    String picture = "foto.png";
    String subject = "English";
    String hobby = "Reading";
    String currentAddress = "Indeed I live in Saint Petersburg";
    String state = "Rajasthan";
    String city = "Jaiselmer";

    @Test
    void fillFormTestWithAllFields() {

        RegistrationPage registrationPage = new RegistrationPage();
        ModalWindow modal = new ModalWindow();

        registrationPage.openPage(URL)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(sex)
                .setNumber(phoneNumber)
                .setDateOfBirth(monthOfBirth, yearOfBirth, dayOfBirth)
                .setSubjects(subject)
                .setHobby(hobby)
                .uploadPhoto(picture)
                .setCurrentAddress(currentAddress)
                .chooseState(state)
                .chooseCity(city)
                .submit();


        modal.checkTitle()
                .checkResult(firstName + " " + lastName)
                .checkResult(email)
                .checkResult(sex)
                .checkResult(phoneNumber)
                .checkResult(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult(subject)
                .checkResult(hobby)
                .checkResult(picture)
                .checkResult(currentAddress)
                .checkResult((state + " " + city));
    }
}
