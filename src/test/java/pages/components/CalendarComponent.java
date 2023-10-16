package pages.components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    @Step("Установить дату {day} {month} {year}")
    public void setDate(String month, String year, String day) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day).click();
    }
}
