import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static jdk.internal.misc.ThreadFlock.open;

public class FirstTest {
    @Test
    void openTest() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=app]").shouldHave(text("Student Registration Form"));
    }
}