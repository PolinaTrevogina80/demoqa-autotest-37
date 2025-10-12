package tests;

import data.Subject;
import data.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.RegistrationPage;
import pages.components.ResultComponent;

import java.io.IOException;
import java.net.URISyntaxException;

public class AutomationFormParametrizedDataTest extends TestBase {
    RegistrationPage registration = new RegistrationPage();
    ResultComponent result = new ResultComponent();


    @ParameterizedTest
    @ValueSource(strings = {
            "Male", "Female", "Other"
    })
    @Tag("Web")
    @DisplayName("Проверяем, что можно установить пол {0} пользователя при регистрации")
    void checkingDifferentGenders(String gender) throws IOException, URISyntaxException {
    User user = new User();
    user.createUser();
    user.gender = gender;

        registration.openPage()
                .removeAdds()
                .setFirstName(user.firstName)
                .setLastName(user.lastName)
                .setUserEmail(user.email)
                .setPhoneNumber(user.phoneNumber)
                .setGender(user.gender)
                .setDate(user.birthDay, user.birthMonth, user.birthYear)
                .setFile(user.fileName)
                .setSubject(user.subject)
                .setHobbies(user.hobbies)
                .setAddress(user.streetAddress)
                .setState(user.state)
                .setCity(user.city)
                .submit();

        result.checkFormAppears()
                .checkName(user.firstName,user.lastName)
                .checkEmail(user.email)
                .checkGender(user.gender)
                .checkNumber(user.phoneNumber)
                .checkDate(user.birthDay, user.birthMonth, user.birthYear)
                .checkSubject(user.subject)
                .checkHobbies(user.hobbies)
                .checkFileName(user.fileName)
                .checkAddress(user.streetAddress)
                .checkStateAndCity(user.state,user.city);
    }

    @ParameterizedTest
    @EnumSource(Subject.class)
    @Tag("Web")
    @DisplayName("Проверяем, выбор предмета {0} для учебы")
    void checkingDifferentSubjects(Subject subject) throws IOException, URISyntaxException {
        User user = new User();
        user.createUser();
        user.subject = subject.subject;

        registration.openPage()
                .removeAdds()
                .setFirstName(user.firstName)
                .setLastName(user.lastName)
                .setUserEmail(user.email)
                .setPhoneNumber(user.phoneNumber)
                .setGender(user.gender)
                .setDate(user.birthDay, user.birthMonth, user.birthYear)
                .setFile(user.fileName)
                .setSubject(user.subject)
                .setHobbies(user.hobbies)
                .setAddress(user.streetAddress)
                .setState(user.state)
                .setCity(user.city)
                .submit();

        result.checkFormAppears()
                .checkName(user.firstName,user.lastName)
                .checkEmail(user.email)
                .checkGender(user.gender)
                .checkNumber(user.phoneNumber)
                .checkDate(user.birthDay, user.birthMonth, user.birthYear)
                .checkSubject(user.subject)
                .checkHobbies(user.hobbies)
                .checkFileName(user.fileName)
                .checkAddress(user.streetAddress)
                .checkStateAndCity(user.state,user.city);
    }


    @ParameterizedTest
    @CsvSource(value = {
            "NCR, Delhi",
            "Uttar Pradesh, Agra",
            "Haryana, Karnal",
            "Rajasthan, Jaipur"
    })    @Tag("Web")
    @DisplayName("Проверяем, можно выбрать штат {0} и один из город {}")
    void checkingDifferentStatesAndCities(String state, String city) throws IOException, URISyntaxException {
        User user = new User();
        user.createUser();
        user.state = state;
        user.city = city;

        registration.openPage()
                .removeAdds()
                .setFirstName(user.firstName)
                .setLastName(user.lastName)
                .setUserEmail(user.email)
                .setPhoneNumber(user.phoneNumber)
                .setGender(user.gender)
                .setDate(user.birthDay, user.birthMonth, user.birthYear)
                .setFile(user.fileName)
                .setSubject(user.subject)
                .setHobbies(user.hobbies)
                .setAddress(user.streetAddress)
                .setState(user.state)
                .setCity(user.city)
                .submit();

        result.checkFormAppears()
                .checkName(user.firstName,user.lastName)
                .checkEmail(user.email)
                .checkGender(user.gender)
                .checkNumber(user.phoneNumber)
                .checkDate(user.birthDay, user.birthMonth, user.birthYear)
                .checkSubject(user.subject)
                .checkHobbies(user.hobbies)
                .checkFileName(user.fileName)
                .checkAddress(user.streetAddress)
                .checkStateAndCity(user.state,user.city);
    }
}
