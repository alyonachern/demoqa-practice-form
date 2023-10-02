package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ModalWindowComponent {
    private SelenideElement modalWindow = $(".modal-body");
    private SelenideElement title = $("#example-modal-sizes-title-lg");
    private String titleText = "Thanks for submitting the form";
    private SelenideElement closeButton = $("#closeLargeModal");

    public void checkVisible() {
        modalWindow.should(visible);
    }

    public void checkHidden() {
        modalWindow.should(hidden);
    }

    public ModalWindowComponent checkTitle() {
        title.shouldHave(text(titleText));
        return this;
    }

    public ModalWindowComponent checkResult(String string) {
        checkVisible();
        modalWindow.shouldHave(text(string));
        return this;
    }

    public ModalWindowComponent closeButton() {
        closeButton.click();
        return this;
    }
}
