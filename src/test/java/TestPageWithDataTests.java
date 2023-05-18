import org.junit.jupiter.api.Test;
import tests.TestData.*;

import static tests.TestData.*;


public class TestPageWithDataTests extends TestBase {
    @Test
    void fillFormTest() {
        //Обращение к локаторам
        registrationPage.openPage()
                .closeAdvertisingBanners()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender("Other")
                .setNumber("5678456666")
                .setBirthDate("04","September","1974")
                .setSubject("Biology")
                .setHobbies("Reading")
                .setPicture("Nebo.jpg")
                .setAddress("SomeTown")
                .setState("NCR")
                .setCity("Delhi")
                .submitInformation();

        //Проверка введённых данных
        registrationPage.verifyResults();
        registrationPage.verifyMultipleResults("Student Name", "Yuri Bilov")
                .verifyMultipleResults("Student Email", "jurib@mail.com")
                .verifyMultipleResults("Gender", "Other")
                .verifyMultipleResults("Mobile", "5678456666")
                .verifyMultipleResults("Date of Birth","04 September,1974")
                .verifyMultipleResults("Subjects","Biology")
                .verifyMultipleResults("Hobbies","Reading")
                .verifyMultipleResults("Picture","Nebo.jpg")
                .verifyMultipleResults("Address","SomeTown")
                .verifyMultipleResults("State and City","NCR Delhi");

        registrationPage.closeWindow();
    }

}
