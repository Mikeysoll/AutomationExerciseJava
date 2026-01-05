package base;

import data.TestData;
import org.junit.jupiter.api.AfterEach;
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

    protected ProductsPage productsPage = new ProductsPage();
    protected SignupLoginPage loginPage = new SignupLoginPage();
    protected HomePage homePage = new HomePage();
    protected AccountInfoPage accountInfoPage = new AccountInfoPage();
    protected ContactPage contactPage = new ContactPage();
    protected Header header = new Header();
    protected TestData testData;

    @BeforeEach
    public void setUp() {
        baseUrl = "https://automationexercise.com";
        pageLoadStrategy = "eager";
        browser = System.getProperty("browser", "chrome");
        browserVersion = System.getProperty("browserVersion", "128.0");
        browserSize = System.getProperty("browserSize", "1920x1080");
        //holdBrowserOpen = true;
        remote = System.getProperty("remote",
                "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        browserCapabilities = capabilities;

        open("/");

        try {
            $(".fc-cta-consent").should(appear, Duration.ofSeconds(10)).click();
        } catch (Throwable ignored) {}

        $(".logo").shouldBe(visible);

        testData = new TestData();
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource("Page Source");
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
