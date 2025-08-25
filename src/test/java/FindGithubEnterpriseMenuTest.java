import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class FindGithubEnterpriseMenuTest {

    @BeforeAll
    static void setupEnvironment() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout=5000;
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void findGithubEnterpriseMenuTest() {
        open("/");

        //Поиск раздела пункта меню Enterprise, и наведение мышки
        $("nav.HeaderMenu-nav").shouldHave(text("Enterprise"));
        $(byText("Enterprise")).hover();

        //Поиск раздела пункта меню с Enterprise, и переход на нужную страницу
        $(byText("Enterprise platform")).click();

        //ожидание загрузки анимации
        sleep(5000);

        //Поиск заголовка на странице
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));
    }


}
