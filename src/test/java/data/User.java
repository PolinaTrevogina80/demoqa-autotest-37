package data;

import com.github.javafaker.Faker;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class User {
    public String firstName,
            lastName,
            email,
            streetAddress,
            phoneNumber,
            gender,
            subject,
            fileName,
            state,
            city,
            birthDay,
            birthMonth,
            birthYear;
    public java.util.Date birthDate;
    public List<String> hobbies;

    public void createUser() throws IOException, URISyntaxException {
        Faker faker = new Faker(new Locale("en-GB"));

        //личные данные
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        email = faker.internet().emailAddress();
        streetAddress = faker.address().streetAddress();
        phoneNumber = faker.phoneNumber().subscriberNumber(10);;
        gender = faker.options().nextElement(Arrays.asList("Male", "Female", "Other"));

        //дата
        birthDate = faker.date().birthday(0,100);
        birthDay = String.valueOf(birthDate.getDay());
        birthYear = String.valueOf(birthDate.getYear()+1900);
        switch (birthDate.getMonth()){
            case Calendar.JANUARY: birthMonth="January";break;
            case Calendar.FEBRUARY: birthMonth="February";break;
            case Calendar.MARCH: birthMonth="March";break;
            case Calendar.APRIL: birthMonth="April";break;
            case Calendar.MAY: birthMonth="May";break;
            case Calendar.JUNE: birthMonth="June";break;
            case Calendar.JULY: birthMonth="July";break;
            case Calendar.AUGUST: birthMonth="August";break;
            case Calendar.SEPTEMBER: birthMonth="September";break;
            case Calendar.OCTOBER: birthMonth="October";break;
            case Calendar.NOVEMBER: birthMonth="November";break;
            case Calendar.DECEMBER: birthMonth="December";break;
        }

        //увлечения
        subject = faker.options().nextElement(Arrays.asList("English","Chemistry","Computer Science","Commerce",
                "Economics","Social Studies","Arts","History","Maths","Accounting","Physics",
                "Biology","Hindi","Civics"));
        hobbies = (Arrays.asList("Music", "Sports", "Reading").subList(0, faker.number().numberBetween(1,3)));

        //штат+город
        state = faker.options().nextElement(Arrays.asList("NCR","Uttar Pradesh","Haryana","Rajasthan"));
        city = faker.options().nextElement(cities(state));

        //файл
        List<Path> files = getFiles();
        fileName = String.valueOf(files.get(faker.random().nextInt(files.size())).getFileName());
        ;
    }

    private List<String> cities(@NotNull String state){
        List<String> cities = List.of();

        switch (state) {
            case "NCR": {
                cities = Arrays.asList("Delhi","Gurgaon","Noida");
                break;
            }
            case "Uttar Pradesh": {
                cities = Arrays.asList("Agra","Lucknow","Merrut");
                break;
            }
            case "Haryana": {
                cities = Arrays.asList("Karnal","Panipat");
                break;
            }
            case "Rajasthan": {
                cities = Arrays.asList("Jaipur","Jaiselmer");
                break;
            }
        }

        return cities;
    }

    private @NotNull List<Path> getFiles() throws IOException {
        Path resourceDirectory = Paths.get("src","test","resources");
        List<Path> files = Files.list(resourceDirectory)
                .toList();
        if (files.isEmpty()) {
            throw new IOException("В папке ресурсов нет файлов.");
        }
        return files;
    }
}
