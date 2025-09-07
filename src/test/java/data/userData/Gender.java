package data.userData;

import java.util.ArrayList;
import java.util.List;

import static utils.RandomUtils.getRandomFromList;

public class Gender {
    private String gender;

    public void setRandomGender(){
        List<String> gender = new ArrayList<>();
        gender.add("Male");
        gender.add("Female");
        gender.add("Other");

        this.gender = getRandomFromList(gender);
    }

    public String getGender(){
        return this.gender;
    }
}
