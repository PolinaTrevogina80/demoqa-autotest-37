package data;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


import static utils.DateUtils.*;
import static utils.RandomUtils.*;


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
    public Date birthDate;
    public List<String> hobbies;

    public void createUser() throws IOException, URISyntaxException {
        //личные данные
        firstName = newFirstName();
        lastName = newLastName();
        email = newEmail();
        streetAddress = newAddress();
        phoneNumber = newPhone();
        gender = newElementFromList(new String[]{"Male", "Female", "Other"});

        //дата
        birthDate = newBirthDate();
        birthDay = String.valueOf(birthDate.getDay());
        birthYear = String.valueOf(birthDate.getYear()+1900);
        birthMonth = convertMonthToText(Integer.valueOf(birthDate.getMonth()));

        //увлечения
        subject = newElementFromList(new String[]{"English", "Chemistry", "Computer Science", "Commerce",
                "Economics", "Social Studies", "Arts", "History", "Maths", "Accounting", "Physics",
                "Biology", "Hindi", "Civics"});
        hobbies = (Arrays.stream(new String[]{"Music", "Sports", "Reading"}).toList()).subList(0, getRandomInt(0,3));

        //штат+город
        state = newElementFromList(new String[]{"NCR","Uttar Pradesh","Haryana","Rajasthan"});
        city = newElementFromList(cities(state));

        //файл
        fileName = getRandomResourceFileName();
        ;
    }

    private String[] cities(String state){
        String[] cities = new String[0];

        switch (state) {
            case "NCR": {
                cities = new String[]{"Delhi", "Gurgaon", "Noida"};
                break;
            }
            case "Uttar Pradesh": {
                cities = new String[]{"Agra","Lucknow","Merrut"};
                break;
            }
            case "Haryana": {
                cities = new String[]{"Karnal","Panipat"};
                break;
            }
            case "Rajasthan": {
                cities = new String[]{"Jaipur","Jaiselmer"};
                break;
            }
        }

        return cities;
    }

    private List<Path> getFiles() throws IOException {
        Path resourceDirectory = Paths.get("src","test","resources");
        List<Path> files = Files.list(resourceDirectory)
                .toList();
        if (files.isEmpty()) {
            throw new IOException("В папке ресурсов нет файлов.");
        }
        return files;
    }
}
