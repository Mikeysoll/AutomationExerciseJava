package base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;
import pages.components.Header;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.time.Duration.ofSeconds;

public class TestBase {

    protected LoginPage loginPage = new LoginPage();
    protected Header header = new Header();
    private static boolean cookiesAccepted = false;

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://automationexercise.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

    }

    @BeforeEach
    public void setUp() {
        open("/");
        if (!cookiesAccepted) {
            try {
                $(byText("Соглашаюсь"))
                        .should(appear, Duration.ofSeconds(3)).click();
                cookiesAccepted = true;
            }
            catch (Throwable ignored) {}
        }

        $(".logo").shouldBe(visible);
    }

}
