package tests;

import data.*;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultComponent;

import java.io.IOException;
import java.net.URISyntaxException;

public class AutomationFormWithRandomDataTest extends TestBase {
    RegistrationPage registration = new RegistrationPage();
    ResultComponent result = new ResultComponent();

    @Test
    public void formOpenTest(){
        registration.openPage();
    }

    @Test
    void fillFormFullTest() throws IOException, URISyntaxException {
    User user = new User();
    user.createUser();

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

    @Test
    void fillFormMinimumTest() throws IOException, URISyntaxException {
        User user = new User();
        user.createUser();

        registration.openPage()
                .removeAdds()
                .setFirstName(user.firstName)
                .setLastName(user.lastName)
                .setPhoneNumber(user.phoneNumber)
                .setGender(user.gender)
                .submit();

        result.checkFormAppears()
                .checkName(user.firstName, user.lastName)
                .checkGender(user.gender)
                .checkNumber(user.phoneNumber);
    }

    @Test
    void negativeTest() {

        registration.openPage()
                .removeAdds()
                .submit();

        result.checkFormNotAppears();
    }
}
