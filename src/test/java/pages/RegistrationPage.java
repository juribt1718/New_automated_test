package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationCheckModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationCheckModal registrationCheckModal = new RegistrationCheckModal();

    private final String titleText = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmail = $("#userEmail"),
            userNumber = $("#userNumber"),
            getAddress = $("#currentAddress");


    public RegistrationPage openPage() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(titleText));
           return this;
    }
    public RegistrationPage closeAdvertisingBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setEmail(String value) {
        userEmail .setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }
    public RegistrationPage setNumber(String value) {
        userNumber.setValue(value);
        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
       calendarComponent.setDate(day,month, year);
        return this;
    }
    public RegistrationPage setSubject(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }
    public RegistrationPage setPicture(String value) {
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/" + value));
        return this;
    }
    public RegistrationPage setAddress(String value) {
        getAddress.setValue(value);
        return this;
    }
    public RegistrationPage setState(String value) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }
    public RegistrationPage setCity(String value) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }
    public RegistrationPage submitInformation() {
        $("#submit").click();
        return this;

    }
    public RegistrationPage verifyResults() {
        registrationCheckModal.verifyModalFields();
        return this;
    }
    public RegistrationPage verifyMultipleResults(String key, String value) {
        registrationCheckModal.verifyMultipleResult(key, value);
        return this;
    }
    public RegistrationPage closeWindow() {
        $("#closeLargeModal").click();
        return this;
    }
}
