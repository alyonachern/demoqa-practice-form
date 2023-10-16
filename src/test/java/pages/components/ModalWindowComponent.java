package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ModalWindowComponent {
    private SelenideElement modalWindow = $(".modal-body");
    private SelenideElement title = $("#example-modal-sizes-title-lg");
    private String titleText = "Thanks for submitting the form";
    private SelenideElement closeButton = $("#closeLargeModal");

    @Step("Проверить, что модальное окно отображается на странице")
    public void checkVisible() {
        modalWindow.should(visible);
    }

    @Step("Проверить, что модальное окно не отображается на странице")
    public void checkHidden() {
        modalWindow.should(hidden);
    }

    @Step("Сверить заголовок модального окна")
    public ModalWindowComponent checkTitle() {
        title.shouldHave(text(titleText));
        return this;
    }

    @Step("Сверить, что {key} соответствует {value}")
    public ModalWindowComponent checkResult(String key, String value) {
        checkVisible();
        modalWindow.shouldHave(text(key), text(value));
        return this;
    }

    @Step("Закрыть модальное окно")
    public ModalWindowComponent closeButton() {
        closeButton.click();
        return this;
    }
}
