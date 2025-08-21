import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubWikiTest {

    //Образец кода для поиска на странице
    private final String codeTestExample = """
            @Listeners({ SoftAsserts.class})
             public class Tests {
               @Test
               public void test() {
                 Configuration.assertionMode = SOFT;
                 open("page.html");
            
                 $("#first").should(visible).click();
                 $("#second").should(visible).click();
               }
             }""";

    @BeforeAll
    static void setupEnvironment() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void githubWikiNavigation() {
        open("/");

        //Поиск по слову selenide
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").setValue("selenide").pressEnter();

        //Поиск в левом меню раздела Wikis, и переход
        $("[id=':ra:--label']").click();
        $(byText("Wikis")).click();

        //Поиск раздела SoftAssertions, и переход в другую вкладку
        $("div.Box-sc-g0xbh4-0.hmwxFk").shouldHave(text("SoftAssertions"));
        $(byText("SoftAssertions")).click();
        Wait().until(driver -> driver.getWindowHandles().size() > 1);
        switchTo().window(1);

        //Поиск нужного раздела и примера кода
        $("div.markdown-body")
                .shouldHave(text("JUnit5 extension"));
        $("#repo-content-pjax-container").shouldHave(text(codeTestExample));
    }

}
