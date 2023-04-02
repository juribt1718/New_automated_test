import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestBoxMyTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        System.setProperty("chromeoptions.args", "--remote-allow-origins=*");
    }

    @Test
    void fillFormTest() {
        String userName = "Yuri";
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
//Обращение к локаторам
        $("#firstName").setValue("Yuri");
        $("#lastName").setValue("Bilov");
        $("#userEmail").setValue("jurib@mail.com");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("5678456666");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1974");
        $(".react-datepicker__day--004:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Biology").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/Nebo.jpg"));
        $("#currentAddress").setValue("SomeTown");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
//
        $("#submit").click();
//Проверка введённых данных
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Yuri Bilov"), text("jurib@mail.com"), text("Other")
                , text("5678456666"), text("04 September,1974"), text("Biology"), text("Reading")
                , text("Nebo.jpg"), text("SomeTown"));
//Закрываем окно
        $("#closeLargeModal").click();
    }

}
