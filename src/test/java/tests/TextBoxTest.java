package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import pages.components.TextBoxOutputComponent;
import utils.RandomDataUtils;

@Feature("Заполнение текстовой формы")
@Tag("text_box")
public class TextBoxTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();
    TextBoxOutputComponent output = new TextBoxOutputComponent();
    RandomDataUtils ru = new RandomDataUtils();

    private static final String URL = "/text-box";
    private String fullName = ru.getRandomString(10),
            email = ru.getRandomString(7) + "@gmail.org",
            currentAddress = ru.getRandomString(25),
            permanentAddress = ru.getRandomString(10);

    @Test
    @DisplayName("Заполнение всех полей на форме")
    public void fillAllFieldsTest() {
        textBoxPage.openPage(URL)
                .setFullName(fullName)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submitForm();

        output.checkResult("Name", fullName)
                .checkResult("Email", email)
                .checkResult("Current Address", currentAddress)
                .checkResult("Permananet Address", permanentAddress);
    }

    @Test
    @DisplayName("Заполнение части полей на форме")
    public void fillSomeFieldsTest() {
        textBoxPage.openPage(URL)
                .setFullName(fullName)
                .submitForm();

        output.checkResult("Name", fullName);
    }

    @Test
    @DisplayName("Отправка формы без данных")
    public void doNotFillFormTest() {
        textBoxPage.openPage(URL)
                .submitForm();

        output.checkHidden();
    }
}
