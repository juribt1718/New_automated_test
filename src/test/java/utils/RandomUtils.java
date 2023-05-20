package utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    //Генерация рандомной строки
    public static String getRandomString(int length) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    //Генерация рандомного числа
    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    //Генерация рандомного числа
    public static String randomGender() {
        String[] genderInf = {"Male", "Female", "Other"};
        return genderInf[ThreadLocalRandom.current().nextInt(0, 3)];
    }

    public static String randomSubjects() {
        String[] subjectsInf = {"Biology", "Physics", "Chemistry"};
        return subjectsInf[ThreadLocalRandom.current().nextInt(0, 3)];
    }

    public static String randomHobbies() {
        String[] hobbiesInf = {"Sports", "Reading", "Music"};
        return hobbiesInf[ThreadLocalRandom.current().nextInt(0, 3)];
    }

    public static String randomPictures() {
        String[] picturesInf = {"flower.jpg", "Nebo.jpg", "rose.jpg"};
        return picturesInf[ThreadLocalRandom.current().nextInt(0, 3)];
    }

    public static String randomState() {
        String[] stateInf = {"NCR", "Uttar Pradesh", "Haryana"};
        return stateInf[ThreadLocalRandom.current().nextInt(0, 3)];
    }

    public static String randomCity(String valState) {
        String[] stateTemplate = {"NCR", "Uttar Pradesh", "Haryana"};
        int k = linearSearch(stateTemplate, valState);
        String[][] cityTemplate = {{"Delhi", "Gurgaon", "Noida"}
                , {"Agra", "Lucknow", "Merrut"}, {"Karnal", "Panipat", "Panipat"}};
        return cityTemplate[k][ThreadLocalRandom.current().nextInt(0, 3)];
    }

    public static int linearSearch(String[] array, String elementToSearch) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == elementToSearch) {
                return i;
            }
        }
        return 0;
    }

    public static String randomDay() {
        return Integer.toString(randomInt(10, 25));
    }

    public static String randomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return months[ThreadLocalRandom.current().nextInt(0, 12)];
    }

    public static void main(String[] args) {
        System.out.println("Show random value:" + RandomUtils.getRandomString(10) + "\n");
        System.out.println("Show random number:" + RandomUtils.randomInt(1, 1000));
        System.out.println("Show gender:" + randomGender());
        System.out.println("Get state's number:" + randomCity("Uttar Pradesh"));

    }

}
