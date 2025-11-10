package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import data.TestData;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.ProductsPage;
import pages.SignupLoginPage;
import pages.components.Header;

import java.time.Duration;
import java.util.Map;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.time.Duration.ofSeconds;

public class TestBase {

    protected ProductsPage productsPage = new ProductsPage();
    protected SignupLoginPage loginPage = new SignupLoginPage();
    protected Header header = new Header();
    protected TestData testData;

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://automationexercise.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "128.0");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.remote= System.getProperty("remote",
                "https://user1:1234@selenoid.autotests.cloud/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        open("/");

        try {
            $(".fc-cta-consent")
                    .should(appear, Duration.ofSeconds(2)).click();
        } catch (Throwable ignored) {
        }

        $(".logo").shouldBe(visible);
    }

    @BeforeEach
    public void setUp() {
        testData = new TestData();
    }

    @AfterEach
    void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource("Page Source");
        Attach.browserConsoleLogs();
    }

    @AfterAll
    static void videoReport() {
        Attach.addVideo();
        closeWebDriver();
    }

}
