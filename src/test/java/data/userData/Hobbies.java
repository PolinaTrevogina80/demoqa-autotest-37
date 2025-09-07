package data.userData;

import java.util.List;

public class Hobbies {
    private int ind;
    private List<String> hobbies;

    public void setHobbies()
    {
        setQuantity();
        hobbies = List.of(new String[]{"Music", "Sports", "Reading"}).subList(0, ind);
    }

    public List<String> getHobbies()
    {
        return hobbies;
    }

    private void setQuantity (){
        ind = (int) (Math.random()*3);
    }

}
