package data.userData;

import java.util.List;

import static utils.RandomUtils.getRandomList;

public class Hobbies {
    private int ind;
    private List<String> hobbies;

    public void setHobbies()
    {
        setQuantity();
        hobbies = getRandomList(List.of(new String[]{"Music", "Sports", "Reading"}), ind);
    }

    public List<String> getHobbies()
    {
        return hobbies;
    }

    private void setQuantity (){
        ind = (int) (Math.random()*3);
    }

}
