package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizationFormTest extends TestBase {

    public static final String URL = "/automation-practice-form";
    String firstName = "Alyona";
    String lastName = "Chernyakova";
    String email = "test@test.com";
    String sex = "Female";
    String phoneNumber = "1234567890";
    String monthOfBirth = "June";
    String yearOfBirth = "1995";
    String expectedDate = "03 June,1995";
    String subject = "English";
    String hobby = "Reading";
    String currentAddress = "Indeed I live in Saint Petersburg";
    String state = "Rajasthan";
    String city = "Jaiselmer";

    @Test
    void fillFormTest() {

        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.openPage(URL);

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText(sex)).click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day--003").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath("foto.png");
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();

        $(".modal-body").shouldHave(text(firstName + " " + lastName));
        $(".modal-body").shouldHave(text(email));
        $(".modal-body").shouldHave(text(sex));
        $(".modal-body").shouldHave(text(phoneNumber));
        $(".modal-body").shouldHave(text(expectedDate));
        $(".modal-body").shouldHave(text(subject));
        $(".modal-body").shouldHave(text(hobby));
        $(".modal-body").shouldHave(text("foto.png"));
        $(".modal-body").shouldHave(text(currentAddress));
        $(".modal-body").shouldHave(text(state + " " + city));

    }

}
