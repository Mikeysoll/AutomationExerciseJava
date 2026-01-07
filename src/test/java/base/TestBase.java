package base;

import com.codeborne.selenide.logevents.SelenideLogger;
import data.TestData;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;
import pages.components.Header;

import java.time.Duration;
import java.util.Map;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;

public class TestBase {

    protected TestData testData;

    @BeforeAll
    static void configureBrowser() {
        baseUrl = "https://automationexercise.com";
        pageLoadStrategy = "eager";
        browser = System.getProperty("browser", "chrome");
        browserVersion = System.getProperty("browserVersion", "128.0");
        browserSize = System.getProperty("browserSize", "1920x1080");
        /*remote = System.getProperty("remote",
                "https://user1:1234@selenoid.autotests.cloud/wd/hub");*/

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));
        browserCapabilities = capabilities;


    }

    @BeforeEach
    public void setUp() {
        testData = new TestData();
        open("/");
        try {
            $(".fc-cta-consent").should(appear, Duration.ofSeconds(10)).click();
        } catch (Throwable ignored) {}
        $(".logo").shouldBe(visible);

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource("Page Source");
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();

    }
}