package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalWindowComponent;
import utils.RandomDataUtils;

@Feature("Заполнение авторизационной формы")
public class AuthorizationFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    ModalWindowComponent modal = new ModalWindowComponent();
    RandomDataUtils ru = new RandomDataUtils();

    private static final String URL = "/automation-practice-form";
    private String firstName = ru.randomFirstName(),
            lastName = ru.randomLastName(),
            email = ru.randomEmail(),
            sex = ru.randomGender(),
            phoneNumber = ru.randomPhone(),
            monthOfBirth = ru.randomDate()[0],
            yearOfBirth = ru.randomDate()[1],
            dayOfBirth = ru.randomDate()[2],
            picture = "foto.png",
            subject = ru.randomSubject(),
            hobby = ru.randomHobby(),
            currentAddress = ru.randomAddress(),
            state = ru.randomState(),
            city = ru.randomCity(state);


    @Test
    @DisplayName("Отправка формы со всеми заполненными полями")
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
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", sex)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", picture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    @DisplayName("Отправка формы только с обязательными полями")
    public void fillFormWithRequiredFieldsTest() {
        registrationPage.openPage(URL)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(sex)
                .setNumber(phoneNumber)
                .submit();

            modal.checkTitle()
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Gender", sex)
                    .checkResult("Mobile", phoneNumber);

    }

    @Test
    @DisplayName("Закрытие модального окна")
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
    @DisplayName("Отправка формы без данных")
    public void submitWithoutDataTest() {
        registrationPage.openPage(URL)
                .submit();

        modal.checkHidden();
    }

    @Test
    @DisplayName("Отправка формы с некорректными данными")
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
