package data;

import com.github.javafaker.Faker;
import data.userData.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Locale;

import static utils.RandomUtils.getRandomNumberString;
import static utils.RandomUtils.getRandomResourceFileName;


public class User {
    public String firstName;
    public String lastName;
    public String email;
    public String streetAddress;
    public String phoneNumber;
    public String gender;
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
        phoneNumber = faker.phoneNumber().subscriberNumber(10);;
        gender = faker.options().nextElement(Gender.genders);
        birthDate.setRandomDate();
        subject.setRandomSubject();
        hobbies.setHobbies();
        stateCity.setRandomState();
        stateCity.setRandomCity();
        fileName = getRandomResourceFileName();
    }



}
