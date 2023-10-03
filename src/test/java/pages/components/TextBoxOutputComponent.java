package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxOutputComponent {

    private SelenideElement output = $("#output");

   public void checkVisible() {
       output.shouldNotBe(empty);
   }

   public void checkHidden() {
       output.shouldBe(empty);
   }

    public TextBoxOutputComponent checkResult(String key, String value) {
        checkVisible();
        output.shouldHave(text(key), text(value));
        return this;
    }
}
