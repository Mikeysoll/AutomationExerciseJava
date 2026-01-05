package base;

import data.TestData;
import org.junit.jupiter.api.AfterAll;
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
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;

public class TestBase {
    protected ProductsPage productsPage = new ProductsPage();
    protected SignupLoginPage loginPage = new SignupLoginPage();
    protected HomePage homePage = new HomePage();
    protected AccountInfoPage accountInfoPage = new AccountInfoPage();
    protected ContactPage contactPage = new ContactPage();
    protected Header header = new Header();
    protected TestData testData;

    @BeforeAll
    static void configureBrowser() {
        Configuration.baseUrl = "https://automationexercise.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "128.0");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.remote = System.getProperty("remote",
                "https://user1:1234@selenoid.autotests.cloud/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    public void setUp() {
        testData = new TestData();
        open("/");
        try {
            $(".fc-cta-consent").should(appear, Duration.ofSeconds(10)).click();
        } catch (Throwable ignored) {}
        $(".logo").shouldBe(visible);
    }

    @AfterEach
    void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource("Page Source");
        Attach.browserConsoleLogs();
    }

    @AfterAll
    static void closeBrowser() {
        Attach.addVideo();
        closeWebDriver();
    }
}