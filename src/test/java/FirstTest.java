import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class FirstTest {
    @BeforeAll
    static void configTest()
    {
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void openTest() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=app]").shouldHave(text("Practice Form"));
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");

        //User Data
        $("[id=firstName").setValue("Polly");
        $("[id=lastName").setValue("Lolly");
        $("[id=userEmail").setValue("Polly@Lolly.ts");
        $("[for=gender-radio-2").click();
        $("[id=userNumber").setValue("1234567890");

        //Calendar
        $("[id=dateOfBirthInput").click();
        $("[class=react-datepicker__year-select]").selectOptionByValue("2000");
        $("[class=react-datepicker__month-select]").selectOption("January");
        $("[class=react-datepicker__month-container]").findElement(byText("1")).click();

        //Hobbies
        $("[id=subjectsInput").setValue("Math");
        $("[id=subjectsInput").pressTab();
        $("[for=hobbies-checkbox-1").click();
        $("[for=hobbies-checkbox-2").click();
        $("[for=hobbies-checkbox-3").click();

        //File
        SelenideElement fileInput = $("input[type='file']");
        File file = new File("src/test/resources/ava.jpg");
        fileInput.uploadFile(file);


        //Address
        $("[id=currentAddress").setValue("Neverland, St.Peters st, 1");
        $("[id=react-select-3-input").setValue("NCR");
        $("[id=react-select-3-input").pressTab();
        $("[id=react-select-4-input").setValue("Delhi");
        $("[id=react-select-4-input").pressTab();
        $("[id=submit]").pressEnter();

        //Validations
        $("[id=example-modal-sizes-title-lg]").shouldHave(text("Thanks for submitting the form"));
        $("[class=table-responsive]").shouldHave(text("Polly Lolly"));
        $("[class=table-responsive]").shouldHave(text("Polly@Lolly.ts"));
        $("[class=table-responsive]").shouldHave(text("Female"));
        $("[class=table-responsive]").shouldHave(text("1234567890"));
        $("[class=table-responsive]").shouldHave(text("01 January,2000"));
        $("[class=table-responsive]").shouldHave(text("Math"));
        $("[class=table-responsive]").shouldHave(text("ava.jpg"));
        $("[class=table-responsive]").shouldHave(text("Sports, Reading, Music"));
        $("[class=table-responsive]").shouldHave(text("Neverland, St.Peters st, 1"));
        $("[class=table-responsive]").shouldHave(text("NCR Delhi"));
    }
}