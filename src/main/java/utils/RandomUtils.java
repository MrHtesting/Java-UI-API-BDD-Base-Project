package utils;

import com.github.javafaker.Faker;

public class RandomUtils {
    private static final Faker faker = new Faker();

    public static String generateString(int length, String type) {
        if (type.equals("char")) {
            return generateString(length);
        } else if (type.equals("num")) {
            return generateNumber(length);
        }
        return "";
    }

    public static String generateString(int length) {
        return faker.lorem().fixedString(length);
    }

    public static String generateNumber(int length) {
        return faker.number().digits(length);
    }

    public static String generateEmail() {
        String name = faker.name().firstName();
        String number = faker.number().digits(3);
        return name + number + "@axa.com";
    }

    public static String generatePassword(int length) {
        return faker.internet().password(length, length + 4);
    }

    public static String generateDateOfBirth() {
        return faker.backToTheFuture().date();
    }

    public static int randBetween(int start, int end) {
        return faker.random().nextInt(start, end);
    }

}
