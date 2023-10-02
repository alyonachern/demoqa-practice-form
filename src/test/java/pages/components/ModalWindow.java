package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class ModalWindow {
    private SelenideElement modalWindow = $(".modal-body");
    private SelenideElement title = $("#example-modal-sizes-title-lg");
    private String titleText = "Thanks for submitting the form";

    public void checkVisible() {
        modalWindow.should(visible);
    }

    public void checkHidden() {
        modalWindow.should(hidden);
    }

    public ModalWindow checkTitle() {
        title.shouldHave(text(titleText));
        return this;
    }

    public ModalWindow checkResult(String string) {
        checkVisible();
        modalWindow.shouldHave(text(string));
        return this;
    }
}
