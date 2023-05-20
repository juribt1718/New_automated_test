import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;
import static utils.RandomUtils.*;




public class TestPageWithRandomUtilsTests extends TestBase {
    @Test
    void fillFormTest() throws InterruptedException {
        //Инициализация переменных
        String userName = getRandomString(10),
                lastName = getRandomString(10),
                userEmail = getRandomString(10) + "@mail.ru";

        //Обращение к локаторам
        registrationPage.openPage()
                .closeAdvertisingBanners()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender("Other")
                .setNumber("5678456666")
                .setBirthDate("04", "September", "1974")
                .setSubject("Biology")
                .setHobbies("Reading")
                .setPicture("Nebo.jpg")
                .setAddress("SomeTown")
                .setState("NCR")
                .setCity("Delhi");
        sleep(10000);
        registrationPage.submitInformation();

        //Проверка введённых данных
        registrationPage.verifyResults();
        registrationPage.verifyMultipleResults("Student Name", userName +" " + lastName)
                .verifyMultipleResults("Student Email", userEmail)
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
