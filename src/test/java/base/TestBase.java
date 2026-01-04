package base;

import data.TestData;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.AccountInfoPage;
import pages.HomePage;
import pages.ProductsPage;
import pages.SignupLoginPage;
import pages.components.Header;

import java.time.Duration;
import java.util.Map;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;


public class TestBase {

    protected ProductsPage productsPage = new ProductsPage();
    protected SignupLoginPage loginPage = new SignupLoginPage();
    protected HomePage homePage = new HomePage();
    protected AccountInfoPage accountInfoPage = new AccountInfoPage();
    protected Header header = new Header();
    protected TestData testData;

    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://automationexercise.com";
        holdBrowserOpen = true;
        pageLoadStrategy = "eager";
        browser = System.getProperty("browser", "chrome");
        browserVersion = System.getProperty("browserVersion", "128.0");
        browserSize = System.getProperty("browserSize", "1920x1080");
        /*remote = System.getProperty("remote",
                                 "https://user1:1234@selenoid.autotests.cloud/wd/hub");*/

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        browserCapabilities = capabilities;

        open("/");

        try {
            $(".fc-cta-consent")
                    .should(appear, Duration.ofSeconds(10)).click();
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
