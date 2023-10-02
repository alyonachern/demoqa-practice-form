package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxOutputComponent {

    private SelenideElement output = $("#output");

   public void checkVisible() {
       output.should(visible);
   }

   public void checkHidden() {
       output.should(hidden);
   }

    public TextBoxOutputComponent checkResult(String string) {
        checkVisible();
        output.shouldHave(text(string));
        return this;
    }
}
