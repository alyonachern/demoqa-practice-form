package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import pages.components.TextBoxOutputComponent;

public class TextBoxTest extends TestBase {

    private static final String URL = "/text-box";
    private String fullName = "Harry Potter",
            email = "email@mail.com",
            currentAddress = "All cities of the world",
            permanentAddress = "Saint Petersburg";

    TextBoxPage textBoxPage = new TextBoxPage();
    TextBoxOutputComponent output = new TextBoxOutputComponent();

    @Test
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
    public void fillSomeFieldsTest() {
        textBoxPage.openPage(URL)
                .setFullName(fullName)
                .submitForm();

        output.checkResult("Name", fullName);
    }

    @Test
    public void doNotFillFormTest() {
        textBoxPage.openPage(URL)
                .submitForm();

        output.checkHidden();
    }
}
