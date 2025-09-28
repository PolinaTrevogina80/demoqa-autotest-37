package data.userData;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static utils.RandomUtils.getRandomFromList;
import static utils.RandomUtils.getRandomList;

public class StateCity {
    private String state;
    private String city;
    private Faker faker = new Faker(new Locale("en-GB"));;


    public void setRandomState(){
        List<String> states = Arrays.asList("NCR","Uttar Pradesh","Haryana","Rajasthan");

        this.state = faker.options().nextElement(states);;
    }

    public void setRandomCity(){
        List<String> city = List.of();

        switch (state) {
            case "NCR": {
                city = Arrays.asList("Delhi","Gurgaon","Noida");
                break;
            }
            case "Uttar Pradesh": {
                city = Arrays.asList("Agra","Lucknow","Merrut");
                break;
            }
            case "Haryana": {
                city = Arrays.asList("Karnal","Panipat");
                break;
            }
            case "Rajasthan": {
                city = Arrays.asList("Jaipur","Jaiselmer");
                break;
            }
        }

        this.city = getRandomFromList(city);
    }

    public String getState(){
        return this.state;
    }

    public String getCity(){
        return this.city;
    }
}
