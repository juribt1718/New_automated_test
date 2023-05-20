package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerData {
    Faker fakerInfa = new Faker(new Locale("en-UG"));

    public String getFakerUsername() {
        return fakerInfa.name().firstName();
    }

    public String getFakerLastName() {
        return fakerInfa.name().lastName();
    }

    public String getFakerEmail() {
        return fakerInfa.internet().emailAddress();
    }

    public String getFakerNumber() {
        return String.valueOf(fakerInfa.number().numberBetween(1000000000, 2000000000));
    }

    public String getFakerYearOfBirth() {
        return Integer.toString(fakerInfa.number().numberBetween(1950, 2000));
    }

    public String getFakerAddress() {
        return fakerInfa.address().fullAddress();
    }


}
