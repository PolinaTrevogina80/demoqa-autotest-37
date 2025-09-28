package data.userData;

import java.util.*;

import com.github.javafaker.Faker;


public class Date {
    public static String
            day,
            month,
            year;

    private Faker faker = new Faker(new Locale("en-GB"));;

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
        java.util.Date date = faker.date().birthday(0,100);
        day = String.valueOf(date.getDay());
        year = String.valueOf(date.getYear()+1900);
        switch (date.getMonth()){
            case Calendar.JANUARY: month="January";break;
            case Calendar.FEBRUARY: month="February";break;
            case Calendar.MARCH: month="March";break;
            case Calendar.APRIL: month="April";break;
            case Calendar.MAY: month="May";break;
            case Calendar.JUNE: month="June";break;
            case Calendar.JULY: month="July";break;
            case Calendar.AUGUST: month="August";break;
            case Calendar.SEPTEMBER: month="September";break;
            case Calendar.OCTOBER: month="October";break;
            case Calendar.NOVEMBER: month="November";break;
            case Calendar.DECEMBER: month="December";break;
        }
    }


}
