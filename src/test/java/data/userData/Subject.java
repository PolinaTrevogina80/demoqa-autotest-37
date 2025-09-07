package data.userData;

import java.util.ArrayList;
import java.util.List;

import static utils.RandomUtils.getRandomFromList;

public class Subject {
    private String subject;

    public void setRandomSubject(){
        List<String> subject = new ArrayList<>();
        subject.add("English");
        subject.add("Chemistry");
        subject.add("Computer Science");
        subject.add("Commerce");
        subject.add("Economics");
        subject.add("Social Studies");
        subject.add("Arts");
        subject.add("History");
        subject.add("Maths");
        subject.add("Accounting");
        subject.add("Physics");
        subject.add("Biology");
        subject.add("Hindi");
        subject.add("Civics");

        this.subject = getRandomFromList(subject);
    }

    public String getSubject(){
        return subject;
    }
}
