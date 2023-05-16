package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationCheckModal {
    public void verifyModalFields(){
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

    }
    public void verifyMultipleResult(String key, String value){
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }
}
