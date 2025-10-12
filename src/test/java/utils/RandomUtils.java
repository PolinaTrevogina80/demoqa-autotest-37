package utils;

import com.github.javafaker.Faker;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.*;

public class RandomUtils {
    static Faker faker = new Faker(new Locale("en-GB"));

    public static String newFirstName() {
        return faker.name().firstName();
    }

    public static String newLastName(){
        return faker.name().lastName();
    }

    public static String newEmail(){
        return faker.internet().emailAddress();
    }

    public static String newAddress(){
        return faker.address().streetAddress();
    }

    public static String newPhone(){
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String newElementFromList(String[] list){
        return faker.options().nextElement(Arrays.asList(list));
    }

    public static Date newBirthDate(){
        return faker.date().birthday(0,100);
    }

    public static int getRandomInt(int before, int until){
        return faker.number().numberBetween(1,3);
    }

    public static String getRandomNumberString(int numbers){
        String digits = "0123456789";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers; i++)
            sb.append(digits.charAt(rnd.nextInt(digits.length())));

        return sb.toString();
    }

    public static String getRandomString(int numbers){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));

        return sb.toString();
    }

    public static String getRandomResourceFileName() throws IOException, URISyntaxException {
        String filename;

        Path resourceDirectory = Paths.get("src","test","resources");

        // Получить список всех файлов в папке
        List<Path> files = Files.list(resourceDirectory)
                .toList();

        if (files.isEmpty()) {
            throw new IOException("В папке ресурсов нет файлов.");
        }

        // Выбрать случайный файл
        Random random = new Random();
        Path randomFilePath = files.get(random.nextInt(files.size()));
        filename = String.valueOf(randomFilePath.getFileName());

        return filename;
    }
}
