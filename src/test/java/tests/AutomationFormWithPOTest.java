package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ResultComponent;

import java.util.List;

public class AutomationFormWithPOTest extends TestBase {
    private final String firstName="Polly",
            lastName="Lolly",
            email="polly@test.ts",
            gender="Female",
            phoneNumber="1234567890",
            fileName="ava.jpg",
            day="1",
            month="December",
            year="2000",
            subject="Math",
            address="Neverland, St.Peters st, 1",
            state="NCR",
            city="Delhi";

    private final List<String>hobbies= List.of(new String[]{"Music", "Sports", "Reading"});
    RegistrationPage registration = new RegistrationPage();
    ResultComponent result = new ResultComponent();

    @Test
    public void formOpenTest(){
        registration.openPage();
    }

    @Test
    void fillFormFullTest() {

        registration.openPage()
                .removeAdds()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setPhoneNumber(phoneNumber)
                .setGender(gender)
                .setDate(day,month,year)
                .setFile(fileName)
                .setSubject(subject)
                .setHobbies(hobbies)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit();

        result.checkFormAppears()
                .checkName(firstName,lastName)
                .checkEmail(email)
                .checkGender(gender)
                .checkNumber(phoneNumber)
                .checkDate(day,month,year)
                .checkSubject(subject)
                .checkHobbies(hobbies)
                .checkFileName(fileName)
                .checkAddress(address)
                .checkStateAndCity(state,city);
    }

    @Test
    void fillFormMinimumTest() {

        registration.openPage()
                .removeAdds()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber(phoneNumber)
                .setGender(gender)
                .submit();

        result.checkFormAppears()
                .checkName(firstName, lastName)
                .checkGender(gender)
                .checkNumber(phoneNumber);
    }

    @Test
    void negativeTest() {

        registration.openPage()
                .removeAdds()
                .submit();

        result.checkFormNotAppears();
    }
}
