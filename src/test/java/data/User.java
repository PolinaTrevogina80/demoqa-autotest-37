package data;

import com.github.javafaker.Faker;
import data.userData.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.Random;


public class User {
    public String firstName;
    public String lastName;
    public String email;
    public String streetAddress;
    public String phoneNumber;
    public Gender gender = new Gender();
    public Date birthDate = new Date();
    public Hobbies hobbies = new Hobbies();
    public StateCity stateCity = new StateCity();
    public Subject subject = new Subject();
    public String fileName;

    public void createUser() throws IOException, URISyntaxException {
        Faker faker = new Faker(new Locale("en-GB"));

        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        email = faker.internet().emailAddress();
        streetAddress = faker.address().streetAddress();
        phoneNumber = faker.phoneNumber().phoneNumber().replaceAll(" ", "").substring(0, 10);
        gender.setRandomGender();
        birthDate.setRandomDate();
        subject.setRandomSubject();
        hobbies.setHobbies();
        gender.setRandomGender();
        birthDate.setRandomDate();
        hobbies.setHobbies();
        stateCity.setRandomState();
        stateCity.setRandomCity();
        subject.setRandomSubject();
        fileName = getRandomResourceFileName();
    }

    private static String getRandomResourceFileName() throws IOException, URISyntaxException {
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
