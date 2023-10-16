package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.BasePage;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage extends BasePage {

    CalendarComponent calendar = new CalendarComponent();
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbies = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            stateAndCity = $("#stateCity-wrapper"),
            submitButton = $("#submit");

    @Step("Открыть {url}")
    public RegistrationPage openPage(String url) {
        open(url);
        removeBanners();
        return this;
    }

    @Step("Установить First Name {firstName}")
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    @Step("Установить Last Name {lastName}")
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Установить email {email}")
    public RegistrationPage setEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    @Step("Установить Number {number}")
    public RegistrationPage setNumber(String number) {
        userNumberInput.setValue(number);
        return this;
    }

    @Step("Установить пол {sex}")
    public RegistrationPage setGender(String sex) {
        genderWrapper.$(byText(sex)).click();
        return this;
    }

    @Step("Установить дату рождения {day} {month} {year}")
    public RegistrationPage setDateOfBirth(String month, String year, String day) {
        dateOfBirthInput.click();
        calendar.setDate(month, year, day);
        return this;
    }

    @Step("Добавить Subject {subject}")
    public RegistrationPage setSubjects(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    @Step("Добавить Hobby {hobby}")
    public RegistrationPage setHobby(String hobby) {
        hobbies.$(byText(hobby)).click();
        return this;
    }

    @Step("Загрузить картинку")
    public RegistrationPage uploadPhoto(String picture) {
        uploadPictureInput.uploadFromClasspath("foto.png");
        return this;
    }

    @Step("Установить Current Address {currentAddress}")
    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    @Step("Установить State {state}")
    public RegistrationPage chooseState(String state) {
        stateInput.click();
        stateAndCity.$(byText(state)).click();
        return this;
    }

    @Step("Установить City {city}")
    public RegistrationPage chooseCity(String city) {
        cityInput.click();
        stateAndCity.$(byText(city)).click();
        return this;
    }

    @Step("Нажать кнопку Submit")
    public void submit() {
        submitButton.click();
    }
}
