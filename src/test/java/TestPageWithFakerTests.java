import org.junit.jupiter.api.Test;
import tests.FakerData;
import static utils.RandomUtils.*;

public class TestPageWithFakerTests extends TestBase {
    @Test
    void fillFormTest() throws InterruptedException {
    FakerData fakerData = new FakerData();

        //Инициализация переменных
        String userName = fakerData.getFakerUsername(),
                lastName = fakerData.getFakerLastName(),
                userEmail = fakerData.getFakerEmail(),
                userGender = randomGender(),
                userNumber = fakerData.getFakerNumber(),
                userDay = randomDay(),
                userMonth = randomMonth(),
                userYear = fakerData.getFakerYearOfBirth(),
                userSubject = randomSubjects(),
                userHobbies = randomHobbies(),
                userPicture = randomPictures(),
                userAddress = fakerData.getFakerAddress(),
                userState = randomState(),
                userCity = randomCity(userState);

        //Обращение к локаторам
        registrationPage.openPage()
                .closeAdvertisingBanners()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setNumber(userNumber)
                .setBirthDate(userDay,userMonth, userYear)
                .setSubject(userSubject)
                .setHobbies(userHobbies)
                .setPicture(userPicture)
                .setAddress(userAddress)
                .setState(userState)
                .setCity(userCity);

        registrationPage.submitInformation();

        //Проверка введённых данных
        registrationPage.verifyResults();
        registrationPage.verifyMultipleResults("Student Name", userName +" " + lastName)
                .verifyMultipleResults("Student Email", userEmail)
                .verifyMultipleResults("Gender", userGender)
                .verifyMultipleResults("Mobile", userNumber)
                .verifyMultipleResults("Date of Birth",userDay +" "+userMonth+"," + userYear)
                .verifyMultipleResults("Subjects",userSubject)
                .verifyMultipleResults("Hobbies",userHobbies)
                .verifyMultipleResults("Picture",userPicture)
                .verifyMultipleResults("Address",userAddress)
                .verifyMultipleResults("State and City",userState+" "+ userCity);

        registrationPage.closeWindow();
    }

}
