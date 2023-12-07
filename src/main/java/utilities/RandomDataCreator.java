package utilities;

import com.github.javafaker.Faker;

import java.util.Random;

public class RandomDataCreator {
    protected static Faker faker = new Faker();

    final static String email = "himanshu.shukla1";

    public static String getRandomFullName() {
        //  Faker faker = new Faker();
        return faker.name().fullName();
    }

    public static String generateFirstName() {
        return faker.name().firstName();
    }

    public static String generateLastname() {
        return faker.name().lastName();
    }


    public static String generateEmail() {
        return email + "+" + faker.random().nextInt(2) + "@gmail.com";
    }


    public static String generateRandomPhoneNumber() {
        Random rand = new Random();

        // Generate the last 9 digits of the phone number
        StringBuilder phoneNumberBuilder = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            int digit = rand.nextInt(10);
            phoneNumberBuilder.append(digit);
        }
        return phoneNumberBuilder.toString();
    }

    public static double generateRandomLatitude() {
        Random random = new Random();
        // Generate a random latitude between -90 and 90 degrees
        return -90 + (random.nextDouble() * 180);
    }
    public static double generateRandomLongitude() {
        Random random = new Random();
        // Generate a random longitude between -180 and 180 degrees
        return -180 + (random.nextDouble() * 360);
    }
    public static int generateRandomInt(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("min must be less than or equal to max");
        }
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}

