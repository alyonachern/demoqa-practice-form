package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage extends BasePage {

    private SelenideElement fullNameInput = $("#userName"),
            emailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit");

    @Step("Открыть {url}")
    public TextBoxPage openPage(String url) {
        open(url);
        removeBanners();
        return this;
    }

    @Step("Установить Full Name {fullName}")
    public TextBoxPage setFullName(String fullName) {
        fullNameInput.setValue(fullName);
        return this;
    }

    @Step("Установить Email {email}")
    public TextBoxPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Установить Current Address {address}")
    public TextBoxPage setCurrentAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    @Step("Установить Permanent Address {address}")
    public TextBoxPage setPermanentAddress(String address) {
        permanentAddressInput.setValue(address);
        return this;
    }

    @Step("Нажать кнопку Submit")
    public void submitForm() {
        submitButton.click();
    }
}
