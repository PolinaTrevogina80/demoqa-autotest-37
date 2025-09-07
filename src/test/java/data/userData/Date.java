package data.userData;

import java.util.ArrayList;
import java.util.List;

public class Date {
    private String
            day,
            month,
            year;

    public String getDay(){
        return this.day;
    }

    public String getMonth(){
        return this.month;
    }

    public String getYear(){
        return this.year;
    }

    public void setRandomDate(){
        setRandomDay();
        setRandomMonth();
        setRandomYear();
    }

    private void setRandomDay(){
        this.day = String.valueOf((int) (Math.random()*30));
    }

    private void setRandomMonth(){
        List<String> months = new ArrayList<>();
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");

        int ind= (int) (Math.random()*months.size());

        this.month = months.get(ind);
    }

    private void setRandomYear(){
        this.year = String.valueOf((int) (Math.random()*75)+1950);
    }


}
