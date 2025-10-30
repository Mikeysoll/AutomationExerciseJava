package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.TestData;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.ProductsPage;
import pages.SignupLoginPage;
import pages.components.Header;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.time.Duration.ofSeconds;

public class TestBase {

    protected ProductsPage productsPage = new ProductsPage();
    protected SignupLoginPage loginPage = new SignupLoginPage();
    protected Header header = new Header();
    protected TestData testData;
    private static boolean cookiesAccepted = false;

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://automationexercise.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        testData = new TestData();
        open("/");
        if (!cookiesAccepted) {
            try {
                $(byText("Соглашаюсь"))
                        .should(appear, Duration.ofSeconds(3)).click();
                cookiesAccepted = true;
            } catch (Throwable ignored) {
            }
        }
        $(".logo").shouldBe(visible);
    }

}
