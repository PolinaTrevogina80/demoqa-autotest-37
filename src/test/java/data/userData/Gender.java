package data.userData;

import java.util.ArrayList;
import java.util.List;

public class Gender {
    private String gender;

    public void setRandomGender(){
        List<String> gender = new ArrayList<>();
        gender.add("Male");
        gender.add("Female");
        gender.add("Other");

        int ind= (int) (Math.random()*gender.size());

        this.gender = gender.get(ind);
    }

    public String getGender(){
        return this.gender;
    }
}
