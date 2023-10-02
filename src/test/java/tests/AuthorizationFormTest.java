package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalWindowComponent;

public class AuthorizationFormTest extends TestBase {

    private static final String URL = "/automation-practice-form";
    private String firstName = "Alyona",
            lastName = "Chernyakova",
            email = "test@test.com",
            sex = "Female",
            phoneNumber = "1234567890",
            monthOfBirth = "June",
            yearOfBirth = "1995",
            dayOfBirth = "03",
            picture = "foto.png",
            subject = "English",
            hobby = "Reading",
            currentAddress = "Indeed I live in Saint Petersburg",
            state = "Rajasthan",
            city = "Jaiselmer";

    RegistrationPage registrationPage = new RegistrationPage();
    ModalWindowComponent modal = new ModalWindowComponent();

    @Test
    void fillFormWithAllFieldsTest() {

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

    @Test
    public void fillFormWithRequiredFieldsTest() {
        registrationPage.openPage(URL)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(sex)
                .setNumber(phoneNumber)
                .submit();

            modal.checkTitle()
                    .checkResult(firstName + " " + lastName)
                    .checkResult(sex)
                    .checkResult(phoneNumber);

    }

    @Test
    public void closeModalWindowTest() {
        registrationPage.openPage(URL)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(sex)
                .setNumber(phoneNumber)
                .submit();

        modal.closeButton();
    }

    @Test
    public void submitWithoutDataTest() {
        registrationPage.openPage(URL)
                .submit();
    }

    @Test
    public void fillFormWithWrongDataTest() {

        lastName = "W";
        firstName = "U";
        phoneNumber = "Number";

        registrationPage.openPage(URL)
                .setLastName(lastName)
                .setFirstName(firstName)
                .setGender(sex)
                .setNumber(phoneNumber)
                .submit();

        modal.checkHidden();

    }
}
