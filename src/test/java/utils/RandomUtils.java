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

    public static String newElementFromList(String... list){
        return faker.options().option(list);
    }

    public static Date newBirthDate(){
        return faker.date().birthday(0,100);
    }

    public static int getRandomInt(int before, int until){
        return faker.number().numberBetween(before,until);
    }

}
