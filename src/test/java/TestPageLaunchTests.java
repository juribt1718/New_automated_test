import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
public class TestPageLaunchTests extends TestBase {
    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName("Yuri")
                .setLastName("Bilov")
                .setEmail("jurib@mail.com")
                .setGender("Other")
                .setNumber("5678456666")
                .setBirthDate("04","September","1974")
                .setSubject("Biology")
                .setHobbies("Reading");
//Обращение к локаторам
 sleep(60000);






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
