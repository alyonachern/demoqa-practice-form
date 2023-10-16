package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxOutputComponent {

    private SelenideElement output = $("#output");

    @Step("Проверить, что вывод после самбита не пустой")
   public void checkVisible() {
       output.shouldNotBe(empty);
   }

    @Step("Проверить, что вывод после самбита пустой")
   public void checkHidden() {
       output.shouldBe(empty);
   }

    @Step("Сверить, что {key} соответствует {value}")
    public TextBoxOutputComponent checkResult(String key, String value) {
        checkVisible();
        output.shouldHave(text(key), text(value));
        return this;
    }
}
