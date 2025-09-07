package data.userData;

import java.util.ArrayList;
import java.util.List;

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

        int ind= (int) (Math.random()*subject.size());

        this.subject = subject.get(ind);
    }

    public String getSubject(){
        return subject;
    }
}
