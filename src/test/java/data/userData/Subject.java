package data.userData;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static utils.RandomUtils.getRandomFromList;

public class Subject {
    private String subject;


    public void setRandomSubject(){
        Faker faker = new Faker(new Locale("en-GB"));;

        List<String> subject = Arrays.asList("English","Chemistry","Computer Science","Commerce",
                "Economics","Social Studies","Arts","History","Maths","Accounting","Physics",
                "Biology","Hindi","Civics");

        this.subject = faker.options().nextElement(subject);
    }

    public String getSubject(){
        return subject;
    }
}
