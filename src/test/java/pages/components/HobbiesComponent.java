package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HobbiesComponent {
    private final SelenideElement hobby1Input = $("[for=hobbies-checkbox-1");
    private final SelenideElement hobby2Input = $("[for=hobbies-checkbox-2");
    private final SelenideElement hobby3Input = $("[for=hobbies-checkbox-3");

    public void setHobby(String hobby) {
        if (hobby.equals("Sports")){
            setHobby1();
        }
        if (hobby.equals("Reading")){
            setHobby2();
        }
        if (hobby.equals("Music")){
            setHobby3();
        }
    }

    public String getHobby(String hobby) {
        return switch (hobby) {
            case "Sports" -> getHobby1();
            case "Reading" -> getHobby2();
            case "Music" -> getHobby3();
            default -> "";
        };
    }

    private void setHobby1() {
        hobby1Input.click();
    }

    public void setHobby2() {
        hobby2Input.click();
    }

    public void setHobby3() {
        hobby3Input.click();
    }

    public String getHobby1(){
        return "Sports";
    }

    public String getHobby2(){
        return "Reading";
    }

    public String getHobby3(){
        return "Music";
    }
}
