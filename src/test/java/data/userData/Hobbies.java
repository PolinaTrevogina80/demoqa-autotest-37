package data.userData;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static utils.RandomUtils.getRandomList;

public class Hobbies {
    private int ind;
    private List<String> hobbies;
    private Faker faker = new Faker(new Locale("en-GB"));;


    public void setHobbies()
    {
       List<String> hobbies = Arrays.asList("Music", "Sports", "Reading");
        setQuantity();
        this.hobbies = getRandomList(hobbies, ind);
    }

    public List<String> getHobbies()
    {
        return hobbies;
    }

    private void setQuantity (){
        ind = faker.number().numberBetween(1,3);
    }

}
