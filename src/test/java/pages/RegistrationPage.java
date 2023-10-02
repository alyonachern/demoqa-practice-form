package pages;

import com.codeborne.selenide.SelenideElement;
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

    public RegistrationPage openPage(String url) {
        open(url);
        removeBanners();
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        userEmailInput.setValue(email);
        return this;
    }

    public RegistrationPage setNumber(String number) {
        userNumberInput.setValue(number);
        return this;
    }

    public RegistrationPage setGender(String sex) {
        genderWrapper.$(byText(sex)).click();
        return this;
    }

    public RegistrationPage setDateOfBirth(String month, String year, String day) {
        dateOfBirthInput.click();
        calendar.setDate(month, year, day);
        return this;
    }

    public RegistrationPage setSubjects(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        hobbies.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadPhoto(String picture) {
        uploadPictureInput.uploadFromClasspath("foto.png");
        return this;
    }

    public RegistrationPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public RegistrationPage chooseState(String state) {
        stateInput.click();
        stateAndCity.$(byText(state)).click();
        return this;
    }

    public RegistrationPage chooseCity(String city) {
        cityInput.click();
        stateAndCity.$(byText(city)).click();
        return this;
    }

    public void submit() {
        submitButton.click();
    }
}
