import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {

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


        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

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
