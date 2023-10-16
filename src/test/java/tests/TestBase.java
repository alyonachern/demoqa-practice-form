package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1980x1020";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        SelenideLogger.addListener("allure",new AllureSelenide());
    }
}
