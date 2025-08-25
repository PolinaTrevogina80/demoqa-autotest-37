import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class DragNDropTest {

    @BeforeAll
    static void setupEnvironment() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void dragNDropTest() {
        open("/drag_and_drop");

        //Проверка расположение квадратов ДО теста
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        //Драг-н-дроп
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));

        //Проверка расположение квадратов ПОСЛЕ теста
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
