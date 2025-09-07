package data.userData;

import java.util.ArrayList;
import java.util.List;

public class StateCity {
    private String state;
    private String city;

    public void setRandomState(){
        List<String> state = new ArrayList<>();
        state.add("NCR");
        state.add("Uttar Pradesh");
        state.add("Haryana");
        state.add("Rajasthan");

        int ind= (int) (Math.random()*4);

        this.state = state.get(ind);
    }

    public void setRandomCity(){
        List<String> city = new ArrayList<>();

        switch (state) {
            case "NCR": {
                city.add("Delhi");
                city.add("Gurgaon");
                city.add("Noida");
                break;
            }
            case "Uttar Pradesh": {
                city.add("Agra");
                city.add("Lucknow");
                city.add("Merrut");
                break;
            }
            case "Haryana": {
                city.add("Karnal");
                city.add("Panipat");
                break;
            }
            case "Rajasthan": {
                city.add("Jaipur");
                city.add("Jaiselmer");
                break;
            }
        }

        int ind= (int) (Math.random()*city.size());

        this.city = city.get(ind);
    }

    public String getState(){
        return this.state;
    }

    public String getCity(){
        return this.city;
    }
}
